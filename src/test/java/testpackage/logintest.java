package testpackage;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.loginpage;

public class logintest extends baseclass
{

	@Test(dataProvider = "mydata")
	public void login(String username ,String password, String expurl)
	{
		w.get("https://www.saucedemo.com/");		
		l.loginmethod(username,password);
		String actulUrl =w.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actulUrl, expurl);	
		sa.assertAll();
	}
		
	@DataProvider(name = "mydata")
	public Object[][] exceldata() throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
		int colcount = sh.getRow(0).getLastCellNum();
		
		Object obj[][] = new Object[rowcount][colcount];
		for(int i =0; i<rowcount;i++)
		{
			XSSFRow row = sh.getRow(i+1); //1
			for(int j =0;j<colcount;j++)  //3
			{
				obj [i][j]= row.getCell(j).getStringCellValue();  // a[0,0]
			}
			
		}
		return obj;
		
	}
	
	
	
}
