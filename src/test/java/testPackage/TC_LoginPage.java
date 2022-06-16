package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pom_pages.PomLoginPage;
import utiltiyPackage.UtilityClass;
import utiltiyPackage.ConfigClass;
import utiltiyPackage.PojoClass;

public class TC_LoginPage {

	public WebDriver driver;
	public PomLoginPage login;
	public UtilityClass utility;
	public ConfigClass config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		utility= new UtilityClass();
		config=new ConfigClass();
		
		report= new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter("E:\\Workspace_1\\HybridFramework\\reports\\report"+utility.Date()+".html");
		report.attachReporter(spark);
	}

	@BeforeClass
	public void setup()
	{
	//BY using config class the setup will be   
	//	driver=PojoClass.startApplication(driver,config.getBrowser(),config.getUrl());
		
		driver=PojoClass.startApplication(driver, "Chrome", "https://opensource-demo.orangehrmlive.com/");	
	}
	
	@BeforeMethod
	public void initClass()
	{
		login= new PomLoginPage(driver);
	}
	
	@Test
	public void validateLoginPage() throws InterruptedException, EncryptedDocumentException, IOException
	{
		logger= report.createTest("Login TO OrangeHRM");
		login.login(utility.excelData("Login", 0, 0), utility.excelData("Login", 0, 1));
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		System.out.println(" the method has failed take screenshot");
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(driver, result.getTestName())).build());
		}
		logger.pass("the test is passed",MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(driver, result.getTestName())).build());
	}
	
	@AfterClass 
	public void endTest()
	{
		report.flush();
		PojoClass.tearDown(driver);
	}
}
