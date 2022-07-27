package com.Jenkins.Integration;

import org.testng.annotations.Test;

import com.jenkins.lib.Baselib;
import com.jenkins.page.test_FirstTestCase;


public class FirstTestCase extends Baselib{
@Test	
public void fisttestCase()
{
	test_FirstTestCase obj=new test_FirstTestCase(driver);
	obj.FirstName();
	
}
}