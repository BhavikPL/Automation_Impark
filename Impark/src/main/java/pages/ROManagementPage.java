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

public class ROManagementPage extends BasePage
{	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'RO List View')]/parent::li")
	public WebElement roListViewOption;
	
	@FindBy(how=How.XPATH, using="//img[contains(@alt,'filter')]/parent::button")
	public WebElement filterIcon;
	
	//filter search locators
	@FindBy(how=How.XPATH, using="//input[@name='address']")
	public WebElement addressSearchTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='name']")
	public WebElement nameSearchTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	public WebElement emailSearchTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='phone_number']")
	public WebElement phoneNumberSearchTextbox;
	
	//ro link report
	@FindBy(how=How.XPATH, using="//a[contains(text(),'RO Link report')]/parent::li")
	public WebElement roLinkReportOption;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Link Plates')]")
	public WebElement linkPLatesButton;
	
	
	public void clickOnROListViewOption()
	{
		driverUtilities.get().clickOnElement(roListViewOption);
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
	}
	
	public void clickOnFilterIcon()
	{
		driverUtilities.get().clickOnElement(filterIcon);
	}
	
	public void enterAddressInToSearch(String address)
	{
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		driverUtilities.get().clearTextBox(addressSearchTextbox);
		driverUtilities.get().typeIntoTextBox(addressSearchTextbox, address);
	}
	
	public void enterEmailInToSearch(String email)
	{
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		driverUtilities.get().clearTextBox(addressSearchTextbox);
		driverUtilities.get().clearTextBox(emailSearchTextbox);
		driverUtilities.get().typeIntoTextBox(emailSearchTextbox, email);
	}
	
	public void enterNameInToSearch(String name)
	{
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		driverUtilities.get().clearTextBox(addressSearchTextbox);
		driverUtilities.get().clearTextBox(emailSearchTextbox);
		driverUtilities.get().typeIntoTextBox(nameSearchTextbox, name);
	}
	
	public void enterPhoneInToSearch(String email)
	{
		try {driverUtilities.get().waitForElementDisappear2("//div[contains(@class,'spinner-border')]");}catch(NoSuchElementException e) {}
		driverUtilities.get().clearTextBox(addressSearchTextbox);
		driverUtilities.get().clearTextBox(emailSearchTextbox);
		driverUtilities.get().clearTextBox(nameSearchTextbox);
		driverUtilities.get().clearTextBox(phoneNumberSearchTextbox);
		driverUtilities.get().typeIntoTextBox(phoneNumberSearchTextbox, email);
	}
	
	public void verifyTickteSearchedBasedOnCitation(String citation)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]")));
	}
	
	public void clickOnROLinkReportOption()
	{
		try
		{
			driverUtilities.get().clickOnElement(roLinkReportOption);
		}
		catch(NoSuchElementException e)
		{
			Assert.fail("RO Link Report option is not present for client "+Settings.clientName);
		}
	}
	
	public void verifyTickteSearchedBasedOnPlate(String plate)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+plate+"')]")));
	}
	
	public void verifyTickteSearchedBasedOnEmail(String plate)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td[contains(text(),'"+plate+"')]")));
	}
	
	public void selectRoListViewRecord(String citation)
	{
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//table[contains(@id,'tb-display')]/tbody/tr/td/a[contains(text(),'"+citation+"')]/ancestor::tr/td/input"));
	}
	
	public void clickOnLinkPlatesButton()
	{
		driverUtilities.get().clickOnElement(linkPLatesButton);
	}
}
