@Demo
@Phsa
@PhsaSearch
Feature: Add discount to the ticket and pay

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

Scenario: search for Ticket1 in valid status
And user search for ticket which has valid status and save its value as "search_number" into temp file
And user click on date time link of "search_number" ticket
And user wait for "5" seconds
And user get the plate number and save its value as "search_plate" into temp file
And user get the state and save its value as "search_state" into temp file
And user get the amount due and save its value as "search_amount_due" into temp file
And user wait for "2" seconds
And user get the lot and save its value as "search_lot" into temp file
And user get the code and save its value as "search_vioCode" into temp file
And user get the description and save its value as "search_vioDescription" into temp file
And user get note1 and save its value as "patroller_Public_Notes" into temp file
And user get vehicle make and save its value as "search_vehicle_make" into temp file
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "10" seconds
And user get the original fine from financial page and save its value as "search_originalFine" into temp file

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
Then verify that Original fine amount is same as "search_originalFine" citation fine
Then verify that New Fine Amount Due is same as "search_originalFine" citation fine
When user click on submit button of Add Discount popup
Then verify that "Discount end date is required" message display as mandatory filed for add discount popup
Then verify that "Remark is required" message display as mandatory filed for add discount popup
When user entered "10" as discount in the Discount Amount field from add discount popup
When user entered "2" as Discount Days from add discount popup
Then verify that Discount End Date is populating the "2" days of future with respect to current date
Then verify that New Fine Amount Due is the "search_originalFine" minus "10" as discounted amount and save its value as "search_fine_discounted" into temp file
When user entered the remark from add discount popup
And user wait for "2" seconds
And click on to the Submit button from add discount popup
And user wait for "5" seconds
Then verify notice total due is "search_fine_discounted" after search


Scenario: Close the browser
When user close browser