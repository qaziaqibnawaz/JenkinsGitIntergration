package com.Jenkins.Integration;

import org.testng.annotations.Test;

import com.jenkins.lib.Baselib;
import com.jenkins.page.test_SecondTestCase;

public class SecondTestCase extends Baselib {
    @Test
	public void secondTestCase()
	{
    	test_SecondTestCase obj=new test_SecondTestCase(driver);
    	obj.LastName();
	}
}
