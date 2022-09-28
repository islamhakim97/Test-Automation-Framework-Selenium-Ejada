package Grid;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.com.testBase;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginOnLinuxUsingFirefox extends testBase {
	
	public LoginOnLinuxUsingFirefox() throws IOException {
		super();
	}
	//WebDriver Griddriver;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod()
	public void setup() throws IOException
	{
		initialization("Grid-linux-firefox");// Using Grid With Chrome and Windows Capabilities
		loginPage = new LoginPage();// after you initialize your driver
		loginPage.getMainPage();
	}
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority=1) 
	
	public void testLogo() 
	{
		
		boolean actualResult=loginPage.checkLogo();
		Assert.assertEquals(actualResult, true, "Logo is not Found");//true for make it pass 
	}

}
