package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITE_WAIT = 30;

	static WebDriver driver;
	
	
    
// Switch to window
    public static void switchToWindowByTitle(WebDriver driver, String targetWindowTitle) {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals(targetWindowTitle)) {
                    // Window with the target title found, switch to it
                    return;
                }
            }
        }

        // If the target window is not found, switch back to the original window
        driver.switchTo().window(currentWindowHandle);
    }
    
// Switch to frame 
    public static void switchToFrame(WebDriver driver, By frameLocator) {
        WebElement frameElement = driver.findElement(frameLocator);
        driver.switchTo().frame(frameElement);
    }
    
// Navigate Back
    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }
    
// Navigate forward 
    
    public static void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }
    
// Refresh
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }


     
}
