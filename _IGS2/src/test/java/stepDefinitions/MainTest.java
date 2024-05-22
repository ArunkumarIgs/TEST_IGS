package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import _3_PageObjectClass.AccountSummaryPage;
import _3_PageObjectClass.LoginPage;
import _3_PageObjectClass.TransactionsPage;
import _3_PageObjectClass.TransferFundsPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainTest {
	private static WebDriver driver;
	private LoginPage loginPage;
	private AccountSummaryPage accountSummaryPage;
	private TransferFundsPage transferFundsPage;
	private TransactionsPage transactionsPage;
	private String transferredAmount;
	private String retrievedAmount;

	@Before
	public void setUp() {
		System.setProperty("Webdriver.chrome.driver", "C:/BenefitPipeline/Session/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		loginPage = new LoginPage(driver); // Initialize LoginPage with WebDriver
		accountSummaryPage = new AccountSummaryPage(driver);
		transferFundsPage = new TransferFundsPage(driver);
		transactionsPage = new TransactionsPage(driver);
	}

	public static WebDriver getDriver() 
	{
		return driver;
	}

	@Given("I login into the site with the registered username and password")
	public void I_login_into_the_site_with_the_registered_username_and_password()
	{
		loginPage.loginappl("Aru", "Aru");
	}

	@Then("the user checks the account balance")
	public void the_user_checks_the_account_balance() throws InterruptedException
	{
		Thread.sleep(4000);
		accountSummaryPage.getAccountBalance();
	}

	@When("the user transfers amount dollars to own account")
	public void the_user_transfers_amount_dollars_to_own_account() throws InterruptedException 
	{
		Thread.sleep(2000);
		transferFundsPage.transferFunds();
		transferFundsPage.enterAmount("5");
		Thread.sleep(2000);
		transferFundsPage.transferbutton();
		Thread.sleep(2000);
	}

	@Then("the user should see a confirmation message")
	public void the_user_should_see_a_confirmation_message()
	{
		transferFundsPage.confirmationmessagemethod();
		transferredAmount = transferFundsPage.getsentamounttext();
		System.out.println("Transferred Amount: " + transferredAmount);
	}

	@When("the user searches for transactions using the current date")
	public void the_user_searches_for_transactions_using_the_current_date() throws InterruptedException 
	{
		transactionsPage.findTransactionsmethod();
	}

@Then("the user should find the transaction for amount dollars")
public void the_user_should_find_the_transaction_for_amount_dollars() throws
InterruptedException
{
Thread.sleep(2000);
retrievedAmount=transactionsPage.transactionVerify();
 System.out.println("Retrieved Amount: " + retrievedAmount);
 try
 {
 Assert.assertEquals(retrievedAmount, transferredAmount, "The retrieved transaction amount = The transferred amount.");
 System.out.println("Assertion Passed: The retrieved transaction amount matches the transferredamount.");
 } catch (AssertionError e)
 {
 System.err.println("Assertion Failed: The retrieved transaction amount does not match the transferred amount.");
 System.err.println("Expected: " + transferredAmount);
 System.err.println("Actual: " + retrievedAmount);
 throw e;
 }
}

	@AfterStep
	public void takeScreenShots(Scenario scenario) 
	{
		if (scenario.isFailed()) 
		{
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
}
