#Author: Bhavik Chondager
@Demo
@Phsa_Manual_Tickets

Feature: Verify functionality of manual ticket section

@datasetup
Scenario: setup for test
When user setups brower
And user opens processing pro application
And user do login to processing pro application with valid credentials
And user enters otp into OTP Verification page
Then verify that login successfull
When user wait for "2" seconds

Scenario: user can expand to the manual ticket menu
And user extends manual tickets menu

Scenario: Verify that ticket management options
Then verify options for manual tickets

Scenario: Verify that user can create ticket manually
And user clicks on to the create ticket option
When user enters citation number and save its value as "search1_number" into temp file
And user selects today date for issue date
And user enters officer name into officer field and save its value as "search1_officer" into temp file
And verify badge id from the badge id list and save its value as "search1_badge" into temp file
And user wait for "1" seconds
And user enters plate number and save its value as "search_plate" into temp file
And user enters state name into state field and save its value as "search1_state" into temp file
And user enters veh make into veh make field and save its value as "search1_vehmake" into temp file
And user enters veh model into veh model field and save its value as "search1_vehmodel" into temp file
#And user enters veh color into veh color field and save its value as "search1_color" into temp file
#And user select body style from the style list and save its value as "search1_style" into temp file
And user enters street into street field and save its value as "search1_street" into temp file
And user enters lot into lot field and save its value as "search1_lot" and "search1_block" and "search1_street" into temp file
And user select vio code from the vio code list and save its value as "search1_viocode" into temp file
And user select vio description from the vio code list and save its value as "search1_vioDesc" into temp file
Then verify description from the description list and save its value as "search1_description" into temp file
And verify the fine and save its value as "search1_fine" into temp file
And verify the paid after and save its value as "search1_paidafter" into temp file
#When user enters remark and save its value as "search1_remark" into temp file
And user enters block into block field and save its value as "search1_block" into temp file
And user clicks on submit button to create ticket
Then verify the successfully ticket creation message
When user clicks on to the okay button of message
When user wait for "2" seconds

Scenario: Close the browser
When user close browser