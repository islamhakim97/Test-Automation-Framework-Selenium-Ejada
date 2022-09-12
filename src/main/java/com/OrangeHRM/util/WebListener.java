package com.OrangeHRM.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebListener implements WebDriverEventListener{
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the:"+element.toString()+"Before any changes made");
		//log.debug("Value of the:\"+element.toString()+\"Before any changes made");
		
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element Value Changed To:"+element.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on Element:"+element.toString()+" ");		
		
	}


	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on:"+element.toString());
		
	}
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying To Find Element By : "+by.toString()+"");		
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : "+by.toString());		
		
	}


	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating Back to the previous page");		
		
	}

	public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated Back to the previous page");		
		
	}
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before NavigatingTo:"+url+"");
		
	}
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigated To:"+url+"");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating Back to the Next page");		
		
	}


	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated Forward( to the Next page");		
		
	}


	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Trying To Switch To Window : "+ windowName);		
		
	}
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Switching to Window"+windowName.toString()+"");		
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception Occure: May be [Can not find Element] Or[ something else .. Ivestigate!] "+ throwable);		
		
	}
	

}



