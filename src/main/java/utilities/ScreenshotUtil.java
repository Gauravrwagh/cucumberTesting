package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static utilities.TestBase.driver;


public class ScreenshotUtil {

	
		
	//Screenshot	
		public  void takeScreenshot(String screenshotName) {
			// Cast WebDriver to TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
//			TakesScreenshot ts = (TakesScreenshot) TestBase.driver; use this or static import

			// Get the screenshot file
			File source = ts.getScreenshotAs(OutputType.FILE);
			// Define the destination file path
			String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
			File destination = new File("target/screenshots/" + screenshotName + "_" + timestamp + ".png");

			try {
				FileUtils.copyFile(source, destination);
				// Copy the file to the destination
		//		FileHandler.copy(source, new File(destination));
				System.out.println("Screenshot captured: " + destination);
			} catch (IOException e) {
				System.out.println("Exception while taking screenshot: " + e.getMessage());
			}
		}

}
