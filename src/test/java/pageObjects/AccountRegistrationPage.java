package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//in pageclasses we have constructor locators and action methods
//.we donot do ant validations in pageobject classes.we do only in test cases
public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "input-firstname")
	WebElement txtFname;

	@FindBy(id = "input-lastname")
	WebElement txtLname;

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-telephone")
	WebElement txtTelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtConfirmpwd;

	@FindBy(xpath = "//input[@value=0]")
	WebElement chkNo;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement accCreationMsg;

	public void setFirstName(String fname) {
		txtFname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String phonenum) {
		txtTelephone.sendKeys(phonenum);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		txtConfirmpwd.sendKeys(password);
	}

	public void setCheck() {
		chkNo.click();
	}

	public void setChkPolicy() {
		chkPolicy.click();
	}

	public void clickContinueBtn() {
		btnContinue.click();
	}

	public String getAccountCreationSuccessMsg() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement accCreationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")));
			return accCreationMsg.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
