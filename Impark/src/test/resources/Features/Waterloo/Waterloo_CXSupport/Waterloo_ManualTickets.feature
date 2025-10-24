#Author: Bhavik Chondager
@Demo
@Manual_Tickets
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
And user wait for "1" seconds
#Then verify create tickets page

When user enters citation number and save its value as "citation1_number" into temp file

And user selects today date for issue date
#And user select office from the officer list and save its value as "citation1_office" into temp file

And user enters officer name into officer field and save its value as "citation1_office" into temp file
And user wait for "1" seconds
And verify badge id from the badge id list and save its value as "citation1_badge" into temp file

And user enters plate number and save its value as "citation1_plate" into temp file
#And user select state from the officer list and save its value as "citation1_state" into temp file

And user enters state name into state field and save its value as "citation1_state" into temp file
#And user select veh make from the make list and save its value as "citation1_vehmake" into temp file

And user enters veh make into veh make field and save its value as "citation1_vehmake" into temp file
#And user select veh model from the model list and save its value as "citation1_vehmodel" into temp file

And user enters veh model into veh model field and save its value as "citation1_vehmodel" into temp file
#And user select veh color from the color list and save its value as "citation1_color" into temp file

And user enters veh color into veh color field and save its value as "citation1_color" into temp file

And user select body style from the style list and save its value as "citation1_style" into temp file
#And user select block from the block list and save its value as "citation1_block" into temp file

And user enters lot into lot field and save its value as "citation1_lot" and "citation1_block" and "citation1_street" into temp file

#And user select street from the street list and save its value as "citation1_street" into temp file

And user enters street into street field and save its value as "citation1_street" into temp file

And user select vio code from the vio code list and save its value as "citation1_viocode" into temp file

Then verify description from the description list and save its value as "citation1_description" into temp file

And verify the fine and save its value as "citation1_fine" into temp file

And verify the paid after and save its value as "citation1_paidafter" into temp file
And user wait for "1" seconds
When user enters remark and save its value as "citation1_remark" into temp file
And user enters block into block field and save its value as "citation1_block" into temp file
And user clicks on upload image button and upload "jpg" file

And user wait for "10" seconds

And user clicks on submit button to create ticket

Then verify the successfully ticket creation message

When user clicks on to the okay button of message

Scenario: Close the browser
When user close browser