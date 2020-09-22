package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.cssSelector("input[id='user_email']"); // Enter emailId field
	By pwd = By.cssSelector("#user_email");// password filed
	By login = By.cssSelector("[value='Log In']"); // Login Button

	public WebElement getemail(){
		return driver.findElement(email);
	}

	public WebElement getpwd(){
		return driver.findElement(pwd);
	}

	public WebElement getlogin(){
		return driver.findElement(login);
	}
}
