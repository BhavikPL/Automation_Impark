package StepDefinition;

import pages.SearchPage;
import path.Path;
import utility.PropertyUtil;

import java.awt.AWTException;
import java.io.IOException;

import base.Base;
import base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageSteps extends Base
{	
	BasePage CurrentPage;
	
	@Then("verify that Search For Notices page opens")
	public void verify_that_search_for_notices_page_opens()
	{
		CurrentPage.getInstance(SearchPage.class).verifySearchForNoticesPage();
	}
	
	@When("user enters notice number by taking its value from temp file with key {string}")
	public void user_enters_notice_number_by_taking_its_value_from_temp_file_with_key(String key)
	{
		CurrentPage.getInstance(SearchPage.class).enterNoticeNumberFromTempFile(key);
	}
	
	@When("user clicks on search button")
	public void user_clicks_on_search_button()
	{
		CurrentPage.getInstance(SearchPage.class).clickSearchButton();
	}
	
	@Then("verify that notice with {string} citation number has been searched successfully")
	public void verify_that_notice_with_citation_number_has_been_searched_successfully(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifySearchCitationResults(expectedNoticeNumber);
	}
	
	@Then("verify that today is the citation issue date")
	public void vverify_that_today_is_the_citation_issue_date()
	{
		CurrentPage.getInstance(SearchPage.class).verifyCitationIssueDate();
	}
	
	@Then("verify that notice with {string} citation plate has been searched successfully")
	public void verify_that_notice_with_citation_plate_has_been_searched_successfully(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifySearchCitationResultsPlate(expectedNoticeNumber);
	}
	
	@Then("verify that notice with {string} citation violation description has been searched successfully")
	public void verify_that_notice_with_citation_violation_description_has_been_searched_successfully(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifySearchCitationResultsVioDesc(expectedNoticeNumber);
	}
	
	@Then("verify that notice with {string} citation status has been searched successfully")
	public void verify_that_notice_with_citation_status_has_been_searched_successfully(String status)
	{
		CurrentPage.getInstance(SearchPage.class).verifyCitationStatus(status);
	}
	
	@Then("verify that notice with {string} citation original fine has been searched successfully")
	public void verify_that_notice_with_citation_original_fine_has_been_searched_successfully(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifySearchCitationResultsOriFine(expectedNoticeNumber);
	}
	
	@Then("verify that {string} link is present in search result")
	public void verify_that_link_is_present_in_search_result(String link)
	{
		CurrentPage.getInstance(SearchPage.class).verifyLinkInSerchResult(link);
	}
	
	@Then("verify that {string} is the value for notice number field after search")
	public void verify_that_is_the_value_for_notice_number_field_after_search(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifyNoticeNUmberValue(expectedNoticeNumber);
	}
	
	@Then("verify sitename in the search result")
	public void verify_sitename_in_the_search_result()
	{
		CurrentPage.getInstance(SearchPage.class).verifySiteNameInSearchResult();
	}
	
	@Then("verify that total {string} search notices are in result")
	public void verify_that_total_search_notices_are_in_result(String count)
	{
		CurrentPage.getInstance(SearchPage.class).verifyNoticeCountInSearchResult(count);
	}
	
	@When("user click on to the {string} link of {string} citation number ticket")
	public void user_click_on_to_the_link_of_citation_number_ticket(String link, String citationNumber) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, citationNumber);
		CurrentPage.getInstance(SearchPage.class).clickOnLinkBasedOnCitationNumber(link,expectedNoticeNumber);
	}
	
	@Then("verify that for {string} link of {string} citation number ticket is not visible after void")
	public void verify_that_for_link_of_citation_number_ticket_is_not_visible_after_void(String link, String citationNumber) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, citationNumber);
		CurrentPage.getInstance(SearchPage.class).clickOnLinkBasedOnCitationNumberNotVisible(link,expectedNoticeNumber);
	}
	
	@Then("verify section {string} for {string} and {string} as key its value")
	public void verify_section_details_key_its_value(String section, String label , String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifySectionLabelAndKeyValue(section, label , keyValue);
	}
	
	@Then("verify total {string} images is under {string} label")
	public void verify_total_images_is_under_label(String count, String label)
	{
		CurrentPage.getInstance(SearchPage.class).verifyImagesUnderLabel(count, label);
	}
	
	@Then("verify that {string} filed has {string} key as value from financial page")
	public void verify_that_filed_has_key_as_value_from_financial_page(String field, String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifyFieldValueFromFinancialPage(field, keyValue);
	}
	
	@Then("verify that {string} is same as configured service charge amount from financial page")
	public void verify_that_is_same_as_configured_service_charge_amount_from_financial_page(String field)
	{
		CurrentPage.getInstance(SearchPage.class).verifyFieldValWithConfiguredFinancialPage(field);
	}
	
	@When("user navigate to {string} tab name and {string} href link")
	public void user_navigate_to_tab(String tabName , String hrefLink)
	{
		CurrentPage.getInstance(SearchPage.class).navigateToTab(tabName, hrefLink);
	}
	
	@Then("verify that Total Amount is the summation of {string} and {string}")
	public void verify_that_Total_Amount_is_the_summation(String fine1 , String fine2)
	{
		CurrentPage.getInstance(SearchPage.class).totalAmountSummation(fine1 , fine2);
	}
	
	@Then("verify that Total Amount is the summation of {string}")
	public void verify_that_Total_Amount_is_the_summation(String fine1) throws IOException
	{
		fine1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, fine1);
		CurrentPage.getInstance(SearchPage.class).totalAmountSummation(fine1);
	}
	
	@Then("verify that Total Amount is the summation of {string} from make payment screen")
	public void verify_that_Total_Amount_is_the_summation_from_make_payment_screen(String fine1) throws IOException
	{
		fine1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, fine1);
		CurrentPage.getInstance(SearchPage.class).totalAmountSummationFromMakePaymentScreen(fine1);
	}
	
	@When("user check the header checkbox")
	public void user_check_the_header_checkbox()
	{
		CurrentPage.getInstance(SearchPage.class).checkHeaderCheckbox();
	}
	
	
	
	
	
	
	
	
	
	@When("user clicks search link from search result page")
	public void user_clicks_search_link_from_search_result_page()
	{
		CurrentPage.getInstance(SearchPage.class).clickSearchLinkFromSearchResultPage();
	}
	
	@When("user clicks search result link from search result page")
	public void user_clicks_search_result_link_from_search_result_page()
	{
		CurrentPage.getInstance(SearchPage.class).clickSearchResultLinkFromSearchResultPage();
	}

	@When("user enters License Plate by taking its value from temp file with key {string}")
	public void user_enters_license_plate_by_taking_its_value_from_temp_file_with_key(String key)
	{
		CurrentPage.getInstance(SearchPage.class).enterLicensePlateFromTempFile(key);
	}

	@When("user selects the License Province or State value from list by taking its value from temp file with key {string}")
	public void user_selects_license_province_or_state_from_list_using_key(String key)
	{
		CurrentPage.getInstance(SearchPage.class).selectLicenseProvinceOrStateFromTempFile(key);
	}
	
	@When("user clears Notice number and License Plate fields")
	public void user_clears_notice_number_and_license_plate_fields()
	{
		CurrentPage.getInstance(SearchPage.class).clearNoticeNumberAndLicensePlateFields();
	}
	
	@Then("verify that {string} message popups")
	public void verify_that_message_popups(String expectedMessage)
	{
		CurrentPage.getInstance(SearchPage.class).verifyMessagePopup(expectedMessage);
	}

	@When("user enters special characters into Notice number and License Plate fields")
	public void user_enters_special_characters_into_notice_and_license_plate_fields()
	{
		CurrentPage.getInstance(SearchPage.class).enterSpecialCharactersIntoNoticeAndLicense();
	}

	@Then("verify that special characters are not entered into Notice number and License Plate fields")
	public void verify_special_characters_not_entered_into_notice_and_license_fields()
	{
		CurrentPage.getInstance(SearchPage.class).verifyNoSpecialCharactersInNoticeAndLicense();
	}
	
	@Then("verify cancel citation form with {string} key as citation number")
	public void verify_cancel_citation_form_with_key_as_citation_number(String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifyCancelForm(keyValue);
	}
	
	@When("user select cancel citation reason and save its value as {string} into temp file")
	public void user_select_cancel_citation_reason(String key) throws IOException
	{
		String keyValue =CurrentPage.getInstance(SearchPage.class).selectCancelCitationReason();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, keyValue);
	}
	
	@When("user enters cancel citation comments and save its value as {string} into temp file")
	public void user_enters_cancel_citation_comments_and_save_its_value_as_into_temp_file(String key) throws IOException
	{
		String keyValue =CurrentPage.getInstance(SearchPage.class).cancelCitationComments();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, keyValue);
	}
	
	@When("user clicks on to the sumbit button of cancel citation popup")
	public void user_clicks_on_to_the_sumbit_button_of_cancel_citation_popup()
	{
		CurrentPage.getInstance(SearchPage.class).clickCancelCitationSubmitButton();
	}
	
	@Then("verify support note popup")
	public void verify_support_note_popup()
	{
		CurrentPage.getInstance(SearchPage.class).verifySupportNotePopup();
	}
	
	@When("user enters note and save its value as {string} into temp file")
	public void user_enters_note_and_save_its_value_as_into_temp_file(String key) throws IOException
	{
		String keyValue =CurrentPage.getInstance(SearchPage.class).enterNote();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, keyValue);
	}
	
	@When("user clicks on choose file button and upload {string} file for note")
	public void user_clicks_on_choose_file_button_and_upload_file_note( String fileType ) throws AWTException
	{
		CurrentPage.getInstance(SearchPage.class).clickOnChooseFilenAndUpload(fileType);
	}
	
	@Then("verify that file uploaded into note section")
	public void verify_that_file_uploaded_into_note_section()
	{
		CurrentPage.getInstance(SearchPage.class).verifyFileHasBeenUploaded();
	}
	
	@When("user clicks on to the submit button of note popup")
	public void user_clicks_on_to_the_submit_button_of_note_popup()
	{
		CurrentPage.getInstance(SearchPage.class).clickOnNotePopupSubmitButton();
	}
	
	@Then("verify note added sucess message")
	public void verify_note_added_sucess_message()
	{
		CurrentPage.getInstance(SearchPage.class).verifyNoteAddedSucessMessage();
	}
	
	@When("user close the note successful added message")
	public void user_close_the_note_successful_added_message()
	{
		CurrentPage.getInstance(SearchPage.class).closeNoteSuccessfullyAddedMessage();
	}
	
	@Then("verify that the validation message for note field")
	public void verify_that_the_validation_message_for_note_filed()
	{
		CurrentPage.getInstance(SearchPage.class).verifyNoteFieldMandatoryMessage();
	}
	
	@When("user click on to the View all support notes link from support note popup")
	public void user_click_on_to_the_View_all_support_notes_link_from_support_note_popup()
	{
		CurrentPage.getInstance(SearchPage.class).clickOnViewAllSupportNotesLink();
	}
	
	@Then("verify that {string} note appears under citation info page")
	public void verify_that_note_appears_under_citation_info_page(String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifyNoteAddedUnderCitationInfo(keyValue);
	}
	
	@Then("verify download link for {string} note appears under citation info page")
	public void verify_download_link_for_note_appears_under_citation_info_page(String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifyDownloadLinkUnderCitationInfo(keyValue);
	}
	
	@When("user enters notice number by taking its value from temp file with key {string} and {string}")
	public void user_enters_notice_number_by_taking_its_value_from_temp_file_with_key(String key1, String key2) throws IOException
	{
		String n1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key1);
		String n2 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key2);
		CurrentPage.getInstance(SearchPage.class).enterNoticesNumberFromTempFile(n1,  n2);
	}
	
	@When("user click on to the {string} button from top bar")
	public void user_click_on_to_the_button_from_top_bar(String buttonName)
	{
		CurrentPage.getInstance(SearchPage.class).clickOnButtonFromTopBar(buttonName);
	}
	
	@Then("verify that page has {string} label and {string} as key its value")
	public void verify_that_page_has_label_and_as_key_its_value(String label, String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(SearchPage.class).verifyLabelAndKeyValue(label,keyValue);
	}
	
	@Then("verify the payment amount is total of {string} and {string} for {string} tickets from payment page")
	public void verify_payment_amout(String key1, String key2, String ticketCounts) throws IOException
	{
		String keyValue1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key1);
		String keyValue2 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key2);
		CurrentPage.getInstance(SearchPage.class).verifyPaymentAmount(keyValue1, keyValue2,ticketCounts);
	}
	
	@When("user clicks on to the make payment button")
	public void user_clicks_on_to_the_make_payment_button()
	{
		CurrentPage.getInstance(SearchPage.class).clickOnMakePaymentButton();
	}
	
	@Then("verify {string} label on screen")
	public void verify_label_on_screen(String label)
	{
		CurrentPage.getInstance(SearchPage.class).verifyLanelOnScreen(label);
	}
	
	@Then("verify client address in payment receipt")
	public void verify_client_address_in_payment_receipt()
	{
		CurrentPage.getInstance(SearchPage.class).verifyClientAddressOnPaymentRec();
	}
	
	@When("user click on to the back button")
	public void user_clicks_on_to_the_back_button()
	{
		CurrentPage.getInstance(SearchPage.class).clickOnBackButtonOfPaymentScreen();
	}
	
	@Then("verify that notice with {string} citation number has {string} status")
	public void verify_that_notice_with_citation_number_has_status(String citation, String status) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, citation);
		CurrentPage.getInstance(SearchPage.class).verifyCitationStatus(keyValue, status);
	}
	
	@Then("verify that notice with {string} citation number has {string} vio description")
	public void verify_that_notice_with_citation_number_has_vio_description(String citation, String vioDesc) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, citation);
		vioDesc = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, vioDesc);
		CurrentPage.getInstance(SearchPage.class).verifyCitationVioDescription(keyValue, vioDesc);
	}
	
	@Then("verify that notice with {string} citation number has {string} Original Fine")
	public void verify_that_notice_with_citation_number_has_Original_Fine(String citation, String fine) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, citation);
		fine = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, fine);
		CurrentPage.getInstance(SearchPage.class).verifyCitationFine(keyValue, fine);
	}
	
	@Then("verify the message {string} visible on make payment screen")
	public void verify_the_message_visible_on_make_payment_screen(String message)
	{
		CurrentPage.getInstance(SearchPage.class).verifyMessageOnMakePaymentScreen(message);
	}
	
	@When("user enters {string} for {string} placeholder for payment")
	public void user_enters_key_for_card_payment_payment_pro(String keyValue, String fieldPlaceHolder)
	{
		CurrentPage.getInstance(SearchPage.class).enterValuesInToCardPayemnt(keyValue,fieldPlaceHolder);
	}
	
	@When("user enters card details")
	public void user_enters_card_details()
	{
		CurrentPage.getInstance(SearchPage.class).enterCardDetails();
	}
	
	@Then("verify that reciept id has been generated and save its value as {string} into temp file")
	public void verify_that_recieptid_has_been_generated_and_save_its_value_as_into_temp_file(String key) throws IOException
	{
		String recID = CurrentPage.getInstance(SearchPage.class).getRecieptID();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, recID);
	}
	
	@When("user close the popup")
	public void user_close_the_popup()
	{
		CurrentPage.getInstance(SearchPage.class).enterCardDetails();
	}
}
