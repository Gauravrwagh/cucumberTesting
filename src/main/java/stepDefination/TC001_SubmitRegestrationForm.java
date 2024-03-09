package stepDefination;




import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StudentRegistrationDemo_QA;
import utilities.ScreenshotUtil;
import utilities.SelectUtil;
import utilities.TestBase;

public class TC001_SubmitRegestrationForm extends TestBase{

//	private WebDriver driver;
	private StudentRegistrationDemo_QA sr;
	private ScreenshotUtil su;

	@Given("user is on demoqa form page")
	public void user_is_on_demoqa_form_page() {

		initialization();
		sr = new StudentRegistrationDemo_QA(driver);
		su = new ScreenshotUtil();

	}

	@When("user enters details")
	public void user_enters_details() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500);");
		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 5; i++) {			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
		}
		sr.enterDetails("ram", "shinde", "asdfr@gmail.com");
	}

	@Then("user select gender")
	public void user_select_gender()  {
			sr.selectGender("Male");
	}
	
	@Then("user enters mobile number")
	public void user_enters_mobile_number() {
		sr.enterMobileNumber("1452632985");
	}
	
	@Then("user select date of birth")
	public void user_select_date_of_birth()throws InterruptedException {
		sr.clickDOBfield();
		Thread.sleep(1000);
		SelectUtil.selectByVisibleText(TestBase.driver,sr.monthDropdown(), "May");
		
		Thread.sleep(2000);
		SelectUtil.selectByVisibleText(TestBase.driver,sr.yearDropdown(), "2000");
		System.out.println("dob- may 2000");
		
		sr.selectDate(" May 10th, 2000");
		Thread.sleep(2000);
		
	}
	
	@Then("user enter subjects")
	public void user_enter_subjects() throws InterruptedException {

		sr.enterSubjects("Hindi");
		try {
            Thread.sleep(2000); // 1 second pause
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	//	sr.enterSubjects("English");
		
	}
	
	@Then("user click hobbies checkboxes")
	public void user_click_hobbies_checkboxes() throws InterruptedException {
		
		Thread.sleep(3000);
		sr.selectHobbies("Sports","Reading"," ");

		
	}
	
	@Then("user enter address")
	public void user_enter_address() {
			sr.enterAddress("h-406, mont vert vesta");
	}
	
	@Then("user select state")
	public void user_select_state() {
		sr.selectState("NCR");
	}
	
	@Then("user select city")
	public void user_select_city() {
		sr.selectCity("Noida");
	}
	
	@Then("user submit the form")
	public void user_submit_the_form() throws InterruptedException {
		sr.clickOnSubmitButton();
		Thread.sleep(5000);

	}
	
	@Then("confirmation message should display")
	public void confirmation_message_should_display() {
		
		assertEquals("Thanks for submitting the form" ,sr.verifyConfirmationMessage());
		System.out.println(sr.verifyConfirmationMessage());
		
//		su.takeScreenshot("form");
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
	
	
}
