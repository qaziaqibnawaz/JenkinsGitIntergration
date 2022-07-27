package com.Jenkins.Integration;

import org.testng.annotations.Test;

import com.jenkins.lib.Baselib;

import com.jenkins.page.test_ThirdTestCase;

public class ThirdTestCase extends Baselib{
	@Test
	public void thirdTestCase()
	{
		test_ThirdTestCase obj=new test_ThirdTestCase(driver);
		obj.FirstName();
		
	}
}
