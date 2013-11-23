package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;



public class PlayerTest{

	/***********************
	*** Test Constructor ***
	***********************/
	@Test
	public void TestEmptyName(){
		try{
			Player player = new Player("", 1);
			fail("Should have thrown an exception because name is empty");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Please enter a name.", ex.getMessage());
		}
	}

	@Test
	public void TestTooLowPlayerNr(){
		try{
			Player player = new Player("Kiddi", 0);
			fail("Should have thrown an exception because player nr is too low");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Player number must be between 1 and 2.", ex.getMessage());
		}
	}

	@Test
	public void TestTooHighPlayerNr(){
		try{
			Player player = new Player("Kiddi", 3);
			fail("Should have thrown an exception because player nr is too high");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Player number must be between 1 and 2.", ex.getMessage());
		}
	}

	@Test
	public void TestPlayerNr1(){
		try{
			Player player = new Player("Kiddi", 1);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown an exception");
		}
	}

	@Test
	public void TestPlayerNr2(){
		try{
			Player player = new Player("Kiddi", 2);
		}
		catch(IllegalArgumentException ex){
			fail("Should not have thrown an exception");
		}
	}

	/*************************
	*** Test Get Functions ***
	*************************/
	@Test
	public void TestGetName(){
		Player player = new Player("Nonni", 1);
		assertEquals("Nonni", player.GetName());
	}

	@Test
	public void TestGetPlayerNr(){
		Player player = new Player("Gunni", 2);
		assertEquals(2, player.GetPlayerNr());
	}
}

