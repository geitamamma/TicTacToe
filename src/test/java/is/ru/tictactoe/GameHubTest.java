package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameHubTest{
	private static Player player1 = new Player("Player1", 1);
	private static Player player2 = new Player("Player2", 2);
	private static ITicTacToeGame newGame = new TicTacToeGame();
	//Game Board
	//x o x
	//o   x
	//x o 
	private ITicTacToeGame threeMovesLeft = new TicTacToeMock();

	/***********************
	*** Test Constructor ***
	***********************/
	@Test
	public void TestConstructorHubWithGameNull(){
		try{
			GameHub game = new GameHub(null, player1, player2);
			fail("Should throw an exception, game is null");
		}
		catch(IllegalArgumentException ex){
			assertEquals("This is somewhat embarrassing, please try again.", ex.getMessage());
		}
	}

	@Test
	public void TestConstructorWithPlayer1Null(){
		try{
			GameHub game = new GameHub(newGame, null, player2);
			fail("Should throw an exception, player1 is null");
		}
		catch(IllegalArgumentException ex){
			assertEquals("This is somewhat embarrassing, please try again.", ex.getMessage());
		}
	}

	@Test
	public void TestConstructorWithPlayer2Null(){
		try{
			GameHub game = new GameHub(newGame, player1, null);
			fail("Should throw an exception, player2 is null");
		}
		catch(IllegalArgumentException ex){
			assertEquals("This is somewhat embarrassing, please try again.", ex.getMessage());
		}
	}

	@Test
	public void TestConstructorWithValidInput(){
		try{
			GameHub game = new GameHub(newGame, player1, player2);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown an exception.");
		}
	}

	/*********************
	*** Test Mark Cell ***
	*********************/
	@Test
	public void TestMarkCellIllegalCellNr(){
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(10, 1);
		assertEquals("Cell number is out of bounce. Next player is Player1.", game.GetMessage());
	}

	@Test
	public void TestMarkCellIllegalPlayerNr(){
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(2, 0);
		assertEquals("Player number must be between 1 and 2. Next player is Player1.", game.GetMessage());
	}

	/*********************
	*** Test GetWinner ***
	**********************/
	@Test
	public void TestGetWinnerPlayer1(){
		GameHub game = new GameHub(newGame, player1, player2);
		assertEquals("Player1 has won !", game.GetWinner(1));
	}

	@Test
	public void TestGetWinnerPlayer2(){
		GameHub game = new GameHub(newGame, player1, player2);
		assertEquals("Player2 has won !", game.GetWinner(2));
	}

	/*****************************
	*** Test GetNextPlayerName ***
	******************************/
	@Test
	public void TestGetNextPlayerNewGame(){
		GameHub game = new GameHub(newGame, player1, player2);
		assertEquals("Player1", game.GetNextPlayerName());
	}

	@Test
	public void TestGetNextPlayerNameThreeMovesLeft(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		assertEquals("Player1", game.GetNextPlayerName());
	}

	/*****************************
	*** Test MarkCell MockGame ***
	******************************/
	@Test
	public void TestMarkCellPlayer2Wins(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(3, 2);
		assertEquals("Player2 has won !", game.GetMessage());
	}

	@Test
	public void TestMarkCellPlayer1Wins(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(2, 1);
		assertEquals("Player1 has won !", game.GetMessage());
	}

	@Test
	public void TestMarkCellPlayer1IsNext(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(8, 2);
		assertEquals("Player1, it's your turn !", game.GetMessage());
	}

	@Test
	public void TestMarkCellPlayer2IsNext(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(8, 1);
		assertEquals("Player2, it's your turn !", game.GetMessage());
	}

	@Test
	public void TestMarkCellGetDraw(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(8, 2);
		game.MarkCell(3, 1);
		game.MarkCell(2, 2);
		assertEquals("It's a draw !", game.GetMessage());
	}

	@Test
	public void TestMarkAlreadyMarkedCell(){
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(1, 2);
		assertEquals("This cell has already been marked. Next player is Player1.", game.GetMessage());
	}
}
