package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class HomePage extends BasePage
{
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'dashboards')]/ancestor::li")
	public WebElement dashBoardMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'ticketmanagement')]/ancestor::li")
	public WebElement ticketManagementMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'appealmanagement')]/ancestor::li")
	public WebElement appealManagementMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'hearingmanagement')]/ancestor::li")
	public WebElement hearingManagementMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'manualcitations')]/ancestor::li")
	public WebElement manualTicketsMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'revenuereports')]/ancestor::li")
	public WebElement revenueReportMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'romanagement')]/ancestor::li")
	public WebElement roManagementMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'administration')]/ancestor::li")
	public WebElement administrationMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='administration']//a[contains(@href,'siteConfigurations')]/parent::li")
	public WebElement siteConfigurationOption;
	

	@FindBy(how=How.XPATH, using="//ul[@id='permitAdministration']//a[contains(@href,'permits-configuration')]/parent::li")
	public WebElement setUpPermitsOption;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'permitAdministration')]/ancestor::li")
	public WebElement permitsAdministrationMenu;
	
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'Configure Permit')]")
	public WebElement configurePermitTitle;
	
	public void extendsTicketManagement()
	{
		try {driverUtilities.get().waitForElementToBePresent(ticketManagementMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(ticketManagementMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void extendsManualTickets()
	{
		try {driverUtilities.get().waitForElementToBePresent(manualTicketsMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(manualTicketsMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void extendsRevenueReport()
	{
		try {driverUtilities.get().waitForElementToBePresent(revenueReportMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(revenueReportMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void extendsHearingManagement()
	{
		try {driverUtilities.get().waitForElementToBePresent(hearingManagementMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(hearingManagementMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void extendsAppealManagement()
	{
		try {driverUtilities.get().waitForElementToBePresent(appealManagementMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(appealManagementMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void extendsROManagement()
	{
		try {driverUtilities.get().waitForElementToBePresent(roManagementMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(roManagementMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void extendsAdministrationMenu()
	{
		try {driverUtilities.get().waitForElementToBePresent(administrationMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(administrationMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void navigateToSiteConfiguration()
	{
		driverUtilities.get().clickOnElement(siteConfigurationOption);
	}
	
	public void extendsPermitsAdministration()
	{

	    try {driverUtilities.get().waitForElementToBePresent(permitsAdministrationMenu);}catch(TimeoutException e) {}
	    driverUtilities.get().clickOnElement(permitsAdministrationMenu);
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void verifyConfigurePermitPageDisplayed()
	{
	    try {driverUtilities.get().waitForElementToBePresent(configurePermitTitle);}catch(TimeoutException e) {}
	    Assert.assertTrue(driverUtilities.get().isElementDisplayed(configurePermitTitle));
	}
	
	public void extendsDashboard()
	{
		try {driverUtilities.get().waitForElementToBePresent(dashBoardMenu);}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(dashBoardMenu);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
}
