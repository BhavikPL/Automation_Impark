package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import config.Settings;
import utility.Util;
import utility.PropertyUtil;
import path.Path;

public class TicketManag_EditTicketPage extends BasePage 
{
    // Page heading
    @FindBy(how=How.XPATH, using="//h3[normalize-space(contains(text(),'Edit Citation'))]")
    public WebElement editCitationHeading;
    
    // License Plate field
    @FindBy(how=How.XPATH, using="//input[@name='lp_number' and @placeholder='License Plate']")
    public WebElement licensePlateField;
    
    // License Status dropdown
    @FindBy(how=How.XPATH, using="//select[@name='status']")
    public WebElement licenseStatusDropdown;
    
    // Select Type dropdown
    @FindBy(how=How.XPATH, using="//select[@name='ticket_type']")
    public WebElement selectTypeDropdown;
    
    // Violation Code field
    @FindBy(how=How.XPATH, using="//input[@name='code_input' and @placeholder='Violation code']")
    public WebElement violationCodeField;
    
    // Violation Description field
    @FindBy(how=How.XPATH, using="//input[@name='description_input' and @placeholder='Select Violation Description']")
    public WebElement violationDescriptionField;
    
    // Officer Name field
    @FindBy(how=How.XPATH, using="//input[@name='officer_input' and @placeholder='Officer Name']")
    public WebElement officerNameField;
    
    // Search Street field
    @FindBy(how=How.XPATH, using="//input[@name='street_input' and @placeholder='Search Street']")
    public WebElement searchStreetField;
    
    // Remarks field
    @FindBy(how=How.XPATH, using="//input[@name='remark_input' and @placeholder='Remarks']")
    public WebElement remarksField;
    
    // Submit button
    @FindBy(how=How.XPATH, using="//button[@type='button' and contains(text(),'Submit')]")
    public WebElement submitButton;
    
    // Total Records Found message
    @FindBy(how=How.XPATH, using="//p[contains(., 'Total') and contains(., 'Records Found')]")
    public WebElement totalRecordsFoundMessage;
    
    // Results table
    @FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']")
    public WebElement resultsTable;
    
    // Edit Ticket menu option
    @FindBy(how=How.XPATH, using="//a[contains(@href,'/amendcitationlist') and contains(@class,'nav-link2')]")
    public WebElement editTicketMenuOption;
    
    // Filter button to show/hide filter section
    @FindBy(how=How.XPATH, using="//button[@class='filter-box report-mr']")
    public WebElement filterButton;
    
    // From date field
    @FindBy(how=How.XPATH, using="//input[@name='start_date']")
    public WebElement fromDateField;
    
    // To date field
    @FindBy(how=How.XPATH, using="//input[@name='end_date']")
    public WebElement toDateField;
    
    // Search ticket field
    @FindBy(how=How.XPATH, using="//input[@name='ticket_no']")
    public WebElement searchTicketField;
    
    // Edit popup elements
    @FindBy(how=How.XPATH, using="//input[@name='ticket_Id']")
    public WebElement editPopupCitationNumber;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'State')]/following-sibling::select")
    public WebElement editPopupState;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'License Plate')]/following-sibling::input[@name='lp_number']")
    public WebElement editPopupLicensePlate;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Remark 1')]/following-sibling::input[@name='remark_1']")
    public WebElement editPopupRemark1;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Violation Code')]/following-sibling::select")
    public WebElement editPopupViolationCode;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Violation Description')]/following-sibling::select")
    public WebElement editPopupViolationDescription;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Vehicle Color')]/following-sibling::select")
    public WebElement editPopupVehicleColor;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Vehicle Make')]/following-sibling::select")
    public WebElement editPopupVehicleMake;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Vehicle Model')]/following-sibling::select")
    public WebElement editPopupVehicleModel;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Reason for Edit *')]/following-sibling::textarea")
    public WebElement editPopupReasonForEdit;
    
    @FindBy(how=How.XPATH, using="//*[normalize-space(contains(text(),'Edit Ticket'))]/ancestor::div//div[contains(@class,'edit-citationonly-submit')]//button[contains(text(),'Submit')]")
    public WebElement editPopupSubmitButton;
    
    @FindBy(how=How.XPATH, using="//button[contains(@class,'edit-citation') and contains(text(),'Submit')]")
    public WebElement editPopupMultipleTicSubmitButton;
    
    // Additional edit popup elements
    @FindBy(how=How.XPATH, using="//input[@name='street']")
    public WebElement editPopupStreet;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Note 1')]/following-sibling::input[@name='note_1']")
    public WebElement editPopupNote1;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'Note 2')]/following-sibling::input[@name='note_2']")
    public WebElement editPopupNote2;
    
    @FindBy(how=How.XPATH, using="//button[normalize-space(contains(text(),'Edit Citation')) and contains(@class,'edit-citation-btn')]")
    public WebElement editCitatinButton;
    
    /**
     * Clear License Plate field
     */
    public void clearLicensePlateField()
    {
        driverUtilities.get().clearTextBox(licensePlateField);
    }
    
    /**
     * Enter license plate number
     */
    public void enterLicensePlateNumber(String plateNumber)
    {
        driverUtilities.get().typeIntoTextBox(licensePlateField, plateNumber);
    }
    
    /**
     * Select license status from dropdown
     */
    public void selectLicenseStatus(String status)
    {
        driverUtilities.get().clickOnElement(licenseStatusDropdown);
        driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'"+status+"')]"));
    }
    
    /**
     * Select ticket type from dropdown
     */
    public void selectTicketType(String type)
    {
        driverUtilities.get().selectElementFromList(selectTypeDropdown, type);
    }
    
    /**
     * Clear violation code field
     */
    public void clearViolationCodeField()
    {
        driverUtilities.get().clearTextBox(violationCodeField);
    }
    
    /**
     * Enter violation code
     */
    public void enterViolationCode(String code)
    {
    	driverUtilities.get().clickOnElement(violationCodeField);
        driverUtilities.get().typeIntoTextBox(violationCodeField, code);
        driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'"+code+"')]"));
    }
    
    /**
     * Clear violation description field
     */
    public void clearViolationDescriptionField()
    {
        driverUtilities.get().clearTextBox(violationDescriptionField);
    }
    
    /**
     * Enter violation description
     */
    public void enterViolationDescription(String description)
    {
    	driverUtilities.get().clickOnElement(violationDescriptionField);
        driverUtilities.get().typeIntoTextBox(violationDescriptionField, description);
        driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'"+description+"')]"));
    }
    
    /**
     * Clear officer name field
     */
    public void clearOfficerNameField()
    {
        driverUtilities.get().clearTextBox(officerNameField);
    }
    
    /**
     * Enter officer name
     */
    public void enterOfficerName(String officerName)
    {
    	driverUtilities.get().clickOnElement(officerNameField);
        driverUtilities.get().typeIntoTextBox(officerNameField, officerName);
        driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'"+officerName+"')]"));
    }
    
    /**
     * Clear search street field
     */
    public void clearSearchStreetField()
    {
        driverUtilities.get().clearTextBox(searchStreetField);
    }
    
    /**
     * Enter search street
     */
    public void enterSearchStreet(String street)
    {
    	driverUtilities.get().clickOnElement(searchStreetField);
        driverUtilities.get().typeIntoTextBox(searchStreetField, street);
        driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'"+street+"')]"));
    }
    
    /**
     * Clear remarks field
     */
    public void clearRemarksField()
    {
        driverUtilities.get().clearTextBox(remarksField);
    }
    
    /**
     * Enter remarks
     */
    public void enterRemarks(String remarks)
    {
        driverUtilities.get().typeIntoTextBox(remarksField, remarks);
    }
    
    /**
     * Click submit button
     */
    public void clickSubmitButton()
    {
        driverUtilities.get().clickOnElement(submitButton);
    }
    
    /**
     * Verify search results display with total records found message
     */
    public void verifySearchResultsDisplay()
    {
        driverUtilities.get().waitForElementToBePresent(totalRecordsFoundMessage);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(totalRecordsFoundMessage));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(resultsTable));
    }
    
    /**
     * Click on edit ticket option
     */
    public void clickOnEditTicketOption()
    {
        driverUtilities.get().waitForElementToBePresent(editTicketMenuOption);
        driverUtilities.get().clickOnElement(editTicketMenuOption);
    }
    
    /**
     * Click on filter button to show filter section
     */
    public void clickOnFilterButton()
    {
        driverUtilities.get().waitForElementToBePresent(filterButton);
        driverUtilities.get().clickOnElement(filterButton);
    }
    
    /**
     * Verify edit ticket page is displayed
     */
    public void verifyEditTicketPageIsDisplayed()
    {
        driverUtilities.get().waitForElementToBePresent(editCitationHeading);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(editCitationHeading));
    }
    
    /**
     * Verify that from date and to date values are pre populated
     */
    public void verifyFromDateAndToDateArePrePopulated()
    {
        driverUtilities.get().waitForElementToBePresent(fromDateField);
        driverUtilities.get().waitForElementToBePresent(toDateField);
        String fromDateValue = driverUtilities.get().getAttribute(fromDateField, "value");
        String toDateValue = driverUtilities.get().getAttribute(toDateField, "value");
        Assert.assertFalse(fromDateValue.isEmpty());
        Assert.assertFalse(toDateValue.isEmpty());
    }
    
    /**
     * Clear citation issue date from field
     */
    public void clearCitationIssueDateFromField()
    {
        driverUtilities.get().setAttributeOfElement(fromDateField, "value", "");
    }
    
    /**
     * Enter valid from date
     */
    public void enterValidFromDate()
    {
    	String todayDate = Util.getCurrentSystemDate("dd/MM/yyyy ");
    	driverUtilities.get().setAttributeOfElement(fromDateField, "value", "");
    }
    
    /**
     * Clear citation issue date to field
     */
    public void clearCitationIssueDateToField()
    {
    	driverUtilities.get().setAttributeOfElement(toDateField, "value", "");
    }
    
    /**
     * Enter valid to date
     */
    public void enterValidToDate()
    {
        // Date entry logic if needed
    }
    
    /**
     * Clear search ticket field
     */
    public void clearSearchTicketField()
    {
        driverUtilities.get().clearTextBox(searchTicketField);
    }
    
    /**
     * Enter citation number
     */
    public void enterCitationNumber(String citationNumber)
    {
        driverUtilities.get().typeIntoTextBox(searchTicketField, citationNumber);
    }
    
    public void verifyTickteSearchedBasedOnCitation(String citation)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]")));
	}
	
	/**
	 * Click on edit link for specific citation
	 */
	public void clickEditLinkForCitation(String citation)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/preceding-sibling::td/a");}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/preceding-sibling::td/a"));
	}
	
	/**
	 * Verify edit ticket popup is displayed
	 */
	public void verifyEditTicketPopup()
	{
		driverUtilities.get().waitForElementToBePresent(editPopupCitationNumber);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(editPopupCitationNumber));
	}
	
	/**
	 * Verify citation number in edit popup
	 */
	public void verifyCitationNumberInEditPopup(String expectedCitation)
	{
		String actualCitation = driverUtilities.get().getAttribute(editPopupCitationNumber, "value");
		Assert.assertEquals(expectedCitation, actualCitation);
	}
	
	/**
	 * Verify state in edit popup
	 */
	public void verifyStateInEditPopup(String expectedState)
	{
		String actualState = driverUtilities.get().getFirstSelectedOptionFromList(editPopupState);
		Assert.assertEquals(expectedState, actualState);
	}
	
	/**
	 * Verify license plate in edit popup
	 */
	public void verifyLicensePlateInEditPopup(String expectedPlate)
	{
		String actualPlate = driverUtilities.get().getAttribute(editPopupLicensePlate, "value");
		Assert.assertEquals(expectedPlate, actualPlate);
	}
	
	/**
	 * Verify remark in edit popup
	 */
	public void verifyRemarkInEditPopup(String expectedRemark)
	{
		String actualRemark = driverUtilities.get().getAttribute(editPopupRemark1, "value");
		Assert.assertEquals(expectedRemark, actualRemark);
	}
	
	/**
	 * Verify violation code in edit popup
	 */
	public void verifyViolationCodeInEditPopup(String expectedCode)
	{
		String actualCode = driverUtilities.get().getFirstSelectedOptionFromList(editPopupViolationCode);
		Assert.assertTrue(actualCode.contains(expectedCode));
	}
	
	/**
	 * Verify violation description in edit popup
	 */
	public void verifyViolationDescriptionInEditPopup(String expectedDescription)
	{
		String actualDescription = driverUtilities.get().getFirstSelectedOptionFromList(editPopupViolationDescription);
		Assert.assertTrue(actualDescription.contains(expectedDescription));
	}
	
	/**
	 * Verify vehicle color in edit popup
	 */
	public void verifyVehicleColorInEditPopup(String expectedColor)
	{
		String actualColor = driverUtilities.get().getFirstSelectedOptionFromList(editPopupVehicleColor);
		Assert.assertEquals(expectedColor, actualColor);
	}
	
	/**
	 * Verify vehicle make in edit popup
	 */
	public void verifyVehicleMakeInEditPopup(String expectedMake)
	{
		String actualMake = driverUtilities.get().getFirstSelectedOptionFromList(editPopupVehicleMake);
		Assert.assertEquals(expectedMake, actualMake);
	}
	
	/**
	 * Verify vehicle model in edit popup
	 */
	public void verifyVehicleModelInEditPopup(String expectedModel)
	{
		String actualModel = driverUtilities.get().getFirstSelectedOptionFromList(editPopupVehicleModel);
		Assert.assertEquals(expectedModel, actualModel);
	}
	
	/**
	 * Enter reason for edit
	 */
	public void enterReasonForEdit(String reason)
	{
		try
		{
			driverUtilities.get().clearTextBox(editPopupReasonForEdit);
			driverUtilities.get().typeIntoTextBox(editPopupReasonForEdit, reason);
		}
		catch(NoSuchElementException e)
		{
			
		}
		try
		{
			driverUtilities.get().clearTextBox(driverUtilities.get().getWebElement("(//label[contains(text(),'Reason for Edit *')]/following-sibling::textarea)[2]"));
			driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement("(//label[contains(text(),'Reason for Edit *')]/following-sibling::textarea)[2]"), reason);
		}
		catch(NoSuchElementException e)
		{
					
		}
	}
	
	/**
	 * Click submit button in edit popup
	 */
	public void clickSubmitButtonInEditPopup()
	{
		driverUtilities.get().clickOnElement(editPopupSubmitButton);
	}
	
	public void clickSubmitButtonInEditPopupMultipleTickets()
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(editPopupMultipleTicSubmitButton);
		driverUtilities.get().clickOnElement(editPopupMultipleTicSubmitButton);
	}
	
	/**
	 * Enter license plate in edit popup and save to temp file
	 */
	public void enterLicensePlateInEditPopupAndSave(String variableName) throws Exception
	{
		driverUtilities.get().clickOnElement(editPopupLicensePlate);
		driverUtilities.get().clearTextBox(editPopupLicensePlate);
		String plateValue = "TESTPLATE" + System.currentTimeMillis();
		driverUtilities.get().typeIntoTextBox(editPopupLicensePlate, plateValue);
		PropertyUtil.updateIntoProperty(Path.dataProperty, variableName, plateValue);
	}
	
	/**
	 * Enter street in edit popup and save to temp file
	 */
	public void enterStreetInEditPopupAndSave(String variableName) throws Exception
	{
		driverUtilities.get().clickOnElement(editPopupStreet);
		driverUtilities.get().clearTextBox(editPopupStreet);
		String streetValue = "TESTSTREET" + System.currentTimeMillis();
		driverUtilities.get().typeIntoTextBox(editPopupStreet, streetValue);
		PropertyUtil.updateIntoProperty(Path.dataProperty, variableName, streetValue);
	}
	
	/**
	 * Select Note 1 in edit popup and save to temp file
	 */
	public void selectNote1InEditPopupAndSave(String variableName) throws Exception
	{
		driverUtilities.get().clickOnElement(editPopupNote1);
		driverUtilities.get().clearTextBox(editPopupNote1);
		String note1Value = "TESTNOTE1" + System.currentTimeMillis();
		driverUtilities.get().typeIntoTextBox(editPopupNote1, note1Value);
		PropertyUtil.updateIntoProperty(Path.dataProperty, variableName, note1Value);
	}
	
	/**
	 * Select Note 2 in edit popup and save to temp file
	 */
	public void selectNote2InEditPopupAndSave(String variableName) throws Exception
	{
		driverUtilities.get().clickOnElement(editPopupNote2);
		driverUtilities.get().clearTextBox(editPopupNote2);
		String note2Value = "TESTNOTE2" + System.currentTimeMillis();
		driverUtilities.get().typeIntoTextBox(editPopupNote2, note2Value);
		PropertyUtil.updateIntoProperty(Path.dataProperty, variableName, note2Value);
	}
	
	/**
	 * Select Violation Code in edit popup and save to temp file
	 */
	public void selectViolationCodeInEditPopupAndSave(String variableName) throws Exception
	{
		int number = Util.getRandomNumberOneToFive();
		driverUtilities.get().selectElementFromListIndex(editPopupViolationCode, number);
		String violationCodeValue = driverUtilities.get().getFirstSelectedOptionFromList(editPopupViolationCode);
		PropertyUtil.updateIntoProperty(Path.dataProperty, variableName, violationCodeValue);
	}
	
	/**
	 * Select Violation Description in edit popup and save to temp file
	 */
	public void selectViolationDescriptionInEditPopupAndSave(String variableName) throws Exception
	{
		String violationDescValue = driverUtilities.get().getFirstSelectedOptionFromList(editPopupViolationDescription);
		PropertyUtil.updateIntoProperty(Path.dataProperty, variableName, violationDescValue);
	}
	
	public void verifyTickteSearchedBasedOnNote(String remark)
	{
		String canRemark = Settings.canRemark;
		if(canRemark.equalsIgnoreCase("true"))
		{
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(normalize-space(.), '"+remark+"')]")));
		}
	}
	
	public void selectCheckboxForTicketRecord(String citatinNumber)
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citatinNumber+"')]/parent::td/preceding-sibling::td/input"));
	}
	
	public void clickOnEditCitationNumber()
	{
		driverUtilities.get().clickOnElement(editCitatinButton);
	}
	
	public void verifyMultipleTicketUpdate()
	{
		String message = "//*[contains(text(),'Ticket updated.')]/following-sibling::button";
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(message)));
	}
	
	public void clickOnMultipleTicketUpdate()
	{
		String message = "//*[contains(text(),'Ticket updated.')]/following-sibling::button";
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(message));
	}
	
	public void clickOnClitatinNumberFromSearchResultTable(String citatinNumber)
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citatinNumber+"')]"));
	}
	
	public void clickOnPLateNumberFromSearchResultTable(String plateNumber)
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+plateNumber+"')]"));
	}
	
	/**
	 * Enter special characters in license plate field
	 */
	public void enterSpecialCharactersInLicensePlate(String specialChars)
	{
		driverUtilities.get().typeIntoTextBox(licensePlateField, specialChars);
	}
	
	/**
	 * Enter special characters in search tickets field
	 */
	public void enterSpecialCharactersInSearchTickets(String specialChars)
	{
		driverUtilities.get().typeIntoTextBox(searchTicketField, specialChars);
	}
	
	/**
	 * Verify "No Record Found" message is displayed
	 */
	public void verifyNoRecordFoundMessage(String expectedMessage)
	{
		WebElement noRecordMessage = driverUtilities.get().getWebElement("//*[contains(text(),'" + expectedMessage + "')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(noRecordMessage));
	}
}