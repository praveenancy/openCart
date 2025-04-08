package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Cart;
import pageObjects.HomePage;
import pageObjects.Product;
import testBase.BaseClass;

public class TC004_Add_Iteeam_To_Cart extends BaseClass {
	
	@Test(groups = "Regression")
	public void searchProduct() throws InterruptedException
	{
		 HomePage homePage = new HomePage(driver);
		 logger.info("enter product in search bar");
		 homePage.search("iphone");
		
		 logger.info("tsp on search button");
		 homePage.clickOnsearchButton();
		 
		 Product product = new Product(driver);
		 logger.info("tap on add to cart button");
		 product.addToCart();
		WebElement msg= product.successMsg();
		
		 logger.info("successfully product added to cart");
	      Boolean msgStatus =msg.isDisplayed();
	    
	      Assert.assertTrue(msgStatus);
	      
	      logger.info("tap on add cart");
	      product.tapOnCart();
	      
	      Cart cart = new Cart(driver);
	      
	      logger.info("tap on Estimate section");
	      cart.tapOnEstimates();
	      
	      logger.info("fill required flled");
	      cart.selectCountry("India");
	      cart.selectState("Telangana");
	      cart.setPostCode("500072");
	      
	      logger.info("tap on get quote buttn");
	      cart.tapOnGetQuotes();
		 
		 
	}

}
