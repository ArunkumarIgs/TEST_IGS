package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import _3_PageObjectClass.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public WebDriver driver;
	private LoginPage loginPage;

// @Before
// public void setUp()
// {
// System.setProperty("Webdriver.chrome.driver","C:/BenefitPipeline/Session/chromedriver.exe");
// WebDriver driver = new ChromeDriver();
// driver.manage().window().maximize();
// driver.get("https://parabank.parasoft.com/parabank/index.htm");
// }
// @After
// public void Afterscenario()
// {
// System.out.println("Test is completed");
// driver.quit();
// }
}
