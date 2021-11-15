package hh.swd04.GameFinderProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd04.GameFinderProject.domain.GenreRepository;

@Controller
public class GenreController {
	
	@Autowired
	private GenreRepository genrerepository;
	
	@RequestMapping(value="/genrelist", method = RequestMethod.GET)
	public String listGenre(Model model) {
		
		model.addAttribute("genres", genrerepository.findAll());
		return "genrelist";
		
	}
	
	

}
