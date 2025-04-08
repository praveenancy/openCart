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
	
		HomePage hm = new HomePage(driver);
		logger.info("Tap on my acount");
		hm.clickOnMyAccount();
		logger.info("Tap on login");
		hm.login();
		
		logger.info("enter email and password");
     	LoginPage lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pass);
		logger.info("Tap on login button");
		lp.login();
	
		
		MyAccount ma = new MyAccount(driver);
		logger.info("validate My account section is displayed");
		boolean status = ma.validateMyAccount();
		
		
		/*Data is valid  - login success - test pass  - logout
		Data is valid -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		Data is invalid -- login failed - test pass  */
		
		
		
		logger.info("check login status");
		if(exp.equalsIgnoreCase("valid"))
		{
			if(status==true)
			{
				ma.logout();
				assertTrue(true);
				
			}
			else {
				System.out.println("valid "+"status : "+status+""+ email +"  "+ pass);
				assertTrue(false);
			}
			
		}
	     
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(status ==true)
			{
				ma.logout();
				System.out.println("valid "+"status :  "+status+""+ email +"  "+ pass);
				assertTrue(false);
				
			}
			else {
				assertTrue(true);
			}
		}
		
		//assertTrue(status);
	}
	  

}
