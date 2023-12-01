package Railway.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Railway.Configs;
import Railway.dataProvider.data;
import Railway.pages.loginPage;

public class TC04 {

	@BeforeTest
	public void startBrowser() {
		Configs.actStartAUT("chrome");
	}
	
	@AfterTest
	public void quitBrowser() {
		Configs.driver.quit();
	}
	
	@Test(dataProvider = "TC04", dataProviderClass = data.class)
	public static void enter(String userName, String passWord) {

		// Login with valid data
		loginPage.actLogin(userName, passWord);

		// Verify point : User is can not login
		loginPage.actCheckMessage(loginPage.welcomeAccountBy, "Welcome guest!");

		// Verify point : Welcome user message is displayed
		loginPage.actCheckMessage(loginPage.messageErorBy, "Invalid username or password. Please try again.");

	}

}
