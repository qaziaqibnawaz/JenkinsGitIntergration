package com.Jenkins.Integration;

import org.testng.annotations.Test;

import com.jenkins.lib.Baselib;
import com.jenkins.page.test_FourthTestCase;
import com.jenkins.page.test_SecondTestCase;

public class FourthTestCase extends Baselib{
	
	@Test
	public void fourthTestCase()
	{
    	test_FourthTestCase obj=new test_FourthTestCase(driver);
    	obj.LastName();
	}
}

