package _3_PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsPage {
	WebDriver driver;

	public TransferFundsPage(WebDriver driver) {
		this.driver = driver;
	}

	By TransferFunds = By.xpath("//a[contains(text(), 'Transfer Funds')]");
	By amountfield = By.xpath("//input[@id='amount' and @name='input']");
	By Transferbutton = By.xpath("//input[@type='submit' and @value='Transfer']");
	By ConfirmationText = By.xpath("//h1[contains(text(), 'Transfer Complete!')]");
	By getsentamount = By.xpath("//span[@id='amountResult']");

	public void transferFunds() {
		driver.findElement(TransferFunds).click();
	}

	public void enterAmount(String amount) {
		driver.findElement(amountfield).sendKeys(amount);
	}

	public void transferbutton() {
		driver.findElement(Transferbutton).click();
	}

	public void confirmationmessagemethod() {
		WebElement confirmationtext = driver.findElement(ConfirmationText);
		boolean isDisplayed = confirmationtext.isDisplayed();
		if (isDisplayed) {
			String getconfirmationtext = confirmationtext.getText();
			System.out.println("Account Transfer Completed!: " + getconfirmationtext);
		} else {
			System.out.println("Account Transfer Not Completed!");
		}
	}

	public String getsentamounttext() {
		WebElement getsentamounttext = driver.findElement(getsentamount);
		String getamounttext = getsentamounttext.getText();
		return getamounttext;
	}

	public void transferFundsmethod(String amount) {
		transferFunds();
		enterAmount(amount);
		transferbutton();
		confirmationmessagemethod();
	}
}
