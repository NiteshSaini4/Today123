package Test_Case_File;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import Utilities_File.ReadConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	ReadConfiguration rc=new ReadConfiguration();
	String browser=rc.getbrowser();//chrome
	String url=rc.geturl();//
	@BeforeTest
	void browserLaunch()
	{
		switch(browser.toLowerCase())
		{
			case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
			case "msedge":
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
			
			case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			default:
				driver=null;
				break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	public  void  ScreenShot() throws IOException
	{
			
		File Source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\user\\Desktop\\Data_DrivenFrame\\ScreenShot\\z1.png");
		FileUtils.copyFile(Source, Destination);
		
	}

}
