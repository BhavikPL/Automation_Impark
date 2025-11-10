@Phsa
@PhsaPayment2
Feature: Verify search ticket functionality by entering the ticket number, License plate and state

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
And user wait for "20" seconds

Scenario: search for Ticket1 in valid status
And user search for notice which has valid status and save its value as "search1_number" into temp file
And user click on date time link of "search1_number" notice
And user wait for "5" seconds
And user get the plate number and save its value as "search1_plate" into temp file
And user get the state and save its value as "search1_state" into temp file
And user get the amount due and save its value as "search1_amount_due" into temp file
And user wait for "2" seconds
And user get the lot and save its value as "search1_lot" into temp file
And user get the code and save its value as "search1_vioCode" into temp file
And user get the description and save its value as "search1_vioDescription" into temp file
And user get note1 and save its value as "patroller1_Public_Notes" into temp file
And user get vehicle make and save its value as "search1_vehicle_make" into temp file
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "10" seconds
And user get the original fine from financial page and save its value as "search1_originalFine" into temp file
And user clicks on to the back link
And user wait for "15" seconds

Scenario: search for Ticket2 in valid status
And user search for ticket which has valid status and save its value as "search2_number" into temp file
And user click on date time link of "search2_number" ticket
And user wait for "5" seconds
And user get the plate number and save its value as "search2_plate" into temp file
And user get the state and save its value as "search2_state" into temp file
And user get the amount due and save its value as "search2_amount_due" into temp file
And user wait for "2" seconds
And user get the lot and save its value as "search2_lot" into temp file
And user get the code and save its value as "search2_vioCode" into temp file
And user get the description and save its value as "search2_vioDescription" into temp file
And user get note1 and save its value as "patroller2_Public_Notes" into temp file
And user get vehicle make and save its value as "search2_vehicle_make" into temp file
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "10" seconds
And user get the original fine from financial page and save its value as "search2_originalFine" into temp file

Scenario: Search two tickets by entering the citation number seperated by comma
When user opens payment application
And user wait for "4" seconds
When user enters notice number by taking its value from temp file with key "search1_number" and "search2_number"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search1_number" citation number has been searched successfully
Then verify that notice with "search2_number" citation number has been searched successfully

Scenario: Motorist pay for multiple citation at a time
When user click on to the "Pay" button from top bar
And user wait for "5" seconds
When user clicks on to the make payment button
Then verify the message "Enter card number" visible on make payment screen
Then verify the message "Enter expiry" visible on make payment screen
Then verify the message "Enter cvc" visible on make payment screen
When user enters "bhavik.chondager@parkloyalty.com" for "Email Address" placeholder for payment
##( issue without email payment is not wokring, email is also not mandatory  )
And user enters card details
And user clicks on to the make payment button
And user wait for "5" seconds
Then verify "Success!" label on screen
Then verify "Payment has been posted successfully." label on screen

Scenario: Navigate to the search screen by clicking on to the back button from payment screen
When user click on to the back button
And user wait for "3" seconds
When user enters notice number by taking its value from temp file with key "search1_number" and "search2_number"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search1_number" citation number has "Paid" status
Then verify that notice with "search2_number" citation number has "Paid" status


Scenario: Close the browser
When user close browser