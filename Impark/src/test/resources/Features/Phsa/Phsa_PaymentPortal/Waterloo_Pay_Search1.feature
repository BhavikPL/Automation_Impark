@waterloo
@SearchPayment1
Feature: Verify search ticket functionality by entering the ticket number, License plate and state

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

Scenario: Valid Login with Correct Username and Password
And user opens payment application
And user navigate to login page
And user wait for "1" seconds
And user do login to payment application with valid credentials
And user enters otp into OTP Verification page from payment application
And user wait for "2" seconds

Scenario: Search for notices functionality
Then verify that Search For Notices page opens
When user enters notice number by taking its value from temp file with key "search_number" from payment application
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully from payment application
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully from payment application
Then verify that notice with "search_vioDesc" citation violation description has been searched successfully from payment application
Then verify that notice with "Valid" citation status has been searched successfully from payment application
Then verify that notice with "search_fine" citation original fine has been searched successfully from payment application
Then verify that "View Images" link is present in search result from payment application
Then verify that "Pay" link is present in search result from payment application
Then verify that "search_number" is the value for notice number field after search from payment application
Then verify sitename in the search result from payment application
Then verify that total "1" search notices are in result from payment application

Scenario: Search by license plate and state
When user clicks search link from search result page
And user enters License Plate by taking its value from temp file with key "search_plate"
And user selects the License Province or State value from list by taking its value from temp file with key "search_state"
And user clicks on search button
And user wait for "2" seconds
Then verify that notice with "search_number" citation number has been searched successfully from payment application
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully from payment application
Then verify that notice with "search_vioDesc" citation violation description has been searched successfully from payment application
Then verify that notice with "Valid" citation status has been searched successfully from payment application
Then verify that notice with "search_fine" citation original fine has been searched successfully from payment application
Then verify that "Add Discount" link is present in search result
Then verify that "Void" link is present in search result
Then verify that "Support Notes" link is present in search result
Then verify that "Pay" link is present in search result
Then verify that "View Details" link is present in search result
Then verify sitename in the search result
Then verify that total "1" search notices are in result

Scenario: Search validation with empty fields
When user clicks search link from search result page from payment application
And user clears Notice number and License Plate fields from payment application
And user clicks on search button from payment application
And user wait for "2" seconds
Then verify that "Enter ticket number or Licence Plate" message popups from payment portal

Scenario: Prevent special characters in notice and license inputs
When user wait for "7" seconds
And user enters special characters into Notice number and License Plate fields from payment application
Then verify that special characters are not entered into Notice number and License Plate fields from payment application

Scenario: Search by citation number and make the citation cancelled and verify view details
When user enters notice number by taking its value from temp file with key "search_number" from payment application
And user clicks on search button from payment application
And user wait for "4" seconds
Then verify that notice with "search_number" citation number has been searched successfully from payment application
Then verify that today is the citation issue date
Then verify that notice with "search_plate" citation plate has been searched successfully from payment application
Then verify that notice with "search_vioDesc" citation violation description has been searched successfully from payment application
Then verify that notice with "Valid" citation status has been searched successfully from payment application
Then verify that notice with "search_fine" citation original fine has been searched successfully from payment application
Then verify that "Add Discount" link is present in search result from payment application
Then verify that "Void" link is present in search result from payment application
Then verify that "Support Notes" link is present in search result from payment application
Then verify that "Pay" link is present in search result from payment application
Then verify that "View Details" link is present in search result from payment applicatio from payment applicationn
Then verify that "search_number" is the value for notice number field after search
Then verify sitename in the search result from payment application
Then verify that total "1" search notices are in result from payment application

Scenario: Close the browser
When user close browser