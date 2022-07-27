package com.jenkins.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class test_FourthTestCase {
WebDriver driver;
	
	public test_FourthTestCase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LastName()
	{
		String LastName="User4";
		System.out.println("My Fourth Name is :"+LastName);
	}

}


