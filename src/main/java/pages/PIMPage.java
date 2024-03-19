package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExpliciteWaitUtil;
import utilities.TestBase;

public class PIMPage extends TestBase {

	private WebDriver driver;
	private ExpliciteWaitUtil ew;
	
	private By btn_PIM = By.xpath("//span[text()='PIM']");
	private By field_EmployeeName = By.xpath("//label[text()='Employee Name']//following::input[1]");
	private By field_EmployeeID = By.xpath("//label[text()='Employee Name']//following::input[2]");
	private By field_SupervisorName = By.xpath("//label[text()='Employee Name']//following::input[3]");
	private By btn_EmplyomentStatus = By.xpath("//label[text()='Employment Status']//following::i[1]");
	private By btn_Include = By.xpath("//label[text()='Employment Status']//following::i[2]");
	private By btn_JobTitle = By.xpath("//label[text()='Employment Status']//following::i[3]");
	private By btn_SubUnit = By.xpath("//label[text()='Employment Status']//following::i[4]");
	private By btn_Search = By.xpath("//button[text()=' Search ']");
	private By successMessage = By.xpath("//span[text()='(1) Record Found']");
	private By errorMessage = By.xpath("//span[text()='No Records Found']");
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		this.ew = new ExpliciteWaitUtil();
		
	}

	public void clickOnPIM() {
		WebElement field_PIM = driver.findElement(btn_PIM);
		field_PIM.click();

	}

	public void enterEmplyoyeeName(String EmployeeName) {
		WebElement nameField = driver.findElement(field_EmployeeName);
		nameField.sendKeys(EmployeeName);
	}

	public void enterEmplyoyeeID(String EmployeeID) {
		WebElement idField = driver.findElement(field_EmployeeID);
		idField.sendKeys(EmployeeID);
	}

	public void enterSupervisorNmae(String SupervisorName) {
		WebElement supervisorField = driver.findElement(field_SupervisorName);
		supervisorField.sendKeys(SupervisorName);
	}

	public void selectEmployementStatus(String employmentStatus) {
		WebElement dropdownButton1 = driver.findElement(btn_EmplyomentStatus);
		dropdownButton1.click();
//		for (int i = 1; i < 8; i++) {
//			WebElement a = driver.findElement(By.xpath("//div[@role='listbox']//div[" + i + "]"));
//			String text = a.getText();
//			System.out.println(text);
//			if (text.equalsIgnoreCase(empStatus)) {
//				a.click();
//				break;
//			}
//		}
		//explicite wait using from expliciteWaitUtil class
		
		WebElement option = ew.waitForElementVisibility(driver, 
				By.xpath("//div[@role='listbox']//span[text()='" + employmentStatus + "']"), 30);
		
		option.click();

	}

	public void selectJobTitle(String jobTitle) {
		WebElement dropdownButton2 = driver.findElement(btn_JobTitle);
		dropdownButton2.click();
		WebElement option = ew.waitForElementVisibility(driver, 
				By.xpath("//div[@role='listbox']//span[text()='" + jobTitle + "']"), 30);
		
		
		option.click();

	}

	public void selectinclude(String includeOption) {
		WebElement dropdownButton3 = driver.findElement(btn_Include);
		dropdownButton3.click();
		WebElement option = ew.waitForElementVisibility(driver, 
				By.xpath("//div[@role='listbox']//span[text()='" + includeOption + "']"), 30);
		
		option.click();

	}

	public void selectSubunit(String subunitOption) {
		WebElement dropdownButton4 = driver.findElement(btn_SubUnit);
		dropdownButton4.click();
		WebElement option = ew.waitForElementVisibility(driver, 
				By.xpath("//div[@role='listbox']//span[text()='" + subunitOption + "']"), 30);
				option.click();

	}

	public void clickOnSearch() {
		WebElement search = driver.findElement(btn_Search);
		search.click();
	}
	
	public String message() {
		if (isElementPresent(successMessage)) {
            return driver.findElement(successMessage).getText();
        } else if (isElementPresent(errorMessage)) {
            return driver.findElement(errorMessage).getText();
        } else {
            return "No message found";
        }
	}
	private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
