package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
	
	WebDriver w; //null . instance variable
	@FindBy(css = "#user-name")WebElement username;
	@FindBy(css ="#password" )WebElement pass;
	@FindBy(css ="#login-button")WebElement login;
	
	
	public loginpage(WebDriver w2) 
	{
		// TODO Auto-generated constructor stub
		this.w=w2;
		PageFactory.initElements(w, this);
	}


	public void loginmethod(String username2, String password)
	{
		username.sendKeys(username2);
		pass.sendKeys(password);
		login.click();
	}
	
}
