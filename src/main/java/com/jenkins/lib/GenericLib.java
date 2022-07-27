package com.jenkins.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.harley.marketplace.init.Iconstants;
import com.google.common.io.Files;

public class GenericLib extends Baselib{
	public static String getPropData(String Key) {
		String data = "";
		try {
		FileInputStream finn = new FileInputStream(Iconstants.propData);
		Properties prop= new Properties();
		prop.load(finn);
		data = prop.getProperty(Key);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void clickElement(WebDriver driver,WebElement ele,String eleName)
	{
		try{		
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele)).click();
			Reporter.log(eleName);
		//	reportLog(eleName);
			}
		catch (TimeoutException e) {
			Reporter.log(eleName+" Not dispalyed");
		//	reportLog(eleName+"Not displayed");
		//	Assert.fail();
		}
	}
	
	public static void enterText(WebDriver driver,WebElement ele,String text, String eleName)
	{
		try{		
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
			Reporter.log(eleName );
		//	reportLog(eleName);
			}
		catch (TimeoutException e) {
			Reporter.log(eleName+" Not displayed");
		//	reportLog(eleName+"Not displayed");
			//Assert.fail();
			
		}
		}
	
	public static void saveScreenShot(WebDriver driver,String path,String fileName)
	{
		/*TakesScreenshot ss = (TakesScreenshot) driver;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String time = LocalDateTime.now().format(dtf);
		
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File(path +fileName +" "+time+".png");
		try {
			Files.copy(src, des);
		} catch (IOException e) {
		

		
		}*/
	}
	public static String saveScreenShot(WebDriver driver,String fileName)
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String time = LocalDateTime.now().format(dtf);
		
		File src = ss.getScreenshotAs(OutputType.FILE);
		String destination=Iconstants.screenshot +fileName +" "+time+"_Failed.png";
		File des = new File(destination);
		try {
			Files.copy(src, des);
		} catch (IOException e) {
		

		
		}
		return destination;
	}
	

	public static void handleAction(WebDriver driver,WebElement ele, String eleName) 
	{
        Actions ac = new Actions(driver);
        ac.moveToElement(ele).click().build().perform();
        Reporter.log("Clicked on " + eleName);
     //   reportLog(eleName);

    }

	public static void hoverAction(WebDriver driver,WebElement ele, String eleName) {
        Actions ac = new Actions(driver);
        ac.moveToElement(ele).build().perform();
        Reporter.log(eleName);
    //    reportLog(eleName);
        
}
	
	
	public static void enterText1(WebDriver driver,WebElement ele,CharSequence[] text, String eleName) {
		try{		
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
			Reporter.log(eleName );
		//	reportLog(eleName);
			}
		catch (TimeoutException e) {
			Reporter.log(eleName+" Not dispalyed");
		//	reportLog(eleName+" Not dispalyed");
			Assert.fail();
		}
		
		
	}
	public static void Sendkey(WebDriver driver,WebElement ele,String text, String eleName) {
        Actions ac = new Actions(driver);
        ac.moveToElement(ele).sendKeys(text).build().perform();
        Reporter.log(eleName);
   //     reportLog(eleName);
        
}
	public static void MouseOver(WebDriver driver,WebElement ele, String eleName) {
		Actions action = new Actions(driver);
		
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform(); 
		Reporter.log( eleName ); 
	//	reportLog(eleName);
}
    public static void WaitForElement(WebDriver driver,WebElement ele)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));	
    }
    
    /*
    public static void ScrolltoParticularElement(WebDriver driver,WebElement ele)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));	
    }
    */
    public static void isDisplayedAssert(WebDriver driver,WebElement ele,String eleName)
    {  
    	WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
    	Assert.assertEquals(true, ele.isDisplayed());
    	Reporter.log(  eleName );
    //	reportLog(eleName);
    }
    
    public static void Navigateback(WebDriver driver)
    {  
    	driver.navigate().back();
    	
    }
    
    	
    public static void EqualsStringAssert(WebDriver driver,String actual,String expected,String eleName)
    {  
    	Assert.assertEquals(actual, expected);
    	Reporter.log(  eleName );
    //	reportLog(eleName);
    }
}

