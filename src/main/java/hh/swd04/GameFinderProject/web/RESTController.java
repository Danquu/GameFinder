package hh.swd04.GameFinderProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd04.GameFinderProject.domain.Game;
import hh.swd04.GameFinderProject.domain.GameRepository;


@Controller
public class RESTController {
	
	@Autowired
	private GameRepository repository;
	
	//RESTillä pelien listaus
		@RequestMapping(value="/games", method = RequestMethod.GET)
		public @ResponseBody List<Game> gameListRest() {
			return (List<Game>) repository.findAll();
		}
		
		//RESTillä pelien haku ID:n avulla
		@RequestMapping(value="/games/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long id) {
			return repository.findById(id);
		}
		
		//RESTillä pelien tallentaminen
		@RequestMapping(value="/games", method = RequestMethod.POST)
		public @ResponseBody Game saveGameRest(@RequestBody Game game) {
			return repository.save(game);
		}
		
		

}
