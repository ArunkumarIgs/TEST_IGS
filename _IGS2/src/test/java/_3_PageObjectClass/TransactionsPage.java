package _3_PageObjectClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionsPage 
{
	WebDriver driver;

	public TransactionsPage(WebDriver driver) {
		this.driver = driver;
	}

	By FindTransactions_btn = By.xpath("//a[contains(text(), 'Find Transactions')]");
	By transactionDate_btn = By.xpath("//input[@id='transactionDate']");
	By findtransaction_btn = By.xpath("//button[@id='findByDate' and @type='submit']");
	By transactionverify = By.xpath("//tbody[@id='transactionBody']/tr[1]/td[3]");

	public void FindTransactionsclick() {
		driver.findElement(FindTransactions_btn).click();
	}

	public void transactionDate_Button() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println(formattedDate);
		driver.findElement(transactionDate_btn).sendKeys(formattedDate);
	}

	public void findtransactionclick() {
		driver.findElement(findtransaction_btn).click();
	}

	public String transactionVerify() throws InterruptedException {
		Thread.sleep(2000);
		String transver = driver.findElement(transactionverify).getText();
		return transver;
	}

	public void findTransactionsmethod() throws InterruptedException {
		Thread.sleep(2000);
		FindTransactionsclick();
		Thread.sleep(2000);
		transactionDate_Button();
		Thread.sleep(2000);
		findtransactionclick();
	}
}