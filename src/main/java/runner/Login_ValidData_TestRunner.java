package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/main/resources/Features/LoginValidData.feature",
		glue="stepDefination",
		monochrome = true,
	    dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports", 
			        		"json:target/cucumber.json", 
			        		"testng:target/testng-cucumber.xml"}
		)
@Test
public class Login_ValidData_TestRunner extends AbstractTestNGCucumberTests {

}
