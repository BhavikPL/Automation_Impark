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
import path.Path;
import utility.Util;

public class ManualTicketsPage extends BasePage
{
	@FindBy(how=How.XPATH, using="//ul[@id='ticketmanagement']//a[contains(@href,'ticketreporting')]/parent::li")
	public WebElement noticeListView;
	
	@FindBy(how=How.XPATH, using="//ul[@id='manualcitations']//a[contains(@href,'citation-image')]/parent::li")
	public WebElement manualImageTicketCreationMenu;
	
	@FindBy(how=How.XPATH, using="//ul[@id='manualcitations']//a[contains(@href,'create-citation')]/parent::li")
	public WebElement createTicketMenu;
	
	// create ticket locators
	@FindBy(how=How.XPATH, using="//input[@name='citation_number']")
	public WebElement citationNumberTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='timestamp']")
	public WebElement issueDateInput;
	
	@FindBy(how=How.XPATH, using="//input[@name='badge_id']")
	public WebElement badgeIDTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='officer_name']")
	public WebElement officerTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='badge_id']")
	public WebElement officerIDBox;

	@FindBy(how=How.XPATH, using="//input[@name='lp_number']")
	public WebElement plateNumberTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='state']")
	public WebElement stateTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='make']")
	public WebElement vehMakeTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='model']")
	public WebElement vehModelTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='color']")
	public WebElement vehColorTextBox;

	@FindBy(how=How.XPATH, using="//select[@name='body_style']")
	public WebElement bodyStyleDropdown;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Enter Lot']")
	public WebElement lotTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='block']")
	public WebElement blockTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='street']")
	public WebElement streetTextBox;

	@FindBy(how=How.XPATH, using="//select[@name='code']")
	public WebElement vioCodeDropdown;

	@FindBy(how=How.XPATH, using="//select[@name='description']")
	public WebElement descriptionDropdown;

	@FindBy(how=How.XPATH, using="//input[@name='fine']")
	public WebElement fineTextBox;

	@FindBy(how=How.XPATH, using="//input[@name='late_fine']")
	public WebElement paidAfterTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='remark_1']")
	public WebElement remarksTextArea;

	@FindBy(how=How.XPATH, using="//button[text()='Submit']")
	public WebElement submitButton;

	@FindBy(how=How.XPATH, using="//button[text()='Upload Image']")
	public WebElement uploadImageButton;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Citation created successfully!')]")
	public WebElement successTicketMessage;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Okay')]")
	public WebElement okayButtonOfMessage;
	
	//edit ticket
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'State')]/following-sibling::select")
	public WebElement selectState;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Vehicle Make')]/following-sibling::select")
	public WebElement selectVehicleMake;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Vehicle Model')]/following-sibling::select")
	public WebElement selectVehicleModel;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Vehicle Color')]/following-sibling::select")
	public WebElement selectVehicleColor;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Remark 1')]/following-sibling::input")
	public WebElement editRemark1;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Reason for Edit')]/following-sibling::textarea")
	public WebElement reasonForEditTextArea;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'edit-citationonly-submit')]/button[contains(text(),'Submit')]")
	public WebElement editTicketSubmitButton;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Violation Code')]/following-sibling::select")
	public WebElement selectVioCodeList;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Body Style')]/following-sibling::select")
	public WebElement selectBodyStyleList;
	
	@FindBy(how=How.XPATH, using="//label[contains(normalize-space(.), 'Violation Description')]/following-sibling::select")
	public WebElement updatedDescriptionDrowDown;
	
	public void verifyManualTicketsMenus()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(manualImageTicketCreationMenu));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(createTicketMenu));
	}
	
	public void verifyCreateTicketPage()
	{
		try {driverUtilities.get().waitForElementToBePresent2("//h4[contains(text(),'Header')]/following-sibling::div//label[contains(text(),'ISSUE DATE')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h3[contains(normalize-space(.), 'Create Tickets')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Header')]/following-sibling::div//label[contains(text(),'Citation')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Header')]/following-sibling::div//label[contains(text(),'ISSUE DATE')]")));
		
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Officer')]/following-sibling::div//label[contains(text(),'OFFICER')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Citation Type')]/following-sibling::div//label[contains(text(),'Warning')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Vehicle')]/following-sibling::div//label[contains(text(),'PLATE')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Vehicle')]/following-sibling::div//label[contains(text(),'STATE')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Vehicle')]/following-sibling::div//label[contains(text(),'VEH MAKE')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Vehicle')]/following-sibling::div//label[contains(text(),'VEH MODEL')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Vehicle')]/following-sibling::div//label[contains(text(),'VEH COLOR')]")));
	
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Vehicle')]/following-sibling::div//label[contains(text(),'BODY STYLE')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Location')]/following-sibling::div//label[contains(text(),'Block')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Location')]/following-sibling::div//label[contains(text(),'Street')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Violation')]/following-sibling::div//label[contains(text(),'VIO CODE')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Violation')]/following-sibling::div//label[contains(text(),'DESCRIPTION')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Violation')]/following-sibling::div//label[contains(text(),'FINE')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Violation')]/following-sibling::div//label[contains(text(),'PAID AFTER')]")));
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h4[contains(text(),'Comments')]/following-sibling::div//label[contains(text(),'REMARKS')]")));
	}
	
	public void clickOnCreateTicketOption()
	{
		driverUtilities.get().clickOnElement(createTicketMenu);
	}
	
	public void clickOnNoticeListViewOption()
	{
		driverUtilities.get().clickOnElement(noticeListView);
	}
	
	public String enterCitationValue()
	{
		driverUtilities.get().waitForElement(citationNumberTextBox);
		driverUtilities.get().clearTextBox(citationNumberTextBox);
		String citationVal = Util.generateRandomNumber(10);
		driverUtilities.get().typeIntoTextBox(citationNumberTextBox, citationVal);
		return citationVal;
	}
	
	public void selectsTodayDateForIssueDate() throws AWTException
	{		
		String dateTimeToSet = Util.getCurrentSystemDate("dd-MM-yyyy' 'HH:mm");
		driverUtilities.get().setAttributeOfElement(issueDateInput, "value", dateTimeToSet);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		driverUtilities.get().keyPress("enter");
		driverUtilities.get().keyRelease("enter");
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void selectPreviousDateAsIssueDate() throws AWTException
	{
		String previousDate = Util.getPreviousSystemDate("dd-MM-yyyy", Settings.maxAppealDays);
		driverUtilities.get().setTextOfElement(issueDateInput, previousDate);
		String time = Util.getCurrentSystemDate("HH:mm");
		driverUtilities.get().keyPress("tab");
		driverUtilities.get().keyRelease("tab");
		try {Thread.sleep(500);}catch(InterruptedException e) {}
		driverUtilities.get().setTextOfElement(issueDateInput, time);
	}
	
	public String verifyBadgeID()
	{
		String isBadge = Settings.isBadgeID;
		String badgeID="";
		if(isBadge.equalsIgnoreCase("true"))
		{
			badgeID = driverUtilities.get().getAttribute(badgeIDTextBox,"value");
		}
		return badgeID;
	}
	
	public String selectOfficer()
	{
		int index = Util.getRandomNumberOneToTen();
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), officerTextBox);
		try {Thread.sleep(700);}catch(InterruptedException e) {}
		//driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), driverUtilities.get().getWebElement("//input[@name='officer_name']/following-sibling::datalist/option["+index+"]"));
		//driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='officer_name']/following-sibling::datalist/option["+index+"]"));
		driverUtilities.get().clickByjavaScript(driverUtilities.get().getWebElement("//input[@name='officer_name']/following-sibling::datalist/option["+index+"]"));
		String officer = driverUtilities.get().getElementAttribute(officerTextBox, "value");
		return officer;
	}
	
	public void enterOfficer()
	{
		String officerField=Settings.isOfficerField;
		if(officerField.equalsIgnoreCase("true"))
		{
			try
			{
				driverUtilities.get().typeIntoTextBox(officerTextBox, Settings.officerName);
			}
			catch(NoSuchElementException e)
			{
				driverUtilities.get().typeIntoTextBox(officerIDBox, Settings.officerName);
			}
		}
	}
	
	public void enterState()
	{
		driverUtilities.get().clearTextBox(stateTextBox);
		driverUtilities.get().typeIntoTextBox(stateTextBox, Settings.stateName);
	}
	
	public void editState()
	{
		driverUtilities.get().selectElementFromList(selectState, Settings.editStateName);
	}
	
	public void enterVehMake()
	{
		driverUtilities.get().typeIntoTextBox(vehMakeTextBox, Settings.make);
	}
	
	public void editVehMake()
	{
		driverUtilities.get().selectElementFromList(selectVehicleMake, Settings.editMake);
	}
	
	public void enterVehModel()
	{
		String model = Settings.canSelectModel;
		if( model.equalsIgnoreCase("true"))
		{
			driverUtilities.get().typeIntoTextBox(vehModelTextBox, Settings.model);
		}
	}
	
	public void editVehModel()
	{
		String model = Settings.canSelectModel;
		if( model.equalsIgnoreCase("true"))
		{
			driverUtilities.get().typeIntoTextBox(selectVehicleModel, Settings.editModel);
		}
	}
	
	public void enterVehColor()
	{
		driverUtilities.get().typeIntoTextBox(vehColorTextBox, Settings.color);
	}
	
	public void editVehColor()
	{
		driverUtilities.get().typeIntoTextBox(selectVehicleColor, Settings.editColor);
	}
	
	public void enterBlock()
	{
		String seperateBlock = Settings.isSeperateBlock;
		if(seperateBlock.equalsIgnoreCase("true"))
		{
			driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(blockTextBox);
			driverUtilities.get().clickOnElement(blockTextBox);
			String block = Settings.block;
			driverUtilities.get().setTextOfElement(blockTextBox, block);
		}
	}
	
	public void editBlock()
	{
		driverUtilities.get().clearTextBox(blockTextBox);
		driverUtilities.get().typeIntoTextBox(blockTextBox , Settings.editBlock);
	}
	
	public void enterLot()
	{
		String isLot = Settings.isLot;
		
		if(isLot.equalsIgnoreCase("true"))
		{
			System.out.println("Before Lot");
			try{driverUtilities.get().typeIntoTextBox(lotTextBox, Settings.lot);}catch(NoSuchElementException e) {}
			System.out.println("After Lot");
		}
	}
	
	public String getBlock()
	{
		String isBlock = Settings.isSeperateBlock;
		String blockVal="";
		if(isBlock.equalsIgnoreCase("true"))
		{
			System.out.println("Before block");
			blockVal= driverUtilities.get().getAttribute(blockTextBox, "value");
			System.out.println("After block");
		}
		return blockVal;
	}
	
	public String getStreet()
	{
		String isStreet = Settings.isSeperateSteet;
		String streetVal="";
		if(streetVal.equalsIgnoreCase("true"))
		{
			System.out.println("Before Street");
			streetVal= driverUtilities.get().getAttribute(streetTextBox, "value");
			System.out.println("After Street");
		}
		return streetVal;
	}
	
	public void enterStreet()
	{
		String seperateStreet = Settings.isSeperateSteet;
		if(seperateStreet.equalsIgnoreCase("true"))
		{
			driverUtilities.get().typeIntoTextBox(streetTextBox, Settings.street);
		}
	}
	
	public void editStreet()
	{
		driverUtilities.get().typeIntoTextBox(streetTextBox, Settings.street);
	}
	
	public String enterPlateValue()
	{
		driverUtilities.get().waitForElement(plateNumberTextBox);
		driverUtilities.get().clearTextBox(plateNumberTextBox);
		String plate = "P"+Util.generateRandomNumber(8);
		driverUtilities.get().typeIntoTextBox(plateNumberTextBox, plate);
		return plate;
	}
	
	public void enterPlateValue(String plateNumber)
	{
		driverUtilities.get().waitForElement(plateNumberTextBox);
		driverUtilities.get().clearTextBox(plateNumberTextBox);
		driverUtilities.get().typeIntoTextBox(plateNumberTextBox, plateNumber);
	}
	
	public String selectState()
	{
		int index = Util.getRandomNumberOneToTwenty();
		driverUtilities.get().clickOnElement(stateTextBox);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='state']/following-sibling::datalist/option["+index+"]"));
		String state = driverUtilities.get().getElementAttribute(stateTextBox, "value");
		return state;
	}
	
	public String selectVehMake()
	{
		int index = Util.getRandomNumberOneToTwenty();
		driverUtilities.get().clickOnElement(vehMakeTextBox);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='make']/following-sibling::datalist/option["+index+"]"));
		String vehMaker = driverUtilities.get().getElementAttribute(vehMakeTextBox, "value");
		return vehMaker;
	}
	
	public String selectVehModel()
	{
		int index = Util.getRandomNumberOneToTwenty();
		driverUtilities.get().clickOnElement(vehModelTextBox);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='model']/following-sibling::datalist/option["+index+"]"));
		String model = driverUtilities.get().getElementAttribute(vehModelTextBox, "value");
		return model;
	}
	
	public String selectVehColor()
	{
		int index = Util.getRandomNumberOneToTwenty();
		driverUtilities.get().clickOnElement(vehColorTextBox);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='color']/following-sibling::datalist/option["+index+"]"));
		String color = driverUtilities.get().getElementAttribute(vehColorTextBox, "value");
		return color;
	}
	
	public String selectBodyStyle()
	{
		String style="";
		int index = Util.getRandomNumberOneToFive();
		String body = Settings.canSelectBody;
		if( body.equalsIgnoreCase("true"))
		{
			driverUtilities.get().selectElementFromListIndex(bodyStyleDropdown, index);
			style = driverUtilities.get().getFirstSelectedOptionFromList(bodyStyleDropdown);
			return style;
		}
		return style;
	}
	
	public String editBodyStyle()
	{
		int index = Util.getRandomNumberOneToFive();
		driverUtilities.get().selectElementFromListIndex(selectBodyStyleList, index);
		String style = driverUtilities.get().getFirstSelectedOptionFromList(selectBodyStyleList);
		return style;
	}
	
	public String selectBlock()
	{
		try {driverUtilities.get().typeIntoTextBox(vehMakeTextBox, Settings.block);}catch(NoSuchElementException e){}
		return Settings.block;
	}
	
	public String selectStreet()
	{
		int index = Util.getRandomNumberOneToTen();
		driverUtilities.get().clickOnElement(streetTextBox);
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//input[@name='street']/following-sibling::datalist/option["+index+"]"));
		String street = driverUtilities.get().getElementAttribute(streetTextBox, "value");
		return street;
	}
	
	public String selectVioCode()
	{
		String flag = Settings.canVioCode;
		String vioCode = "";
		
		if(flag.equalsIgnoreCase("true"))
		{
			try{driverUtilities.get().makeElementVisibleIntoScreen(paidAfterTextBox);}catch(NoSuchElementException e) {}
			int index = Util.getRandomNumberOneToFive();
			try
			{
				driverUtilities.get().selectElementFromListIndex(vioCodeDropdown, index);
			}
			catch(NoSuchElementException e)
			{
				driverUtilities.get().selectElementFromListIndex(vioCodeDropdown, 1);
			}
			vioCode = driverUtilities.get().getFirstSelectedOptionFromList(vioCodeDropdown);
		}
		return vioCode;
	}
	
	public String selectVioDesc()
	{
		String flag = Settings.canVioDesc;
		String vioDes = "";
		
		if(flag.equalsIgnoreCase("true"))
		{
			try{driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(descriptionDropdown);}catch(NoSuchElementException e) {}
			int index = Util.getRandomNumberOneToFive();
			try
			{
				driverUtilities.get().selectElementFromListIndex(descriptionDropdown, index);
			}
			catch(NoSuchElementException e)
			{
				driverUtilities.get().selectElementFromListIndex(descriptionDropdown, 1);
			}
			vioDes = driverUtilities.get().getFirstSelectedOptionFromList(descriptionDropdown);
		}
		return vioDes;
	}
	
	public String editVioCode()
	{
		try{driverUtilities.get().makeElementVisibleIntoScreen(paidAfterTextBox);}catch(NoSuchElementException e) {}
		int index = Util.getRandomNumberOneToTen();
		driverUtilities.get().selectElementFromListIndex(selectVioCodeList, index);
		String vioCode = driverUtilities.get().getFirstSelectedOptionFromList(selectVioCodeList);
		return vioCode;
	}
	
	public String verifyDescription()
	{
		String description = driverUtilities.get().getFirstSelectedOptionFromList(descriptionDropdown);
		return description;
	}
	
	public String verifyUpdatedDescription()
	{
		String description = driverUtilities.get().getFirstSelectedOptionFromList(updatedDescriptionDrowDown);
		return description;
	}
	
	public String getFineValue()
	{
		driverUtilities.get().waitForElement(fineTextBox);
		String fineVal = driverUtilities.get().getAttribute(fineTextBox, "value");
		return fineVal;
	}
	
	public String getPaidAfterValue()
	{
		String isPaidAfter = Settings.isPaidAfter;
		String paidAfterVal="";
		
		if(isPaidAfter.equalsIgnoreCase("true"))
		{
			driverUtilities.get().waitForElement(paidAfterTextBox);
			paidAfterVal = driverUtilities.get().getAttribute(paidAfterTextBox, "value");
		}
		return paidAfterVal;
	}
	
	public String enterRemark()
	{
		String cnRemk = Settings.canRemark;
		if(cnRemk.equalsIgnoreCase("true"))
		{
			driverUtilities.get().makeElementVisibleIntoScreen(remarksTextArea);
			driverUtilities.get().waitForElement(remarksTextArea);
			driverUtilities.get().clearTextBox(remarksTextArea);
			//String remark = "Test remark for the verification number "+Util.generateRandomNumber(9);
			driverUtilities.get().typeIntoTextBox(remarksTextArea, Settings.remark);
		}
		return Settings.remark;
	}
	
	public String editRemark()
	{
		String cnRemk = Settings.canRemark;
		if(cnRemk.equalsIgnoreCase("true"))
		{
			driverUtilities.get().waitForElement(editRemark1);
			driverUtilities.get().clearTextBox(editRemark1);
			//String remark = "Test remark for the verification number "+Util.generateRandomNumber(9);
			driverUtilities.get().typeIntoTextBox(editRemark1, Settings.editRemark);
		}
		return Settings.editRemark;
	}
	
	public void clickOnUploadImageButtonAndUpload( String fileFormat ) throws AWTException
	{
		driverUtilities.get().makeElementVisibleIntoScreenAtMiddle(uploadImageButton);
		driverUtilities.get().clickOnElement(uploadImageButton);
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
			default:
			{
				
			}
		}
		try {driverUtilities.get().waitForElementToBePresent2("//img[@alt='Citation']");}catch(TimeoutException e)
		{
			Assert.fail("Image does not uploaded");
		}
	}
	
	public void clickOnSubmit()
	{
		driverUtilities.get().waitForElementToBeClickable("//button[text()='Submit']");
		driverUtilities.get().moveCursorToAnElementAndClick(driverUtilities.get().getActions(), submitButton);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void verifySuccessfullCreationTicketMessage()
	{
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
		try {driverUtilities.get().waitForElementToBePresent(successTicketMessage);}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(successTicketMessage));
	}
	
	public void clickOkayButtonOfMessage()
	{
		try {driverUtilities.get().waitForElementToBePresent(okayButtonOfMessage);}catch(TimeoutException e) {}
		try{driverUtilities.get().clickOnElement(okayButtonOfMessage);}catch(NoSuchElementException e) {}
	}
	
	public String enterReasonForEdit()
	{
		driverUtilities.get().waitForElement(reasonForEditTextArea);
		driverUtilities.get().clearTextBox(reasonForEditTextArea);
		String reason = "Edit_because_"+Util.generateRandomNumber(9);
		driverUtilities.get().typeIntoTextBox(reasonForEditTextArea, reason);
		return reason;
	}
	
	public void clickOnEditTicketSubmitButton()
	{
		driverUtilities.get().clickOnElement(editTicketSubmitButton);
	}
}
