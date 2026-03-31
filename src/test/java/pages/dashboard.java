package pages;

import java.io.Serial;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboard  extends utility
{
	WebDriver w;  // null //global .instance
	
	@FindBy(xpath = "//input[@type='search']" )WebElement search;
	@FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")WebElement addtokart;
	@FindBy(xpath = "//a[contains(text(),'Flight Booking')]")WebElement flight;

	public dashboard(WebDriver w2)  //ihiny8i
	{
		// TODO Auto-generated constructor stub
		super(w2);
		this.w=w2;
		PageFactory.initElements(w, this);
	}

	public void addtokart(String vegname) throws Exception
	{
		search.clear();	
		search.sendKeys(vegname);
		waitforseconds(2);
		waitforappeare(addtokart).click();
		
	}
	
	public void flighmethod()
	{
		String original = w.getWindowHandle();
		flight.click();
		Set<String>all = w.getWindowHandles();
		for(String temp:all)
		{
			if(!temp.equalsIgnoreCase(original))
			{
				w.switchTo().window(temp);
				System.out.println(w.getTitle());
				break;
			}
		}
		w.switchTo().window(original);
		
	}
	
}
