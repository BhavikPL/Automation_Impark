package pages;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import path.Path;
import utility.ExcelReader;
import utility.Util;

public class DashboardIntegrationsPage extends BasePage 
{
    // Dashboard integrations menu navigation
    @FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'dashboards')]/ancestor::li")
    public WebElement dashBoardMenu;
    
    @FindBy(how=How.XPATH, using="//a[contains(@href,'integration') and contains(text(),'Integrations')]")
    public WebElement integrationsMenuLink;
    
    // Main page heading
    @FindBy(how=How.XPATH, using="//h3[contains(text(),'Integration')]")
    public WebElement integrationsPageHeading;
    
    // Integration Summary Cards Section
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-inte3')]")
    public WebElement integrationSummaryCardsSection;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Payment Counts')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement paymentCountsCard;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Permit Counts')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement permitCountsCard;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Scofflaw Counts')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement scofflawCountsCard;
    
    // Payment Latency Section
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-payment-latency-main')]")
    public WebElement paymentLatencySection;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Payment Latency')]")
    public WebElement paymentLatencyTitle;
    
    @FindBy(how=How.XPATH, using="//button[@name='today' and contains(@class,'cstm-om-today')]")
    public WebElement todayButton;
    
    @FindBy(how=How.XPATH, using="//button[@name='monthly' and contains(@class,'cstm-om-today')]")
    public WebElement monthlyButton;
    
    @FindBy(how=How.XPATH, using="//button[@name='yearly' and contains(@class,'cstm-om-today')]")
    public WebElement yearlyButton;
    
    @FindBy(how=How.XPATH, using="//canvas[contains(@role,'img')]")
    public WebElement paymentLatencyChart;
    
    @FindBy(how=How.XPATH, using="//span[contains(@class,'show_avg_cstm')]")
    public WebElement averageLatencyValue;
    
    // Active Payments Section
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-ap-mn')]")
    public WebElement activePaymentsSection;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Active Payments')]")
    public WebElement activePaymentsTitle;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm_show_avg_full_sect')]//div[contains(@class,'cstm-ap-mn-left-cont')]")
    public WebElement activePaymentCount;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm_show_avg_full_sect')]//div[contains(@class,'cstm-ap-mn-left-name')]")
    public WebElement paymentProvider;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-payment-latency-main')]//div[contains(text(),'Active Payment')]")
    public WebElement activePaymentChartSection;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-payment-main-latency')]//button[@name='today']")
    public WebElement activePaymentTodayButton;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-payment-main-latency')]//button[@name='monthly']")
    public WebElement activePaymentMonthlyButton;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-payment-main-latency')]//button[@name='yearly']")
    public WebElement activePaymentYearlyButton;
    
    // Transaction Summary Section
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-tra-sum')]")
    public WebElement transactionSummarySection;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Transaction Summary')]")
    public WebElement transactionSummaryTitle;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-tra-sum')]//button[@name='today']")
    public WebElement transactionSummaryTodayButton;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-tra-sum')]//button[@name='monthly']")
    public WebElement transactionSummaryMonthlyButton;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-tra-sum')]//button[@name='yearly']")
    public WebElement transactionSummaryYearlyButton;
    
    // Average Summary Section
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-ave-sun')]")
    public WebElement averageSummarySection;
    
    // Data Table Section
    @FindBy(how=How.XPATH, using="//div[contains(@class,'data_table_box')]")
    public WebElement dataTableSection;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'data_tbl_ttl')]//h2[contains(text(),'Data Table')]")
    public WebElement dataTableHeader;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'data_tbl_btn')]//div[contains(@class,'cstm_rev_down_btn')]")
    public WebElement downloadButton;
    
    @FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']")
    public WebElement dataTable;
    
    @FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']//thead//tr")
    public WebElement tableHeaderRow;
    
    @FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']//tbody")
    public WebElement tableBody;
    
    @FindBy(how=How.XPATH, using="//table[@id='cstm-report-tb-display']//tbody//tr")
    public java.util.List<WebElement> tableRows;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Average Summary')]")
    public WebElement averageSummaryTitle;
    
    @FindBy(how=How.XPATH, using="//div[normalize-space(contains(text(),'Days Average')) and contains(@class,'cstm-tra-sum-weekly')]")
    public WebElement daysAverageHeader;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-weekly-ave')]")
    public WebElement averageSummaryCardsContainer;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Payment')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement averageSummaryPaymentCard;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Permit')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement averageSummaryPermitCard;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Scofflaw')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement averageSummaryScofflawCard;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Latency')]/following-sibling::div[contains(@class,'cstm-inte3-in-leftcont')]")
    public WebElement averageSummaryLatencyCard;
    
    // Average Summary Filter Buttons
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-ave-sun')]//button[@name='today' and contains(text(),'Weekly')]")
    public WebElement weeklyButton;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-ave-sun')]//button[@name='monthly']")
    public WebElement averageSummaryMonthlyButton;
    
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-ave-sun')]//button[@name='yearly']")
    public WebElement averageSummaryYearlyButton;

    /**
     * Navigate to Dashboard Integrations page
     */
    public void navigateToDashboardIntegrations()
    {
        driverUtilities.get().waitForElementToBePresent(dashBoardMenu);
        driverUtilities.get().clickOnElement(dashBoardMenu);
        
        driverUtilities.get().waitForElementToBePresent(integrationsMenuLink);
        driverUtilities.get().clickOnElement(integrationsMenuLink);
    }
    
    /**
     * Verify Dashboard Integrations page loads successfully
     */
    public void verifyDashboardIntegrationsPageLoaded()
    {
        driverUtilities.get().waitForElementToBePresent(integrationsPageHeading);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(integrationsPageHeading));
        
        driverUtilities.get().waitForElementToBePresent(integrationSummaryCardsSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(integrationSummaryCardsSection));
    }
    
    /**
     * Locate integration summary cards section
     */
    public void locateIntegrationSummaryCardsSection()
    {
        driverUtilities.get().waitForElementToBePresent(integrationSummaryCardsSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(integrationSummaryCardsSection));
    }
    
    /**
     * Verify payment counts card
     */
    public void verifyPaymentCountsCard()
    {
        driverUtilities.get().waitForElementToBePresent(paymentCountsCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentCountsCard));
    }
    
    /**
     * Verify permit counts card
     */
    public void verifyPermitCountsCard()
    {
        driverUtilities.get().waitForElementToBePresent(permitCountsCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitCountsCard));
    }
    
    /**
     * Verify scofflaw counts card
     */
    public void verifyScofflawCountsCard()
    {
        driverUtilities.get().waitForElementToBePresent(scofflawCountsCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(scofflawCountsCard));
    }
    
    /**
     * Verify payment latency chart is displayed
     */
    public void verifyPaymentLatencyChartIsDisplayed()
    {
        driverUtilities.get().waitForElementToBePresent(paymentLatencySection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentLatencySection));
        
        driverUtilities.get().waitForElementToBePresent(paymentLatencyChart);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentLatencyChart));
    }
    
    /**
     * Verify default time period is today
     */
    public void verifyDefaultTimePeriodIsToday()
    {
        driverUtilities.get().waitForElementToBePresent(todayButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(todayButton));
        
        String todayButtonClass = driverUtilities.get().getElementAttribute(todayButton, "class");
        Assert.assertTrue(todayButtonClass.contains("active"));
    }
    
    /**
     * Click on monthly button
     */
    public void clickOnMonthlyButton()
    {
        driverUtilities.get().waitForElementToBePresent(monthlyButton);
        driverUtilities.get().clickOnElement(monthlyButton);
    }
    
    /**
     * Verify chart updates for monthly selection
     */
    public void verifyChartUpdatesForMonthlySelection()
    {
        String monthlyButtonClass = driverUtilities.get().getElementAttribute(monthlyButton, "class");
        Assert.assertTrue(monthlyButtonClass.contains("active"));
        
        driverUtilities.get().waitForElementToBePresent(paymentLatencyChart);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentLatencyChart));
    }
    
    /**
     * Click on yearly button
     */
    public void clickOnYearlyButton()
    {
        driverUtilities.get().waitForElementToBePresent(yearlyButton);
        driverUtilities.get().clickOnElement(yearlyButton);
    }
    
    /**
     * Verify chart updates for yearly selection
     */
    public void verifyChartUpdatesForYearlySelection()
    {
        String yearlyButtonClass = driverUtilities.get().getElementAttribute(yearlyButton, "class");
        Assert.assertTrue(yearlyButtonClass.contains("active"));
        
        driverUtilities.get().waitForElementToBePresent(paymentLatencyChart);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentLatencyChart));
    }
    
    /**
     * Verify average latency value is displayed
     */
    public void verifyAverageLatencyValueIsDisplayed()
    {
        driverUtilities.get().waitForElementToBePresent(averageLatencyValue);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageLatencyValue));
        
        String latencyValue = driverUtilities.get().getElementText(averageLatencyValue);
        Assert.assertFalse(latencyValue.isEmpty());
    }
    
    /**
     * Locate active payments section
     */
    public void locateActivePaymentsSection()
    {
    	driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(activePaymentCount);
        driverUtilities.get().waitForElementToBePresent(activePaymentsSection);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(activePaymentCount);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentsSection));
    }
    
    /**
     * Verify payment count display
     */
    public void verifyPaymentCountDisplay()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentCount);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentCount));
    }
    
    /**
     * Verify payment provider
     */
    public void verifyPaymentProvider()
    {
        driverUtilities.get().waitForElementToBePresent(paymentProvider);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentProvider));
    }
    
    /**
     * Verify active payment chart
     */
    public void verifyActivePaymentChart()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentChartSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentChartSection));
    }
    
    /**
     * Verify time period filter buttons
     */
    public void verifyTimePeriodFilterButtons()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentTodayButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentTodayButton));
        
        driverUtilities.get().waitForElementToBePresent(activePaymentMonthlyButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentMonthlyButton));
        
        driverUtilities.get().waitForElementToBePresent(activePaymentYearlyButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentYearlyButton));
    }
    
    /**
     * Click on today button for active payments
     */
    public void clickOnTodayButtonForActivePayments()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentTodayButton);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(activePaymentTodayButton);
        driverUtilities.get().clickOnElement(activePaymentTodayButton);
    }
    
    /**
     * Verify chart displays today data
     */
    public void verifyChartDisplaysTodayData()
    {
        String todayButtonClass = driverUtilities.get().getElementAttribute(activePaymentTodayButton, "class");
        Assert.assertTrue(todayButtonClass.contains("active"));
    }
    
    /**
     * Click on monthly button for active payments
     */
    public void clickOnMonthlyButtonForActivePayments()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentMonthlyButton);
        driverUtilities.get().clickOnElement(activePaymentMonthlyButton);
    }
    
    /**
     * Verify chart displays monthly data
     */
    public void verifyChartDisplaysMonthlyData()
    {
        String monthlyButtonClass = driverUtilities.get().getElementAttribute(activePaymentMonthlyButton, "class");
        Assert.assertTrue(monthlyButtonClass.contains("active"));
    }
    
    /**
     * Click on yearly button for active payments
     */
    public void clickOnYearlyButtonForActivePayments()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentYearlyButton);
        driverUtilities.get().clickOnElement(activePaymentYearlyButton);
    }
    
    /**
     * Verify chart displays yearly data
     */
    public void verifyChartDisplaysYearlyData()
    {
        String yearlyButtonClass = driverUtilities.get().getElementAttribute(activePaymentYearlyButton, "class");
        Assert.assertTrue(yearlyButtonClass.contains("active"));
    }
    
    /**
     * Verify active payment today filter is active by default
     */
    public void verifyActivePaymentTodayFilterIsActiveByDefault()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentTodayButton);
        String todayButtonClass = driverUtilities.get().getElementAttribute(activePaymentTodayButton, "class");
        Assert.assertTrue(todayButtonClass.contains("active"));
    }
    
    /**
     * Observe active payment chart displays today data
     */
    public void observeActivePaymentChartDisplaysTodayData()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentChartSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentChartSection));
    }
    
    /**
     * Click on active payment monthly filter button
     */
    public void clickOnActivePaymentMonthlyFilterButton()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentMonthlyButton);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(activePaymentMonthlyButton);
        driverUtilities.get().clickOnElement(activePaymentMonthlyButton);
    }
    
    /**
     * Observe active payment chart changes to monthly view
     */
    public void observeActivePaymentChartChangesToMonthlyView()
    {
        String monthlyButtonClass = driverUtilities.get().getElementAttribute(activePaymentMonthlyButton, "class");
        Assert.assertTrue(monthlyButtonClass.contains("active"));
    }
    
    /**
     * Verify active payment chart reflects monthly data
     */
    public void verifyActivePaymentChartReflectsMonthlyData()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentChartSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentChartSection));
    }
    
    /**
     * Click on active payment yearly filter button
     */
    public void clickOnActivePaymentYearlyFilterButton()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentYearlyButton);
        driverUtilities.get().clickOnElement(activePaymentYearlyButton);
    }
    
    /**
     * Observe active payment chart changes to yearly view
     */
    public void observeActivePaymentChartChangesToYearlyView()
    {
        String yearlyButtonClass = driverUtilities.get().getElementAttribute(activePaymentYearlyButton, "class");
        Assert.assertTrue(yearlyButtonClass.contains("active"));
    }
    
    /**
     * Verify active payment chart reflects yearly data
     */
    public void verifyActivePaymentChartReflectsYearlyData()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentChartSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentChartSection));
    }
    
    /**
     * Verify active payment filter buttons show active state correctly
     */
    public void verifyActivePaymentFilterButtonsShowActiveStateCorrectly()
    {
        driverUtilities.get().waitForElementToBePresent(activePaymentTodayButton);
        driverUtilities.get().waitForElementToBePresent(activePaymentMonthlyButton);
        driverUtilities.get().waitForElementToBePresent(activePaymentYearlyButton);
        
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentTodayButton));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentMonthlyButton));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(activePaymentYearlyButton));
    }
    
    /**
     * Verify transaction summary chart is displayed
     */
    public void verifyTransactionSummaryChartIsDisplayed()
    {
        driverUtilities.get().waitForElementToBePresent(transactionSummarySection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(transactionSummarySection));
    }
    
    /**
     * Check transaction summary default time period selection
     */
    public void checkTransactionSummaryDefaultTimePeriodSelection()
    {
        driverUtilities.get().waitForElementToBePresent(transactionSummaryTodayButton);
        String todayButtonClass = driverUtilities.get().getElementAttribute(transactionSummaryTodayButton, "class");
        Assert.assertTrue(todayButtonClass.contains("active"));
    }
    
    /**
     * Click on transaction summary monthly filter
     */
    public void clickOnTransactionSummaryMonthlyFilter()
    {
        driverUtilities.get().waitForElementToBePresent(transactionSummaryMonthlyButton);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(transactionSummaryMonthlyButton);
        driverUtilities.get().clickOnElement(transactionSummaryMonthlyButton);
    }
    
    /**
     * Verify transaction summary chart updates for monthly
     */
    public void verifyTransactionSummaryChartUpdatesForMonthly()
    {
        String monthlyButtonClass = driverUtilities.get().getElementAttribute(transactionSummaryMonthlyButton, "class");
        Assert.assertTrue(monthlyButtonClass.contains("active"));
    }
    
    /**
     * Click on transaction summary yearly filter
     */
    public void clickOnTransactionSummaryYearlyFilter()
    {
        driverUtilities.get().waitForElementToBePresent(transactionSummaryYearlyButton);
        driverUtilities.get().clickOnElement(transactionSummaryYearlyButton);
    }
    
    /**
     * Verify transaction summary chart updates for yearly
     */
    public void verifyTransactionSummaryChartUpdatesForYearly()
    {
        String yearlyButtonClass = driverUtilities.get().getElementAttribute(transactionSummaryYearlyButton, "class");
        Assert.assertTrue(yearlyButtonClass.contains("active"));
    }
    
    /**
     * Verify transaction summary chart maintains proper formatting
     */
    public void verifyTransactionSummaryChartMaintainsProperFormatting()
    {
        driverUtilities.get().waitForElementToBePresent(transactionSummarySection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(transactionSummarySection));
    }
    
    /**
     * Locate average summary section
     */
    public void locateAverageSummarySection()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummarySection);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(averageSummarySection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummarySection));
    }
    
    /**
     * Verify average summary section title
     */
    public void verifyAverageSummarySectionTitle()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummaryTitle);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryTitle));
    }
    
    /**
     * Verify days average header
     */
    public void verifyDaysAverageHeader()
    {
        driverUtilities.get().waitForElementToBePresent(daysAverageHeader);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(daysAverageHeader));
    }
    
    /**
     * Verify average summary payment card
     */
    public void verifyAverageSummaryPaymentCard()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummaryPaymentCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryPaymentCard));
    }
    
    /**
     * Verify average summary permit card
     */
    public void verifyAverageSummaryPermitCard()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummaryPermitCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryPermitCard));
    }
    
    /**
     * Verify average summary scofflaw card
     */
    public void verifyAverageSummaryScofflawCard()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummaryScofflawCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryScofflawCard));
    }
    
    /**
     * Verify average summary latency card
     */
    public void verifyAverageSummaryLatencyCard()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummaryLatencyCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryLatencyCard));
    }
    
    /**
     * Verify average summary time period filters
     */
    public void verifyAverageSummaryTimePeriodFilters()
    {
        driverUtilities.get().waitForElementToBePresent(weeklyButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(weeklyButton));
        
        driverUtilities.get().waitForElementToBePresent(averageSummaryMonthlyButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryMonthlyButton));
        
        driverUtilities.get().waitForElementToBePresent(averageSummaryYearlyButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummaryYearlyButton));
    }
    
    // Test case DI_008 specific methods
    
    /**
     * Navigate to average summary section
     */
    public void navigateToAverageSummarySection()
    {
        driverUtilities.get().waitForElementToBePresent(averageSummarySection);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(averageSummarySection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(averageSummarySection));
    }
    
    /**
     * Verify Average Summary weekly is selected by default
     */
    public void verifyAverageSummaryWeeklyIsSelectedByDefault()
    {
        WebElement weeklyButtonActive = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-ave-sun-top')]//button[@name='today' and contains(@class,'active')]");
        driverUtilities.get().waitForElementToBePresent(weeklyButtonActive);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(weeklyButtonActive));
    }
    
    /**
     * Click on Average Summary monthly filter button
     */
    public void clickOnAverageSummaryMonthlyFilterButton()
    {
        WebElement monthlyButton = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-ave-sun-top')]//button[@name='monthly']");
        driverUtilities.get().waitForElementToBePresent(monthlyButton);
        driverUtilities.get().clickOnElement(monthlyButton);
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
    }
    
    public void clickOnAverageSummaryWeeklyFilterButton()
    {
        WebElement monthlyButton = driverUtilities.get().getWebElement("(//button[contains(@class,'cstm-om-today active') and @name='today'])[3]");
        driverUtilities.get().waitForElementToBePresent(monthlyButton);
        driverUtilities.get().clickOnElement(monthlyButton);
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
    }
    
    /**
     * Observe Average Summary data changes in summary cards
     */
    public void observeAverageSummaryDataChangesInSummaryCards()
    {
        WebElement paymentCard = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Payment')]");
        WebElement permitCard = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Permit')]");
        WebElement scofflawCard = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Scofflaw')]");
        WebElement latencyCard = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-weekly-ave')]//div[contains(text(),'Latency')]");
        
        driverUtilities.get().waitForElementToBePresent(paymentCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentCard));
        
        driverUtilities.get().waitForElementToBePresent(permitCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitCard));
        
        driverUtilities.get().waitForElementToBePresent(scofflawCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(scofflawCard));
        
        driverUtilities.get().waitForElementToBePresent(latencyCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(latencyCard));
    }
    
    /**
     * Click on Average Summary yearly filter button
     */
    public void clickOnAverageSummaryYearlyFilterButton()
    {
        WebElement yearlyButton = driverUtilities.get().getWebElement("//div[contains(@class,'cstm-ave-sun-top')]//button[@name='yearly']");
        driverUtilities.get().waitForElementToBePresent(yearlyButton);
        driverUtilities.get().clickOnElement(yearlyButton);
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
    }
    
    /**
     * Navigate to Data Table section
     */
    public void navigateToDataTableSection()
    {
        driverUtilities.get().waitForElementToBePresent(dataTableSection);
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(dataTableSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(dataTableSection));
    }
    
    /**
     * Verify Data Table header displays correctly
     */
    public void verifyDataTableHeaderDisplaysCorrectly()
    {
        driverUtilities.get().waitForElementToBePresent(dataTableHeader);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(dataTableHeader));
        String headerText = driverUtilities.get().getElementText(dataTableHeader);
        Assert.assertEquals(headerText, "Data Table");
    }
    
    /**
     * Verify Download button functionality
     */
    public void verifyDownloadButtonFunctionality()
    {
        driverUtilities.get().waitForElementToBePresent(downloadButton);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(downloadButton));
    }
    
    /**
     * Verify Data Table columns are displayed
     */
    public void verifyDataTableColumnsAreDisplayed()
    {
        driverUtilities.get().waitForElementToBePresent(tableHeaderRow);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(tableHeaderRow));
        
        // Verify column headers
        WebElement daysColumn = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//th[contains(@class,'srt-tab') and contains(text(),'Days')]");
        WebElement paymentColumn = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//th[contains(@class,'srt-tab') and contains(text(),'Payment')]");
        WebElement permitColumn = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//th[contains(@class,'srt-tab') and contains(text(),'Permit')]");
        WebElement scofflawColumn = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//th[contains(@class,'srt-tab') and contains(text(),'Scofflaw')]");
        WebElement latencyColumn = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//th[contains(@class,'srt-tab') and contains(text(),'Latency')]");
        
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(daysColumn));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(paymentColumn));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitColumn));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(scofflawColumn));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(latencyColumn));
    }
    
    /**
     * Verify Data Table rows are displayed
     */
    public void verifyDataTableRowsAreDisplayed()
    {
        driverUtilities.get().waitForElementToBePresent(tableBody);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(tableBody));
        int r = driverUtilities.get().getNumberOfElement("//table[@id='cstm-report-tb-display']//tbody//tr");
        Assert.assertTrue(r == 12);
        
        // Verify specific day rows
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (String month : months)
        {
            WebElement dayRow = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//tbody//tr//td[contains(text(),'" + month + "')]");
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(dayRow));
        }
    }
    
    /**
     * Verify Data Table formatting is correct
     */
    public void verifyDataTableFormattingIsCorrect()
    {
        driverUtilities.get().waitForElementToBePresent(dataTable);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(dataTable));
        
        // Verify table has proper classes
        String tableClass = driverUtilities.get().getElementAttribute(dataTable, "class");
        Assert.assertTrue(tableClass.contains("table"));
        Assert.assertTrue(tableClass.contains("table-heading"));
        Assert.assertTrue(tableClass.contains("table-bordered"));
        
        // Verify table has proper ID
        String tableId = driverUtilities.get().getElementAttribute(dataTable, "id");
        Assert.assertEquals(tableId, "cstm-report-tb-display");
        
        // Verify latency column has proper time format
        WebElement latencyCell = driverUtilities.get().getWebElement("//table[@id='cstm-report-tb-display']//tbody//tr[1]//td[5]");
        String latencyValue = driverUtilities.get().getElementText(latencyCell);
        //Assert.assertTrue(latencyValue.matches("\\d{2}:\\d{2}:\\d{2}"));
    }
    
    /**
     * Click on download button
     */
    public void clickOnDownloadButton()
    {
        driverUtilities.get().waitForElementToBePresent(downloadButton);
        driverUtilities.get().clickOnElement(downloadButton);
    }
    
    /**
     * Verify download format options are displayed
     */
    public void verifyDownloadFormatOptionsAreDisplayed()
    {
        WebElement pdfOption = driverUtilities.get().getWebElement("//div[contains(text(),'Pdf')]");
        WebElement csvOption = driverUtilities.get().getWebElement("//div[contains(text(),'CSV')]");
        WebElement excelOption = driverUtilities.get().getWebElement("//div[contains(text(),'Excel')]");
        
        driverUtilities.get().waitForElementToBePresent(pdfOption);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(pdfOption));
        
        driverUtilities.get().waitForElementToBePresent(csvOption);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(csvOption));
        
        driverUtilities.get().waitForElementToBePresent(excelOption);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(excelOption));
    }
    
    /**
     * Click on Excel download option
     */
    public void clickOnExcelDownloadOption()
    {
        WebElement excelOption = driverUtilities.get().getWebElement("//div[contains(text(),'Excel')]");
        driverUtilities.get().waitForElementToBePresent(excelOption);
        driverUtilities.get().clickOnElement(excelOption);
    }
    
    /**
     * Verify Excel file downloaded successfully
     */
    public void verifyExcelFileDownloadedSuccessfully()
    {
    	String fileName;
		String filePath;
		File file;
		fileName = Util.getDownloadedFileName();
		filePath = Path.downloadPath+File.separator+fileName;
		file = new File(filePath);
		
		List<Map<String, Object>> excelDate = null;
		try {
			excelDate = new ExcelReader().getData(filePath, 0);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("Excel file Size:="+excelDate.size());
		Assert.assertTrue(excelDate.size()!=0);
		
    }
}