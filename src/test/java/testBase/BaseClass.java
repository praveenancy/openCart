package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
  public static WebDriver driver;
  
  public Logger logger;
  
  public Properties p;
	
	//@BeforeClass(groups = "Regression")
	@BeforeMethod(groups = "Regression")
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		//load the properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		// generating the logs
		logger = LogManager.getLogger(this.getClass());
		
		//switching the broswer based on parameter
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
	
			logger.info("remote env");
			String huburl= "http://localhost:4444/wd/hub";
			
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				logger.info("windows platform");
			cap.setPlatform(Platform.WIN11);
			}
			else if	(os.equalsIgnoreCase("MAC"))
			{
				logger.info("mac platform");
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				logger.info("wrong os is selected");
				return;
			}
				
				
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome");logger.info("chrome"); break;
			case "edge" : cap.setBrowserName("MicrosoftEdge");logger.info("edge"); break;
			default : logger.info("wrong browser"); return;
				
			}
				
				URL url = new URL(huburl);
				logger.info("Url is passing here");
			      driver = new RemoteWebDriver(url,cap);
				
				
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			System.out.println("local envv....");
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default : System.out.println("invaid browser"); return;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Url is passing here: "+p.getProperty("url"));
		driver.get(p.getProperty("url"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
	}

	
	
	@AfterMethod
	public void tearDown()
	{
		logger.info("closing the browser");
		driver.quit();
	}
	
public String randomString() {
		
		String randomString=RandomStringUtils.randomAlphabetic(5);
		
		return randomString;
	}
	 public String randomNumber() {
		String number= RandomStringUtils.randomNumeric(10);
		
		return number;
	 }

	 public String captureScreen(String fname) {
		 
		 
		String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 
		 File sourceFile=	ts.getScreenshotAs(OutputType.FILE);
		 String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+fname +"_"+timestamp+".png";
		 File targetFile = new File(targetFilePath);
		 sourceFile.renameTo(targetFile);
		 
		 return targetFilePath;
	 }
}
