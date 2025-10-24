package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mailosaur.MailosaurException;

import base.BasePage;
import config.Settings;
import utility.EmailOTPReader;
import utility.EncryptDecPassword;
import utility.GenerateRandomData;
import utility.Util;

public class PaymentProPage extends BasePage
{
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Citation')]/following-sibling::input")
	public WebElement citationTextbox;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'License Plate')]/following-sibling::input")
	public WebElement licensePlateTextbox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='recaptcha-anchor']")
	public WebElement recatchaCheckBox;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'recaptcha-checkbox-checkmark')]")
	public WebElement recatchaCheckmarkCheckBox;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search')]")
	public WebElement searchButton;
	
	@FindBy(how=How.XPATH, using="(//button[text()='Make Payment'])[1]")
	public WebElement makePaymentButton;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'displayResult')]//label")
	public WebElement selectAllTicketsCheckbox;
	
	@FindBy(how=How.XPATH, using="//button[contains(normalize-space(.), 'Yes, Continue')]")
	public WebElement yesContinueButton;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Same as user information')]/input")
	public WebElement billingAddressCheckbox;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Back')]")
	public WebElement backButton;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Start Appeals')]")
	public WebElement startAppealButton;
	
	public void enterCitation(String citationNumber)
	{
		try{driverUtilities.get().waitForElementToBePresent(citationTextbox);}catch(TimeoutException e) {}
		driverUtilities.get().clearTextBox(citationTextbox);
		driverUtilities.get().typeIntoTextBox(citationTextbox, citationNumber);
	}
	
	public void enterPlate(String plateNumber)
	{
		try{driverUtilities.get().waitForElementToBePresent(licensePlateTextbox);}catch(TimeoutException e) {}
		driverUtilities.get().clearTextBox(licensePlateTextbox);
		driverUtilities.get().typeIntoTextBox(licensePlateTextbox, plateNumber);
	}
	
	public void clickOnCaptcha()
	{
		try {driverUtilities.get().waitForElementToBePresent2("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]");}catch(TimeoutException e) {}
		try {driverUtilities.get().waitForElementToBePresent2("//div[contains(@class,'recaptcha-checkbox-checkmark')]");}catch(TimeoutException e) {}
		try {Thread.sleep(10000);}catch(InterruptedException e) {}
		//driverUtilities.get().setAttributeOfElement(recatchaCheckBox, "data-sitekey", "6LctsycrAAAAAOlQkUBQW4z-zTMxdujXp5NJbnd5");
		driverUtilities.get().enterIntoFrame(driverUtilities.get().getWebElement("//iframe[contains(@title, 'reCAPTCHA')]"));
		//driverUtilities.get().setAttributeOfElement(recatchaCheckBox, "data-sitekey", "6LctsycrAAAAAEvegP6Nd5-OOfXg7c5EUxFyaOFN");
		//driverUtilities.get().captchaAttSet();
		try {Thread.sleep(20000);}catch(InterruptedException e) {}
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), recatchaCheckmarkCheckBox);
		try {Thread.sleep(2000);}catch(InterruptedException e) {}
		driverUtilities.get().leaveFrame();
	}
	
	public void clickOnSearchButton()
	{
		try{driverUtilities.get().waitForElementToBePresent(searchButton);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(searchButton);
	}
	
	public void clickOnMakePaymentButton()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(makePaymentButton);
		driverUtilities.get().clickOnElement(makePaymentButton);
		driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Download Receipt')]");
		driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Download Receipt')]");
	}
	
	public void enterValuesInToCardPayemnt(String keyValue, String fieldPlaceHolder)
	{
		String path= "//input[@placeholder='"+fieldPlaceHolder+"']";
		WebElement ele = driverUtilities.get().getWebElement(path);
		driverUtilities.get().typeIntoTextBox(ele, keyValue);
	}
	
	public void verifyTotalPayableAmount(String oriFine)
	{
		Double originalFine = Double.parseDouble(oriFine);
		Double serviceCharge = Double.parseDouble(Settings.serviceCharge);
		Double totalPay = originalFine + serviceCharge;
		System.out.println("totalPay:="+totalPay);
		
		String payAmoutStringPath= "//h6[contains(text(),'Total Amount')]/parent::div/following-sibling::div/h5";
		WebElement payAmoutAsElement = driverUtilities.get().getWebElement(payAmoutStringPath);
		String payAmoutValue = driverUtilities.get().getElementText(payAmoutAsElement);
		payAmoutValue = payAmoutValue.substring(1);
		System.out.println("payAmoutValue:="+payAmoutValue);
		
		try
		{
			driverUtilities.get().getWebElement("//label[contains(text(),'Card number (Only last 4 digit)')]");
			Assert.assertTrue(payAmoutValue.contains(oriFine));
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(totalPay.equals(Double.parseDouble(payAmoutValue)));
		}
	}
	
	public void clickOnPayButtonFromPaymentPortal()
	{
		String isAppealPay = Settings.isPayFromPaymentPortal;
		if(isAppealPay.equalsIgnoreCase("true"))
		{
			String path= "//button[contains(text(),'Pay')]";
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(path));
		}
		else
		{
			Assert.fail("Pay from payment portal is not available for client "+Settings.clientName);
		}
	}
	
	public void verifyPageHasValue(String value)
	{
		String pathString = "//*[contains(normalize-space(.), '"+value+"')]";
		int c = driverUtilities.get().getNumberOfElement(pathString);
		pathString = "(//*[contains(normalize-space(.), '"+value+"')])["+c+"]";
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(pathString)));
	}
	
	public void clickOnLoginLink()
	{
		String login = Settings.isLoginFrmPaymentPortal;
		if(login.equalsIgnoreCase("true"))
		{
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//a[contains(@href,'login')]"));
		}
		else
		{
			Assert.fail("Login from payment portal is not present for clien "+Settings.clientName);
		}
	}
	 
	public void enterUserName()
	{
		driverUtilities.get().clearTextBox(driverUtilities.get().getWebElement("//input[contains(@placeholder,'Enter username')]"));
		driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement("//input[contains(@placeholder,'Enter username')]"), Settings.userId);
	}
	 
	public void enterPassword()
	{
		driverUtilities.get().clearTextBox(driverUtilities.get().getWebElement("//input[contains(@placeholder,'Enter password')]"));
		driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement("//input[contains(@placeholder,'Enter password')]"), EncryptDecPassword.decrypt(Settings.password));
	}
	
	public void clickOnLoginButton()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Log In')]"));
	}
	
	public void enterOtp() throws IOException, MailosaurException, AWTException
	{
		String otp = EmailOTPReader.getOtp2();
		System.out.println("otp is:="+otp);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(@class,'formgroup-main otp')]//input[1]"));
		driverUtilities.get().pasteData(otp);
		try {Thread.sleep(5000);}catch(InterruptedException e) {}
	}
	
	public void clickOnAppealLink()
	{
		String isAppealPay = Settings.isAppealFromPaymentPortal;
		if(isAppealPay.equalsIgnoreCase("true"))
		{
			String appealPath= "//button[text()='Appeal']";
			try{driverUtilities.get().waitForElementToBePresent2(appealPath);}catch(NoSuchElementException e) {}
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(appealPath));
		}
		else
		{
			Assert.fail("Appeal from payment portal is not available for client "+Settings.clientName);
		}
	}
	
	public void clickOnAppealMultipleCitationLink()
	{
		String isAppealPay = Settings.isAppealMultiplePaymentPortal;
		if(isAppealPay.equalsIgnoreCase("true"))
		{
			String appealPath= "//button[text()='Appeal Multiple Citation']";
			try{driverUtilities.get().waitForElementToBePresent2(appealPath);}catch(NoSuchElementException e) {}
			driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(appealPath));
		}
		else
		{
			Assert.fail("Appeal from payment portal is not available for client "+Settings.clientName);
		}
	}
	
	public void verifyThatCitationEntryFromMyAppeal(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'row cstm-table-appeallist')]//table//tr/td[contains(text(),'"+citationNumber+"')]")));
	}
	
	public void verifyThatPlateEntryFromMyAppeal(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'row cstm-table-appeallist')]//table//tr/td[contains(text(),'"+citationNumber+"')]")));
	}
	
	public void verifyViewLinksFromMyAppeal(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'row cstm-table-appeallist')]//table//tr/td[contains(text(),'"+citationNumber+"')]/preceding-sibling::td[contains(@class,'cstm-action-main')]/a[contains(@href,'appeal-detail')]")));
	}
	
	public void verifyEditLinksFromMyAppeal(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'row cstm-table-appeallist')]//table//tr/td[contains(text(),'"+citationNumber+"')]/preceding-sibling::td[contains(@class,'cstm-action-main')]/a[@href='/appeal']")));
	}
	
	public void verifyAddRemarkFromMyAppeal(String citationNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//div[contains(@class,'row cstm-table-appeallist')]//table//tr/td[contains(text(),'"+citationNumber+"')]/preceding-sibling::td[contains(@class,'cstm-action-main')]/a[@href='/my-appeals']")));
	}
	
	public void selectStateForAppealFromPaymentPortal()
	{
		driverUtilities.get().selectElementFromList(driverUtilities.get().getWebElement("//select[@name='state']"), Settings.stateOfAppealPaymentPortal);
	}
	
	public void selectReasonForAppealFromPaymentPortal()
	{
		driverUtilities.get().selectElementFromList(driverUtilities.get().getWebElement("//select[@name='appeal_reason']"), Settings.reasonOfAppealPaymentPortal);
	}
	
	public String enterZipFromPaymentPortal()
	{
		//driverUtilities.get().makeElementVisibleIntoScreen(zipcodeTextbox);
		String zip = GenerateRandomData.getZipCode();
		driverUtilities.get().clearTextBox(driverUtilities.get().getWebElement("//input[@name='zip']"));
		driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement("//input[@name='zip']"), zip);
		return zip;
	}
	
	public void removeEmail()
	{
		try 
		{
			EmailOTPReader.removeEmail();
		} 
		catch (IOException | MailosaurException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void selectTopCheckBox()
	{
		driverUtilities.get().clickOnElement(selectAllTicketsCheckbox);
	}
	
	public void verifyAppealRevertMessage()
	{
		String msg = "//p[contains(normalize-space(.), 'You have selected a citation that is currently in a suspended status as the result of an appeal submission. Would you like to procced with payment and close the pending appeal? By choosing this option, your appeal will be closed and payment will be applied.')]";
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(msg)));
	}
	
	public void clickOnYesContinueButton()
	{
		try{driverUtilities.get().clickOnElement(yesContinueButton);}catch(NoSuchElementException e) {}
	}
	
	public void clickOnBillingAddSameAsUserAdd()
	{
		try{driverUtilities.get().clickOnElement(billingAddressCheckbox);}catch(NoSuchElementException e) {}
	}
	
	public void clickOnBackButton()
	{
		driverUtilities.get().clickOnElement(backButton);
	}
	
	public void verifyAppealMultipleCitationMessage()
	{
		String msg = "//p[contains(normalize-space(.), 'You are about to start appeals for multiple citations. Are you sure you want to proceed?')]";
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(msg)));
	}
	
	public void clickOnStartAppeal()
	{
		try
		{
			driverUtilities.get().clickOnElement(startAppealButton);
		}
		catch(NoSuchElementException e)
		{
			Assert.fail("Start appeal button is not available for client "+Settings.clientName);
		}
	}
	
	public String enterPlaceHolderWithIndex(String placeholder, String index)
	{
		String data="";
		String elementPath = "(//input[contains(@placeholder,'"+placeholder+"')])["+index+"]";
		WebElement element = driverUtilities.get().getWebElement(elementPath);
		if(placeholder.equalsIgnoreCase("First name"))
		{
			data = GenerateRandomData.getFirstName();
			driverUtilities.get().typeIntoTextBox(element, data);
		}
		else if(placeholder.equalsIgnoreCase("Middle name"))
	    {
	        data = GenerateRandomData.getMiddleName();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
	    else if(placeholder.equalsIgnoreCase("Last name"))
	    {
	        data = GenerateRandomData.getLastName();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
	    else if(placeholder.equalsIgnoreCase("(xxx) xxx-xxxx"))
	    {
	        data = GenerateRandomData.getPhoneNumber();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
	    else if(placeholder.equalsIgnoreCase("Email"))
	    {
	        data = GenerateRandomData.getEmailAddress();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
	    else if(placeholder.equalsIgnoreCase("Address"))
	    {
	        data = GenerateRandomData.getAddress();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
	    else if(placeholder.equalsIgnoreCase("City"))
	    {
	        data = GenerateRandomData.getCity();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
	    else if(placeholder.equalsIgnoreCase("zip code"))
	    {
	        data = GenerateRandomData.getZipCode();
	        driverUtilities.get().typeIntoTextBox(element, data);
	    }
		return data;
	}
	
	public void enterInToReasonCategoryIndexBased(String index)
	{
		String categpry = Settings.appealReasonCategory;
		String appealCategoryString = "(//select[@name='appeal_reason'])["+index+"]";
		WebElement reasonForAppealCategory = driverUtilities.get().getWebElement(appealCategoryString);
		driverUtilities.get().makeElementVisibleIntoScreen(reasonForAppealCategory);
		driverUtilities.get().selectElementFromList(reasonForAppealCategory, Settings.appealReasonCategory);
	}
	
	public void clickOnSubmitButtonOfMultipleCitation()
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//button[contains(text(),'Submit')]"));
	}
	
	public void verifyMessageForCardpayOfChargeBackFee()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Ticket must be in Paid with Card payment source to add Chargeback')]")));
	}
}
