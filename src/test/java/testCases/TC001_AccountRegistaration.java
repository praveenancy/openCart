package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistaration extends BaseClass {

	@Test(groups = "Regression", priority = 1)
	public void Registration() throws InterruptedException {

		HomePage homePage = new HomePage(driver);

		logger.info("Tap on my acount");
		homePage.clickOnMyAccount();
		logger.info("tap on registor");
		homePage.clikOnRegistor();

		AccountRegistrationPage ag = new AccountRegistrationPage(driver);

		logger.info("Fill all the details");
		ag.FirstName(randomString());
		ag.LastName(randomString());
		ag.email(randomString() + "@gmail.com");
		ag.number(randomNumber());

		String pass = randomString() + randomNumber();
		ag.password(pass);
		ag.ConfirmPassword(pass);
		logger.info("Tap/agree on terms and conditions checkbox");
		ag.agree();

		logger.info("tap on continue button");
		ag.Continue();

		String msg = ag.successMessage();

		logger.info("validate Your Account Has Been Created! text is being displayed ");
		Assert.assertEquals(msg, "Your Account Has Been Created!");

	}

	@Test(groups = "Regression", priority = 2)
	public void registrationErrorMessagesValidation() {

		HomePage homePage = new HomePage(driver);

		logger.info("Tap on my acount");
		homePage.clickOnMyAccount();
		logger.info("tap on registor");
		homePage.clikOnRegistor();
		AccountRegistrationPage ag = new AccountRegistrationPage(driver);
		logger.info("tap on continue button");
		ag.Continue();

	}

}
