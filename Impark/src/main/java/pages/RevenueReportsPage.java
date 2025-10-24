package pages;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import config.Settings;
import junit.framework.AssertionFailedError;
import path.Path;
import utility.GenerateRandomData;
import utility.Util;

public class RevenueReportsPage extends BasePage
{	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'paidtickets')]/parent::li")
	public WebElement paymentManagementMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/paymentcount')]/parent::li")
	public WebElement paymentSummaryMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/reconciliation-payment')]/parent::li")
	public WebElement paymentReconciliationMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/payment-failed-report')]/parent::li")
	public WebElement paymentFailedReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/paymentSummaryReport')]/parent::li")
	public WebElement paymentSummaryReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/skeletal-report')]/parent::li")
	public WebElement skeletalReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/permitSummaryReport')]/parent::li")
	public WebElement permitSummaryReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/permitBookPurchaseSummaryReport')]/parent::li")
	public WebElement permitBookPurchaseSummaryReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/reports')]/parent::li")
	public WebElement otherReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'/paymentReconciliationReport')]/parent::li")
	public WebElement paymentReconciliationReportMenu;
	
	@FindBy(how=How.XPATH, using="//input[@name='end_date']")
	public WebElement endDate;
	
	@FindBy(how=How.XPATH, using="//ul[@id='revenuereports']//a[contains(@href,'payment-failed-report')]/parent::li")
	public WebElement paymentFailedMenu;
	
	public void verifyRevenueReportsMenus()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentManagementMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentSummaryMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentReconciliationMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentFailedReportMenu));
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentSummaryReportMenu));}catch(NoSuchElementException e) {}
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(skeletalReportMenu));}catch(NoSuchElementException e) {}
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitSummaryReportMenu));}catch(NoSuchElementException e) {}
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitBookPurchaseSummaryReportMenu));}catch(NoSuchElementException e) {}
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(otherReportMenu));}catch(NoSuchElementException e) {}
		try{Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentReconciliationReportMenu));}catch(NoSuchElementException e) {}
	}
	
	public void clickOnPaymentManagementOption()
	{
		driverUtilities.get().clickOnElement(paymentManagementMenu);
	}
	
	public void verifyTickteSearchedBasedOnCitation(String citation)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnPlateNumber(String plateNumber)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+plateNumber+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnState(String state)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td[contains(text(),'"+state+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnRecID(String vc)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+vc+"')]")));
	}
	
	public void selectPreviousDayEndDate() throws AWTException
	{
		try{driverUtilities.get().waitForElementToBePresent(endDate);}catch(TimeoutException e) {}
		driverUtilities.get().makeElementVisibleIntoScreen(endDate);
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
	
	public void clickOnPaymentFailedOption()
	{
		driverUtilities.get().clickOnElement(paymentFailedMenu);
	}
	
	public void verifyPlatNumberWithCitationForPaymentFailed(String citation, String platNumber)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td/a[contains(text(),'"+platNumber+"')]")));
	}
	
	public void verifyFineAmoutFromPaymentFailed(String citation, String fine)
	{
		String amtString = "//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td[2]";
		String amoutText = driverUtilities.get().getElementText(driverUtilities.get().getWebElement(amtString));
		
		Double expAmount = Double.parseDouble(fine) + Double.parseDouble(Settings.serviceCharge);
		System.out.println("amoutText:="+amoutText);
		System.out.println("expAmount:="+expAmount.toString());
		Assert.assertTrue(amoutText.contains(expAmount.toString()));
	}
	
	public void verifyCitationFailedStatus(String citation)
	{
		String statusString = "//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td[3]";
		String status = driverUtilities.get().getElementText(driverUtilities.get().getWebElement(statusString));
		Assert.assertTrue(status.contains("FAILED"));
	}
	
	public void verifyCitationFailedDescription(String citation)
	{
		String descString = "//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td//div[contains(@class,'description')]";
		String desc = driverUtilities.get().getElementText(driverUtilities.get().getWebElement(descString));
		String expDesc = "card_number "+Settings.invalidCardNumber+" is not valid";
		//System.out.println("Failed desc:="+desc);
		Assert.assertTrue(desc.contains(expDesc));
	}
	
	public void verifyFineWithCitationForPaymentManagement(String citation, String fine)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td[contains(normalize-space(.), '"+fine+"')]")));
	}
	
	public void verifyValWithCitationForPaymentManagement(String citation, String value)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/preceding-sibling::td[contains(normalize-space(.), '"+value+"')]")));
	}
	
	public void verifyCodeWithCitationForPaymentManagement(String citation, String code)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td[contains(normalize-space(.), '"+code+"')]")));
	}
	
	public void verifyDescWithCitationForPaymentManagement(String citation, String code)
	{
		try {driverUtilities.get().waitForElementToBePresent2("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'cstm-report-tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/parent::td/following-sibling::td[contains(normalize-space(.), '"+code+"')]")));
	}
	
	public void enterPreviousEndDateForPaymentFailedReport()
	{
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), endDate);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		String date = Util.getPreviousSystemDate("dd","1");
		String month = Util.getCurrentSystemDate("MMMMMM");
		
		if(date.startsWith("0"))
		{
			date = date.substring(1);
		}
		String datePath = "//div[contains(@aria-label,'"+month+"') and text()='"+date+"']";
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(datePath));
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
}
