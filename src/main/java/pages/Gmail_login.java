package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail_login {
	

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
   	    ChromeDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	//	driver.get("https://www.google.com/gmail/about/");
		driver.get("https://mail.google.com/");
		System.out.println("----------------");
		WebElement field_nameOrEmail = driver.findElement(By.xpath("//input[@aria-label='Email or phone']"));
		field_nameOrEmail.sendKeys("waghg20@gmail.com");
		WebElement btn_submit  = driver.findElement(By.xpath("//span[text()='Next']"));
		btn_submit.click();
		System.out.println(" ---- next click ----");
	}
}



//open chrome using cmd
//  "C:\Program Files\Google\Chrome\Application\chrome.exe" --remote-debugging-port=9222 --user-data-dir="C:\localhost"
