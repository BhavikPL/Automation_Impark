package pages;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import config.Settings;import io.cucumber.java.en.Then;
import path.Path;
import utility.GenerateRandomData;
import utility.Util;

public class AppealManagementPage extends BasePage
{
	@FindBy(how = How.XPATH, using = "//input[@name='citation_number']")
	public WebElement citationNumberTextbox;
	
	@FindBy(how=How.XPATH, using="//button[text()='Submit']")
	public WebElement submitButton;
	
	@FindBy(how=How.XPATH, using="//input[@name='card_number']")
	public WebElement cardNumberTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='expiry']")
	public WebElement expiryTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='cvc']")
	public WebElement cvvextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='termofpayment']")
	public WebElement refundPolicyCheckbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='attachments']")
	public WebElement chooseFileButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Appeal Management')]/parent::li")
	public WebElement appealManagementOption;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.),'Change Reason')]/following-sibling::select")
	public WebElement changeReasonList;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Appeal Rejected Fee')]/parent::div/following-sibling::div/input")
	public WebElement appealRejectedFeeTextbox;
	
	public void enterCitationNumberInSearchBox(String citation)
	{
		driverUtilities.get().typeIntoTextBox(citationNumberTextbox, citation);
	}
	
	public void verifyTickteSearchedBasedOnCitationAR(String citation)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[@id='tbl-main-download']/table/tbody/tr/td/a[contains(text(),'"+citation+"')]")));
	}
	
	public void naigateInToTicketByAppealDate(String citation)
	{
		String path="//div[@id='tbl-main-download']/table/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/preceding-sibling::td//a";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		driverUtilities.get().clickOnElement(pathElement);
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		//driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Appeal Workflow')]");
	}
	
	public void naigateInToCitation(String citation)
	{
		String path="//div[@id='tbl-main-download']/table/tbody/tr/td/a[contains(text(),'"+citation+"')]";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		driverUtilities.get().clickOnElement(pathElement);
	}
	
	public void selectFromList(String listName, String option)
	{
		String listPath = "//label[contains(normalize-space(.),'"+listName+"')]/following-sibling::select";
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
	
	public String enterValueInToField(String label, String elementType)
	{
		String typeEle = "";
		String data = GenerateRandomData.getReason();
		if(elementType.equalsIgnoreCase("textarea"))
		{
			typeEle = "textarea";
		}
		if(elementType.equalsIgnoreCase("textbox"))
		{
			typeEle = "input";
		}
		
		String path = "//label[contains(normalize-space(.),'"+label+"')]/following-sibling::"+typeEle;
		System.out.println("path:="+path);
		driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement(path), data);
		return data;
	}
	
	public void verifyConfirmationPopup()
	{
		String path = "//*[contains(normalize-space(.),'This status change is permanent and can’t be changed again.')]";
		int c = driverUtilities.get().getNumberOfElement(path);
		path = "(//*[contains(normalize-space(.),'This status change is permanent and can’t be changed again.')])["+c+"]";
		WebElement pathElement = driverUtilities.get().getWebElement(path);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathElement));
	}
	
	public void clickOnToTheButtonOfpopup(String buttonName)
	{
		String path= "//button[contains(text(),'"+buttonName+"')]";
		WebElement button = driverUtilities.get().getWebElement(path);
		driverUtilities.get().clickOnElement(button);
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
	
	public void verifyPayButtonNotPresent()
	{
		String path= "//button[contains(text(),'Pay')]";
		try {driverUtilities.get().getWebElement(path); Assert.fail("Pay button is visible");}catch(NoSuchElementException e) {}
	}
	
	public void navigateToTab(String tabName , String hrefLink)
	{
		try{driverUtilities.get().keyPress("page up");}catch(AWTException e) {}
		try{driverUtilities.get().keyRelease("page up");}catch(AWTException e) {}
		String path= "//a[contains(normalize-space(.),'"+tabName+"') and @href='"+hrefLink+"']/parent::li";
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(driverUtilities.get().getWebElement(path));
		WebElement tabLink = driverUtilities.get().getWebElement(path);
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'Appeal Workflow')]"));
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().clickOnElement(tabLink);
	}
	
	public void clickOnSubmit()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(submitButton);
		driverUtilities.get().clickOnElement(submitButton);
	}
	
	public void clickOnPayButtonFromAppeal()
	{
		String isAppealPay = Settings.isPayFromAppeal;
		if(isAppealPay.equalsIgnoreCase("true"))
		{
			String path= "//button[contains(text(),'Pay')]";
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path));
		}
		else
		{
			Assert.fail("Pay from appeal is not available for client "+Settings.clientName);
		}
	}
	
	public void clickOnPayButtonFromLinked()
	{
		String isLinkedPay = Settings.isPayFromLinked;
		if(isLinkedPay.equalsIgnoreCase("true"))
		{
			String path= "(//button[contains(text(),'Pay')])[2]";
			try
			{
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path));
			}
			catch(NoSuchElementException e)
			{
				String path2= "//button[contains(text(),'Pay')]";
				driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path2));
			}
		}
		else
		{
			Assert.fail("Pay from linked tab is not available for client "+Settings.clientName);
		}
	}
	
	public void choosePaymentMethod(String paymentMethod)
	{
		String path= "//*[contains(text(),'Choose your payment method')]/following-sibling::div//button[contains(text(),'"+paymentMethod+"')]";
		WebElement tabLink = null;
		try{tabLink = driverUtilities.get().getWebElement(path);}catch(NoSuchElementException e) { Assert.fail(paymentMethod +" payment is not available for client "+Settings.clientName);}
		driverUtilities.get().clickOnElement(tabLink);
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
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
	
	public void enterDiffCardDetails(String cardType)
	{
		//driverUtilities.get().makeElementVisibleIntoScreen(makePaymentButton);
		driverUtilities.get().clearTextBox(cardNumberTextbox);
		if(cardType.equalsIgnoreCase("visa"))
		{
			driverUtilities.get().typeIntoTextBox(cardNumberTextbox, Settings.visaCardNumber);
		}
		if(cardType.equalsIgnoreCase("mastercard"))
		{
			driverUtilities.get().typeIntoTextBox(cardNumberTextbox, Settings.mastercardCardNumber);
		}
		if(cardType.equalsIgnoreCase("american express"))
		{
			driverUtilities.get().typeIntoTextBox(cardNumberTextbox, Settings.amexCardNumber);
		}
		driverUtilities.get().typeIntoTextBox(expiryTextbox, Settings.expiry);
	}
	
	public void cardTypeIdentified(String cardType)
	{
		
		if(cardType.equalsIgnoreCase("american express"))
		{
			String srcString = driverUtilities.get().getAttribute(driverUtilities.get().getWebElement("//img[contains(@alt,'card')]"), "src");
			System.out.println("srcString:="+srcString);
			Assert.assertTrue(srcString.contains("amex"));
		}
		if(cardType.equalsIgnoreCase("mastercard"))
		{
			String srcString = driverUtilities.get().getAttribute(driverUtilities.get().getWebElement("//img[contains(@alt,'card')]"), "src");
			System.out.println("srcString:="+srcString);
			Assert.assertTrue(srcString.contains("masterCard"));
		}
		if(cardType.equalsIgnoreCase("visa"))
		{
			String srcString = driverUtilities.get().getAttribute(driverUtilities.get().getWebElement("//img[contains(@alt,'card')]"), "src");
			System.out.println("srcString:="+srcString);
			Assert.assertTrue(srcString.contains("visa"));
		}
	}
	
	public void enterInvalidCardDetails()
	{
		driverUtilities.get().clearTextBox(cardNumberTextbox);
		driverUtilities.get().typeIntoTextBox(cardNumberTextbox, Settings.invalidCardNumber);
		driverUtilities.get().typeIntoTextBox(expiryTextbox, Settings.expiry);
		driverUtilities.get().typeIntoTextBox(cvvextbox, Settings.cvv);
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
	
	public void acceptRefundTermsAndCondition()
	{
		try{driverUtilities.get().makeElementVisibleIntoScreen(refundPolicyCheckbox);}catch(NoSuchElementException e) {}
		try{driverUtilities.get().clickOnElement(refundPolicyCheckbox);}catch(NoSuchElementException e) {}
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
	
	public void verifyPaymentSource(String paymentSource)
	{
		String path1= "//label[contains(text(),'Payment Source')]/following-sibling::*//*[contains(text(),'"+paymentSource+"')]";
		WebElement pathEle = driverUtilities.get().getWebElement(path1);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathEle));
	}
	
	public void verifyLabelAndKeyValue(String label , String value)
	{
		String originalFinePath= "//label[contains(normalize-space(.), '"+label+"')]/parent::div/following-sibling::div/input";
		WebElement originalFineElement = driverUtilities.get().getWebElement(originalFinePath);
		String originalFineValue = driverUtilities.get().getAttribute(originalFineElement, "value");
		Assert.assertTrue(originalFineValue.contains(value));
	}
	
	public void verifyServiceFee()
	{
		String isServiceChr=Settings.isServiceCharge;
		if(isServiceChr.equalsIgnoreCase("true"))
		{
			String path1= "//label[contains(normalize-space(.), 'Service Fee')]/parent::div/following-sibling::div/input";
			WebElement pathEle = driverUtilities.get().getWebElement(path1);
			String attValue = driverUtilities.get().getAttribute(pathEle, "value");
			Double doubleValue = Double.parseDouble(Settings.serviceCharge);
			System.out.println("doubleValue:="+doubleValue);
			Assert.assertTrue(Double.parseDouble(attValue) == doubleValue);
		}
	}
	
	public void verifyLabelAndKeyValueContactInformation(String label , String value)
	{
		String elementPath= "//p[contains(normalize-space(.),'"+label+"')]/parent::div/following-sibling::div/h6";
		WebElement element = driverUtilities.get().getWebElement(elementPath);
		String elementValue = driverUtilities.get().getElementText(element);
		Assert.assertTrue(elementValue.contains(value));
	}
	
	public void verifyPayAmountContactInformation(String value)
	{
		Double originalFine = Double.parseDouble(value);
		Double serviceCharge = Double.parseDouble(Settings.serviceCharge);
		Double totalPay = originalFine + serviceCharge;
		System.out.println("totalPay:="+totalPay);
		
		String payAmoutStringPath= "//p[contains(normalize-space(.),'Payment amount')]/parent::div/following-sibling::div/h6";
		WebElement payAmoutAsElement = driverUtilities.get().getWebElement(payAmoutStringPath);
		String payAmoutValue = driverUtilities.get().getElementText(payAmoutAsElement);
		payAmoutValue = payAmoutValue.substring(1);
		System.out.println("payAmoutValue:="+payAmoutValue);
		
		try
		{
			driverUtilities.get().getWebElement("//label[contains(text(),'Card number (Only last 4 digit)')]");
			Assert.assertTrue(payAmoutValue.contains(value));
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(totalPay.equals(Double.parseDouble(payAmoutValue)));
		}
	}
	
	public void verifyPayAmountWithChargeBackFeeContactInformation(String value)
	{
		Double fine = Double.parseDouble(value);
		Double serviceCharge = Double.parseDouble(Settings.serviceCharge);
		Double chargeBackFee = Double.parseDouble(Settings.chargeBackFee);
		try
		{
			//int c = driverUtilities.get().getNumberOfElement("//button[text()='Make Payment']");
			//WebElement makePaymentButton = driverUtilities.get().getWebElement("(//button[text()='Make Payment'])["+c+"]");
			//driverUtilities.get().makeElementVisibleIntoScreen(makePaymentButton);
			driverUtilities.get().getWebElement("//label[contains(text(),'Card number (Only last 4 digit)')]");
			serviceCharge = 0.00;
		}
		catch(NoSuchElementException e)
		{
	
		}
		Double totalPay = fine + serviceCharge+chargeBackFee;
		System.out.println("totalPay:="+totalPay);
		
		String path1= "//p[contains(normalize-space(.),'Payment amount')]/parent::div/following-sibling::div/h6";
		WebElement pathEle = driverUtilities.get().getWebElement(path1);
		String pathEleValue = driverUtilities.get().getElementText(pathEle);
		pathEleValue = pathEleValue.substring(1);
		System.out.println("pathEleValue:="+pathEleValue);
		Assert.assertTrue(totalPay.equals(Double.parseDouble(pathEleValue)));
	}
	
	public void verifyPayDateContactInformation()
	{
		String path1= "//p[contains(normalize-space(.),'Payment date')]/parent::div/following-sibling::div/h6";
		WebElement pathEle = driverUtilities.get().getWebElement(path1);
		String payDateScreenValue = driverUtilities.get().getElementText(pathEle);
		System.out.println("payDateScreenValue:="+payDateScreenValue);
		
		String getTodayDate = Util.getCurrentSystemDate("MM/dd/yyyy");
		System.out.println("getTodayDate:="+getTodayDate);
		Assert.assertTrue(payDateScreenValue.equals(getTodayDate));
	}
	
	public void verifyIneligibleForAppealMessage()
	{
		String messageString= "//p[contains(normalize-space(.),'The appeal request is more than')]";
		WebElement messageElement = driverUtilities.get().getWebElement(messageString);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(messageElement));
		
		messageString= "//p[contains(normalize-space(.),'and ineligible for appeal')]";
		messageElement = driverUtilities.get().getWebElement(messageString);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(messageElement));
	}
	
	public void verifyIneligibleForAppealMessageNotPopulated()
	{
		String messageString= "//p[contains(normalize-space(.),'ineligible for appeal')]";
		try {driverUtilities.get().getWebElement(messageString); Assert.fail("Ineligible for appeal message is populated");}catch(NoSuchElementException e) {}
	}
	
	public void verifyValidationMessageForRaisingAnAppeal()
	{
		String firstNameMessage = "//*[contains(text(),'Enter first name')]";
		WebElement firstNameMessageAsElement = driverUtilities.get().getWebElement(firstNameMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(firstNameMessageAsElement));
		
		String lastNameMessage = "//*[contains(text(),'Enter last name')]";
		WebElement lastNameMessageAsElement = driverUtilities.get().getWebElement(lastNameMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(lastNameMessageAsElement));
		
		String emailMessage = "//*[contains(text(),'Enter email')]";
		WebElement emailMessageAsElement = driverUtilities.get().getWebElement(emailMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(emailMessageAsElement));
		
		String phoneNumberMessage = "//*[contains(text(),'Enter telephone')]";
		WebElement phoneNumberMessageAsElement = driverUtilities.get().getWebElement(phoneNumberMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(phoneNumberMessageAsElement));
		
		String addressLineMessage = "//*[contains(text(),'Enter address')]";
		WebElement addressLine1MessageAsElement = driverUtilities.get().getWebElement(addressLineMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(addressLine1MessageAsElement));
		
		String cityMessage = "//*[contains(text(),'Enter city')]";
		WebElement cityMessageAsElement = driverUtilities.get().getWebElement(cityMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(cityMessageAsElement));
		
		
		String appealAdditinalReasonMessage = "//*[contains(text(),'Enter appeal additional reason')]";
		WebElement appealAdditionalReasonMessageElement = driverUtilities.get().getWebElement(appealAdditinalReasonMessage);
		driverUtilities.get().makeElementVisibleIntoScreen(appealAdditionalReasonMessageElement);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealAdditionalReasonMessageElement));
		
		String appealReasonMessage = "//*[contains(text(),'Select appeal reason')]";
		WebElement appealReasonMessageElement = driverUtilities.get().getWebElement(appealReasonMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealReasonMessageElement));
		
		String conditionMessage = "//*[contains(text(),'Must select all terms and conditions.')]";
		WebElement conditionMessageElement = driverUtilities.get().getWebElement(conditionMessage);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(conditionMessageElement));
	}
	
	public void clickOnChooseFileButtonAndUpload( String fileFormat ) throws AWTException
	{
		driverUtilities.get().makeElementVisibleIntoScreen(chooseFileButton);
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), chooseFileButton);
		try{Thread.sleep(1500);}catch(InterruptedException e){}
		
		switch( fileFormat )
		{
			case "jpeg":
			{
				String iPath=Path.jpeg;
				driverUtilities.get().fileUpload(Path.jpeg);
				break;
			}
			case "jpg":
			{
				String iPath=Path.jpg;
				driverUtilities.get().fileUpload(Path.jpg);
				break;
			}
			case "png":
			{
				String iPath=Path.prayerImagePath;
				driverUtilities.get().fileUpload(Path.prayerImagePath);
				break;
			}
			case "gif":
			{
				String iPath=Path.gif;
				driverUtilities.get().fileUpload(Path.gif);
				break;
			}
			case "bmp":
			{
				String iPath=Path.bmp;
				driverUtilities.get().fileUpload(Path.bmp);
				break;
			}
			case "pdf":
			{
				String iPath=Path.pdf;
				driverUtilities.get().fileUpload(Path.pdf);
				break;
			}
			default:
			{
				
			}
		}
	}
	
	public void verifyUploadedFilesCountInPreview(String count)
	{
		int c = driverUtilities.get().getNumberOfElement("//div[contains(@class,'cstm-appeal-preview-images')]//div[contains(@class,'appeal-preview-img')]//img");
		Assert.assertEquals(Integer.parseInt(count), c);
	}
	
	public void verifyAttachementsForCitationAppealForm(String count)
	{
		int c = driverUtilities.get().getNumberOfElement("//div[contains(@class,'cstm-attactment')]//div[contains(@class,'AppImage')]//img");
		Assert.assertEquals(Integer.parseInt(count), c);
	}
	
	public void navigateToNoticeFromAppealWotkFlow()
	{
		String noticePath = "//a[contains(text(),'Notice')]/parent::li";
		int c = driverUtilities.get().getNumberOfElement(noticePath);
		noticePath = "(//a[contains(text(),'Notice')]/parent::li)["+c+"]";
		WebElement noticeTabLink = driverUtilities.get().getWebElement(noticePath);
		driverUtilities.get().moveCursorToAnElement(driverUtilities.get().getActions(), noticeTabLink);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), noticeTabLink);
	}
	
	public void verifyNoticeDetailsFromAppealWorkFlow(String address)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@class,'table-heading table-bordered')]/tbody/tr/td[contains(text(),'Admin')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@class,'table-heading table-bordered')]/tbody/tr/td[contains(text(),'Appeal Submit Notification')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@class,'table-heading table-bordered')]/tbody/tr/td/a[contains(text(),'Download')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@class,'table-heading table-bordered')]/tbody/tr/td[contains(text(),'"+address+"')]")));
	}
	
	public void verifyPayAmountWithNSFFeeContactInformation(String value)
	{
		Double fine = Double.parseDouble(value);
		Double serviceCharge = Double.parseDouble(Settings.serviceCharge);
		Double chargeBackFee = Double.parseDouble(Settings.NSFFee);
		Double totalPay = fine + serviceCharge+chargeBackFee;
		System.out.println("totalPay:="+totalPay);
		
		String path1= "//p[contains(normalize-space(.),'Payment amount')]/parent::div/following-sibling::div/h6";
		WebElement pathEle = driverUtilities.get().getWebElement(path1);
		String pathEleValue = driverUtilities.get().getElementText(pathEle);
		pathEleValue = pathEleValue.substring(1);
		System.out.println("pathEleValue:="+pathEleValue);
		Assert.assertTrue(totalPay.equals(Double.parseDouble(pathEleValue)));
	}
	
	public void verifyPayAmountWithNSFFeeContactInformationNoServiceChrg(String value)
	{
		Double fine = Double.parseDouble(value);
		System.out.println("fine:="+fine);
		Double nsfCharge = Double.parseDouble(Settings.NSFFee);
		System.out.println("chargeBackFee:="+nsfCharge);
		Double totalPay = fine+nsfCharge;
		System.out.println("totalPay:="+totalPay);
		
		String path1= "//p[contains(normalize-space(.),'Payment amount')]/parent::div/following-sibling::div/h6";
		WebElement pathEle = driverUtilities.get().getWebElement(path1);
		String pathEleValue = driverUtilities.get().getElementText(pathEle);
		pathEleValue = pathEleValue.substring(1);
		System.out.println("pathEleValue:="+pathEleValue);
		Assert.assertTrue(totalPay.equals(Double.parseDouble(pathEleValue)));
	}
	
	public void clickOnAppealManagementOption()
	{
		driverUtilities.get().clickOnElement(appealManagementOption);
	}
	
	public void verifyNoMessageForSuspendedToAppealPayment()
	{
		String message= "//*[contains(normalize-space(.), 'You have selected a citation that is currently in a suspended status as the result of an appeal submission. Would you like to procced with payment and close the pending appeal? By choosing this option, your appeal will be closed and payment will be applied.')]";
		int c = driverUtilities.get().getNumberOfElement(message);
		message = "(" + message + ")[" + c + "]";
		try{driverUtilities.get().getWebElement(message);Assert.fail("For susupended payment cannot do");}catch(NoSuchElementException e){}
	}
	
	public void verifyAppealWorkflowUpdateMessage()
	{
		driverUtilities.get().scrollUpWebPage();
		String path= "//*[contains(text(),'Appeal Workflow updated')]";
		WebElement pathEle = driverUtilities.get().getWebElement(path);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(pathEle));
	}
	
	public void selectChangeReason(String reasonIndex)
	{
		try 
		{
			driverUtilities.get().selectElementFromListIndex(changeReasonList, Integer.parseInt(reasonIndex));
		}
		catch(NoSuchElementException e)
		{
			Assert.fail("Change reason dropdown list is not avalible for client: "+Settings.clientName);
		}
	}
	
	public void verifyChangeReasonMessage()
	{
		try
		{
			driverUtilities.get().isElementDisplayed(changeReasonList);
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//p[contains(text(),'Reason is required')]")));
		}
		catch(NoSuchElementException e)
		{
			Assert.fail("Change reason dropdown list is not avalible for client: "+Settings.clientName);
		}
	}
	
	public String getAppealRejectedFees()
	{
		String value;
		try{value = driverUtilities.get().getAttribute(appealRejectedFeeTextbox, "value");}catch(NoSuchElementException e) {value="0";}
		return value;
	}
}
