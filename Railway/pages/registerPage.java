package Railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Railway.Configs;

public class registerPage {

	// Elements
	public static By centerLableBy = By.xpath("//h1[@align='center']");
	public static By createAccountLableBy = By.xpath("//h1[@align='center' and 'Create account']");
	public static By emailTxtBoxBy = By.xpath("//fieldset//input[@id='email']");
	public static By passwordTxtBoxBy = By.xpath("//fieldset//input[@id='password']");
	public static By confirmPasswordTxtBoxBy = By.xpath("//fieldset//input[@id='confirmPassword']");
	public static By pidTxtBoxBy = By.xpath("//fieldset//input[@id='pid']");
	public static By registerBtnBy = By.xpath("//p/input[@type='submit']");
	public static By messageErrorBy = By.xpath("//div/p[@class='message error']");
	public static By validationErrorPasswordBy = By.xpath("//fieldset//label[@class='validation-error' and @for='password']");
	public static By validationErrorPidBy = By.xpath("//fieldset//label[@class='validation-error' and @for='pid']");
	public static By confirmActivateBy = By.xpath("//div[@id='content']/p");
	// Actions
	public static void actCreateAccount(String email, String password, String confirmPassword, String pidNumber) {

		Configs.driver.findElement(emailTxtBoxBy).sendKeys(email);
		Configs.driver.findElement(passwordTxtBoxBy).sendKeys(password);
		Configs.driver.findElement(confirmPasswordTxtBoxBy).sendKeys(confirmPassword);
		Configs.driver.findElement(pidTxtBoxBy).sendKeys(pidNumber);

		// Scroll to Register button and click
		((JavascriptExecutor) Configs.driver).executeScript("arguments[0].scrollIntoView(true);",
				Configs.driver.findElement(registerBtnBy));
		Configs.driver.findElement(registerBtnBy).click();

	}

}
