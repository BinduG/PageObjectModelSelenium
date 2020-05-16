package com.lakme.Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.lakme.basesetup.BaseSetup;

public class BasesetupTestCases extends BaseSetup {
	
	
	public BasesetupTestCases() {
		
		super();
	}
	
	@BeforeTest
	public void setup() {
		
		initializeDriver();
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
	

}
