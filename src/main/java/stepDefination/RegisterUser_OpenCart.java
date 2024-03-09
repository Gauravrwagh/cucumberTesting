package stepDefination;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpenCartRegistrationPage;
import utilities.ScreenshotUtil;
import utilities.TestBase;


public class RegisterUser_OpenCart extends TestBase {

	private OpenCartRegistrationPage rp;
	
	ScreenshotUtil su = new ScreenshotUtil();
	
	
	@Given("user is on the opencart WebPage")
	public void user_is_on_the_opencart_web_page() {
	    initialization();
	    
	    rp = new OpenCartRegistrationPage(TestBase.driver);
	}

	@When("user select register option")
	public void user_select_register_option() {
	    rp.clickOnRegisterButton();
	}

	@Then("user enters details {string} {string} {string} {string} {string}")
	public void user_enters_details(String username, String firstname, String lastname,
			String email, String password) {
		
		rp.enterRegistrationDetails(username, firstname, lastname, email, password);
//		rp.enterUsername(username);
//		rp.enterFirstname(firstname);
//		rp.enterLastname(lastname);
//		rp.enterEmail(email);
//		rp.enterPassword(password);
	}
	
	@Then("user selects country from dropdown {string}")
    public void user_selects_country_from_dropdown(String country) {
        rp.selectCountryFromDropdown(country);
    }
	@Then("user fill captcha manually")
	public void user_fill_captcha_manually() throws InterruptedException {
	    Thread.sleep(3000);
	}

	@Then("user click on Register button")
	public void user_click_on_register_button() {
	    rp.submitDetails();
	}

	@Then("user should see message")
	public void user_should_see_message(String status) {
	    assertEquals("Welcome to OpenCart, your account has been created",rp.getRegistrationMessage());
		System.out.println("-----"+rp.getRegistrationMessage()+"-----");
	//	su.takeScreenshot("Registratio Status");
	}

	@Then("user click on continue button")
	public void user_click_on_continue_button() {
	    rp.clickContinue();
	    
	    
	}

	@After
	public void quite() {
		tearDown();
	}
	
	@After
	public void close(Scenario scenario) {
		String scenarioName = scenario.getName();
		if(scenario.isFailed()) {
			su.takeScreenshot(scenarioName);
		}
	}
//	@Then("user enter email and password")
//	public void user_enter_email_and_password() {
//	    
//	}
//
//	@Then("user should see login successfull message")
//	public void user_should_see_login_successfull_message() {
//	    
//	}
}
