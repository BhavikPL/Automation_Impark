package pages;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import dev.failsafe.TimeoutExceededException;
import utility.Util;

public class AdministrationPage extends BasePage
{
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'Hearing Configuration')]")
	public WebElement hearingConfigurationOption;
	
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'Hearing Configuration')]/parent::div/following-sibling::div//button")
	public WebElement hearingEnableButton;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Enable Hearing Schedule Configuration')]/parent::div/following-sibling::button")
	public WebElement enableHearingSchedulingButton;
	
	//hearing configuration locators
	@FindBy(how=How.XPATH, using="//input[contains(@placeholder,'Select start date')]")
	public WebElement startDateHearing;
	
	@FindBy(how=How.XPATH, using="//input[contains(@placeholder,'Select end date')]")
	public WebElement endDateHearing;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Select custom date')]/following-sibling::div//input")
	public WebElement customDateField;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Date')]")
	public WebElement addDateButton;
	
	// Additional locators needed for Thursday-specific configuration
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add More')]")
	public WebElement addMoreButton;

	@FindBy(how=How.XPATH, using="//img[contains(@alt,'delete')]")
	public WebElement deleteTimeSlotButton;
	
	public void navigateToHearigConfigAndEnableIt()
	{
		driverUtilities.get().makeElementVisibleIntoScreen(hearingConfigurationOption);
		driverUtilities.get().clickOnElement(hearingEnableButton);
	}
	
	public void enableHearingSchedulingOption()
	{
		driverUtilities.get().clickOnElement(enableHearingSchedulingButton);
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
	}
	
	private void clearDateField(WebElement dateField) throws AWTException
	{
		driverUtilities.get().clickOnElement(dateField);
		for(int i=1; i<=12; i++)
		{
			driverUtilities.get().keyPress("back space");
			driverUtilities.get().keyRelease("back space");
			try {Thread.sleep(50);}catch(InterruptedException e) {}
		}
		
		for(int i=1; i<=12; i++)
		{
			driverUtilities.get().keyPress("delete");
			driverUtilities.get().keyRelease("delete");
			try {Thread.sleep(50);}catch(InterruptedException e) {}
		}
	}
	
	public void enterStartDateAndEndDate(String days) throws AWTException
	{
		try{driverUtilities.get().waitForElementToBePresent(startDateHearing);}catch(TimeoutException e) {}
		driverUtilities.get().makeElementVisibleIntoScreen(driverUtilities.get().getWebElement("//*[contains(text(),'Enable Hearing Schedule Configuration')]"));
		clearDateField(startDateHearing);
		clearDateField(endDateHearing);
		driverUtilities.get().clickOnElement(startDateHearing);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		String date = Util.getCurrentSystemDate("dd");
		if(date.startsWith("0"))
		{
			date = date.substring(1);
		}
		String month = Util.getCurrentSystemDate("MMMMMM");
		String datePath = "//div[contains(@aria-label,'"+month+"') and text()='"+date+"']";
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(datePath));
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		
		
		
		String futureDate = Util.getNextSystemDate("MM/dd/yyyy", days);
		//String futureDD = futureDate.split("-")[0];
		//if(futureDD.startsWith("0"))
		//{
			//futureDD = futureDD.substring(1);
		//}
		//String futureMonth = futureDate.split("-")[1];
		//String futureYear = futureDate.split("-")[2];
		//driverUtilities.get().clickOnElement(endDateHearing);
		//try {Thread.sleep(1000);}catch(InterruptedException e) {}
		//String endDatePath = "//div[contains(@aria-label,'"+futureMonth+"') and text()='"+futureDD+"']";
		//driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement(endDatePath));
		driverUtilities.get().typeIntoTextBox(endDateHearing, futureDate);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void selectDayAndEnterStartAndEndTime(String day, String startTime, String endTime, String totalHearing)
	{
		String selectDayPath = "//input[contains(@id,'"+day+"')]/following-sibling::label/parent::*/parent::*";
		WebElement selectDayCheckbox = driverUtilities.get().getWebElement(selectDayPath);
		String attClass = driverUtilities.get().getAttribute(selectDayCheckbox, "class");
		boolean isChecked = attClass.contains("shadow");
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		if(!isChecked)
		{
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(selectDayCheckbox);
			driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), selectDayCheckbox);
			
			String enterStartTimePath = "(//input[contains(@id,'"+day+"')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[1]";
			WebElement enterStartTime = driverUtilities.get().getWebElement(enterStartTimePath);
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(enterStartTime);
			driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), enterStartTime);
			WebElement timeOption =  driverUtilities.get().getWebElement(("//li[text()='"+startTime+"']"));
			driverUtilities.get().makeElementVisibleIntoScreen(timeOption);
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(selectDayCheckbox);
			driverUtilities.get().clickOnElement(timeOption);
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			
			String enterEndTimePath = "(//input[contains(@id,'"+day+"')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[2]";
			WebElement enterEndTime = driverUtilities.get().getWebElement(enterEndTimePath);
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(enterEndTime);
			driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), enterEndTime);
			WebElement endTimeOption =  driverUtilities.get().getWebElement(("//li[text()='"+endTime+"']"));
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(endTimeOption);
			driverUtilities.get().clickOnElement(endTimeOption);
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(selectDayCheckbox);
			String noOfHearingPath = "//label[contains(text(),'"+day+"')]/ancestor::div/following-sibling::div//input[contains(@type,'checkbox')]/following-sibling::label[contains(text(),'Number of hearings')]";
			WebElement noOfHearing = driverUtilities.get().getWebElement(noOfHearingPath);
			boolean isNoOfHearingCheckboxChecked = driverUtilities.get().isElementChecked(noOfHearing);
			if(!isNoOfHearingCheckboxChecked)
			{
				driverUtilities.get().clickOnElement(noOfHearing);
				driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(driverUtilities.get().getWebElement("(//label[contains(text(),'"+day+"')]/ancestor::div/following-sibling::div//input[contains(@placeholder,'Number of hearings')])[1]"));
				driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement("(//label[contains(text(),'"+day+"')]/ancestor::div/following-sibling::div//input[contains(@placeholder,'Number of hearings')])[1]"), totalHearing);
			}
		}
	}
	
	public void clickOnSaveConfiguration()
	{
		String saveConfigPath = "(//*[contains(text(),'Hearing Configuration')]/parent::div/following-sibling::div//button[contains(text(),'Save Configuration')])[2]";
		WebElement saveConfigButton = driverUtilities.get().getWebElement(saveConfigPath);
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(saveConfigButton);
		driverUtilities.get().clickOnElement(saveConfigButton);
	}
	
	public void verifyHearingConfigurationSaved()
	{
		String messagePath = "//*[contains(text(),'hearing schedule rule added/updated successfully')]";
		WebElement configSaveMessage = driverUtilities.get().getWebElement(messagePath);
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(configSaveMessage));
		try {driverUtilities.get().waitForElementDisappear(configSaveMessage);}catch(TimeoutException e) {}
	}
	
	
	/**
	 * Configure specific time slot for Thursday
	 */
	private void configureThursdayTimeSlot(int slotNumber, String startTime, String endTime, String hearingCount) {
	    try {
	        String day = "Thursday";
	        
	        // Configure start time - EXACT copy of your working approach
	        String enterStartTimePath = "(//input[contains(@id,'weekday-"+day+"')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[" + (slotNumber * 2 - 1) + "]";
	        WebElement enterStartTime = driverUtilities.get().getWebElement(enterStartTimePath);
	        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(enterStartTime);
	        driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), enterStartTime);
	        WebElement timeOption = driverUtilities.get().getWebElement(("//li[text()='"+startTime+"']"));
	        driverUtilities.get().makeElementVisibleIntoScreen(timeOption);
	        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(enterStartTime);
	        driverUtilities.get().clickOnElement(timeOption);
	        try {Thread.sleep(1000);}catch(InterruptedException e) {}
	        
	        // Configure end time - EXACT copy of your working approach  
	        String enterEndTimePath = "(//input[contains(@id,'weekday-"+day+"')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[" + (slotNumber * 2) + "]";
	        WebElement enterEndTime = driverUtilities.get().getWebElement(enterEndTimePath);
	        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(enterEndTime);
	        driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), enterEndTime);
	        WebElement endTimeOption = driverUtilities.get().getWebElement(("//li[text()='"+endTime+"']"));
	        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(endTimeOption);
	        driverUtilities.get().clickOnElement(endTimeOption);
	        try {Thread.sleep(1000);}catch(InterruptedException e) {}
	        
	        // Configure number of hearings - EXACT copy of your working approach with slotNumber fix
	        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(driverUtilities.get().getWebElement("//input[contains(@id,'weekday-"+day+"')]"));
	        String noOfHearingPath = "(//label[contains(text(),'"+day+"')]/ancestor::div/following-sibling::div//input[contains(@type,'checkbox')]/following-sibling::label[contains(text(),'Number of hearings')])[" + slotNumber + "]";
	        WebElement noOfHearing = driverUtilities.get().getWebElement(noOfHearingPath);
	        boolean isNoOfHearingCheckboxChecked = driverUtilities.get().isElementChecked(noOfHearing);
	        if(!isNoOfHearingCheckboxChecked)
	        {
	            driverUtilities.get().clickOnElement(noOfHearing);
	            driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(driverUtilities.get().getWebElement("(//label[contains(text(),'"+day+"')]/ancestor::div/following-sibling::div//input[contains(@placeholder,'Number of hearings')])["+slotNumber+"]"));
	            driverUtilities.get().typeIntoTextBox(driverUtilities.get().getWebElement("(//label[contains(text(),'"+day+"')]/ancestor::div/following-sibling::div//input[contains(@placeholder,'Number of hearings')])["+slotNumber+"]"), hearingCount);
	        }
	        
	    } catch(Exception e) {
	        System.out.println("Error configuring Thursday time slot " + slotNumber + ": " + e.getMessage());
	    }
	}
	
	/**
	 * Configure Thursday occurrence for first and third Thursdays only
	 */
	private void configureThursdayOccurrence() {
	    try {
	        // Configure first and third Thursday occurrences
	        String[] occurrences = {"1", "2", "3", "4", "5"};
	        String[] occurrenceNames = {"First", "Second", "Third", "Fourth", "Fifth"};
	        
	        for(int i = 0; i < occurrences.length; i++) {
	            String checkboxPath = "//input[@value='" + occurrences[i] + "']";
	            try {
	                WebElement checkbox = driverUtilities.get().getWebElement(checkboxPath);
	                boolean isChecked = driverUtilities.get().isElementChecked(checkbox);
	                
	                if(occurrenceNames[i].equals("First") || occurrenceNames[i].equals("Third")) {
	                    // Check first and third
	                    if(!isChecked) {
	                        driverUtilities.get().clickOnElement(checkbox);
	                    }
	                } else {
	                    // Uncheck others
	                    if(isChecked) {
	                        driverUtilities.get().clickOnElement(checkbox);
	                    }
	                }
	            } catch(Exception e) {
	                // Element not found, continue
	            }
	        }
	        
	    } catch(Exception e) {
	        System.out.println("Error configuring Thursday occurrence: " + e.getMessage());
	    }
	}

	/**
	 * Delete existing configurations for all days except Thursday
	 */
	public void deleteExistingConfigurationsExceptThursday() {
	    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Friday", "Saturday"};
	    
	    for(String day : days) {
	        try {
	            String dayCheckboxPath = "//input[contains(@id,'weekday-"+day+"')]";
	            WebElement dayCheckbox = driverUtilities.get().getWebElement(dayCheckboxPath);
	            
	            boolean isChecked = driverUtilities.get().isElementChecked(dayCheckbox);
	            
	            if(isChecked) {
	                driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(dayCheckbox);
	                driverUtilities.get().clickOnElement(dayCheckbox);
	                try {Thread.sleep(500);} catch(InterruptedException e) {}
	            }
	        } catch(Exception e) {
	            System.out.println("Day " + day + " checkbox not found: " + e.getMessage());
	        }
	    }
	}
	/**
	 * Check if Thursday configuration already exists with correct time slots
	 */
	private boolean isThursdayConfigurationComplete(String startTime1, String endTime1, String startTime2, String endTime2) {
	    try {
	        // Check if Thursday is selected
	        String selectDayPath = "//input[contains(@id,'weekday-Thursday')]/following-sibling::label/parent::*/parent::*";
	        WebElement selectDayCheckbox = driverUtilities.get().getWebElement(selectDayPath);
	        String attClass = driverUtilities.get().getAttribute(selectDayCheckbox, "class");
	        boolean isChecked = attClass.contains("shadow");
	        
	        if(!isChecked) {
	            return false;
	        }
	        
	        // Check if both time slots exist with correct values
	        String firstStartTimePath = "(//input[contains(@id,'weekday-Thursday')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[1]";
	        String firstEndTimePath = "(//input[contains(@id,'weekday-Thursday')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[2]";
	        String secondStartTimePath = "(//input[contains(@id,'weekday-Thursday')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[3]";
	        String secondEndTimePath = "(//input[contains(@id,'weekday-Thursday')]/parent::div/following-sibling::div//input[contains(@placeholder, 'HH:mm')])[4]";
	        
	        try {
	            WebElement startTime1Element = driverUtilities.get().getWebElement(firstStartTimePath);
	            WebElement endTime1Element = driverUtilities.get().getWebElement(firstEndTimePath);
	            WebElement startTime2Element = driverUtilities.get().getWebElement(secondStartTimePath);
	            WebElement endTime2Element = driverUtilities.get().getWebElement(secondEndTimePath);
	            
	            String actualStartTime1 = driverUtilities.get().getAttribute(startTime1Element, "value");
	            String actualEndTime1 = driverUtilities.get().getAttribute(endTime1Element, "value");
	            String actualStartTime2 = driverUtilities.get().getAttribute(startTime2Element, "value");
	            String actualEndTime2 = driverUtilities.get().getAttribute(endTime2Element, "value");
	            
	            return convertTimeFormat(startTime1).equals(actualStartTime1) &&
	                   convertTimeFormat(endTime1).equals(actualEndTime1) &&
	                   convertTimeFormat(startTime2).equals(actualStartTime2) &&
	                   convertTimeFormat(endTime2).equals(actualEndTime2);
	        } catch(Exception e) {
	            return false;
	        }
	        
	    } catch(Exception e) {
	        System.out.println("Error checking Thursday configuration: " + e.getMessage());
	        return false;
	    }
	}

	/**
	 * Verify and skip if Thursday is already configured correctly
	 */
	public void verifyAndSkipIfThursdayConfigured() {
	    if(isThursdayConfigurationComplete("9:00 AM", "10:00 AM", "10:00 AM", "11:00 AM")) {
	        System.out.println("Thursday configuration is already complete. Skipping configuration steps.");
	    }
	}

	
	/**
	 * Configure Thursday hearing slots specifically for first and third Thursdays
	 * with 9-10 AM and 10-11 AM time slots
	 */
	public void configureThursdayHearingSlotsForFirstAndThird(String startTime1, String endTime1, String startTime2, String endTime2, String hearingCount) {
	    // First, delete any existing configurations for other days
	    deleteExistingConfigurationsExceptThursday();
	    
	    // Configure Thursday checkbox selection
	    String day = "Thursday";
	    String thursdayCheckboxPath = "//input[contains(@id,'weekday-"+day+"')]";
	    WebElement thursdayCheckbox = driverUtilities.get().getWebElement(thursdayCheckboxPath);
	    
	    // Check if Thursday is already selected
	    boolean isThursdayChecked = driverUtilities.get().isElementChecked(thursdayCheckbox);
	    
	    if(!isThursdayChecked) {
	        driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(thursdayCheckbox);
	        driverUtilities.get().clickOnElement(thursdayCheckbox);
	        try {Thread.sleep(2000);} catch(InterruptedException e) {}
	    }
	    
	    // Wait for the time slots section to appear
	    try {Thread.sleep(1000);} catch(InterruptedException e) {}
	    
	    // Configure first time slot (9-10 AM)
	    configureThursdayTimeSlot(1, startTime1, endTime1, hearingCount);
	    
	    // Add and configure second time slot (10-11 AM)
	    addAndConfigureSecondTimeSlot(startTime2, endTime2, hearingCount);
	    
	    // Configure first and third Thursday occurrence
	    configureThursdayOccurrence();
	}
	
	/**
	 * Add second time slot if not already present and configure it
	 */
	private void addAndConfigureSecondTimeSlot(String startTime2, String endTime2, String hearingCount) {
	    try {
	        // Check if second time slot already exists
	        String secondSlotPath = "(//input[contains(@id,'weekday-Thursday')]/ancestor::div//input[contains(@placeholder, 'HH:mm')])[3]";
	        
	        try {
	            driverUtilities.get().getWebElement(secondSlotPath);
	        } catch(Exception e) {
	            // Second slot doesn't exist, click "Add More" button
	            String addMorePath = "//input[contains(@id,'weekday-Thursday')]/ancestor::div//button[contains(text(),'Add More')]";
	            WebElement addMoreBtn = driverUtilities.get().getWebElement(addMorePath);
	            driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(addMoreBtn);
	            driverUtilities.get().clickOnElement(addMoreBtn);
	            try {Thread.sleep(2000);} catch(InterruptedException ex) {}
	        }
	        
	        // Configure second time slot
	        configureThursdayTimeSlot(2, startTime2, endTime2, hearingCount);
	        
	    } catch(Exception e) {
	        System.out.println("Error adding/configuring second time slot: " + e.getMessage());
	    }
	}

	

	/**
	 * Convert time format from "9:00 AM" to "09:00"
	 */
	private String convertTimeFormat(String time) {
	    try {
	        String[] parts = time.split(" ");
	        String timePart = parts[0];
	        String ampm = parts[1];
	        
	        String[] hourMin = timePart.split(":");
	        int hour = Integer.parseInt(hourMin[0]);
	        String minute = hourMin[1];
	        
	        if(ampm.equalsIgnoreCase("PM") && hour != 12) {
	            hour += 12;
	        } else if(ampm.equalsIgnoreCase("AM") && hour == 12) {
	            hour = 0;
	        }
	        
	        return String.format("%02d:%s", hour, minute);
	        
	    } catch(Exception e) {
	        System.out.println("Error converting time format: " + e.getMessage());
	        return time;
	    }
	}
}
