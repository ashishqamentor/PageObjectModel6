package greenkartstep;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "features/greenkart.feature",
	glue = "greenkartstep",
	plugin = {	"pretty" , "html:report/greenkart.html",
				"json:report/greenkart.json "
			},
	monochrome = true
)

public class geenkartrunner extends AbstractTestNGCucumberTests 
{

	
	
}
