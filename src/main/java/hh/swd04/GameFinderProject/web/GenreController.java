package hh.swd04.GameFinderProject.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd04.GameFinderProject.domain.Genre;
import hh.swd04.GameFinderProject.domain.GenreRepository;

@Controller
public class GenreController {
	
	@Autowired
	private GenreRepository genrerepository;
	
	//Näytä genrelista
	@RequestMapping(value="/genrelist", method = RequestMethod.GET)
	public String listGenre(Model model) {
		
		model.addAttribute("genres", genrerepository.findAll());
		return "genrelist";
		
	}
	
	//Lisää genre
	@RequestMapping(value="/addgenre")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String addGenre(Model model) {
		
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	//Tallenna genre
	@RequestMapping(value ="/savegenre", method = RequestMethod.POST)
    public String saveGame(Genre genre){
		//jos id 0 tai null = SQL Insert, muuten SQL Update
        genrerepository.save(genre);
        return "redirect:/genrelist";
    }    
	
	//Poista genre ID:n avulla
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value ="/deletegenre/{id}", method = RequestMethod.GET)
    public String deleteGenre(@PathVariable("id") Long genreid, Model model) {
    	genrerepository.deleteById(genreid);
        return "redirect:../genrelist";
    }     
	
	//Päivitä genre ID:n avulla
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value ="/updategenre/{id}", method = RequestMethod.GET)
	public String editGenre(@PathVariable("id") Long genreid, Model model) {
		Optional<Genre> genre = genrerepository.findById(genreid);
		model.addAttribute("genre", genre);
		return "updategenre";
	}
	
	

}
