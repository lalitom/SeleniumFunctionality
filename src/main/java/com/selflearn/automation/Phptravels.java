package com.selflearn.automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phptravels {
	
	WebDriver driver=null;
	String text="Harvard";
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://phptravels.com/demo/");
		
	}
	@Test(enabled=false)
	public void verifyPageTitleTest()
	{
		String title= driver.getTitle();
		System.out.println("the title of the page is "+title);
		
	}
	@Test(enabled=false)
	public void verifyDemoLinkXPATHTest()
	{
		WebElement LinkID1=driver.findElement(By.xpath("//a[@class='text-primary']"));
		LinkID1.click();
		
		
	}
	@Test(enabled=false)
	public void verifyDemoLinkLinkTextTest()
	{
	
		
		WebElement LinkID2=driver.findElement(By.linkText("DEMO"));
		clickAtElement(driver,LinkID2);
		
	}
	
	@Test(enabled=false)
	public void verifyDemoLinkpartialLinkTextTest()
	{
	
		
		WebElement LinkID2=driver.findElement(By.partialLinkText("DEM"));
		clickAtElement(driver,LinkID2);
	
	}
	@Test(enabled=false)
	public void mousehoveronfeatureslinkTest() throws InterruptedException
	{
		String text;
		int num=0;
        WebDriverWait wait=new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='onesignal-popover-dialog']/div/div/button[text()='No Thanks']"))));
		driver.findElement(By.xpath("//div[@id='onesignal-popover-dialog']/div/div/button[text()='No Thanks']")).click();
		By by = By.cssSelector("li.has-drop>span>span");
		
		List<WebElement> link=driver.findElements(by);
		for(int i=0;i<=link.size();i++)
		{
			text=link.get(i).getAttribute("innerHTML");
			if (text.equalsIgnoreCase("FEATURES"))
					{
				     num=i;
					break;
					}
		}
		this.mouseHoverElement(driver, link.get(num));
		//clickAtElement(driver,link.get(num));
		Thread.sleep(2000);
	}
	@Test(enabled=false)
	public void verifyfeaturesuboptionclickTest()
	{
		//String texttobeVisible;
		int indexofelementFound=0;
		
		WebDriverWait wait =new WebDriverWait(driver, 1000);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='onesignal-popover-dialog']/div/div/button[text()='No Thanks']")));
		driver.findElement(By.xpath("//div[@id='onesignal-popover-dialog']/div/div/button[text()='No Thanks']")).click();
		By by = By.cssSelector("li.has-drop>span>span");
		
		List<WebElement> link=driver.findElements(by);
		for(int i=0;i<=link.size();i++)
		{
			text=link.get(i).getAttribute("innerHTML");
			if (text.equalsIgnoreCase("FEATURES"))
					{
				indexofelementFound=i;
					break;
					}
		}
		this.mouseHoverElement(driver, link.get(indexofelementFound));
		WebElement linkunderfeature=driver.findElement(By.xpath("//ul[@class='menu reset']/li/a[text()='Hotels Module']"));
		clickAtElement(driver,linkunderfeature);
		
		
		
	}
	@SuppressWarnings("null")
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public void clickAtElement(WebDriver driver,WebElement elem)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(elem).click().build().perform();
	}
	public void mouseHoverElement(WebDriver driver,WebElement elem)
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(elem).perform();
	}

}
