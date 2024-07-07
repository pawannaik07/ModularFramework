package com.guru99.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import commonLibs.Utils.ConfigUtils;
import commonLibs.Utils.ReportUtils;
import commonLibs.Utils.ScreenshotUtils;
import commonLibs.implementation.CommonDriver;
import pages.LoginPage;

public class BaseTest {

	CommonDriver cmnDriver;
	String url;
	WebDriver driver;
	
	LoginPage loginpage;
	
	String configFileName;
	String currentWorkingDirectory;
	
	Properties configProperty;
	
	String reportFilename;
	ReportUtils reportUtils;
	
	ScreenshotUtils screenshot;
	
	@BeforeSuite
	public void preSetup() throws IOException {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "/config/config.properties";
		reportFilename = currentWorkingDirectory + "/reports/guru99TestReports";
		
		configProperty = ConfigUtils.readProperties(configFileName);
		
		reportUtils = new ReportUtils(reportFilename);
	}
	
	@BeforeClass
	public void setup() throws Exception {
		url = configProperty.getProperty("baseUrl");
		
		String browserType = configProperty.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);
		
		driver = cmnDriver.getDriver();
		
		loginpage = new LoginPage(driver); 
		
		screenshot = new ScreenshotUtils(driver);
		cmnDriver.navigateToUrl(url);
	}
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		
		String testcasename = result.getName();
		long executionTime = System.currentTimeMillis();
		
		String screenshotFilename = currentWorkingDirectory + "/screenshots" + testcasename + executionTime +".jpeg";
		if(result.getStatus() == ITestResult.FAILURE) {
			
			reportUtils.addTestLog(Status.FAIL, "step failed" );
			
			screenshot.captureAndSaveScreenshot(screenshotFilename);
			
		}
	}
	
	@AfterClass
	public void tearDown() {
		cmnDriver.closeAllBrowser();
		
	}
	@AfterSuite
	public void postTeardown() {
		reportUtils.flushReport();
	}
}
