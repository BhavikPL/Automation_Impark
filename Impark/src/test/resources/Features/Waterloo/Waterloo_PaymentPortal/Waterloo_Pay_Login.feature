
@waterloo
@LoginPayment
Feature: verify login functionality of payment application

@datasetup
Scenario: setup for test
And user setups brower
And user opens payment application
And user navigate to login page
And user wait for "1" seconds

@TestcaseId=TC_LOGIN_002
Scenario: Valid Login with Correct Username and Password
When user do login to payment application with valid credentials
And user enters otp into OTP Verification page
And user wait for "2" seconds

Scenario: Cleanup
When user close browser
