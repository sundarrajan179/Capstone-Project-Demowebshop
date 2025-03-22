package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

	public static WebDriver driver;
	 public static void getBrowser() 
	  {
		 Properties prop = PropertyReader.readProperty();
		  switch(prop.getProperty("Browser"))
		  {
		  case "chrome":
			  driver =new ChromeDriver();
			  break;
		  case "firefox":
			   driver =new FirefoxDriver();
			  break;
		  case "safari":
			    driver =new SafariDriver();
			  break;
			  default:
			  System.out.println("Unknown browser found");
		  }
		  driver.manage().window().maximize();  
	  }
	 public static void getUrl() {
		 Properties prop = PropertyReader.readProperty();
		 driver.get(prop.getProperty("URL"));
	 }
	 
}
