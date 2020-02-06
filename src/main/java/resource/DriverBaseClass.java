package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




//Base class contain all the default driver commands.

public class DriverBaseClass {
	
	
	public WebDriver  driver;
	public	Properties pro;
	FileInputStream fis;
	public WebDriver initriver() throws IOException {
		
		
		pro = new Properties ();
		fis = new FileInputStream("C:\\Users\\Sourabh Mishra\\FrameworkP\\src\\main\\java\\resource\\data.properties");
 
		pro.load(fis);
	
		
		String browserName=pro.getProperty("Browser");

	   if(browserName.equals("chrome")) {
		   
		   System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			 driver = new ChromeDriver();
	   }
	   else if(browserName.equals("FireFox"))
	   {
		   System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	          
           driver = new FirefoxDriver();
		   
	   }
	   else
	   {
		   System.out.println("Browser not found");
	   }
	
	   driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(pro.getProperty("Url"));
		
		return driver;
	
	}
	

}		