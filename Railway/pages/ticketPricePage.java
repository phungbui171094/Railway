package Railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Railway.Configs;

public class ticketPricePage {

	// Elements
	public static String dynamicBookTicketTicketPriceButton = "//tr[td[text()='%s']]//td[a[text()='Book ticket']]";
	//Price table //table/tbody[tr[th[contains(text(),'Seat type') and following-sibling ::td[contains(text(),'%s')]]]]/tr[th[contains(text(),'Price (VND)')]]/td[contains(text(),'%s')]
	public static By headerLableBy = By.xpath("//table//tr[@class='TableSmallHeader']/th");
	public static String dynamicTicketPriceXpath = "//table/tbody[tr[th[contains(text(),'Seat type') and following-sibling ::td[contains(text(),'%s')]]]]/tr[th[contains(text(),'Price (VND)')]]/td[contains(text(),'%s')]";

	// Actions
	// Action click 'book ticket' from ticket price page
	public static void actBookTicket(WebDriver driver, String seatType) {
		String bookTicketButton = String.format(dynamicBookTicketTicketPriceButton, seatType);
		driver.findElement(By.xpath(bookTicketButton)).click();
	}
	
	// Action check ticket price
	public static void actCheckTicketPrice(String seatType, String expectedPrice) {
		String ticketPriceXpath = String.format(dynamicTicketPriceXpath, seatType, expectedPrice);
		WebElement ticketPriceElement = Configs.driver.findElement(By.xpath(ticketPriceXpath));
		
		//Check element is display
		ticketPriceElement.isDisplayed();
	}

}
