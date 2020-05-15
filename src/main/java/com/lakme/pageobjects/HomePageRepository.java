package com.lakme.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageRepository {
	
	WebDriver driver;
	
	public HomePageRepository(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	@FindBy(css=".icon icon-customer")
	WebElement loginIcon;
	

}
