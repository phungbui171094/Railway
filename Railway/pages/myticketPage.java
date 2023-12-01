package Railway.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Railway.Configs;

public class myticketPage {

	// Elements
	public static String dynamicTicketXpath = "//table/tbody/tr[td[text()='%s' and following-sibling ::td[text()='%s' and following-sibling ::td[text()='%s'  and following-sibling ::td[text()='%s' and following-sibling ::td[text()='%s']]]]]]";
	public static String dynamicCancelBtnXpath = "//table/tbody/tr[td[text()='%s' and following-sibling ::td[text()='%s' and following-sibling ::td[text()='%s'  and following-sibling ::td[text()='%s' and following-sibling ::td[text()='%s']]]]]]/td/input[@value='Cancel']";

	// Actions
	// Action Cancel the ticket
	public static void actCancelTicket(String departFr, String arriveAt, String seatType, String departDate,
			String ticketAmount) {

		String TicketString = String.format(dynamicCancelBtnXpath, departFr, arriveAt, seatType, departDate,
				ticketAmount);
		Configs.driver.findElement(By.xpath(TicketString)).click();
	}

	// Action click on the confirm pop-up
	public static void actClickPopUp(String Message, String acceptOrCancel) {

		// Focus on pop-up
		Alert popUp = Configs.driver.switchTo().alert();
		String popUpMessage = Configs.driver.switchTo().alert().getText();

		if (popUpMessage.contentEquals(Message)) {

			if (acceptOrCancel.contains("accept")) {

				// Click Accept/OK on the alert
				popUp.accept();
			}

			if (acceptOrCancel.contains("cancel")) {

				// Click Cancel on the alert
				popUp.dismiss();
			}

		} else {

			// Print the message for checking
			System.out.println("The message of pop-up: " + popUpMessage);
		}
	}

	// Action return the amount of ticket
	public static int actGetTicketElement(String departFr, String arriveAt, String seatType, String departDate,
			String ticketAmount) {

		String TicketString = String.format(dynamicCancelBtnXpath, departFr, arriveAt, seatType, departDate, ticketAmount);

		List<WebElement> elements = Configs.driver.findElements(By.xpath(TicketString));

		int numberOfElement = elements.size();
		return numberOfElement;

	}

}
