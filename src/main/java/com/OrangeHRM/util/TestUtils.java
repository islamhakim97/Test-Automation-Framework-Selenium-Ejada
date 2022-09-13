package com.OrangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.Base.com.testBase;
import com.relevantcodes.extentreports.LogStatus;


public class TestUtils extends testBase {
	//private static final String Tctime = TCstime();
	//public static ATUTestRecorder Recorder;
	
	public TestUtils() throws IOException {
		super();
		
	}
    //Date And Time For Tc
	
	// Take SnapShot
	public static void TakePicture(String name) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// assign date and time to tcName
		String projectPath=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(projectPath+"/TestReport/" + name+ ".png"));
	}

	/*// Start Take Video
	public static void StartTakeVideo(String videoname) throws ATUTestRecorderException {

		TestUtils.TakeVideo(videoname);
		TestUtils.Recorder.start();

	}

	// Take Video
	public static void TakeVideo(String videoname) throws ATUTestRecorderException {
		
		Recorder = new ATUTestRecorder("D:\\Eclipse\\OrangeAllureReport\\TestReport", videoname, false);
	}

	// log TestCases Names to Report
	public static void LogTCsNamesToREport(String videoname) {
		logger = extent.startTest(videoname);
	}*/

	public static void LogTestStatusToExtentReport(ITestResult result,String name) {
		// ** Log Test Status to the Report:
		// *** For adding Test Status To the Extent Report:
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Pass");
			// Add Snapshots to the Report in case of success
			//System.out.println(result.getName());
			logger.log(LogStatus.PASS, "<a href='" + name + ".png"
					+ "'><span class='label info'>Download Snapshot</span></a>");
			// Add Video to the Report
			logger.log(LogStatus.PASS,
					"<a href='" + name + ".mov" + "'><span class='label info'>Download Video</span></a>");

		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable());
			// Add Snapshots to the Report in case of failure
			logger.log(LogStatus.FAIL, "<a href='" + name + ".png"
					+ "'><span class='label info'>Download Snapshot</span></a>");
			// Add Video to the Report
			logger.log(LogStatus.PASS,
					"<a href='" + name+ ".mov" + "'><span class='label info'>Download Video</span></a>");
		//	System.out.println(result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Skipped");
			//System.out.println(result.getName());
		}
	}
	
	//Data And Time For TCs
	public static String TCstime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");  
	    Date date = new Date();  
	    String str=formatter.format(date);
		return str; 
	}

	public static Object[][] getDataFromExcel(String ExcelSheetename) throws IOException {
		// "/Volumes/IslamHakim/Data Excel Sheets/LoginData.xlsx"
		String projectPath=System.getProperty("user.dir");
		File file = new File(projectPath+"/Data/LoginData.xlsx");
		FileInputStream fis2 = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis2);

		XSSFSheet sheet = workbook.getSheet(ExcelSheetename);
		int rows = sheet.getLastRowNum(); // num of rows
		int columns = sheet.getRow(0).getLastCellNum(); // num of columns
		Object[][] data = new Object[rows][columns];
		// Get Data from Excel sheet
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;

	}

}