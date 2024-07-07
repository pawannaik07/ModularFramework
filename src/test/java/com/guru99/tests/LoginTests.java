package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTest{
	@Parameters({"username", "userPassword"})
	
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {
		reportUtils.createATestCase("verify user login");
		
		reportUtils.addTestLog(Status.INFO, "perform login");
		
		loginpage.loginToApplication(username, password);
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = cmnDriver.getTitleOfThePage();
		
		reportUtils.addTestLog(Status.INFO, "expected and actual");
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}

}
