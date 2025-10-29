package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import base.Base;
import base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaymentSearchPage;
import pages.SearchPage;
import path.Path;
import utility.PropertyUtil;

public class PaymentSearchPageSteps  extends Base
{
	BasePage CurrentPage;
	
	@When("user enters notice number by taking its value from temp file with key {string} from payment application")
	public void user_enters_notice_number_by_taking_its_value_from_temp_file_with_key_payment(String key)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterNoticeNumberFromTempFile(key);
	}
	
	@When("user clicks on search button from payment application")
	public void user_clicks_on_search_button_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickSearchButton();
	}
	
	@Then("verify that notice with {string} citation number has been searched successfully from payment application")
	public void verify_that_notice_with_citation_number_has_been_searched_successfully_payment(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifySearchCitationResults(expectedNoticeNumber);
	}
	
	@Then("verify that today is the citation issue date from payment application")
	public void vverify_that_today_is_the_citation_issue_date_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyCitationIssueDate();
	}
	
	@Then("verify that notice with {string} citation plate has been searched successfully from payment application")
	public void verify_that_notice_with_citation_plate_has_been_searched_successfully_payment(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifySearchCitationResultsPlate(expectedNoticeNumber);
	}
	
	@Then("verify that notice with {string} citation violation description has been searched successfully from payment application")
	public void verify_that_notice_with_citation_violation_description_has_been_searched_successfully_payment(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifySearchCitationResultsVioDesc(expectedNoticeNumber);
	}
	
	@Then("verify that notice with {string} citation status has been searched successfully from payment application")
	public void verify_that_notice_with_citation_status_has_been_searched_successfully_payment(String status)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyCitationStatus(status);
	}
	
	@Then("verify that notice with {string} citation original fine has been searched successfully from payment application")
	public void verify_that_notice_with_citation_original_fine_has_been_searched_successfully_payment(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifySearchCitationResultsOriFine(expectedNoticeNumber);
	}
	
	@Then("verify that {string} link is present in search result from payment application")
	public void verify_that_link_is_present_in_search_result_payment(String link)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyLinkInSerchResult(link);
	}
	
	@Then("verify that {string} is the value for notice number field after search from payment application")
	public void verify_that_is_the_value_for_notice_number_field_after_search_payment(String key) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNoticeNUmberValue(expectedNoticeNumber);
	}
	
	@Then("verify sitename in the search result from payment application")
	public void verify_sitename_in_the_search_result_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifySiteNameInSearchResult();
	}
	
	@Then("verify that total {string} search notices are in result from payment application")
	public void verify_that_total_search_notices_are_in_result_payment(String count)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNoticeCountInSearchResult(count);
	}
	
	@When("user click on to the {string} link of {string} citation number ticket from payment application")
	public void user_click_on_to_the_link_of_citation_number_ticket_payment(String link, String citationNumber) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, citationNumber);
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnLinkBasedOnCitationNumber(link,expectedNoticeNumber);
	}
	
	@Then("verify that for {string} link of {string} citation number ticket is not visible after void from payment application")
	public void verify_that_for_link_of_citation_number_ticket_is_not_visible_after_void_payment(String link, String citationNumber) throws IOException
	{
		String expectedNoticeNumber = PropertyUtil.getFromTempPropertyFile(path.Path.dataProperty, citationNumber);
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnLinkBasedOnCitationNumberNotVisible(link,expectedNoticeNumber);
	}
	
	@Then("verify section {string} for {string} and {string} as key its value from payment application")
	public void verify_section_details_key_its_value_payment(String section, String label , String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifySectionLabelAndKeyValue(section, label , keyValue);
	}
	
	@Then("verify total {string} images is under {string} label from payment application")
	public void verify_total_images_is_under_label_payment(String count, String label)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyImagesUnderLabel(count, label);
	}
	
	@Then("verify that {string} filed has {string} key as value from financial page from payment application")
	public void verify_that_filed_has_key_as_value_from_financial_page_payment(String field, String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyFieldValueFromFinancialPage(field, keyValue);
	}
	
	@Then("verify that {string} is same as configured service charge amount from financial page from payment application")
	public void verify_that_is_same_as_configured_service_charge_amount_from_financial_page_payment(String field)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyFieldValWithConfiguredFinancialPage(field);
	}
	
	@When("user navigate to {string} tab name and {string} href link from payment application")
	public void user_navigate_to_tab_payment(String tabName , String hrefLink)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).navigateToTab(tabName, hrefLink);
	}
	
	@Then("verify that Total Amount is the summation of {string} and {string} from payment application")
	public void verify_that_Total_Amount_is_the_summation_payment(String fine1 , String fine2)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).totalAmountSummation(fine1 , fine2);
	}
	
	@Then("verify that Total Amount is the summation of {string} from payment application")
	public void verify_that_Total_Amount_is_the_summation_payment(String fine1) throws IOException
	{
		fine1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, fine1);
		CurrentPage.getInstance(PaymentSearchPage.class).totalAmountSummation(fine1);
	}
	
	@Then("verify that Total Amount is the summation of {string} from make payment screen from payment application")
	public void verify_that_Total_Amount_is_the_summation_from_make_payment_screen(String fine1) throws IOException
	{
		fine1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, fine1);
		CurrentPage.getInstance(PaymentSearchPage.class).totalAmountSummationFromMakePaymentScreen(fine1);
	}
	
	@When("user check the header checkbox from payment application")
	public void user_check_the_header_checkbox_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).checkHeaderCheckbox();
	}
	
	
	
	
	
	
	
	
	
	@When("user clicks search link from search result page from payment application")
	public void user_clicks_search_link_from_search_result_page_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickSearchLinkFromSearchResultPage();
	}
	
	@When("user clicks search result link from search result page from payment application")
	public void user_clicks_search_result_link_from_search_result_page_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickSearchResultLinkFromSearchResultPage();
	}

	@When("user enters License Plate by taking its value from temp file with key {string} from payment application")
	public void user_enters_license_plate_by_taking_its_value_from_temp_file_with_key_payment(String key)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterLicensePlateFromTempFile(key);
	}

	@When("user selects the License Province or State value from list by taking its value from temp file with key {string} from payment application")
	public void user_selects_license_province_or_state_from_list_using_key_payment(String key)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).selectLicenseProvinceOrStateFromTempFile(key);
	}
	
	@When("user clears Notice number and License Plate fields from payment application")
	public void user_clears_notice_number_and_license_plate_fields_payment_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clearNoticeNumberAndLicensePlateFields();
	}
	
	@Then("verify that {string} message popups from payment portal from payment application")
	public void verify_that_message_popups_from_payment_portal_payment(String expectedMessage)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyMessagePopup(expectedMessage);
	}

	@When("user enters special characters into Notice number and License Plate fields from payment application")
	public void user_enters_special_characters_into_notice_and_license_plate_fields_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterSpecialCharactersIntoNoticeAndLicense();
	}

	@Then("verify that special characters are not entered into Notice number and License Plate fields from payment application")
	public void verify_special_characters_not_entered_into_notice_and_license_fields_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNoSpecialCharactersInNoticeAndLicense();
	}
	
	@Then("verify cancel citation form with {string} key as citation number from payment application")
	public void verify_cancel_citation_form_with_key_as_citation_number_payment(String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyCancelForm(keyValue);
	}
	
	@When("user select cancel citation reason and save its value as {string} into temp file from payment application")
	public void user_select_cancel_citation_reason_payment(String key) throws IOException
	{
		String keyValue =CurrentPage.getInstance(PaymentSearchPage.class).selectCancelCitationReason();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, keyValue);
	}
	
	@When("user get cancel citation comments and save its value as {string} into temp file from payment application")
	public void user_enters_cancel_citation_comments_and_save_its_value_as_into_temp_file_payment(String key) throws IOException
	{
		String keyValue =CurrentPage.getInstance(PaymentSearchPage.class).cancelCitationComments();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, keyValue);
	}
	
	@When("user clicks on to the sumbit button of cancel citation popup from payment application")
	public void user_clicks_on_to_the_sumbit_button_of_cancel_citation_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickCancelCitationSubmitButton();
	}
	
	@Then("verify support note popup from payment application")
	public void verify_support_note_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifySupportNotePopup();
	}
	
	@When("user enters note and save its value as {string} into temp file from payment application")
	public void user_enters_note_and_save_its_value_as_into_temp_file_payment(String key) throws IOException
	{
		String keyValue =CurrentPage.getInstance(PaymentSearchPage.class).enterNote();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, keyValue);
	}
	
	@When("user clicks on choose file button and upload {string} file for note from payment application")
	public void user_clicks_on_choose_file_button_and_upload_file_note_payment( String fileType ) throws AWTException
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnChooseFilenAndUpload(fileType);
	}
	
	@Then("verify that file uploaded into note section from payment application")
	public void verify_that_file_uploaded_into_note_section_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyFileHasBeenUploaded();
	}
	
	@When("user clicks on to the submit button of note popup from payment application")
	public void user_clicks_on_to_the_submit_button_of_note_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnNotePopupSubmitButton();
	}
	
	@Then("verify note added sucess message from payment portal from payment application")
	public void verify_note_added_sucess_message_from_payment_portal_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNoteAddedSucessMessage();
	}
	
	@When("user close the note successful added message from payment application")
	public void user_close_the_note_successful_added_message_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).closeNoteSuccessfullyAddedMessage();
	}
	
	@Then("verify that the validation message for note field from payment application")
	public void verify_that_the_validation_message_for_note_filed_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNoteFieldMandatoryMessage();
	}
	
	@When("user click on to the View all support notes link from support note popup from payment application")
	public void user_click_on_to_the_View_all_support_notes_link_from_support_note_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnViewAllSupportNotesLink();
	}
	
	@Then("verify that {string} note appears under citation info page from payment application")
	public void verify_that_note_appears_under_citation_info_page_payment(String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNoteAddedUnderCitationInfo(keyValue);
	}
	
	@Then("verify download link for {string} note appears under citation info page from payment application")
	public void verify_download_link_for_note_appears_under_citation_info_page_payment(String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyDownloadLinkUnderCitationInfo(keyValue);
	}
	
	@When("user enters notice number by taking its value from temp file with key {string} and {string} from payment application")
	public void user_enters_notice_number_by_taking_its_value_from_temp_file_with_key_payment(String key1, String key2) throws IOException
	{
		String n1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key1);
		String n2 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key2);
		CurrentPage.getInstance(PaymentSearchPage.class).enterNoticesNumberFromTempFile(n1,  n2);
	}
	
	@When("user click on to the {string} button from top bar from payment application from payment application")
	public void user_click_on_to_the_button_from_top_bar_from_payment_application(String buttonName)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnButtonFromTopBar(buttonName);
	}
	
	@Then("verify that page has {string} label and {string} as key its value from payment application")
	public void verify_that_page_has_label_and_as_key_its_value_payment(String label, String key) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyLabelAndKeyValue(label,keyValue);
	}
	
	@Then("verify the payment amount is total of {string} and {string} for {string} tickets from payment page from payment application")
	public void verify_payment_amout_payment(String key1, String key2, String ticketCounts) throws IOException
	{
		String keyValue1 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key1);
		String keyValue2 = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key2);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyPaymentAmount(keyValue1, keyValue2,ticketCounts);
	}
	
	@When("user clicks on to the make payment button from payment application")
	public void user_clicks_on_to_the_make_payment_button_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnMakePaymentButton();
	}
	
	@Then("verify {string} label on screen from payment application")
	public void verify_label_on_screen_payment(String label)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyLanelOnScreen(label);
	}
	
	@Then("verify client address in payment receipt from payment application from payment application")
	public void verify_client_address_in_payment_receipt_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyClientAddressOnPaymentRec();
	}
	
	@When("user click on to the back button from payment application from payment application")
	public void user_clicks_on_to_the_back_button_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickOnBackButtonOfPaymentScreen();
	}
	
	@Then("verify that notice with {string} citation number has {string} status from payment application")
	public void verify_that_notice_with_citation_number_has_status_payment(String citation, String status) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, citation);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyCitationStatus(keyValue, status);
	}
	
	@Then("verify that notice with {string} citation number has {string} vio description from payment application")
	public void verify_that_notice_with_citation_number_has_vio_description_payment(String citation, String vioDesc) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, citation);
		vioDesc = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, vioDesc);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyCitationVioDescription(keyValue, vioDesc);
	}
	
	@Then("verify that notice with {string} citation number has {string} Original Fine from payment application")
	public void verify_that_notice_with_citation_number_has_Original_Fine_payment(String citation, String fine) throws IOException
	{
		String keyValue = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, citation);
		fine = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, fine);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyCitationFine(keyValue, fine);
	}
	
	@Then("verify the message {string} visible on make payment screen from payment application")
	public void verify_the_message_visible_on_make_payment_screen_payment(String message)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyMessageOnMakePaymentScreen(message);
	}
	
	@When("user enters {string} for {string} placeholder for payment from payment application")
	public void user_enters_key_for_card_payment_payment_pro_payment(String keyValue, String fieldPlaceHolder)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterValuesInToCardPayemnt(keyValue,fieldPlaceHolder);
	}
	
	@When("user enters card details from payment application")
	public void user_enters_card_details_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterCardDetails();
	}
	
	@Then("verify that reciept id has been generated and save its value as {string} into temp file from payment application")
	public void verify_that_recieptid_has_been_generated_and_save_its_value_as_into_temp_file_payment(String key) throws IOException
	{
		String recID = CurrentPage.getInstance(PaymentSearchPage.class).getRecieptID();
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, recID);
	}
	
	@When("user close the popup from payment application")
	public void user_close_the_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).closePopup();
	}
	
	@Then("verify that Original fine amount is same as {string} citation fine from payment application")
	public void verify_that_original_fine_amount_is_same_as_citation_fine_payment(String key) throws IOException
	{
		String expectedFine = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyOriginalFineAmount(expectedFine);
	}
	
	@Then("verify that New Fine Amount Due is same as {string} citation fine from payment application")
	public void verify_that_new_fine_amount_due_is_same_as_citation_fine_payment(String key) throws IOException
	{
		String expectedFine = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, key);
		CurrentPage.getInstance(PaymentSearchPage.class).verifyNewFineAmountDue(expectedFine);
	}
	
	@When("user click on submit button of Add Discount popup from payment application")
	public void user_click_on_submit_button_of_add_discount_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickSubmitButtonOfAddDiscountPopup();
	}
	
	@Then("verify that {string} message display as mandatory filed for add discount popup from payment application")
	public void verify_that_message_display_as_mandatory_field_for_add_discount_popup_payment(String expectedMessage)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyMandatoryFieldMessage(expectedMessage);
	}
	
	@When("user entered {string} as discount in the Discount Amount field from add discount popup from payment application")
	public void user_entered_as_discount_in_the_discount_amount_field_from_add_discount_popup_payment(String discountAmount)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterDiscountAmount(discountAmount);
	}
	
	@When("user entered {string} as Discount Days from add discount popup from payment application")
	public void user_entered_as_discount_days_from_add_discount_popup_payment(String discountDays)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterDiscountDays(discountDays);
	}
	
	@Then("verify that Discount End Date is populating the {string} days of future with respect to current date from payment application")
	public void verify_that_discount_end_date_is_populating_the_days_of_future_with_respect_to_current_date_payment(String days)
	{
		CurrentPage.getInstance(PaymentSearchPage.class).verifyDiscountEndDate(days);
	}
	
	@Then("verify that New Fine Amount Due is the {string} minus {string} as discounted amount and save its value as {string} into temp file from payment application")
	public void verify_that_new_fine_amount_due_is_the_minus_as_discounted_amount_and_save_its_value_as_into_temp_file_payment(String originalFine, String discountAmount, String key) throws IOException
	{
		String expectedOriginalFine = PropertyUtil.getFromTempPropertyFile(Path.dataProperty, originalFine);
		String discountedAmount = CurrentPage.getInstance(PaymentSearchPage.class).verifyDiscountedAmountAndGetValue(expectedOriginalFine, discountAmount);
		PropertyUtil.updateIntoProperty(Path.dataProperty, key, discountedAmount);
	}
	
	@When("user entered the remark from add discount popup from payment application")
	public void user_entered_the_remark_from_add_discount_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).enterRemark();
	}
	
	@When("click on to the Submit button from add discount popup from payment application")
	public void click_on_to_the_submit_button_from_add_discount_popup_payment()
	{
		CurrentPage.getInstance(PaymentSearchPage.class).clickSubmitButtonFromAddDiscountPopup();
	}
}
