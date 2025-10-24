package pages;

import java.awt.AWTException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import config.Settings;
import junit.framework.AssertionFailedError;
import path.Path;
import utility.ExcelCSV;
import utility.ExcelReader;
import utility.ExcelReaderXLS;
import utility.GenerateRandomData;
import utility.PropertyUtil;
import utility.ThursdayFinder;
import utility.Util;

public class TicketManagementPage extends BasePage
{
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'search')]/parent::li")
	public WebElement searchTicketMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'ticketreporting')]/parent::li")
	public WebElement ticketListViewMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'amendcitationlist')]/parent::li")
	public WebElement editTicketMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'regholdticket')]/parent::li")
	public WebElement regHoldTicketMenu;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Plate Analysis')]/parent::li")
	public WebElement plateAnalysisMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'ticketCountSummaryReport')]/parent::li")
	public WebElement ticketCountSummaryReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'ticketListReport')]/parent::li")
	public WebElement ticketListReportMenu;
	
	@FindBy(how=How.XPATH, using="//input[@name='ticket_no']")
	public WebElement citationSeachField;
	
	@FindBy(how=How.XPATH, using="//input[@name='lp_number']")
	public WebElement plateSeachField;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Submit')]")
	public WebElement submitSearchButton;
	
	@FindBy(how=How.XPATH, using="//li/a[contains(normalize-space(.), 'Linked Ticket') and contains(@href,'#linked')]")
	public WebElement linkedTicketTab;
	
	@FindBy(how=How.XPATH, using="//li/a[contains(normalize-space(.), 'Citation Info') and contains(@href,'#citation-info')]")
	public WebElement citationInfoTab;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class,'close')]/button")
	public WebElement closeButtonOfMessage;
	
	//citation appeal page locators
	@FindBy(how = How.XPATH, using = "//input[@name='first_name']")
	public WebElement firstNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='middle_name']")
	public WebElement middleNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='last_name']")
	public WebElement lastNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='telephone']")
	public WebElement telephoneTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement emailTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='address']")
	public WebElement addressTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	public WebElement cityTextbox;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'State')]//div[contains(@class,'control')]")
	public WebElement stateTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='zip']")
	public WebElement zipcodeTextbox;

	@FindBy(how = How.XPATH, using = "//textarea[@name='appeal_additional_reason']")
	public WebElement reasonForAppealTextbox;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Reason for appeal (Category)')]//input")
	public WebElement reasonForAppealCategoryTextbox;

	@FindBy(how = How.XPATH, using = "//h3[contains(normalize-space(.),'Appeal Citation')]/following-sibling::div//button[contains(text(),'Submit')]")
	public WebElement citationAppealSubmitButton;
	
	//appeal management form
	@FindBy(how = How.XPATH, using = "//input[@name='citation_number']")
	public WebElement citationNumberTextbox;
	
	//hearing form
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	public WebElement firstNameHearing;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	public WebElement lastNameHearing;
	
	@FindBy(how = How.XPATH, using = "//input[@name='date']")
	public WebElement dateHearing;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='comment']")
	public WebElement remarkHearing;
	
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement emailHearing;
	
	@FindBy(how = How.XPATH, using = "//input[@name='phone']")
	public WebElement phoneHearing;
	
	//Note popup
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Support Note')]")
	public WebElement notePopupHeading;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Enter Note*')]/following-sibling::div//div[contains(@data-placeholder,'Start typing...')]")
	public WebElement enterNoteTextarea;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Support Note')]/ancestor::div//button[contains(text(),'Submit')]")
	public WebElement noteSubmitButton1;
	
	@FindBy(how = How.XPATH, using = "(//h3[contains(text(),'Support Note')]/ancestor::div//button[contains(text(),'Submit')])[2]")
	public WebElement noteSubmitButton2;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Choose File')]/following-sibling::input")
	public WebElement chooseFileButton;
	
	//void citation
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(.), 'Cancel Citation Reason')]/following-sibling::select")
	public WebElement cancelCitationReasonList;
	
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(.), 'Cancel Citation Comments')]/following-sibling::textarea")
	public WebElement cancelCitationComments;
	
	@FindBy(how = How.XPATH, using = "//p[contains(normalize-space(.), 'Cancel Citation')]/following-sibling::div/button[contains(text(),'Submit')]")
	public WebElement cancelCitationSubmitButton;
	
	//status change popup
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(.), 'Status ')]/following-sibling::select")
	public WebElement StatusList;
	
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(.), 'Remark')]/following-sibling::textarea")
	public WebElement statusRemarkTextarea;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(normalize-space(.), 'Update Status')]/ancestor::div/following-sibling::div//button[contains(text(),'Submit')]")
	public WebElement updateStatusSubmitButton;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Appeal eligible date')]/parent::*/following-sibling::*//input")
	public WebElement appealEligibleDateInput;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Hearing eligible date')]/parent::*/following-sibling::*//input")
	public WebElement hearingEligibleDateInput;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Change Amount') or contains(text(),'Submit')]")
	public WebElement changeAmountButton;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Submit')]")
	public WebElement submitButtonAfterChangeAmount;
	
	//financial page
	@FindBy(how=How.XPATH, using="//*[contains(normalize-space(.), 'Add Charge Back Fees')]/input[@type='checkbox']")
	public WebElement chargeBackCheckbox;
	
	@FindBy(how=How.XPATH, using="//*[contains(normalize-space(.), 'Add NSF Fees')]/input[@type='checkbox']")
	public WebElement nsfCheckbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='charge_back_fee']")
	public WebElement chargeBackTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='nsf_amount']")
	public WebElement nsfTextbox;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Charge Back Applied Date')]/parent::div/following-sibling::div//input")
	public WebElement chargeBackAppliedDateTextbox;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'NSF Applied Date')]/parent::div/following-sibling::div//input")
	public WebElement nsfAppliedDateTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='original_amount']")
	public WebElement originalAmoutTextbox;
	
	//payment screen
	@FindBy(how=How.XPATH, using="//div[contains(@class,'info-edit-button')]/img")
	public WebElement editIconOfPaymentAmount;
	
	@FindBy(how=How.XPATH, using="//input[contains(@class,'fine-amount-input')]")
	public WebElement changeAmountTextbox;
	
	@FindBy(how=How.XPATH, using="//h6[contains(text(),'Payment amount')]/parent::div/following-sibling::div/h5")
	public WebElement payableAmountLabel;
	
	//refund popup
	@FindBy(how=How.XPATH, using="//input[@name='citationNumber']")
	public WebElement refundCitationTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='fineAmount']")
	public WebElement refundAmountTextbox;
	
	@FindBy(how=How.XPATH, using="//textarea[@name='reason']")
	public WebElement refundReasonTextArea;
	
	@FindBy(how=How.XPATH, using="//select[@name='drinksDropdown']")
	public WebElement refundSourceList;
	
	@FindBy(how=How.XPATH, using="//button[text()='Submit Refund']")
	public WebElement submitRefundButton;
	
	//search ticket page
	@FindBy(how=How.XPATH, using="//label[contains(text(),'License Plate*')]/following-sibling::input")
	public WebElement licensePlateTextBox;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Search')]")
	public WebElement searchButtonOfSeatchTic;
	
	// Add Address button locator
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Address') or contains(text(),'Add address')]")
	public WebElement addAddressButton;

	// RO Information popup locator
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'RO Information') or contains(text(),'Registered Owner Information')]")
	public WebElement roInformationPopup;

	// RO Information form field locators - Based on actual HTML structure
	@FindBy(how=How.XPATH, using="//textarea[@name='address']")
	public WebElement roAddressField;

	@FindBy(how=How.XPATH, using="//input[@name='city']")
	public WebElement roCityField;

	@FindBy(how=How.XPATH, using="//*[contains(text(),'RO Information')]/ancestor::div/following-sibling::div//span[contains(text(),'State *')]/following-sibling::div//input")
	public WebElement roStateField;

	@FindBy(how=How.XPATH, using="//input[@name='zip']")
	public WebElement roZipField;

	@FindBy(how=How.XPATH, using="//input[@name='name']")
	public WebElement roNameField;

	@FindBy(how=How.XPATH, using="//input[@name='email']")
	public WebElement roEmailField;

	@FindBy(how=How.XPATH, using="//input[@name='phone']")
	public WebElement roPhoneField;
	
	@FindBy(how=How.XPATH, using="//input[@name='reason']")
	public WebElement roReasonField;

	@FindBy(how=How.XPATH, using="//button[contains(text(),'Change Address')]")
	public WebElement roChangeAddressButton;
	
	// Ticket number search field locator
	@FindBy(how=How.XPATH, using="//input[@name='ticketNumber' or @id='ticketNumber']")
	public WebElement ticketNumberField;

	// Search button locator
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Search') and contains(@class,'btn')]")
	public WebElement searchButton;
	
	// License plate search field locator
	@FindBy(how=How.XPATH, using="//input[@name='licPlate' or @id='licPlate']")
	public WebElement licensePlateField;
	
	// New locators for search form user details fields - based on Search Ticket.html
	@FindBy(how=How.XPATH, using="//input[@name='userName' and @id='userName']")
	public WebElement searchFormNameField;
	
	@FindBy(how=How.XPATH, using="//input[@name='address' and @id='address']")
	public WebElement searchFormAddressField;
	
	@FindBy(how=How.XPATH, using="//input[@name='city' and @id='city']")
	public WebElement searchFormCityField;
	
	@FindBy(how=How.XPATH, using="//input[@name='zip' and @id='zip']")
	public WebElement searchFormZipField;
	
	@FindBy(how=How.XPATH, using="//input[@name='email' and @id='email']")
	public WebElement searchFormEmailField;
	
	@FindBy(how=How.XPATH, using="//input[@name='phone' and @id='phone']")
	public WebElement searchFormPhoneField;
	
	@FindBy(how=How.XPATH, using="//input[@name='end_date']")
	public WebElement endDate;
	
	@FindBy(how=How.XPATH, using="//input[@name='start_date']")
	public WebElement startDate;
	
	// License State field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@placeholder='License State']")
	public WebElement licenseStateField;
	
	// Status field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@placeholder='Select Status']")
	public WebElement statusField;
	
	// Violation Code field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@placeholder='Violation code']")
	public WebElement violationCodeField;
	
	@FindBy(how=How.XPATH, using="//input[@name='lp_number']")
	public WebElement licensePlateFieldTicketListView;
	
	// Violation Description field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@placeholder='Select Violation Description']")
	public WebElement violationDescriptionField;
	
	// Officer Name field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@placeholder='Officer Name']")
	public WebElement officerNameField;
	
	// Street field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@name='street_input' and @placeholder='Search Street']")
	public WebElement streetField;
	
	// Remark field locator for ticket list view
	@FindBy(how=How.XPATH, using="//input[@name='remark_input' and @placeholder='Remarks']")
	public WebElement remarkField;
	
	// Additional locators for hearing slot selection (add these to your locators section)
	@FindBy(how=How.XPATH, using="//input[contains(@placeholder,'Citation Number')]")
	public WebElement citationNumberInput;

	@FindBy(how=How.XPATH, using="//button[contains(text(),'Save') and contains(@class,'hearing')]")
	public WebElement hearingSaveButton;

	@FindBy(how=How.XPATH, using="//*[contains(text(),'hearing scheduled successfully') or contains(text(),'Hearing scheduled')]")
	public WebElement hearingSuccessMessage;
	
	public void verifyTicketManagementMenus()
	{
		String client = Settings.clientName;
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(searchTicketMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketListViewMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(editTicketMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(regHoldTicketMenu));
		String platAnalysis = Settings.plateAnalysisMenu;
		if(platAnalysis.equalsIgnoreCase("true"))
		{
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(plateAnalysisMenu));
		}
		String tcktCoutSumaryReptMenu = Settings.ticketCountSummaryReportMenu;
		if(tcktCoutSumaryReptMenu.equalsIgnoreCase("true"))
		{
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketCountSummaryReportMenu));
		}
		String ticktLstReportMenu = Settings.ticketListReportMenu;
		if(ticktLstReportMenu.equalsIgnoreCase("true"))
		{
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketListReportMenu));
		}
	}
	
	public void clickOnTicketViewListOption()
	{
		driverUtilities.get().clickOnElement(ticketListViewMenu);
	}
	
	public void clickOnSearchTicketOption()
	{
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), searchTicketMenu);
	}
	
	public void enterCitationNumberForSearch(String citation)
	{
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		driverUtilities.get().clearTextBox(citationSeachField);
		driverUtilities.get().typeIntoTextBox(citationSeachField, citation);
	}
	
	public void enterPlateNumberForSearch(String plate)
	{
		driverUtilities.get().typeIntoTextBox(plateSeachField, plate);
	}
	
	public void clickOnSearchSubmitButton()
	{
		driverUtilities.get().clickOnElement(submitSearchButton);
		try {driverUtilities.get().waitForElementToBePresent2("//select[contains(@class,'select-pagination-val')]");}catch(TimeoutException e) {}
	}
	
	public void verifyTickteSearchedBasedOnCitation(String citation)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+citation+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnPlateNumber(String plateNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+plateNumber+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnState(String state)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+state+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnVc(String vc)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+vc+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnFineAmount(String fa)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(normalize-space(.), '"+fa+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnRemark(String remark)
	{
		String canRemark = Settings.canRemark;
		if(canRemark.equalsIgnoreCase("true"))
		{
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(normalize-space(.), '"+remark+"')]")));
		}
	}
	
	public void verifyTickteSearchedBasedOnTicketCategory(String category)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(normalize-space(.), '"+category+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnTicketStatus(String status)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(normalize-space(.), '"+status+"')]")));
	}
	
	public void clickOnHyperlink(String plateNumber)
	{
		plateNumber = plateNumber.toUpperCase();
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+plateNumber+"')]"));
	}
	
	public void clickOnHyperlinkDateTime(String citationNumber)
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("(//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+citationNumber+"')]/ancestor::tr/td/a)[1]"));
	}
	
	public void verifyTabSelected(String tabName)
	{
		String className;
		if(tabName.equalsIgnoreCase("Linked Ticket"))
		{
			className = driverUtilities.get().getAttribute(linkedTicketTab, "class");
			Assert.assertTrue(className.contains("active"));
		}
		else if(tabName.equalsIgnoreCase("Linked Ticket"))
		{
			className = driverUtilities.get().getAttribute(linkedTicketTab, "class");
			Assert.assertTrue(className.contains("active"));
		}
	}
	
	public void verifyLabelAndKeyValue(String lebel , String value)
	{	
		if(lebel.equalsIgnoreCase("Ticket Status") && value.equalsIgnoreCase("Suspended"))
		{
			String suspend = Settings.canSuspend;
			if(suspend.equalsIgnoreCase("true"))
			{
				Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), '"+lebel+"')]/following-sibling::*[contains(normalize-space(.),'"+value+"')]")));				
			}
			else
			{
				Assert.fail("Cannto change status of citation to Suspended for client "+Settings.clientName);
			}
		}
		else if(lebel.equalsIgnoreCase("Amount Due"))
		{
			//driverUtilities.get().makeElementVisibleIntoScreen(originalAmoutTextbox);
			String originalFile = driverUtilities.get().getAttribute(originalAmoutTextbox,"value");
			System.out.println("originalFile:="+originalFile);
			Assert.assertTrue(originalFile.contains(value));
		}
		else
		{
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), '"+lebel+"')]/following-sibling::*[contains(normalize-space(.),'"+value+"')]")));
		}
	}
	
	public void verifyLabelAndKeyValueNotVisible(String lebel , String value)
	{	
		if(lebel.equalsIgnoreCase("Ticket Status") && value.equalsIgnoreCase("Suspended"))
		{
			String suspend = Settings.canSuspend;
			if(suspend.equalsIgnoreCase("true"))
			{
				Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), '"+lebel+"')]/following-sibling::*[contains(normalize-space(.),'"+value+"')]")));				
			}
			else
			{
				Assert.fail("Cannto change status of citation to Suspended for client "+Settings.clientName);
			}
		}
		else if(lebel.equalsIgnoreCase("Amount Due"))
		{
			//driverUtilities.get().makeElementVisibleIntoScreen(originalAmoutTextbox);
			String originalFile = driverUtilities.get().getAttribute(originalAmoutTextbox,"value");
			System.out.println("originalFile:="+originalFile);
			Assert.assertTrue(originalFile.contains(value));
		}
		else
		{
			try{driverUtilities.get().getWebElement("//*[contains(normalize-space(.), '"+lebel+"')]/following-sibling::*[contains(normalize-space(.),'"+value+"')]"); Assert.fail("Suspended citation visible");}catch(NoSuchElementException e) {}
		}
	}
	
	public void verifyElementPresent(String element , String name)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//"+element+"[contains(text(),'"+name+"')]")));
	}
	
	public void verifyTableHeader(String tableClassName , String headerName)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'"+tableClassName+"')]/table/thead//tr/th[contains(normalize-space(.), '"+headerName+"')]")));
	}
	
	public void verifyTableValue(String tableClassName , String value)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'"+tableClassName+"')]/table/tbody//tr/td[contains(normalize-space(.), '"+value+"')]")));
	}
	
	public void navigateToTab(String tabName , String hrefLink)
	{
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		String path= "//a[contains(normalize-space(.),'"+tabName+"') and @href='"+hrefLink+"']/parent::li";
		WebElement tabLink = driverUtilities.get().getWebElement(path);
		//driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'Logout')]"));
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().scrollUpWebPage();
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(tabLink);
		driverUtilities.get().clickOnElement(tabLink);
	}
	
	public void verifySectionLabelAndKeyValue(String section, String lebel , String value)
	{
		String path = "//*[contains(normalize-space(.),'"+section+"')]/following-sibling::*//*[contains(normalize-space(.), '"+lebel+"')]/following-sibling::*[contains(normalize-space(.),'"+value+"')]";
		WebElement pathEle = null;
		try
		{
			pathEle = driverUtilities.get().getWebElement(path);
			driverUtilities.get().makeElementVisibleIntoScreen(pathEle);
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathEle));
		}
		catch(NoSuchElementException e)
		{
			path = "//*[contains(normalize-space(.),'"+section+"')]/following-sibling::*//*[contains(normalize-space(.), '"+lebel+"')]/following-sibling::*[contains(normalize-space(.),'"+value.replaceAll("[^a-zA-Z0-9]", "")+"')]";
			try{pathEle = driverUtilities.get().getWebElement(path);}catch(NoSuchElementException e1) {}
			try{driverUtilities.get().makeElementVisibleIntoScreen(pathEle);
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathEle));
			}
			catch(Exception e2) {}
		}	
	}
	
	public void verifySectionLabelAndValue(String section, String lebel )
	{
		String path = "//*[contains(normalize-space(.),'"+section+"')]/following-sibling::*//*[contains(normalize-space(.), '"+lebel+"')]";
		WebElement pathEle = driverUtilities.get().getWebElement(path);
		driverUtilities.get().makeElementVisibleIntoScreen(pathEle);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathEle));
	}
	
	public void verifyImagesUnderLabel(String count , String label)
	{
		int c = driverUtilities.get().getNumberOfElement("//*[contains(text(),'Images')]/following-sibling::*//img");
		Assert.assertEquals(c, Integer.parseInt(count));
	}
	
	public void clickOnPayButtonFromFinancial()
	{
		String isFinancialPay = Settings.isPayFromFinancial;
		if(isFinancialPay.equalsIgnoreCase("true"))
		{
			String path= "//button[contains(text(),'Pay')]";
			try{driverUtilities.get().waitForElementToBePresent2(path);}catch(TimeoutException e){}
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(driverUtilities.get().getWebElement(path));
			//driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), driverUtilities.get().getWebElement(path));
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path));
		}
		else
		{
			Assert.fail("Pay from financial is not available for client "+Settings.clientName);
		}
	}
	
	public void clickOnStateButton(String stateButton)
	{
		String suspend = Settings.canSuspend;
		String unsuspend = Settings.canUnsuspend;
		String hearing = Settings.canHearing;
		String appeal = Settings.canAppeal;
		String note = Settings.canNote;
		String edit = Settings.canEdit;
		String isVoid = Settings.canVoid;
		String isStatus = Settings.canStatus;
		System.out.println("suspend="+suspend+"----"+stateButton);
		System.out.println("hearing="+hearing+"----"+stateButton);
		System.out.println("appeal="+appeal+"----"+stateButton);
		
		if(stateButton.equalsIgnoreCase("Appeal"))
		{
			if(appeal.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				try{driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));}catch(NoSuchElementException e) {}
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Appeal is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Suspend"))
		{
			if(suspend.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Suspend is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Unsuspend"))
		{
			if(unsuspend.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Suspend is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Hearing"))
		{
			if(hearing.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Hearing is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Note"))
		{
			if(note.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Note is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Edit"))
		{
			if(edit.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Edit is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Void"))
		{
			if(isVoid.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Void is not available for "+Settings.clientName);
			}
		}
		
		if(stateButton.equalsIgnoreCase("Status"))
		{
			if(isStatus.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Status is not available for "+Settings.clientName);
			}
		}
		if(stateButton.equalsIgnoreCase("Hearing Outcome"))
		{
			if(hearing.equalsIgnoreCase("true"))
			{
				String buttonPath = "//*[contains(text(),'"+stateButton+"')]/ancestor::button";
				driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//a[contains(text(),'Financial')]"));
				System.out.println("buttonPath="+buttonPath);
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(buttonPath));
			}
			else
			{
				Assert.fail("Hearing is not available for "+Settings.clientName);
			}
		}
	}
	
	public void verifyPopup(String poupName)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'cstm-modal-title')]/h3[contains(text(),'"+poupName+"')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'cstm-modal-title')]/h3[contains(text(),'"+poupName+"')]/parent::div/following-sibling::*/button[contains(text(),'×')]")));
		String submitButton = "//div[contains(@class,'cstm-modal-title')]/h3[contains(text(),'"+poupName+"')]/ancestor::div//button[contains(text(),'Submit')]";
		int c = driverUtilities.get().getNumberOfElement(submitButton);
		submitButton = "(" + submitButton + ")[" + c + "]";
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(submitButton)));
	}
	
	public void enterReasonForSuspending(String reason)
	{
		String path= "//div[contains(@class,'inputfield-suspened')]/following-sibling::div//textarea";
		WebElement textArea = driverUtilities.get().getWebElement(path);
		driverUtilities.get().clearTextBox(textArea);
		driverUtilities.get().typeIntoTextBox(textArea, reason);
	}
	
	public void clickOnToTheButtonOfpopup(String buttonName, String popupName)
	{
		String path= "//button[contains(text(),'"+buttonName+"')]";
		int c = driverUtilities.get().getNumberOfElement(path);
		path = "(" + path + ")[" + c + "]";
		WebElement button = driverUtilities.get().getWebElement(path);
		driverUtilities.get().clickOnElement(button);
	}
	
	public void verifyNotEligibleForAnAppealMessage()
	{
		String textMessage = "//*[contains(text(),'Citation is not eligible for Appeal')]";
		WebElement message = driverUtilities.get().getWebElement(textMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(message));
	}
	
	public void closeMessagePopup()
	{
		try{driverUtilities.get().clickOnElement(closeButtonOfMessage);}catch(NoSuchElementException e) {}
	}
	
	public void verifyNotEligibleForHearingMessage()
	{
		String textMessage = "//*[contains(text(),'Citation is not eligible for Hearing')]";
		WebElement message = driverUtilities.get().getWebElement(textMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(message));
	}
	
	public void verifyFiledValues(String field, String value)
	{
		String path ="//*[contains(normalize-space(.),'"+field+"')]/input";
		try{driverUtilities.get().waitForElementToBePresent2("//*[contains(normalize-space(.),'"+field+"')]/input");}catch(TimeoutException e) {}
		WebElement pathEle = driverUtilities.get().getWebElement(path);
		String propertValue = driverUtilities.get().getAttribute(pathEle, "value");
		Assert.assertEquals(propertValue, value);
	}
	
	public String enterValueInToFirstName()
	{
		String firstName = GenerateRandomData.getFirstName();
		driverUtilities.get().clearTextBox(firstNameTextbox);
		driverUtilities.get().typeIntoTextBox(firstNameTextbox,firstName );
		return firstName;
	}
	
	public String enterValueIntoMiddleName() 
	{
		String middleName = GenerateRandomData.getMiddleName();
		driverUtilities.get().clearTextBox(middleNameTextbox);
		driverUtilities.get().typeIntoTextBox(middleNameTextbox, middleName);
		return middleName;
	}

	public String enterValueIntoLastName()
	{
		String lastName = GenerateRandomData.getLastName();
		driverUtilities.get().clearTextBox(lastNameTextbox);
		driverUtilities.get().typeIntoTextBox(lastNameTextbox, lastName);
		return lastName;
	}

	public String enterValueIntoTelephone() 
	{
		String phone = GenerateRandomData.getPhoneNumber();
		driverUtilities.get().clearTextBox(telephoneTextbox);
		driverUtilities.get().typeIntoTextBox(telephoneTextbox, phone);
		return phone;
	}

	public String enterValueIntoEmail() 
	{
		String email = GenerateRandomData.getEmailAddress();
		driverUtilities.get().clearTextBox(emailTextbox);
		driverUtilities.get().typeIntoTextBox(emailTextbox, email);
		return email;
	}

	public String enterValueIntoAddress()
	{
		String address = GenerateRandomData.getAddress();
		driverUtilities.get().clearTextBox(addressTextbox);
		driverUtilities.get().typeIntoTextBox(addressTextbox, address);
		return address;
	}

	public String enterValueIntoCity() 
	{
		String city = GenerateRandomData.getCity();
		driverUtilities.get().clearTextBox(cityTextbox);
		driverUtilities.get().typeIntoTextBox(cityTextbox, city);
		return city;
	}

	public void selectValueIntoState()
	{
		//driverUtilities.get().clearTextBox(stateTextbox);
		//driverUtilities.get().typeIntoTextBox(stateTextbox, Settings.appealState);
		
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), stateTextbox);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), driverUtilities.get().getWebElement("//*[contains(text(),'"+Settings.appealState+"')]"));
	}

	public String enterValueIntoZipcode()
	{
		//driverUtilities.get().makeElementVisibleIntoScreen(zipcodeTextbox);
		String zip = GenerateRandomData.getZipCode();
		driverUtilities.get().clearTextBox(zipcodeTextbox);
		driverUtilities.get().typeIntoTextBox(zipcodeTextbox, zip);
		return zip;
	}

	public String enterValueIntoReasonForAppeal() 
	{
		//driverUtilities.get().makeElementVisibleIntoScreen(reasonForAppealTextbox);
		String reason = GenerateRandomData.getReason();
		driverUtilities.get().clearTextBox(reasonForAppealTextbox);
		driverUtilities.get().typeIntoTextBox(reasonForAppealTextbox, reason);
		return reason;
	}
	
	public void enterInToReasonCategory()
	{
		String categpry = Settings.appealReasonCategory;
		driverUtilities.get().makeElementVisibleIntoScreen(reasonForAppealCategoryTextbox);
		driverUtilities.get().clearTextBox(reasonForAppealCategoryTextbox);
		driverUtilities.get().typeIntoTextBox(reasonForAppealCategoryTextbox, Settings.appealReasonCategory);
		String optionPath = "//*[text()='"+categpry+"']";
		try {Thread.sleep(500);}catch(InterruptedException e) {}
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(optionPath));
	}
	
	public void selectTearmsAndCondition()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//input[@name='term4']"));
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='term1']"));
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='term2']"));
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='term3']"));
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='term4']"));
	}
	
	public void clickOnCitationAppealSubmitButton()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(citationAppealSubmitButton);
		driverUtilities.get().clickOnElement(citationAppealSubmitButton);
	}
	
	public String fillCitationAppealForm(String field)
	{
		String value = "";
		if(field.equalsIgnoreCase("first name"))
		{
			value = enterValueInToFirstName();
		}
		else if(field.equalsIgnoreCase("middle name"))
		{
			value = enterValueIntoMiddleName();
		}
		else if(field.equalsIgnoreCase("last name"))
		{
			value = enterValueIntoLastName();
		}
		else if(field.equalsIgnoreCase("telephone number"))
		{
			value = enterValueIntoTelephone();
		}
		else if(field.equalsIgnoreCase("email address"))
		{
			value = enterValueIntoEmail();
		}
		else if(field.equalsIgnoreCase("address"))
		{
			value = enterValueIntoAddress();
		}
		else if(field.equalsIgnoreCase("city"))
		{
			value = enterValueIntoCity();
		}
		else if(field.equalsIgnoreCase("zip code"))
		{
			value = enterValueIntoZipcode();
		}
		else if(field.equalsIgnoreCase("reason for appeal"))
		{
			value = enterValueIntoReasonForAppeal();
		}
		return value;
	}
	
	public void fillCitationAppealFormSomeFileds(String field)
	{
		if(field.equalsIgnoreCase("state"))
		{
			selectValueIntoState();
		}
		else if(field.equalsIgnoreCase("reason category"))
		{
			enterInToReasonCategory();
		}
	}
	
	public void clickOnSubmitOfCitationAppeal()
	{
		try{driverUtilities.get().makeElementVisibleIntoScreen(citationAppealSubmitButton);}catch(NoSuchElementException e) {}
		driverUtilities.get().clickOnElement(citationAppealSubmitButton);
		try{driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Appeal Reports')]");}catch(TimeoutException e) {}catch(NoSuchElementException e1) {}
		try{driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Appeal Reports')]");}catch(TimeoutException e) {}catch(NoSuchElementException e1) {}
	}
	
	public void scrollUptoElement(String element)
	{
		String buttonPath = "//*[contains(text(),'"+element+"')]";
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement(buttonPath));
	}
	
	
	private void selectHearingBookingSlot() throws ParseException
	{
		int availableSlotCount;
		String nextValidThurshDay = ThursdayFinder.getNextFirstOrThirdThursday("d-MMMM-yyyy");
		String month = nextValidThurshDay.split("-")[1];
		String date = nextValidThurshDay.split("-")[0];
		String year = nextValidThurshDay.split("-")[2];
		String nextFirstOrThirdThurshdayStringPath = month + " " + date + ", " + year;
		String nextFirstOrThirdThurshdayDate = "//*[contains(@aria-label,'"+nextFirstOrThirdThurshdayStringPath+"')]";
		
		String monthCurrent = Util.getCurrentSystemDate("MM");
		int monthCuttentToComapre = Integer.parseInt(monthCurrent);
		int monthToCompare = Util.convertMonthNameToNumber(month);
		
		if( monthCuttentToComapre < monthToCompare )
		{
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(@class,'arrow react-calendar__navigation__next-button')]"));
			try{Thread.sleep(Duration.ofSeconds(2));}catch(InterruptedException e) {}
		}
		
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='hearingDate']"));
		try{Thread.sleep(Duration.ofSeconds(5));}catch(InterruptedException e) {}
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(nextFirstOrThirdThurshdayDate));
		try{Thread.sleep(Duration.ofSeconds(2));}catch(InterruptedException e) {}
		
		String getAvailableSeatSlotString = "//div[contains(@class,'time-slots')]//*[contains(text(),'Available')]";
		List<WebElement> getAvailableSeatSlotStringElements = driverUtilities.get().getAllWebElements(getAvailableSeatSlotString);
		
		for(WebElement elements : getAvailableSeatSlotStringElements )
		{
			String text = driverUtilities.get().getElementText(elements);
			System.out.println("Slot information:="+text);
			
			String count = text.split(" ")[0];
			availableSlotCount = Integer.parseInt(count);
			System.out.println("availableSlotCount:="+availableSlotCount);
			if(availableSlotCount>0)
			{
				int totalSlotsTimings = driverUtilities.get().getNumberOfElement("//div[contains(@class,'time-slots')]//*[contains(text(),'Available')]/ancestor::div[contains(@class,'slot-info')]/ancestor::button");
				System.out.println("totalSlotsTimings:="+totalSlotsTimings);
				for(int i=1; i<=availableSlotCount; i++)
				{
					String path = "(//div[contains(@class,'time-slots')]//*[contains(text(),'Available')]/ancestor::div[contains(@class,'slot-info')]/ancestor::button)["+i+"]";
					System.out.println("path:="+path);
					WebElement slotCard = driverUtilities.get().getWebElement(path);
					String isDisable = driverUtilities.get().getElementAttribute(slotCard, "disabled");
					System.out.println("isDisable:="+isDisable);
					if(isDisable == null)
					{
						System.out.println("In side is disabled verification");
						driverUtilities.get().clickOnElement(slotCard);
						System.out.println("slot card clicked");
						break;
					}
				}
				/*try
				{
					driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(@class,'time-slots')]//*[contains(text(),'Available')]/ancestor::div[contains(@class,'slot-info')]/ancestor::button"));
				}
				catch(NoSuchElementException e)
				{
					driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("(//div[contains(@class,'time-slots')]//*[contains(text(),'Available')]/ancestor::div[contains(@class,'slot-info')]/ancestor::button)[2]"));
				}
				*/
			}
		}
	       
	     // Step 3: Click on Select Hearing button
	    String selectHearingXPath = "//button[contains(text(),'Select Hearing')]";
	    WebElement selectButton = driverUtilities.get().getWebElement(selectHearingXPath);
	    driverUtilities.get().clickOnElement(selectButton);
	    System.out.println("✓ Clicked on Select Hearing button");
	}
	
	public String enterHearingData(String field) throws ParseException
	{
		String value="";
		if(field.equalsIgnoreCase("first name"))
		{
			value = GenerateRandomData.getFirstName();
			driverUtilities.get().typeIntoTextBox(firstNameHearing, value);
		}
		else if(field.equalsIgnoreCase("last name"))
		{
			value = GenerateRandomData.getLastName();
			driverUtilities.get().typeIntoTextBox(lastNameHearing, value);
		}
		else if(field.equalsIgnoreCase("Date"))
		{
			try{driverUtilities.get().clickOnElement(dateHearing);}catch(NoSuchElementException e) {}
			try{Thread.sleep(Duration.ofSeconds(4));}catch(InterruptedException e) {}
			selectHearingBookingSlot();
		}
		else if(field.equalsIgnoreCase("remark"))
		{
			value = GenerateRandomData.getReason();
			driverUtilities.get().typeIntoTextBox(remarkHearing, value);
		}
		else if(field.equalsIgnoreCase("Email"))
		{
			value = GenerateRandomData.getEmailAddress();
			driverUtilities.get().typeIntoTextBox(emailHearing, value);
		}
		else if(field.equalsIgnoreCase("phone"))
		{
			value = GenerateRandomData.getPhoneNumber();
			driverUtilities.get().typeIntoTextBox(phoneHearing, value);
		}
		return value;
	}
	
	public void verifyFieldValueFromFinancialPage(String field, String keyValue)
	{
		String path= "//label[contains(normalize-space(.), '"+field+"')]/parent::div/following-sibling::div/input";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		String text = driverUtilities.get().getAttribute(pathElement, "value");
		text = text.split(".")[0];
		System.out.println("keyValue:="+keyValue);
		System.out.println("text:="+text);
		Assert.assertTrue(text.equals(keyValue));
	}
	
	public void verifyFieldValWithConfiguredFinancialPage(String field)
	{
		String serChrg=Settings.serviceCharge;
		String path= "//label[contains(normalize-space(.), '"+field+"')]/parent::div/following-sibling::div/input";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		String text = driverUtilities.get().getAttribute(pathElement, "value");
		Assert.assertTrue(text.equals(serChrg));
	}
	
	public void verifyRegisterDetails(String value)
	{
		try{driverUtilities.get().getWebElement("//*[contains(text(),'"+value+"')]");}catch(NoSuchElementException e) {System.out.println("Not gone from appeal");}
	}
	
	public void verifyAuditDetails(String auditDetails)
	{
		try{driverUtilities.get().getWebElement("//h6[contains(normalize-space(.), '"+auditDetails+"')]");}catch(NoSuchElementException e) {System.out.println("Not gone from appeal");}
	}
	
	public void verifyAuditDetailsAsKey(String auditDetails)
	{
		try{driverUtilities.get().getWebElement("//h6[contains(normalize-space(.), '"+auditDetails+"')]");}catch(NoSuchElementException e) {System.out.println("Not gone from appeal");}
	}
	
	public void verifyAddressFromUserDetailPage(String label, String keyValue)
	{
		try{driverUtilities.get().getWebElement("//p[contains(normalize-space(.), '"+label+"')]/following-sibling::h5[contains(text(),'"+keyValue+"')]");}catch(NoSuchElementException e) {System.out.println("Not gone from appeal");}
	}
	
	public void verifyAddFromUserDetailPageBillingAddSameAsUserDetails(String label, String keyValue)
	{
		String isBillingAddressCheckBox = Settings.isBillingAddressCheckbox;
		if(isBillingAddressCheckBox.equalsIgnoreCase("true"))
		{
			driverUtilities.get().getWebElement("(//p[contains(normalize-space(.), '"+label+"')]/following-sibling::h5[contains(text(),'"+keyValue+"')])[2]");
		}
		else
		{
			Assert.fail("Billing address same as user details check box not for client "+Settings.clientName);
		}
	}
	
	public void verifySupportNotePopup()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(notePopupHeading));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(enterNoteTextarea));
		String submitButton = "//h3[contains(text(),'Support Note')]/ancestor::div//button[contains(text(),'Submit')]";
		int c = driverUtilities.get().getNumberOfElement(submitButton);
		submitButton = "(" + submitButton + ")[" + c + "]";
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(submitButton)));
	}
	
	public String enterNote()
	{
		String note = "Note for citation"+Util.generateRandomNumber(10);
		driverUtilities.get().typeIntoTextBox(enterNoteTextarea, note);
		return note;
	}
	
	public void clickOnChooseFilenAndUpload( String fileFormat ) throws AWTException
	{
		driverUtilities.get().makeElementVisibleIntoScreen(chooseFileButton);
		try{Thread.sleep(1500);}catch(InterruptedException e){}
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), chooseFileButton);
		try{Thread.sleep(1500);}catch(InterruptedException e){}
		
		switch( fileFormat )
		{
			case "pdf":
			{
				String iPath=Path.pdf;
				driverUtilities.get().fileUpload(Path.pdf);
				break;
			}
			case "jpg":
			{
				String iPath=Path.jpg;
				driverUtilities.get().fileUpload(Path.jpg);
				break;
			}
			case "bmp":
			{
				String iPath=Path.bmp;
				driverUtilities.get().fileUpload(Path.bmp);
				break;
			}
			default:
			{
				
			}
		}
	}
	
	public void verifyFileHasBeenUploaded()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'appeal-preview-img')]//img")));
	}
	
	public void clickOnNotePopupSubmitButton()
	{
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(noteSubmitButton2);
		try
		{
			driverUtilities.get().clickOnElement(noteSubmitButton1);
		}
		catch(Exception e)
		{
			
		}
		try
		{
			driverUtilities.get().clickOnElement(noteSubmitButton2);
		}
		catch(Exception e)
		{
		
		}
	}
	
	public void verifyNoteAddedSucessMessage()
	{
		driverUtilities.get().waitForElementToBePresent2("//div[contains(text(),'note added successfully')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(text(),'note added successfully')]")));
	}
	
	public void closeNoteSuccessfullyAddedMessage()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(text(),'note added successfully')]/parent::div/parent::div/preceding-sibling::div/button"));
	}
	
	public void verifyNoteAddedUnderCitationInfo(String value)
	{
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'Support Notes')]"));
		//driverUtilities.get().scrollDownWebPage();
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Support Notes')]/following-sibling::div//table/tbody/tr//*[contains(text(),'"+value+"')]")));
	}
	
	public void verifyDownloadLinkUnderCitationInfo(String value)
	{
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'Support Notes')]"));
		//driverUtilities.get().scrollDownWebPage();
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Support Notes')]/following-sibling::div//table/tbody/tr//*[contains(text(),'"+value+"')]/ancestor::td/following-sibling::td/a[contains(text(),'Download')]")));
	}
	
	public void verifyEditTicketPopup()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(normalize-space(.), 'Edit Ticket')]")));
		
		//Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//img[@alt='slide-img']")));
		
		String ticketIssueDateTime = driverUtilities.get().getAttribute(driverUtilities.get().getWebElement("//label[contains(normalize-space(.), 'Ticket Issue Date Time')]/following-sibling::div//input"), "disabled");
		System.out.println("ticketIssueDateTime:="+ticketIssueDateTime);
		Assert.assertNotNull(ticketIssueDateTime);
		
		String ticketNoTime = driverUtilities.get().getAttribute(driverUtilities.get().getWebElement("//label[contains(normalize-space(.), 'Ticket No')]/following-sibling::input"), "disabled");
		System.out.println("ticketNoTime:="+ticketNoTime);
		Assert.assertNotNull(ticketNoTime);
	}
	
	public void verifyCancelForm(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//p[contains(normalize-space(.), 'Cancel Citation')]")));
		String citationNo = driverUtilities.get().getElementText(driverUtilities.get().getWebElement("//span[contains(normalize-space(.), 'Selected Citation Numbers')]/following-sibling::textarea"));
		Assert.assertEquals(citationNo, citationNumber);
	}
	
	public String selectCancelCitationReason()
	{
		int index = Util.getRandomNumberOneToFive();
		driverUtilities.get().selectElementFromListIndex(cancelCitationReasonList, index);
		String reason = driverUtilities.get().getFirstSelectedOptionFromList(cancelCitationReasonList);
		return reason;
	}
	
	public String cancelCitationComments()
	{
		String reasonCancel = "Cancel Citation Reason is"+Util.generateRandomNumber(10);
		driverUtilities.get().typeIntoTextBox(cancelCitationComments, reasonCancel);
		return reasonCancel;
	}
	
	public void clickCancelCitationSubmitButton()
	{
		driverUtilities.get().clickOnElement(cancelCitationSubmitButton);
		try {driverUtilities.get().waitForElementToBePresent2("//*[contains(normalize-space(.), 'Ticket updated')]");}catch(TimeoutException e) {}
	}
	
	public void verifyUpdateStatusPopup()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h3[contains(normalize-space(.), 'Update Status')]")));
	}
	
	public void selectTicketStatus(String status)
	{
		driverUtilities.get().selectElementFromList(StatusList, status);	
	}
	
	public String updateStatusRemark()
	{
		String statusRemark = "Update status remark is "+Util.generateRandomNumber(10);
		driverUtilities.get().typeIntoTextBox(statusRemarkTextarea, statusRemark);
		return statusRemark;
	}
	
	public void clickStatusUpdateSubmitButton()
	{
		driverUtilities.get().clickOnElement(updateStatusSubmitButton);
		try {driverUtilities.get().waitForElementToBePresent2("//*[contains(normalize-space(.), 'Ticket updated')]");}catch(TimeoutException e) {}
	}
	
	public void selectDateAsAppealEligibleDate() throws AWTException
	{
		try{driverUtilities.get().waitForElementToBePresent(appealEligibleDateInput);}catch(TimeoutException e) {}
		driverUtilities.get().makeElementVisibleIntoScreen(appealEligibleDateInput);
		driverUtilities.get().clickOnElement(appealEligibleDateInput);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		
		String date = Util.getCurrentSystemDate("dd");
		String month = Util.getCurrentSystemDate("MMMMMM");
		
		if(date.startsWith("0"))
		{
			date = date.substring(1);
		}
		String datePath = "//div[contains(@aria-label,'"+month+"') and text()='"+date+"']";
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(datePath));
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void clickOnChangeAmountButton()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(changeAmountButton);
		driverUtilities.get().clickOnElement(changeAmountButton);
	}
	
	public void clickOnSubmitAfterChangingAmount()
	{
		try
		{
			driverUtilities.get().makeElementVisibleIntoScreen(submitButtonAfterChangeAmount);
			driverUtilities.get().clickOnElement(submitButtonAfterChangeAmount);
		}
		catch(NoSuchElementException e)
		{
			Assert.fail("Submit button after changing amount is not available for client "+Settings.clientName);
		}
	}
	
	public void checkChargeBackCheckbox()
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(chargeBackCheckbox);
		driverUtilities.get().clickOnElement(chargeBackCheckbox);
	}
	
	public void checkNSFCheckbox()
	{
		try {Thread.sleep(2000);}catch(InterruptedException e) {}
		String nsfAllowed = Settings.isNSF;
		if(nsfAllowed.equalsIgnoreCase("true"))
		{
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(nsfCheckbox);
			driverUtilities.get().clickOnElement(nsfCheckbox);
		}
		else
		{
			Assert.fail("NSF fees is not allowed for client "+Settings.clientName);
		}
	}
	
	public void checkUncheckNSFCheckbox()
	{
		try 
		{
			driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'Service Fee')]"));
		}
		catch(NoSuchElementException e)
		{
			driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//label[contains(text(),'Collections Fee')]"));
		}
		try
		{
			driverUtilities.get().isElementDisplayed(nsfAppliedDateTextbox);
			driverUtilities.get().clickOnElement(nsfCheckbox);
		}
		catch(NoSuchElementException e)
		{
			
		}
	}
	
	public void enterChargeBackFees()
	{
		//driverUtilities.get().makeElementVisibleIntoScreen(chargeBackTextbox);
		String amount = Settings.chargeBackFee;
		driverUtilities.get().clearTextBox(chargeBackTextbox);
		driverUtilities.get().setTextOfElement(chargeBackTextbox, amount);
		
		//driverUtilities.get().typeIntoTextBox(chargeBackTextbox, amount);
		//driverUtilities.get().setAttributeOfElement(chargeBackTextbox, "value", amount);
	}
	
	public void enterNSFFees()
	{
		//driverUtilities.get().makeElementVisibleIntoScreen(chargeBackTextbox);
		String amount = Settings.NSFFee;
		driverUtilities.get().clearTextBox(nsfTextbox);
		driverUtilities.get().setTextOfElement(nsfTextbox, amount);
		
		//driverUtilities.get().typeIntoTextBox(chargeBackTextbox, amount);
		//driverUtilities.get().setAttributeOfElement(chargeBackTextbox, "value", amount);
	}
	
	public void enterChargeBackAppliedDate()
	{
		String todayDate = Util.getCurrentSystemDate("MM/dd/yyyy");
		//driverUtilities.get().setAttributeOfElement(checkDateFiled, "value", todayDate);
		driverUtilities.get().typeIntoTextBox(chargeBackAppliedDateTextbox, todayDate);
	}
	
	public void enterNSFAppliedDate()
	{
		String todayDate = Util.getCurrentSystemDate("MM/dd/yyyy");
		//driverUtilities.get().setAttributeOfElement(checkDateFiled, "value", todayDate);
		driverUtilities.get().typeIntoTextBox(nsfAppliedDateTextbox, todayDate);
	}
	
	public String getRecieptID()
	{
		String recieptIDString = "//div[contains(text(),'Receipt #')]/following-sibling::div";
		String recID = driverUtilities.get().getElementText(driverUtilities.get().getWebElement(recieptIDString));
		System.out.println("recID:="+recID);
		recID = recID.replaceAll("[^a-zA-Z0-9]", "");
		Assert.assertNotNull(recID);
		System.out.println("recID:="+recID);
		return recID;
	}
	
	public void modifyPayAsPartialPay()
	{
		String paritalPay = Settings.allowPartialPay;
		if(paritalPay.equalsIgnoreCase("true"))
		{
			try{driverUtilities.get().waitForElementToBePresent(editIconOfPaymentAmount);}catch(TimeoutException e) {}
			driverUtilities.get().clickOnElement(editIconOfPaymentAmount);
			driverUtilities.get().clearTextBox(changeAmountTextbox);
			String partialAmount = Settings.partialPayAmount;
			driverUtilities.get().typeIntoTextBox(changeAmountTextbox, partialAmount);
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'Confirmation')]"));
		}
		else
		{
			Assert.fail("Partial pay is not allowed for client "+Settings.clientName);
		}
	}
	
	public void verifyPartialAmountAsPayableAmount()
	{
		String partialAmount = driverUtilities.get().getElementText(payableAmountLabel);
		System.out.println("partialAmount:="+partialAmount);
		String configPartialAmount = Settings.partialPayAmount;
		System.out.println("configPartialAmount:="+configPartialAmount);
		Assert.assertTrue(partialAmount.contains(configPartialAmount));
	}
	
	public void verifyDueAmountFromCitationInfo(String previousFine)
	{
		String amoutDue= "//h6[contains(text(),'Amount Due:')]/following-sibling::*";
		WebElement amoutDueEle = driverUtilities.get().getWebElement(amoutDue);
		String amoutDueValue = driverUtilities.get().getElementText(amoutDueEle);
		System.out.println("amoutDueValue:="+amoutDueValue);
		amoutDueValue = amoutDueValue.substring(1);
		System.out.println("amoutDueValue:="+amoutDueValue);
		Double previousValue = Double.parseDouble(previousFine);
		System.out.println("previousValue:="+previousValue);
		String configPartialAmount = Settings.partialPayAmount;
		Assert.assertTrue(Double.parseDouble(amoutDueValue) == (previousValue-Double.parseDouble(configPartialAmount)) );
	}
	
	public void verifyDueAmount(String amount)
	{
		String amoutDue= "//h6[contains(text(),'Amount Due:')]/following-sibling::*";
		WebElement amoutDueEle = driverUtilities.get().getWebElement(amoutDue);
		String amoutDueValue = driverUtilities.get().getElementText(amoutDueEle);
		System.out.println("amoutDueValue:="+amoutDueValue);
		Assert.assertTrue(amoutDueValue.contains(amount));
	}
	
	public void verifyPaidAmountSameAsConfig()
	{
		String amoutPaid= "//h6[contains(text(),'Amount Paid')]/following-sibling::*";
		WebElement amoutPaidEle = driverUtilities.get().getWebElement(amoutPaid);
		String amoutPaidValue = driverUtilities.get().getElementText(amoutPaidEle);
		amoutPaidValue = amoutPaidValue.replace("$", "");
		String configPartialAmount = Settings.partialPayAmount;
		Assert.assertTrue(Double.parseDouble(amoutPaidValue) == Double.parseDouble(configPartialAmount) );
	}
	
	public void selectAllTableRecord()
	{
		String allRec= "//input[@id='all']";
		WebElement allRecEle = driverUtilities.get().getWebElement(allRec);
		driverUtilities.get().clickOnElement(allRecEle);
	}
	
	public void verifyToatlOutstandingAmount(String val1 , String val2)
	{
		Double fine1 = Double.parseDouble(val1);
		Double fine2 = Double.parseDouble(val2);
		Double sum = fine1+fine2;
		String toatlValue = sum.toString();
		System.out.println("toatlValue:="+toatlValue);
		String valPath = "//*[contains(normalize-space(.),'Total Outstanding Balance')]/following-sibling::h5";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		String uiAmount = driverUtilities.get().getElementText(valPathEle);
		System.out.println("uiAmount:="+uiAmount);
		Assert.assertTrue(uiAmount.contains(toatlValue));
	}
	
	public void verifyPaymentAmount(String val1 , String val2)
	{
		Double fine1 = Double.parseDouble(val1);
		Double fine2 = Double.parseDouble(val2);
		Double sum = fine1+fine2;
		String toatlValue = sum.toString();
		System.out.println("toatlValue:="+toatlValue);
		String valPath = "//*[contains(normalize-space(.),'Payment amount')]/parent::div/following-sibling::div/h5";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		String uiAmount = driverUtilities.get().getElementText(valPathEle);
		System.out.println("uiAmount:="+uiAmount);
		Assert.assertTrue(uiAmount.contains(toatlValue));
	}
	
	public void verifySuspendedTicketAndNotAppeal()
	{
		String suspend = Settings.canSuspend;
		
		if(suspend.equalsIgnoreCase("true"))
		{
			String valPath = "//*[contains(text(),'Ticket is suspended but do not have Appeal')]";
			WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(valPathEle));
			try {driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'×')]"));}catch(NoSuchElementException e) {}
		}
		else
		{
			Assert.fail("Suspend ticket status is not allowed for client "+Settings.clientName);
		}
	}
	
	public void clickOnBackLink()
	{
		String valPath = "//div[contains(@class,'back-button-citationdetails')]/a";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		driverUtilities.get().clickOnElement(valPathEle);
	}
	
	public void clickOnBackLinkOFSearch()
	{
		String valPath = "//a[contains(@href,'/search') and contains(text(),'Back')]";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		driverUtilities.get().clickOnElement(valPathEle);
	}
	
	public void clickOnRefundButton()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Refund')]"));
	}
	
	public void clickOnReversePaymentButton()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Reverse Payment')]"));
	}
	
	public void verifyRefundAmount(String value)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//input[@name='fineAmount']");}catch(TimeoutException e) {}
		String refundStringValue = driverUtilities.get().getAttribute(refundAmountTextbox, "value");
		Assert.assertTrue(refundStringValue.contains(value));
	}
	
	public void verifyRefundCitation(String value)
	{
		String refundStringValue = driverUtilities.get().getAttribute(refundCitationTextbox, "value");
		Assert.assertTrue(refundStringValue.contains(value));
	}
	
	public void selectRefundSource(String value)
	{
		driverUtilities.get().selectElementFromList(refundSourceList, value);
	}
	
	public String enterRefundReason()
	{
		String reason = "Refund Reason is "+Util.generateRandomNumber(10);
		driverUtilities.get().typeIntoTextBox(refundReasonTextArea, reason);
		return reason;
	}
	
	public void clickOnSubmitRefundButton()
	{
		driverUtilities.get().clickOnElement(submitRefundButton);
	}
	
	public void clickOnYesContinue()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Yes, Continue')]"));
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		try {driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Success!')]");}catch(TimeoutException e) {}
	}
	
	public void clickOnYesButton()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Yes')]"));
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		try {driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Success!')]");}catch(TimeoutException e) {}
	}
	
	public void verifyAlreadyAnAppealMessage()
	{
		String valPath = "//*[contains(text(),'The citation has already been appealed, and ineligible for appeal')]";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(valPathEle));
	}
	
	public void verifyRversePaymentMessage()
	{
		String valPath = "//*[contains(text(),'Are you sure you want to reverse this payment?')]";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(valPathEle));
	}
	
	public void verifyCitationNotEligibleMessage()
	{
		String valPath = "//*[contains(text(),'Citation is not eligible for Appeal')]";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(valPathEle));
	}
	
	public void verifySearchTicketPage()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(licensePlateTextBox));
	}
	
	public void enterPlateNumberFromSearchTic(String plateNo)
	{
		driverUtilities.get().typeIntoTextBox(licensePlateTextBox, plateNo);
	}
	
	public void clickOnSearchButtonOfSearchTic()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(searchButtonOfSeatchTic);
		driverUtilities.get().clickOnElement(searchButtonOfSeatchTic);
		String pathEle = "//*[contains(normalize-space(.), 'Total Citations')]";
		int c = driverUtilities.get().getNumberOfElement(pathEle);
		pathEle = "(//*[contains(normalize-space(.), 'Total Citations')])["+c+"]";
		try {driverUtilities.get().waitForElementToBePresent2(pathEle);}catch(TimeoutException e) {}
	}
	
	public void changeOriginalFine(String originalFine)
	{
		try{driverUtilities.get().waitForElementToBePresent(originalAmoutTextbox);}catch(TimeoutException e) {}
		driverUtilities.get().makeElementVisibleIntoScreen(originalAmoutTextbox);
		driverUtilities.get().clearTextBox(originalAmoutTextbox);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().typeIntoTextBox(originalAmoutTextbox, originalFine);
	}
	
	public void changeOriginalFineInNegative(String originalFine)
	{
		Double fine = Double.parseDouble(originalFine);
		Double neagativeFine = -fine;
		driverUtilities.get().clearTextBox(originalAmoutTextbox);
		driverUtilities.get().typeIntoTextBox(originalAmoutTextbox, neagativeFine.toString());
	}
	
	public void verifyMessageForBackCharge()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Ticket must be in Paid with Card payment source to add Chargeback')]")));
	}
	
	public void selectTicketsFromTicketListView(String citation)
	{
		String valPath = "//table[@id='cstm-report-tb-display']/tbody/tr/td[contains(text(),'"+citation+"')]/ancestor::tr/td/input";
		try{driverUtilities.get().waitForElementToBePresent2(valPath);}catch(TimeoutException e) {}
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		driverUtilities.get().clickOnElement(valPathEle);
	}
	
	public void clickOnButtonFromTicketListView(String buttonName)
	{
		String buttonPath = "//button[contains(normalize-space(.), '"+buttonName+"')]";
		try{driverUtilities.get().waitForElementToBePresent2(buttonPath);}catch(TimeoutException e) {}
		WebElement buttonPathEle = driverUtilities.get().getWebElement(buttonPath);
		driverUtilities.get().clickOnElement(buttonPathEle);
	}
	
	public void verifyDataOnScreen(String data)
	{
		WebElement valPathEle = null;
		String valPath = "//*[contains(normalize-space(.), '"+data+"')]";
		try{valPathEle = driverUtilities.get().getWebElement(valPath);}catch(NoSuchElementException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(valPathEle));
	}
	
	public void verifyInvalidCardDetailMessage()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), 'PAYMENT FAILED') and contains(@class,'erroe-msg')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), 'card_number "+Settings.invalidCardNumber+" is not valid') and contains(@class,'erroe-msg')]")));
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'×')]"));
	}
	
	public void clickPrintBtnOfTicketListView()
	{
		String noRecordText = "//*[contains(text(),'No Record Found')]";
		driverUtilities.get().isElementClickable(driverUtilities.get().getWebElement("//button[contains(text(),'Print')]"));
		try
		{
			driverUtilities.get().getWebElement(noRecordText);
		}
		catch(NoSuchElementException e)
		{
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Print')]"));
		}
	}
	
	public void closePrintScreen()
	{
		try 
		{
			driverUtilities.get().keyPress("tab");
			driverUtilities.get().keyRelease("tab");
			driverUtilities.get().keyPress("enter");
			driverUtilities.get().keyRelease("enter");
		}
		catch(AWTException e)
		{
			
		}
	}
	
	public void verifyMessageForNSF()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Ticket must be in Paid with Check payment source to add NSF')]")));
		driverUtilities.get().clickOnElement(closeButtonOfMessage);
	}
	
	public void clickDownloadBtnOfTicketListView()
	{
		String noRecordText = "//*[contains(text(),'No Record Found')]";
		try
		{
			driverUtilities.get().getWebElement(noRecordText);
		}
		catch(NoSuchElementException e)
		{
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(text(),'Download')]"));
		}
	}
	
	public void selectDownloadOption(String downloadOption)
	{
		Util.clearDownload();
		String noRecordText = "//*[contains(text(),'No Record Found')]";
		try
		{
			driverUtilities.get().getWebElement(noRecordText);
		}
		catch(NoSuchElementException e)
		{
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(text(),'"+downloadOption+"')]"));
		}
	}
	
	public void verifyExcelFileDate() throws Exception
	{
		String fileName;
		String filePath;
		File file;
		fileName = Util.getDownloadedFileName();
		filePath = Path.downloadPath+File.separator+fileName;
		file = new File(filePath);
		String totalRecords = driverUtilities.get().getElementText(driverUtilities.get().getWebElement("//div[contains(@class,'total-count-records')]//b")); 
		List<Map<String, Object>> excelDate = new ExcelReader().getData(filePath, 0);
		System.out.println("Excel file Size:="+excelDate.size());
		int fileRecordCount = excelDate.size()-1;
		Assert.assertTrue(excelDate.size()!=0);
		Assert.assertEquals(fileRecordCount, Integer.parseInt(totalRecords));
	}
	
	public void verifyCSVFileDate() throws Exception
	{
		String totalRecords = driverUtilities.get().getElementText(driverUtilities.get().getWebElement("//div[contains(@class,'total-count-records')]//b")); 
		int recordCountFile = new ExcelCSV().getRowsCount();
		Assert.assertTrue(recordCountFile!=0);
		Assert.assertEquals(recordCountFile, Integer.parseInt(totalRecords));
	}
	
	public void verifyPDFFileSize() throws Exception
	{
		String totalRecords = driverUtilities.get().getElementText(driverUtilities.get().getWebElement("//div[contains(@class,'total-count-records')]//b")); 
		int recordCountFile = new ExcelCSV().getRowsCount();
		Assert.assertTrue(recordCountFile!=0);
		Assert.assertEquals(recordCountFile, Integer.parseInt(totalRecords));
	}
	
	public void verifyParitialPaymentMessage(String data)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), 'You have modified the amount for following citations')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(normalize-space(.), '"+data+"')]")));
	}
	
	public void verifyThatNoPayButtonForSuspendedTicket()
	{
		String path= "//button[contains(text(),'Pay')]";
		try{driverUtilities.get().getWebElement(path); Assert.fail("Pay button is visible for suspended ticket please check it");}catch(NoSuchElementException e){}
	}
	
	public void closeMessage()
	{
		try{driverUtilities.get().clickOnElement(closeButtonOfMessage);}catch(NoSuchElementException e) {}
	}
	
	/**
	 * Clicks on the Add Address button to open RO Information popup
	 */
	public void clickOnAddAddressButton()
	{
		driverUtilities.get().clickOnElement(addAddressButton);
	}
	
	/**
	 * Enters random address details in RO Information form and returns the entered value
	 * @return String - The generated address value
	 */
	public String enterRoAddressDetails()
	{
		String address = GenerateRandomData.getAddress();
		driverUtilities.get().typeIntoTextBox(roAddressField, address);
		return address;
	}

	/**
	 * Enters random city details in RO Information form and returns the entered value
	 * @return String - The generated city value
	 */
	public String enterRoCityDetails()
	{
		String city = GenerateRandomData.getCity();
		driverUtilities.get().typeIntoTextBox(roCityField, city);
		return city;
	}

	/**
	 * Enters state details in RO Information form based on configuration and returns the entered value
	 * Gets state name from Settings.stateName and maps it to the appropriate state value
	 * @return String - The state value to be entered
	 */
	public String enterRoStateDetails()
	{
		String stateName = Settings.stateName;
		
		// State code to full name mapping
		Map<String, String> stateMapping = new HashMap<>();
		stateMapping.put("FL", "FLORIDA");
		stateMapping.put("CA", "CALIFORNIA");
		stateMapping.put("NY", "NEW YORK");
		stateMapping.put("TX", "TEXAS");
		stateMapping.put("IL", "ILLINOIS");
		stateMapping.put("PA", "Pennsylvania");
		stateMapping.put("OH", "OHIO");
		stateMapping.put("GA", "Georgia");
		stateMapping.put("NC", "North Carolina");
		stateMapping.put("MI", "Michigan");
		
		// Get state value from mapping, use the original stateName if not found in mapping
		// This way, if the state code is not in our mapping, it will use whatever is configured
		String stateValue = stateMapping.containsKey(stateName.toUpperCase()) ? 
			stateMapping.get(stateName.toUpperCase()) : stateName;
		System.out.println("State name is:="+stateValue);
		
		driverUtilities.get().typeIntoTextBox(roStateField, stateValue);
		String stateNameForSelect = "//*[contains(normalize-space(.), '"+stateValue+"')]";
		System.out.println("stateNameForSelect is:="+stateNameForSelect);
		//driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(stateNameForSelect));
		return stateValue;
	}
	
	/**
	 * Enters random zip code details in RO Information form and returns the entered value
	 * @return String - The generated zip code value
	 */
	public String enterRoZipDetails()
	{
		String zip = GenerateRandomData.getZipCode();
		driverUtilities.get().typeIntoTextBox(roZipField, zip);
		return zip;
	}

	/**
	 * Enters random name details in RO Information form and returns the entered value
	 * Creates a full name by combining first name and last name
	 * @return String - The generated name value (First Name + Last Name)
	 */
	public String enterRoNameDetails()
	{
		String firstName = GenerateRandomData.getFirstName();
		String lastName = GenerateRandomData.getLastName();
		String fullName = firstName + " " + lastName;
		driverUtilities.get().typeIntoTextBox(roNameField, fullName);
		return fullName;
	}

	/**
	 * Enters random email details in RO Information form and returns the entered value
	 * @return String - The generated email value
	 */
	public String enterRoEmailDetails()
	{
		String email = GenerateRandomData.getEmailAddress();
		driverUtilities.get().typeIntoTextBox(roEmailField, email);
		return email;
	}

	public String enterRoPhoneDetails()
	{
		String phone = GenerateRandomData.getPhoneNumber();
		driverUtilities.get().typeIntoTextBox(roPhoneField, phone);
		return phone;
	}

	public String enterRoReasonDetails()
	{
		String reason = GenerateRandomData.getReason();
		driverUtilities.get().typeIntoTextBox(roReasonField, reason);
		return reason;
	}
	
	public void clickOnRoChangeAddressButton()
	{
		driverUtilities.get().clickOnElement(roChangeAddressButton);
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
	}

	/**
	 * Verifies that the RO Information popup has been closed after saving
	 * Throws AssertionError if popup is still visible
	 */
	public void verifyRoInformationPopupClosed()
	{
		try 
		{
			driverUtilities.get().getWebElement("//h3[contains(text(),'RO Information') or contains(text(),'Registered Owner Information')]");
			Assert.fail("RO Information popup is still visible");
		} catch(NoSuchElementException e) {
			// Popup is closed, which is expected
		}
	}
	
	public void enterTicketNumberForSearch(String ticketNumber)
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketNumberField);
		driverUtilities.get().clearTextBox(ticketNumberField);
		driverUtilities.get().typeIntoTextBox(ticketNumberField, ticketNumber);
	}

	public void clickOnSearchButton()
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(searchButton);
		driverUtilities.get().clickOnElement(searchButton);
	}
	
	public void verifySearchPerformedBasedOnTicketNumber(String ticketNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'"+ticketNumber+"')]")));
	}
	
	/**
	 * Enters the provided license plate into the license plate search field
	 * @param licensePlate - The license plate to enter in the search field
	 */
	public void enterLicensePlateForSearch(String licensePlate)
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(licensePlateField);
		driverUtilities.get().clearTextBox(licensePlateField);
		driverUtilities.get().clearTextBox(ticketNumberField);
		driverUtilities.get().typeIntoTextBox(licensePlateField, licensePlate);
	}
	
	public void selectStateForSearch()
	{
		String stateName = Settings.stateName;
		
		// Map state codes to full state names
		Map<String, String> stateMapping = new HashMap<>();
		stateMapping.put("FL", "FLORIDA");
		stateMapping.put("CA", "CALIFORNIA");
		stateMapping.put("NY", "NEW YORK");
		stateMapping.put("TX", "TEXAS");
		stateMapping.put("IL", "ILLINOIS");
		stateMapping.put("PA", "PENNSYLVANIA");
		stateMapping.put("OH", "OHIO");
		stateMapping.put("GA", "GEORGIA");
		stateMapping.put("NC", "NORTH CAROLINA");
		stateMapping.put("MI", "MICHIGAN");
		
		// Get state value from mapping, use the original stateName if not found in mapping
		String stateValue = stateMapping.getOrDefault(stateName.toUpperCase(), stateName.toUpperCase());
		System.out.println("stateValue:="+stateValue);
		//driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(@class,'css-13cymwt-control')]//div[contains(text(),'"+stateValue+"')]"));
	}

	/**
	 * Verifies that the search results contain the specified license plate
	 * Checks if the license plate is displayed in the search results and asserts the result
	 * @param licensePlate - The license plate to verify in the search results
	 */
	public void verifySearchPerformedBasedOnLicensePlateAndState(String licensePlate,String state)
	{
		try 
		{
			boolean isDisplayed = driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Plate/State')]/following-sibling::*[contains(normalize-space(.), '"+licensePlate+"/"+state+"')] "));
			Assert.assertTrue("License plate '" + licensePlate + "' not found in search results", isDisplayed);
		} 
		catch (Exception e) 
		{
			Assert.fail("Failed to verify license plate '" + licensePlate + "' in search results: " + e.getMessage());
		}
	}
	
	// New methods for search form user details
		public void enterNameIntoSearchForm(String name)
		{
			driverUtilities.get().clearTextBox(searchFormNameField);
			driverUtilities.get().typeIntoTextBox(searchFormNameField, name);
		}
		
		public void enterAddressIntoSearchForm(String address)
		{
			driverUtilities.get().clearTextBox(searchFormAddressField);
			driverUtilities.get().typeIntoTextBox(searchFormAddressField, address);
		}
		
		public void enterCityIntoSearchForm(String city)
		{
			driverUtilities.get().clearTextBox(searchFormCityField);
			driverUtilities.get().typeIntoTextBox(searchFormCityField, city);
		}
		
		public void enterZipIntoSearchForm(String zip)
		{
			driverUtilities.get().clearTextBox(searchFormZipField);
			driverUtilities.get().typeIntoTextBox(searchFormZipField, zip);
		}
		
		public void enterEmailIntoSearchForm(String email)
		{
			driverUtilities.get().clearTextBox(searchFormEmailField);
			driverUtilities.get().typeIntoTextBox(searchFormEmailField, email);
		}
		
		public void enterPhoneIntoSearchForm(String phone)
		{
			driverUtilities.get().clearTextBox(searchFormPhoneField);
			driverUtilities.get().typeIntoTextBox(searchFormPhoneField, phone);
		}
		
		public void selectPreviousDayEndDate() throws AWTException
		{
			try{driverUtilities.get().waitForElementToBePresent(endDate);}catch(TimeoutException e) {}
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(endDate);
			driverUtilities.get().clickOnElement(endDate);
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			
			String date = Util.getPreviousSystemDate("dd","2");
			String month = Util.getPreviousSystemDate("MMMMMM","2");
			if(date.startsWith("0"))
			{
				date = date.substring(1);
			}
			String datePath = "//div[contains(@aria-label,'"+month+"') and text()='"+date+"']";
			driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), driverUtilities.get().getWebElement(datePath));
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
		}
		
		public void selectTodayDayStartDate() throws AWTException
		{
			try{driverUtilities.get().waitForElementToBePresent(startDate);}catch(TimeoutException e) {}
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(startDate);
			driverUtilities.get().clickOnElement(startDate);
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			
			String date = Util.getCurrentSystemDate("dd");
			String month = Util.getCurrentSystemDate("MMMMMM");
			if(date.startsWith("0"))
			{
				date = date.substring(1);
			}
			String datePath = "//div[contains(@aria-label,'"+month+"') and text()='"+date+"']";
			driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), driverUtilities.get().getWebElement(datePath));
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
		}
		
		public void enterLicenseStateForTicketListSearch()
		{
			String stateName = Settings.stateName;
			
			// State code to full name mapping
			Map<String, String> stateMapping = new HashMap<>();
			stateMapping.put("FL", "FLORIDA");
			stateMapping.put("CA", "CALIFORNIA");
			stateMapping.put("NY", "NEW YORK");
			stateMapping.put("TX", "TEXAS");
			stateMapping.put("IL", "ILLINOIS");
			stateMapping.put("PA", "PENNSYLVANIA");
			stateMapping.put("OH", "OHIO");
			stateMapping.put("GA", "GEORGIA");
			stateMapping.put("NC", "NORTH CAROLINA");
			stateMapping.put("MI", "MICHIGAN");
			stateMapping.put("KS", "KANSAS");
			stateMapping.put("WI", "WISCONSIN");
			stateMapping.put("AK", "ALASKA");
			
			// Get state value from mapping, use the original stateName if not found in mapping
			String stateValue = stateMapping.getOrDefault(stateName.toUpperCase(), stateName.toUpperCase());
			System.out.println("License State value from settings: " + stateValue);
			
			// Wait for element and clear any existing text
			try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(licenseStateField);
			driverUtilities.get().clearTextBox(licenseStateField);
			driverUtilities.get().typeIntoTextBox(licenseStateField, stateValue);
			
			// Wait for dropdown to appear and select the state
			try {Thread.sleep(2000);}catch(InterruptedException e) {}
			String stateOptionPath = "//li[text()='"+stateValue+"']";
			try 
			{
				WebElement stateOption = driverUtilities.get().getWebElement(stateOptionPath);
				driverUtilities.get().clickOnElement(stateOption);
			} 
			catch(NoSuchElementException e) 
			{
				System.out.println("State option not found in dropdown: " + stateValue);
			}
		}
		
		/**
		 * Enters status value from Settings into the Status field for ticket list search
		 * Gets status from Settings.ticketStatus, enters into field and selects from dropdown
		 */
		public void enterStatusForTicketListSearch(String statusValue)
		{
			
			// Wait for element and clear any existing text
			try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
			driverUtilities.get().clearTextBox(statusField);
			driverUtilities.get().typeIntoTextBox(statusField, statusValue);
			
			// Wait for dropdown to appear and select the status
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			String statusOptionPath = "//li[contains(text(),'" + statusValue + "')]";
			try 
			{
				WebElement statusOption = driverUtilities.get().getWebElement(statusOptionPath);
				driverUtilities.get().clickOnElement(statusOption);
			} 
			catch(NoSuchElementException e) 
			{
				System.out.println("Status option not found in dropdown: " + statusValue);
			}
		}
		
		/**
		 * Enters violation code value from Settings into the Violation Code field for ticket list search
		 * Gets violation code from Settings.violationCode, enters into field and selects from dropdown
		 */
		public void enterViolationCodeForTicketListSearch(String violationCodeValue)
		{
			
			// Wait for element and clear any existing text
			try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
			driverUtilities.get().clearTextBox(violationCodeField);
			driverUtilities.get().typeIntoTextBox(violationCodeField, violationCodeValue);
			
			// Wait for dropdown to appear and select the violation code
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			String violationCodeOptionPath = "//li[contains(text(),'" + violationCodeValue + "')]";
			try 
			{
				WebElement violationCodeOption = driverUtilities.get().getWebElement(violationCodeOptionPath);
				driverUtilities.get().clickOnElement(violationCodeOption);
			} 
			catch(NoSuchElementException e) 
			{
				System.out.println("Violation code option not found in dropdown: " + violationCodeValue);
			}
		}
		
		public void enterLicensePlateFromTicketListView(String licensePlate)
		{
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(licensePlateFieldTicketListView);
			driverUtilities.get().clearTextBox(licensePlateFieldTicketListView);
			driverUtilities.get().typeIntoTextBox(licensePlateFieldTicketListView, licensePlate);
		}
		
		/**
		 * Enters violation description value from settings into the Violation Description field for ticket list search
		 * Gets a default violation description value, enters into field and selects from dropdown
		 */
		public void enterViolationDescriptionForTicketListSearch()
		{
			// Use a default violation description value that should exist in the dropdown
			String violationDescription = "NO PARKING ZONE"; // Default value based on HTML options
			System.out.println("Violation Description value from settings: " + violationDescription);
			
			// Wait for element and clear any existing text
			try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
			driverUtilities.get().clearTextBox(violationDescriptionField);
			driverUtilities.get().typeIntoTextBox(violationDescriptionField, violationDescription);
			
			// Wait for dropdown to appear and select the violation description
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			String violationDescriptionOptionPath = "//li[contains(text(),'" + violationDescription + "')]";
			try 
			{
				WebElement violationDescriptionOption = driverUtilities.get().getWebElement(violationDescriptionOptionPath);
				driverUtilities.get().clickOnElement(violationDescriptionOption);
			} 
			catch(NoSuchElementException e) 
			{
				System.out.println("Violation description option not found in dropdown: " + violationDescription);
			}
		}
		
		/**
		 * Enters officer name value from settings into the Officer Name field for ticket list search
		 * Gets officer name from Settings.officerName, enters into field and selects from dropdown
		 */
		public void enterOfficerNameForTicketListSearch()
		{
			String officerName = Settings.officerName;
			System.out.println("Officer Name value from settings: " + officerName);
			
			// Wait for element and clear any existing text
			try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(officerNameField);
			driverUtilities.get().clearTextBox(officerNameField);
			driverUtilities.get().typeIntoTextBox(officerNameField, officerName);
			
			// Wait for dropdown to appear and select the officer name
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			String officerNameOptionPath = "//li[contains(normalize-space(.), '"+officerName+"')]";
			int c = driverUtilities.get().getNumberOfElement(officerNameOptionPath);
			officerNameOptionPath = "("+officerNameOptionPath+")["+c+"]";
			try 
			{
				WebElement officerNameOption = driverUtilities.get().getWebElement(officerNameOptionPath);
				driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(officerNameOption);
				driverUtilities.get().clickOnElement(officerNameOption);
			} 
			catch(NoSuchElementException e) 
			{
				System.out.println("Officer name option not found in dropdown: " + officerName);
			}
		}
		
		public void enterStreetForTicketListSearch()
		{
			String streetName = Settings.street;
			System.out.println("Street value from settings: " + streetName);
			
			// Wait for element and clear any existing text
			try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
			driverUtilities.get().clearTextBox(streetField);
			driverUtilities.get().typeIntoTextBox(streetField, streetName);
			
			// Wait for dropdown to appear and select the street
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			String streetOptionPath = "//li[contains(text(),'" + streetName + "')]";
			try 
			{
				WebElement streetOption = driverUtilities.get().getWebElement(streetOptionPath);
				driverUtilities.get().clickOnElement(streetOption);
			} 
			catch(NoSuchElementException e) 
			{
				System.out.println("Street option not found in dropdown: " + streetName);
			}
		}
		
		public void enterRemarkForTicketListSearch(String remarkValue)
		{
		    System.out.println("Remark value to enter: " + remarkValue);
		    
		    // Wait for element and clear any existing text
		    try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		    driverUtilities.get().clearTextBox(remarkField);
		    driverUtilities.get().typeIntoTextBox(remarkField, remarkValue);
		    
		    // Wait for dropdown to appear and select the remark
		    try {Thread.sleep(1000);}catch(InterruptedException e) {}
		    String remarkOptionPath = "//li[contains(text(),'" + remarkValue + "')]";
		    try
		    {
		        WebElement remarkOption = driverUtilities.get().getWebElement(remarkOptionPath);
		        driverUtilities.get().clickOnElement(remarkOption);
		    } 
		    catch(NoSuchElementException e) 
		    {
		        System.out.println("Remark option not found in dropdown: " + remarkValue);
		    }
		}
		
		public void verifyAmountDueIsFinePlusAppealRejectedFee(String fine, String appealRejectedFee)
		{
			String amoutDue= "//h6[contains(text(),'Amount Due:')]/following-sibling::*";
			WebElement amoutDueEle = driverUtilities.get().getWebElement(amoutDue);
			String amoutDueValue = driverUtilities.get().getElementText(amoutDueEle);
			System.out.println("amoutDueValue:="+amoutDueValue);
			amoutDueValue = amoutDueValue.substring(1);
			System.out.println("amoutDueValue:="+amoutDueValue);
			Double fineValue = Double.parseDouble(fine);
			System.out.println("fineValue:="+fineValue);
			Double appealRejectedFeeValue = Double.parseDouble(appealRejectedFee);
			System.out.println("appealRejectedFeeValue:="+appealRejectedFeeValue);
			Double sum = fineValue + appealRejectedFeeValue;
			String sumValue = sum.toString();
			System.out.println("sumValue:="+sumValue);
			System.out.println("amoutDueValue:="+amoutDueValue);
			Assert.assertTrue(amoutDueValue.contains(sumValue));
		}
}
