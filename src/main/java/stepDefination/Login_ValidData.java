package stepDefination;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ScreenshotUtil;
import utilities.TestBase;

public class Login_ValidData extends TestBase {

	private WebDriver driver;
	private LoginPage lp;
	
	ScreenshotUtil su = new ScreenshotUtil();

	@Given("user is on login page")
	public void user_is_on_login_page() {
		initialization();
		
		lp = new LoginPage(TestBase.driver);
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		lp.enterUsername("admin");
		lp.enterPassword("admin123");
	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
		lp.clickLoginButton();

	}

	@Then("user login successfully")
	public void user_login_successfully() {
		
		assertEquals("Dashboard",lp.getDisplayedMessage());
		System.out.println("-----Test Passed-----");
		
//		su.takeScreenshot("LoginValidData");
//		
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
