package com.jenkins.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class test_FirstTestCase {
	
	
	public void FirstName()
	{
		String FirstName="Aqib";
		System.out.println("My First Name is :"+FirstName);
		WebDriverManager.chromedriver().setup();
		
	    WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://tb.dunnsolutions.com/");
	}

}
