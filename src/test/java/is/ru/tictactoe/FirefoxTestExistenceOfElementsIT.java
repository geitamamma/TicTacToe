package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirefoxTestExistenceOfElementsIT {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void SetUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = System.getenv("STAGING_SERVER");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TestIfTitleIsTicTacToe() throws Exception {
		driver.get(baseUrl);
		assertEquals("Tic Tac Toe", driver.getTitle());
	}

	@Test
	public void TestIfGameBoardTableIsPresent() throws Exception{
		driver.get(baseUrl);
		assertTrue(IsElementPresent(By.className("game-board")));
	}

	@Test
	public void TestIfResetButtonIsPresent() throws Exception{
		driver.get(baseUrl);
		assertTrue(IsElementPresent(By.id("reset-game")));
	}

	@Test
	public void TestIfMessageBoxIsPresent() throws Exception{
		driver.get(baseUrl);
		assertTrue(IsElementPresent(By.id("message")));
	}

	@Test
	public void TestIfH1ContainsTicTacToe() throws Exception{
		driver.get(baseUrl);
		WebElement header1 = driver.findElement(By.id("h1"));
		assertEquals("Tic Tac Toe !", header1.getText());
	}

	@Test
	public void TestIfAllCellsArePresent() throws Exception{
		driver.get(baseUrl);
		List<WebElement> cells = driver.findElements(By.className("cell"));
		assertEquals(9, cells.size());
	}

	@After
	public void TearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean IsElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
