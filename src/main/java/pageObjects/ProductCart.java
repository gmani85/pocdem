package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCart {

	public WebDriver driver;
	public ProductCart(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}
	By cart = (By.xpath("//p[@id='add_to_cart']"));
	// By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By qty=(By.xpath("//input[@id='quantity_wanted']"));
	By textsi=	By.xpath("//div[@id='uniform-group_1']/span");
	By clr=(By.xpath("//li[@class='selected']/a"));
	
	public WebElement addtocart() {
		return driver.findElement(cart);
	}
	public int getactprodqty() {
		int actqt1= Integer.parseInt(driver.findElement(qty).getAttribute("value"));
		//int actqt=Integer.parseInt(((WebElement) qty).getAttribute("value"));
		return actqt1;
	}
	public String getactprodsie() {
		String actprodsie=driver.findElement(textsi).getText();
		return actprodsie;
	}
	
	public String getactprodcolor() {
		String actprodcolor=driver.findElement(clr).getAttribute("title");
		return actprodcolor;
	}
	
}
