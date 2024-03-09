package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StudentRegistrationDemo_QA {

	private WebDriver driver;
	
	private By btnForm = By.xpath("//div[@class='card mt-4 top-card'][2]");
	private By btnPracticeForm = By.xpath("//span[text()='Practice Form']");
	private By inputFirstName = By.id("firstName");
	private By inputLastName = By.id("lastName");
	private By inputEmail = By.id("userEmail");
	private By genderOptions = By.xpath("//div[@id='genterWrapper']//label");
	private By inputMobilenumber = By.xpath("//input[@placeholder='Mobile Number']");
	private By inputDOB = By.id("dateOfBirthInput");
	private By monthDropdown = By.xpath("//select[@class='react-datepicker__month-select']");
	private By yearDropdown = By.xpath("//select[@class='react-datepicker__year-select']");
	private By dateTable = By.xpath("//div[@tabindex='-1']");
	private By inputSubject = By.xpath("//div[@class='subjects-auto-complete__control css-yk16xz-control']");
	private By autoSuggestedSub = By.xpath("//div[@class='subjects-auto-complete__menu css-26l3qy-menu']//div");
	private By checkHobbies = By.xpath("//input[@type='checkbox']//following::label");
	private By addressField = By.id("currentAddress");
	private By stateField = By.id("state");
	private By cityField = By.id("city");
	private By btnSubmit = By.id("submit");
	private By formConfirmationMessage = By.xpath("//div[text()='Thanks for submitting the form']");
	
	public  StudentRegistrationDemo_QA(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnForm() {
		WebElement form=driver.findElement(btnForm);
		form.click();
	}
	public void clickOnPracticeForm() {
		WebElement practiceForm =driver.findElement(btnPracticeForm);
		practiceForm.click();
	}
	public void enterDetails(String username,String lastname,String emailID) {
		driver.findElement(inputFirstName).sendKeys(username);
		driver.findElement(inputLastName).sendKeys(lastname);
		driver.findElement(inputEmail).sendKeys(emailID);
		
	}
	public void selectGender(String inputGender) {
		List<WebElement> gender=driver.findElements(genderOptions);
		 for(WebElement option: gender) {
				String opt= option.getText(); 
				 if(opt.equals(inputGender)) {
					 option.click();
						System.out.println("Selected Gender - " +opt);

					 break;
				 }
	}
	}
	
	public void enterMobileNumber(String contactNum) {
		WebElement mobileNumber =driver.findElement(inputMobilenumber);
		mobileNumber.sendKeys(contactNum);
	}
	
	public void clickDOBfield() {
        WebElement dob = driver.findElement(inputDOB);
        dob.click();
    }

    public By monthDropdown() {
        return monthDropdown;
    }

    public By yearDropdown() {
        return yearDropdown;
    }
    
	public void selectDate(String inputDate) throws InterruptedException {
     List<WebElement> date = driver.findElements(dateTable);
		 
		 for(WebElement selectDate:date) {
			 String dateText = selectDate.getAttribute("aria-label");
			 
			 if(dateText.contains(inputDate)) {
				 selectDate.click();
				 System.out.println("Selected Date - " +dateText);
				 break;
			 }
		 }
		
    }
	
	public void enterSubjects(String sub) {

	WebElement inputfield = driver.findElement(inputSubject);
	Actions actions = new Actions(driver);
	actions.moveToElement(inputfield).click().sendKeys(sub).build().perform();
	List<WebElement> autoSuggest = driver.findElements(autoSuggestedSub);
	
	for(int i=0; i<autoSuggest.size();i++) {
		String suggession = autoSuggest.get(i).getText();
		if(suggession.equals(sub)) {
			autoSuggest.get(i).click();
			break;
		}
	}
}
	
	public void selectHobbies(String h1, String h2, String h3) {
		List<WebElement> hobbies = driver.findElements(checkHobbies);
		for(int i=0;i<3;i++) {
			String hobbie = hobbies.get(i).getText();
			System.out.println(hobbie);
			if(hobbie.equals(h1)|| hobbie.equals(h2) || hobbie.equals(h3)) {
				hobbies.get(i).click();
			}
		}

	}
	public void enterAddress(String address) {
		WebElement add = driver.findElement(addressField);
		add.sendKeys(address);		
	}
	public void selectState(String stateName) {
		WebElement stateContainer = driver.findElement(stateField);
		stateContainer.click();
		WebElement state = driver.findElement(By.xpath("//div[text()='"+stateName+"']"));
		state.click();
	}
	public void selectCity(String cityName) {
		WebElement stateContainer = driver.findElement(cityField);
		stateContainer.click();
		WebElement city = driver.findElement(By.xpath("//div[text()='"+cityName+"']"));
		city.click();
	}
	
	public void clickOnSubmitButton() {
		WebElement submit = driver.findElement(btnSubmit);
		submit.click();
		
	}
	
	public String verifyConfirmationMessage() {
	//	WebElement message = driver.findElement(formConfirmationMessage);
		 if (isElementPresent(formConfirmationMessage)) {
	            return driver.findElement(formConfirmationMessage).getText();
	        }  else {
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