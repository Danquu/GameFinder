package hh.swd04.GameFinderProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
	        .and()
	        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
	        .and()
	        .csrf().ignoringAntMatchers("/h2-console/**")
	        .and()
	        .headers().frameOptions().sameOrigin()
	        .and()
	        .authorizeRequests().antMatchers("/login").authenticated()
	        .and()
	      .formLogin()
	          .defaultSuccessUrl("/gamelist")
	          .permitAll()
	          .and()
	      .logout()
	      .logoutSuccessUrl("/gamelist")
	          .permitAll();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }
	}

