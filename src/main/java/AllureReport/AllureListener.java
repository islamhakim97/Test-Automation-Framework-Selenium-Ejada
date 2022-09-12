package AllureReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.com.testBase;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener{


	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Iam onTestFailure method "+getTestMethodName(iTestResult)+"failed");
		Object testClass=iTestResult.getInstance();//keep an instance
		WebDriver driver=testBase.getDriver();
		//Allure ScreenShot and SaveTestLog
		if(driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case: " +getTestMethodName(iTestResult));
			saveFailureScreenShot(driver);
		}
		saveTextLog(getTestMethodName(iTestResult)+" failed and screenshot taken! ");
	}

	public static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	@Attachment(value= "{0}",type="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}

	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method "+iTestContext.getName());
		
		
	}

	public void onStart(ITestContext iTestContext) {
		
		System.out.println("I am in onStart method "+iTestContext.getName());
		iTestContext.setAttribute("WebDriver", testBase.getDriver());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("I am in onTestFailedButWithinSuccessPercentage "+ getTestMethodName(iTestResult) +"FailedButWithinSuccessPercentage");

		
	}


	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method "+ getTestMethodName(iTestResult) +"Skipped");
		
	}

	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method "+ getTestMethodName(iTestResult) +"start");
		
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method "+ getTestMethodName(iTestResult) +"Success");
		
	}

}
