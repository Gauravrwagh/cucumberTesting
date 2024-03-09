package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SelectUtil;
import utilities.TestBase;

public class OpenCartRegistrationPage extends TestBase {

	private WebDriver driver;
	SelectUtil selectutil = new SelectUtil();
	
	private By btnRegister = By.xpath("//div[@class='navbar-right hidden-xs']//a[2]");
	private By inputUsername = By.xpath("//input[@name='username']");
	private By inputFirstname = By.xpath("//input[@name='firstname']");
	private By inputLastName = By.xpath("//input[@name='lastname']");
	private By inputEmail = By.xpath("//input[@name='email']");
	private By countryDropdown = By.xpath("//select[@name='country_id']");
	private By inputPassword = By.name("password");
	private By btnSubmit = By.xpath("//div[@id='button-register']");
	private By textMessage = By.xpath("//div[@class='col-md-8']");
	private By btnContinue = By.xpath("//a[text()='Continue']");
	
	
	public OpenCartRegistrationPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void clickOnRegisterButton() {
		driver.findElement(btnRegister).click();
	}
	
	public void enterRegistrationDetails(String username, String firstname, String lastname,
			String email,String password	) {
		driver.findElement(inputUsername).sendKeys(username);
		driver.findElement(inputFirstname).sendKeys(firstname);
		driver.findElement(inputLastName).sendKeys(lastname);
		driver.findElement(inputEmail).sendKeys(email);
		driver.findElement(inputPassword).sendKeys(password);
	}
	
//	public void enterUsername(String username) {
//		driver.findElement(inputUsername).sendKeys(username);
//	}
//	
//	public void enterFirstname(String firstname) {
//		driver.findElement(inputFirstname).sendKeys(firstname);
//	}
//	
//	public void enterLastname(String lastname) {
//		driver.findElement(inputLastName).sendKeys(lastname);
//	}
//	
//	public void enterEmail(String email) {
//		driver.findElement(inputEmail).sendKeys(email);
//	}
//	
//	public void enterPassword(String password) {
//		driver.findElement(inputPassword).sendKeys(password);
//	}
	
	public void selectCountryFromDropdown(String visibleText) {
		selectutil.selectByVisibleText(driver, countryDropdown, visibleText);
	}
	
	
	
	public void submitDetails() {
		driver.findElement(btnSubmit).click();
	}
	
	public String getRegistrationMessage() {
		if(isElementPresent(textMessage)) {
			return driver.findElement(textMessage).getText();
		}else if(isElementPresent(btnSubmit)) {
			return driver.findElement(btnSubmit).getText();
		}else {
			return "No Message Found";
		}
	}	
	 private boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	 
	 public void clickContinue() {
		 driver.findElement(btnContinue).click();
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
