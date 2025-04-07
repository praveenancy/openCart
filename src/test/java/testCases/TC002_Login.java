package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_Login extends BaseClass{
	
	
	@Test
	public void loginTest() throws InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		Thread.sleep(1000);
		hp.clickOnMyAccount();
		hp.login();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		
		lp.login();
		
		MyAccount ma = new MyAccount(driver);
		boolean satus = ma.validateMyAccount();
		
		ma.logout();
		Thread.sleep(2000);
		
		assertTrue(satus);
		
		
		
	}

}
