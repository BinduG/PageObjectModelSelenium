package com.lakme.basesetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {

	public WebDriver driver;

	@Test
	public WebDriver initializeDriver() throws IOException {


		//Getting current project directory location and storing in propertiesFileLoaction variable 

		String propertiesFileLoaction = System.getProperty("user.dir");

		//creating object for Properties class
		Properties prop = new Properties();

		//creating object for FileInputStream
		FileInputStream fis = new FileInputStream(propertiesFileLoaction+"\\resources\\data.properties");

		//Loading data.properties file
		prop.load(fis);

		//Getting browser name from properties file

		String browserName = prop.getProperty("browserName");

		//Invoking Browser

		if(browserName.equalsIgnoreCase("GoogleChrome"))
		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
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

		//Navigate to URL
		driver.get(prop.getProperty("URL"));

		//Setting implicit timeout
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//Maximizing Browser
		driver.manage().window().maximize();

		//returning driver object
		return driver;

	}


}
