package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//in pageclasses we have constructor locators and action methods
//.we donot do ant validations in pageobject classes.we do only in test cases
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogin;
	
	
public void clickMyAccount()
{
	lnkMyAccount.click();
}
public void clickRegister()
{
	lnkRegister.click();
}
public void clickLogin()
{
	lnkLogin.click();
}
}