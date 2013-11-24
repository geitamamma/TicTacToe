package is.ru.tictactoe;

import com.thoughtworks.selenium.Selenium;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TicTacToeIT{
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Selenium selenium;

	/************
	*** SETUP ***
	************/
	@Before
	public void SetUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = System.getenv("STAGING_SERVER");
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/****************
	*** THE TESTS ***
	****************/
	@Test
	public void GetPlayer1Sign() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		assertEquals("X", selenium.getText("id=0"));
	}

	@Test
	public void GetPlayer2Sign() throws Exception{
		SetUpGame();
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		assertEquals("O", selenium.getText("id=1"));
	}
	
	@Test
	public void GetPlayer1SignAfter3Rounds() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		assertEquals("X", selenium.getText("id=2"));
	}

	@Test
	public void GetPlayer2SignAfter4Rounds() throws Exception{
		SetUpGame();
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		selenium.click("id=3");
		Thread.sleep(2000);
		assertEquals("O", selenium.getText("id=3"));
	}

	@Test
	public void Player2IsNext() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=1");
		Thread.sleep(2000);
		assertEquals("Kalli, it's your turn !", selenium.getText("message"));
	}

	@Test
	public void Player1IsNextTwoMoves() throws Exception{
		SetUpGame();
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		assertEquals("Jon, it's your turn !", selenium.getText("message"));
	}

	@Test
	public void CellAlreadyBeenClickedPlayer1() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		assertEquals("This cell has already been marked. Next player is Jon.", selenium.getText("message"));
	}

	@Test
	public void CellAlreadyBeenClickedPlayer1GetSign() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		assertEquals("X", selenium.getText("id=2"));
	}

	@Test
	public void CellAlreadyBeenClickedPlayer2() throws Exception{
		SetUpGame();
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		assertEquals("This cell has already been marked. Next player is Kalli.", selenium.getText("message"));
	}

	@Test
	public void CellAlreadyBeenClickedPlayer2GetSign() throws Exception{
		SetUpGame();
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		assertEquals("O", selenium.getText("id=1"));
	}

	@Test
	public void Player1Wins() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=3");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		assertEquals("Jon has won !", selenium.getText("message"));
	}

	@Test
	public void Player1WinsMessageStays() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=3");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		selenium.click("id=5");
		Thread.sleep(2000);
		assertEquals("Jon has won !", selenium.getText("message"));
	}

	@Test
	public void Player2Wins() throws Exception{
		SetUpGame();
		Thread.sleep(2000);
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=3");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=8");
		Thread.sleep(2000);
		selenium.click("id=5");
		Thread.sleep(2000);
		assertEquals("Kalli has won !", selenium.getText("message"));
	}

	@Test
	public void Player2WinsMessageStays() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=3");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=8");
		Thread.sleep(2000);
		selenium.click("id=5");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		assertEquals("Kalli has won !", selenium.getText("message"));
	}

	@Test
	public void ItsADraw() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=2");
		Thread.sleep(2000);
		selenium.click("id=5");
		Thread.sleep(2000);
		selenium.click("id=3");
		Thread.sleep(2000);
		selenium.click("id=6");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=8");
		Thread.sleep(2000);
		selenium.click("id=7");
		Thread.sleep(2000);
		assertEquals("It's a draw !", selenium.getText("message"));
	}

	@Test 
	public void ResetGameCheckMessage() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=1");
		Thread.sleep(2000);
		selenium.click("id=reset-game");
		Thread.sleep(2000);
		assertEquals("First player is Jon.", selenium.getText("message"));
	}

	@Test
	public void ResetGameCheckCell1() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=reset-game");
		Thread.sleep(2000);
		assertEquals("", selenium.getText("id=0"));
	}

	@Test
	public void ResetGameCheckCell2() throws Exception{
		SetUpGame();
		selenium.waitForPageToLoad("5000");
		selenium.click("id=0");
		Thread.sleep(2000);
		selenium.click("id=4");
		Thread.sleep(2000);
		selenium.click("id=reset-game");
		Thread.sleep(2000);
		assertEquals("", selenium.getText("id=4"));
	}

	private void SetUpGame(){
		selenium.open("/");
		selenium.type("name=player1", "Jon");
		selenium.type("name=player2", "Kalli");
		selenium.click("id=start-game");
	}

	/**************
	*** CLOSING ***
	**************/
	@After
	public void TearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}