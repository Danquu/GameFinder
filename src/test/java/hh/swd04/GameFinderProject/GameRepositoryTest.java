package hh.swd04.GameFinderProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd04.GameFinderProject.domain.Game;
import hh.swd04.GameFinderProject.domain.GameRepository;
import hh.swd04.GameFinderProject.domain.Genre;
import hh.swd04.GameFinderProject.domain.GenreRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GameRepositoryTest {
	
	@Autowired
	private GameRepository repository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@Test //Testataan löytyykö peli titlen avulla
	public void findByTitle() {
		List<Game> games = repository.findByTitle("Diablo 3");
		
		assertThat(games.get(0).getReleaseyear()).isEqualTo(2009);
	}
	
	
	@Test //Testataan pelin tallennusta
	public void createGame() {
		Genre genre3 = new Genre("Children");
		genrerepository.save(genre3);
		
		Game game = new Game("Minecraft", genre3, "Chill game for younger ones", 2011, "Mojang", "Mojang", 14.99);
		repository.save(game);
		assertThat(game.getId()).isNotNull();
	}

}
