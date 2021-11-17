package hh.swd04.GameFinderProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
	
	List<Game> findByTitle(String title);
	


}
