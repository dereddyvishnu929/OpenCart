package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_001_AccountRegistration extends BaseClass 
{
	
	@Test(groups= {"Regression","Master"})
	void test_account_registration()
	{
		
		logger.info("*** Starting Tc_001_AccountRegistration ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		logger.info("Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpg=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
		regpg.setfirstname("abc");
		
		regpg.setlasttname("abc");
		
		regpg.setemail(randomString()+"@gmail.com");
		
		regpg.settelephone(randomNumber());
		
		String pwd=randomAlphaNumeric();
		
		regpg.setpassword(pwd);
		
		regpg.setconfirmpassword(pwd);
		
		regpg.setprivacypolicy();
		
		regpg.clickcontinue();
		logger.info("Clicked on Continue button");
		
		String conmsg=regpg.configmsgconfirmation();
		logger.info("Validating expected message");
		
		Assert.assertEquals(conmsg, "Your Account Has Been Created!", "Test Failed");
		}
		catch(Exception e)
		{
			logger.info("Test Failed");
			Assert.fail();
		}
		
		logger.info("*** Finished Tc_001_AccountRegistration *** ");
	}
	
	

}
