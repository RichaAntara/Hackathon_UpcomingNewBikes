package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public Properties p;
	
	
	@BeforeTest(groups= {"sanity","regression"}) 
	@Parameters({ "os","browser" })
	public void setup(String os,String br ) throws IOException {
		
		//loading properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p= new Properties();
		p.load(file);
		
		
		//Loading log4j2 file
		logger =LogManager.getLogger(Test.class);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){	
 
			DesiredCapabilities capabilities=new DesiredCapabilities();
 
			//OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
 
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
 
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
 
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
			return;
			}
		}
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				
				driver.get(p.getProperty("appURL"));
				driver.manage().window().maximize();
	}
	
	
	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\ExtendReportScreenShot\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath; 

	}
	
	public String randomStrNum() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNum = RandomStringUtils.randomNumeric(3);
		String strnum = generatedString + generatedNum + "@gmail.com" ;
		return (strnum);
	}
	
	@AfterTest (groups= {"sanity","regression"})
	public void teardown() {
	driver.quit();
	}

}


