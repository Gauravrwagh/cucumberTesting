package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gmail_LoginPage {
	
	public WebDriver driver;
	
	private By btn_SignIn = By.xpath("//a[text()='Sign in']");
	private By input_EmailOrPhone = By.xpath("//input[@aria-label='Email or phone']");
	private By btn_Next = By.xpath("//span[text()='Next']");
	private By input_Password = By.xpath("//input[@name='Passwd']");
	private By btn_Compose = By.xpath("//div[text()='Compose']");
	private By input_Recipients = By.xpath("//div[@class='oL aDm']");
	private By input_Subject = By.xpath("//input[@name='subjectbox']");
	private By input_MessageBody = By.xpath("//div[@aria-label='Message Body']");
	private By btn_Send = By.xpath("//div[@aria-label='Send ‪(Ctrl-Enter)‬']");
	private By confirmationMessage  = By.xpath("//span[text()='Message Sent']");
	
	public Gmail_LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void clickSignInButton() {
		WebElement signInButton  = driver.findElement(btn_SignIn);
		signInButton .click();
		}
	public void enterEmailOrPhone(String EmailOrPhone) {
		WebElement emailOrPhoneField  = driver.findElement(input_EmailOrPhone);
		emailOrPhoneField .sendKeys(EmailOrPhone);
	}
	
	public void clickNextButton() {
		WebElement nextButton  = driver.findElement(btn_Next);
		nextButton .click();
	}
	
	public void enterPassword(String Password) {
		WebElement passwordField  = driver.findElement(input_Password);
		passwordField .sendKeys(Password);
	}
	public void clickComposeButton() {
		WebElement composeButton  = driver.findElement(btn_Compose);
		composeButton .click();
	}
	public void enterRecipientsEmailId(String emailID) {
		WebElement recipientsField  = driver.findElement(input_Recipients);
		recipientsField .sendKeys(emailID);
	}
	public void enterSubject(String Subject) {
		WebElement subjectField  = driver.findElement(input_Subject);
		subjectField .sendKeys(Subject);
	}
	public void enterMessageBody(String Message) {
		WebElement messageBodyField  = driver.findElement(input_MessageBody);
		messageBodyField .sendKeys(Message);
	}
	public void clickSendButton() {
		WebElement sendButton  = driver.findElement(btn_Send);
		sendButton .clear();
	}
	public boolean isConfirmationMessageDisplayed() {
		try {
		WebElement message = driver.findElement(confirmationMessage);
		return message.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}
	}
}
