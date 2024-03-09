package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={
				 "src/main/resources/Features/LoginMultiData.feature",
				  "src/main/resources/Features/LoginValidData.feature",
				  "src/main/resources/Features/RegisterUser.feature",
				  "src/main/resources/Features/StudentRegistration.feature"
				},
				  
		glue="stepDefination",
		monochrome = true,
	    dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports.html", 
			        //		"json:target/cucumber.json", 
			        //		"testng:target/testng-cucumber.xml",
			        //		"rerun:target/failedrerun.txt"
				}   // create file in target folder includes fail tests
		)
@Test
public class Login_MultiData_TestRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
}
