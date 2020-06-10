package com.lakme.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.lakme.basesetup.BaseSetup;

public class HomePageRepo extends BaseSetup{
	
	
	public String homePageUrl = "https://ui.freecrm.com/";
	
	public HomePageRepo() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageUrl() {
		
		String actualUrl = driver.getCurrentUrl();
		
		return actualUrl;
	}

}
