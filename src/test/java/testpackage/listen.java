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

import com.google.common.io.Files;

public class listen extends baseclass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Test is started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("Test is successfull.");
		System.out.println();
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("test is failed.");

		try {
			
			w=  (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			
			LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
	        String formattedDate = now.format(formatter);
			
			TakesScreenshot tc = (TakesScreenshot) w;
			File src = tc.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/temp_"+formattedDate+".png");
			Files.copy(src, dest);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
