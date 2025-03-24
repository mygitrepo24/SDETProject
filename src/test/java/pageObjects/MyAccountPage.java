package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMsg;
	
	@FindBy(xpath="//div[@class='list-group']//a[normalize-space()='Logout']")
	WebElement logOut;
	public void clickLogOut()
	{
		logOut.click();
	}
	public boolean validatingMyAccountText()
	{
		try {
		return(txtMsg.isDisplayed());
	}
		
		
catch(Exception e)
		{
  return false;
		}
		
}
}