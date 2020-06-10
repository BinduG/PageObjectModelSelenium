package com.lakme.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lakme.basesetup.BaseSetup;

public class LandingPageRepo extends BaseSetup{
	
	
	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement loginButton;
	
	public LandingPageRepo() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPageRepo clickLoginButton() {
	
		loginButton.click();
		
		return new LoginPageRepo();
		
	}
	
	

}
