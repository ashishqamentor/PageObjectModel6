package testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import pages.checkout;
import pages.dashboard;
import pages.loginpage;

public class baseclass 
{

	public WebDriver w;  // global/ instance varibale
	 dashboard d ;
	 checkout c;
	 loginpage l;
	
	@BeforeTest
	public void launch() throws Exception
	{		
		//local
		FileInputStream fis = new FileInputStream("./data/config.properties");
		Properties p = new Properties();
		p.load(fis);
		String mybrowser = p.getProperty("browser");
		if(mybrowser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");
			w = new ChromeDriver(op);
		}
		if(mybrowser.equalsIgnoreCase("edge"))
		{
			EdgeOptions op = new EdgeOptions();
			op.addArguments("inprivate");
			w = new EdgeDriver(op);
		}
		
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d = new dashboard(w);
		c = new checkout(w);
		l = new loginpage(w);
		
	}
	
	public ExtentReports extenreportObj()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./report/myreport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	public File myfailedscreenshot(String testname) throws Exception
	{
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String formattedDate = now.format(formatter);
		TakesScreenshot tc = (TakesScreenshot) w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+testname+"_"+formattedDate+".png");
		Files.copy(src, dest);
		return dest;
		
	}
	
	
	
	@AfterTest
	public void terminate()
	{
		w.quit();
	}
	
	
}
