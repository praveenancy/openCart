package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import testBase.Dataprovider;

public class TC003_DataProvideLogin extends BaseClass {
	
	@Test(dataProvider = "testdata", dataProviderClass = Dataprovider.class)
	public void dpLogin(String email, String pass, String exp)
	{
		logger.info("strted testing");
	
		HomePage hm = new HomePage(driver);
		hm.clickOnMyAccount();
		hm.login();
		
     	LoginPage lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.login();
	
		MyAccount ma = new MyAccount(driver);
		boolean status = ma.validateMyAccount();
		
		
		/*Data is valid  - login success - test pass  - logout
		Data is valid -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		Data is invalid -- login failed - test pass  */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(status==true)
			{
				ma.logout();
				assertTrue(true);
				
			}
			else {
				assertTrue(false);
			}
			
		}
	     
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(status ==true)
			{
				ma.logout();
				assertTrue(false);
				
			}
			else {
				assertTrue(true);
			}
		}
		
		//assertTrue(status);
	}
	  

}
