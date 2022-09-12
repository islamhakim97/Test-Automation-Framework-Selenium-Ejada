package com.OrangeHRM.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.com.testBase;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;

import com.OrangeHRM.util.TestUtils;

import AllureReport.AllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Listeners({AllureListener.class})
public class LoginPageTest extends testBase {

	public LoginPageTest() throws IOException {
		super();

	}

	LoginPage loginPage;
	HomePage homePage;
	String date;

	@Parameters({ "Browser" })
	@BeforeMethod(groups= {"E2E","Regression"})
	public void setup(Method method, String browser) throws IOException

	{
		initialization(browser);
		loginPage = new LoginPage();// after you initialize your driver
		/*date=TestUtils.TCstime();
		String name =method.getName()+date;//Assign DAte and Time To videoname
		System.out.println(name);

		// Start Take Video :
		TestUtils.StartTakeVideo(name);*/
		loginPage.getMainPage();
		/* Log TCs Name To ExtentReport
	//	System.out.println(name);
		TestUtils.LogTCsNamesToREport(name);
		//System.out.println(name);*/

	}

	@AfterMethod(groups= {"E2E","Regression"})
	public void tearDown(Method method, ITestResult result) throws IOException // ITestResult is TestNG listener to log test																										// status[pass|fail|skipped]

	{
		
		/*String name =method.getName()+date;//Assign Date and Time To picName
		System.out.println(name);
		//Take SnapShot:
		TestUtils.TakePicture(name);
		//Stop Video
		TestUtils.Recorder.stop();
		//Log Test Status to the Report
		TestUtils.LogTestStatusToExtentReport(result,name);*/

		driver.quit();

		// driver.close();

	}

	// Login TCs
	@Test(priority = 1,groups= {"E2E","Regression"}) //[retryAnalyzer = [automateRetryFailedTests.RetryAnalyzer.class] The 1st way For retry Failed Tests]  groups= {"Regression"},alwaysRun = true 
	@Description("Verify Valid Login On LoginPage") // allure Report Notations , seen by allure Report
	@Epic("Epic001")
	@Feature("Feature2:Login")
	@Story("Story: Valid Login")
	@Step("Verify Login ")
	@Severity(SeverityLevel.BLOCKER)
	public void PerformValidLoginTest() throws IOException { //[1-Fail]
		String validUser = prop.getProperty("username");
		String validpass = prop.getProperty("password");
		homePage = loginPage.performValidLogin(validUser, validpass);
		boolean Ar = homePage.DashboardisDisplayed();
		Assert.assertTrue(Ar, "Login Fail , In correct Username Or Password");
	}

	@Test(priority = 2, dataProvider = "testLoginData") // ,dataProvider="testLoginData" [4 Pass]
	@Description("Verify UnValid Login On LoginPage") // allure Report Notations 
	@Epic("Epic001")
	@Feature("Feature2:Login")
	@Story("Story: Un Valid Login")
	@Step("Verify Login ")
	@Severity(SeverityLevel.NORMAL)
	public void CheckLoginwithInvalidPasswordOrmail(String mail, String pass) throws IOException// String fname,String
																								// lname
	{
		loginPage.performLoginWithInvalidData(mail, pass);
		boolean actualResult = loginPage.InvalidCredentialsIsDisplayed();
		// ASsert User can't Login with invalid Credentials
		Assert.assertEquals(actualResult, true, "Login Success , With invalid Username Or Password");

	}
	@Test(priority=3,groups={"E2E"}) //[retryAnalyzer = automateRetryFailedTests.RetryAnalyzer.class] The 1st way For retry Failed Tests
	@Description("Verify Logo Prescence On LoginPage") // allure Report Notations 
	@Epic("Epic001")
	@Feature("Feature1:Logo")
	@Story("Story: Logo Presence")
	@Step("Verify Logo Prescence ")
	@Severity(SeverityLevel.MINOR)
	public void testLogo() //2-Fail
	{
		boolean actualResult=loginPage.checkLogo();
		Assert.assertEquals(actualResult, false, "Logo is not Found");//true for make it pass 
	}
	@Test(priority=4,groups={"E2E"})
	@Description("Verify URL OF LoginPage") // allure Report Notations 
	@Epic("Epic001")
	@Feature("Feature3:URL")
	@Story("Story: Check URL")
	@Step("Verify URL ")
	@Severity(SeverityLevel.BLOCKER)
	public void testURL()
	{
		String AR=loginPage.getURL();
		String ER="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(AR, ER, "URL is not Correct");
	}
	@Test(priority=4,groups={"E2E"})
	@Description("Verify TitLe OF LoginPage") // allure Report Notations 
	@Epic("Epic001")
	@Feature("Feature4:Title")
	@Story("Story: Check Title")
	@Step("Verify Title ")
	@Severity(SeverityLevel.TRIVIAL)
	public void testTitle()
	{
		String AR=loginPage.getTitle();
		String ER="OrangeHRM";
		Assert.assertEquals(AR, ER, "Title is not Correct");
	}

	@DataProvider( )//parallel=true when u use parallel execution with data providers parallel=true--> @DataProvider(parallel=true )
	public Object[][] testLoginData() throws IOException {
		// if you ** change the file name **[don't forget to change the File Path ]in
		// the getDataFromExcel Method
		// AND [pass the correct sheet name to getDataFrom Excel Method]].
		String ExcelSheetname = "Sheet1";// "FbLoginData";//"RegisterDataSheet";
		Object[][] data = TestUtils.getDataFromExcel(ExcelSheetname);
		return data;
	}

}
