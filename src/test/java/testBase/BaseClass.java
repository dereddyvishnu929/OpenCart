package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger; //for logging
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config"); //load config properties
		
		logger=LogManager.getLogger(this.getClass());
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appUrl"));
		
		//driver.get("http://localhost/opencart/upload/index.php");
		//driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void logout()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	public String CaptureScreen(String tname)
	{
		//SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		//Date dt=new Date();
		//String timestamp=df.format(dt);
		
		String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") + "\\screenShots\\" + tname + "_" + timestamp + ".png";
		
		try
		{
			FileUtils.copyFile(source, new File(destination));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return destination;

	}

}

