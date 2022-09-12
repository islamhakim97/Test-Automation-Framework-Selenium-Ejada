package com.OrangeHRM.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Base.com.testBase;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.pages.ResetPassword;
import AllureReport.AllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})//add it to each class u want to run with allure Listeners 
public class ResetPasswordTest extends testBase {

	public ResetPasswordTest() throws IOException {
		super();
	}

	LoginPage loginPage;
	ResetPassword resetPassword;
	String date;
	@Parameters({ "Browser" })
	@BeforeMethod(groups={"E2E","Regression"}) //alwaysRun = true to run before TCs when Using groups in xml
	public void setup(Method method, String browser) throws IOException 
	{
		initialization(browser);
		loginPage = new LoginPage();// after you initialize your driver
		/*date=TestUtils.TCstime();
		String name =method.getName()+date;//Assign Date and Time To VideoName
		// Start Take Video :
		TestUtils.StartTakeVideo(name);*/
		// log TestCases Names to Report
		loginPage.getMainPage();
		//TestUtils.LogTCsNamesToREport(name);

	}

	@AfterMethod(groups= {"E2E","Regression"})
	public void tearDown(Method method, ITestResult result) throws IOException // ITestResult is TestNG listener to log test status[pass|fail|skipped]
	{ 
		/*String name =method.getName()+date;//Assign Date and Time To picName
		//  Take SnapShot:
		TestUtils.TakePicture(name);
		TestUtils.Recorder.stop();
		// ** Log Test Status to the Report:
		TestUtils.LogTestStatusToExtentReport(result,name);*/
		driver.quit();

		// driver.close();

	}

	// Forgot Password Functionality
	@Test(priority = 1,groups= {"E2E","Regression"}) // [1-Fail]   
	@Description("Verify Reset Password On LoginPage") // allure Report Notations , seen by allure Report
	@Epic("Epic002")
	@Feature("Feature2:Reset Password")
	@Story("Story: Verify Reset Password")
	@Step("Verify Login ")
	@Severity(SeverityLevel.BLOCKER)
	public void checkForgotPasswordFunctionality() throws IOException {
		resetPassword = loginPage.checkForgotPassword();
		String ER = "Reset Password link sent successfully";
		String AR=resetPassword.checkEmailISent();
		Assert.assertEquals(AR,ER, "You Can't Set a new Password");

	}

}
