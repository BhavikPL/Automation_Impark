@Demo
@Phsa
@PhsaSearch1
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
And user wait for "20" seconds

Scenario: search for Notice in valid status
And user search for notice which has valid status and save its value as "search_number" into temp file
And user click on date time link of "search_number" notice
And user wait for "5" seconds
And user get the plate number and save its value as "search_plate" into temp file
And user get the state and save its value as "search_state" into temp file
And user get the amount due and save its value as "search_amount_due" into temp file
And user wait for "2" seconds
##And user get the lot and save its value as "search_lot" into temp file
And user get the code and save its value as "search_vioCode" into temp file
And user get the description and save its value as "search_vioDescription" into temp file
##And user get the type and save its value as "search_vioType" into temp file
And user get note1 and save its value as "patroller_Public_Notes" into temp file
And user get vehicle make and save its value as "search_vehicle_make" into temp file
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "4" seconds
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
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "Outstanding" citation status has been searched successfully
Then verify that notice with "search_originalFine" citation original fine has been searched successfully
Then verify that "Add Discount" link is present in search result
##Then verify that "Void" link is present in search result
Then verify that "Support Note" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that notice with "search_number" citation number has view Details
Then verify that "search_number" is the value for notice number field after search
Then verify sitename "PHSA-Staging" in the search result
Then verify that "search_number" is the value for notice number field after search
##Then verify notice branch lot is "search_lot" after search
Then verify notice vio code is "search_vioCode" after search
Then verify notice original amount is "search_originalFine" after search
Then verify notice total due is "search_amount_due" after search
##Then verify notice type code description is "search_vioType" after search

Scenario: Search by license plate and state
When user clicks search link from search result page
And user enters License Plate by taking its value from temp file with key "search_plate"
And user selects the License Province or State value from list by taking its value from temp file with key "search_state"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully
Then verify that notice with "search_plate" citation plate has been searched successfully
Then verify that notice with "Outstanding" citation status has been searched successfully
Then verify that notice with "search_originalFine" citation original fine has been searched successfully
Then verify that "Add Discount" link is present in search result
##Then verify that "Void" link is present in search result
Then verify that "Support Note" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that notice with "search_number" citation number has view Details
Then verify that "search_number" is the value for notice number field after search
Then verify that "search_number" is the value for notice number field after search
##Then verify notice branch lot is "search_lot" after search
Then verify notice vio code is "search_vioCode" after search
Then verify notice original amount is "search_originalFine" after search
Then verify notice total due is "search_amount_due" after search
Then verify sitename "PHSA-Staging" in the search result
##Then verify notice type code description is "search_vioType" after search

Scenario: Search validation with empty fields
When user clicks search link from search result page
And user clears Notice number and License Plate fields
And user clicks on search button
And user wait for "2" seconds
Then verify that "Enter ticket number or Licence Plate" message popups

Scenario: Prevent special characters in notice and license inputs
When user wait for "7" seconds
And user enters special characters into Notice number and License Plate fields
Then verify that special characters are not entered into Notice number and License Plate fields

Scenario: Search by citation number and make the citation cancelled and verify view details
When user enters notice number by taking its value from temp file with key "search_number"
And user clicks on search button
And user wait for "4" seconds
Then verify that notice with "search_number" citation number has been searched successfully

Scenario: verify view details page
When user click on to the view details link of "search_number" citation number ticket
And user wait for "2" seconds
##Then verify section "Officer Details" for "Officer Name" and "search_officer" as key its value
Then verify section "Vehicle Details" for "Vehicle Make" and "search_vehicle_make" as key its value
##Then verify section "Vehicle Details" for "Vehicle Model" and "search_vehmodel" as key its value
Then verify section "Vehicle Details" for "Licence Plate Number" and "search_plate" as key its value
##Then verify section "Location Details" for "Street" and "search_street" as key its value
##Then verify section "Location Details" for "Block" and "search_block" as key its value
Then verify section "Violation Details" for "Description" and "search_vioDescription" as key its value
Then verify section "Violation Details" for "Code" and "search_vioCode" as key its value
Then verify section "Patroller Memo" for "Public Notes" and "patroller_Public_Notes" as key its value
#Then verify section "Enforcement Notes" for "Printed Remark 1" and "search_remark" as key its value
#Then verify total "1" images is under "Images" label

Scenario: verify financial page
When user navigate to "Financial" tab name and "#commercial" href link
And user wait for "4" seconds
Then verify that "Original Fine" filed has "search_originalFine" key as value from financial page
Then verify that "Total Due" filed has "search_amount_due" key as value from financial page
##Then verify that "Service Fee" is same as configured service charge amount from financial page

Scenario: Close the browser
When user close browser