#Author: Bhavik Chondager
@waterloo
@Search
Feature: For two citations make them to void and verify status

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

Scenario: create citation1
When user enters citation number and save its value as "search1_number" into temp file
And user selects today date for issue date
And user enters officer name into officer field and save its value as "search1_officer" into temp file
And verify badge id from the badge id list and save its value as "search1_badge" into temp file
And user wait for "1" seconds
And user enters plate number and save its value as "search_plate" into temp file
And user enters state name into state field and save its value as "search1_state" into temp file
And user enters veh make into veh make field and save its value as "search1_vehmake" into temp file
And user enters veh model into veh model field and save its value as "search1_vehmodel" into temp file
And user enters veh color into veh color field and save its value as "search1_color" into temp file
And user select body style from the style list and save its value as "search1_style" into temp file
And user enters street into street field and save its value as "search1_street" into temp file
And user enters lot into lot field and save its value as "search1_lot" and "search1_block" and "search1_street" into temp file
And user select vio code from the vio code list and save its value as "search1_viocode" into temp file
And user select vio description from the vio code list and save its value as "search1_vioDesc" into temp file
Then verify description from the description list and save its value as "search1_description" into temp file
And verify the fine and save its value as "search1_fine" into temp file
And verify the paid after and save its value as "search1_paidafter" into temp file
When user enters remark and save its value as "search1_remark" into temp file
And user enters block into block field and save its value as "search1_block" into temp file
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

Scenario: Search two tickets by entering the citation number seperated by comma
When user enters notice number by taking its value from temp file with key "search1_number" and "search2_number"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search1_number" citation number has been searched successfully
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "search1_number" citation number has "search1_vioDesc" vio description
Then verify that notice with "search1_number" citation number has "search1_fine" Original Fine
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Notes" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that "View Details" link is present in search result
Then verify that "search1_number" is the value for notice number field after search
Then verify that "search2_number" is the value for notice number field after search
Then verify sitename in the search result

Then verify that notice with "search2_number" citation number has been searched successfully
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "search2_number" citation number has "search2_vioDesc" vio description
Then verify that notice with "search2_number" citation number has "search2_fine" Original Fine
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Notes" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that "View Details" link is present in search result
Then verify that "search2_number" is the value for notice number field after search
Then verify that Total Amount is the summation of "search1_fine" and "search2_fine"

Scenario: Admin make the citations void for multiple citation
When user click on to the "Void" button from top bar
And user wait for "2" seconds
Then verify cancel citation form with "search1_number" key as citation number
Then verify cancel citation form with "search2_number" key as citation number
When user enters cancel citation comments and save its value as "search_cancel_comment" into temp file
When user select cancel citation reason and save its value as "search_cancel_reason" into temp file
And user wait for "2" seconds
And user clicks on to the sumbit button of cancel citation popup
And user wait for "2" seconds
Then verify that notice with "search1_number" citation number has "Cancelled" status
Then verify that notice with "search2_number" citation number has "Cancelled" status

Scenario: Close the browser
When user close browser