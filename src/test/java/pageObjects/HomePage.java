package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement acc_link;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
     WebElement reg_link;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login_link;
	
	//Action Methods
	
	public void clickMyAccout()
	{
		acc_link.click();	
	}
	
	public void clickRegister()
	{
		reg_link.click();
	}

	public void loginlink()
	{
		login_link.click();
	}
	

}
