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
		Thread.sleep(3000);
		logger.info("Tap on my acount");
		hp.clickOnMyAccount();
		logger.info("Tap on login");
		hp.login();
		
		logger.info("enter email and password");
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		
		logger.info("Tap on login button");
		lp.login();
		
		MyAccount ma = new MyAccount(driver);
		logger.info("validate My account section is displayed");
		boolean satus = ma.validateMyAccount();
		
		logger.info("tap on log out button");
		ma.logout();
		Thread.sleep(2000);
		
		assertTrue(satus);
		
		
		
	}

}
