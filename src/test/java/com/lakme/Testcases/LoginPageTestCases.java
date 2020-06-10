package com.lakme.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lakme.basesetup.BaseSetup;
import com.lakme.pageobjects.ForgotPasswordRepo;
import com.lakme.pageobjects.HomePageRepo;
import com.lakme.pageobjects.LandingPageRepo;
import com.lakme.pageobjects.LoginPageRepo;
import com.lakme.util.TestUtil;

public class LoginPageTestCases extends BaseSetup{

	public LoginPageRepo loginpage;

	public LandingPageRepo landingpage;

	public HomePageRepo homepage;
	
	public ForgotPasswordRepo forgotpwd;



	public LoginPageTestCases() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initializeDriver();

		landingpage = new LandingPageRepo();



	}

	
	  @AfterMethod public void tearDown() {
	  
	  driver.quit(); }
	 

	@DataProvider
	public Object[][] getvalidcredentials() throws Exception{

		Object[][] data = TestUtil.getTestData("validLoginCredentials");

		return data;

	}


	@DataProvider 
	
	public Object[][] getinvalidpassword() throws Exception{

		Object[][] data = TestUtil.getTestData("InvalidPassword");

		return data;

	}
	
	@DataProvider 
	
	public Object[][] getinvalidemail() throws Exception{

		Object[][] data = TestUtil.getTestData("Invalidusername");

		return data;

	}
	
	@DataProvider public Object[][] get_TC_Login_06_TestData() throws Exception{

		Object[][] data = TestUtil.getTestData("TC_Login_06");

		return data;

	}


	@Test(dataProvider = "getvalidcredentials")
	public void TC_Login_01_Test(String emailID, String password) {

		loginpage = landingpage.clickLoginButton();

		loginpage.enterEmailID(emailID);

		loginpage.enterPassword(password);

		homepage = loginpage.submitlogin();

	}


	@Test(dataProvider = "getinvalidpassword") 
	public void TC_Login_02_Test(String emailID, String password){

		loginpage = landingpage.clickLoginButton();

		loginpage.enterEmailID(emailID);

		loginpage.enterPassword(password);

		loginpage.submitlogin();

		Assert.assertEquals(loginpage.actualLoginFailuerMsg(), loginpage.expectedLoginFailuerMsg);

	}
	
	@Test(dataProvider = "getinvalidemail") 
	public void TC_Login_03_Test(String emailID, String password){

		loginpage = landingpage.clickLoginButton();

		loginpage.enterEmailID(emailID);

		loginpage.enterPassword(password);

		loginpage.submitlogin();

		Assert.assertEquals(loginpage.actualLoginFailuerMsg(), loginpage.expectedLoginFailuerMsg);

	}

	@Test(dataProvider = "getvalidcredentials") 
	public void TC_Login_04_Test(String emailID, String password){

		loginpage = landingpage.clickLoginButton();

		loginpage.enterPassword(password);

		loginpage.submitlogin();

		Assert.assertEquals(loginpage.actualInvalidLoginReqMsg(),loginpage.expectedInvalidLoginReqMsg);

	}
	
	@Test(dataProvider = "getvalidcredentials") 
	public void TC_Login_05_Test(String emailID, String password){

		loginpage = landingpage.clickLoginButton();

		loginpage.enterEmailID(emailID);

		loginpage.submitlogin();

		Assert.assertEquals(loginpage.actualInvalidLoginReqMsg(),loginpage.expectedInvalidLoginReqMsg);

	}
	
	@Test(dataProvider = "get_TC_Login_06_TestData")
	public void TC_Login_06_Test(String emailID) {
		
		loginpage = landingpage.clickLoginButton();
		
		forgotpwd = loginpage.clickForgotPasswordLink();
		
		forgotpwd.enterEmailID(emailID);
		
		forgotpwd.clickResetPasswordButton();
		
		Assert.assertEquals(forgotpwd.actualPwdResetLinkSentMsg(),forgotpwd.expectedPwdResetLinkSentMsg);
			
			
		}
	
	}




