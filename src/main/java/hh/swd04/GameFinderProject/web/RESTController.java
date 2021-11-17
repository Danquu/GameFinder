package hh.swd04.GameFinderProject.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd04.GameFinderProject.domain.Game;
import hh.swd04.GameFinderProject.domain.GameRepository;
import hh.swd04.GameFinderProject.domain.Genre;
import hh.swd04.GameFinderProject.domain.GenreRepository;


@Controller
public class RESTController {
	
	@Autowired
	private GameRepository repository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	
	
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
		
	
		
		//RESTillä pelien lisäys
		@RequestMapping(value="/games", method = RequestMethod.POST)
		ResponseEntity<String> addGameRest(@Valid @RequestBody Game game) {
			
			if(game.getTitle() == null) {
				return new ResponseEntity<String>("Invalid request", HttpStatus.NOT_FOUND);
			}
			
			repository.save(game);
			return new ResponseEntity<String>("Game saved", HttpStatus.OK);
		}
		
		//RESTillä genrelistaus
		@RequestMapping(value="genres", method = RequestMethod.GET)
		public @ResponseBody List<Genre> genreListRest() {
			return (List<Genre>) genrerepository.findAll();
		}
		
		//RESTillä genren haku ID:n avulla
				@RequestMapping(value="/genres/{id}", method = RequestMethod.GET)
				public @ResponseBody Optional<Genre> findGenreRest(@PathVariable("id") Long genreid) {
					return genrerepository.findById(genreid);
		}
				
		//RESTillä genren tallentaminen
		@RequestMapping(value="/genres", method = RequestMethod.POST)
		public @ResponseBody Genre saveGenreRest(@RequestBody Genre genre) {
					return genrerepository.save(genre);
		}


		
		
		
		

}
