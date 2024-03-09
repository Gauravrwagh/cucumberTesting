package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpliciteWaitUtil {


	// ExpliciteWait
		public static WebElement waitForElementVisibility(WebDriver driver, By locator, Duration timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    // You can add more generalized wait methods based on your needs

	    // For example, wait for an element to be clickable
	    public static WebElement waitForElementClickable(WebDriver driver, By locator, Duration timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    // For example, wait for an element's text to contain certain value
	    public static boolean waitForElementTextContains(WebDriver driver, By locator, String expectedText, Duration timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	        return wait.until(ExpectedConditions.textToBe(locator, expectedText));
	    }
}
