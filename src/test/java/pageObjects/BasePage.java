  package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//BasePage includes only  constructor.this class will be extended and this constructor will be invoked by every page object class for reusability
public class BasePage {
public WebDriver driver;

public BasePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}
