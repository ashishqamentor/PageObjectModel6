package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkout
{

	WebDriver w; // null , global , instance
	
	@FindBy(xpath = "//a[@class='cart-icon']")WebElement carticon;
	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")WebElement proceed;
	@FindBy(xpath = "//input[@class='promoCode']")WebElement promoCode;
	@FindBy(xpath = "//button[@class='promoBtn']")WebElement promoBtn;
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")WebElement placeorder;
	@FindBy(xpath = "//select")WebElement countrydropdown;
	@FindBy(xpath = "//input[@class='chkAgree']")WebElement checkbox;
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")WebElement proceedfinal;
	
	public checkout(WebDriver w2) 
	{
		// TODO Auto-generated constructor stub
		this.w=w2;
		PageFactory.initElements(w, this);
		
	}

	public void checkoutjourney(String mypromo, String mycountry)
	{
		carticon.click();
		proceed.click();
		promoCode.sendKeys(mypromo);
		promoBtn.click();
		placeorder.click();
		
		Select s = new Select(countrydropdown);
		s.selectByVisibleText(mycountry);
		checkbox.click();
		proceedfinal.click();
		
	}
	
	
}
