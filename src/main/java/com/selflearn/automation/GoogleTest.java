package com.selflearn.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	
	WebDriver driver=null;
	String text="Harvard";
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		
	}
	@Test(enabled=false)
	public void verifyPageTitleTest()
	{
		String title= driver.getTitle();
		System.out.println("the title of the page is "+title);
		
	}
	@Test(enabled=false)
	public void verifysearchbox()
	{
		boolean searhbox= driver.findElement(By.id("lst-ib")).isDisplayed();
		System.out.println("the element is present "+searhbox);
		
		
	}
	
	@Test (priority = 0)
	public void verifysearchButton()
	{
		boolean searchbutton= driver.findElement(By.name("btnK")).isDisplayed();
		System.out.println("the element is present "+searchbutton);
		
		
	}
	@Test(enabled=false)
	public void verifyvoicebutton()
	{
		boolean isenabled= driver.findElement(By.id("gsri_ok0")).isEnabled();
		System.out.println("the element is enabled "+isenabled);
		boolean isdisplayed= driver.findElement(By.id("gsri_ok0")).isDisplayed();
		System.out.println("the element is displayed "+isdisplayed);
		
		
		
	}
	
	
	@Test
	public void SearchText()
	{
		System.out.println("Inside SearchText");
		driver.findElement(By.id("lst-ib")).clear();
		String stringtobeSearched=searchString("harvard");
		driver.findElement(By.id("lst-ib")).sendKeys(stringtobeSearched);
		driver.findElement(By.name("btnK")).click();
		System.out.println("The Page title "+driver.getTitle());
		
		
	}
	
	
	public String searchString(String text)
	{
		return text;
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
