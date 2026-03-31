package testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
	
	@AfterTest
	public void terminate()
	{
		w.quit();
	}
	
	
}
