@Demo
@Phsa
@PhsaSearch4
Feature: Add discount to the ticket and pay

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

Scenario: create citation
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

Scenario: Add discount for the citation ticket
When user click on to the "Add Discount" link of "search_number" citation number ticket
And user wait for "2" seconds
Then verify that Original fine amount is same as "search_fine" citation fine
Then verify that New Fine Amount Due is same as "search_fine" citation fine
When user click on submit button of Add Discount popup
Then verify that "Discount end date is required" message display as mandatory filed for add discount popup
Then verify that "Remark is required" message display as mandatory filed for add discount popup
When user entered "10" as discount in the Discount Amount field from add discount popup
When user entered "2" as Discount Days from add discount popup
Then verify that Discount End Date is populating the "2" days of future with respect to current date
Then verify that New Fine Amount Due is the "search_fine" minus "10" as discounted amount and save its value as "search_fine_discounted" into temp file
When user entered the remark from add discount popup
And user wait for "2" seconds
And click on to the Submit button from add discount popup
And user wait for "5" seconds
Then verify that Total Amount is the summation of "search_fine_discounted"

Scenario: Verify that the payment made for the discounted citation.
When user check the header checkbox
And user wait for "1" seconds
When user click on to the "Pay" button from top bar
And user wait for "5" seconds
Then verify that page has "Plate number" label and "search_plate" as key its value
Then verify that page has "Notice number" label and "search_number" as key its value
Then verify that Total Amount is the summation of "search_fine_discounted" from make payment screen


Scenario: Close the browser
When user close browser