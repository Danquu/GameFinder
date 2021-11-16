package hh.swd04.GameFinderProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd04.GameFinderProject.domain.User;
import hh.swd04.GameFinderProject.domain.UserRepository;


@Service
public class UserDetailService implements UserDetailsService {
	
private final UserRepository userrepository;
	
	@Autowired
	public UserDetailService(UserRepository userRepository) {
		this.userrepository = userRepository;
	}


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User currentuser = userrepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPassword(), 
        		AuthorityUtils.createAuthorityList(currentuser.getRole()));
        return user;
	}
	
}


