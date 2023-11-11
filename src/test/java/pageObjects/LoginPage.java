package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	public void setemail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btn_login.click();
	}
	
	
	
	
	

}
