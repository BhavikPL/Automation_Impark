package pages;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class TicketManag_SearchTicketsPage extends BasePage 
{
    // State mapping for two-character codes to full state names
    private static final Map<String, String> STATE_MAPPING = new HashMap<>();
    
    static {
        STATE_MAPPING.put("AL", "Alabama");
        STATE_MAPPING.put("AK", "Alaska");
        STATE_MAPPING.put("AZ", "Arizona");
        STATE_MAPPING.put("AR", "Arkansas");
        STATE_MAPPING.put("CA", "California");
        STATE_MAPPING.put("CO", "Colorado");
        STATE_MAPPING.put("CT", "Connecticut");
        STATE_MAPPING.put("DE", "Delaware");
        STATE_MAPPING.put("FL", "Florida");
        STATE_MAPPING.put("GA", "Georgia");
        STATE_MAPPING.put("HI", "Hawaii");
        STATE_MAPPING.put("ID", "Idaho");
        STATE_MAPPING.put("IL", "Illinois");
        STATE_MAPPING.put("IN", "Indiana");
        STATE_MAPPING.put("IA", "Iowa");
        STATE_MAPPING.put("KS", "Kansas");
        STATE_MAPPING.put("KY", "Kentucky");
        STATE_MAPPING.put("LA", "Louisiana");
        STATE_MAPPING.put("ME", "Maine");
        STATE_MAPPING.put("MD", "Maryland");
        STATE_MAPPING.put("MA", "Massachusetts");
        STATE_MAPPING.put("MI", "Michigan");
        STATE_MAPPING.put("MN", "Minnesota");
        STATE_MAPPING.put("MS", "Mississippi");
        STATE_MAPPING.put("MO", "Missouri");
        STATE_MAPPING.put("MT", "Montana");
        STATE_MAPPING.put("NE", "Nebraska");
        STATE_MAPPING.put("NV", "Nevada");
        STATE_MAPPING.put("NH", "New Hampshire");
        STATE_MAPPING.put("NJ", "New Jersey");
        STATE_MAPPING.put("NM", "New Mexico");
        STATE_MAPPING.put("NY", "New York");
        STATE_MAPPING.put("NC", "North Carolina");
        STATE_MAPPING.put("ND", "North Dakota");
        STATE_MAPPING.put("OH", "Ohio");
        STATE_MAPPING.put("OK", "Oklahoma");
        STATE_MAPPING.put("OR", "Oregon");
        STATE_MAPPING.put("PA", "Pennsylvania");
        STATE_MAPPING.put("RI", "Rhode Island");
        STATE_MAPPING.put("SC", "South Carolina");
        STATE_MAPPING.put("SD", "South Dakota");
        STATE_MAPPING.put("TN", "Tennessee");
        STATE_MAPPING.put("TX", "Texas");
        STATE_MAPPING.put("UT", "Utah");
        STATE_MAPPING.put("VT", "Vermont");
        STATE_MAPPING.put("VA", "Virginia");
        STATE_MAPPING.put("WA", "Washington");
        STATE_MAPPING.put("WV", "West Virginia");
        STATE_MAPPING.put("WI", "Wisconsin");
        STATE_MAPPING.put("WY", "Wyoming");
        STATE_MAPPING.put("DC", "District of Columbia");
    }
    
    // Search page elements
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Search For')]")
    public WebElement searchForCitationsHeading;
    
    @FindBy(how=How.XPATH, using="//p[text()='Search by Ticket Number, License plate and state.']")
    public WebElement searchPageDescription;
    
    // Search form fields
    @FindBy(how=How.XPATH, using="//input[@name='ticketNumber' and @id='ticketNumber']")
    public WebElement ticketNumberField;
    
    @FindBy(how=How.XPATH, using="//input[@name='licPlate' and @id='licPlate']")
    public WebElement licensePlateField;
    
    @FindBy(how=How.XPATH, using="//label[contains(text(),'License State')]/following-sibling::div")
    public WebElement licenseStateField;
    
    @FindBy(how=How.XPATH, using="//div[@id='state']//div[contains(@class,'react-select__control')]")
    public WebElement licenseStateDropdown;
    
    @FindBy(how=How.XPATH, using="//div[@id='state']//div[contains(@class,'react-select__menu')]")
    public WebElement licenseStateDropdownMenu;
    
    @FindBy(how=How.XPATH, using="//input[@name='userName' and @id='userName']")
    public WebElement nameField;
    
    @FindBy(how=How.XPATH, using="//input[@name='address' and @id='address']")
    public WebElement addressField;
    
    @FindBy(how=How.XPATH, using="//input[@name='city' and @id='city']")
    public WebElement cityField;
    
    @FindBy(how=How.XPATH, using="//label[text()='License State']/following-sibling::div")
    public WebElement stateCityField;
    
    @FindBy(how=How.XPATH, using="//div[@id='stateCity']//div[contains(@class,'react-select__control')]")
    public WebElement stateCityDropdown;
    
    @FindBy(how=How.XPATH, using="//div[@id='stateCity']//div[contains(@class,'react-select__menu')]")
    public WebElement stateCityDropdownMenu;
    
    @FindBy(how=How.XPATH, using="//input[@name='zip' and @id='zip']")
    public WebElement zipField;
    
    @FindBy(how=How.XPATH, using="//input[@name='email' and @id='email']")
    public WebElement emailField;
    
    @FindBy(how=How.XPATH, using="//input[@name='phone' and @id='phone']")
    public WebElement phoneField;
    
    @FindBy(how=How.XPATH, using="//input[@name='vin_number' and @id='vin_number']")
    public WebElement vinNumberField;
    
    // Search button
    @FindBy(how=How.XPATH, using="//button[@class='btn' and @type='button' and text()='Search']")
    public WebElement searchButton;
    
    // Search results elements based on actual HTML structure
    @FindBy(how=How.XPATH, using="//div[contains(@class,'displayResult') or contains(@class,'cstm-citation-data-main-row')]")
    public WebElement searchResultsContainer;
    
    // Citation details elements
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Ticket Number'))]/following-sibling::h5)[1]")
    public WebElement ticketNumberValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Plate/State'))]/following-sibling::h5)[3]")
    public WebElement plateStateValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Status'))]/following-sibling::h5)[8]")
    public WebElement statusValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Original Fine'))]/following-sibling::h5)[9]")
    public WebElement originalFineValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Make'))]/following-sibling::h5)[4]")
    public WebElement makeValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Color'))]/following-sibling::h5)[5]")
    public WebElement colorValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Location'))]/following-sibling::h5)[6]")
    public WebElement locationValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Violation'))]/following-sibling::h5)[7]")
    public WebElement violationValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Issue Date & Time'))]/following-sibling::h5)[2]")
    public WebElement issueDateTimeValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Late Fee(s)'))]/following-sibling::h5)[10]")
    public WebElement lateFeeValue;
    
    @FindBy(how=How.XPATH, using="(//div[contains(@class,'details-searchCitation')]//p[normalize-space(contains(text(),'Amount Due'))]/following-sibling::h5)[11]")
    public WebElement amountDueValue;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'details-searchCitation')]//p[contains(text(),'Registered Owner Details')]/following-sibling::h5")
    public WebElement registeredOwnerDetailsValue;
    
    // Action buttons
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-viewdetsils-button-citationsearchresult')]//button[contains(text(),'View Details')]")
    public WebElement viewDetailsButton;
    
    @FindBy(how=How.XPATH, using="//button[contains(@class,'modal-payment') or text()='Pay']")
    public WebElement payButton;
    
    // Back button
    @FindBy(how=How.XPATH, using="//div[@class='col-12 back-button mb-2']//a[contains(text(),'Back')]")
    public WebElement backButton;
    
    // Payment popup elements
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Choose your payment method')]")
    public WebElement paymentPopupHeading;
    
    @FindBy(how=How.XPATH, using="//button[contains(@class,'close') or contains(@aria-label,'Close')]")
    public WebElement closePaymentPopupButton;

    
    /**
     * Verify Search Tickets page is displayed
     */
    public void verifySearchTicketsPageIsDisplayed()
    {
        try {driverUtilities.get().waitForElementToBePresent(searchForCitationsHeading);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(searchForCitationsHeading);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(searchForCitationsHeading));
        
        //try {driverUtilities.get().waitForElementToBePresent(searchPageDescription);}catch(TimeoutException e) {}
        //driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(searchPageDescription);
        //527175Assert.assertTrue(driverUtilities.get().isElementDisplayed(searchPageDescription));
    }
    
    /**
     * Clear ticket number field
     */
    public void clearTicketNumberField()
    {
        try {driverUtilities.get().waitForElementToBePresent(ticketNumberField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketNumberField);
        driverUtilities.get().clearTextBox(ticketNumberField);
    }
    
    /**
     * Clear license plate number field
     */
    public void clearLicensePlateNumberField()
    {
        try {driverUtilities.get().waitForElementToBePresent(licensePlateField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(licensePlateField);
        driverUtilities.get().clearTextBox(licensePlateField);
    }
    
    /**
     * Clear name field
     */
    public void clearNameField()
    {
        try {driverUtilities.get().waitForElementToBePresent(nameField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(nameField);
        driverUtilities.get().clearTextBox(nameField);
    }
    
    /**
     * Clear address field
     */
    public void clearAddressField()
    {
        try {driverUtilities.get().waitForElementToBePresent(addressField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(addressField);
        driverUtilities.get().clearTextBox(addressField);
    }
    
    /**
     * Clear email field
     */
    public void clearEmailField()
    {
        try {driverUtilities.get().waitForElementToBePresent(emailField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(emailField);
        driverUtilities.get().clearTextBox(emailField);
    }
    
    /**
     * Clear phone field
     */
    public void clearPhoneField()
    {
        try {driverUtilities.get().waitForElementToBePresent(phoneField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(phoneField);
        driverUtilities.get().clearTextBox(phoneField);
    }
    
    /**
     * Clear zip field
     */
    public void clearZipField()
    {
        try {driverUtilities.get().waitForElementToBePresent(zipField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(zipField);
        driverUtilities.get().clearTextBox(zipField);
    }
    
    /**
     * Enter ticket number in search field
     */
    public void enterTicketNumber(String ticketNumber)
    {
        try {driverUtilities.get().waitForElementToBePresent(ticketNumberField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketNumberField);
        driverUtilities.get().typeIntoTextBox(ticketNumberField, ticketNumber);
    }
    
    /**
     * Enter license plate number in search field
     */
    public void enterLicensePlateNumber(String plateNumber)
    {
        try {driverUtilities.get().waitForElementToBePresent(licensePlateField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(licensePlateField);
        driverUtilities.get().typeIntoTextBox(licensePlateField, plateNumber);
    }
    
    /**
     * Select license state from dropdown
     */
    public void selectLicenseState(String stateCode)
    {
        String fullStateName = STATE_MAPPING.get(stateCode.toUpperCase());
        if (fullStateName == null) {
            fullStateName = stateCode; // fallback to original code if not found in mapping
        }
        
        
        try {driverUtilities.get().waitForElementToBePresent(licenseStateField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(licenseStateField);
        driverUtilities.get().clickOnElement(licenseStateField);
        
        WebElement licenseStateField= driverUtilities.get().getWebElement("//label[contains(text(),'License State')]/following-sibling::div//input");
        driverUtilities.get().typeIntoTextBox(licenseStateField, fullStateName);
        try {Thread.sleep(1000);}catch(InterruptedException e) {}
        
        // Select the licesnse state option from dropdown
        String stateOptionXpath = "//*[normalize-space(text())='" + fullStateName.toUpperCase() + "']";
        WebElement stateOption = driverUtilities.get().getWebElement(stateOptionXpath);
        driverUtilities.get().clickOnElement(stateOption);
    }
    
    /**
     * Enter name in name field
     */
    public void enterName(String name)
    {
        try {driverUtilities.get().waitForElementToBePresent(nameField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(nameField);
        driverUtilities.get().typeIntoTextBox(nameField, name);
    }
    
    /**
     * Enter address from address list
     */
    public void enterAddressFromList(String address)
    {
        try {driverUtilities.get().waitForElementToBePresent(addressField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(addressField);
        driverUtilities.get().typeIntoTextBox(addressField, address);
    }
    
    /**
     * Enter email address in email field
     */
    public void enterEmailAddress(String email)
    {
        try {driverUtilities.get().waitForElementToBePresent(emailField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(emailField);
        driverUtilities.get().typeIntoTextBox(emailField, email);
    }
    
    /**
     * Enter phone number in phone field
     */
    public void enterPhoneNumber(String phone)
    {
        try {driverUtilities.get().waitForElementToBePresent(phoneField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(phoneField);
        driverUtilities.get().typeIntoTextBox(phoneField, phone);
    }
    
    /**
     * Enter invalid email format in email field
     */
    public void enterInvalidEmailFormat()
    {
        String invalidEmail = "invalid-email-format";
        try {driverUtilities.get().waitForElementToBePresent(emailField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(emailField);
        driverUtilities.get().typeIntoTextBox(emailField, invalidEmail);
    }
    
    /**
     * Enter invalid phone number format in phone field
     */
    public void enterInvalidPhoneNumberFormat()
    {
        String invalidPhone = "invalid-phone-123";
        try {driverUtilities.get().waitForElementToBePresent(phoneField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(phoneField);
        driverUtilities.get().typeIntoTextBox(phoneField, invalidPhone);
    }
    
    /**
     * Enter invalid zip code format in zip field
     */
    public void enterInvalidZipCodeFormat()
    {
        String invalidZip = "invalid-zip-123";
        try {driverUtilities.get().waitForElementToBePresent(zipField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(zipField);
        driverUtilities.get().typeIntoTextBox(zipField, invalidZip);
    }
    
    /**
     * Click on search button
     */
    public void clickOnSearchButton()
    {
        try {driverUtilities.get().waitForElementToBePresent(searchButton);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(searchButton);
        driverUtilities.get().clickOnElement(searchButton);
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
    }
    
    /**
     * Verify search results display with citation details including ticket information, 
     * violation details, financial amounts, registered owner details, and functional Pay/View Details buttons
     */
    public void verifySearchResultsDisplay()
    {
        // Verify search results container is displayed
        try {driverUtilities.get().waitForElementToBePresent(searchResultsContainer);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(searchResultsContainer);
        Assert.assertTrue("Search results container should be displayed", driverUtilities.get().isElementDisplayed(searchResultsContainer));
        
        // Verify ticket information
        verifyTicketInformation();
        
        // Verify violation details
        verifyViolationDetails();
        
        // Verify financial amounts
        verifyFinancialAmounts();
        
        // Verify registered owner details
        verifyRegisteredOwnerDetails();
        
        // Verify functional buttons
        verifyFunctionalButtons();
    }
    
    /**
     * Verify ticket information details
     */
    public void verifyTicketInformation()
    {
        // Verify Ticket Number
        try {driverUtilities.get().waitForElementToBePresent(ticketNumberValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketNumberValue);
        Assert.assertTrue("Ticket number should be displayed", driverUtilities.get().isElementDisplayed(ticketNumberValue));
        
        // Verify Plate/State
        try {driverUtilities.get().waitForElementToBePresent(plateStateValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(plateStateValue);
        Assert.assertTrue("Plate/State should be displayed", driverUtilities.get().isElementDisplayed(plateStateValue));
        
        // Verify Make
        try {driverUtilities.get().waitForElementToBePresent(makeValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(makeValue);
        Assert.assertTrue("Make should be displayed", driverUtilities.get().isElementDisplayed(makeValue));
        
        // Verify Color
        try {driverUtilities.get().waitForElementToBePresent(colorValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(colorValue);
        Assert.assertTrue("Color should be displayed", driverUtilities.get().isElementDisplayed(colorValue));
        
        // Verify Location
        try {driverUtilities.get().waitForElementToBePresent(locationValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(locationValue);
        Assert.assertTrue("Location should be displayed", driverUtilities.get().isElementDisplayed(locationValue));
        
        // Verify Issue Date & Time
        try {driverUtilities.get().waitForElementToBePresent(issueDateTimeValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(issueDateTimeValue);
        Assert.assertTrue("Issue Date & Time should be displayed", driverUtilities.get().isElementDisplayed(issueDateTimeValue));
    }
    
    /**
     * Verify violation details
     */
    public void verifyViolationDetails()
    {
        // Verify Violation
        try {driverUtilities.get().waitForElementToBePresent(violationValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(violationValue);
        Assert.assertTrue("Violation details should be displayed", driverUtilities.get().isElementDisplayed(violationValue));
        
        // Verify Status
        try {driverUtilities.get().waitForElementToBePresent(statusValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(statusValue);
        Assert.assertTrue("Status should be displayed", driverUtilities.get().isElementDisplayed(statusValue));
    }
    
    /**
     * Verify financial amounts
     */
    public void verifyFinancialAmounts()
    {
        // Verify Original Fine
        try {driverUtilities.get().waitForElementToBePresent(originalFineValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(originalFineValue);
        Assert.assertTrue("Original Fine should be displayed", driverUtilities.get().isElementDisplayed(originalFineValue));
        
        // Verify Late Fee(s)
        try {driverUtilities.get().waitForElementToBePresent(lateFeeValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(lateFeeValue);
        Assert.assertTrue("Late Fee should be displayed", driverUtilities.get().isElementDisplayed(lateFeeValue));
        
        // Verify Amount Due
        try {driverUtilities.get().waitForElementToBePresent(amountDueValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(amountDueValue);
        Assert.assertTrue("Amount Due should be displayed", driverUtilities.get().isElementDisplayed(amountDueValue));
    }
    
    /**
     * Verify registered owner details
     */
    public void verifyRegisteredOwnerDetails()
    {
        // Verify Registered Owner Details
        try {driverUtilities.get().waitForElementToBePresent(registeredOwnerDetailsValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(registeredOwnerDetailsValue);
        Assert.assertTrue("Registered Owner Details should be displayed", driverUtilities.get().isElementDisplayed(registeredOwnerDetailsValue));
    }
    
    /**
     * Verify functional Pay/View Details buttons
     */
    public void verifyFunctionalButtons()
    {
        // Verify View Details button
        try {driverUtilities.get().waitForElementToBePresent(viewDetailsButton);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(viewDetailsButton);
        Assert.assertTrue("View Details button should be displayed", driverUtilities.get().isElementDisplayed(viewDetailsButton));
        
        // Verify Pay button
        try {driverUtilities.get().waitForElementToBePresent(payButton);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(payButton);
        Assert.assertTrue("Pay button should be displayed", driverUtilities.get().isElementDisplayed(payButton));
    }
    
    /**
     * Verify citation details with expected values from property files
     */
    public void verifyCitationDetailsWithPropertyValues(String expectedTicketNumber, String expectedPlate, String expectedState, 
                                                        String expectedMake, String expectedColor, String expectedViolation, 
                                                        String expectedFine, String expectedStreet)
    {
        // Verify Ticket Number matches expected value
        String actualTicketNumber = driverUtilities.get().getElementText(ticketNumberValue);
        Assert.assertTrue("Ticket number should match: Expected=" + expectedTicketNumber + ", Actual=" + actualTicketNumber, 
                         actualTicketNumber.contains(expectedTicketNumber));
        
        // Verify Plate/State matches expected values
        String actualPlateState = driverUtilities.get().getElementText(plateStateValue);
        Assert.assertTrue("Plate should match: Expected=" + expectedPlate + ", Actual=" + actualPlateState, 
                         actualPlateState.contains(expectedPlate));
        Assert.assertTrue("State should match: Expected=" + expectedState + ", Actual=" + actualPlateState, 
                         actualPlateState.contains(expectedState));
        
        // Verify Make matches expected value
        String actualMake = driverUtilities.get().getElementText(makeValue);
        Assert.assertTrue("Make should match: Expected=" + expectedMake + ", Actual=" + actualMake, 
                         actualMake.equalsIgnoreCase(expectedMake));
        
        // Verify Color matches expected value
        String actualColor = driverUtilities.get().getElementText(colorValue);
        Assert.assertTrue("Color should match: Expected=" + expectedColor + ", Actual=" + actualColor, 
                         actualColor.equalsIgnoreCase(expectedColor));
        
        // Verify Violation Description matches expected value
        String actualViolation = driverUtilities.get().getElementText(violationValue);
        Assert.assertTrue("Violation should match: Expected=" + expectedViolation + ", Actual=" + actualViolation, 
                         actualViolation.contains(expectedViolation));
        
        // Verify Original Fine matches expected value
        String actualFine = driverUtilities.get().getElementText(originalFineValue);
        Assert.assertTrue("Fine should match: Expected=" + expectedFine + ", Actual=" + actualFine, 
                         actualFine.contains(expectedFine));
        
        // Verify Location contains street information from expected value
        String actualLocation = driverUtilities.get().getElementText(locationValue);
        Assert.assertTrue("Location should contain street: Expected=" + expectedStreet + ", Actual=" + actualLocation, 
                         actualLocation.contains(expectedStreet));
    }
    
    /**
     * Verify Registered Owner Details with specific values
     */
    public void verifyRegisteredOwnerDetailsWithValues(
                                                      String expectedAddress, String expectedCity, 
                                                      String expectedState, String expectedZip)
    {
        // Verify Registered Owner Details section is displayed
        try {driverUtilities.get().waitForElementToBePresent(registeredOwnerDetailsValue);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(registeredOwnerDetailsValue);
        Assert.assertTrue("Registered Owner Details should be displayed", driverUtilities.get().isElementDisplayed(registeredOwnerDetailsValue));
        
        // Get the actual registered owner details text
        String actualOwnerDetails = driverUtilities.get().getElementText(registeredOwnerDetailsValue);
        
        // Verify Address is present
        Assert.assertTrue("Address should be present: Expected=" + expectedAddress + ", Actual=" + actualOwnerDetails, 
                         actualOwnerDetails.contains(expectedAddress));
        
        // Verify City is present
        Assert.assertTrue("City should be present: Expected=" + expectedCity + ", Actual=" + actualOwnerDetails, 
                         actualOwnerDetails.contains(expectedCity));
        
        // Verify State is present
        Assert.assertTrue("State should be present: Expected=" + expectedState + ", Actual=" + actualOwnerDetails, 
                         actualOwnerDetails.contains(expectedState));
        
        // Verify Zip is present
        Assert.assertTrue("Zip should be present: Expected=" + expectedZip + ", Actual=" + actualOwnerDetails, 
                         actualOwnerDetails.contains(expectedZip));
    }
    
    /**
     * Click on back button from search tickets result
     */
    public void clickOnBackButton()
    {
        try {driverUtilities.get().waitForElementToBePresent(backButton);}catch(TimeoutException e) {}
        try {driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(backButton);}catch(NoSuchElementException e) {}
        try {driverUtilities.get().clickOnElement(backButton);}catch(NoSuchElementException e) {}
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
    }
    
    /**
     * Enter invalid value in ticket number field
     */
    public void enterInvalidTicketNumber()
    {
        String invalidTicketNumber = "INVALID123";
        try {driverUtilities.get().waitForElementToBePresent(ticketNumberField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketNumberField);
        driverUtilities.get().typeIntoTextBox(ticketNumberField, invalidTicketNumber);
    }
    
    /**
     * Verify validation message for empty search
     */
    public void verifyValidationMessageForEmptySearch()
    {
        String expectedMessage = "Enter ticket number or Licence Plate or Motorist detail or Vin number";
        String validationMessageXpath = "//*[contains(text(),'" + expectedMessage + "')]";
        WebElement validationMessageElement = driverUtilities.get().getWebElement(validationMessageXpath);
        
        try {driverUtilities.get().waitForElementToBePresent(validationMessageElement);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(validationMessageElement);
        Assert.assertTrue("Validation message should be displayed for empty search", 
                         driverUtilities.get().isElementDisplayed(validationMessageElement));
    }
    
    /**
     * Verify validation message for invalid search
     */
    public void verifyValidationMessageForInvalidSearch()
    {
        String noRecordsMessage = "No Records Found";
        String noRecordsXpath = "//*[contains(text(),'" + noRecordsMessage + "')]";
        WebElement validationMessageElement = driverUtilities.get().getWebElement(noRecordsXpath);
        
        try {driverUtilities.get().waitForElementToBePresent(validationMessageElement);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(validationMessageElement);
        Assert.assertTrue("Validation message should be displayed for invalid search", 
                         driverUtilities.get().isElementDisplayed(validationMessageElement));
    }
    
    /**
     * Scroll to personal information section
     */
    public void scrollToPersonalInformationSection()
    {
        try {driverUtilities.get().waitForElementToBePresent(nameField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(nameField);
    }
    
    /**
     * Click on state dropdown in personal information section
     */
    public void clickOnStateDropdownInPersonalInformation()
    {
        try {driverUtilities.get().waitForElementToBePresent(stateCityDropdown);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(stateCityDropdown);
        driverUtilities.get().clickOnElement(stateCityDropdown);
        try {Thread.sleep(1000);}catch(InterruptedException e) {}
    }
    
    /**
     * Verify available states are listed in personal information dropdown
     */
    public void verifyAvailableStatesAreListed()
    {
        try {driverUtilities.get().waitForElementToBePresent(stateCityDropdownMenu);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(stateCityDropdownMenu);
        Assert.assertTrue("State dropdown menu should be displayed", driverUtilities.get().isElementDisplayed(stateCityDropdownMenu));
    }
    
    /**
     * Select a state from personal information dropdown
     */
    public void selectStateFromPersonalInformation(String stateCode)
    {
        String fullStateName = STATE_MAPPING.get(stateCode.toUpperCase());
        if (fullStateName == null) {
            fullStateName = stateCode;
        }
        
        try {driverUtilities.get().waitForElementToBePresent(stateCityField);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(stateCityField);
        driverUtilities.get().clickOnElement(stateCityField);
        
        //WebElement licenseStateField= driverUtilities.get().getWebElement("//label[contains(text(),'License State')]/following-sibling::div//input");
        driverUtilities.get().typeIntoTextBox(stateCityField, fullStateName);
        try {Thread.sleep(1000);}catch(InterruptedException e) {}
        
        // Select the state option from dropdown
        String stateOptionXpath = "//*[normalize-space(text())='" + fullStateName.toUpperCase() + "']";
        WebElement stateOption = driverUtilities.get().getWebElement(stateOptionXpath);
        driverUtilities.get().clickOnElement(stateOption);
    }
    
    /**
     * Verify search results display citations with the selected state from personal information section
     */
    public void verifySearchResultsMatchSelectedState(String expectedState)
    {
        try {driverUtilities.get().waitForElementToBePresent(searchResultsContainer);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(searchResultsContainer);
        Assert.assertTrue("Search results should be displayed", driverUtilities.get().isElementDisplayed(searchResultsContainer));
        
        String actualPlateState = driverUtilities.get().getElementText(plateStateValue);
        Assert.assertTrue("State should match in search results: Expected=" + expectedState + ", Actual=" + actualPlateState, 
                         actualPlateState.contains(expectedState));
    }
    
    /**
     * Click on pay button from search results
     */
    public void clickOnPayButton()
    {
        try {driverUtilities.get().waitForElementToBePresent(payButton);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(payButton);
        driverUtilities.get().clickOnElement(payButton);
    }
    
    /**
     * Verify payment popup is displayed with expected text
     */
    public void verifyPaymentPopupDisplayed(String expectedPopupText)
    {
        try {driverUtilities.get().waitForElementToBePresent(paymentPopupHeading);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(paymentPopupHeading);
        Assert.assertTrue("Payment popup should be displayed", driverUtilities.get().isElementDisplayed(paymentPopupHeading));
        
        String actualPopupText = driverUtilities.get().getElementText(paymentPopupHeading);
        Assert.assertTrue("Payment popup should contain expected text: Expected=" + expectedPopupText + ", Actual=" + actualPopupText, 
                         actualPopupText.contains(expectedPopupText));
    }
    
    /**
     * Close payment popup
     */
    public void closePaymentPopup()
    {
        try {driverUtilities.get().waitForElementToBePresent(closePaymentPopupButton);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(closePaymentPopupButton);
        driverUtilities.get().clickOnElement(closePaymentPopupButton);
    }
    
    /**
     * Clear all search fields
     */
    public void clearAllSearchFields()
    {
        clearTicketNumberField();
        clearLicensePlateNumberField();
        clearNameField();
        clearAddressField();
        clearEmailField();
        clearPhoneField();
        clearZipField();
    }
    
    /**
     * Click on View Details button
     */
    public void clickOnViewDetailsButton()
    {
        try {driverUtilities.get().waitForElementToBePresent(viewDetailsButton);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(viewDetailsButton);
        driverUtilities.get().clickOnElement(viewDetailsButton);
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
    }
    
    /**
     * Verify Citation Info tab is displayed
     */
    public void verifyCitationInfoTabIsDisplayed()
    {
        String citationInfoTabXpath = "//a[contains(text(),'Citation Info')]";
        WebElement citationInfoTab = driverUtilities.get().getWebElement(citationInfoTabXpath);
        
        try {driverUtilities.get().waitForElementToBePresent(citationInfoTab);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(citationInfoTab);
        Assert.assertTrue("Citation Info tab should be displayed", driverUtilities.get().isElementDisplayed(citationInfoTab));
    }
    
    public void verifyLinkedTicketInfoTabIsDisplayed()
    {
        String linkedTicketTabXpath = "//a[contains(@href,'#linked')]";
        WebElement linkedTicketTab = driverUtilities.get().getWebElement(linkedTicketTabXpath);
        
        try {driverUtilities.get().waitForElementToBePresent(linkedTicketTab);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(linkedTicketTab);
        Assert.assertTrue("Citation Info tab should be displayed", driverUtilities.get().isElementDisplayed(linkedTicketTab));
    }
}
