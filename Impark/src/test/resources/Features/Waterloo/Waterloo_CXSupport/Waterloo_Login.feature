
@waterloo
@Login
Feature: verify login functionality of cx support application
 

@TestcaseId=TC_LOGIN_001
Scenario: Verify components on login page
When user setups brower
And user opens cx support application
Then verify login page components are visible

@TestcaseId=TC_LOGIN_002
Scenario: Valid Login with Correct Username and Password
When user do login to cx support application with valid credentials
Then verify that user is redirected to OTP verification page
When user clicks on back button of browser

@TestcaseId=TC_LOGIN_003
Scenario: Invalid Login with Incorrect Username
When user do login to cx suppport application with "invaliduser" invalid user name
Then verify error message is displayed with text "Invalid User details"

@TestcaseId=TC_LOGIN_004
Scenario: Invalid Login with Incorrect Password
When user do login to cx suppport application with "wrongpassword" invalid password
Then verify error message is displayed with text "Entered username/password is invalid. If you're experiencing difficulties resetting your password, please contact our support team for assistance."

@TestcaseId=TC_LOGIN_005
Scenario: Login with Empty Username Field
When user enter "" into username
And user enter "validpassword" into password
And user clicks onto the login button
Then verify validation error is displayed for empty "Enter username"

@TestcaseId=TC_LOGIN_006
Scenario: Login with Empty Password Field
When user enter "validuser" into username
And user enter "" into password
And user clicks onto the login button
Then verify validation error is displayed for empty "Enter password"

@TestcaseId=TC_LOGIN_007
Scenario: Login with Both Fields Empty
When user enter "" into username
And user enter "" into password
And user clicks onto the login button
Then verify validation error is displayed for empty "Enter username"
Then verify validation error is displayed for empty "Enter password"

@TestcaseId=TC_LOGIN_008
Scenario: Forgot Password Link Functionality
When user clicks on forgot password link
Then verify user is redirected to password reset page

Scenario: Cleanup
When user close browser
