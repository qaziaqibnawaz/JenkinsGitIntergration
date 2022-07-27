package com.jenkins.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class test_SecondTestCase {
WebDriver driver;
	
	public test_SecondTestCase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LastName()
	{
		String LastName="nawaz";
		System.out.println("My Last Name is :"+LastName);
	}

}
