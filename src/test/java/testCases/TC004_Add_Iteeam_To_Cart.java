package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Product;
import testBase.BaseClass;

public class TC004_Add_Iteeam_To_Cart extends BaseClass {
	
	@Test(groups = "Regression")
	public void searchProduct() throws InterruptedException
	{
		 HomePage homePage = new HomePage(driver);
		 homePage.search("iphone");
		 
		 homePage.clickOnsearchButton();
		 
		 Product product = new Product(driver);
		 product.addToCart();
		WebElement msg= product.successMsg();
	      Boolean msgStatus =msg.isDisplayed();
	    
	      Assert.assertTrue(msgStatus);
		
		 Thread.sleep(3000);
		 captureScreen("praveen");
	}

}
