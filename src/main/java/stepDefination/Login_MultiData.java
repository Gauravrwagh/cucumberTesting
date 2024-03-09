package stepDefination;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ScreenshotUtil;
import utilities.TestBase;

public class Login_MultiData extends TestBase {

	public Login_MultiData() {
		
	}

//	private WebDriver driver;
	private LoginPage lp;
	
	ScreenshotUtil su = new ScreenshotUtil();

	@Given("user is on the login page of orangehrm")
	public void user_is_on_the_login_page_of_orangehrm() {
		initialization();

		lp = new LoginPage(TestBase.driver);
	}

	@When("^user enter username as (.*) and password as (.*)$")
	public void user_enter_username_as_and_password_as(String username, String password) {
			lp.enterUsername(username);
			lp.enterPassword(password);
			
	}

	@When("user hit login button")
	public void user_hit_login_button() {
			lp.clickLoginButton();
	}

	@Then("^login validation message should display as (.*)$")
	public void login_validation_message_should_display_as(String expectedResult) {
			assertEquals(expectedResult,lp.getDisplayedMessage());
			System.out.println("Test Passed: " + expectedResult);
			
	//		su.takeScreenshot("LoginREsult");

			tearDown();

	}
	
	@After
	public void close(Scenario scenario) {
		String scenarioName = scenario.getName();
		if(scenario.isFailed()) {
			su.takeScreenshot(scenarioName);
		}
	}
}
