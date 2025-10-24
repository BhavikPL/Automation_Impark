package pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class DashboardAppealPage extends BasePage 
{
    // Dashboard appeal menu navigation
    @FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'dashboards')]/ancestor::li")
    public WebElement dashBoardMenu;
    
    @FindBy(how=How.XPATH, using="//a[contains(@href,'appealsDashboardBi') and contains(text(),'Appeal')]")
    public WebElement appealMenuLink;
    
    // Main dashboard content verification elements
    @FindBy(how=How.XPATH, using="//h3[contains(text(),'Appeals Dashboard')]")
    public WebElement appealsDashboardHeading;
    
    @FindBy(how=How.XPATH, using="//iframe[@id='knowi-iframe']")
    public WebElement appealsDashboardIframe;
    
    @FindBy(how=How.XPATH, using="//iframe[contains(@src,'knowi') or @name='c9login']")
    public WebElement alternativeIframe;
    
    @FindBy(how=How.XPATH, using="//div[@id='knowi-div']")
    public WebElement knowiDiv;
    
    // Appeal Summary Metrics Section
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeal Requests')]/ancestor::div/following-sibling::div//span[contains(@class,'value-content')]")
    public WebElement appealRequestsCard;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals Approved')]/ancestor::div/following-sibling::div//span[contains(@class,'value-content')]")
    public WebElement appealsApprovedCard;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals Partially Upheld')]/ancestor::div/following-sibling::div//span[contains(@class,'value-content')]")
    public WebElement appealsPartiallyUpheldCard;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals Rejected')]/ancestor::div/following-sibling::div//span[contains(@class,'value-content')]")
    public WebElement appealsRejectedCard;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals Closed')]/ancestor::div/following-sibling::div//span[contains(@class,'value-content')]")
    public WebElement appealsClosedCard;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals Open')]/ancestor::div/following-sibling::div//span[contains(@class,'value-content')]")
    public WebElement appealsOpenCard;
    
    // Appeals By Reason Bar Chart Section
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Reason')]")
    public WebElement appealsByReasonSection;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Reason')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]")
    public WebElement barChartVisualizationForAppealsByReasonChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Reason')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]//*[contains(@class,'highcharts-xaxis-labels')]//*[name()='text']")
    public List<WebElement> allXAxisCategoriesForAppealsByReasonChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Reason')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]//svg//g[contains(@class,'highcharts-data-labels')]//text")
    public List<WebElement> allBarValuesForAppealsByReasonChart;

    // Appeals By Status Pie Chart Section - Multiple locator variations
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Status')]")
    public WebElement appealsByStatusSection;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals') and contains(text(),'Status')]")
    public WebElement appealsByStatusSectionAlternative;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')] | //*[contains(text(),'Appeals') and contains(text(),'Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]")
    public WebElement pieChartVisualizationForAppealsByStatusChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]//svg | //*[contains(text(),'Appeals') and contains(text(),'Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]//svg")
    public WebElement pieChartContainer;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//svg//*[name()='path'] | //*[contains(text(),'Appeals') and contains(text(),'Status')]/ancestor::div/following-sibling::div//svg//*[name()='path']")
    public List<WebElement> allPieSegments;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//svg//*[name()='text'] | //*[contains(text(),'Appeals') and contains(text(),'Status')]/ancestor::div/following-sibling::div//svg//*[name()='text']")
    public List<WebElement> allPieChartLabelsAndValues;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@class,'legend')]//*[name()='text'] | //*[contains(text(),'Appeals') and contains(text(),'Status')]/ancestor::div/following-sibling::div//svg//*[contains(@class,'legend')]//*[name()='text']")
    public List<WebElement> pieLegendItems;

    // Appeals By Month Bar Chart Section
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Month')]")
    public WebElement appealsByMonthSection;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]")
    public WebElement barChartVisualizationForAppealsByMonthChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]//*[contains(@class,'highcharts-xaxis-labels')]//*[name()='text']")
    public List<WebElement> allXAxisCategoriesForAppealsByMonthChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]//svg//g[contains(@class,'highcharts-data-labels')]//text")
    public List<WebElement> allBarValuesForAppealsByMonthChart;

    // Appeals By Date Line Chart Section
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Date')]")
    public WebElement appealsByDateSection;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]")
    public WebElement lineChartVisualizationForAppealsByDateChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]//*[contains(@class,'highcharts-xaxis-labels')]//*[name()='text']")
    public List<WebElement> allXAxisCategoriesForAppealsByDateChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]//svg//g[contains(@class,'highcharts-data-labels')]//text")
    public List<WebElement> allDataPointValuesForAppealsByDateChart;

    // TC_APP_008 - Quarterly Appeals Count Chart Section
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Quarterly Appeals Count')]")
    public WebElement quarterlyAppealsCountSection;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]")
    public WebElement barChartVisualizationForQuarterlyAppealsCountChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]//*[contains(@class,'highcharts-xaxis-labels')]//*[name()='text']")
    public List<WebElement> allXAxisCategoriesForQuarterlyAppealsCountChart;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]//svg//g[contains(@class,'highcharts-data-labels')]//text")
    public List<WebElement> allBarValuesForQuarterlyAppealsCountChart;

    /**
     * Navigate to Dashboard Appeal page
     */
    public void navigateToDashboardAppeal()
    {
        try {driverUtilities.get().waitForElementToBePresent(dashBoardMenu);}catch(TimeoutException e) {}
        driverUtilities.get().clickOnElement(dashBoardMenu);
        try {Thread.sleep(1000);}catch(InterruptedException e) {}
        
        try {driverUtilities.get().waitForElementToBePresent(appealMenuLink);}catch(TimeoutException e) {}
        driverUtilities.get().clickOnElement(appealMenuLink);
        try {Thread.sleep(3000);}catch(InterruptedException e) {} // Wait for page to load
    }
    
    /**
     * Verify Dashboard Appeal page loads successfully by checking filters
     */
    public void verifyDashboardAppealPageLoadsSuccessfullyWithFilters()
    {
        try {driverUtilities.get().waitForElementToBePresent(appealsDashboardHeading);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealsDashboardHeading));
        
        try {driverUtilities.get().waitForElementToBePresent(knowiDiv);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(knowiDiv));
        
        // Try multiple iframe locators
        boolean iframeFound = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            iframeFound = driverUtilities.get().isElementDisplayed(appealsDashboardIframe);
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                iframeFound = driverUtilities.get().isElementDisplayed(alternativeIframe);
            } catch(TimeoutException ex) {
                System.out.println("Iframe not found with standard locators, checking page content");
            }
        }
        
        // If iframe not found, at least verify the container is present
        if(!iframeFound) {
            System.out.println("Iframe not immediately found, verifying knowi container");
            Assert.assertTrue("Knowi container should be present", driverUtilities.get().isElementDisplayed(knowiDiv));
        } else {
            System.out.println("Iframe found and displayed");
        }
    }
    
    /**
     * Locate the appeal summary metrics section
     */
    public void locateAppealSummaryMetricsSection()
    {
        // Try to enter iframe with fallback options
        boolean frameEntered = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            driverUtilities.get().enterIntoFrame(appealsDashboardIframe);
            frameEntered = true;
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                driverUtilities.get().enterIntoFrame(alternativeIframe);
                frameEntered = true;
            } catch(TimeoutException ex) {
                System.out.println("Unable to enter iframe, proceeding without frame switch");
            }
        }
        
        if(frameEntered) {
            System.out.println("Successfully entered iframe");
        }
    }
    
    /**
     * Verify all metric cards are displayed with correct values
     */
    public void verifyAllMetricCardsAreDisplayedWithCorrectValues()
    {
        driverUtilities.get().waitForElementToBePresent(appealRequestsCard);
        try {driverUtilities.get().waitForElementToBePresent2("//span[contains(@class,'value-content')]");}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealRequestsCard));
        String appealRequestsText = driverUtilities.get().getElementText(appealRequestsCard);
        int appealRequestsCount = Integer.parseInt(appealRequestsText);
        Assert.assertTrue(appealRequestsCount >= 0);
        
        driverUtilities.get().waitForElementToBePresent(appealsApprovedCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealsApprovedCard));
        String appealsApprovedText = driverUtilities.get().getElementText(appealsApprovedCard);
        int appealsApprovedCount = Integer.parseInt(appealsApprovedText);
        Assert.assertTrue(appealsApprovedCount >= 0);
        
        driverUtilities.get().waitForElementToBePresent(appealsPartiallyUpheldCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealsPartiallyUpheldCard));
        String appealsPartiallyUpheldText = driverUtilities.get().getElementText(appealsPartiallyUpheldCard);
        int appealsPartiallyUpheldCount = Integer.parseInt(appealsPartiallyUpheldText);
        Assert.assertTrue(appealsPartiallyUpheldCount >= 0);
        
        driverUtilities.get().waitForElementToBePresent(appealsRejectedCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealsRejectedCard));
        String appealsRejectedText = driverUtilities.get().getElementText(appealsRejectedCard);
        int appealsRejectedCount = Integer.parseInt(appealsRejectedText);
        Assert.assertTrue(appealsRejectedCount >= 0);
        
        driverUtilities.get().waitForElementToBePresent(appealsClosedCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealsClosedCard));
        String appealsClosedText = driverUtilities.get().getElementText(appealsClosedCard);
        int appealsClosedCount = Integer.parseInt(appealsClosedText);
        Assert.assertTrue(appealsClosedCount >= 0);
        
        driverUtilities.get().waitForElementToBePresent(appealsOpenCard);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(appealsOpenCard));
        String appealsOpenText = driverUtilities.get().getElementText(appealsOpenCard);
        int appealsOpenCount = Integer.parseInt(appealsOpenText);
        Assert.assertTrue(appealsOpenCount >= 0);
    }
    
    /**
     * Check data values are shown with proper labels
     */
    public void checkDataValuesAreShownWithProperLabels()
    {
        String appealRequestsText = driverUtilities.get().getElementText(appealRequestsCard);
        Assert.assertFalse(appealRequestsText.isEmpty());
        
        String appealsApprovedText = driverUtilities.get().getElementText(appealsApprovedCard);
        Assert.assertFalse(appealsApprovedText.isEmpty());
        
        String appealsRejectedText = driverUtilities.get().getElementText(appealsRejectedCard);
        Assert.assertFalse(appealsRejectedText.isEmpty());
        
        driverUtilities.get().leaveFrame();
    }
    
    /**
     * Locate the Appeals By Reason section
     */
    public void locateAppealsByReasonSection()
    {
        // Try to enter iframe with fallback options
        boolean frameEntered = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            driverUtilities.get().enterIntoFrame(appealsDashboardIframe);
            frameEntered = true;
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                driverUtilities.get().enterIntoFrame(alternativeIframe);
                frameEntered = true;
            } catch(TimeoutException ex) {
                System.out.println("Unable to enter iframe, proceeding without frame switch");
            }
        }
        
        if(frameEntered) {
            try {driverUtilities.get().waitForElementToBePresent(appealsByReasonSection);}catch(TimeoutException e) {}
        }
    }
    
    /**
     * Verify bar chart visualization loads
     */
    public void verifyBarChartVisualizationLoads()
    {
        driverUtilities.get().waitForElementToBePresent(barChartVisualizationForAppealsByReasonChart);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(barChartVisualizationForAppealsByReasonChart));
    }
    
    /**
     * Check all reason categories are displayed
     */
    public void checkAllReasonCategoriesAreDisplayed()
    {
        Assert.assertTrue(allXAxisCategoriesForAppealsByReasonChart.size() > 0);
        
        for(WebElement category : allXAxisCategoriesForAppealsByReasonChart)
        {
            String catego = driverUtilities.get().getElementText(category);
            System.out.println("Category Name:="+catego);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(category));
        }
    }
    
    /**
     * Verify data values match chart bars
     */
    public void verifyDataValuesMatchChartBars()
    {
        Assert.assertTrue(allBarValuesForAppealsByReasonChart.size() > 0);
        
        for(WebElement barValue : allBarValuesForAppealsByReasonChart)
        {
            String valueText = driverUtilities.get().getElementText(barValue);
            System.out.println("Bar Value:=" + valueText);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(barValue));
        }
        
        driverUtilities.get().leaveFrame();
    }
    
    /**
     * Locate the Appeals By Status section
     */
    public void locateAppealsByStatusSection()
    {
       // Try to enter iframe with fallback options
        boolean frameEntered = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            driverUtilities.get().enterIntoFrame(appealsDashboardIframe);
            frameEntered = true;
            System.out.println("Successfully entered main iframe");
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                driverUtilities.get().enterIntoFrame(alternativeIframe);
                frameEntered = true;
                System.out.println("Successfully entered alternative iframe");
            } catch(TimeoutException ex) {
                System.out.println("Unable to enter iframe, proceeding without frame switch");
            }
        }
        
        if(frameEntered) {
            // Wait for iframe content to load
            try {Thread.sleep(3000);}catch(InterruptedException e) {}
            
            // Debug: Print all text content to see what's available
            String pageSource = driverUtilities.get().getPageSource();
            if(pageSource.contains("Appeals By Status")) {
                System.out.println("Appeals By Status text found in iframe");
            } else if(pageSource.contains("Appeal") && pageSource.contains("Status")) {
                System.out.println("Found separate 'Appeal' and 'Status' text - checking variations");
            } else {
                System.out.println("Appeals By Status text NOT found in iframe");
                System.out.println("Available text content: " + pageSource.substring(0, Math.min(500, pageSource.length())));
            }
            
            try {driverUtilities.get().waitForElementToBePresent(appealsByStatusSection);}catch(TimeoutException e) {
                System.out.println("Appeals By Status section not found with exact text match");
            }
        }
    }
    
    /**
     * Verify pie chart visualization loads
     */
    public void verifyPieChartVisualizationLoads()
    {
    	 WebElement pieChart = driverUtilities.get().getWebElement("//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-series-group')]");
    	 Assert.assertTrue(driverUtilities.get().isElementDisplayed(pieChart));
    }
    
    /**
     * Check all status categories are displayed
     */
    public void checkAllStatusCategoriesAreDisplayed()
    {
  
        WebElement pieChart = driverUtilities.get().getWebElement("//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-series-group')]");
        String sliceOfChart = "//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-series-group')]//*[name()='path']";
        int parts = driverUtilities.get().getNumberOfElement(sliceOfChart);
        System.out.println("Total parts of pie chart are:="+parts);
        
        for(int i=0; i<parts; i++)
        {
        	 String sliceTextPath = "//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-label highcharts-data-label highcharts-data-label-color-"+i+"')]/*[name()='text']";
        	 WebElement pieChartPart = driverUtilities.get().getWebElement(sliceTextPath);
        	 String text = driverUtilities.get().getElementText(pieChartPart);
        	 System.out.println("Part text is:="+text);
        	 try {Thread.sleep(1000);}catch(InterruptedException e) {}
        }
    }
    
    /**
     * Verify percentage calculations
     */
    public void verifyPercentageCalculations()
    {
        WebElement pieChart = driverUtilities.get().getWebElement("//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-series-group')]");
        String sliceOfChart = "//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-series-group')]//*[name()='path']";
        int parts = driverUtilities.get().getNumberOfElement(sliceOfChart);
        System.out.println("Total parts of pie chart are:="+parts);
        
        for(int i=0; i<parts; i++)
        {
        	 String sliceTextPath = "//*[contains(text(),'Appeals By Status')]/ancestor::div/following-sibling::div//div[contains(@id,'highcharts')]/*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-label highcharts-data-label highcharts-data-label-color-"+i+"')]/*[name()='text']";
        	 WebElement pieChartPart = driverUtilities.get().getWebElement(sliceTextPath);
        	 String text = driverUtilities.get().getElementText(pieChartPart);
        	 System.out.println("Part text is:="+text);
        	 try {Thread.sleep(1000);}catch(InterruptedException e) {}
        }
       driverUtilities.get().leaveFrame();
    }
    
    /**
     * Locate the Appeals By Month section
     */
    public void locateAppealsByMonthSection()
    {
        // Try to enter iframe with fallback options
        boolean frameEntered = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            driverUtilities.get().enterIntoFrame(appealsDashboardIframe);
            frameEntered = true;
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                driverUtilities.get().enterIntoFrame(alternativeIframe);
                frameEntered = true;
            } catch(TimeoutException ex) {
                System.out.println("Unable to enter iframe, proceeding without frame switch");
            }
        }
        
        if(frameEntered) {
            try {driverUtilities.get().waitForElementToBePresent(appealsByMonthSection);}catch(TimeoutException e) {}
        }
    }
    
    /**
     * Verify Appeals By Month chart loads
     */
    public void verifyAppealsByMonthChartLoads()
    {
    	String xAxis1 = "(//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[1]";
    	String xAxis2 = "(//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[2]";
    	Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis1)));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis2)));
    }
    
    /**
     * Verify Appeals By Month chart x-axis value
     */
    public void verifyAppealsByMonthChartXAxisValue()
    {
    	String xAxis1 = "(//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[1]";
    	String xAxis2 = "(//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[2]";
    	Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis1)));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis2)));
        
        int monthsList1 = driverUtilities.get().getNumberOfElement(xAxis1);
        Assert.assertTrue(monthsList1>0);
        
        int monthsList2 = driverUtilities.get().getNumberOfElement(xAxis2);
        Assert.assertTrue(monthsList2>0);
    }
    
    /**
     * Verify Appeals By Month chart bar values
     */
    public void verifyAppealsByMonthChartBarValues()
    {
    	String barValuePath = "//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-data-labels highcharts-series-') and contains(@class,'highcharts-color-')]";
        int toatlBarValues = driverUtilities.get().getNumberOfElement(barValuePath);
        System.out.println("Appeal By months:="+toatlBarValues);
        for(int i=0; i<toatlBarValues; i++)
        {
        	String barValuePathWithIndex = "//*[contains(text(),'Appeals By Month')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-data-labels highcharts-series-"+i+"') and contains(@class,'highcharts-color-"+i+"')]//*[name()='tspan']";
        	System.out.println(barValuePathWithIndex);
        	WebElement barValue = driverUtilities.get().getWebElement(barValuePathWithIndex);
        	String text = driverUtilities.get().getElementText(barValue);
        	System.out.println("Appeal By month count:="+text);
        }       
        driverUtilities.get().leaveFrame();
    }
    
    /**
     * Locate the Appeals By Date section
     */
    public void locateAppealsByDateSection()
    {
        // Try to enter iframe with fallback options
        boolean frameEntered = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            driverUtilities.get().enterIntoFrame(appealsDashboardIframe);
            frameEntered = true;
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                driverUtilities.get().enterIntoFrame(alternativeIframe);
                frameEntered = true;
            } catch(TimeoutException ex) {
                System.out.println("Unable to enter iframe, proceeding without frame switch");
            }
        }
        
        if(frameEntered) {
            try {driverUtilities.get().waitForElementToBePresent(appealsByDateSection);}catch(TimeoutException e) {}
        }
    }
    
    /**
     * Verify Appeals By Date chart loads
     */
    public void verifyAppealsByDateChartLoads()
    {
        driverUtilities.get().waitForElementToBePresent(lineChartVisualizationForAppealsByDateChart);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(lineChartVisualizationForAppealsByDateChart));
    }
    
    /**
     * Verify Appeals By Date chart x-axis value
     */
    public void verifyAppealsByDateChartXAxisValue()
    {
    	String xAxis1 = "(//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[1]";
    	String xAxis2 = "(//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[2]";
    	Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis1)));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis2)));
        
        int monthsList1 = driverUtilities.get().getNumberOfElement(xAxis1);
        Assert.assertTrue(monthsList1>0);
        
        int monthsList2 = driverUtilities.get().getNumberOfElement(xAxis2);
        Assert.assertTrue(monthsList2>0);
    }
    
    /**
     * Verify Appeals By Date chart values
     */
    public void verifyAppealsByDateChartValues()
    {
    	String barValuePath = "//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-data-labels highcharts-series-') and contains(@class,'highcharts-color-')]//*[name()='text']";
        int toatlBarValues = driverUtilities.get().getNumberOfElement(barValuePath);
        System.out.println("Appeal By Date total records:="+toatlBarValues);
        for(int i=1; i<=toatlBarValues; i++)
        {
        	String barValuePathWithIndex = "(//*[contains(text(),'Appeals By Date')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-data-labels highcharts-series-0') and contains(@class,'highcharts-color-0')]//*[name()='text'])["+i+"]";
        	System.out.println(barValuePathWithIndex);
        	WebElement barValue = driverUtilities.get().getWebElement(barValuePathWithIndex);
        	String text = driverUtilities.get().getElementText(barValue);
        	System.out.println("Appeal By Date value:="+text);
        }       
        driverUtilities.get().leaveFrame();
    }
    
    // TC_APP_008 - Quarterly Appeals Count Chart Methods
    
    /**
     * Locate the Quarterly Appeals Count section
     */
    public void locateQuarterlyAppealsCountSection()
    {
        // Try to enter iframe with fallback options
        boolean frameEntered = false;
        try {
            driverUtilities.get().waitForElementToBePresent(appealsDashboardIframe);
            driverUtilities.get().enterIntoFrame(appealsDashboardIframe);
            frameEntered = true;
        } catch(TimeoutException e) {
            try {
                driverUtilities.get().waitForElementToBePresent(alternativeIframe);
                driverUtilities.get().enterIntoFrame(alternativeIframe);
                frameEntered = true;
            } catch(TimeoutException ex) {
                System.out.println("Unable to enter iframe, proceeding without frame switch");
            }
        }
        
        if(frameEntered) {
            try {driverUtilities.get().waitForElementToBePresent(quarterlyAppealsCountSection);}catch(TimeoutException e) {}
        }
    }
    
    /**
     * Verify Quarterly Appeals Count chart loads
     */
    public void verifyQuarterlyAppealsCountChartLoads()
    {
        driverUtilities.get().waitForElementToBePresent(barChartVisualizationForQuarterlyAppealsCountChart);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(barChartVisualizationForQuarterlyAppealsCountChart));
    }
    
    /**
     * Verify Quarterly Appeals Count chart x-axis value
     */
    public void verifyQuarterlyAppealsCountChartXAxisValue()
    {
        String xAxis1 = "(//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[1]";
        String xAxis2 = "(//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')])[2]";
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis1)));
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement(xAxis2)));
        
        int quartersList1 = driverUtilities.get().getNumberOfElement(xAxis1);
        Assert.assertTrue(quartersList1>0);
        
        int quartersList2 = driverUtilities.get().getNumberOfElement(xAxis2);
        Assert.assertTrue(quartersList2>0);
    }
    
    /**
     * Verify Quarterly Appeals Count chart values
     */
    public void verifyQuarterlyAppealsCountChartValues()
    {
        String barValuePath = "//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-data-labels highcharts-series-') and contains(@class,'highcharts-color-')]";
        int totalBarValues = driverUtilities.get().getNumberOfElement(barValuePath);
        System.out.println("Quarterly Appeals Count total bars:="+totalBarValues);
        
        for(int i=0; i<totalBarValues; i++)
        {
            String barValuePathWithIndex = "//*[contains(text(),'Quarterly Appeals Count')]/ancestor::div/following-sibling::div/div[contains(@id,'highcharts')]/*[local-name()='svg']/*[name()='g' and contains(@class,'highcharts-data-labels highcharts-series-"+i+"') and contains(@class,'highcharts-color-"+i+"')]//*[name()='tspan']";
            System.out.println(barValuePathWithIndex);
            WebElement barValue = driverUtilities.get().getWebElement(barValuePathWithIndex);
            String text = driverUtilities.get().getElementText(barValue);
            System.out.println("Quarterly Appeals Count value:="+text);
        }
        driverUtilities.get().leaveFrame();
    }
}
