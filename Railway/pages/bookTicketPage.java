package Railway.pages;

import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Railway.Configs;

public class bookTicketPage {

	// Elements
	public static String departDateSelectionXpath 	= "//select[@name='Date']";
	public static String departFromSelectionXpath 	= "//select[@name='DepartStation']";
	public static String arriveAtSelectionXpath 	= "//span/select[@name='ArriveStation']";
	public static String seatTypeSelectionXpath 	= "//select[@name='SeatType']";
	public static String ticketAmountSelectionXpath = "//select[@name='TicketAmount']";
	public static String bookTicketBookTicketPageButtonXpath = "//input[@type='submit']";
	public static By 	departFromSelectionBy 		= By.xpath("//select[@name='DepartStation']");
	public static By 	arriveAtSelectionBy 		= By.xpath("//span/select[@name='ArriveStation']");

	// Book Ticket successfully
	public static String bookTicketSuccessfullyMessageXpath = "//div//h1[@align='center']";
	public static By bookTicketSuccessfullyMessageBy = By.xpath(bookTicketSuccessfullyMessageXpath);
	public static String dynamicTicketInforXpath = "//table[@class='MyTable WideTable']//tbody[tr[@class='TableSmallHeader']/th[contains(text(),'%s')]]/tr/td[contains(text(),'%s')]";

	// Actions plus date from curent date and format
	public static String actPlusAndFormatDate(int plusDate) {
		LocalDate currentDate = LocalDate.now();
		LocalDate manyDaysLater = currentDate.plusDays(plusDate);
		int onlyDate = manyDaysLater.getDayOfMonth();

		if (onlyDate > 9) {
			String formatedDate = manyDaysLater.format(Configs.formatter2);
			return formatedDate;
		} else {
			String formatedDate = manyDaysLater.format(Configs.formatter1);
			return formatedDate;
		}

	}

	// Actions book ticket
	public static void actBookTicket(String departDate, String departFrom, String arriveAt, String seatType,
			String ticketAmount) {

		// Scroll to Book Ticket button
		((JavascriptExecutor) Configs.driver).executeScript("arguments[0].scrollIntoView(true);",
				Configs.driver.findElement(By.xpath(bookTicketBookTicketPageButtonXpath)));

		if (departDate != null) {
			Select selectDepartDate = new Select(Configs.driver.findElement(By.xpath(departDateSelectionXpath)));
			selectDepartDate.selectByVisibleText(departDate);
		}

		if (departFrom != null) {
			Select selectDepartFrom = new Select(Configs.driver.findElement(By.xpath(departFromSelectionXpath)));
			selectDepartFrom.selectByVisibleText(departFrom);
		}

		if (arriveAt != null) {

			// Wait for the element stable
			WebElement arriveAtElement = Configs.driver.findElement(By.xpath(arriveAtSelectionXpath));
			WebDriverWait wait = new WebDriverWait(Configs.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(arriveAtElement)));

			// Select
			WebElement arriveAtSelectElement = Configs.driver.findElement(By.xpath(arriveAtSelectionXpath));
			Select selectAriveAt = new Select(arriveAtSelectElement);
			selectAriveAt.selectByVisibleText(arriveAt);
		}

		if (seatType != null) {
			Select selectSeatType = new Select(Configs.driver.findElement(By.xpath(seatTypeSelectionXpath)));
			selectSeatType.selectByVisibleText(seatType);
		}

		if (ticketAmount != null) {
			Select selectTicketAmount = new Select(Configs.driver.findElement(By.xpath(ticketAmountSelectionXpath)));
			selectTicketAmount.selectByVisibleText(ticketAmount);
		}

		Configs.driver.findElement(By.xpath(bookTicketBookTicketPageButtonXpath)).click();
	}

	// Actions check the message
	public static void actCheckMessage(WebDriver driver, String expectedMessage) {
		WebElement displayedMessage = driver.findElement(By.xpath(bookTicketSuccessfullyMessageXpath));
		String displayText = displayedMessage.getText();
		String expectedText = expectedMessage;

		Assert.assertEquals(displayText, expectedText, "The message is: " + displayText);
	}

	// Actions check the booked ticket infor (after booking successfully)
	public static void actCheckTicketInfor(String departDate, String departStation, String ariveStation,
			String seatType, String ticketAmount) {

		if (departDate != null) {
			String bookTicketInfor = String.format(dynamicTicketInforXpath, "Depart Date", departDate);
			By bookTicketInforBy = By.xpath(bookTicketInfor);
			Configs.driver.findElement(bookTicketInforBy).isDisplayed();
			System.out.println("Depart date is correct");
		}

		if (departStation != null) {
			String bookTicketInfor = String.format(dynamicTicketInforXpath, "Depart Station", departStation);
			By bookTicketInforBy = By.xpath(bookTicketInfor);
			Configs.driver.findElement(bookTicketInforBy).isDisplayed();
			System.out.println("Depart station is correct");
		}

		if (ariveStation != null) {
			String bookTicketInfor = String.format(dynamicTicketInforXpath, "Arrive Station", ariveStation);
			By bookTicketInforBy = By.xpath(bookTicketInfor);
			Configs.driver.findElement(bookTicketInforBy).isDisplayed();
			System.out.println("Arive Station is correct");
		}

		if (seatType != null) {
			String bookTicketInfor = String.format(dynamicTicketInforXpath, "Seat Type", seatType);
			By bookTicketInforBy = By.xpath(bookTicketInfor);
			Configs.driver.findElement(bookTicketInforBy).isDisplayed();
			System.out.println("Seat type is correct");
		}

		if (ticketAmount != null) {
			String bookTicketInfor = String.format(dynamicTicketInforXpath, "Amount", ticketAmount);
			By bookTicketInforBy = By.xpath(bookTicketInfor);
			Configs.driver.findElement(bookTicketInforBy).isDisplayed();
			System.out.println("Ticket amount is correct");
		}
	}
	
	// Action check selected value
		public static void actCheckSelectedValue(By Element, String expectedValue) {
			
			Select select = new Select(Configs.driver.findElement(Element));
			WebElement selectedOption = select.getFirstSelectedOption();
			String actualValue = selectedOption.getText();

			Assert.assertEquals(actualValue, expectedValue, "The actual value is: '" + actualValue + "'");
		}

}
