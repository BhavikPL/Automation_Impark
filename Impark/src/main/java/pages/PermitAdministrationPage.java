package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.NoSuchElementException;

import base.BasePage;
import utility.Util;
import utility.GenerateRandomData;

public class PermitAdministrationPage extends BasePage {
	// Navigation elements
	@FindBy(how = How.XPATH, using = "//ul[@id='permitAdministration']//a[contains(@href,'permits-configuration')]/parent::li")
	public WebElement setUpPermitsOption;

	// Configure Permit page elements
	@FindBy(how = How.XPATH, using = "//h3[normalize-space()='Configure Permit']")
	public WebElement configurePermitTitle;

	// Details section elements
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Name')]/following-sibling::input")
	public WebElement nameInput;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Resident type')]/following-sibling::select")
	public WebElement residentTypeDropdown;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Support resource name')]/following-sibling::input")
	public WebElement supportResourceNameInput;

	@FindBy(how = How.XPATH, using = "//input[@name='permit_start_date']")
	public WebElement permitStartDateInput;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Send buy Permit email to city as well?')]/following-sibling::select")
	public WebElement sendBuyPermitEmailDropdown;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Type')]/following-sibling::select")
	public WebElement typeDropdown;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Is public')]/following-sibling::select")
	public WebElement isPublicDropdown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder = 'Enter Private Comments']")
	public WebElement privateCommentsTextarea;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Administrator') and contains(text(),'email')]/following-sibling::input")
	public WebElement administratorEmailInput;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Zone')]/following-sibling::input")
	public WebElement zoneInput;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Created by')]/following-sibling::input")
	public WebElement createdByInput;

	@FindBy(how = How.XPATH, using = "//input[@name='permit_end_date']")
	public WebElement permitEndDateInput;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Permit numbering name')]/following-sibling::select")
	public WebElement permitNumberingNameDropdown;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Support resource email')]/following-sibling::input")
	public WebElement supportResourceEmailInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'react-select-allowed-portals-placeholder')]")
	public WebElement allowedPortalDropdown;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Description')]/following-sibling::div//div[contains(@data-placeholder,'Start typing...')]")
	public WebElement descriptionTextarea;

	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Note')]/following-sibling::div//div[contains(@data-placeholder,'Start typing...')]")
	public WebElement noteTextarea;

	// Duration checkboxes
	@FindBy(how = How.XPATH, using = "//label[text()='Annually']/input")
	public WebElement annuallyCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Semi Annually']/input")
	public WebElement semiAnnuallyCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Quarterly']/input")
	public WebElement quarterlyCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Monthly']/input")
	public WebElement monthlyCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Custom dates']/input")
	public WebElement customDatesCheckbox;

	// Applicable days checkboxes
	@FindBy(how = How.XPATH, using = "//label[text()='Sunday']/input")
	public WebElement sundayCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Monday']/input")
	public WebElement mondayCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Tuesday']/input")
	public WebElement tuesdayCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Wednesday']/input")
	public WebElement wednesdayCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Thrusday']/input")
	public WebElement thursdayCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Friday']/input")
	public WebElement fridayCheckbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Saturday']/input")
	public WebElement saturdayCheckbox;

	// Time selection
	@FindBy(how = How.XPATH, using = "//input[@name='permit_time_validity.start_time']")
	public WebElement startTimeInput;

	@FindBy(how = How.XPATH, using = "//input[@name='permit_time_validity.end_time']")
	public WebElement endTimeInput;

	// Save button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]")
	public WebElement saveButton;

	// ========== RULES SECTION LOCATORS ==========
	// Count restrictions
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Count restrictions')]/input[@type='checkbox']")
	public WebElement countRestrictionsCheckbox;

	// Count restriction type radio buttons
	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='per_user']")
	public WebElement perUserRadio;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='per_address']")
	public WebElement perAddressRadio;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='per_agency']")
	public WebElement perAgencyRadio;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='per_plate']")
	public WebElement perPlateRadio;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='per_lot']")
	public WebElement perLotRadio;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='per_district']")
	public WebElement perDistrictRadio;

	// Count restriction value input
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-rules-list-in-field')]//input[@class='permit-field-rules' and @placeholder='Enter Count']")
	public WebElement countRestrictionValueInput;

	// Auto approve for OTC payment
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Auto approve for OTC Payment')]/input[@type='checkbox']")
	public WebElement autoApproveForOTCPaymentCheckbox;

	// Permit approval
	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Permit approval')]/input[@type='checkbox']")
	public WebElement permitApprovalCheckbox;

	// Approval type radio buttons
	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='Has auto approve']")
	public WebElement autoApproveRadio;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='Approval workflow']")
	public WebElement approvalWorkflowRadio;

	// Documents requirement
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Documents')]/input[@type='checkbox']")
	public WebElement documentsRequirementCheckbox;

	// Document name input
	@FindBy(how = How.XPATH, using = "//input[@name='documents.0.name' and @placeholder='Document Type']")
	public WebElement documentNameInput;

	// Document note textarea
	@FindBy(how = How.XPATH, using = "//textarea[@name='documents.0.short_notice' and @placeholder='Document Note']")
	public WebElement documentNoteTextarea;

	// No renewal if open citation
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'No renewal if open citation')]/input[@type='checkbox']")
	public WebElement noRenewalIfOpenCitationCheckbox;

	// Citation count input
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'No renewal if open citation')]/ancestor::div/following-sibling::div/input[@class='permit-field-rules']")
	public WebElement citationCountInput;

	// Wait list
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Wait list')]/input[@type='checkbox']")
	public WebElement waitListCheckbox;

	// Wait list capacity inputs
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Allowed capacity')]/following-sibling::input[@class='permit-field-rules']")
	public WebElement allowedCapacityInput;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Waitlist capacity')]/following-sibling::input[@class='permit-field-rules']")
	public WebElement waitlistCapacityInput;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Waitlist expiry days')]/following-sibling::input[@class='permit-field-rules']")
	public WebElement waitlistExpiryDaysInput;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Wait list message')]/following-sibling::textarea[@class='permit-field-textarea']")
	public WebElement waitlistMessageTextarea;

	// Document option name input
	@FindBy(how = How.XPATH, using = "//input[@name='documents.0.options.0' and @placeholder='Document Name']")
	public WebElement documentOptionNameInput;

	// Allow cancels
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Allow cancels')]/input[@type='checkbox']")
	public WebElement allowCancelsCheckbox;

	// Allow opt in and out of notification
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Allow opt in and out of notification')]/input[@type='checkbox']")
	public WebElement allowOptInAndOutOfNotificationCheckbox;

	// Update button for rules
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Save')])[2]")
	public WebElement saveButtonForRules;

	// ========== PAYMENTS SECTION LOCATORS ==========
	// Service Fee
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Service Fee')]/following-sibling::div//input[@class='permit-field-rules cstm-pp-drr-input']")
	public WebElement serviceFeeInput;

	// Tired pricing (escalated pricing)
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Tired pricing (escalated pricing)')]/input[@type='checkbox']")
	public WebElement tiredPricingCheckbox;

	// Permit fee duration options
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-payment-list3-box')]//label[contains(text(),'Daily')]/input[@type='checkbox']")
	public WebElement dailyPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-payment-list3-box')]//label[contains(text(),'Monthly')]/input[@type='checkbox']")
	public WebElement monthlyPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-payment-list3-box')]//label[contains(text(),'Quarterly')]/input[@type='checkbox']")
	public WebElement quarterlyPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-payment-list3-box')]//label[contains(text(),'Annually')]/input[@type='checkbox']")
	public WebElement annuallyPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-payment-list3-box')]//label[contains(text(),'Semi Annually')]/input[@type='checkbox']")
	public WebElement semiAnnuallyPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-payment-list3-box')]//label[contains(text(),'Events')]/input[@type='checkbox']")
	public WebElement eventsPermitFeeCheckbox;

	// Permit fee amount input
	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Permit fee')]/ancestor::div/following-sibling::div//label[contains(text(),'Annually')]/parent::div/following-sibling::div//input[@class='permit-field-rules cstm-pp-drr-input']")
	public WebElement permitFeeAmountInput;

	// Guest Permit fee duration options
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-row-box2')][2]//label[contains(text(),'Daily')]/input[@type='checkbox']")
	public WebElement dailyGuestPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-row-box2')][2]//label[contains(text(),'Monthly')]/input[@type='checkbox']")
	public WebElement monthlyGuestPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-row-box2')][2]//label[contains(text(),'Quarterly')]/input[@type='checkbox']")
	public WebElement quarterlyGuestPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'permit-row-box2')][2]//label[text()='Annually']/input[@type='checkbox'])[2]")
	public WebElement annuallyGuestPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-row-box2')][2]//label[contains(text(),'Semi Annually')]/input[@type='checkbox']")
	public WebElement semiAnnuallyGuestPermitFeeCheckbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'permit-row-box2')][2]//label[contains(text(),'Events')]/input[@type='checkbox']")
	public WebElement eventsGuestPermitFeeCheckbox;

	// Guest Permit fee amount input
	@FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Guest Permit fee')]/ancestor::div/following-sibling::div//label[contains(text(),'Annually')]/parent::div/following-sibling::div//input[@class='permit-field-rules cstm-pp-drr-input']")
	public WebElement guestPermitFeeAmountInput;

	// Setup prorate fees
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Do you want to setup prorate fee?')]/input[@type='checkbox']")
	public WebElement setupProrateFeesCheckbox;

	// Prorate duration dropdown
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Do you want to setup prorate fee?')]/parent::div/following-sibling::div//select")
	public WebElement prorateDurationDropdown;

	// Prorate fee amount input
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Do you want to setup prorate fee?')]/parent::div/following-sibling::div//input")
	public WebElement prorateFeeAmountInput;

	// Payment options checkboxes
	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'Master card')]/input[@type='checkbox']")
	public WebElement masterCardCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'VISA')]/input[@type='checkbox']")
	public WebElement visaCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'American express')]/input[@type='checkbox']")
	public WebElement americanExpressCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'Discover')]/input[@type='checkbox']")
	public WebElement discoverCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'ACH')]/input[@type='checkbox']")
	public WebElement achCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'Check')]/input[@type='checkbox']")
	public WebElement checkCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='pyament-options']//label[contains(text(),'Cash')]/input[@type='checkbox']")
	public WebElement cashCheckbox;

	// Update button for payments
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Save')])[3]")
	public WebElement saveButtonForPayments;

	// ========== NOTIFICATIONS SECTION LOCATORS ==========
	// Enable all alerts checkbox
	@FindBy(how = How.XPATH, using = "//div[@class='permit-notifications-list']//label[contains(text(),'Enable all alerts')]/input[@type='checkbox']")
	public WebElement enableAllAlertsCheckbox;

	// Update button for notifications
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Save')])[4]")
	public WebElement saveButtonForNotifications;

	// ========== CONFIGURE QUESTION SECTION LOCATORS ==========
	// Components panel elements
	@FindBy(how = How.XPATH, using = "//li[@data-tool='Permit-Duration' and @id='Permit-Duration']")
	public WebElement permitDurationComponent;

	@FindBy(how = How.XPATH, using = "//li[@data-tool='Address-Details' and @id='Address-Details']")
	public WebElement addressDetailsComponent;

	@FindBy(how = How.XPATH, using = "//li[@data-tool='User-Details' and @id='User-Details']")
	public WebElement userDetailsComponent;

	// Question Form drop zone
	//@FindBy(how = How.XPATH, using = "//span[text()='Question Form']/following::div[contains(@class,'dragActive')][1]")
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'configure-question-cont-al-body')]")
	public WebElement questionFormDropZone;

	// Update button for configure question
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	public WebElement submitButtonForConfigureQuestion;
	
	// Verification locators for dropped components
	@FindBy(how=How.XPATH, using="//div[contains(@class,'dragActive')]//div[contains(@class,'configure-permit-drag')]//div[contains(@class,'Permit-Duration')]")
	public WebElement droppedPermitDurationComponent;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'dragActive')]//div[contains(@class,'configure-permit-drag')]//div[contains(@class,'Address-Details')]")
	public WebElement droppedAddressDetailsComponent;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'dragActive')]//div[contains(@class,'configure-permit-drag')]//div[contains(@class,'User-Details')]")
	public WebElement droppedUserDetailsComponent;
		
	
	// ========== WAITLIST CREATION LOCATORS ==========
	// Navigation to permit parking space availability
	@FindBy(how=How.XPATH, using="//ul[@id='permitAdministration']//a[contains(@href,'permits-waitlist')]/parent::li")
	public WebElement permitParkingSpaceAvailabilityOption;

	// Create waitlist button
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Create Waitlist')]")
	public WebElement createWaitlistButton;

	// Waitlist form elements
	@FindBy(how=How.XPATH, using="//input[@name='name' and @placeholder='Waitlist Name']")
	public WebElement waitlistNameInput;

	@FindBy(how=How.XPATH, using="//textarea[@name='description' and @placeholder='Waitlist Description']")
	public WebElement waitlistDescriptionTextarea;

	@FindBy(how=How.XPATH, using="//textarea[@name='waitlist_message' and @placeholder='Waitlist Message']")
	public WebElement waitlistMessageTextareaForCreation;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Waitlist Allowed Capacity']")
	public WebElement waitlistAllowedCapacityInput;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Waitlist Capacity']")
	public WebElement waitlistCapacityInputForCreation;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Waitlist Expiry Days']")
	public WebElement waitlistExpiryDaysInputForCreation;

	@FindBy(how=How.XPATH, using="//input[@type='checkbox' and @value='false']")
	public WebElement waitlistEnabledCheckbox;

	@FindBy(how=How.XPATH, using="//button[@type='submit' and contains(text(),'Create')]")
	public WebElement createButton;
	
	// Select Waitlist dropdown
	@FindBy(how=How.XPATH, using="//label[text()='Select Waitlist']/following-sibling::select")
	public WebElement selectWaitlistDropdown;
	
	@FindBy(how=How.XPATH, using="//li[@data-tool='Permit-Quantity-Plate-Details' and @id='Permit-Quantity-Plate-Details']")
	public WebElement permitQuantityPlateDetailsComponent;
	
	// ========== PUBLISH PERMITS VERIFICATION LOCATORS ==========
	// Navigation to publish permits
	@FindBy(how=How.XPATH, using="//ul[@id='permitAdministration']//a[contains(@href,'permits-option')]/parent::li")
	public WebElement publishPermitsOption;

	// Permit Configuration List page title
	@FindBy(how=How.XPATH, using="//h3[normalize-space()='Permit Configuration List']")
	public WebElement permitConfigurationListTitle;

	// Table locators
	@FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']")
	public WebElement permitConfigurationTable;

	// Table row locator for specific permit
	@FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']//tr[td[1][contains(text(),'')]]")
	public WebElement permitTableRow;

	// Action links locator
	@FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']//tr[td[1][contains(text(),'')]]//div[@class='table-action']//a")
	public WebElement actionLinks;

	public void clickOnSetUpPermits() {
		driverUtilities.get().clickOnElement(setUpPermitsOption);
	}

	public void verifyConfigurePermitPageDisplayed() {
		try {
			driverUtilities.get().waitForElementToBePresent(configurePermitTitle);
		} catch (TimeoutException e) {
		}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(configurePermitTitle));
	}

	// Details section methods
	public String enterName() {
		String name = GenerateRandomData.getFirstName() + " " + GenerateRandomData.getLastName() + " " + "Parking";
		driverUtilities.get().typeIntoTextBox(nameInput, name);
		return name;
	}

	public void selectResidentType(String residentType) {
		driverUtilities.get().selectElementFromList(residentTypeDropdown, residentType);
	}

	public String enterSupportResourceName() {
		String supportResourceName = GenerateRandomData.getFirstName() + " " + GenerateRandomData.getLastName();
		driverUtilities.get().typeIntoTextBox(supportResourceNameInput, supportResourceName);
		return supportResourceName;
	}

	public void enterPermitStartDate() throws AWTException {
		try {
			driverUtilities.get().waitForElementToBePresent(permitStartDateInput);
		} catch (TimeoutException e) {
		}
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(permitStartDateInput);
		driverUtilities.get().clickOnElement(permitStartDateInput);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		String date = Util.getCurrentSystemDate("dd");
		String month = Util.getCurrentSystemDate("MMMMMM");

		if (date.startsWith("0")) {
			date = date.substring(1);
		}
		String datePath = "//div[contains(@aria-label,'" + month + "') and text()='" + date + "']";
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(datePath));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectSendBuyPermitEmail(String option) {
		driverUtilities.get().selectElementFromList(sendBuyPermitEmailDropdown, option);
	}

	public void selectType(String type) {
		driverUtilities.get().selectElementFromList(typeDropdown, type);
	}

	public void selectIsPublic(String isPublic) {
		driverUtilities.get().selectElementFromList(isPublicDropdown, isPublic);
	}

	public String enterPrivateComments() {
		String privateComments = GenerateRandomData.getReason();
		driverUtilities.get().typeIntoTextBox(privateCommentsTextarea, privateComments);
		return privateComments;
	}

	public String enterAdministratorEmail() {
		String adminEmail = GenerateRandomData.getEmailAddress();
		driverUtilities.get().typeIntoTextBox(administratorEmailInput, adminEmail);
		return adminEmail;
	}

	public String enterZone() {
		String zone = "Zone " + GenerateRandomData.getPhoneNumber();
		driverUtilities.get().typeIntoTextBox(zoneInput, zone);
		return zone;
	}

	public String enterCreatedBy() {
		String createdBy = GenerateRandomData.getFirstName() + " " + GenerateRandomData.getLastName();
		driverUtilities.get().typeIntoTextBox(createdByInput, createdBy);
		return createdBy;
	}

	public void enterPermitEndDate() throws AWTException {
		try {
			driverUtilities.get().waitForElementToBePresent(permitEndDateInput);
		} catch (TimeoutException e) {
		}
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(permitEndDateInput);
		driverUtilities.get().clickOnElement(permitEndDateInput);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		String futureDate = Util.getNextSystemDate("dd-MMMM-yyyy", "2");
		String futureDD = futureDate.split("-")[0];
		if (futureDD.startsWith("0")) {
			futureDD = futureDD.substring(1);
		}
		String futureMonth = futureDate.split("-")[1];

		String datePath = "//div[contains(@aria-label,'" + futureMonth + "') and text()='" + futureDD + "']";
		System.out.println("datePath:=" + datePath);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(datePath));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectPermitNumberingName(String permitName) {
		driverUtilities.get().selectElementFromList(permitNumberingNameDropdown, permitName);
	}

	public String enterSupportResourceEmail() {
		String supportEmail = GenerateRandomData.getEmailAddress();
		driverUtilities.get().typeIntoTextBox(supportResourceEmailInput, supportEmail);
		return supportEmail;
	}

	public void selectAllowedPortal(String portal) {
		driverUtilities.get().clickOnElement(allowedPortalDropdown);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		driverUtilities.get()
				.clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'" + portal + "')]"));
	}

	public String enterDescription() {
		String description = "This is a test permit description for " + GenerateRandomData.getFirstName();
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(descriptionTextarea);
		driverUtilities.get().clickOnElement(descriptionTextarea);
		driverUtilities.get().typeIntoTextBox(descriptionTextarea, description);
		return description;
	}

	public String enterNote() {
		String note = "Test note for permit configuration: " + GenerateRandomData.getReason();
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(noteTextarea);
		driverUtilities.get().clickOnElement(noteTextarea);
		driverUtilities.get().typeIntoTextBox(noteTextarea, note);
		return note;
	}

	public void selectAnnuallyDuration() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(annuallyCheckbox);
		driverUtilities.get().clickOnElement(annuallyCheckbox);
	}

	public void selectAllApplicableDaysExceptSunday() {
		// Select all days except Sunday
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(mondayCheckbox);
		driverUtilities.get().clickOnElement(mondayCheckbox);

		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(tuesdayCheckbox);
		driverUtilities.get().clickOnElement(tuesdayCheckbox);

		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(wednesdayCheckbox);
		driverUtilities.get().clickOnElement(wednesdayCheckbox);

		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(thursdayCheckbox);
		driverUtilities.get().clickOnElement(thursdayCheckbox);

		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(fridayCheckbox);
		driverUtilities.get().clickOnElement(fridayCheckbox);

		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(saturdayCheckbox);
		driverUtilities.get().clickOnElement(saturdayCheckbox);
	}

	public void enterStartTime(String startTime) {
		driverUtilities.get().makeElementVisibleIntoScreen(startTimeInput);
		driverUtilities.get().clickOnElement(startTimeInput);
		WebElement timeOption = driverUtilities.get().getWebElement("//li[text()='" + startTime + "']");
		driverUtilities.get().makeElementVisibleIntoScreen(timeOption);
		driverUtilities.get().clickOnElement(timeOption);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterEndTime(String endTime) {
		driverUtilities.get().makeElementVisibleIntoScreen(endTimeInput);
		driverUtilities.get().clickOnElement(endTimeInput);
		WebElement timeOption = driverUtilities.get().getWebElement("//li[text()='" + endTime + "']");
		driverUtilities.get().makeElementVisibleIntoScreen(timeOption);
		driverUtilities.get().clickOnElement(timeOption);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void clickOnSaveButton() {
		driverUtilities.get().makeElementVisibleIntoScreen(saveButton);
		driverUtilities.get().clickOnElement(saveButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	// ========== RULES SECTION METHODS ==========
	public void enableCountRestrictions() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(countRestrictionsCheckbox);
		driverUtilities.get().clickOnElement(countRestrictionsCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectCountRestrictionType(String restrictionType) {
		switch (restrictionType.toLowerCase()) {
		case "per_user":
		case "per user":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(perUserRadio);
			driverUtilities.get().clickOnElement(perUserRadio);
			break;
		case "per_address":
		case "per address":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(perAddressRadio);
			driverUtilities.get().clickOnElement(perAddressRadio);
			break;
		case "per_agency":
		case "per agency":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(perAgencyRadio);
			driverUtilities.get().clickOnElement(perAgencyRadio);
			break;
		case "per_plate":
		case "per plate":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(perPlateRadio);
			driverUtilities.get().clickOnElement(perPlateRadio);
			break;
		case "per_lot":
		case "per lot":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(perLotRadio);
			driverUtilities.get().clickOnElement(perLotRadio);
			break;
		case "per_district":
		case "per district":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(perDistrictRadio);
			driverUtilities.get().clickOnElement(perDistrictRadio);
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterCountRestrictionValue(String value) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(countRestrictionValueInput);
		driverUtilities.get().typeIntoTextBox(countRestrictionValueInput, value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableAutoApproveForOTCPayment() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(autoApproveForOTCPaymentCheckbox);
		driverUtilities.get().clickOnElement(autoApproveForOTCPaymentCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enablePermitApproval() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(permitApprovalCheckbox);
		driverUtilities.get().clickOnElement(permitApprovalCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectApprovalType(String approvalType) {
		if (approvalType.equalsIgnoreCase("Auto approve ?")) {
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(autoApproveRadio);
			driverUtilities.get().clickOnElement(autoApproveRadio);
		} else if (approvalType.equalsIgnoreCase("Approval workflow")) {
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(approvalWorkflowRadio);
			driverUtilities.get().clickOnElement(approvalWorkflowRadio);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableDocumentsRequirement() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(documentsRequirementCheckbox);
		driverUtilities.get().clickOnElement(documentsRequirementCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterDocumentName(String documentName) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(documentNameInput);
		driverUtilities.get().typeIntoTextBox(documentNameInput, documentName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterDocumentNote(String documentNote) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(documentNoteTextarea);
		driverUtilities.get().typeIntoTextBox(documentNoteTextarea, documentNote);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterDocumentOptionName(String documentOptionName) {
		driverUtilities.get().makeElementVisibleIntoScreen(documentOptionNameInput);
		driverUtilities.get().typeIntoTextBox(documentOptionNameInput, documentOptionName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableNoRenewalIfOpenCitation() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(noRenewalIfOpenCitationCheckbox);
		driverUtilities.get().clickOnElement(noRenewalIfOpenCitationCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterCitationCount(String citationCount) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(citationCountInput);
		driverUtilities.get().typeIntoTextBox(citationCountInput, citationCount);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableWaitList() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(waitListCheckbox);
		driverUtilities.get().clickOnElement(waitListCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterAllowedCapacity(String allowedCapacity) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(allowedCapacityInput);
		driverUtilities.get().typeIntoTextBox(allowedCapacityInput, allowedCapacity);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterWaitlistCapacity(String waitlistCapacity) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(waitlistCapacityInput);
		driverUtilities.get().typeIntoTextBox(waitlistCapacityInput, waitlistCapacity);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterWaitlistExpiryDays(String expiryDays) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(waitlistExpiryDaysInput);
		driverUtilities.get().typeIntoTextBox(waitlistExpiryDaysInput, expiryDays);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterWaitlistMessage(String waitlistMessage) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(waitlistMessageTextarea);
		driverUtilities.get().typeIntoTextBox(waitlistMessageTextarea, waitlistMessage);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableAllowCancels() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(allowCancelsCheckbox);
		driverUtilities.get().clickOnElement(allowCancelsCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableAllowOptInAndOutOfNotification() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(allowOptInAndOutOfNotificationCheckbox);
		driverUtilities.get().clickOnElement(allowOptInAndOutOfNotificationCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void clickOnSaveButtonForRules() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(saveButtonForRules);
		driverUtilities.get().clickOnElement(saveButtonForRules);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	// ========== PAYMENTS SECTION METHODS ==========
	public void enterServiceFee(String serviceFee) {
		driverUtilities.get().makeElementVisibleIntoScreen(serviceFeeInput);
		driverUtilities.get().typeIntoTextBox(serviceFeeInput, serviceFee);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableTiredPricingEscalatedPricing() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(tiredPricingCheckbox);
		driverUtilities.get().clickOnElement(tiredPricingCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectPermitFeeDuration(String duration) {
		switch (duration.toLowerCase()) {
		case "daily":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(dailyPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(dailyPermitFeeCheckbox);
			break;
		case "monthly":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(monthlyPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(monthlyPermitFeeCheckbox);
			break;
		case "quarterly":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(quarterlyPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(quarterlyPermitFeeCheckbox);
			break;
		case "annually":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(annuallyPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(annuallyPermitFeeCheckbox);
			break;
		case "semi annually":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(semiAnnuallyPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(semiAnnuallyPermitFeeCheckbox);
			break;
		case "events":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(eventsPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(eventsPermitFeeCheckbox);
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterPermitFeeAmount(String amount) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(permitFeeAmountInput);
		driverUtilities.get().typeIntoTextBox(permitFeeAmountInput, amount);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectGuestPermitFeeDuration(String duration) {
		switch (duration.toLowerCase()) {
		case "daily":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(dailyGuestPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(dailyGuestPermitFeeCheckbox);
			break;
		case "monthly":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(monthlyGuestPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(monthlyGuestPermitFeeCheckbox);
			break;
		case "quarterly":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(quarterlyGuestPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(quarterlyGuestPermitFeeCheckbox);
			break;
		case "annually":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(annuallyGuestPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(annuallyGuestPermitFeeCheckbox);
			break;
		case "semi annually":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(semiAnnuallyGuestPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(semiAnnuallyGuestPermitFeeCheckbox);
			break;
		case "events":
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(eventsGuestPermitFeeCheckbox);
			driverUtilities.get().clickOnElement(eventsGuestPermitFeeCheckbox);
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterGuestPermitFeeAmount(String amount) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(guestPermitFeeAmountInput);
		driverUtilities.get().typeIntoTextBox(guestPermitFeeAmountInput, amount);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableSetupProrateFees() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(setupProrateFeesCheckbox);
		driverUtilities.get().clickOnElement(setupProrateFeesCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void selectProrateDuration(String duration) {
		driverUtilities.get().selectElementFromList(prorateDurationDropdown, duration);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enterProrateFeeAmount(String amount) {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(prorateFeeAmountInput);
		driverUtilities.get().typeIntoTextBox(prorateFeeAmountInput, amount);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void enableAllPaymentOptions() {
		// Enable Master Card
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(masterCardCheckbox);
		driverUtilities.get().clickOnElement(masterCardCheckbox);

		// Enable VISA
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(visaCheckbox);
		driverUtilities.get().clickOnElement(visaCheckbox);

		// Enable American Express
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(americanExpressCheckbox);
		driverUtilities.get().clickOnElement(americanExpressCheckbox);

		// Enable Discover
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(discoverCheckbox);
		driverUtilities.get().clickOnElement(discoverCheckbox);

		// Enable ACH
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(achCheckbox);
		driverUtilities.get().clickOnElement(achCheckbox);

		// Enable Check
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(checkCheckbox);
		driverUtilities.get().clickOnElement(checkCheckbox);

		// Enable Cash
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(cashCheckbox);
		driverUtilities.get().clickOnElement(cashCheckbox);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void clickOnSaveButtonForPayments() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(saveButtonForPayments);
		driverUtilities.get().clickOnElement(saveButtonForPayments);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	// ========== NOTIFICATIONS SECTION METHODS ==========
	public void enableAllAlertsForNotifications() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(enableAllAlertsCheckbox);
		driverUtilities.get().clickOnElement(enableAllAlertsCheckbox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void clickOnSaveButtonForNotifications() {
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(saveButtonForNotifications);
		driverUtilities.get().clickOnElement(saveButtonForNotifications);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	// ========== CONFIGURE QUESTION SECTION METHODS ==========
	public void dragAndDropPermitDurationToQuestionForm() {
		try {
			driverUtilities.get().waitForElementToBePresent(permitDurationComponent);
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(permitDurationComponent);
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(questionFormDropZone);

			// Perform drag and drop using Actions
			Actions actions = driverUtilities.get().getActions();
			driverUtilities.get().dragAndDropElement(actions, permitDurationComponent, questionFormDropZone);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		} catch (Exception e) {
			System.out.println("Error in dragAndDropPermitDurationToQuestionForm: " + e.getMessage());
		}
	}

	public void dragAndDropAddressDetailsToQuestionForm() {
		try {
			driverUtilities.get().waitForElementToBePresent(addressDetailsComponent);
			driverUtilities.get().makeElementVisibleIntoScreen(addressDetailsComponent);
			driverUtilities.get().makeElementVisibleIntoScreen(questionFormDropZone);

			// Perform drag and drop using Actions
			Actions actions = driverUtilities.get().getActions();
			driverUtilities.get().dragAndDropElement(actions, addressDetailsComponent, questionFormDropZone);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		} catch (Exception e) {
			System.out.println("Error in dragAndDropAddressDetailsToQuestionForm: " + e.getMessage());
		}
	}

	public void dragAndDropUserDetailsToQuestionForm() {
		try {
			driverUtilities.get().waitForElementToBePresent(userDetailsComponent);
			driverUtilities.get().makeElementVisibleIntoScreen(userDetailsComponent);
			driverUtilities.get().makeElementVisibleIntoScreen(questionFormDropZone);

			// Perform drag and drop using Actions
			Actions actions = driverUtilities.get().getActions();
			driverUtilities.get().dragAndDropElement(actions, userDetailsComponent, questionFormDropZone);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		} catch (Exception e) {
			System.out.println("Error in dragAndDropUserDetailsToQuestionForm: " + e.getMessage());
		}
	}

	public void clickOnsubmitButtonForConfigureQuestion() {
		driverUtilities.get().makeElementVisibleIntoScreen(submitButtonForConfigureQuestion);
		driverUtilities.get().clickOnElement(submitButtonForConfigureQuestion);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	// ========== VERIFICATION METHODS FOR DROPPED COMPONENTS ==========
	public void verifyPermitDurationComponentIsDropped() {
		try {
			driverUtilities.get().waitForElementToBePresent(droppedPermitDurationComponent);
			Assert.assertTrue("Permit Duration component was not dropped successfully",
					driverUtilities.get().isElementDisplayed(droppedPermitDurationComponent));
			System.out.println("✓ Permit Duration component successfully dropped and verified");
		} catch (Exception e) {
			Assert.fail("Permit Duration component verification failed: " + e.getMessage());
		}
	}

	public void verifyAddressDetailsComponentIsDropped() {
		try {
			driverUtilities.get().waitForElementToBePresent(droppedAddressDetailsComponent);
			Assert.assertTrue("Address Details component was not dropped successfully",
					driverUtilities.get().isElementDisplayed(droppedAddressDetailsComponent));
			System.out.println("✓ Address Details component successfully dropped and verified");
		} catch (Exception e) {
			Assert.fail("Address Details component verification failed: " + e.getMessage());
		}
	}

	public void verifyUserDetailsComponentIsDropped() {
		try {
			driverUtilities.get().waitForElementToBePresent(droppedUserDetailsComponent);
			Assert.assertTrue("User Details component was not dropped successfully",
					driverUtilities.get().isElementDisplayed(droppedUserDetailsComponent));
			System.out.println("✓ User Details component successfully dropped and verified");
		} catch (Exception e) {
			Assert.fail("User Details component verification failed: " + e.getMessage());
		}
	}
	
	// ========== WAITLIST CREATION METHODS ==========
	public void clickOnPermitParkingSpaceAvailability()
	{
	    driverUtilities.get().clickOnElement(permitParkingSpaceAvailabilityOption);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public void clickOnCreateWaitlistButton()
	{
	    driverUtilities.get().clickOnElement(createWaitlistButton);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public String enterWaitlistName()
	{
	    String waitlistName = "Test Waitlist " + GenerateRandomData.getFirstName() + " " + GenerateRandomData.getLastName();
	    driverUtilities.get().typeIntoTextBox(waitlistNameInput, waitlistName);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	    return waitlistName;
	}

	public String enterWaitlistDescription()
	{
	    String waitlistDescription = "This is a test waitlist description for " + GenerateRandomData.getFirstName() + " parking area";
	    driverUtilities.get().typeIntoTextBox(waitlistDescriptionTextarea, waitlistDescription);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	    return waitlistDescription;
	}

	public String enterWaitlistMessageForCreation()
	{
	    String waitlistMessage = "Test waitlist message for " + GenerateRandomData.getFirstName() + " parking permit";
	    driverUtilities.get().typeIntoTextBox(waitlistMessageTextareaForCreation, waitlistMessage);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	    return waitlistMessage;
	}

	public void enterWaitlistAllowedCapacityForCreation(String allowedCapacity)
	{
	    driverUtilities.get().typeIntoTextBox(waitlistAllowedCapacityInput, allowedCapacity);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public void enterWaitlistCapacityForCreation(String waitlistCapacity)
	{
	    driverUtilities.get().typeIntoTextBox(waitlistCapacityInputForCreation, waitlistCapacity);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public void enterWaitlistExpiryDaysForCreation(String expiryDays)
	{
	    driverUtilities.get().typeIntoTextBox(waitlistExpiryDaysInputForCreation, expiryDays);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public void enableWaitlistEnabledCheckbox()
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(waitlistEnabledCheckbox);
	    driverUtilities.get().clickOnElement(waitlistEnabledCheckbox);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public void clickOnCreateButton()
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(createButton);
	    driverUtilities.get().clickOnElement(createButton);
	    try {Thread.sleep(5000);}catch(InterruptedException e) {}
	}
	
	public void selectWaitlistFromDropdown(String waitlistName)
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(selectWaitlistDropdown);
		driverUtilities.get().selectElementFromList(selectWaitlistDropdown, waitlistName);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	

	public void dragAndDropPermitQuantityPlateDetailsToQuestionForm()
	{
		try {
			driverUtilities.get().waitForElementToBePresent(permitQuantityPlateDetailsComponent);
			driverUtilities.get().makeElementVisibleIntoScreen(permitQuantityPlateDetailsComponent);
			driverUtilities.get().makeElementVisibleIntoScreen(questionFormDropZone);
				
			// Perform drag and drop using Actions
			Actions actions = driverUtilities.get().getActions();
			driverUtilities.get().dragAndDropElement(actions, permitQuantityPlateDetailsComponent, questionFormDropZone);
			try {Thread.sleep(2000);}catch(InterruptedException e) {}
		} catch (Exception e) {
			System.out.println("Error in dragAndDropPermitQuantityPlateDetailsToQuestionForm: " + e.getMessage());
		}
	}
	
	public void verifyPermitTemplateCreatedSuccessMessage()
	{
		String msg = "//*[contains(text(),'Permit template successfully created')]";
		try { driverUtilities.get().getWebElement(msg); Assert.fail("Permit created successfully message not displayed");}catch(NoSuchElementException e) {}
	}
	
	// ========== PUBLISH PERMITS VERIFICATION METHODS ==========
	public void clickOnPublishPermitsOption()
	{
	    driverUtilities.get().clickOnElement(publishPermitsOption);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}

	public void verifyPermitConfigurationListPageDisplayed()
	{
	    try {driverUtilities.get().waitForElementToBePresent(permitConfigurationListTitle);}catch(TimeoutException e) {}
	    Assert.assertTrue("Permit Configuration List page is not displayed", 
	        driverUtilities.get().isElementDisplayed(permitConfigurationListTitle));
	    System.out.println("✓ Permit Configuration List page is displayed successfully");
	}

	public void verifyPermitNameAndZoneAndStatusVisibleInTable(String permitName, String zone)
	{
	    try {
	        // Wait for table to be present
	        driverUtilities.get().waitForElementToBePresent(permitConfigurationTable);
	        
	        // Find the row containing the permit name
	        String permitRowXPath = "//table[@id='cstm-report-tb-display']//tr[td[1][normalize-space()='" + permitName + "']]";
	        WebElement permitRow = driverUtilities.get().getWebElement(permitRowXPath);
	        
	        // Verify the row exists
	        Assert.assertTrue("Permit row with name '" + permitName + "' not found in table", 
	            driverUtilities.get().isElementDisplayed(permitRow));
	        
	        // Verify zone in the same row
	        String zoneXPath = permitRowXPath + "/td[5]";
	        WebElement zoneCell = driverUtilities.get().getWebElement(zoneXPath);
	        String actualZone = zoneCell.getText().trim();
	        Assert.assertEquals("Zone mismatch for permit '" + permitName + "'", zone, actualZone);
	        
	        // Verify status is ACTIVE
	        String statusXPath = permitRowXPath + "/td[2]";
	        WebElement statusCell = driverUtilities.get().getWebElement(statusXPath);
	        String actualStatus = statusCell.getText().trim();
	        Assert.assertEquals("Status is not ACTIVE for permit '" + permitName + "'", "ACTIVE", actualStatus);
	        
	        System.out.println("✓ Permit '" + permitName + "' with zone '" + zone + "' and status 'ACTIVE' verified in table");
	    } catch (Exception e) {
	        Assert.fail("Failed to verify permit '" + permitName + "' in table: " + e.getMessage());
	    }
	}

	public void verifyEditAndPayLinksPresentForPermit(String permitName)
	{
	    try {
	        // Find the row containing the permit name
	        String permitRowXPath = "//table[@id='cstm-report-tb-display']//tr[td[1][normalize-space()='" + permitName + "']]";
	        WebElement permitRow = driverUtilities.get().getWebElement(permitRowXPath);
	        
	        // Verify Edit link exists
	        String editLinkXPath = permitRowXPath + "//div[@class='table-action']//a[contains(text(),'Edit')]";
	        WebElement editLink = driverUtilities.get().getWebElement(editLinkXPath);
	        Assert.assertTrue("Edit link not found for permit '" + permitName + "'", 
	            driverUtilities.get().isElementDisplayed(editLink));
	        
	        // Verify Pay link exists
	        String payLinkXPath = permitRowXPath + "//div[@class='table-action']//a[contains(text(),'Pay')]";
	        WebElement payLink = driverUtilities.get().getWebElement(payLinkXPath);
	        Assert.assertTrue("Pay link not found for permit '" + permitName + "'", 
	            driverUtilities.get().isElementDisplayed(payLink));
	        
	        System.out.println("✓ Edit and Pay links verified for permit '" + permitName + "'");
	    } catch (Exception e) {
	        Assert.fail("Failed to verify Edit and Pay links for permit '" + permitName + "': " + e.getMessage());
	    }
	}

	public void verifyStatusIsActiveForPermit(String permitName)
	{
	    try {
	        // Find the row containing the permit name
	        String permitRowXPath = "//table[@id='cstm-report-tb-display']//tr[td[1][normalize-space()='" + permitName + "']]";
	        
	        // Verify status is ACTIVE
	        String statusXPath = permitRowXPath + "/td[2]";
	        WebElement statusCell = driverUtilities.get().getWebElement(statusXPath);
	        String actualStatus = statusCell.getText().trim();
	        Assert.assertEquals("Status is not ACTIVE for permit '" + permitName + "'", "ACTIVE", actualStatus);
	        
	        System.out.println("✓ Status verified as 'ACTIVE' for permit '" + permitName + "'");
	    } catch (Exception e) {
	        Assert.fail("Failed to verify status for permit '" + permitName + "': " + e.getMessage());
	    }
	}

	public void verifyIsPublicIsTrueForPermit(String permitName)
	{
	    try {
	        // Find the row containing the permit name
	        String permitRowXPath = "//table[@id='cstm-report-tb-display']//tr[td[1][normalize-space()='" + permitName + "']]";
	        
	        // Verify Is Public is true
	        String isPublicXPath = permitRowXPath + "/td[4]";
	        WebElement isPublicCell = driverUtilities.get().getWebElement(isPublicXPath);
	        String actualIsPublic = isPublicCell.getText().trim();
	        Assert.assertEquals("Is Public is not 'true' for permit '" + permitName + "'", "true", actualIsPublic);
	        
	        System.out.println("✓ Is Public verified as 'true' for permit '" + permitName + "'");
	    } catch (Exception e) {
	        Assert.fail("Failed to verify Is Public for permit '" + permitName + "': " + e.getMessage());
	    }
	}
}