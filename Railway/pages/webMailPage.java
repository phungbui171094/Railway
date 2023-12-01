package Railway.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Railway.Configs;

public class webMailPage {

	// Elements
	public static By mailNameBy = By.xpath("//div/span/span[@id='inbox-id']");
	public static By inputNameTxtBxBy = By.xpath("//div/span/span/input[@type='text']");
	public static By setNameBtnBy = By.xpath("//div/span/span/button[@class='save button small']");
	public static By selectHostBy = By.xpath("//div/span/select[@id='gm-host-select']");
	// For activate account
	public static String confirmMailXpath = "//td[contains(text(),'Please confirm your account %s')]";
	// %s = 'test09@grr.la' = mailName + "@" + hostName
	public static By activateLinkBy = By.xpath("//div[@class='email_body']/a[@href and 'to activate your account.']");
	// For reset password
	public static String resetMailXpath = "//td[contains(text(),'Please reset your password %s')]";
	public static By resetPasswordLinkBy = By.xpath("//div[@class='email_body']/a[@href and ' to reset your password.']");

	// Action click on the web mail to activate acccount
	public static void actActivateAccount(String mailName) {
		
		// Navigate to the Web Mail
		Configs.driver.get(Configs.webMailUrl);

		// Select mail host
		Select selectHost = new Select(Configs.driver.findElement(selectHostBy));
		selectHost.selectByVisibleText(Configs.hostName);

		// Click on Name field
		Configs.driver.findElement(mailNameBy).click();

		// Enter mail Name and click Set
		Configs.driver.findElement(inputNameTxtBxBy).sendKeys(mailName);
		Configs.driver.findElement(setNameBtnBy).click();

		// Click to the mail
		String confirmMail = String.format(confirmMailXpath, mailName + "@" + Configs.hostName);
		WebDriverWait wait = new WebDriverWait(Configs.driver, Duration.ofSeconds(30));
		WebElement confirmMailElement = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmMail)));
		confirmMailElement.click();
		
		 //Click to the link to activate
		WebElement activateLinkElement = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(activateLinkBy));
		activateLinkElement.click();
	}
	
	// Action click on the web mail to reset password
		public static void actResetPassword(String mailName) {
			
			// Navigate to the Web Mail
			Configs.driver.get(Configs.webMailUrl);

			// Select mail host
			Select selectHost = new Select(Configs.driver.findElement(selectHostBy));
			selectHost.selectByVisibleText(Configs.hostName);

			// Click on Name field
			Configs.driver.findElement(mailNameBy).click();

			// Enter mail Name and click Set
			Configs.driver.findElement(inputNameTxtBxBy).sendKeys(mailName);
			Configs.driver.findElement(setNameBtnBy).click();

			// Click to the mail
			String resetMail = String.format(resetMailXpath, mailName + "@" + Configs.hostName);
			WebDriverWait wait = new WebDriverWait(Configs.driver, Duration.ofSeconds(30));
			WebElement resetMailElement = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(resetMail)));
			resetMailElement.click();
			
			 //Click to the link to reset password
			WebElement resetLinkElement = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordLinkBy));
			resetLinkElement.click();
		}

}
