package Railway;

import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configs {

	// Railway URL
	public static String railwayUrl = "http://saferailway.somee.com/";

	// Web mail
	public static String webMailUrl = "https://www.guerrillamail.com/";
	public static String hostName = "grr.la";

	// Set Driver Location
	public static String chromeDriverLocation = "Driver/chromedriver.exe";
	public static String firefoxDriverLocation = "Driver/geckodriver.exe";

	// Set Driver
	public static WebDriver driver;
	
	// Date formater
	public static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/d/yyyy");
	public static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	// Action set driver and start browser
	public static void actStartAUT(String typeBrowser) {
		String browser = typeBrowser;

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
			driver = new ChromeDriver();

		}

		if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(railwayUrl);
	}


}