package Railway.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Railway.Configs;

public class basePage {
//	new change 2nd
	// Elements
	public static String dynamicMenu = "//a[span='%s']";
	public static By createAccountLinkBy = By.xpath("//div[@id='content']//a['create an account']");

	// Actions
	// Action Select menu
	public static void actSelectMenu(String menuName) {

		String menuNameXpath = String.format(dynamicMenu, menuName);
		Configs.driver.findElement(By.xpath(menuNameXpath)).click();
	}

	// Action Check tab menu exists (exist/notExist)
	public static void actCheckTabMenuExist(String tabName, String existOrnotExist) {

		String menuNameXpath = String.format(dynamicMenu, tabName);
		List<WebElement> elements = Configs.driver.findElements(By.xpath(menuNameXpath));
		if (elements.size() == 0) {
			Assert.assertEquals(existOrnotExist, "notExist", "The tab menu exists");
		} else {
			Assert.assertEquals(existOrnotExist, "exist", "The tab menu not exists");
		}
	}

	// Action element exists (exist/notExist)
	public static void actCheckElementExist(By Element, String existOrnotExist) {

		List<WebElement> elements = Configs.driver.findElements(Element);
		if (elements.size() == 0) {
			Assert.assertEquals(existOrnotExist, "notExist", "The element exists");
		} else {
			Assert.assertEquals(existOrnotExist, "exist", "The element not exists");
		}
	}

	// Action switch tab
	public static void actSwitchTab(String tabTitle) {

		// Get all tab titles
		Set<String> allHandles = Configs.driver.getWindowHandles();

		// Switch to the desired tab
		for (String handle : allHandles) {
			Configs.driver.switchTo().window(handle);
			String title = Configs.driver.getTitle();
			if (title.equals(tabTitle)) {
				// Already switch to the tab
				break;
			}
		}
	}

	// Action check Element has value
	public static void actCheckElementHasValuet(By Element, String hasValueORhasNot) {

		String value = Configs.driver.findElement(Element).getAttribute("value");

		if (Element != null && !value.isEmpty()) {
			Assert.assertEquals(hasValueORhasNot, "hasValue", "The element has no value");
		} else {
			Assert.assertEquals(hasValueORhasNot, "hasNot", "The element has value");
		}
	}

	// Action check page title
	public static void actCheckPageTitle(String expectedTitle) {

		String title = Configs.driver.getTitle();
		Assert.assertEquals(title, expectedTitle, "The Titlle is: '" + title + "'");
	}
	
}
