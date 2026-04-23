package greenkartstep;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testpackage.baseclass;

public class greenkartstepdefination extends baseclass {

	@Given("user is on greenkart site.")
	public void user_is_on_greenkart_site() throws Exception {
		launch();
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		}

	@When("user add vegitable in basket.")
	public void user_add_vegitable_in_basket() throws Exception 
	{
		// when
		FileInputStream fis = new FileInputStream("./data/login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(1);
		int rowcount = sh.getLastRowNum();

		for (int i = 0; i < rowcount; i++) 
		{
			XSSFRow row = sh.getRow(i + 1);
			XSSFCell cell = row.getCell(0);
			String vegname = cell.getStringCellValue();

			d.addtokart(vegname);
		}
	}

	@Then("user do checkout.")
	public void checkout() throws Exception 
	{
		Thread.sleep(2000);
		c.checkoutjourney("ashish","India");

	}
	
	@And("successfull message is displyed.")
	public void screenshot() throws Exception
	{
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/geenkartCucumber.png");
		Files.copy(src, dest);	
		w.quit();
		
		
	}
	
	
}
