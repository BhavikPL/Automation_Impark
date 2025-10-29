@Demo
@Phsa
@PhsaSearch1
Feature: Verify search ticket functionality

@datasetup
Scenario: setup for test
And user setups brower
And user opens processing pro application
And user do login to processing pro application with valid credentials
And user enters otp into OTP Verification page
Then verify that login successfull
When user wait for "2" seconds
And user extends manual tickets menu
And user wait for "1" seconds
And user clicks on to the create ticket option
And user wait for "1" seconds

Scenario: create a citation
When user enters citation number and save its value as "search_number" into temp file
And user selects today date for issue date
And user enters officer name into officer field and save its value as "search_officer" into temp file
And verify badge id from the badge id list and save its value as "search_badge" into temp file
And user wait for "1" seconds
And user enters plate number and save its value as "search_plate" into temp file
And user enters state name into state field and save its value as "search_state" into temp file
And user enters veh make into veh make field and save its value as "search_vehmake" into temp file
And user enters veh model into veh model field and save its value as "search_vehmodel" into temp file
And user enters street into street field and save its value as "search_street" into temp file
And user enters lot into lot field and save its value as "search_lot" and "search_block" and "search_street" into temp file
And user select vio code from the vio code list and save its value as "search_viocode" into temp file
And user select vio description from the vio code list and save its value as "search_vioDesc" into temp file
Then verify description from the description list and save its value as "search_description" into temp file
And verify the fine and save its value as "search_fine" into temp file
And verify the paid after and save its value as "search_paidafter" into temp file
And user enters block into block field and save its value as "search_block" into temp file
And user clicks on upload image button and upload "jpg" file
And user wait for "10" seconds
And user clicks on submit button to create ticket
Then verify the successfully ticket creation message
When user clicks on to the okay button of message
When user wait for "2" seconds

Scenario: Valid Login with Correct Username and Password
And user opens cx support application
And user do login to cx support application with valid credentials
Then verify that user is redirected to OTP verification page
When user enters otp into OTP Verification page
And user wait for "2" seconds

Scenario: Search for notices functionality
Then verify that Search For Notices page opens
When user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully
##Then verify that notice with "search_vioDesc" citation violation description has been searched successfully
Then verify that notice with "Valid" citation status has been searched successfully
Then verify that notice with "search_fine" citation original fine has been searched successfully
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Note" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that notice with "search_number" citation number has view Details
Then verify that "search_number" is the value for notice number field after search
Then verify sitename in the search result
Then verify that total "1" search notices are in result
Then verify that "search_number" is the value for notice number field after search

Scenario: Search by license plate and state
When user clicks search link from search result page
And user enters License Plate by taking its value from temp file with key "search_plate"
And user selects the License Province or State value from list by taking its value from temp file with key "search_state"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully
##Then verify that notice with "search_vioDesc" citation violation description has been searched successfully
Then verify that notice with "Valid" citation status has been searched successfully
Then verify that notice with "search_fine" citation original fine has been searched successfully
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Note" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that notice with "search_number" citation number has view Details
Then verify sitename in the search result
Then verify that total "1" search notices are in result

Scenario: Search validation with empty fields
When user clicks search link from search result page
And user clears Notice number and License Plate fields
And user clicks on search button
And user wait for "2" seconds
Then verify that "Enter ticket number or Licence Plate" message popups

Scenario: Prevent special characters in notice and license inputs
When user wait for "7" seconds
And user enters special characters into Notice number and License Plate fields
Then verify that special characters are not entered into Notice number and License Plate fields

Scenario: Search by citation number and make the citation cancelled and verify view details
When user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "4" seconds
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully
##Then verify that notice with "search_vioDesc" citation violation description has been searched successfully
Then verify that notice with "Valid" citation status has been searched successfully
Then verify that notice with "search_fine" citation original fine has been searched successfully
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Note" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that notice with "search_number" citation number has view Details
Then verify that "search_number" is the value for notice number field after search
Then verify sitename in the search result
Then verify that total "1" search notices are in result

Scenario: verify view details page
When user click on to the view details link of "search_number" citation number ticket
And user wait for "2" seconds
Then verify section "Officer Details" for "Officer Name" and "search_officer" as key its value
Then verify section "Vehicle Details" for "Vehicle Make" and "search_vehmake" as key its value
Then verify section "Vehicle Details" for "Vehicle Model" and "search_vehmodel" as key its value
Then verify section "Vehicle Details" for "Licence Plate Number" and "search_plate" as key its value
Then verify section "Location Details" for "Street" and "search_street" as key its value
Then verify section "Location Details" for "Block" and "search_block" as key its value
Then verify section "Violation Details" for "Description" and "search_description" as key its value
#Then verify section "Enforcement Notes" for "Printed Remark 1" and "search_remark" as key its value
Then verify section "Violation Details" for "Description" and "search_vioDesc" as key its value
Then verify total "1" images is under "Images" label

Scenario: verify financial page
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "4" seconds
Then verify that "Original Fine" filed has "search_fine" key as value from financial page
Then verify that "Total Due" filed has "search_fine" key as value from financial page
Then verify that "Service Fee" is same as configured service charge amount from financial page

Scenario: Make the citation void and verify
When user clicks search link from search result page
And user wait for "2" seconds
And user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "5" seconds

When user click on to the "Void" link of "search_number" citation number ticket
And user wait for "5" seconds
Then verify cancel citation form with "search_number" key as citation number
When user select cancel citation reason and save its value as "search_cancel_reason" into temp file
And user wait for "3" seconds
When user get cancel citation comments and save its value as "search_cancel_comment" into temp file
And user wait for "2" seconds
And user clicks on choose file button and upload "pdf" file for void
And user wait for "4" seconds
Then verify that file uploaded into void section
And user clicks on to the sumbit button of cancel citation popup
And user wait for "2" seconds
Then verify that notice with "Cancelled" citation status has been searched successfully
Then verify that for "Void" link of "search_number" citation number ticket is not visible after void
Then verify that for "Pay" link of "search_number" citation number ticket is not visible after void
Then verify that notice with "search_number" citation number has view Details
Then verify that "Support Note" link is present in search result

Scenario: Add support note to the citation and verify
When user click on to the "Support Note" link of "search_number" citation number ticket
And user wait for "2" seconds
When user clicks on to the submit button of note popup
Then verify that the validation message for note field
When user wait for "2" seconds
And user enters note and save its value as "search_note" into temp file
And user clicks on choose file button and upload "pdf" file for note
And user wait for "4" seconds
Then verify that file uploaded into note section
When user clicks on to the submit button of note popup
Then verify note added sucess message
And user wait for "5" seconds
And user click on to the "Support Note" link of "search_number" citation number ticket
And user click on to the View all support notes link from support note popup
And user wait for "1" seconds
Then verify that "search_note" note appears under citation info page
And verify download link for "search_note" note appears under citation info page
When user close the popup

Scenario: verify audit trail for citation events making citation void and support note added
When user click on to the view details link of "search_number" citation number ticket
And user wait for "2" seconds
And user navigate to "Audit Trail" tab name and "#audit-trail" href link
And user wait for "4" seconds
Then verify that audit "Old Value: Valid" visible
Then verify that audit "New Value: Suspended" visible
Then verify that audit "Reason: citation note added" visible

Scenario: verify the view details for support note details
When user navigate to "Notice Info" tab name and "#citation-info" href link
And user wait for "4" seconds
Then verify that "search_note" note appears under notice info page from view details
Then verify download link for "search_note" note appears under notice info page from view details
Then verify that support notes section for "search_note" has user name same as logged user name info page from view details

Scenario: verify the view details for void details
Then verify section "Void Details" for "Notice void comments" and "search_cancel_comment" as key its value
Then verify section "Void Details" for "Void Reason" and "search_cancel_reason" as key its value
Then verify that void details has user name same as logged user name info page from view details

Scenario: Close the browser
When user close browser