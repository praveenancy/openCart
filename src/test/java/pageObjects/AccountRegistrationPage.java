package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage{
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(id = "input-firstname") WebElement firstName;
	@FindBy(id = "input-lastname") WebElement lastName;
	@FindBy(id = "input-email") WebElement email;
	@FindBy(id = "input-telephone") WebElement number;
	@FindBy(id = "input-password") WebElement passw;
	@FindBy(id = "input-confirm") WebElement confirmPass;
	@FindBy(xpath = "//input[@class='btn btn-primary']") WebElement continuebtn;
	@FindBy(xpath = "//input[@name='agree']") WebElement agree;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']") WebElement successmsg;
	
	
	
	public void FirstName(String fname) {
		
		firstName.sendKeys(fname);
	}
	
	public void LastName(String lname) {
			
			lastName.sendKeys(lname);
		}
	public void email(String femail) {
		
		email.sendKeys(femail);
	}
	public void number(String no) {
		
		number.sendKeys(no);
	}
	public void password(String pass)
	{
		passw.sendKeys(pass);
	}
	public void ConfirmPassword(String cPass) {
		
		confirmPass.sendKeys(cPass);
	}
	
	public void Continue()
	{
		continuebtn.click();
	}
	public void agree()
	{
		agree.click();
	}

	public String successMessage()
	{
		try {
		return successmsg.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
}
