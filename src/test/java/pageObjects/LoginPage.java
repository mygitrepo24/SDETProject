package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement btnContinue;
	

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	

	public void clickLoginBtn()
	{
		btnLogin.click();
	}
	
	public void clickContinueBtn()
	{
		btnContinue.click();
	}
	
	
}
