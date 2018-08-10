package com.selflearn.automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TNGBasicFlow {
	
	/*
	 * 
	 * Setting System property for chrome browser
       Launching Browser
       login into App
       Entering the Url
       google test
       Logging out of the App
       Entering the Url
       Search performing
       Logging out of the App
       Close the browser
	   Delete the cookies
       PASSED: googletitleTest
       PASSED: searchText
	 * BEFORESUITE-->BEFORETEST-->BEFORECLASS-->BEFOREMETHOD-->TEST
	 * 
	 * 
	 */
	
	
	
	
	
	@BeforeSuite
	public void setup()
	{
		System.out.println("#BeforeSuite --->Setting System property for chrome browser");
	}

	
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("#BeforeTest --->Launching Browser");
	}
	
	@BeforeClass 
	public void login()
	{
		System.out.println("#BeforeClass --->login into App");
	}
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("#BeforeMethod --->Entering the Url");
		
	}
		
	@Test
	public void googletitleTest()
	{
		System.out.println("#Test --->google test");
	}
    @Test
    public void searchText()
    {
    	
    	System.out.println("#Test --->Search performing");
    }
	@AfterMethod
	public void logOut()
	{
		System.out.println("#AfterMethod --->Logging out of the App");
	}
    @AfterTest
    public void deleteCookies()
    {
    	
    	System.out.println("#AfterTest --->Delete the cookies");
    }
    @AfterClass
    public void closeBrowser()
    {
    	System.out.println("#AfterClass --->Close the browser");
    	
    }
    @AfterSuite
    public void generateReports()
    {
    	System.out.println("#AfterSuite-->Generate the Reports");
    }


}
