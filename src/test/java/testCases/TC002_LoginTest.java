package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;

public class TC002_LoginTest extends BaseTestClass{
@Test(groups={"Sanity","Master"})
public void verify_login()
{
	
	try {
		
	
	logger.info("starting TC002_LoginTest");
	HomePage hp=new HomePage(driver);
	logger.info("clicking on My account link");
	hp.clickMyAccount();
	logger.info("clicking on login link");
	hp.clickLogin();
	LoginPage lp=new LoginPage(driver);
	logger.info("Entering email address");
	lp.setEmail(p.getProperty("email"));
	logger.info("Entering password");
	lp.setPassword(p.getProperty("password"));
	logger.info("Clicking on login button");
	lp.clickLoginBtn();
	logger.info("Validating My account text exists after login or not");
	MyAccountPage ap=new MyAccountPage(driver);
	boolean b= ap.validatingMyAccountText();
	if(b)
	{
   Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test failed");	
		logger.debug("My account text does not exist after login");
		Assert.assertTrue(false);
	}
	}
	catch(Exception e)
	{
		
		Assert.fail();
	}
	logger.info("Completed TC002_LoginTest" );
}
}
