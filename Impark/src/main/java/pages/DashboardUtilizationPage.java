package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class DashboardUtilizationPage extends BasePage 
{
    // Dashboard utilization menu navigation
    @FindBy(how=How.XPATH, using="//ul[@id='menuitemsgrp']//ul[contains(@id,'dashboards')]/ancestor::li")
    public WebElement dashBoardMenu;
    
    @FindBy(how=How.XPATH, using="//a[contains(@href,'utilization')]")
    public WebElement utilizationMenuLink;
    
    // Page content verification
    @FindBy(how=How.XPATH, using="//div[contains(@class,'apexcharts-canvas')]")
    public WebElement chartCanvas;
    
    @FindBy(how=How.XPATH, using="//iframe[@id='knowi-iframe']")
    public WebElement utilizationDashboardIframe;
    
    @FindBy(how=How.XPATH, using="//iframe[contains(@src,'knowi') or @name='c9login']")
    public WebElement alternativeIframe;
    
    // Utilization Sections
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Permit Utilization')]")
    public WebElement permitUtilizationSection;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Scans Heatmap')]")
    public WebElement scansHeatmapSection;
    
    @FindBy(how=How.XPATH, using="(//div[normalize-space(contains(text(),'Ticket Heatmap')) and contains(@class,'cstm-heatmap-top-name')])[2]")
    public WebElement ticketHeatmapSection;
    
    @FindBy(how=How.XPATH, using="(//div[normalize-space(contains(text(),'Timings Heatmap')) and contains(@class,'cstm-heatmap-top-name')])[3]")
    public WebElement timingsHeatmapSection;
    
    // Permit Utilization Section Elements
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Total Permits')]/following-sibling::*[1]")
    public WebElement totalPermitsValue;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Permit Utilization') and not(contains(text(),'Avg'))]/following-sibling::*[1]")
    public WebElement permitUtilizationValue;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Avg. Permit Utilization')]/following-sibling::*[1]")
    public WebElement avgPermitUtilizationValue;
    
    // Scans Heatmap Section Elements
    @FindBy(how=How.XPATH, using="//div[contains(@class,'cstm-heatmap-top-name') and contains(text(),'Scans Heatmap')]")
    public WebElement scansHeatmapTitle;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'No Data')]")
    public WebElement legendNoData;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Low')]")
    public WebElement legendLow;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Medium')]")
    public WebElement legendMedium;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'High')]")
    public WebElement legendHigh;
    
    @FindBy(how=How.XPATH, using="//*[contains(text(),'Extreme')]")
    public WebElement legendExtreme;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Scans Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]")
    public WebElement heatmapGrid;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Scans Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]//*[name()='g' and contains(@class,'apexcharts-yaxis-texts-g')]//*[name()='text']")
    public List<WebElement> scansHeatmapYAxisValues;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Scans Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]//*[name()='g' and contains(@class,'apexcharts-xaxis-texts-g')]//*[name()='text']")
    public List<WebElement> scansHeatmapXAxisValues;
    
    // Ticket Heatmap Section Elements
    @FindBy(how=How.XPATH, using="(//div[normalize-space(contains(text(),'Ticket Heatmap'))]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')])[4]")
    public WebElement ticketHeatmapTitle;
    
    @FindBy(how=How.XPATH, using="(//div[normalize-space(contains(text(),'Ticket Heatmap'))]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')])[4]")
    public WebElement ticketHeatmapGrid;
    
    @FindBy(how=How.XPATH, using="(//div[normalize-space(contains(text(),'Ticket Heatmap'))]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')])[4]//*[name()='g' and contains(@class,'apexcharts-yaxis-texts-g')]//*[name()='text']")
    public List<WebElement> ticketHeatmapYAxisValues;
    
    @FindBy(how=How.XPATH, using="(//div[normalize-space(contains(text(),'Ticket Heatmap'))]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')])[4]//*[name()='g' and contains(@class,'apexcharts-xaxis-texts-g')]//*[name()='text']")
    public List<WebElement> ticketHeatmapXAxisValues;
    
    // Timings Heatmap Section Elements
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Timings Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]")
    public WebElement timingsHeatmapTitle;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Timings Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]")
    public WebElement timingsHeatmapGrid;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Timings Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]//*[name()='g' and contains(@class,'apexcharts-yaxis-texts-g')]//*[name()='text']")
    public List<WebElement> timingsHeatmapYAxisValues;
    
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Timings Heatmap')]/parent::div/following-sibling::div//div[contains(@class,'apexcharts-theme-')]//*[name()='g' and contains(@class,'apexcharts-xaxis-texts-g')]//*[name()='text']")
    public List<WebElement> timingsHeatmapXAxisValues;

    /**
     * Navigate to Dashboard Utilization page
     */
    public void navigateToDashboardUtilization()
    {
        try {driverUtilities.get().waitForElementToBePresent(dashBoardMenu);}catch(TimeoutException e) {}
        driverUtilities.get().clickOnElement(dashBoardMenu);
        try {Thread.sleep(1000);}catch(InterruptedException e) {}
        
        try {driverUtilities.get().waitForElementToBePresent(utilizationMenuLink);}catch(TimeoutException e) {}
        driverUtilities.get().clickOnElement(utilizationMenuLink);
        try {Thread.sleep(3000);}catch(InterruptedException e) {}
    }
    
    /**
     * Verify Dashboard Utilization page loads successfully
     */
    public void verifyDashboardUtilizationPageLoadsSuccessfully()
    {
        try {driverUtilities.get().waitForElementToBePresent(chartCanvas);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(chartCanvas));
    }
    
    /**
     * Verify all utilization sections are visible
     */
    public void verifyAllUtilizationSectionsAreVisible()
    {
  
        
            try {driverUtilities.get().waitForElementToBePresent(permitUtilizationSection);}catch(TimeoutException e) {}
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitUtilizationSection));
            
            try {driverUtilities.get().waitForElementToBePresent(scansHeatmapSection);}catch(TimeoutException e) {}
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(scansHeatmapSection));
            
            try {driverUtilities.get().waitForElementToBePresent(ticketHeatmapSection);}catch(TimeoutException e) {}
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketHeatmapSection));
            
            try {driverUtilities.get().waitForElementToBePresent(timingsHeatmapSection);}catch(TimeoutException e) {}
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(timingsHeatmapSection));
    }
    
    /**
     * Locate Permit Utilization section
     */
    public void locatePermitUtilizationSection()
    {
        try {driverUtilities.get().waitForElementToBePresent(permitUtilizationSection);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitUtilizationSection));
    }
    
    /**
     * Verify Total Permits value
     */
    public void verifyTotalPermitsValue()
    {
        try {driverUtilities.get().waitForElementToBePresent(totalPermitsValue);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(totalPermitsValue));
        String value = driverUtilities.get().getElementText(totalPermitsValue);
        Assert.assertFalse(value.isEmpty());
    }
    
    /**
     * Verify Permit Utilization value
     */
    public void verifyPermitUtilizationValue()
    {
        try {driverUtilities.get().waitForElementToBePresent(permitUtilizationValue);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(permitUtilizationValue));
        String value = driverUtilities.get().getElementText(permitUtilizationValue);
        Assert.assertFalse(value.isEmpty());
    }
    
    /**
     * Verify Avg. Permit Utilization value
     */
    public void verifyAvgPermitUtilizationValue()
    {
        try {driverUtilities.get().waitForElementToBePresent(avgPermitUtilizationValue);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(avgPermitUtilizationValue));
        String value = driverUtilities.get().getElementText(avgPermitUtilizationValue);
        Assert.assertFalse(value.isEmpty());
    }
    
    /**
     * Locate Scans Heatmap section
     */
    public void locateScansHeatmapSection()
    {
        try {driverUtilities.get().waitForElementToBePresent(scansHeatmapSection);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(scansHeatmapSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(scansHeatmapSection));
    }
    
    /**
     * Verify Scans Heatmap title displays
     */
    public void verifyScansHeatmapTitleDisplays()
    {
        try {driverUtilities.get().waitForElementToBePresent(scansHeatmapTitle);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(scansHeatmapTitle));
        String title = driverUtilities.get().getElementText(scansHeatmapTitle);
        Assert.assertTrue(title.contains("Scans Heatmap"));
    }
    
    /**
     * Verify Scans Heatmap legend shows data levels
     */
    public void verifyScansHeatmapLegendShowsDataLevels()
    {
        try {driverUtilities.get().waitForElementToBePresent(legendNoData);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendNoData));
        
        try {driverUtilities.get().waitForElementToBePresent(legendLow);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendLow));
        
        try {driverUtilities.get().waitForElementToBePresent(legendMedium);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendMedium));
        
        try {driverUtilities.get().waitForElementToBePresent(legendHigh);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendHigh));
        
        try {driverUtilities.get().waitForElementToBePresent(legendExtreme);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendExtreme));
    }
    
    /**
     * Verify Scans Heatmap weekly data is displayed
     */
    public void verifyScansHeatmapWeeklyDataIsDisplayed()
    {
        try {driverUtilities.get().waitForElementToBePresent(heatmapGrid);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(heatmapGrid);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(heatmapGrid));
        
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
        
        String[] expectedDays = {"","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        Assert.assertTrue(scansHeatmapYAxisValues.size() > 0);
        for(int i = 0; i < scansHeatmapYAxisValues.size(); i++)
        {
            WebElement yAxisValue = scansHeatmapYAxisValues.get(i);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(yAxisValue));
            String dayText = driverUtilities.get().getElementText(yAxisValue);
            System.out.println("Y-Axis (Day " + (i+1) + "): " + dayText);
            
            if(i < expectedDays.length)
            {
                Assert.assertTrue(dayText.contains(expectedDays[i]));
            }
        }
        
        Assert.assertTrue(scansHeatmapXAxisValues.size() > 0);
        for(int i = 0; i < scansHeatmapXAxisValues.size(); i++)
        {
            WebElement xAxisValue = scansHeatmapXAxisValues.get(i);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(xAxisValue));
            String hourText = driverUtilities.get().getElementText(xAxisValue);
            System.out.println("X-Axis (Hour " + (i+1) + "): " + hourText);
            
            String expectedHour = String.format("%02d:00", i+1);
            Assert.assertTrue(hourText.contains(expectedHour));
        }
    }
    
    /**
     * Locate Ticket Heatmap section
     */
    public void locateTicketHeatmapSection()
    {
        try {driverUtilities.get().waitForElementToBePresent(ticketHeatmapSection);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketHeatmapSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketHeatmapSection));
    }
    
    /**
     * Verify Ticket Heatmap title displays
     */
    public void verifyTicketHeatmapTitleDisplays()
    {
        try {driverUtilities.get().waitForElementToBePresent(ticketHeatmapTitle);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketHeatmapTitle);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketHeatmapTitle));
        String title = driverUtilities.get().getElementText(ticketHeatmapTitle);
        Assert.assertTrue(title.contains("Ticket Heatmap"));
    }
    
    /**
     * Verify Ticket Heatmap legend shows data levels
     */
    public void verifyTicketHeatmapLegendShowsDataLevels()
    {
        try {driverUtilities.get().waitForElementToBePresent(legendNoData);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendNoData));
        
        try {driverUtilities.get().waitForElementToBePresent(legendLow);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendLow));
        
        try {driverUtilities.get().waitForElementToBePresent(legendMedium);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendMedium));
        
        try {driverUtilities.get().waitForElementToBePresent(legendHigh);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendHigh));
        
        try {driverUtilities.get().waitForElementToBePresent(legendExtreme);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendExtreme));
    }
    
    /**
     * Verify Ticket Heatmap weekly data is displayed
     */
    public void verifyTicketHeatmapWeeklyDataIsDisplayed()
    {
        try {driverUtilities.get().waitForElementToBePresent(ticketHeatmapGrid);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(ticketHeatmapGrid);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(ticketHeatmapGrid));
        
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
        
        String[] expectedDays = {"","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        Assert.assertTrue(ticketHeatmapYAxisValues.size() > 0);
        for(int i = 0; i < ticketHeatmapYAxisValues.size(); i++)
        {
            WebElement yAxisValue = ticketHeatmapYAxisValues.get(i);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(yAxisValue));
            String dayText = driverUtilities.get().getElementText(yAxisValue);
            System.out.println("Y-Axis (Day " + (i+1) + "): " + dayText);
            
            if(i < expectedDays.length)
            {
                Assert.assertTrue(dayText.contains(expectedDays[i]));
            }
        }
        
        Assert.assertTrue(ticketHeatmapXAxisValues.size() > 0);
        for(int i = 0; i < ticketHeatmapXAxisValues.size(); i++)
        {
            WebElement xAxisValue = ticketHeatmapXAxisValues.get(i);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(xAxisValue));
            String hourText = driverUtilities.get().getElementText(xAxisValue);
            System.out.println("X-Axis (Hour " + (i+1) + "): " + hourText);
            
            String expectedHour = String.format("%02d:00", i+1);
            Assert.assertTrue(hourText.contains(expectedHour));
        }
    }
    
    /**
     * Locate Timings Heatmap section
     */
    public void locateTimingsHeatmapSection()
    {
        try {driverUtilities.get().waitForElementToBePresent(timingsHeatmapSection);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(timingsHeatmapSection);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(timingsHeatmapSection));
    }
    
    /**
     * Verify Timings Heatmap title displays
     */
    public void verifyTimingsHeatmapTitleDisplays()
    {
        try {driverUtilities.get().waitForElementToBePresent(timingsHeatmapTitle);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(timingsHeatmapTitle);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(timingsHeatmapTitle));
    }
    
    /**
     * Verify Timings Heatmap legend shows data levels
     */
    public void verifyTimingsHeatmapLegendShowsDataLevels()
    {
        try {driverUtilities.get().waitForElementToBePresent(legendNoData);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendNoData));
        
        try {driverUtilities.get().waitForElementToBePresent(legendLow);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendLow));
        
        try {driverUtilities.get().waitForElementToBePresent(legendMedium);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendMedium));
        
        try {driverUtilities.get().waitForElementToBePresent(legendHigh);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendHigh));
        
        try {driverUtilities.get().waitForElementToBePresent(legendExtreme);}catch(TimeoutException e) {}
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(legendExtreme));
    }
    
    /**
     * Verify Timings Heatmap weekly data is displayed
     */
    public void verifyTimingsHeatmapWeeklyDataIsDisplayed()
    {
        try {driverUtilities.get().waitForElementToBePresent(timingsHeatmapGrid);}catch(TimeoutException e) {}
        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(timingsHeatmapGrid);
        Assert.assertTrue(driverUtilities.get().isElementDisplayed(timingsHeatmapGrid));
        
        try {Thread.sleep(2000);}catch(InterruptedException e) {}
        
        String[] expectedDays = {"","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        Assert.assertTrue(timingsHeatmapYAxisValues.size() > 0);
        for(int i = 0; i < timingsHeatmapYAxisValues.size(); i++)
        {
            WebElement yAxisValue = timingsHeatmapYAxisValues.get(i);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(yAxisValue));
            String dayText = driverUtilities.get().getElementText(yAxisValue);
            System.out.println("Y-Axis (Day " + (i+1) + "): " + dayText);
            
            if(i < expectedDays.length)
            {
                Assert.assertTrue(dayText.contains(expectedDays[i]));
            }
        }
        
        Assert.assertTrue(timingsHeatmapXAxisValues.size() > 0);
        for(int i = 0; i < timingsHeatmapXAxisValues.size(); i++)
        {
            WebElement xAxisValue = timingsHeatmapXAxisValues.get(i);
            Assert.assertTrue(driverUtilities.get().isElementDisplayed(xAxisValue));
            String hourText = driverUtilities.get().getElementText(xAxisValue);
            System.out.println("X-Axis (Hour " + (i+1) + "): " + hourText);
            
            String expectedHour = String.format("%02d:00", i+1);
            Assert.assertTrue(hourText.contains(expectedHour));
        }
    }
}


