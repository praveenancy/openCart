package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//input[@id='input-email']") WebElement email;
	@FindBy(xpath = "//input[@id='input-password']") WebElement pass;
	@FindBy(xpath ="//input[@value='Login']") WebElement loginButton;
	
	public void enterEmail(String em)
	{
		email.sendKeys(em);
	}
	public void enterPassword(String ps)
	{
		pass.sendKeys(ps);
	}
	
	public void login()
	{
		loginButton.click();
	}
}
