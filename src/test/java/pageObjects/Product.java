package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends BasePage{

	
	public Product(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//*[text()= 'Add to Cart']") WebElement addCart;
	@FindBy(xpath ="//*[contains(@class, 'alert alert-success alert-dismissible')]") WebElement successmsg;
	@FindBy(xpath ="(//span[@class='hidden-xs hidden-sm hidden-md'])[5]") WebElement cart;
	
	
	public void addToCart()
	{
		addCart.click();
	}
	
	public WebElement successMsg()
	{
		return successmsg;
	}
	
	public void tapOnCart()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cart);
		
		//cart.click();
	}
	
	
}
