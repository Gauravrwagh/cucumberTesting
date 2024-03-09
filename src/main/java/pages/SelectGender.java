package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.SelectUtil;

public class SelectGender {

	//private WebDriver  driver;
	public static void main(String[] args) throws InterruptedException {
		
	SelectUtil sl = new SelectUtil();
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.manage().window().maximize();
	 driver.get("https://demoqa.com/automation-practice-form");	      
	 
//	 List<WebElement> genderOptions = driver.findElements(By
//			      .xpath("//div[@id='genterWrapper']//label"));
//	
//	 for(WebElement option: genderOptions) {
//		String opt= option.getText(); 
//		 if(opt.equals("Other")) {
//			 option.click();
//				System.out.println("Selected Gender - " + opt);
//
//			 break;
//		 }
//	 } 
	 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500);");
	//	Thread.sleep(5000);

		WebElement inputField = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__control css-yk16xz-control']"));	
		System.out.println(inputField.isDisplayed());
		System.out.println(inputField.getText());
		inputField.click();
		Thread.sleep(2000);

	//	WebElement eng =driver.findElement(By.xpath("//div[text()='English']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(inputField).click().sendKeys("h").build().perform();
		
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//div[@class='subjects-auto-complete__menu css-26l3qy-menu']//div"));
		
		for(int i=0; i<autoSuggest.size();i++) {
			String suggession = autoSuggest.get(i).getText();
			if(suggession.equals("Hindi")) {
				autoSuggest.get(i).click();
				break;
			}
		}
		
	
		System.out.println("-------------------");

		

//	 System.out.println(driver.findElement(By.id("hobbies-checkbox-1")).isDisplayed());
//	 System.out.println(driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']")).isDisplayed());
//	 System.out.println(driver.findElement(By.xpath("//label[text()='Reading']")).isEnabled());
//	//Selecting the second checkbox using Xpath
//	 String read = driver.findElement(By.xpath("//label[text()='Reading']")).getText();
//	 
//	 if(read.equals("Reading")) {
//		 System.out.println(read);
//		 driver.findElement(By.xpath("//label[text()='Reading']")).click();
//	 }
	 
	 
//	 By checkboxHobbie = By.xpath("//input[@type='checkbox']//following::label");
//	 
//	 List<WebElement> hobbies = driver.findElements(checkboxHobbie);
//	 
//	// ExpliciteWaitUtil.waitForElementClickable(driver, checkboxHobbie, Duration.ofSeconds(10));
//		for(int i=0;i<3;i++) {
//			 Thread.sleep(5000);
//			String text = hobbies.get(i).getText();
//			System.out.println(text);
//			System.out.println(hobbies.get(i).isEnabled());
//			
//			if(text.equals("Sports")|| text.equals("Reading") || text.equals("Music")) {
//				hobbies.get(i).click();		
//			
//			}
//		}
	 
//	 for(WebElement hobbie:hobbies ) {
//			System.out.println(hobbie.getText());
//			hobbie.click();
//		}
	 

//	 driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("9158624310");
//	 
//	 driver.findElement(By.id("dateOfBirthInput")).click();
//	 WebElement monthdd =driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//	 Select sel = new Select(monthdd);
//	 Thread.sleep(5000);
//	 sel.selectByVisibleText("May");
//	 
//	 WebElement yeardd = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
//	 Select sel1 = new Select(yeardd);
//	 Thread.sleep(5000);
//
//		 sel1.selectByValue("2000");
//		 
//		 
//		 List<WebElement> date = driver.findElements(By.xpath("//div[@tabindex='-1']"));
//		 
//		 for(WebElement selectDate:date) {
//			 String dateText = selectDate.getAttribute("aria-label");
//			 System.out.println(dateText);
//			 if(dateText.contains(" May 10th, 2000")) {
//				 selectDate.click();
//				 break;
//			 }
//		 }
	// driver.quit();
}
}