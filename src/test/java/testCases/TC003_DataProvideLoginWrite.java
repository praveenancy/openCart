package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import testBase.Dataprovider;
import utilities.ExcelUtility;

public class TC003_DataProvideLoginWrite extends BaseClass {
	
	int count =1;
 
	
	
	@Test(dataProvider = "testdata", dataProviderClass = Dataprovider.class)
	public void dpLogin(String email, String pass, String exp) throws IOException
	{
		System.out.println("start test");
		
		logger.info("strted testing");
		
		String path =".\\testdata\\Opencart_LoginData.xlsx";
	
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
		
	//	ExcelUtility utiliity = new ExcelUtility(path);
		
		
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(status==true)
			{
				ma.logout();
				//utiliity.setCellData("sheet1", count, 4, "pass");
				count++;
				assertTrue(true);
				
			}
			else {
				
				//utiliity.setCellData("sheet1", count, 4, "fail");
				count++;
				assertTrue(false);
			}
			
		}
	     
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(status ==true)
			{
				ma.logout();
				
				//utiliity.setCellData("sheet1", count, 4, "fail");
				count++;
				assertTrue(false);
				
			}
			else {
				
			//	utiliity.setCellData("sheet1", count, 4, "pass");
				count++;
				assertTrue(true);
			}
		}
		
		//assertTrue(status);
	}
	  

}
