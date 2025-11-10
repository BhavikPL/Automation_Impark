#Author: Bhavik Chondager
@Demo
@Phsa5
@PhsaSearch5
Feature: For two citations make them to void and verify status

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
And user search for notice which has valid status and save its value as "search1_number" into temp file
And user click on date time link of "search1_number" notice
And user wait for "5" seconds
And user get the plate number and save its value as "search1_plate" into temp file
And user clicks on to the back link
And user wait for "15" seconds

Scenario: search for Ticket2 in valid status
And user search for ticket which has valid status and save its value as "search2_number" into temp file
And user click on date time link of "search2_number" ticket
And user wait for "5" seconds
And user get the plate number and save its value as "search2_plate" into temp file

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
Then verify that notice with "search2_number" citation number has been searched successfully


Scenario: Admin make the citations void for multiple citation
When user click on to the "Void" button from top bar
And user wait for "2" seconds
Then verify cancel citation form with "search1_number" key as citation number
Then verify cancel citation form with "search2_number" key as citation number
When user select cancel notice code and save its value as "search_cancel_reason" into temp file
And user wait for "3" seconds
When user get cancel notice description and save its value as "search_cancel_comment" into temp file
And user wait for "2" seconds
When user get cancel notice comments and save its value as "search_cancel_comment" into temp file
And user wait for "2" seconds
And user clicks on choose file button and upload "pdf" file for void
And user wait for "4" seconds
Then verify that file uploaded into void section
And user clicks on to the sumbit button of cancel citation popup
And user wait for "2" seconds
Then verify that notice with "search1_number" citation number has "Cancelled" status
Then verify that notice with "search2_number" citation number has "Cancelled" status
Then verify that for "Void" link of "search_number" citation number ticket is not visible after void
Then verify that for "Pay" link of "search_number" citation number ticket is not visible after void
Then verify that "Support Note" link is present in search result

Scenario: Close the browser
When user close browser