@Phsa
@PhsaPayment1
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

Scenario: search for Notice in valid status
And user search for notice which has valid status and save its value as "search_number" into temp file
And user click on date time link of "search_number" notice
And user wait for "5" seconds
And user get the plate number and save its value as "search_plate" into temp file
And user get the state and save its value as "search_state" into temp file
And user get the amount due and save its value as "search_amount_due" into temp file
And user wait for "2" seconds
And user get the lot and save its value as "search_lot" into temp file
And user get the code and save its value as "search_vioCode" into temp file
And user get the description and save its value as "search_vioDescription" into temp file
##And user get the type and save its value as "search_vioType" into temp file
And user get note1 and save its value as "patroller_Public_Notes" into temp file
And user get vehicle make and save its value as "search_vehicle_make" into temp file
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "4" seconds
And user get the original fine from financial page and save its value as "search_originalFine" into temp file

Scenario: Search for notices functionality
When user opens payment application
And user wait for "4" seconds
##Then verify that Search For Notices page opens
When user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that notice with "search_plate" citation plate has been searched successfully
##Then verify that notice with "Valid" citation status has been searched successfully from payment portal
Then verify that notice with "search_originalFine" citation original fine has been searched successfully
Then verify that "Pay" link is present in search result
Then verify that "search_number" is the value for notice number field after search
Then verify notice branch lot is "search_lot" after search
Then verify notice vio code is "search_vioCode" after search
Then verify notice original amount is "search_originalFine" after search
Then verify notice total due is "search_amount_due" after search
Then verify sitename "PHSA-Staging" in the search result

Scenario: Search by license plate and state
When user clicks search link from search result page
And user wait for "2" seconds
And user enters License Plate by taking its value from temp file with key "search_plate" from payment application
And user selects the License Province or State value from list by taking its value from temp file with key "search_state" from payment application
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "Outstanding" citation status has been searched successfully
Then verify that notice with "search_originalFine" citation original fine has been searched successfully
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Note" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that notice with "search_number" citation number has view Details
Then verify that "search_number" is the value for notice number field after search
Then verify that "search_number" is the value for notice number field after search
Then verify notice branch lot is "search_lot" after search
Then verify notice vio code is "search_vioCode" after search
Then verify notice original amount is "search_originalFine" after search
Then verify notice total due is "search_amount_due" after search
Then verify sitename "PHSA-Staging" in the search result
##Then verify notice type code description is "search_vioType" after search

Scenario: Search validation with empty fields
When user clicks search link from search result page
And user wait for "2" seconds
And user clears Notice number and License Plate fields from payment application
And user clicks on search button
And user wait for "2" seconds
Then verify that "Enter ticket number or Licence Plate" message popups from payment portal from payment application

Scenario: Prevent special characters in notice and license inputs
When user wait for "7" seconds
And user enters special characters into Notice number and License Plate fields from payment application
Then verify that special characters are not entered into Notice number and License Plate fields from payment application

Scenario: Search by citation number and make the citation cancelled and verify view details
When user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "4" seconds
Then verify that notice with "search_number" citation number has been searched successfully

Scenario: Close the browser
When user close browser