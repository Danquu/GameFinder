package hh.swd04.GameFinderProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd04.GameFinderProject.domain.Game;
import hh.swd04.GameFinderProject.domain.GameRepository;
import hh.swd04.GameFinderProject.domain.Genre;
import hh.swd04.GameFinderProject.domain.GenreRepository;
import hh.swd04.GameFinderProject.domain.User;
import hh.swd04.GameFinderProject.domain.UserRepository;

@SpringBootApplication
public class GameFinderProjectApplication {
	
	private static final Logger log = LoggerFactory.getLogger(GameFinderProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GameFinderProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner gameDemo(GameRepository repository, GenreRepository genrerepository, UserRepository userrepository) {
		return (args) -> {
			log.info("Save some games");
			
			Genre genre1 = new Genre("FPS");
			genrerepository.save(genre1);
			
			repository.save(new Game("Modern Warfare", genre1, "Fast-paced action shooter", 2009, "EA", "EA", 39.99));
			 
			User admin = new User("admin", "$2a$12$q/Z2L4YQiPlLO44bMqoYaeAH5pyL39.M51h5aZZ6Y8GH305lbMv3i", "ADMIN");
			userrepository.save(admin);
			
			log.info("Get the games");
			for (Game game : repository.findAll()) {
				log.info(game.toString());
			}
		};
	
}
}
