package pages;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import config.Settings;
import utility.GenerateRandomData;
import utility.ThursdayFinder;
import utility.Util;

public class HearingManagementPage extends BasePage {
	@FindBy(how = How.XPATH, using = "//input[@name='citation_number']")
	public WebElement citationNumberTextbox;

	@FindBy(how = How.XPATH, using = "//button[text()='Submit']")
	public WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Check Date')]/following-sibling::div//input")
	public WebElement checkDateFiled;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Check Number')]/following-sibling::input")
	public WebElement checkNumberTextBox;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Check Received Date')]/following-sibling::div//input")
	public WebElement checkRecDateFiled;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/hearingCitations')]/parent::li")
	public WebElement hearingEligibleTicketsMenu;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Create Hearing')]/parent::li")
	public WebElement createHearingMenu;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Create Hearing')]")
	public WebElement createHearingButton;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Create Hearing')]/parent::div/following-sibling::div//button[contains(text(),'Submit')]")
	public WebElement submitButtonOfCreateHearingPopup;

	@FindBy(how = How.XPATH, using = "//img[contains(@class,'img-fluid')]/parent::button")
	public WebElement backButtonFromHearingFlow;

	// Create Hearing Popup Elements
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	public WebElement firstNameFieldInCreateHearingPopup;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	public WebElement lastNameFieldInCreateHearingPopup;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement emailFieldInCreateHearingPopup;

	@FindBy(how = How.XPATH, using = "//input[@name='phone']")
	public WebElement phoneFieldInCreateHearingPopup;

	// Available Hearing Slots Popup Elements
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cstm-confirmation-popup-available-hearing-slots')]//div[contains(text(),'times slot available')]")
	public WebElement timesSlotAvailableText;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cstm-confirmation-popup-available-hearing-slots')]//div[contains(text(),'10:00 - 17:00')]")
	public WebElement timeSlot1000To1700;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cstm-confirmation-popup-available-hearing-slots')]//button[contains(text(),'Select Hearing')]")
	public WebElement selectHearingButton;

	// ===== HEARING REQUESTS SEARCH FUNCTIONALITY LOCATORS =====
	// Locator for Hearing Requests menu under Hearing Management
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/requested-hearings') and contains(text(),'Hearing Requests')]")
	public WebElement hearingRequestsMenu;

	// Locator for Search Citation input field in Hearing Requests page
	@FindBy(how = How.XPATH, using = "//input[@name='ticket_no' and @placeholder='Search Citation']")
	public WebElement searchCitationInputField;

	// Locator for LP Number input field in Hearing Requests page
	@FindBy(how = How.XPATH, using = "//input[@name='lp_number' and @placeholder='LP Number']")
	public WebElement searchLPNumberInputField;

	// Locator for Submit button in Hearing Requests search form
	@FindBy(how = How.XPATH, using = "//form//button[@type='submit' and contains(@class,'licence-print')]")
	public WebElement submitButtonFromHearingRequestsSearch;
	
	// Ticket Number field in Create Hearing popup - NEW UI ELEMENT
	@FindBy(how=How.XPATH, using="//input[@name='ticket-0']")
	public WebElement ticketNumberFieldInCreateHearingPopup;

	public void navigateToTab(String tabName)
	{
		String path = "//*[contains(text(),'" + tabName + "')]/ancestor::a";
		try 
		{
			driverUtilities.get().waitForElementToBePresent2(path);
		} 
		catch(TimeoutException e) 
		{
		}
		WebElement pathEle = driverUtilities.get().getWebElement(path);
		driverUtilities.get().clickOnElement(pathEle);
	}

	public void clickOnSubmit() {
		driverUtilities.get().makeElementVisibleIntoScreen(submitButton);
		driverUtilities.get().clickOnElement(submitButton);
	}

	public void enterTodayDateIntoCheckDate() {
		String todayDate = Util.getCurrentSystemDate("MM/dd/yyyy");
		// driverUtilities.get().setAttributeOfElement(checkDateFiled, "value",
		// todayDate);
		driverUtilities.get().typeIntoTextBox(checkDateFiled, todayDate);
	}

	public String enterCheckNumber() {
		String checkNumber = GenerateRandomData.getPhoneNumber();
		driverUtilities.get().typeIntoTextBox(checkNumberTextBox, checkNumber);
		return checkNumber;
	}

	public void enterTodayDateIntoCheckRecDate() {
		String todayDate = Util.getCurrentSystemDate("MM/dd/yyyy");
		// driverUtilities.get().setAttributeOfElement(checkRecDateFiled, "value",
		// todayDate);
		driverUtilities.get().typeIntoTextBox(checkRecDateFiled, todayDate);
	}

	public void clickOnHearingEligibleMenu() {
		String hearingEligiblityVisible = Settings.isHearingEligibility;
		if (hearingEligiblityVisible.equalsIgnoreCase("true")) {
			driverUtilities.get().clickOnElement(hearingEligibleTicketsMenu);
		} else {
			Assert.fail("Hearing eligibility menu is not available for " + Settings.clientName);
		}
	}

	public void clickOnCreateHearingMenu() {
		String hearing = Settings.canHearing;
		if (hearing.equalsIgnoreCase("true")) {
			driverUtilities.get().clickOnElement(createHearingMenu);
		} else {
			Assert.fail("Hearing is not available for " + Settings.clientName);
		}
	}

	public void selectHearingEligibleTickets(String citation) {
		String valPath = "//table[@id='cstm-report-tb-display']/tbody/tr/td/a[contains(text(),'" + citation
				+ "')]/parent::td/preceding-sibling::td/input";
		try {
			driverUtilities.get().waitForElementToBePresent2(valPath);
		} catch (TimeoutException e) {
		}
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		driverUtilities.get().clickOnElement(valPathEle);
	}

	public void clickOnCreateHearingButton() {
		String hearing = Settings.canHearing;
		if (hearing.equalsIgnoreCase("true")) {
			driverUtilities.get().clickOnElement(createHearingButton);
		} else {
			Assert.fail("Hearing is not available for " + Settings.clientName);
		}
	}

	public void enterFirstNameAndLastNameFromCreateHearingPoup(String citation) {
		String fnString = "//input[contains(@value,'" + citation
				+ "')]/parent::div/following-sibling::div/input[contains(@placeholder,'First name')]";
		String lnString = "//input[contains(@value,'" + citation
				+ "')]/parent::div/following-sibling::div/input[contains(@placeholder,'Last name')]";

		WebElement firstName = driverUtilities.get().getWebElement(fnString);
		WebElement lastNameName = driverUtilities.get().getWebElement(lnString);

		String firstNameVal = GenerateRandomData.getFirstName();
		String lastNameVal = GenerateRandomData.getLastName();

		driverUtilities.get().typeIntoTextBox(firstName, firstNameVal);
		driverUtilities.get().typeIntoTextBox(lastNameName, lastNameVal);
	}

	public void enterTicketNoFromCreateHearingPoup(String citation) {
		String tcNo = "//input[contains(@placeholder,'Enter Ticket Number')]";
		WebElement tcNumber = driverUtilities.get().getWebElement(tcNo);
		driverUtilities.get().typeIntoTextBox(tcNumber, citation);
	}

	public void enterFirstNameAndLastNameFromCreateHearingPoup() {
		String fnString = "//input[@placeholder='First name*']";
		String lnString = "//input[@placeholder='Last name*']";

		WebElement firstName = driverUtilities.get().getWebElement(fnString);
		WebElement lastNameName = driverUtilities.get().getWebElement(lnString);

		String firstNameVal = GenerateRandomData.getFirstName();
		String lastNameVal = GenerateRandomData.getLastName();

		driverUtilities.get().typeIntoTextBox(firstName, firstNameVal);
		driverUtilities.get().typeIntoTextBox(lastNameName, lastNameVal);
	}

	public void clickOnSubmitButtonCreatingHearing() 
	{
		driverUtilities.get().clickOnElement(submitButtonOfCreateHearingPopup);
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
	}

	public void ticketNotInHearingEligible(String citation) {
		String valPath = "//table[@id='cstm-report-tb-display']/tbody/tr/td/a[contains(text(),'" + citation
				+ "')]/parent::td/preceding-sibling::td/input";
		try {
			driverUtilities.get().getWebElement(valPath);
			System.out.println(citation + " is not hearared yet");
		} catch (NoSuchElementException e) {
		}
	}

	public void clickOnBackButtonOfHearingFlow() {
		driverUtilities.get().clickOnElement(backButtonFromHearingFlow);
	}

	public void closeButtonOfCreateHearingPopup() {
		String path = "//h3[contains(text(),'Create Hearing')]/ancestor::div/preceding-sibling::div//button[contains(text(),'x')]";
		int c = driverUtilities.get().getNumberOfElement(path);
		path = "(//h3[contains(text(),'Create Hearing')]/ancestor::div/preceding-sibling::div//button[contains(text(),'x')])["
				+ c + "]";
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path));
	}

	public void navigateToTab(String tabName, String hrefLink) {
		String path = "//a[contains(normalize-space(.),'" + tabName + "') and @href='" + hrefLink + "']/parent::li";
		WebElement tabLink = driverUtilities.get().getWebElement(path);
		driverUtilities.get().makeElementVisibleIntoScreen(
				driverUtilities.get().getWebElement("//*[contains(text(),'Appeal Workflow')]"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		driverUtilities.get().clickOnElement(tabLink);
	}

	public void verifyLabelAndKeyValue(String label, String value) {
		String originalFinePath = "//label[contains(normalize-space(.), '" + label
				+ "')]/parent::div/following-sibling::div/input";
		WebElement originalFineElement = driverUtilities.get().getWebElement(originalFinePath);
		String originalFineValue = driverUtilities.get().getAttribute(originalFineElement, "value");
		Assert.assertTrue(originalFineValue.contains(value));
	}

	public void clickOnPayButtonFromHearing() {
		String isHearingPay = Settings.isPayFromHearing;
		if (isHearingPay.equalsIgnoreCase("true")) {
			String path = "//button[contains(text(),'Pay')]";
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path));
		} else {
			Assert.fail("Pay from hearing is not available for client " + Settings.clientName);
		}
	}

	public String enterFirstNameInCreateHearingPopup() {
		driverUtilities.get().waitForElementToBePresent(firstNameFieldInCreateHearingPopup);
		String firstNameValue = GenerateRandomData.getFirstName();
		driverUtilities.get().typeIntoTextBox(firstNameFieldInCreateHearingPopup, firstNameValue);
		return firstNameValue;
	}

	/**
	 * Enter last name in Create Hearing popup and return the entered value
	 */
	public String enterLastNameInCreateHearingPopup() {
		driverUtilities.get().waitForElementToBePresent(lastNameFieldInCreateHearingPopup);
		String lastNameValue = GenerateRandomData.getLastName();
		driverUtilities.get().typeIntoTextBox(lastNameFieldInCreateHearingPopup, lastNameValue);
		return lastNameValue;
	}

	/**
	 * Enter email in Create Hearing popup and return the entered value
	 */
	public String enterEmailInCreateHearingPopup() {
		try{driverUtilities.get().waitForElementToBePresent(emailFieldInCreateHearingPopup);}catch(TimeoutException e) {}catch(NoSuchElementException e) {}
		String emailValue = GenerateRandomData.getEmailAddress();
		try{driverUtilities.get().typeIntoTextBox(emailFieldInCreateHearingPopup, emailValue);}catch(NoSuchElementException e) {}
		return emailValue;
	}

	/**
	 * Enter phone number in Create Hearing popup and return the entered value
	 */
	public String enterPhoneNumberInCreateHearingPopup() {
		try{driverUtilities.get().waitForElementToBePresent(phoneFieldInCreateHearingPopup);}catch(TimeoutException e) {}catch(NoSuchElementException e) {}
		String phoneValue = GenerateRandomData.getPhoneNumber();
		try{driverUtilities.get().typeIntoTextBox(phoneFieldInCreateHearingPopup, phoneValue);}catch(NoSuchElementException e) {}
		return phoneValue;
	}

	/**
	 * Click on Select Slot button for specific citation in Create Hearing popup
	 * 
	 * @param citationValue - The citation number to find the corresponding Select
	 *                      Slot button
	 */
	public void clickOnSelectSlotButtonForCitation(String citationValue) {
		// XPath to find the Select Slot button for the specific citation
		String selectSlotXPath = "//input[@value='"+citationValue+"']/ancestor::div/following-sibling::div//input";

		WebElement selectSlotButton = driverUtilities.get().getWebElement(selectSlotXPath);
		driverUtilities.get().clickOnElement(selectSlotButton);
	}

	/**
	 * Verify that "times slot available" text is present with green dot in
	 * Available Hearing Slots popup
	 */
	public void verifyTimesSlotAvailableTextWithGreenDot() {
		driverUtilities.get().waitForElementToBePresent(timesSlotAvailableText);
		Assert.assertTrue("Times slot available text should be present",
				driverUtilities.get().isElementDisplayed(timesSlotAvailableText));

		// Verify green dot is present (small green dot before the text)
		String greenDotXPath = "//div[contains(@class,'cstm-confirmation-popup-available-hearing-slots')]//div[contains(text(),'times slot available')]/preceding-sibling::*[contains(@class,'dot') or contains(@style,'green')]";
		Assert.assertTrue("Green dot should be present with times slot available text",
				driverUtilities.get().getNumberOfElement(greenDotXPath) > 0);
	}

	/**
	 * Click on specific time slot in Available Hearing Slots popup
	 * 
	 * @param timeSlot - The time slot to click (e.g., "10:00 - 17:00")
	 */
	public void clickOnTimeSlot(String timeSlot) {
		// XPath to find the time slot element
		String timeSlotXPath = "//*[contains(text(),'times slot available')]/parent::div/following-sibling::button";
		// String timeSlotXPath =
		// "//div[contains(@class,'cstm-confirmation-popup-available-hearing-slots')]//button[contains(@class,'slot-button')]//span[contains(text(),'"+timeSlot+"')]";
		WebElement timeSlotElement = driverUtilities.get().getWebElement(timeSlotXPath);
		driverUtilities.get().clickOnElement(timeSlotElement);
	}

	/**
	 * Click on Select Hearing button in Available Hearing Slots popup
	 */
	public void clickOnSelectHearingButton() {
		driverUtilities.get().waitForElementToBePresent(selectHearingButton);
		driverUtilities.get().clickOnElement(selectHearingButton);
	}

	// ===== HEARING MANAGEMENT MENU LOCATORS =====
	// Locators for Hearing Management sub-menu under Hearing Management main menu
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/hearing-report') and contains(text(),'Hearing Management')]")
	public WebElement hearingManagementMenu;

	/**
	 * Click on Hearing Management sub-menu under Hearing Management main menu
	 */
	public void clickOnHearingManagementMenu() {
		driverUtilities.get().waitForElementToBePresent(hearingManagementMenu);
		driverUtilities.get().clickOnElement(hearingManagementMenu);
	}

	/**
	 * Verify that ticket status is "Hearing" for specific citation number and plate
	 * number
	 * 
	 * @param citationNumber - The citation number to search for
	 * @param plateNumber    - The plate number to search for
	 */
	public void verifyTicketStatusIsHearing(String citationNumber, String plateNumber) {
		// XPath to find the row containing both citation number and plate number, then
		// get the ticket status
		// Based on HTML structure: Citation Number is in 3rd column, Plate Number is in
		// 9th column, Ticket Status is in 7th column
		String ticketStatusXPath = "//tr[td[3]/a[contains(text(),'" + citationNumber
				+ "')] and td[9]/a[contains(text(),'" + plateNumber + "')]]/td[7]";

		try {
			WebElement ticketStatusElement = driverUtilities.get().getWebElement(ticketStatusXPath);
			String actualTicketStatus = driverUtilities.get().getElementText(ticketStatusElement);

			Assert.assertTrue("Ticket status should be 'Hearing' for citation " + citationNumber + " and plate "
					+ plateNumber + ", but found: " + actualTicketStatus,
					"Hearing".equalsIgnoreCase(actualTicketStatus));

			System.out.println("✓ Verified ticket status is 'Hearing' for citation " + citationNumber + " and plate "
					+ plateNumber);
		} catch (Exception e) {
			Assert.fail("Failed to verify ticket status for citation " + citationNumber + " and plate " + plateNumber
					+ ": " + e.getMessage());
		}
	}

	// ===== HEARING REQUESTS SEARCH FUNCTIONALITY METHODS =====

	/**
	 * Click on Hearing Requests menu under Hearing Management
	 */
	public void clickOnHearingRequestsMenu() {
		driverUtilities.get().waitForElementToBePresent(hearingRequestsMenu);
		driverUtilities.get().clickOnElement(hearingRequestsMenu);
		System.out.println("✓ Clicked on Hearing Requests menu");
	}

	/**
	 * Enter citation number in search citation field
	 * 
	 * @param citationValue - The citation number to enter
	 */
	public void enterCitationNumberInSearchField(String citationValue) {
		driverUtilities.get().waitForElementToBePresent(searchCitationInputField);
		driverUtilities.get().typeIntoTextBox(searchCitationInputField, citationValue);
		System.out.println("✓ Entered citation number: " + citationValue + " in search citation field");
	}

	/**
	 * Enter LP number in search LP number field
	 * 
	 * @param lpNumberValue - The LP number to enter
	 */
	public void enterLPNumberInSearchField(String lpNumberValue) {
		driverUtilities.get().waitForElementToBePresent(searchLPNumberInputField);
		driverUtilities.get().typeIntoTextBox(searchLPNumberInputField, lpNumberValue);
		System.out.println("✓ Entered LP number: " + lpNumberValue + " in search LP number field");
	}

	/**
	 * Click on Submit button from Hearing Requests search form
	 */
	public void clickOnSubmitButtonFromHearingRequestsSearch() {
		driverUtilities.get().waitForElementToBePresent(submitButtonFromHearingRequestsSearch);
		driverUtilities.get().clickOnElement(submitButtonFromHearingRequestsSearch);
		System.out.println("✓ Clicked on Submit button from Hearing Requests search");
	}

	/**
	 * Verify that ticket is searched based on citation number
	 * 
	 * @param citationNumber - The citation number to verify in search results
	 */
	public void verifyTicketSearchedByCitationNumber(String citationNumber) {
		// XPath to verify that the citation number appears in search results
		// This will check if the citation number is present in the search results table
		String citationSearchResultXPath = "//table//tr//td//a[contains(text(),'" + citationNumber + "')]";

		try {
			driverUtilities.get().waitForElementToBePresent2(citationSearchResultXPath);
			WebElement citationElement = driverUtilities.get().getWebElement(citationSearchResultXPath);

			Assert.assertTrue("Citation number " + citationNumber + " should be found in search results",
					driverUtilities.get().isElementDisplayed(citationElement));

			System.out.println("✓ Verified ticket is searched based on citation number: " + citationNumber);
		} catch (Exception e) {
			// If no results found, check for "No Record Found" message
			String noRecordFoundXPath = "//div[contains(@class,'no-record-found') and contains(text(),'No Record Found')]";
			try {
				WebElement noRecordElement = driverUtilities.get().getWebElement(noRecordFoundXPath);
				if (driverUtilities.get().isElementDisplayed(noRecordElement)) {
					// FAIL the test when no records are found - this is the expected behavior
					Assert.fail("No records found for citation number: " + citationNumber
							+ ". Search verification failed - no matching records exist.");
				} else {
					Assert.fail("Failed to verify ticket search by citation number " + citationNumber + ": "
							+ e.getMessage());
				}
			} catch (Exception noRecordException) {
				Assert.fail(
						"Failed to verify ticket search by citation number " + citationNumber + ": " + e.getMessage());
			}
		}
	}

	/**
	 * Verify that ticket is searched based on plate number
	 * 
	 * @param plateNumber - The plate number to verify in search results
	 */
	public void verifyTicketSearchedByPlateNumber(String plateNumber) {
		// XPath to verify that the plate number appears in search results
		// This will check if the plate number is present in the search results table
		String plateSearchResultXPath = "//table//tr//td//a[contains(text(),'" + plateNumber + "')]";

		try {
			driverUtilities.get().waitForElementToBePresent2(plateSearchResultXPath);
			WebElement plateElement = driverUtilities.get().getWebElement(plateSearchResultXPath);

			Assert.assertTrue("Plate number " + plateNumber + " should be found in search results",
					driverUtilities.get().isElementDisplayed(plateElement));

			System.out.println("✓ Verified ticket is searched based on plate number: " + plateNumber);
		} catch (Exception e) {
			// If no results found, check for "No Record Found" message
			String noRecordFoundXPath = "//div[contains(@class,'no-record-found') and contains(text(),'No Record Found')]";
			try {
				WebElement noRecordElement = driverUtilities.get().getWebElement(noRecordFoundXPath);
				if (driverUtilities.get().isElementDisplayed(noRecordElement)) {
					// FAIL the test when no records are found - this is the expected behavior
					Assert.fail("No records found for plate number: " + plateNumber
							+ ". Search verification failed - no matching records exist.");
				} else {
					Assert.fail(
							"Failed to verify ticket search by plate number " + plateNumber + ": " + e.getMessage());
				}
			} catch (Exception noRecordException) {
				Assert.fail("Failed to verify ticket search by plate number " + plateNumber + ": " + e.getMessage());
			}
		}
	}

	private boolean isSlotDateVisibleOnScreen(String date)
	{
		boolean hasSlotOnScreen = false; 
		String dateString = "//span[contains(text(),'"+date+" Thu')]/ancestor::div[contains(@class,'rbc-time-header')]/following-sibling::div//div[contains(@class,'rbc-events-container')]/div[contains(@class,'rbc-background-event')]";
		try
		{
			driverUtilities.get().getWebElement(dateString);
			hasSlotOnScreen=true;
		}
		catch(NoSuchElementException e)
		{
			hasSlotOnScreen=false;
		}
		return hasSlotOnScreen;
	}
	
	private boolean isTitleHasAvailbleSlotNumbers(WebElement dateSlot)
	{
		int availableSlots = 0;
		boolean flag = false;
		String availbleSlotTitle = driverUtilities.get().getAttribute(dateSlot,"title");
		Pattern pattern = Pattern.compile("(\\d+)$");
        Matcher matcher = pattern.matcher(availbleSlotTitle);
        
        if (matcher.find())
        {
            String numberStr = matcher.group(1);
            availableSlots = Integer.parseInt(numberStr);
            System.out.println("Available number: " + availableSlots);
        }
        
        if(availableSlots>0)
        {
        	flag=true;
        }
        else
        {
        	flag = false;
        }
        return flag;
	}
	
	private void navigateToAvailableSlots()
	{
		String nextButtonPath = "//button[contains(text(),'Next')]";
		WebElement nextButton = driverUtilities.get().getWebElement(nextButtonPath);
		
		String nextThurshdayDate = ThursdayFinder.getNextFirstOrThirdThursday("dd");
		String slotPath1 = "(//span[contains(text(),'"+nextThurshdayDate+" Thu')]/ancestor::div[contains(@class,'rbc-time-header')]/following-sibling::div//div[contains(@class,'rbc-events-container')]/div[contains(@class,'rbc-background-event')])[1]";
		boolean hasSlotOnScreen = isSlotDateVisibleOnScreen(nextThurshdayDate);
		while(!hasSlotOnScreen)
		{
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(nextButton);
			try{driverUtilities.get().clickOnElement(nextButton);}catch(ElementClickInterceptedException w) {}
			try {Thread.sleep(Duration.ofSeconds(2));}catch(InterruptedException e) {}
			hasSlotOnScreen = isSlotDateVisibleOnScreen(nextThurshdayDate);
			if(hasSlotOnScreen)
			{
				break;
			}
		}
		
		WebElement firstSlotElement = driverUtilities.get().getWebElement(slotPath1);
		String slotPath2 = "(//span[contains(text(),'"+nextThurshdayDate+" Thu')]/ancestor::div[contains(@class,'rbc-time-header')]/following-sibling::div//div[contains(@class,'rbc-events-container')]/div[contains(@class,'rbc-background-event')])[2]";
		WebElement secondSlotElement = driverUtilities.get().getWebElement(slotPath2);
		
		boolean hasAvailableSeatForFirstSlot = isTitleHasAvailbleSlotNumbers(firstSlotElement);
		boolean hasAvailableSeatForSecondSlot = isTitleHasAvailbleSlotNumbers(secondSlotElement);
		
		while(!hasAvailableSeatForSecondSlot)
		{
			driverUtilities.get().clickOnElement(nextButton);		
			nextThurshdayDate = ThursdayFinder.getNextFirstOrThirdThursday("dd");
			slotPath2 = "(//span[contains(text(),'"+nextThurshdayDate+" Thu')]/ancestor::div[contains(@class,'rbc-time-header')]/following-sibling::div//div[contains(@class,'rbc-events-container')]/div[contains(@class,'rbc-background-event')])[2]";
			secondSlotElement = driverUtilities.get().getWebElement(slotPath2);
			hasAvailableSeatForSecondSlot = isTitleHasAvailbleSlotNumbers(secondSlotElement);
		}
		
		driverUtilities.get().clickOnElement(secondSlotElement);
	}
	
	public void clickOnAvilableSlot()
	{
		navigateToAvailableSlots();
	}
	
	/**
	 * Enter citation number into Ticket Number field in Create Hearing popup - NEW UI METHOD
	 * @param citation The citation number to enter
	 */
	public void enterCitationNumberIntoTicketNumberField(String citation)
	{
		driverUtilities.get().waitForElementToBePresent(ticketNumberFieldInCreateHearingPopup);
		driverUtilities.get().typeIntoTextBox(ticketNumberFieldInCreateHearingPopup, citation);
	}
	
	/**
	 * Select hearing status from the dropdown list
	 * @param listName The name of the list (for consistency with other functions)
	 * @param option The option to select from the hearing status dropdown
	 */
	public void selectHearingStatusFromList(String listName, String option)
	{
		String listPath = "//label[contains(normalize-space(.),'Hearing Status')]/following-sibling::select";
		WebElement pathElement = driverUtilities.get().getWebElement(listPath);
		try
		{
			driverUtilities.get().selectElementFromList(pathElement, option);
		}
		catch(NoSuchElementException e)
		{
			Assert.fail(option +" is not available for client " +Settings.clientName);
		}
	}
	
	/**
	 * Click on empty time slot in the hearing calendar
	 * This method finds and clicks on empty time slots within the calendar grid
	 * Locator: Background events that represent available time slots
	 */
	public void clickOnEmptyTimeSlot()
	{
		try 
		{
			// Wait for calendar to be loaded
			driverUtilities.get().waitForElementToBePresent2("//div[@class='rbc-calendar']");
			
			// Find all background events that represent available time slots
			// These are the actual clickable elements for empty slots
			String backgroundEventXPath = "//div[@class='rbc-background-event']";
			java.util.List<WebElement> backgroundEvents = driverUtilities.get().getAllWebElements(backgroundEventXPath);
			
			if (!backgroundEvents.isEmpty()) {
				// Click on the first available background event (empty slot)
				WebElement firstBackgroundEvent = backgroundEvents.get(0);
				driverUtilities.get().clickOnElement(firstBackgroundEvent);
				System.out.println("✓ Clicked on empty time slot (background event) in the calendar");
			} else {
				System.out.println("No background events (empty slots) found in the calendar");
				// Fallback: Try clicking on any clickable area in the calendar
				try {
					String fallbackXPath = "//div[@class='rbc-calendar']//div[not(contains(@style,'pointer-events: none'))]";
					WebElement fallbackElement = driverUtilities.get().getWebElement(fallbackXPath);
					driverUtilities.get().clickOnElement(fallbackElement);
					System.out.println("✓ Clicked on fallback calendar element");
				} catch (Exception fallbackException) {
					System.out.println("Failed to click on any calendar element: " + fallbackException.getMessage());
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error clicking on empty time slot: " + e.getMessage());
			// Final fallback: Try clicking on any clickable area in the calendar
			try {
				String fallbackXPath = "//div[@class='rbc-calendar']//div[not(contains(@style,'pointer-events: none'))]";
				WebElement fallbackElement = driverUtilities.get().getWebElement(fallbackXPath);
				driverUtilities.get().clickOnElement(fallbackElement);
				System.out.println("✓ Clicked on fallback calendar element");
			} catch (Exception fallbackException) {
				System.out.println("Failed to click on any calendar element: " + fallbackException.getMessage());
			}
		}
	}
}
