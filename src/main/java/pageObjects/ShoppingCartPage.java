package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

	public WebDriver driver;

	By emailmessage = (By.xpath("//h2"));
	// By sendMeInstructions=By.cssSelector("[type='submit']");
	By Proceedcar = (By.xpath("//a[@title='Proceed to checkout']"));
	
	By text=(By.xpath("//span[@class='product-name']"));
	By prod= By.xpath("//span[@id='layer_cart_product_attributes']");
	By qtuany=By.xpath("//span[@id='layer_cart_product_quantity']");
	By price=By.xpath("//*[@id='layer_cart_product_price']");
	

	public ShoppingCartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public String fetchtext() {
		String ms=driver.findElement(emailmessage).getText();
		return ms;
	}

	public String fetchprodname() {
		String prodname= driver.findElement(text).getText();
		return prodname;
	}
	public String fetchprodsiecolor() {
		String prodcolosie= driver.findElement(prod).getText();
		return prodcolosie;
	}
	public int fetchqty() {
		int prodqty= Integer.parseInt(driver.findElement(qtuany).getText());
		return prodqty;
		
		}
	public String fetchprice() {
			String prodprice= (driver.findElement(price).getText());
			return prodprice;
			}
	
	public void Proccedcheckout() {
		 driver.findElement(Proceedcar).click();;
	}

}
