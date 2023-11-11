package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDTest extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void login_DDTest(String email, String password, String res)
	{
		logger.info("*** Starting TC_003_LoginDDTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		hp.loginlink(); 
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(password);
		lp.clicklogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccExist();
		
		if(res.equals("valid"))
		{
			if(targetpage==true)
			{
				macc.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
		
		if(res.equals("invalid"))
		{
			if(targetpage==false)
			{
				macc.clicklogout();
				Assert.fail();
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** Finished TC_003_LoginDDTest ***");
		
	}

}
