package testCases;

//usually one test class has one test 
import org.testng.Assert;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTestClass;

public class TC001_AccountRegistrationTest extends BaseTestClass {
	
	
	

	@Test(groups={"Master","Regression"})
	public void verifyAccountRegistration()
{
		try
		{
	logger.info("Starting TC001_AccountRegistrationTest");
	HomePage hp=new HomePage(driver);
	logger.info("clicked on MyaccountLink");
	hp.clickMyAccount();
	logger.info("clicked on RegistrationLink");
	hp.clickRegister();
	AccountRegistrationPage rp=new AccountRegistrationPage(driver);
	Faker f=new Faker();
	rp.setFirstName(f.name().firstName());
	rp.setLastName(f.name().lastName());
	rp.setEmail(f.internet().emailAddress());
	rp.setTelephone(f.phoneNumber().cellPhone());
	String s=f.internet().password();
	rp.setPassword(s);
	rp.setConfirmPassword(s);
	rp.setCheck();rp.setChkPolicy();
	rp.clickContinueBtn();
	logger.info("Validating expected message");
	String msg=rp.getAccountCreationSuccessMsg();
	if(msg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test failed");
		logger.debug("Debug logs..");
		Assert.assertTrue(false);
		}
		}
		
	catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Completed TC001_AccountRegistrationTest");
}

}
