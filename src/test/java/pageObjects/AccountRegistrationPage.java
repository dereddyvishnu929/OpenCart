package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfiguration;
	
	
	//action methods
	public void setfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setlasttname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void settelephone(String tele)
	{
		telephone.sendKeys(tele);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void setconfirmpassword(String confirmpwd)
	{
		confirmpassword.sendKeys(confirmpwd);
	}
	
	public void setprivacypolicy()
	{
		agree.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	
	public String configmsgconfirmation()
	{
		try
		{
			return(msgconfiguration.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	

}
