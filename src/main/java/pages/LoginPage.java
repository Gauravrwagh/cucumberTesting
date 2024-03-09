package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.ActionsUtil;
import utilities.TestBase;


public class LoginPage extends TestBase {

	
	private WebDriver driver;
	private ActionsUtil actionUtil;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//h6[text()='Dashboard']");
    private By errorMessage = By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionUtil = new ActionsUtil(driver);
    }

   
    public void enterUsername(String username) {
       WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.clear();
        usernameElement.sendKeys(username);    
    }
    
//    public void moveToUsername() {
//        actionUtil.doubleClick(usernameElement);
//    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getDisplayedMessage() {
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
