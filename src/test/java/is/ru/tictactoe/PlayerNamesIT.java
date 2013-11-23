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

public class PlayerNamesIT{
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
	public void TestSubmittingEmptyForm() throws Exception{
		selenium.open("/");
		selenium.click("id=start-game");
		assertEquals("Please enter a name.", selenium.getText("message"));
	}

	@Test
	public void TestSubmittingPlayer1Only() throws Exception{
		selenium.open("/");
		selenium.type("name=player1", "Jon");
		selenium.click("id=start-game");
		assertEquals("Please enter a name.", selenium.getText("message"));
	}

	@Test
	public void TestSubmittingPlayer2Only() throws Exception{
		selenium.open("/");
		selenium.type("name=player2", "Kalli");
		selenium.click("id=start-game");
		assertEquals("Please enter a name.", selenium.getText("message"));
	}

	@Test
	public void TestSubmittingBothNames() throws Exception{
		selenium.open("/");
		selenium.type("name=player1", "Jon");
		selenium.type("name=player2", "Kalli");
		selenium.click("id=start-game");
		assertEquals("First player is Jon.", selenium.getText("message"));
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