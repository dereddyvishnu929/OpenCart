package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myacc;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement Logoutlink;
	
	public boolean isMyAccExist()
	{
		try
		{
			return(myacc.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void clicklogout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Logoutlink);
		Logoutlink.click();
	}

}
