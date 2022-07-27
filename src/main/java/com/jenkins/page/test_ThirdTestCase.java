package com.jenkins.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class test_ThirdTestCase {
	WebDriver driver;

	public test_ThirdTestCase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FirstName()
	{
		String FirstName="Test";
		System.out.println("My third Name is :"+FirstName);
		
	}

}
