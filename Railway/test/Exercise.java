package Railway.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Railway.Configs;
import Railway.dataProvider.data;
import Railway.pages.basePage;
import Railway.pages.bookTicketPage;
import Railway.pages.loginPage;
import Railway.pages.myticketPage;
import Railway.pages.registerPage;
import Railway.pages.resetPasswordPage;
import Railway.pages.ticketPricePage;
import Railway.pages.timetablePage;
import Railway.pages.webMailPage;

public class Exercise extends BaseTest {

	@Test(dataProvider = "TC01", dataProviderClass = data.class)
	public void TC01(String userName, String passWord) {

		System.out.println();
		System.out.println("TC 01: User can log into Railway with valid username and password");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Click on 'Login' tab");
		System.out.println("Step 3: Enter valid Email and Password");
		System.out.println("Step 4: Click on 'Login' button");
		loginPage.actLogin(userName, passWord);

		System.out.println("Verify point: User is logged into Railway");
		loginPage.actCheckMessage(loginPage.welcomeAccountBy, "Welcome " + userName);

		System.out.println("Verify point: Welcome user message is displayed");
		loginPage.actCheckMessage(loginPage.welcomeMessageBy, "Welcome to Safe Railway");
	}

	@Test(dataProvider = "TC02", dataProviderClass = data.class)
	public void TC02(String userName, String passWord) {

		System.out.println();
		System.out.println("TC 02: User cannot login with blank 'Username' textbox");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Click on 'Login' tab");
		System.out.println(
				"Step 3: User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox");
		System.out.println("Step 4: Click on 'Login' button");
		loginPage.actLogin(userName, passWord);

		System.out.println("Verify point: User is can not login");
		loginPage.actCheckMessage(loginPage.welcomeAccountBy, "Welcome guest!");

		System.out.println(
				"Verify point: Message 'There was a problem with your login and/or errors exist in your form.' appears");
		loginPage.actCheckMessage(loginPage.messageErorBy,
				"There was a problem with your login and/or errors exist in your form.");
	}

	@Test(dataProvider = "TC03", dataProviderClass = data.class)
	public void TC03(String userName, String passWord) {

		System.out.println();
		System.out.println("TC 03: User cannot log into Railway with invalid password");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Click on 'Login' tab");
		System.out.println("Step 3: Enter valid Email and invalid Password");
		System.out.println("Step 4: Click on 'Login' button");
		loginPage.actLogin(userName, passWord);

		System.out.println("Verify point: User is can not login");
		loginPage.actCheckMessage(loginPage.welcomeAccountBy, "Welcome guest!");

		System.out.println(
				"Verify point: Error message 'There was a problem with your login and/or errors exist in your form.' is displayed");
		loginPage.actCheckMessage(loginPage.messageErorBy,
				"There was a problem with your login and/or errors exist in your form.");
	}

	@Test(dataProvider = "TC05", dataProviderClass = data.class)
	public void TC05(String userName, String passWord) {

		System.out.println();
		System.out.println("TC 05: User can't login with an account hasn't been activated");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Click on 'Login' tab");
		System.out.println("Step 3: Enter username and password of account hasn't been activated.");
		System.out.println("Step 4: Click on 'Login' button");
		loginPage.actLogin(userName, passWord);

		System.out.println("Verify point: User is can not login");
		loginPage.actCheckMessage(loginPage.welcomeAccountBy, "Welcome guest!");

		System.out.println("Verify point: Message 'Invalid username or password. Please try again.' appears");
		loginPage.actCheckMessage(loginPage.messageErorBy, "Invalid username or password. Please try again.");
	}

	@Test(dataProvider = "TC01", dataProviderClass = data.class)
	public void TC06(String userName, String passWord) {

		System.out.println();
		System.out.println("TC 06: User is redirected to Home page after logging out");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with valid Email and Password");
		loginPage.actLogin(userName, passWord);

		System.out.println("Step 3: Click on 'FAQ' tab");
		basePage.actSelectMenu("FAQ");

		System.out.println("Step 4: Click on 'Log out' tab");
		basePage.actSelectMenu("Log out");

		System.out.println("Verify point: Home page displays");
		loginPage.actCheckMessage(loginPage.welcomeAccountBy, "Welcome guest!");
		loginPage.actCheckMessage(loginPage.welcomeMessageBy, "Welcome to Safe Railway");

		System.out.println("Verify point: 'Log out' tab is disappeared");
		basePage.actCheckTabMenuExist("Log out", "notExist");
	}

	@Test(dataProvider = "TC07", dataProviderClass = data.class)
	public void TC07(String userName, String passWord, String confirmPassword, String pidNumber) {

		System.out.println();
		System.out.println("TC 07: User can't create account with an already in-use email");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Click on 'Register' tab");
		basePage.actSelectMenu("Register");

		System.out.println("Step 3: Enter information of the created account in Pre-condition");
		System.out.println("Step 4: Click on 'Register' button");
		registerPage.actCreateAccount(userName, passWord, confirmPassword, pidNumber);

		System.out.println(
				"Verify point: Error message 'This email address is already in use.' displays above the form.");
		loginPage.actCheckMessage(registerPage.messageErrorBy, "This email address is already in use.");
	}

	@Test(dataProvider = "TC08", dataProviderClass = data.class)
	public void TC08(String userName, String passWord, String confirmPassword, String pidNumber) {

		System.out.println();
		System.out.println("TC 08: User can't create account while password and PID fields are empty");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Click on 'Register' tab");
		basePage.actSelectMenu("Register");

		System.out.println("Step 3: Enter valid email address and leave other fields empty");
		System.out.println("Step 4: Click on 'Register' button");
		registerPage.actCreateAccount(userName, passWord, confirmPassword, pidNumber);

		System.out.println(
				"Verify point: Error message 'There're errors in the form. Please correct the errors and try again.' displays above the form.");
		loginPage.actCheckMessage(registerPage.messageErrorBy,
				"There're errors in the form. Please correct the errors and try again.");

		System.out.println("Verify point: Next to password fields, error message 'Invalid password length' displays");
		loginPage.actCheckMessage(registerPage.validationErrorPasswordBy, "Invalid password length");

		System.out.println("Verify point: Next to PID field, error message 'Invalid ID length' displays");
		loginPage.actCheckMessage(registerPage.validationErrorPidBy, "Invalid ID length");
	}

	@Test(dataProvider = "TC09", dataProviderClass = data.class)
	public void TC09(String userName, String passWord, String confirmPassword, String pidNumber) {

		System.out.println();
		System.out.println("TC 09: User create and activate account");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println(
				"Verify point : Home page is shown with guide containing href 'create an account' to 'Register' page");
		basePage.actCheckElementExist(basePage.createAccountLinkBy, "exist");

		System.out.println("Step 2: Click on 'Create an account'");
		Configs.driver.findElement(basePage.createAccountLinkBy).click();

		System.out.println("Verify point : Register page is shown");
		basePage.actCheckElementExist(registerPage.createAccountLableBy, "exist");

		System.out.println("Step 3: Enter valid information into all fields");
		System.out.println("Step 4: Click on 'Register' button");
		registerPage.actCreateAccount(userName + "@" + Configs.hostName, passWord, confirmPassword, pidNumber);

		System.out.println("Verify point: 'Thank you for registering your account' is shown");
		loginPage.actCheckMessage(registerPage.centerLableBy, "Thank you for registering your account");

		System.out.println("Step 5: Navigate to the webmail");
		Configs.driver.get(Configs.webMailUrl);

		System.out.println("Step 6: Login to the mailbox");
		System.out.println(
				"Step 7: Open email with subject containing 'Please confirm your account' and the email of the new account at step 3");
		System.out.println("Step 8: Click on the activate link");
		webMailPage.actActivateAccount(userName);

		System.out.println(
				"Verify point: Redirect to Railways page and message 'Registration Confirmed! You can now log in to the site' is shown");
		basePage.actSwitchTab("Safe Railway - Registration Confirmation Page");
		loginPage.actCheckMessage(registerPage.confirmActivateBy,
				"Registration Confirmed! You can now log in to the site.");

	}

	@Test(dataProvider = "TC10", dataProviderClass = data.class)
	public void TC10(String userName, String password) {

		System.out.println();
		System.out.println("TC 10: Reset password shows error if the new password is same as current");
		System.out.println("Step 1: Navigate to QA Railway Login page");
		basePage.actSelectMenu("Login");

		System.out.println("Step 2: Click on 'Forgot Password page' link");
		Configs.driver.findElement(loginPage.forgotPasswordLinkBy).click();

		System.out.println("Step 3: Enter the email address of the activated account");
		Configs.driver.findElement(resetPasswordPage.emailTxtboxBy).sendKeys(userName + "@" + Configs.hostName);

		System.out.println("Step 4: Click on 'Send Instructions' button");
		Configs.driver.findElement(resetPasswordPage.sendInstructionsBtnBy).click();

		System.out.println("Step 5: Login to the mailbox (the same mailbox when creating account)");
		System.out.println(
				"Step 6: Open email with subject contaning 'Please reset your password' and the email of the account at step 3");
		System.out.println("Step 7: Click on reset link");
		webMailPage.actResetPassword(userName);

		System.out.println("Verify point: Redirect to Railways page and Form 'Password Change Form' is shown");
		basePage.actSwitchTab("Safe Railway - Password Reset");
		loginPage.actCheckMessage(resetPasswordPage.passwordChangeFormLableBy, "Password Change Form");

		System.out.println("Verify point: The reset password token is shown");
		basePage.actCheckElementHasValuet(resetPasswordPage.resetTokenTxtboxBy, "hasValue");

		System.out.println("Step 8: Input same password into 2 fields  'new password' and 'confirm password'");
		System.out.println("Step 9: Click Reset Password'");
		resetPasswordPage.actResetPassword(password, password);

		System.out.println(
				"Verify point: Message 'The new password cannot be the same with the current password' is shown");
		loginPage.actCheckMessage(resetPasswordPage.erorMessageBy,
				"The new password cannot be the same with the current password");

	}

	@Test(dataProvider = "TC11", dataProviderClass = data.class)
	public void TC11(String userName, String password, String confirmPassword) {

		System.out.println();
		System.out.println("TC 11: Reset password shows error if the new password and confirm password doesn't match");
		System.out.println("Step 1: Navigate to QA Railway Login page");
		basePage.actSelectMenu("Login");

		System.out.println("Step 2: Click on 'Forgot Password page' link");
		Configs.driver.findElement(loginPage.forgotPasswordLinkBy).click();

		System.out.println("Step 3: Enter the email address of the activated account");
		Configs.driver.findElement(resetPasswordPage.emailTxtboxBy).sendKeys(userName + "@" + Configs.hostName);

		System.out.println("Step 4: Click on 'Send Instructions' button");
		Configs.driver.findElement(resetPasswordPage.sendInstructionsBtnBy).click();

		System.out.println("Step 5: Login to the mailbox (the same mailbox when creating account)");
		System.out.println(
				"Step 6: Open email with subject contaning 'Please reset your password' and the email of the account at step 3");
		System.out.println("Step 7: Click on reset link");
		webMailPage.actResetPassword(userName);

		System.out.println("Verify point: Redirect to Railways page and Form 'Password Change Form' is shown");
		basePage.actSwitchTab("Safe Railway - Password Reset");
		loginPage.actCheckMessage(resetPasswordPage.passwordChangeFormLableBy, "Password Change Form");

		System.out.println("Verify point: The reset password token is shown");
		basePage.actCheckElementHasValuet(resetPasswordPage.resetTokenTxtboxBy, "hasValue");

		System.out.println("Step 8: Input same password into 2 fields  'new password' and 'confirm password'");
		System.out.println("Step 9: Click Reset Password'");
		resetPasswordPage.actResetPassword(password, confirmPassword);

		System.out.println(
				"Verify point: Error message 'Could not reset password. Please correct the errors and try again.' displays above the form.");
		loginPage.actCheckMessage(resetPasswordPage.erorMessageBy,
				"Could not reset password. Please correct the errors and try again.");

		System.out.println(
				"Verify point: Error message 'The password confirmation did not match the new password.' displays next to the confirm password field.");
		loginPage.actCheckMessage(resetPasswordPage.confirmPasswordErorBy,
				"The password confirmation did not match the new password.");

	}

	@Test(dataProvider = "TC12", dataProviderClass = data.class)
	public void TC12(String userName, String password, String departDate, String departFr, String arriveAt,
			String seatType, String ticketAmount) {

		System.out.println();
		System.out.println("TC 12: User can book 1 ticket at a time");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		loginPage.actLogin(userName, password);

		System.out.println("Step 3: Click on 'Book ticket' tab");
		basePage.actSelectMenu("Book ticket");

		System.out.println("Step 4: Select the next 12 days from 'Depart date'");
		System.out.println("Step 5: Select Depart from 'Nha Trang' and Arrive at 'Huế'");
		System.out.println("Step 6: Select 'Soft bed with air conditioner' for 'Seat type'");
		System.out.println("Step 7: Select '1' for 'Ticket amount'");
		System.out.println("Step 8: Click on 'Book ticket' button");
		bookTicketPage.actBookTicket(departDate, departFr, arriveAt, seatType, ticketAmount);

		System.out.println("Verify point: Message 'Ticket booked successfully!' displays.");
		loginPage.actCheckMessage(bookTicketPage.bookTicketSuccessfullyMessageBy, "Ticket booked successfully!");

		System.out.println(
				"Verify point: Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		bookTicketPage.actCheckTicketInfor(departDate, departFr, arriveAt, seatType, ticketAmount);
	}

	@Test(dataProvider = "TC13", dataProviderClass = data.class)
	public void TC13(String userName, String password, String departDate, String departFr, String arriveAt,
			String seatType, String ticketAmount) {

		System.out.println();
		System.out.println("TC 13: User can book many tickets at a time");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		loginPage.actLogin(userName, password);

		System.out.println("Step 3: Click on 'Book ticket' tab");
		basePage.actSelectMenu("Book ticket");

		System.out.println("Step 4: Select the next 25 days from 'Depart date'");
		System.out.println("Step 5: Select 'Nha Trang' for 'Depart from' and 'Sài Gòn' for 'Arrive at'.");
		System.out.println("Step 6: Select 'Soft bed with air conditioner' for 'Seat type'");
		System.out.println("Step 7: Select '5' for 'Ticket amount'");
		System.out.println("Step 8: Click on 'Book ticket' button");
		bookTicketPage.actBookTicket(departDate, departFr, arriveAt, seatType, ticketAmount);

		System.out.println("Verify point: Message 'Ticket booked successfully!' displays");
		loginPage.actCheckMessage(bookTicketPage.bookTicketSuccessfullyMessageBy, "Ticket booked successfully!");

		System.out.println(
				"Verify point: Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		bookTicketPage.actCheckTicketInfor(departDate, departFr, arriveAt, seatType, ticketAmount);
	}

	@Test(dataProvider = "TC14", dataProviderClass = data.class)
	public void TC14(String userName, String password, String departFr, String arriveAt) {

		System.out.println();
		System.out.println("TC 14: User can check price of ticket from Timetable");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		loginPage.actLogin(userName, password);

		System.out.println("Step 3: Click on 'Timetable' tab");
		basePage.actSelectMenu("Timetable");

		System.out.println("Step 4: Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");
		timetablePage.actCheckPrice(departFr, arriveAt);

		System.out.println("Verify point: 'Ticket Price' page is loaded");
		basePage.actCheckPageTitle("Safe Railway - Ticket Price");

		System.out.println("Verify point: Ticket table shows 'Ticket price from Đà Nẵng to Sài Gòn'");
		loginPage.actCheckMessage(ticketPricePage.headerLableBy, "Ticket price from Đà Nẵng to Sài Gòn");

		System.out.println("Verify point: Price for each seat displays correctly");
		ticketPricePage.actCheckTicketPrice("HS", "310000");
		ticketPricePage.actCheckTicketPrice("SS", "335000");
		ticketPricePage.actCheckTicketPrice("SSC", "360000");
		ticketPricePage.actCheckTicketPrice("HB", "410000");
		ticketPricePage.actCheckTicketPrice("SB", "460000");
		ticketPricePage.actCheckTicketPrice("SBC", "510000");
	}

	@Test(dataProvider = "TC15", dataProviderClass = data.class)
	public void TC15(String userName, String password, String departFr, String arriveAt) {

		System.out.println();
		System.out.println("TC 15: User can book ticket from Timetable");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		loginPage.actLogin(userName, password);

		System.out.println("Step 3: Click on 'Timetable' tab");
		basePage.actSelectMenu("Timetable");

		System.out.println("Step 4: Click on book ticket of route 'Quảng Ngãi' to 'Huế'");
		timetablePage.actBookTicket(departFr, arriveAt);

		System.out.println("Verify point: Book ticket form is shown with the corrected 'depart from' and 'Arrive at'");
		bookTicketPage.actCheckSelectedValue(bookTicketPage.departFromSelectionBy, departFr);
		bookTicketPage.actCheckSelectedValue(bookTicketPage.arriveAtSelectionBy, arriveAt);

		System.out.println("Step 5: Select Depart date next 10 days");
		System.out.println("Step 6: Select Ticket amount = 5");
		System.out.println("Step 7: Click on 'Book ticket' button");
		bookTicketPage.actBookTicket(bookTicketPage.actPlusAndFormatDate(10), null, null, null, "5");

		System.out.println("Verify point: Message 'Ticket booked successfully!' displays");
		loginPage.actCheckMessage(bookTicketPage.bookTicketSuccessfullyMessageBy, "Ticket booked successfully!");

		System.out.println(
				"Verify point: Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		bookTicketPage.actCheckTicketInfor(bookTicketPage.actPlusAndFormatDate(10), departFr, arriveAt, "Hard seat",
				"5");
	}

	@Test(dataProvider = "TC16", dataProviderClass = data.class)
	public void TC16(String userName, String password, String departDate, String departFr, String arriveAt,
			String seatType, String ticketAmount) {

		System.out.println();
		System.out.println("TC 16: User can cancel a ticket");
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		loginPage.actLogin(userName, password);

		System.out.println("Step 3: Book a ticket");
		basePage.actSelectMenu("Book ticket");
		bookTicketPage.actBookTicket(departDate, departFr, arriveAt, seatType, ticketAmount);

		System.out.println("Step 4: Click on 'My ticket' tab");
		basePage.actSelectMenu("My ticket");

		// Get amount of ticket element before delete
		int numberOfElementBe4 = myticketPage.actGetTicketElement(departFr, arriveAt, seatType, departDate, ticketAmount);
		System.out.println("Number of ticket before delete: " + numberOfElementBe4);

		System.out.println("Step 5: Click on 'Cancel' button of ticket which user want to cancel");
		myticketPage.actCancelTicket(departFr, arriveAt, seatType, departDate, ticketAmount);

		System.out.println("Step 6: Click on 'OK' button on Confirmation message 'Are you sure?'");
		myticketPage.actClickPopUp("Are you sure?", "accept");

		// Refresh the page
		Configs.driver.navigate().refresh();
		
		System.out.println("Verify point: The canceled ticket is disappeared");
		// Get amount of ticket element after deleted
		int numberOfElementAfter = myticketPage.actGetTicketElement(departFr, arriveAt, seatType, departDate, ticketAmount);
		System.out.println("Number of ticket after deleted: " + numberOfElementAfter);

		assertEquals(numberOfElementAfter, numberOfElementBe4 - 1, "The ticket is not deleted");

	}

}
