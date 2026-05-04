package loginstep;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testpackage.baseclass;

public class loginstepdefination extends baseclass
{

	@Given("user is on sause demo site.")
	public void onsite() throws Exception
	{
		launch();
		w.get("https://www.saucedemo.com/");
	}
		
	@When("^user enters (.+) and (.+)$")
	public void credentials(String user, String pass) 
	{
		w.findElement(By.cssSelector("#user-name")).sendKeys(user);
		w.findElement(By.cssSelector("#password")).sendKeys(pass);
	}
	
	@And("click on login")
	public void login()
	{
		w.findElement(By.cssSelector("#login-button")).click();
	}
	
	@Then("inventory page should display with url {string}")
	public void verify(String expurl)
	{
		String actUrl = w.getCurrentUrl();
		SoftAssert as = new SoftAssert();
		as.assertEquals(actUrl, expurl);
		w.quit();
		
		as.assertAll();
	}
	
}
