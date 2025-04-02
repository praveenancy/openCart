package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver)	;
		}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement myAccount;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutbtn;
	
	
	public boolean validateMyAccount()
	{
		try {
		boolean status =myAccount.isDisplayed();
		
		return status;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void logout()
	{
		
		logoutbtn.click();
	}
	
}
