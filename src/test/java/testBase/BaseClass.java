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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
  public static WebDriver driver;
  
  public Logger logger;
  
  public Properties p;
	
	@BeforeClass(groups = "Regression")
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
			System.out.println("remote envv....");
			String huburl= "http://localhost:4444/wd/hub";
			
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
			cap.setPlatform(Platform.WIN11);
			}
			else if	(os.equalsIgnoreCase("MAC"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("wrong os");
				return;
			}
				
				
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
			default : System.out.println("no matching browser"); return;
				
			}
				
				URL url = new URL(huburl);
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
		driver.get(p.getProperty("url"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
	}

	@AfterClass
	public void tearDown()
	{
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
		 String targetFilePath = System.getProperty("user.dir")+"\\screenshots"+fname +"_"+timestamp+".png";
		 File targetFile = new File(targetFilePath);
		 sourceFile.renameTo(targetFile);
		 
		 return targetFilePath;
	 }
}
