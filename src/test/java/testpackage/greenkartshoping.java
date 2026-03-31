package testpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.checkout;
import pages.dashboard;

public class greenkartshoping extends baseclass
{

	@Parameters({"url","promo","country"})
	@Test
	public void shopping(String myurl,String mypromo,String mycountry) throws Exception
	{
		w.get(myurl);		
		FileInputStream fis = new FileInputStream("./data/login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(1);		
		int rowcount = sh.getLastRowNum();
		
		for(int i =0;i<rowcount;i++)
		{
			XSSFRow row = sh.getRow(i+1);
			XSSFCell cell = row.getCell(0);
			String vegname = cell.getStringCellValue();
			
			d.addtokart(vegname);		
		}	
		Thread.sleep(2000);
		c.checkoutjourney(mypromo,mycountry);
		
	}
	
	@Test(enabled = false)
	public void flightbookingtest()
	{
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		d.flighmethod();
	}

	
}
