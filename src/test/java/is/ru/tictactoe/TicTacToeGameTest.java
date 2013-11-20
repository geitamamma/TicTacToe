package is.ru.tictactoe;

//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeGameTest{

	/***********************
	*** Test Constructor ***
	***********************/
	@Test
	public void TestConstructorGameArray(){
		TicTacToeGame game = new TicTacToeGame();
		int[] expectedGameBoard = GetEmptyGameBoard();
		assertArrayEquals(expectedGameBoard, game.GetGameBoard());
	}

	@Test
	public void TestConstructorNextPlayer(){
		TicTacToeGame game = new TicTacToeGame();
		assertEquals(1, game.GetNextPlayer());
	}

	@Test
	public void TestConstructorMovesLeft(){
		TicTacToeGame game = new TicTacToeGame();
		assertEquals(9, game.GetMovesLeft());
	}

	/*********************
	*** Test Mark Cell ***
	*********************/
	@Test
	public void TestMarkCellCellNrTooLow(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(-1, 1);
			fail("Should have thrown an exception because cell number is too low");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Cell number is out of bounce.", ex.getMessage());
		}
	}

	@Test
	public void TestMarkCellCellNrTooHigh(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(9, 1);
			fail("Should have thrown an exception because cell number is too high");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Cell number is out of bounce.", ex.getMessage());
		}
	}

	@Test
	public void TestMarkCellPlayerNrTooLow(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(0, 0);
			fail("Sould have thrown exception because player number is too low");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Player number must be between 1 and 2.", ex.getMessage());
		}
	}

	@Test
	public void TestMarkCellPlayerNrTooHigh(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(0, 3);
			fail("Sould have thrown exception because player number is too high.");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Player number must be between 1 and 2.", ex.getMessage());
		}
	}

	@Test
	public void TestMarkCellCellNr0Player1(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(0, 1);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown exception because both cell nr and player nr are within limits!");
		}
	}

	@Test
	public void TestMarkCellCellNr0Player2(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(0, 2);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown exception because both cell nr and player nr are within limits!");
		}
	}

	@Test
	public void TestMarkCellCellNr8Player1(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(8, 1);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown exception because both cell nr and player nr are within limits!");
		}
	}

	@Test
	public void TestMarkCellCellNr8Player2(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(8, 2);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown exception because both cell nr and player nr are within limits!");
		}
	}

	@Test
	public void TestMarkCellMiddle(){
		TicTacToeGame game = new TicTacToeGame();
		try{
			game.MarkCell(3, 1);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown exception because both cell nr and player nr are within limits!");
		}
	}

	@Test
	public void TestMarkCellPlayer2GetGameBoard(){
		TicTacToeGame game = new TicTacToeGame();
		int[] expectedGameBoard = GetEmptyGameBoard();
		expectedGameBoard[0] = 2;
		game.MarkCell(0, 2);
		assertArrayEquals(expectedGameBoard, game.GetGameBoard());
	}

	@Test
	public void TestMarkCellPlayer1GetGameBoard(){
		TicTacToeGame game = new TicTacToeGame();
		int[] expectedGameBoard = GetEmptyGameBoard();
		expectedGameBoard[4] = 1;
		game.MarkCell(4, 1);
		assertArrayEquals(expectedGameBoard, game.GetGameBoard());
	}

	@Test
	public void TestMarkCellPlayer2GetNextPlayer(){
		TicTacToeGame game = new TicTacToeGame();
		game.MarkCell(0, 2);
		assertEquals(1, game.GetNextPlayer());
	}

	@Test
	public void TestMarkCellPlayer1GetNextPlayer(){
		TicTacToeGame game = new TicTacToeGame();
		game.MarkCell(6, 1);
		assertEquals(2, game.GetNextPlayer());
	}

	@Test
	public void TestMarkCellPlayer2GetMovesLeft(){
		TicTacToeGame game = new TicTacToeGame();
		game.MarkCell(2, 1);
		assertEquals(8, game.GetMovesLeft());
	}

	@Test
	public void TestMarkCellPlayer1GetMovesLeft(){
		TicTacToeGame game = new TicTacToeGame();
		game.MarkCell(7, 2);
		assertEquals(8, game.GetMovesLeft());
	}


	/***********************
	*** Empty Game Board ***
	***********************/
	private int[] GetEmptyGameBoard(){
		int[] array = new int[9];
		for(int i=0; i<9; i++)
			array[i] = 0;
		return array;
	}
}