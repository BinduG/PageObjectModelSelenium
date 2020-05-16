package com.lakme.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lakme.basesetup.BaseSetup;

public class FlightsPageRepository extends BaseSetup {

	
	
	//Page Factory
	
	@FindBy(id="oneway")
	public WebElement oneWay;
	
	@FindBy(id="roundTrip")
	public WebElement roundTrip;
	
	@FindBy(id="multiCity")
	public WebElement multiCity;
	
	//Initializing page objects
	
	public FlightsPageRepository() {
		
		PageFactory.initElements(driver, this);
	}

	//Page Actions
	public void clickonewaybutton() {
		
		oneWay.click();
	}
	
	public void clickroundTripbutton() {
		
		roundTrip.click();
	}
	
	public void clickmultiCitybutton() {
		
		multiCity.click();
	}
}
