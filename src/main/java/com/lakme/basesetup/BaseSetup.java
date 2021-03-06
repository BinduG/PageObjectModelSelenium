package com.lakme.basesetup;

import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lakme.util.TestUtil;
import com.lakme.util.TestListenerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public static EventFiringWebDriver eventFiringDriver;
	
	public static TestListenerUtil eventListener;
	
	public static Logger log;
	
	
	public BaseSetup()  {
		
		      

				//<!----------------creating object for Properties class-------------------------------->
		
				prop = new Properties();

				//creating object for FileInputStream
				FileInputStream fis;
				try {
					fis = new FileInputStream(TestUtil.projectpath+TestUtil.propertiesFileLocation);
				
					prop.load(fis);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				//<!------------------------Creating Object for log4j------------------------------>
				
				log = LogManager.getLogger();			

	}

	public void initializeDriver() {
		
		String browserName = prop.getProperty("browserName");

		//Invoking Browser

		if(browserName.equalsIgnoreCase("GoogleChrome"))
		{
			log.info("Setting up ChromeDriver");
			
			WebDriverManager.chromedriver().setup();
			
			log.info("Chrome Driver Setup completed");

			driver = new ChromeDriver();
			
			log.info("Chrome Browser is invoked");
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("InternetExplorer")) {

			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Failed to invoke" +browserName+ "browser");
		}
		
		
		eventFiringDriver = new EventFiringWebDriver(driver);
		
		eventListener = new TestListenerUtil();
		
		eventFiringDriver.register(eventListener);
		
		driver = eventFiringDriver;
		
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageloadTimeout, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));
	

	}

}
