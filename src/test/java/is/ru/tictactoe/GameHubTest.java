package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameHubTest{
	private static Player player1 = new Player("Player1", 1);
	private static Player player2 = new Player("Player2", 2);
	/********************
	*** TicTacToeMock ***
	*********************
	Game Board:
	x x
	  o o
	o x
	NextPlayer: 1
	MovesLeft: 3
	********************/

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
			ITicTacToeGame newGame = new TicTacToeGame();
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
			ITicTacToeGame newGame = new TicTacToeGame();
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
			ITicTacToeGame newGame = new TicTacToeGame();
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
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(10, 1);
		assertEquals("Cell number is out of bounce. Next player is Player1.", game.GetMessage());
	}

	@Test
	public void TestMarkCellIllegalPlayerNr(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(2, 0);
		assertEquals("Player number must be between 1 and 2. Next player is Player1.", game.GetMessage());
	}

	/*********************
	*** Test GetWinner ***
	**********************/
	@Test
	public void TestGetWinnerPlayer1(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		assertEquals("Player1 has won !", game.GetWinner(1));
	}

	@Test
	public void TestGetWinnerPlayer2(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		assertEquals("Player2 has won !", game.GetWinner(2));
	}

	/*****************************
	*** Test GetNextPlayerName ***
	******************************/
	@Test
	public void TestGetNextPlayerNewGame(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		assertEquals("Player1", game.GetNextPlayerName());
	}

	@Test
	public void TestGetNextPlayerNameThreeMovesLeft(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		assertEquals("Player1", game.GetNextPlayerName());
	}

	/*****************************
	*** Test MarkCell MockGame ***
	******************************/
	@Test
	public void TestMarkCellPlayer2Wins(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(3, 2);
		assertEquals("Player2 has won !", game.GetMessage());
	}

	@Test
	public void TestMarkCellPlayer1Wins(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(2, 1);
		assertEquals("Player1 has won !", game.GetMessage());
	}

	@Test
	public void TestMarkCellPlayer1IsNext(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(8, 2);
		assertEquals("Player1, it's your turn !", game.GetMessage());
	}

	@Test
	public void TestMarkCellPlayer2IsNext(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(8, 1);
		assertEquals("Player2, it's your turn !", game.GetMessage());
	}

	@Test
	public void TestMarkCellGetDraw(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(8, 2);
		game.MarkCell(3, 1);
		game.MarkCell(2, 2);
		assertEquals("It's a draw !", game.GetMessage());
	}

	@Test
	public void TestMarkAlreadyMarkedCell(){
		ITicTacToeGame threeMovesLeft = new TicTacToeMock();
		GameHub game = new GameHub(threeMovesLeft, player1, player2);
		game.MarkCell(1, 2);
		assertEquals("This cell has already been marked. Next player is Player1.", game.GetMessage());
	}

	/*****************************
	*** Test CheckWinner Logic ***
	******************************/
	@Test
	public void TestWinnerRow1(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(0, 1);
		game.MarkCell(1, 1);
		game.MarkCell(2, 1);
		assertEquals("Player1 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerRow2(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(3, 1);
		game.MarkCell(4, 1);
		game.MarkCell(5, 1);
		assertEquals("Player1 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerRow3(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(6, 1);
		game.MarkCell(7, 1);
		game.MarkCell(8, 1);
		assertEquals("Player1 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerColumn1(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(0, 2);
		game.MarkCell(3, 2);
		game.MarkCell(6, 2);
		assertEquals("Player2 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerColumn2(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(1, 2);
		game.MarkCell(4, 2);
		game.MarkCell(7, 2);
		assertEquals("Player2 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerColumn3(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(2, 2);
		game.MarkCell(5, 2);
		game.MarkCell(8, 2);
		assertEquals("Player2 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerDiagonal1(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(0, 2);
		game.MarkCell(4, 2);
		game.MarkCell(8, 2);
		assertEquals("Player2 has won !", game.GetMessage());
	}

	@Test
	public void TestWinnerDiagonal2(){
		ITicTacToeGame newGame = new TicTacToeGame();
		GameHub game = new GameHub(newGame, player1, player2);
		game.MarkCell(2, 1);
		game.MarkCell(4, 1);
		game.MarkCell(6, 1);
		assertEquals("Player1 has won !", game.GetMessage());
	}
}
