package testpackage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;

public class listen extends baseclass implements ITestListener {

	ExtentReports extent = extenreportObj();
	ExtentTest test ;
	
	ThreadLocal<ExtentTest> thread = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Test is started.");
		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
		
		thread.get().info("i am creating automation report");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("Test is successfull.");
		System.out.println();
		thread.get().pass("Test is Passed.");		
		try {
			
			w=  (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			String testname = result.getMethod().getMethodName();
			File f = myfailedscreenshot(testname);			
			thread.get().addScreenCaptureFromPath(f.getAbsolutePath());
				
			extent.flush();
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			extent.flush();
		}		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("test is failed.");
		thread.get().fail("Test is failed");
		try {
			
			w=  (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			String testname = result.getMethod().getMethodName();
			File f = myfailedscreenshot(testname);			
			thread.get().addScreenCaptureFromPath(f.getAbsolutePath());
				
			extent.flush();
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			extent.flush();
		}

	}
	
	
	
	
	
	
	
	

}
