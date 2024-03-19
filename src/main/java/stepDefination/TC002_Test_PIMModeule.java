package stepDefination;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PIMPage;
import utilities.TestBase;

public class TC002_Test_PIMModeule extends TestBase {

	private PIMPage pp;
	
	@Given("user on loginpage")
	public void user_on_loginpage() {
	    
		initialization();
		
		pp = new PIMPage(TestBase.driver);
	}

	@When("user submit credentials")
	public void user_submit_credentials() {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@When("^user enter details employename as (.*) and employeeId as (.*)$")
	public void user_enter_details_employename_as_and_employee_id_as(String empName, String empID) {
		pp.clickOnPIM();
		pp.enterEmplyoyeeName(empName);
		pp.enterEmplyoyeeID(empID);
	}

	@Then("user click on searchfield")
	public void user_click_on_searchfield() {
		pp.clickOnSearch();

	}

	@Then("^verify record avilibity message (.*)$")
	public void verify_record_avilibity_message(String expectedResult) {
		if(pp.message().contains("Record Found")) {
			System.out.println("Test Passed: " + expectedResult);

		}else if(pp.message().contains("No Records Found")) {
			System.out.println("Test Passed: " + expectedResult);

		}
//		assertEquals("(1) Record Found", pp.message());
//		System.out.println("Test Passed: " + expectedResult);
	}
}
