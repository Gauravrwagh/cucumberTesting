package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtil extends TestBase {

	

	//Selectclass	
		public static void selectByVisibleText(WebDriver driver, By dropdownLocator, String visibleText) {
			WebElement dropdownElement = driver.findElement(dropdownLocator);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(visibleText);
		}

		public static void selectByValue(WebDriver driver, By dropdownLocator, String value) {
			WebElement dropdownElement = driver.findElement(dropdownLocator);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByValue(value);
		}

		public static void selectByIndex(WebDriver driver, By dropdownLocator, int index) {
			WebElement dropdownElement = driver.findElement(dropdownLocator);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByIndex(index);
		}
}
