package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/main/resources/Features/TestPIMModule.feature",
		glue="stepDefination",
		monochrome = true,
	    dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports.html",
							"html:target/cucumber-reports", 
			        		"json:target/cucumber.json", 
			        		"testng:target/testng-cucumber.xml"
				}
		)
@Test
public class PIM_Module_Runner extends AbstractTestNGCucumberTests {

}
