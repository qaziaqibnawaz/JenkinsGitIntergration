package com.Jenkins.Integration;

import org.testng.annotations.Test;

import com.jenkins.page.test_SecondTestCase;

public class SecondTestCase {
    @Test
	public void secondTestCase()
	{
    	test_SecondTestCase obj=new test_SecondTestCase();
    	obj.LastName();
	}
}
