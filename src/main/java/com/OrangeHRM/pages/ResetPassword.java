package com.OrangeHRM.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.com.testBase;

public class ResetPassword extends testBase{
	public ResetPassword() throws IOException
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory Elements
	@FindBy(name="username")
	WebElement HRMUsername;
	@FindBy(xpath="//button[text()=' Reset Password ']")
	WebElement ResetPassBtn;
    //Reset Password link sent successfully
	@FindBy(xpath="//h6[text()='Reset Password link sent successfully']")
	WebElement ResetMessage;
	
	
   //Page Factory Methods
	public String checkEmailISent()
	{
		js.executeScript("arguments[0].style.border='3px solid purple'", HRMUsername);
		HRMUsername.sendKeys("Islam Hakim");
		js.executeScript("arguments[0].style.border='3px solid purple'", ResetPassBtn);
		ResetPassBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		js.executeScript("arguments[0].style.border='3px solid purple'", ResetMessage);
		return ResetMessage.getText();
     	
	}
}
