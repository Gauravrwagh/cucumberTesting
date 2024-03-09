package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

	 private static Actions actions;

	    public ActionsUtil(WebDriver driver) {
	        actions = new Actions(driver);
	    }

	    public void moveToElement(WebElement element) {
	        actions.moveToElement(element).build().perform();
	    }

	    public void click(WebElement element) {
	        actions.click(element).build().perform();
	    }

	    public void doubleClick(WebElement element) {
	        actions.doubleClick(element).build().perform();
	    }

	    public void contextClick(WebElement element) {
	        actions.contextClick(element).build().perform();
	    }

	    public void dragAndDrop(WebElement source, WebElement target) {
	        actions.dragAndDrop(source, target).build().perform();
	    }

	    // Add more actions as needed

	    public void perform() {
	        actions.perform();
	    }

}
