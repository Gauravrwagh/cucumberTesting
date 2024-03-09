package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin = {"pretty", "html:target/cucumber-reports", 
			        		"json:target/cucumber.json", 
			        		"testng:target/testng-cucumber.xml",
			        		"rerun:target/failedrerun.txt"},
		
		features={"@target/failedrerun.txt"},
		glue="stepDefination",
		monochrome = true,
	    dryRun = false
		)
public class FailedRun extends AbstractTestNGCucumberTests {

	
	
}
