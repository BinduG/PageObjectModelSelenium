package com.lakme.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lakme.basesetup.BaseSetup;

public class ForgotPasswordRepo extends BaseSetup {
	
	
	public String expectedPwdResetLinkSentMsg = "Thank you. If this account is registered you will receive an email with a password reset link.";
	
	@FindBy(name="email")
	public WebElement emailID;
	
	@FindBy(xpath = "//button[@name='action']")
	public WebElement resetPasswordButton;
	
	@FindBy(xpath = "//div[@class='field']")
	public WebElement pwdResetLinkSentMsg;
	
	public ForgotPasswordRepo() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailID(String mailID) {

		emailID.sendKeys(mailID);
		
	}
	
	public void clickResetPasswordButton()
	{
		resetPasswordButton.click();
	}
	
	public String actualPwdResetLinkSentMsg() {
		
		String actualMsg = pwdResetLinkSentMsg.getText();
		
		return actualMsg;
	}
	 
}
