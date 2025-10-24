package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import base.Base;
import base.BasePage;
import config.Settings;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ManualTicketsPage;
import path.Path;
import utility.PropertyUtil;

public class ManualTicketsPageSteps extends Base
{	
	
	BasePage CurrentPage;

	@When("verify options for manual tickets")
	public void verify_ticket_manual_menus()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).verifyManualTicketsMenus();
	}
	
	@Then("verify create tickets page")
	public void verify_create_tickets_page()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).verifyCreateTicketPage();
	}
	
	
	@When("user clicks on to the create ticket option")
	public void user_clicks_on_to_the_create_ticket_option()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).clickOnCreateTicketOption();
	}
	
	@When("user enters citation number and save its value as {string} into temp file")
	public void user_enters_citation_number_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String citationValue = CurrentPage.getInstance(ManualTicketsPage.class).enterCitationValue();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, citationValue);
	}
	
	@When("user selects today date for issue date")
	public void user_selects_today_date_for_issue_date() throws AWTException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).selectsTodayDateForIssueDate();
	}
	
	@When("user selects max configure date for issue date")
	public void user_selects_previous_date_for_issue_date() throws AWTException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).selectPreviousDateAsIssueDate();
	}
	
	/*@When("user select office from the officer list and save its value as {string} into temp file")
	public void user_select_officer_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String officerName = CurrentPage.getInstance(ManualTicketsPage.class).selectOfficer();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, officerName);
	}*/
	
	@When("verify badge id from the badge id list and save its value as {string} into temp file")
	public void verify_badgeid_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String badgeVal = CurrentPage.getInstance(ManualTicketsPage.class).verifyBadgeID();
		System.out.println("badgeVal:="+badgeVal);
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, badgeVal);
	}
	
	@When("user enters officer name into officer field and save its value as {string} into temp file")
	public void user_enter_officer_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterOfficer();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.officerName);
	}
	
	@When("user enters plate number and save its value as {string} into temp file")
	public void user_enters_plate_number_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String plate = CurrentPage.getInstance(ManualTicketsPage.class).enterPlateValue();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, plate);
	}

	@When("user enters {string} plate number")
	public void user_enters_plate_number(String key) throws IOException
	{
		String plate =  PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(ManualTicketsPage.class).enterPlateValue(plate);
	}
	
	/*@When("user select state from the state list and save its value as {string} into temp file")
	public void user_select_state_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String stateName = CurrentPage.getInstance(ManualTicketsPage.class).selectState();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, stateName);
	}*/
	
	@When("user enters state name into state field and save its value as {string} into temp file")
	public void user_enter_state_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterState();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.stateName);
	}
	
	@When("user edit state from {string} and save its value as {string} into temp file")
	public void user_edit_state_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editState();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.editStateName);
	}
	
	
	/*@When("user select veh make from the make list and save its value as {string} into temp file")
	public void user_select_veh_make_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String make = CurrentPage.getInstance(ManualTicketsPage.class).selectVehMake();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, make);
	}*/
	
	@When("user enters veh make into veh make field and save its value as {string} into temp file")
	public void user_enter_veh_make_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterVehMake();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.make);
	}
	
	@When("user edit veh make from {string} and save its value as {string} into temp file")
	public void user_edit_vehicle_make_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editVehMake();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.editMake);
	}
	
	/*@When("user select veh model from the model list and save its value as {string} into temp file")
	public void user_select_veh_model_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String model = CurrentPage.getInstance(ManualTicketsPage.class).selectVehModel();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, model);
	}*/
	
	@When("user enters veh model into veh model field and save its value as {string} into temp file")
	public void user_enter_veh_model_and_save_its_value_as_into_temp_file( String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterVehModel();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.model);
	}
	
	@When("user edit veh model from {string} and save its value as {string} into temp file")
	public void user_edit_vehicle_model_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editVehModel();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.editModel);
	}
	
	/*@When("user select veh color from the color list and save its value as {string} into temp file")
	public void user_select_veh_color_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String color = CurrentPage.getInstance(ManualTicketsPage.class).selectVehColor();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, color);
	}*/
	
	@When("user enters veh color into veh color field and save its value as {string} into temp file")
	public void user_enter_veh_color_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterVehColor();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.color);
	}
	
	@When("user edit veh color from {string} and save its value as {string} into temp file")
	public void user_edit_vehicle_color_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editVehColor();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.editColor);
	}
	
	@When("user select body style from the style list and save its value as {string} into temp file")
	public void user_select_body_style_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String color = CurrentPage.getInstance(ManualTicketsPage.class).selectBodyStyle();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, color);
	}
	
	@When("user edit body style and save its value as {string} into temp file")
	public void user_edit_body_style_from_and_save_its_value_as_into_temp_file( String saveAs) throws IOException
	{
		String color = CurrentPage.getInstance(ManualTicketsPage.class).editBodyStyle();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, color);
	}
	
	@When("user select block from the block list and save its value as {string} into temp file")
	public void user_select_block_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String color = CurrentPage.getInstance(ManualTicketsPage.class).selectBlock();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, color);
	}
	
	@When("user enters lot into lot field and save its value as {string} and {string} and {string} into temp file")
	public void user_enter_lot_and_save_its_value_as_into_temp_file(String saveAsIot, String saveAsBlock, String saveAsStrret) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterLot();
		String block = CurrentPage.getInstance(ManualTicketsPage.class).getBlock();
		String street = CurrentPage.getInstance(ManualTicketsPage.class).getStreet();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAsIot, Settings.lot);
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAsBlock, block);
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAsStrret, street);
	}
	
	@When("user enters block into block field and save its value as {string} into temp file")
	public void user_enter_block_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterBlock();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.block);
	}
	
	@When("user edit block from {string} and save its value as {string} into temp file")
	public void user_edit_block_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editBlock();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.editBlock);
	}
	
	/*@When("user select street from the block list and save its value as {string} into temp file")
	public void user_select_street_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String street = CurrentPage.getInstance(ManualTicketsPage.class).selectStreet();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, street);
	}*/
	
	@When("user enters street into street field and save its value as {string} into temp file")
	public void user_enter_street_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).enterStreet();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.street);
	}
	
	@When("user edit street from {string} and save its value as {string} into temp file")
	public void user_edit_street_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editStreet();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.street);
	}
	
	@When("user select vio code from the vio code list and save its value as {string} into temp file")
	public void user_select_vio_code_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String code = CurrentPage.getInstance(ManualTicketsPage.class).selectVioCode();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, code);
	}
	
	@When("user select vio description from the vio code list and save its value as {string} into temp file")
	public void user_select_vio_description_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String code = CurrentPage.getInstance(ManualTicketsPage.class).selectVioDesc();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, code);
	}
	
	@When("user edit vio code and save its value as {string} into temp file")
	public void user_edit_violation_code_from_and_save_its_value_as_into_temp_file( String saveAs) throws IOException
	{
		String code = CurrentPage.getInstance(ManualTicketsPage.class).editVioCode();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, code);
	}
	
	@Then("verify description from the description list and save its value as {string} into temp file")
	public void user_select_description_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String desc = CurrentPage.getInstance(ManualTicketsPage.class).verifyDescription();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, desc);
	}
	
	@Then("verify updated description from the description list and save its value as {string} into temp file")
	public void user_updated_select_description_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String desc = CurrentPage.getInstance(ManualTicketsPage.class).verifyUpdatedDescription();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, desc);
	}
	
	@Then("verify the fine and save its value as {string} into temp file")
	public void verify_fine_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String fineValue = CurrentPage.getInstance(ManualTicketsPage.class).getFineValue();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, fineValue);
	}
	
	@Then("verify the paid after and save its value as {string} into temp file")
	public void verify_paid_after_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String paidAfterValue = CurrentPage.getInstance(ManualTicketsPage.class).getPaidAfterValue();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, paidAfterValue);
	}
	
	@When("user enters remark and save its value as {string} into temp file")
	public void user_enters_remark_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String remark = CurrentPage.getInstance(ManualTicketsPage.class).enterRemark();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, remark);
	}
	
	@When("user edit remark from {string} and save its value as {string} into temp file")
	public void user_edit_remark_from_and_save_its_value_as_into_temp_file(String oldValue , String saveAs) throws IOException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).editRemark();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, Settings.editRemark);
	}
	
	@When("user clicks on upload image button and upload {string} file")
	public void user_clicks_on_upload_image_button_and_upload_file( String fileType ) throws IOException, AWTException
	{
		CurrentPage.getInstance(ManualTicketsPage.class).clickOnUploadImageButtonAndUpload(fileType);
	}
	
	@When("user clicks on submit button to create ticket")
	public void user_clicks_on_submit_button_to_create_ticket()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).clickOnSubmit();
	}
	
	@Then("verify the successfully ticket creation message")
	public void verify_the_successfully_ticket_creation_message()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).verifySuccessfullCreationTicketMessage();
	}
	
	@When("user clicks on to the okay button of message")
	public void user_clicks_on_to_the_okay_button_of_message()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).clickOkayButtonOfMessage();
	}
	
	@When("user enter reason for edit and save its value as {string} into temp file")
	public void user_enter_reason_for_edit_and_save_its_value_as_into_temp_file(String saveAs) throws IOException
	{
		String reason = CurrentPage.getInstance(ManualTicketsPage.class).enterReasonForEdit();
		PropertyUtil.updateIntoProperty(Path.dataProperty, saveAs, reason);
	}
	
	@When("user clicks on to the submit button of edit ticket popup")
	public void user_clickson_to_the_submit_button_of_edit_ticket_popup()
	{
		CurrentPage.getInstance(ManualTicketsPage.class).clickOnEditTicketSubmitButton();
	}
}
