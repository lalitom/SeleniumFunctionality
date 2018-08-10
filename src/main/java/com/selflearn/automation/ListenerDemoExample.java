package com.selflearn.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListenerDemoExample implements ITestListener {

	WebDriver driver=null;
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Screen shot captured====="+arg0.toString());
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("TestCase started====" +arg0.toString());
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Congrates Testcase has been passed===="+ arg0.toString());
		
	}
	
	@Test
	public void GoogleTest()
	{   
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("harvard");
		driver.findElement(By.name("btnK")).click();
		System.out.println("The Page title "+driver.getTitle());
		driver.navigate().back();
		driver.close();
	}
	

}
