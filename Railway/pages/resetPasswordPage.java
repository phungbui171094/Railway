package Railway.pages;

import org.openqa.selenium.By;

import Railway.Configs;

public class resetPasswordPage {

	// Elements
	public static By emailTxtboxBy = By.xpath("//input[@id='email']");
	public static By sendInstructionsBtnBy = By.xpath("//input[@type='submit' and @value='Send Instructions']");
	// Password change form
	public static By passwordChangeFormLableBy = By.xpath("//legend[contains(text(),'Password Change Form')]");
	public static By newPasswordTxtboxBy = By.xpath("//input[@id='newPassword']");
	public static By confirmPasswordTxtboxBy = By.xpath("//input[@id='confirmPassword']");
	public static By resetTokenTxtboxBy = By.xpath("//input[@id='resetToken']");
	public static By resetPasswordBtnBy = By.xpath("//input[@type='submit' and @value='Reset Password']");
	// Eror message /
	public static By erorMessageBy = By.xpath("//p[@class='message error']");
	// Confirm password error message 
	public static By confirmPasswordErorBy = By.xpath("//li[@class='confirm-password']/label[@class='validation-error']");


	// Actions
	// Actions reset password
	public static void actResetPassword(String newPassword, String confirmPassword) {

		Configs.driver.findElement(newPasswordTxtboxBy).sendKeys(newPassword);
		Configs.driver.findElement(confirmPasswordTxtboxBy).sendKeys(confirmPassword);
		Configs.driver.findElement(resetPasswordBtnBy).click();

	}

}
