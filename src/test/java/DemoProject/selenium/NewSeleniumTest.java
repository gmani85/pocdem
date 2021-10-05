package DemoProject.selenium;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProductCart;
import pageObjects.ShoppingCartPage;
import resources.base;

public class NewSeleniumTest extends base {
	public WebDriver driver;
	// Actions s= new Actions(driver);
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String Username, String Password) throws IOException, InterruptedException {

		// one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		// LandingPage l=new LandingPage(driver);
		// LoginPage lp=l.getLogin(); //driver.findElement(By.css()
		LoginPage l = new LoginPage(driver);
		LandingPage l2 = new LandingPage(driver);
		ProductCart l3=new ProductCart(driver);
		ShoppingCartPage l4 = new ShoppingCartPage(driver);
		l.fetchlogin(Username, Password);
		List<WebElement> cat = driver.findElements(By.xpath("//a[@title='T-shirts']"));
		// WebElement cat= driver.findElement(By.xpath("//a[@title='T-shirts'][2]"));
		cat.get(1).click();
		Actions s = new Actions(driver);
		s.moveToElement(l2.getimage()).click().build().perform();
		Thread.sleep(3000);
		// driver.switchTo().frame(0);
		String Acualpodcolo=l3.getactprodcolor();
		log.info(Acualpodcolo);
		int Actualprodqty=l3.getactprodqty();
		log.info(Actualprodqty);
		String Actualprodsie=l3.getactprodsie();
		log.info(Actualprodsie);
		String colorsi=(Acualpodcolo+"," +" "+Actualprodsie);
		log.info(colorsi);
		double price=(Actualprodqty)*16.51;
		String Actualtotal="$"+price;
		log.info(Actualtotal);
		l3.addtocart().click();
		// driver.switchTo().defaultContent();
		Thread.sleep(5000);
		String var = l4.fetchtext();
		String prodname=l4.fetchprodname();
		Thread.sleep(5000);
		Assert.assertEquals(var, "Product successfully added to your shopping cart");
		Assert.assertEquals(prodname, "Faded Short Sleeve T-shirts");
		Assert.assertEquals(l4.fetchqty(),Actualprodqty );
		Assert.assertEquals(l4.fetchprodsiecolor(), colorsi);
		Assert.assertEquals(l4.fetchprice(), Actualtotal);
		l4.Proccedcheckout();

	}

	

	

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// coloumn stands for how many values per each test

		// Array size is 2
		// 0,1
		Object[][] data = new Object[1][2];
		// 0th row
		data[0][0] = "jetblue@grr.la";
		data[0][1] = "jetblue";
		return data;

	}

}
