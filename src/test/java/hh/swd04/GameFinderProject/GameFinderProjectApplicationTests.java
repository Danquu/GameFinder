package hh.swd04.GameFinderProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd04.GameFinderProject.web.GameController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GameFinderProjectApplicationTests {
	
	@Autowired
	private GameController gameController;

	@Test
	public void contextLoads() {
		assertThat(gameController).isNotNull();
	}


}
