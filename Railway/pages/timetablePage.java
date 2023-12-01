package Railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Railway.Configs;

public class timetablePage {

	// Elements
	public static String dynamicCheckPriceButton = "//table[thead[tr[th[contains(text(),'Depart Station')]]]]/tbody/tr[td[contains(text(),'%s') and following-sibling::td[contains(text(),'%s')]]]/td/a[contains(text(),'check price')]";
	public static String dynamicBookTicketTimeTableButton = "//table[thead[tr[th[contains(text(),'Depart Station')]]]]/tbody/tr[td[contains(text(),'%s') and following-sibling::td[contains(text(),'%s')]]]/td/a[contains(text(),'book ticket')]";
	
	// Actions click "check price" button
	public static void actCheckPrice(String DepartStation, String ArriveStation) {
		
		// Scroll to the element
		String checkPriceButton = String.format(dynamicCheckPriceButton, DepartStation, ArriveStation);
		((JavascriptExecutor) Configs.driver).executeScript("arguments[0].scrollIntoView(true);",
				Configs.driver.findElement(By.xpath(checkPriceButton)));
		
		Configs.driver.findElement(By.xpath(checkPriceButton)).click();
	}

	// Action click "book ticket" button
	public static void actBookTicket(String DepartStation, String ArriveStation) {

		// Scroll to the element
		String bookTicketButton = String.format(dynamicBookTicketTimeTableButton, DepartStation, ArriveStation);
		((JavascriptExecutor) Configs.driver).executeScript("arguments[0].scrollIntoView(true);",
				Configs.driver.findElement(By.xpath(bookTicketButton)));
		
		Configs.driver.findElement(By.xpath(bookTicketButton)).click();
	}

}
