package _3_PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSummaryPage {
	WebDriver driver;

	// table[@id='accountTable']/child::tbody/child::tr[1]/child::td[2]

	By accountBalance = By.xpath("//table[@id='accountTable']//tbody//tr[1]//td[2]");

	public AccountSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getAccountBalance() throws InterruptedException {
		Thread.sleep(3000);
		WebElement getbalance = driver.findElement(accountBalance);
		boolean isDisplayed = getbalance.isDisplayed();
		if (isDisplayed)
		{
			String amount = getbalance.getText();
			System.out.println("Account balance displayed: " + amount);
		} else 
		{
			System.out.println("Account balance is not displayed.");
		}
	}
}
