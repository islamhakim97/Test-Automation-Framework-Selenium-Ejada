package com.OrangeHRM.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.com.testBase;




public class HomePage extends testBase{

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this); // creates the findElement calls behind the scene.
	}
	//Put Elements Of The HomePage with PageFactory Object Technique
	
    @FindBy(linkText="Dashboard")
    WebElement Dashboard;
	
	
	//Put Methods Of The HomePage with PageFactory Object Technique
	public boolean DashboardisDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("arguments[0].style.border='3px solid purple'", Dashboard);
		return Dashboard.isDisplayed();
	}

}
