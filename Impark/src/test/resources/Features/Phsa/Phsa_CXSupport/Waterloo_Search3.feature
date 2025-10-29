#Author: Bhavik Chondager
@Demo
@waterloo
@Search3
Feature: For two citations if one is cancelled then payment screen, for payment only valid's fine will be considered

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
And user enters veh color into veh color field and save its value as "search_color" into temp file
And user select body style from the style list and save its value as "search_style" into temp file
And user enters street into street field and save its value as "search_street" into temp file
And user enters lot into lot field and save its value as "search_lot" and "search_block" and "search_street" into temp file
And user select vio code from the vio code list and save its value as "search_viocode" into temp file
And user select vio description from the vio code list and save its value as "search_vioDesc" into temp file
Then verify description from the description list and save its value as "search_description" into temp file
And verify the fine and save its value as "search_fine" into temp file
And verify the paid after and save its value as "search_paidafter" into temp file
When user enters remark and save its value as "search_remark" into temp file
And user enters block into block field and save its value as "search_block" into temp file
And user clicks on upload image button and upload "jpg" file
And user wait for "10" seconds
And user clicks on submit button to create ticket
Then verify the successfully ticket creation message
When user clicks on to the okay button of message
When user wait for "2" seconds

Scenario: create citation2
When user enters citation number and save its value as "search2_number" into temp file
And user selects today date for issue date
And user enters officer name into officer field and save its value as "search2_officer" into temp file
And verify badge id from the badge id list and save its value as "search2_badge" into temp file
And user wait for "1" seconds
And user enters "search_plate" plate number
And user enters state name into state field and save its value as "search2_state" into temp file
And user enters veh make into veh make field and save its value as "search2_vehmake" into temp file
And user enters veh model into veh model field and save its value as "search2_vehmodel" into temp file
And user enters veh color into veh color field and save its value as "search2_color" into temp file
And user select body style from the style list and save its value as "search2_style" into temp file
And user enters street into street field and save its value as "search2_street" into temp file
And user enters lot into lot field and save its value as "search2_lot" and "search2_block" and "search2_street" into temp file
And user select vio code from the vio code list and save its value as "search2_viocode" into temp file
And user select vio description from the vio code list and save its value as "search2_vioDesc" into temp file
Then verify description from the description list and save its value as "search2_description" into temp file
And verify the fine and save its value as "search2_fine" into temp file
And verify the paid after and save its value as "search2_paidafter" into temp file
When user enters remark and save its value as "search2_remark" into temp file
And user enters block into block field and save its value as "search2_block" into temp file
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

Scenario: Make the citation void and verify
When user click on to the "Void" link of "search_number" citation number ticket
And user wait for "5" seconds
Then verify cancel citation form with "search_number" key as citation number
When user select cancel citation reason and save its value as "search_cancel_reason" into temp file
And user wait for "2" seconds
When user get cancel citation comments and save its value as "search_cancel_comment" into temp file
And user clicks on choose file button and upload "pdf" file for void
And user wait for "4" seconds
Then verify that file uploaded into void section
And user clicks on to the sumbit button of cancel citation popup
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has "Cancelled" status
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "search_number" citation number has "search_vioDesc" vio description
Then verify that notice with "search_number" citation number has "search_fine" Original Fine

Then verify that notice with "search2_number" citation number has been searched successfully
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "search2_number" citation number has "search2_vioDesc" vio description
Then verify that notice with "search2_number" citation number has "search2_fine" Original Fine
Then verify that Total Amount is the summation of "search2_fine"

Scenario: Admin pay( check the fine amount ) for multiple citation at a time
When user check the header checkbox
And user wait for "1" seconds
When user click on to the "Pay" button from top bar
And user wait for "5" seconds
Then verify that page has "Plate number" label and "search_plate" as key its value
Then verify that page has "Notice number" label and "search2_number" as key its value
Then verify that page has "Notice number" label and "search2_number" as key its value
Then verify that page has "Payment amount" label and "search2_fine" as key its value
Then verify that Total Amount is the summation of "search2_fine" from make payment screen

Scenario: Close the browser
When user close browser