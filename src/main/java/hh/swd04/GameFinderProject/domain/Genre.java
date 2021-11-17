package hh.swd04.GameFinderProject.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Genre {
	
	@Id @GeneratedValue private Long genreid;
	
	@NotBlank(message="Name is mandatory") private String name;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	@JsonIgnoreProperties("genre")
	private List<Game> games;
	
	public Genre() {
		super();
	}

	public Genre(String name) {
		super();
		this.name = name;
	}
	
	public Genre(String name, List<Game> games) {
		super();
		this.name = name;
		this.games = games;
	}

	public Long getGenreid() {
		return genreid;
	}

	public String getName() {
		return name;
	}
	
	

	public List<Game> getGames() {
		return games;
	}

	public void setGenreid(Long genreid) {
		this.genreid = genreid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", name=" + name + "]";
	}
	
	
	
	

}
