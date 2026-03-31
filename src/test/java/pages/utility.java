package pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility
{

	WebDriver w; // null
	
	public utility(WebDriver w2) 
	{
		this.w=w2;
	}

	public  WebElement waitforappeare(WebElement temp)
	{
		WebDriverWait wait = new WebDriverWait(w, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(temp));
		
	}
	
	public void waitforseconds(int n) throws Exception
	{
		Thread.sleep(1000*n);
	}
	
}
