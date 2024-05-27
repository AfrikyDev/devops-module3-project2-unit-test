package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationTest {
	
	static WebDriver driver;
	String appURL = "https://www.facebook.com";
	
	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
//		driver= new ChromeDriver();
		driver.get(appURL);		
	}
	
	@Test
	public void appUrlValidfation() {
		String expectedURL = "https://www.facebook.com/";
		String actualURL = driver.getCurrentUrl();
		
		assertTrue(actualURL.equals(expectedURL), "Mismatch in the application URL");
	}
	
	@Test
	public void welcomeMessageValidation() {
		String expectedResult = "Connect with friends and the world around you on Facebook.";
		
		WebElement welMsg = driver.findElement(By.xpath("//h2[@class='_8eso']"));
		String actualResult = welMsg.getText();
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the welcome notice in the login page.");
	}
	
	@AfterTest
	public void quitApp() {
		driver.quit();
	}
	
}
