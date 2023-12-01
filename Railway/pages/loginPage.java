package Railway.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Railway.Configs;

public class loginPage {

	// Elements
	public static String dynamicMenu = "//a[span='%s']";
	public static String userTextboxXpath = "//input[@id='username']";
	public static String passTextboxXpath = "//input[@id='password']";
	public static String loginButtonXpath = "//input[@value='login']";
	public static By welcomeMessageBy 	  = By.xpath("//div/h1[@align='center']");
	public static By welcomeAccountBy 	  = By.xpath("//div[@class='account']/strong");
	public static By messageErorBy 		  = By.xpath("//p[@class='message error LoginForm']");
	public static By forgotPasswordLinkBy = By.xpath("//li/a[contains(text(),'Forgot Password page')]");
	
	
	// Action Login
	public static void actLogin(String userName, String passWord) {

		// Click Login menu
		basePage.actSelectMenu("Login");

		// Enter user name and password then click Login
		Configs.driver.findElement(By.xpath(userTextboxXpath)).sendKeys(userName);
		Configs.driver.findElement(By.xpath(passTextboxXpath)).sendKeys(passWord);
		Configs.driver.findElement(By.xpath(loginButtonXpath)).click();
	}

	// Actions check the message
	public static void actCheckMessage(By messageByElement,String expectedMessage) {
		WebDriverWait wait = new WebDriverWait(Configs.driver, Duration.ofSeconds(30));
		WebElement displayedMessage = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(messageByElement));
		String displayText = displayedMessage.getText();
		String expectedText = expectedMessage;
		
		Assert.assertEquals(displayText, expectedText, "The message is: '" + displayText +"'");
	}
	
	
}
