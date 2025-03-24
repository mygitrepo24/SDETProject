package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;
import utilities.DataProviders;

/*Data is valid-login successsful -testpass -logout
 Data is valid-login failed -testfail
 Data is Invalid-login successsful -testfail -logout
 Data is Invalid-login failed -testpass */


public class TC003_LoginTest_DDT extends BaseTestClass {

	@Test(groups="Datadriven",dataProvider="LoginData",dataProviderClass=DataProviders.class)//getting data provider from different class
	public void loginDataDriven(String email,String pwd,String expres)
	{
		logger.info("starting TC003_LoginDDT");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("clicking on My account link");
		hp.clickMyAccount();
		logger.info("clicking on login link");
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering email address"+email);
		lp.setEmail(email);
		logger.info("Entering password"+pwd);
		lp.setPassword(pwd);
		logger.info("Clicking on login button");
		lp.clickLoginBtn();
		logger.info("Validating My account text exists after login or not");
		MyAccountPage ap=new MyAccountPage(driver);
		AccountLogOutPage alp=new AccountLogOutPage(driver);
		boolean b= ap.validatingMyAccountText();
		if(expres.equalsIgnoreCase("Valid"))
		{
			if(b==true)
			{
			
			ap.clickLogOut();			
			alp.clkBtnContinue();
			Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(expres.equalsIgnoreCase("InValid"))
		{
			if(b==true)
			{
				ap.clickLogOut();
				alp.clkBtnContinue();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
		    Assert.fail();
		}
		finally {
			logger.info("Completed TC003_LoginTest_DDT");
		}
		
		}
	}

