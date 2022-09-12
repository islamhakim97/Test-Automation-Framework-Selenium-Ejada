package com.Base.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.OrangeHRM.util.WebListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	public static WebDriver driver; // Glopal driver
	public static JavascriptExecutor js;
	public static Properties prop;
	public static EventFiringWebDriver e_driver; // For logging Purpose
	public static WebListener weblistener;
	public static ExtentReports extent;
	public static ExtentTest logger;// to log each test in the Report
    public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();//For synchronized WebDriver - Thread To share The Driver Between Multiple Files
	public testBase() throws IOException {
		prop = new Properties();
		String projectPath=System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				projectPath+"/Data/config.properties");
		prop.load(fis);

	}

	public WebDriver initialization(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
     		 driver = new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver","D:\\Web Automation Using Selenium\\BrowsersDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
              WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
			//System.setProperty("webdriver.gecko.driver","D:\\Web Automation Using Selenium\\BrowsersDrivers\\geckodriver.exe");
			//driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			//headless Browser Testing
		} else if (browser.equalsIgnoreCase("headless")) {
		    DesiredCapabilities caps=new DesiredCapabilities();
		    caps.setJavascriptEnabled(true);
		    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\Eclipse\\OrangeAllureReport\\drivers\\phantomjs.exe ");
		    String[] PhantomjsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
		    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, PhantomjsArgs);
			 driver = new PhantomJSDriver(caps); 
		
		}else if (browser.equalsIgnoreCase("chrome-headless")) {
			 WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","D:\\Web Automation Using Selenium\\BrowsersDrivers\\chromedriver.exe");
		   ChromeOptions options=new ChromeOptions();
		   options.addArguments("--headless");
		   options.addArguments("--window-size=1920,1080");
		   driver = new ChromeDriver(options); 
		}else if (browser.equalsIgnoreCase("safari")) {
			/*
			 * Configure safari driver Manually first in your MacbookAir : (Open terminal :
			 * [run 'cd usr/bin , safaridriver --enble', enable remote automation on
			 * safari-Deceloper , close any safari browser before start testing as safari
			 * not permit to instantiate more than safari browser in the same time] )
			 */
			driver = new SafariDriver();
		}
		
		// For web Driver listener
		e_driver = new EventFiringWebDriver(driver);
		weblistener = new WebListener();
		e_driver.register(weblistener);
		driver = e_driver;
		tdriver.set(driver);
		// driver.get(prop.getProperty("URL")) ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = ((JavascriptExecutor) driver);
		return getDriver();
	}
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}

}
