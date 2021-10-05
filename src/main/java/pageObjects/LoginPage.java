package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//rahulonlinetutor@gmail.com
public class LoginPage {

	public WebDriver driver;

	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[type='password']");
	By login = (By.cssSelector(".login"));
	// By forgotPassword = By.cssSelector("[href*='password/new']");

	// By login= (By.cssSelector(".login"));
	By username = (By.cssSelector("#email"));
	By passwod = (By.cssSelector("#passwd"));
	By submit = (By.cssSelector("#SubmitLogin"));

	// constructor is invoked to initialize driver
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	/*
	 * public ForgotPassword forgotPassword() {
	 * driver.findElement(forgotPassword).click(); return new
	 * ForgotPassword(driver);
	 * 
	 * }
	 */
	public void fetchlogin(String uname, String pwd) {
		// return driver.findElement(login);
		driver.findElement(login).click();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(passwod).sendKeys("pwd");
		driver.findElement(submit).click();
	}

	/*
	 * public WebElement fetchusername() { return driver.findElement(username); }
	 * 
	 * public WebElement fetchpassword() { return driver.findElement(passwod); }
	 * 
	 * public WebElement submit() { return driver.findElement(submit); }
	 */
}
