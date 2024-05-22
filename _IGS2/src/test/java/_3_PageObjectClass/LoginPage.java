package _3_PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	By usernameField = By.xpath("//input[@type='text' and @name='username']");
	By passwordField = By.xpath("//input[@type='password' and @name='password']");
	By loginButton = By.xpath("//input[@type='submit' and @value='Log In']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) 
	{
		WebElement usernameElement = driver.findElement(usernameField);
		usernameElement.sendKeys(username);
	}

	public void setPassword(String password) {
		WebElement passwordElement = driver.findElement(passwordField);
		passwordElement.sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void loginappl(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLoginButton();
	}
}