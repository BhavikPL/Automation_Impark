@Demo
@Phsa
@PhsaSearch1_2
Feature: Verify search ticket functionality

@datasetup
Scenario: setup for test
And user setups brower
And user opens processing pro application
And user do login to processing pro application with valid credentials
And user enters otp into OTP Verification page
Then verify that login successfull
When user wait for "2" seconds
And user extends notice management menu
And user wait for "1" seconds
And user clicks on to the notice list view option
And user wait for "10" seconds

Scenario: search for Ticket in valid status
And user search for ticket which has valid status and save its value as "search_number" into temp file
And user click on date time link of "search_number" ticket
And user wait for "5" seconds
And user get the plate number and save its value as "search_plate" into temp file
And user get the state and save its value as "search_state" into temp file
And user get badgeId and save its value as "patroller_badgeID" into temp file
##And user get remark1 and save its value as "patroller_privateNotes" into temp file
And user get the state and save its value as "search_state" into temp file

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

Scenario: verify view details page
When user click on to the view details link of "search_number" citation number ticket
And user wait for "2" seconds
Then verify section "Patroller Memo" for "Badge ID" and "patroller_badgeID" as key its value
Then verify section "Vehicle Details" for "License Province or State" and "search_state" as key its value

Scenario: Make the citation void and verify
When user clicks search link from search result page
And user wait for "2" seconds
And user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "5" seconds

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

##Scenario: Make ticket/notice cancelled
##When user click on to the "Void" link of "search_number" citation number ticket
##And user wait for "5" seconds
##Then verify cancel citation form with "search_number" key as citation number
##When user select cancel notice code and save its value as "search_cancel_reason" into temp file
##And user wait for "3" seconds
##When user get cancel notice description and save its value as "search_cancel_comment" into temp file
##And user wait for "2" seconds
##When user get cancel notice comments and save its value as "search_cancel_comment" into temp file
##And user wait for "2" seconds
##And user clicks on choose file button and upload "pdf" file for void
##And user wait for "4" seconds
##Then verify that file uploaded into void section
##And user clicks on to the sumbit button of cancel citation popup
##And user wait for "2" seconds
##Then verify that notice with "Cancelled" citation status has been searched successfully
##Then verify that for "Void" link of "search_number" citation number ticket is not visible after void
##Then verify that for "Pay" link of "search_number" citation number ticket is not visible after void
##Then verify that notice with "search_number" citation number has view Details
##Then verify that "Support Note" link is present in search result

Scenario: verify the view details for support note details
When user click on to the view details link of "search_number" citation number ticket
And user wait for "2" seconds
Then verify that "search_note" note appears under notice info page from view details
Then verify download link for "search_note" note appears under notice info page from view details
Then verify that support notes section for "search_note" has user name same as logged user name info page from view details

##Scenario: verify the view details for void details
##Then verify section "Void Details" for "Notice void comments" and "search_cancel_comment" as key its value
##Then verify section "Void Details" for "Void Reason" and "search_cancel_reason" as key its value
##Then verify that void details has user name same as logged user name info page from view details

##Scenario: verify that the notice tab has status button to change the status of Notice to "Outstanding"
##When user click on to the status icon
##And user wait for "2" seconds
##And user click on to the submit button of update status popup
##Then verify the "Select status" validation message
##Then verify the listed values of status list
##When user select the status "Outstanding" from status list from update status popup
##And user click on to the submit button of update status popup
##Then verify the "Enter remarks" validation message
##When user enters remark for changing status for "Outstanding" status
##And user click on to the submit button of update status popup
##And user wait for "4" seconds
##Then verify that notice status is changing to "Outstanding"

Scenario: verify that the notice tab has status button to change the status of Notice to "Collection"
When user click on to the status icon
And user wait for "2" seconds
And user click on to the submit button of update status popup
When user select the status "Collection" from status list from update status popup
When user enters remark for changing status for "Collection" status
And user click on to the submit button of update status popup
And user wait for "4" seconds
Then verify that notice status is changing to "Collection"

Scenario: verify that the notice tab has status button to change the status of Notice to "Outstanding"
When user click on to the status icon
And user wait for "2" seconds
And user click on to the submit button of update status popup
When user select the status "Outstanding" from status list from update status popup
When user enters remark for changing status for "Outstanding" status
And user click on to the submit button of update status popup
And user wait for "4" seconds
Then verify that notice status is changing to "Outstanding"

Scenario: verify that the notice tab has status button to change the status of Notice to "Suspended"
When user click on to the status icon
And user wait for "2" seconds
And user click on to the submit button of update status popup
When user select the status "Suspended" from status list from update status popup
When user enters remark for changing status for "Suspended" status
And user click on to the submit button of update status popup
And user wait for "4" seconds
Then verify that notice status is changing to "Suspended"

Scenario: verify that the notice tab has status button to change the status of Notice to "Outstanding"
When user click on to the status icon
And user wait for "2" seconds
And user click on to the submit button of update status popup
When user select the status "Outstanding" from status list from update status popup
When user enters remark for changing status for "Outstanding" status
And user click on to the submit button of update status popup
And user wait for "2" seconds
And user click on to the yes continue button of popup
And user wait for "4" seconds
Then verify that notice status is changing to "Outstanding"

Scenario: verify audit trail for citation events making citation void and support note added
When user navigate to "Audit Trail" tab name and "#audit-trail" href link
And user wait for "4" seconds
Then verify that audit "Old Value: Valid" visible
Then verify that audit "New Value: Suspended" visible
Then verify that audit "Reason: citation note added" visible

Scenario: Close the browser
When user close browser