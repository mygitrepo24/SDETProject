package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AccountLogOutPage extends BasePage {

	public AccountLogOutPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='pull-right']//a")
	WebElement btnContinue;
	
	public void clkBtnContinue()
	{
		btnContinue.click();
	}
}
