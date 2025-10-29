@Demo
@Phsa
@PhsaSearch7
Feature: Verify the lot-branch id, vio type, description and vio code by searching for ticket

@datasetup
Scenario: setup for test
And user setups brower

Scenario: Valid Login with Correct Username and Password
And user opens cx support application
And user do login to cx support application with valid credentials
Then verify that user is redirected to OTP verification page
When user enters otp into OTP Verification page
And user wait for "2" seconds

Scenario Outline: verify Code, description from violation details section
Then verify that Search For Notices page opens
When user enters "<citation_number>" notice number
And user clicks on search button
And user wait for "4" seconds
#Then verify that notice with "<citation_number>" citation number has "<violation>" violation
Then verify that notice with "<citation_number>" citation number has "<violation_type>" violation type
Then verify that notice with "<citation_number>" citation number has "<lot_branch>" BranchLot
When user click on to the view details link of "<citation_number>" citation number
And user wait for "2" seconds
Then verify section "Violation Details" for "Code" and "<code>"
Then verify section "Violation Details" for "Description" and "<Description>"
When user clicks search link from search result page
And user wait for "2" seconds

Examples:
| citation_number | violation_type | lot_branch 					| code | Description 						|
| 6418306         | 4 - Restricted | 01-199     					|	PTNT |	Patient Parking Only	|
| 6418694         | 4 - Restricted | 01-199     					|	PTNT |	Patient Parking Only	|
| 6418695         | 1 - No record of payment | 01-202     |PLAT	 |  Not Registered        |

Scenario Outline: verify Internal Note 1, Internal Note 2, Printed Remark1,Printed Remark2 from "Patroller Memo section
Then verify that Search For Notices page opens
When user enters "<citation_number>" notice number
And user clicks on search button
And user wait for "4" seconds
When user click on to the view details link of "<citation_number>" citation number
And user wait for "2" seconds
Then verify section "Patroller Memo" for "Internal Note 1" and "<Internal Note1>"
Then verify section "Patroller Memo" for "Internal Note 2" and "<Internal Note2>"
Then verify section "Patroller Memo" for "Printed Remark 1" and "<Printed Remark1>"
Then verify section "Patroller Memo" for "Printed Remark 2" and "<Printed Remark2>"
When user clicks search link from search result page
And user wait for "2" seconds

Examples:
| citation_number | Internal Note1                  |  Internal Note2 			    | Printed Remark1                     | Printed Remark2 			|
| 400019907       |NO PARKING IN CONSTRUCTION ZONE | LEFT REAR TIRE CHALKED   |	TAXI STAND -MOVE OR WILL BE TOWED. 	|	EXPIRED LICENSE PLATE	|



Scenario: Close the browser
When user close browser