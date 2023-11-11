package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	
	@Test(groups= {"Sanity","Master"})
	public void testlogin()
	{
		try
		{
		logger.info("*** Starting TC_002_LoginTest ***");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		logger.info("Clicked on My Account");
		
		hp.loginlink(); 
		logger.info("Clicked on login link");
		
		logger.info("Providing login details");
		LoginPage lp=new LoginPage(driver);
		lp.setemail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		
		lp.clicklogin();
		logger.info("Clicked on login button");
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccExist();
		Assert.assertEquals(targetpage, true, "invalid login data");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** Finish TC_002_LoginTest ***");
				
	}

}
