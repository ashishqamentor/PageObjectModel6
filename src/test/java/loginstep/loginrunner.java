package loginstep;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "features/login.feature",
		glue = "loginstep",
		plugin = {	"pretty" , "html:report/login.html",
								"json:report/login.json "
				},
		monochrome = true
		
		)
public class loginrunner extends AbstractTestNGCucumberTests
{

	
	
}
