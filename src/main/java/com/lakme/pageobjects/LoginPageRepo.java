package com.lakme.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lakme.basesetup.BaseSetup;

public class LoginPageRepo extends BaseSetup {

	public String expectedPageTitle = "Cogmento CRM";

	public String expectedLoginFailuerMsg = ("Something went wrong...\n" + "Invalid login");
	
	public String expectedInvalidLoginReqMsg = ("Something went wrong...\n" + "Invalid request");

	@FindBy(name = "email")
	public WebElement emailtextbox;

	@FindBy(name = "password")
	public WebElement passwordtextbox;

	@FindBy(css = "div[class*='submit button']")
	public WebElement loginButton;

	@FindBy(css = "div[class = 'ui negative message']")
	public WebElement invalidLoginmessage;
	
	@FindBy(css = "div[class = 'ui negative message']")
	public WebElement invalidLoginRequestmessage;

	@FindBy(css = "span[class='user-display']")
	public WebElement userDisplayName;
	
	@FindBy(xpath="//*[contains(@href,'/password/reset/request/')]")
	public WebElement forgotPassword;

	public LoginPageRepo() {

		PageFactory.initElements(driver, this);
	}

	public void enterEmailID(String emailID) {

		emailtextbox.sendKeys(emailID);

	}

	public void enterPassword(String password) {

		passwordtextbox.sendKeys(password);
	}

	public  HomePageRepo submitlogin() {

		loginButton.click();

		return new HomePageRepo();

	}

	public String loginPageTitle() {

		String actualLoginPageTitle = driver.getTitle();

		return actualLoginPageTitle;
	}

	public String actualLoginFailuerMsg() {

		String loginFailuerMessage = invalidLoginmessage.getText();

		return loginFailuerMessage;
	}

	public String actualInvalidLoginReqMsg() {

		String actualloginInvalidReqMessage = invalidLoginRequestmessage.getText();

		return actualloginInvalidReqMessage;
	} 

	public String getDisplayName() {

		String displayName = userDisplayName.getText();

		return displayName;
	}
	
	public ForgotPasswordRepo clickForgotPasswordLink() {
		
		forgotPassword.click();
		
		return new ForgotPasswordRepo();
	}






}
