package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By img = (By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	// By title=By.cssSelector(".text-center>h2");
	By cart = (By.xpath("//p[@id='add_to_cart']"));
	// By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getimage() {
		return driver.findElement(img);

	}

	

}
