package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_Flights {
	
	By menu_Flights = By.xpath("//li[@data-cy='menu_Flights']");
	By tripType = By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']//li");
	By formCityfield = By.xpath("//label[@for='fromCity']");
	By input_formCity = By.xpath("//input[@placeholder='From']");
	By CityAutoSuggession = By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li");
	By toCity = By.xpath("//label[@for='toCity']");
	By Departure = By.xpath("//label[@for='departure']");
	By monthPicker = By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Month']");
	
	
	public static void main(String[] args) throws InterruptedException {

	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.manage().window().maximize();
	 driver.get("https://www.makemytrip.com/flights/");
	 
	 driver.findElement(By.xpath("//li[@data-cy='menu_Flights']")).click();
	 List<WebElement> trip = driver.findElements(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']//li"));
	 for(WebElement selecttype: trip ) {
		 String ttText = selecttype.getText();
		 if(ttText.equals("One Way")) {
			 selecttype.click();
		 }
	 }
	 
//	 driver.findElement(By.xpath("//label[@for='fromCity']")).click();
//	 driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("del");
//	 List<WebElement> autosuggest = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
//	 for(WebElement as:autosuggest) {
//		 String autos = as.getText();
//		 if(autos.contains("Delhi, India")) {
//			 as.click();
//			 break;
//		 }
//	 }

	 
//	 driver.findElement(By.xpath("//label[@for='toCity']")).click();
//	 driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("che");
//	 List<WebElement> autosuggestTo = driver.findElements(By.xpath("//label[@for='toCity']//following::ul[@class='react-autosuggest__suggestions-list']//li"));
//	 for(WebElement ass:autosuggestTo) {
//		 String autoss = ass.getText();
//		 if(autoss.contains("Chennai, India")) {
//			 ass.click();
//		 }
//	 }
	 
	 	System.out.println("-------------");

	 driver.findElement(By.xpath("//label[@for='departure']")).click();
	 	WebElement monthyear = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]/div[1]"));
	 	String my = monthyear.getText();
	 	System.out.println(my);
	 	
	// 	while(true) {
	 	for(int i=0;i<15;i++) {
	 		if(my.contains("May 2024")) {
	 			List<WebElement> dt = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body'][1]//p"));
	 			for(WebElement e:dt) {
	 				String date = e.getText();
	 				System.out.println(date);
	 				if(date.equals("25")) {
	 					e.click();
	 					break;
	 					
	 				}
	 			}
	 			
	 			}else {
	 				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	 			}
	 	}
	 	
	}
}