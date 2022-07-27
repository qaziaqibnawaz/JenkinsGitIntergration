package com.jenkins.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;



public class test_FirstTestCase {
	WebDriver driver;
	
	public test_FirstTestCase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FirstName()
	{
		String FirstName="Aqib";
		System.out.println("My First Name is :"+FirstName);
		
	}

}
