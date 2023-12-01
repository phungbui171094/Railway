package Railway.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Railway.Configs;

public class BaseTest {

	@BeforeMethod
	public void startBrowser() {
		Configs.actStartAUT("chrome");
	}

	@AfterMethod
	public void quitBrowser() {
		Configs.driver.quit();
	}

}