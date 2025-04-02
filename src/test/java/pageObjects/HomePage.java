package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
		@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myaccount;
		@FindBy(xpath = "//a[normalize-space()='Register']") WebElement registor;
		@FindBy(xpath = "//a[normalize-space()='Login']") WebElement login;
		@FindBy(xpath = "//*[@name='search']") WebElement search ;	
		@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement searchButton;
		
		
		
		public void clickOnMyAccount()
		{
			myaccount.click();
		}
		public void clikOnRegistor()
		{
			registor.click();
		}
		
		public void login()
		{
			login.click();
		}
		
		public void search(String product)
		{
			search.sendKeys(product);
		}
		
		public void clickOnsearchButton() {
			searchButton.click();
		}
}
