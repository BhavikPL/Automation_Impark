package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import config.Settings;
import path.Path;
import utility.EncryptDecPassword;
import utility.PropertyUtil;
import utility.Util;

public class SearchPage extends BasePage
{
	// Login page elements
	@FindBy(how=How.XPATH, using="//input[@name='user_name']")
	public WebElement userNameTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy(how=How.XPATH, using="//button[contains(@type,'submit') and contains(text(),'Sign In')]")
	public WebElement loginButton;
	
	// Search page elements
	@FindBy(how=How.XPATH, using="//h3[contains(normalize-space(.),'Search For Notices')]")
	public WebElement searchForNoticesHeading;
	
	@FindBy(how=How.XPATH, using="//input[@name='ticketNumber']")
	public WebElement noticeNumberTextBox;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Search')]")
	public WebElement searchButton;

	@FindBy(how=How.XPATH, using="//a[contains(normalize-space(.),'Search')]")
	public WebElement searchLinkFromResults;
	
	@FindBy(how=How.XPATH, using="//a[contains(normalize-space(.),'Search Result')]")
	public WebElement searchResultLinkFromResults;

	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.),'License Plate')]/following-sibling::input")
	public WebElement licensePlateInput;

	@FindBy(how=How.XPATH, using="//div[contains(text(),'Select state')]/following-sibling::div/input")
	public WebElement licenseProvinceStateInput;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Enter ticket number or Licence Plate')]")
	public WebElement validationMessage;
	
	// Search results elements
	@FindBy(how=How.XPATH, using="//div[contains(@class,'details-searchCitation ')]")
	public WebElement searchResultsTable;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Citation Number')]")
	public WebElement citationNumberHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Issue Date')]")
	public WebElement issueDateHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Officer')]")
	public WebElement officerHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Plate Number')]")
	public WebElement plateNumberHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'State')]")
	public WebElement stateHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Vehicle Make')]")
	public WebElement vehicleMakeHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Vehicle Model')]")
	public WebElement vehicleModelHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Vehicle Color')]")
	public WebElement vehicleColorHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Body Style')]")
	public WebElement bodyStyleHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Block')]")
	public WebElement blockHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Street')]")
	public WebElement streetHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Violation Code')]")
	public WebElement violationCodeHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Description')]")
	public WebElement descriptionHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Fine')]")
	public WebElement fineHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Paid After')]")
	public WebElement paidAfterHeader;
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Remarks')]")
	public WebElement remarksHeader;
	
	//void citation
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(.), 'Cancel Notice Reason')]/following-sibling::select")
	public WebElement cancelCitationReasonList;
		
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(.), 'Cancel Notice Comments')]/following-sibling::textarea")
	public WebElement cancelCitationComments;
		
	@FindBy(how = How.XPATH, using = "//p[contains(normalize-space(.), 'Cancel Notice')]/following-sibling::div/button[contains(text(),'Submit')]")
	public WebElement cancelCitationSubmitButton;
	
	//Note popup
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Support Note')]")
	public WebElement notePopupHeading;
		
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Enter Note*')]/following-sibling::div//div[contains(@data-placeholder,'Start typing...')]/p")
	public WebElement enterNoteTextarea;
		
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Support Note')]/ancestor::div//button[contains(text(),'Submit')]")
	public WebElement noteSubmitButton1;
		
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Support Note')]/ancestor::div//button[contains(text(),'Submit')]")
	public WebElement noteSubmitButton2;
		
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Choose File')]/following-sibling::input")
	public WebElement chooseFileButton;
	
	//view details page
	@FindBy(how=How.XPATH, using="//input[@name='original_amount']")
	public WebElement originalAmoutTextbox;
	
	//top bar pay button
	@FindBy(how=How.XPATH, using="//div[contains(@class,'justify-center')]//button[contains(text(),'Pay')]")
	public WebElement topPayButton;
	
	//card details from payment page
	@FindBy(how=How.XPATH, using="//input[@name='card_number']")
	public WebElement cardNumberTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='expiry']")
	public WebElement expiryTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='cvc']")
	public WebElement cvvextbox;
	
	// Add Discount popup elements
	@FindBy(how=How.XPATH, using="//input[@name='fine']")
	public WebElement originalFineAmountInput;
	
	@FindBy(how=How.XPATH, using="//input[@name='currentAmountDue']")
	public WebElement currentAmountDueInput;
	
	@FindBy(how=How.XPATH, using="//input[@name='discountAmount']")
	public WebElement discountAmountInput;
	
	@FindBy(how=How.XPATH, using="//input[@name='discount_days']")
	public WebElement discountDaysInput;
	
	@FindBy(how=How.XPATH, using="//input[@name='newDueAmount']")
	public WebElement newFineAmountDueInput;
	
	@FindBy(how=How.XPATH, using="//textarea[@name='remark']")
	public WebElement remarkTextarea;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	public WebElement submitButton;
	
	// Login methods
	private void enterUserName()
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		driverUtilities.get().typeIntoTextBox(userNameTextBox, Settings.userId);
	}
	
	private void enterPassword()
	{
		driverUtilities.get().clearTextBox(passwordTextBox);
		driverUtilities.get().typeIntoTextBox(passwordTextBox, EncryptDecPassword.decrypt(Settings.password));
	}
	
	private void clickOnLoginButton()
	{
		driverUtilities.get().clickOnElement(loginButton);
		try {Thread.sleep(200);}catch(InterruptedException e) {}
	}
	
	public void doLoginWithValidCredentials()
	{
		enterUserName();
		enterPassword();
		clickOnLoginButton();
	}
	
	public void enterOtp()
	{
		String otp = "527175";
		try {driverUtilities.get().waitForElementToBePresent2("//div[contains(@class,'otp-login-sec')]//input[1]");}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(@class,'otp-login-sec')]//input[1]"));
		try {
			driverUtilities.get().pasteData(otp);
		} catch (Exception e) {}
		try {Thread.sleep(5000);}catch(InterruptedException e) {}
	}
	
	public void verifySuccessLogin()
	{
		try {driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Dashboard')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Dashboard')]")));
	}
	
	public void waitForSeconds(String time)
	{
		try{ Thread.sleep( 1000*Integer.parseInt(time) );}catch( InterruptedException e ){}
	}
	
	// Search page methods
	public void verifySearchForNoticesPage()
	{
		Assert.assertTrue("Search For Notices heading not displayed", driverUtilities.get().isElementDisplayed(searchForNoticesHeading));
		Assert.assertTrue("Notice number textbox not displayed", driverUtilities.get().isElementDisplayed(noticeNumberTextBox));
		Assert.assertTrue("Search button not displayed", driverUtilities.get().isElementDisplayed(searchButton));
	}
	
	public void enterNoticeNumberFromTempFile(String key)
	{
		String noticeNumber = "";
		try {
			noticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		} catch (IOException e) {
			noticeNumber = "";
		}
		driverUtilities.get().clearTextBox(noticeNumberTextBox);
		driverUtilities.get().typeIntoTextBox(noticeNumberTextBox, noticeNumber);
	}
	
	public void enterNoticesNumberFromTempFile(String key1, String key2)
	{
		String citationNumbers = key1+","+key2;
		driverUtilities.get().clearTextBox(noticeNumberTextBox);
		driverUtilities.get().typeIntoTextBox(noticeNumberTextBox, citationNumbers);
	}
	
	public void clickOnButtonFromTopBar(String buttonName)
	{
		WebElement button = driverUtilities.get().getWebElement("//div[contains(@class,'justify-center')]//button[contains(text(),'"+buttonName+"')]");
		driverUtilities.get().clickOnElement(button);
	}
	
	public void clickSearchButton()
	{
		driverUtilities.get().clickOnElement(searchButton);
	}

	public void clickSearchLinkFromSearchResultPage()
	{
		driverUtilities.get().clickOnElement(searchLinkFromResults);
	}
	
	public void clickSearchResultLinkFromSearchResultPage()
	{
		driverUtilities.get().clickOnElement(searchResultLinkFromResults);
	}
	
	public void verifySearchCitationResults(String expectedNoticeNumber)
	{
		WebElement searchTable = driverUtilities.get().getWebElement("//h2[contains(@class,'text-xl font-medium text-gray')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(searchTable));
		
		WebElement citationSearched = driverUtilities.get().getWebElement("//h5[contains(text(),'"+expectedNoticeNumber+"')]/preceding-sibling::p[normalize-space(contains(text(),'Notice Number'))]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(citationSearched));
	}

	public void verifyCitationIssueDate()
	{
		String date = Util.getCurrentSystemDate("MM/dd/yyyy");
		WebElement citationDate = driverUtilities.get().getWebElement("//h5[contains(text(),'"+date+"')]/preceding-sibling::p[normalize-space(contains(text(),'Issue date'))]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(citationDate));
	}
	
	public void verifySearchCitationResultsPlate(String expectedNoticeNumber)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//h5[contains(text(),'"+expectedNoticeNumber+"')]/preceding-sibling::p[normalize-space(contains(text(),'Plate/State'))]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(citationSearched));
	}
	
	public void verifySearchCitationResultsVioDesc(String expectedNoticeNumber)
	{
		System.out.println("Expected vio Desc:="+expectedNoticeNumber);
		WebElement citationSearched = driverUtilities.get().getWebElement("//p[contains(text(),'Violation')]/following-sibling::h5");
		String actualDesc = driverUtilities.get().getElementText(citationSearched);
		System.out.println("Actual vio Desc:="+actualDesc);
		Assert.assertTrue(actualDesc.contains(expectedNoticeNumber));
	}
	
	public void verifyCitationStatus(String status)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//p[contains(text(),'Status')]/following-sibling::h5[normalize-space(contains(text(),'"+status+"'))]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(citationSearched));
	}
	
	public void verifySearchCitationResultsOriFine(String expectedNoticeNumber)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//p[contains(text(),'Original Fine')]/following-sibling::h5");
		String actualDesc = driverUtilities.get().getElementText(citationSearched);
		Assert.assertTrue(actualDesc.contains(expectedNoticeNumber));
	}
	
	public void verifyLinkInSerchResult(String linkVal)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//button[contains(@class,'inline-flex items-center text-sm') and contains(text(),'"+linkVal+"')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(citationSearched));
	}
	
	public void verifyNoticeNUmberValue(String expectedNoticeNumber)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//input[contains(@id,'ticket_number')]");
		String actualDesc = driverUtilities.get().getElementAttribute(citationSearched,"value");
		Assert.assertTrue(actualDesc.contains(expectedNoticeNumber));
	}
	
	public void clickOnLinkOfCitation(String citationNumber)
	{
		WebElement lnk = driverUtilities.get().getWebElement("//input[contains(@id,'ticket_number')]");
	}
	
	public void verifySiteNameInSearchResult()
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//p[contains(text(),'Site Name')]/following-sibling::h5");
		String actualDesc = driverUtilities.get().getElementText(citationSearched);
		Assert.assertTrue(actualDesc.contains(Settings.clientName));
	}
	
	public void verifyNoticeCountInSearchResult(String count)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//p[normalize-space(contains(text(),'Total Notices'))]/following-sibling::h5[text()='"+count+"']");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(citationSearched));
	}
	
	public void clickOnLinkBasedOnCitationNumber(String link, String number)
	{
		WebElement citationSearched = driverUtilities.get().getWebElement("//h5[contains(text(),'"+number+"')]/preceding-sibling::p[normalize-space(contains(text(),'Notice Number'))]/parent::div/parent::div/preceding-sibling::div//button[contains(text(),'"+link+"')]");
		//driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), citationSearched);
		driverUtilities.get().clickOnElement(citationSearched);
	}
	
	public void clickOnLinkBasedOnCitationNumberNotVisible(String link, String number)
	{
		try
		{ 
			driverUtilities.get().getWebElement("//h5[contains(text(),'"+number+"')]/preceding-sibling::p[normalize-space(contains(text(),'Notice Number'))]/parent::div/parent::div/preceding-sibling::div//button[contains(text(),'"+link+"')]");
			Assert.fail(link+ "is visible, please verify by your self");
		}
		catch(NoSuchElementException e)
		{
			
		}
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
	
	public void verifyImagesUnderLabel(String count , String label)
	{
		int c = driverUtilities.get().getNumberOfElement("//*[contains(text(),'Images')]/following-sibling::*//img");
		Assert.assertEquals(c, Integer.parseInt(count));
	}
	
	public void verifyFieldValueFromFinancialPage(String field, String keyValue)
	{
		String path= "//label[contains(normalize-space(.), '"+field+"')]/parent::div/following-sibling::div/input";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		String text = driverUtilities.get().getAttribute(pathElement, "value");
		System.out.println("text:="+text);
		System.out.println("keyValue:="+keyValue);
		Assert.assertTrue(text.contains(keyValue));
	}
	
	public void verifyFieldValWithConfiguredFinancialPage(String field)
	{
		String serChrg=Settings.serviceCharge;
		String path= "//label[contains(normalize-space(.), '"+field+"')]/parent::div/following-sibling::div/input";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		String text = driverUtilities.get().getAttribute(pathElement, "value");
		Assert.assertTrue(text.equals(serChrg));
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
	
	@SuppressWarnings("deprecation")
	public void totalAmountSummation(String fine1 , String fine2)
	{
		WebElement C1_Fine = driverUtilities.get().getWebElement("//p[contains(text(),'Original Fine')]/following-sibling::h5");
		String C1_Fine_amount = driverUtilities.get().getElementText(C1_Fine);
		C1_Fine_amount = C1_Fine_amount.replaceAll("[^\\d.]", "");
		double c1_fine = Double.parseDouble(C1_Fine_amount);
		
		WebElement C2_Fine = driverUtilities.get().getWebElement("(//p[contains(text(),'Original Fine')]/following-sibling::h5)[2]");
		String C2_Fine_amount = driverUtilities.get().getElementText(C2_Fine);
		C2_Fine_amount = C2_Fine_amount.replaceAll("[^\\d.]", "");
		double c2_fine = Double.parseDouble(C2_Fine_amount);
		
		String onlineSiteCharge = Settings.serviceCharge;
		double serviceCharge = Double.parseDouble(onlineSiteCharge);
		
		double total_Charge = c1_fine+c2_fine+serviceCharge+serviceCharge;
		String total = String.valueOf(total_Charge);
		System.out.println("Total Calculated:="+total);
		
		WebElement total_Fine = driverUtilities.get().getWebElement("//p[contains(text(),'Total Amount')]/following-sibling::h5");
		String total_Fine_amount = driverUtilities.get().getElementText(total_Fine);
		System.out.println("Total From UI:="+total_Fine_amount);
		
		Assert.assertTrue(total_Fine_amount.contains(String.valueOf(total_Charge)));
	}
	
	@SuppressWarnings("deprecation")
	public void totalAmountSummation(String fine1)
	{
		//WebElement C1_Fine = driverUtilities.get().getWebElement("//p[contains(text(),'Original Fine')]/following-sibling::h5");
		//String C1_Fine_amount = driverUtilities.get().getElementText(C1_Fine);
		//C1_Fine_amount = C1_Fine_amount.replaceAll("[^\\d.]", "");
		double c1_fine = Double.parseDouble(fine1);
		
		String onlineSiteCharge = Settings.serviceCharge;
		double serviceCharge = Double.parseDouble(onlineSiteCharge);
		
		double total_Charge = c1_fine+serviceCharge;
		String total = String.valueOf(total_Charge);
		System.out.println("Total Calculated:="+total);
		
		WebElement total_Fine = driverUtilities.get().getWebElement("//*[contains(text(),'Total Amount')]/following-sibling::h5");
		String total_Fine_amount = driverUtilities.get().getElementText(total_Fine);
		System.out.println("Total From UI:="+total_Fine_amount);
		
		Assert.assertTrue(total_Fine_amount.contains(String.valueOf(total_Charge)));
	}
	
	@SuppressWarnings("deprecation")
	public void totalAmountSummationFromMakePaymentScreen(String fine1)
	{
		//WebElement C1_Fine = driverUtilities.get().getWebElement("//p[contains(text(),'Original Fine')]/following-sibling::h5");
		//String C1_Fine_amount = driverUtilities.get().getElementText(C1_Fine);
		//C1_Fine_amount = C1_Fine_amount.replaceAll("[^\\d.]", "");
		double c1_fine = Double.parseDouble(fine1);
		
		String onlineSiteCharge = Settings.serviceCharge;
		double serviceCharge = Double.parseDouble(onlineSiteCharge);
		
		double total_Charge = c1_fine+serviceCharge;
		String total = String.valueOf(total_Charge);
		System.out.println("Total Calculated:="+total);
		
		WebElement total_Fine = driverUtilities.get().getWebElement("//*[contains(text(),'Payment amount')]/parent::div/following-sibling::div/h5");
		String total_Fine_amount = driverUtilities.get().getElementText(total_Fine);
		System.out.println("Total From UI:="+total_Fine_amount);
		
		Assert.assertTrue(total_Fine_amount.contains(String.valueOf(total_Charge)));
	}
	
	public void checkHeaderCheckbox()
	{
		WebElement checkBox = driverUtilities.get().getWebElement("//div[contains(@class,'displayResult displycitysearchHeader')]//div[contains(@class,'form-group-checkbox2')]/label");
		driverUtilities.get().clickOnElement(checkBox);
	}
	
	
	
	
	
	
	public void enterLicensePlateFromTempFile(String key)
	{
		String plate = "";
		try {
			plate = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		} catch (IOException e) {
			plate = "";
		}
		driverUtilities.get().clearTextBox(licensePlateInput);
		driverUtilities.get().typeIntoTextBox(licensePlateInput, plate);
	}

	private String mapStateAbbrevToFull(String abbrev)
	{
		if(abbrev==null) return "";
		String a = abbrev.trim().toUpperCase();
		switch(a)
		{
			case "AL": return "Alabama";
			case "AK": return "Alaska";
			case "AZ": return "Arizona";
			case "AR": return "Arkansas";
			case "CA": return "California";
			case "CO": return "Colorado";
			case "CT": return "Connecticut";
			case "DE": return "Delaware";
			case "DC": return "District of Columbia";
			case "FL": return "Florida";
			case "GA": return "Georgia";
			case "HI": return "Hawaii";
			case "ID": return "Idaho";
			case "IL": return "Illinois";
			case "IN": return "Indiana";
			case "IA": return "Iowa";
			case "KS": return "Kansas";
			case "KY": return "Kentucky";
			case "LA": return "Louisiana";
			case "ME": return "Maine";
			case "MD": return "Maryland";
			case "MA": return "Massachusetts";
			case "MI": return "Michigan";
			case "MN": return "Minnesota";
			case "MS": return "Mississippi";
			case "MO": return "Missouri";
			case "MT": return "Montana";
			case "NE": return "Nebraska";
			case "NV": return "Nevada";
			case "NH": return "New Hampshire";
			case "NJ": return "New Jersey";
			case "NM": return "New Mexico";
			case "NY": return "New York";
			case "NC": return "North Carolina";
			case "ND": return "North Dakota";
			case "OH": return "Ohio";
			case "OK": return "Oklahoma";
			case "OR": return "Oregon";
			case "PA": return "Pennsylvania";
			case "RI": return "Rhode Island";
			case "SC": return "South Carolina";
			case "SD": return "South Dakota";
			case "TN": return "Tennessee";
			case "TX": return "Texas";
			case "UT": return "Utah";
			case "VT": return "Vermont";
			case "VA": return "Virginia";
			case "WA": return "Washington";
			case "WV": return "West Virginia";
			case "WI": return "Wisconsin";
			case "WY": return "Wyoming";
			default: return abbrev;
		}
	}

	public void selectLicenseProvinceOrStateFromTempFile(String key)
	{
		String stateShort = "";
		try {
			stateShort = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		} catch (IOException e) {
			stateShort = "";
		}
		String stateFull = mapStateAbbrevToFull(stateShort);
		driverUtilities.get().clearTextBox(licenseProvinceStateInput);
		driverUtilities.get().typeIntoTextBox(licenseProvinceStateInput, stateFull);
		stateFull = stateFull.toUpperCase();
		try {Thread.sleep(1000);} catch(InterruptedException e) {}
		WebElement option = driverUtilities.get().getWebElement("//*[contains(text(),'"+stateFull+"')]");
		driverUtilities.get().clickByjavaScript(option);
	}
	
	public void clearNoticeNumberAndLicensePlateFields()
	{
		driverUtilities.get().clearTextBox(noticeNumberTextBox);
		driverUtilities.get().clearTextBox(licensePlateInput);
	}
	
	public void verifyMessagePopup(String expectedMessage)
	{
		Assert.assertTrue("Validation message not displayed", driverUtilities.get().isElementDisplayed(validationMessage));
		String actualMessage = driverUtilities.get().getElementText(validationMessage);
		Assert.assertTrue("Expected message: " + expectedMessage + ", Actual message: " + actualMessage, 
			actualMessage.contains(expectedMessage));
	}

	public void enterSpecialCharactersIntoNoticeAndLicense()
	{
		driverUtilities.get().clearTextBox(noticeNumberTextBox);
		driverUtilities.get().clearTextBox(licensePlateInput);
		driverUtilities.get().typeIntoTextBox(noticeNumberTextBox, "!@#$%^&*()_+{}");
		driverUtilities.get().typeIntoTextBox(licensePlateInput, "!@#$%^&*()_+{}");
	}

	public void verifyNoSpecialCharactersInNoticeAndLicense()
	{
		String noticeVal = driverUtilities.get().getAttribute(noticeNumberTextBox, "value");
		String plateVal = driverUtilities.get().getAttribute(licensePlateInput, "value");
		boolean noticeHasSpecial = noticeVal != null && noticeVal.matches(".*[^A-Za-z0-9].*");
		boolean plateHasSpecial = plateVal != null && plateVal.matches(".*[^A-Za-z0-9].*");
		Assert.assertFalse(noticeHasSpecial);
		Assert.assertFalse(plateHasSpecial);
	}
	
	public void verifyCancelForm(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//p[contains(normalize-space(.), 'Cancel Notice')]")));
		String citationNo = driverUtilities.get().getElementText(driverUtilities.get().getWebElement("//span[contains(normalize-space(.), 'Selected Notice Numbers')]/following-sibling::textarea"));
		Assert.assertTrue(citationNo.contains(citationNumber));
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
		driverUtilities.get().clickOnElement(enterNoteTextarea);
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
	
	public void verifyNoteFieldMandatoryMessage()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//*[contains(text(),'Field is required.')]"));
	}
	
	public void clickOnViewAllSupportNotesLink()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'View all support notes')]"));
	}
	
	public void verifyNoteAddedUnderCitationInfo(String value)
	{
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'All Support Notes')]"));
		//driverUtilities.get().scrollDownWebPage();
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'All Support Notes')]/ancestor::div/following-sibling::div//table/tbody/tr//*[contains(text(),'"+value+"')]")));
	}
	
	public void verifyDownloadLinkUnderCitationInfo(String value)
	{
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'All Support Notes')]"));
		//driverUtilities.get().scrollDownWebPage();
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'All Support Notes')]/ancestor::div/following-sibling::div//table/tbody/tr//*[contains(text(),'"+value+"')]/ancestor::td/following-sibling::td/a[contains(text(),'Download')]")));
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
	
	public void verifyPaymentAmount(String val1 , String val2, String ticketCounts)
	{
		val1 = val1.replaceAll("[^\\d.]", "");
		val2 = val2.replaceAll("[^\\d.]", "");
		
		Double fine1 = Double.parseDouble(val1);
		Double fine2 = Double.parseDouble(val2);
		Integer counts = Integer.parseInt(ticketCounts);
		
		Double sum = ( (fine1+fine2)+( Double.parseDouble(Settings.serviceCharge)*counts) );
		String toatlValue = sum.toString();
		System.out.println("toatlValue:="+toatlValue);
		String valPath = "//*[contains(normalize-space(.),'Payment amount')]/parent::div/following-sibling::div/h5";
		WebElement valPathEle = driverUtilities.get().getWebElement(valPath);
		String uiAmount = driverUtilities.get().getElementText(valPathEle);
		System.out.println("uiAmount:="+uiAmount);
		Assert.assertTrue(uiAmount.contains(toatlValue));
	}
	
	public void clickOnMakePaymentButton()
	{
		int c = driverUtilities.get().getNumberOfElement("//button[text()='Make Payment']");
		WebElement makePaymentButton = driverUtilities.get().getWebElement("(//button[text()='Make Payment'])["+c+"]");
		driverUtilities.get().makeElementVisibleIntoScreen(makePaymentButton);
		try{driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//h5[contains(text(),'Make Payment')]"));}catch(NoSuchElementException e) {}
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), makePaymentButton);
		try{driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Download Receipt')]");}catch(TimeoutException e) {}
	}
	
	public void verifyLanelOnScreen(String text)
	{
		String path= "//*[contains(text(),'"+text+"')]";
		try {driverUtilities.get().waitForElementToBePresent2(path);}catch(TimeoutException e) {}
		int c = driverUtilities.get().getNumberOfElement(path);
		path= "(//*[contains(text(),'"+text+"')])["+c+"]";
		driverUtilities.get().waitForElementToBePresent2(path);
		WebElement pathEle = driverUtilities.get().getWebElement(path);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathEle));
	}
	
	public void verifyClientAddressOnPaymentRec()
	{
		String addressString= "//*[contains(text(),'"+Settings.clientAdd1+"')]";
		int c = driverUtilities.get().getNumberOfElement(addressString);
		addressString= "(//*[contains(text(),'"+Settings.clientAdd1+"')])["+c+"]";
		try{driverUtilities.get().waitForElementToBePresent2(addressString);}catch(TimeoutException e) {}
		WebElement addressElement = driverUtilities.get().getWebElement(addressString);
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(addressElement));}catch(AssertionError e) {Assert.fail("No addess line 1");}
		
		addressString= "//*[contains(normalize-space(.), '"+Settings.clientAdd2+"')]";
		c = driverUtilities.get().getNumberOfElement(addressString);
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("(//*[contains(normalize-space(.), '"+Settings.clientAdd2+"')])["+c+"]")));}catch(AssertionError e) {Assert.fail("No addess line 2");}
	}
	
	public void clickOnBackButtonOfPaymentScreen()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//a[contains(text(),'Back')]"));
	}
	
	public void verifyCitationStatus(String number , String status)
	{
		WebElement ele = driverUtilities.get().getWebElement("//h5[contains(text(),'"+number+"')]/ancestor::div/following-sibling::div//p[contains(text(),'Status')]/following-sibling::h5[contains(text(),'"+status+"')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(ele));
	}
	
	public void verifyCitationVioDescription(String number , String vioDesc)
	{
		WebElement ele = driverUtilities.get().getWebElement("//h5[contains(text(),'"+number+"')]/ancestor::div/following-sibling::div/p[contains(text(),'Violation')]/following-sibling::h5[normalize-space(contains(text(),'"+vioDesc+"'))]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(ele));
	}
	
	public void verifyCitationFine(String number , String fine)
	{
		WebElement ele = driverUtilities.get().getWebElement("//h5[contains(text(),'"+number+"')]/ancestor::div/following-sibling::div//p[contains(text(),'Original Fine')]/following-sibling::h5[contains(text(),'"+fine+"')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(ele));
	}
	
	public void verifyMessageOnMakePaymentScreen(String message)
	{
		WebElement messageEle = driverUtilities.get().getWebElement("//*[contains(text(),'"+message+"')]");
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(messageEle));
	}
	
	public void enterValuesInToCardPayemnt(String keyValue, String fieldPlaceHolder)
	{
		String path= "//input[@placeholder='"+fieldPlaceHolder+"']";
		WebElement ele = driverUtilities.get().getWebElement(path);
		driverUtilities.get().typeIntoTextBox(ele, keyValue);
	}
	
	public void enterCardDetails()
	{
		driverUtilities.get().typeIntoTextBox(cardNumberTextbox, Settings.cardNumber);
		try{driverUtilities.get().typeIntoTextBox(expiryTextbox, Settings.expiry);}catch(NoSuchElementException e) {}
		try{driverUtilities.get().typeIntoTextBox(cvvextbox, Settings.cvv);}catch(NoSuchElementException e) {}
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
	
	public void closePopup()
	{
		String closeXPath = "//div[contains(@class,'close')]//button";
		int c = driverUtilities.get().getNumberOfElement(closeXPath);
		System.out.println("Total close button:="+c);
		try {Thread.sleep(1000);}catch(InterruptedException e1) {}
		
		for(int i=c ; i>=1; i-- )
		{
			closeXPath = "(//div[contains(@class,'close')]//button)["+i+"]";
			System.out.println("closeXPath:="+closeXPath);
			WebElement e = driverUtilities.get().getWebElement(closeXPath);
			try {Thread.sleep(1000);}catch(InterruptedException e1) {}
			driverUtilities.get().clickOnElement(e);
			try {Thread.sleep(1000);}catch(InterruptedException e1) {}
		}
	}
	
	// Add Discount popup methods
	public void verifyOriginalFineAmount(String expectedFine)
	{
		String actualFine = driverUtilities.get().getAttribute(originalFineAmountInput, "value");
		Assert.assertTrue("Original fine amount mismatch. Expected: " + expectedFine + ", Actual: " + actualFine, 
			actualFine.contains(expectedFine.replaceAll("[^\\d.]", "")));
	}
	
	public void verifyNewFineAmountDue(String expectedFine)
	{
		String actualFine = driverUtilities.get().getAttribute(newFineAmountDueInput, "value");
		Assert.assertTrue("New fine amount due mismatch. Expected: " + expectedFine + ", Actual: " + actualFine, 
			actualFine.contains(expectedFine.replaceAll("[^\\d.]", "")));
	}
	
	public void clickSubmitButtonOfAddDiscountPopup()
	{
		driverUtilities.get().clickOnElement(submitButton);
	}
	
	public void verifyMandatoryFieldMessage(String expectedMessage)
	{
		WebElement messageElement = driverUtilities.get().getWebElement("//*[contains(text(),'" + expectedMessage + "')]");
		Assert.assertTrue("Mandatory field message not displayed: " + expectedMessage, 
			driverUtilities.get().isElementDisplayed(messageElement));
	}
	
	public void enterDiscountAmount(String discountAmount)
	{
		driverUtilities.get().clearTextBox(discountAmountInput);
		driverUtilities.get().typeIntoTextBox(discountAmountInput, discountAmount);
	}
	
	public void enterDiscountDays(String discountDays)
	{
		driverUtilities.get().clearTextBox(discountDaysInput);
		driverUtilities.get().typeIntoTextBox(discountDaysInput, discountDays);
	}
	
	public void verifyDiscountEndDate(String days)
	{
		String expectedDate = Util.getFutureDate(Integer.parseInt(days));
		WebElement discountEndDateInput = driverUtilities.get().getWebElement("//input[@placeholder='MM/DD/YYYY']");
		String actualDate = driverUtilities.get().getAttribute(discountEndDateInput, "value");
		Assert.assertTrue("Discount end date mismatch. Expected: " + expectedDate + ", Actual: " + actualDate, 
			actualDate.contains(expectedDate));
	}
	
	public void verifyDiscountedAmount(String originalFine, String discountAmount)
	{
		double originalFineValue = Double.parseDouble(originalFine.replaceAll("[^\\d.]", ""));
		double discountAmountValue = Double.parseDouble(discountAmount);
		double expectedDiscountedAmount = originalFineValue - discountAmountValue;
		
		String actualDiscountedAmount = driverUtilities.get().getAttribute(newFineAmountDueInput, "value");
		double actualValue = Double.parseDouble(actualDiscountedAmount.replaceAll("[^\\d.]", ""));
		
		Assert.assertTrue("Discounted amount mismatch. Expected: " + expectedDiscountedAmount + ", Actual: " + actualValue, 
			Math.abs(expectedDiscountedAmount - actualValue) < 0.01);
	}
	
	public String verifyDiscountedAmountAndGetValue(String originalFine, String discountAmount)
	{
		double originalFineValue = Double.parseDouble(originalFine.replaceAll("[^\\d.]", ""));
		double discountAmountValue = Double.parseDouble(discountAmount);
		double expectedDiscountedAmount = originalFineValue - discountAmountValue;
		
		String actualDiscountedAmount = driverUtilities.get().getAttribute(newFineAmountDueInput, "value");
		double actualValue = Double.parseDouble(actualDiscountedAmount.replaceAll("[^\\d.]", ""));
		
		Assert.assertTrue("Discounted amount mismatch. Expected: " + expectedDiscountedAmount + ", Actual: " + actualValue, 
			Math.abs(expectedDiscountedAmount - actualValue) < 0.01);
		
		return actualDiscountedAmount;
	}
	
	public void enterRemark()
	{
		String remark = "Test discount remark " + Util.generateRandomNumber(5);
		driverUtilities.get().typeIntoTextBox(remarkTextarea, remark);
	}
	
	public void clickSubmitButtonFromAddDiscountPopup()
	{
		driverUtilities.get().clickOnElement(submitButton);
	}
}
