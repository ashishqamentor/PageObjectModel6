package testpackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class temptest   extends baseclass
{
	@Test
	public void login1234()
	{
		w.get("https://www.saucedemo.com/");		
		System.out.println(w.getTitle());
		String actulUrl =w.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
	
	}
}
