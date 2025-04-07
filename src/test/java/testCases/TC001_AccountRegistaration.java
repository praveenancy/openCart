package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistaration extends BaseClass{
	
	
	@Test(groups = "Regression")
	public void Registration() throws InterruptedException
	{
		
		HomePage homePage = new HomePage(driver);
	
		logger.info("Tapping on my acount");
		homePage.clickOnMyAccount();
		logger.info("tapping on registor");
		homePage.clikOnRegistor();
		
		AccountRegistrationPage ag = new AccountRegistrationPage(driver);
		
		ag.FirstName(randomString());
		ag.LastName(randomString());
		ag.email(randomString()+"@gmail.com");
		ag.number(randomNumber());
		
		String pass= randomString()+randomNumber();
		ag.password(pass);
		ag.ConfirmPassword(pass);
		ag.agree();
		ag.Continue();
		
		
		String msg = ag.successMessage();
		
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		
	}
	
	
	
	
}
