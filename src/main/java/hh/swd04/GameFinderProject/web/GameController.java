package hh.swd04.GameFinderProject.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd04.GameFinderProject.domain.Game;
import hh.swd04.GameFinderProject.domain.GameRepository;
import hh.swd04.GameFinderProject.domain.GenreRepository;

@Controller
public class GameController {
	
	@Autowired
	private GameRepository repository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index() {
		return "redirect:/gamelist";
	}
	
	@RequestMapping(value="/gamelist", method = RequestMethod.GET)
	public String listGame(Model model) {
		
		model.addAttribute("games", repository.findAll());
		return "gamelist";
	}
	
	@RequestMapping(value="/addgame")
	public String addGame(Model model) {
		
		model.addAttribute("game", new Game());
		model.addAttribute("genres", genrerepository.findAll());
		return "addgame";
	
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
    public String saveGame(Game game){
		//jos id 0 tai null = SQL Insert, muuten SQL Update
        repository.save(game);
        return "redirect:/gamelist";
    }    
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);
        return "redirect:../gamelist";
    }     
	
	
	@RequestMapping(value ="/updategame/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String editGame(@PathVariable("id") Long id, Model model) {
		Optional<Game> game = repository.findById(id);
		model.addAttribute("game", game);
		model.addAttribute("genres", genrerepository.findAll());
		return "updategame";
	}

}
