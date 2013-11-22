package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameHubTest{

	@Test
	public void CheckWinnerTest(){
		GameHub game = new GameHub();
		assertTrue(game.CheckWinner());
	}
}
