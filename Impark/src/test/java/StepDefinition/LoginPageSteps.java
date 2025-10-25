package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mailosaur.MailosaurException;

import pages.LoginPage;
import base.Base;
import base.BasePage;
import base.BrowserManager;
import base.DriverUtilities;
import config.Settings;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import path.Path;
import utility.PropertyUtil;

public class LoginPageSteps extends Base
{	
	
	BasePage CurrentPage;

	@When("user update total testcase count to {int}")
	public void user_update_total_testcase_count_to( int testcase )
	{
		int c;
		c = totalTestCases.get() + testcase;
		totalTestCases.set(c);
	}

	@When("user clears data property file")
	public void user_clears_data_property_file()
	{
		try { PropertyUtil.clearProperty();} catch (IOException e) {}
	}
	
	@When("user setups brower")
	public void setup_brower()
	{
		RemoteWebDriver driver = BrowserManager.openBrowser(Settings.browserName);
		threadLocalDriver.set(driver);
		DriverUtilities dUtil = new DriverUtilities();
		driverUtilities.set(dUtil);
		totalTestCases.set(0);
	}
	
	@When("user setups brower for {string} client tests")
	public void setup_brower(String client)
	{
		RemoteWebDriver driver = BrowserManager.openBrowser(Settings.browserName);
		threadLocalDriver.set(driver);
		DriverUtilities dUtil = new DriverUtilities();
		driverUtilities.set(dUtil);
		totalTestCases.set(0);
	}
	
	@When("user close browser")
	public void close_brower()
	{
		BrowserManager.closeBrowser(threadLocalDriver.get());
		threadLocalDriver.remove();
		totalTests = totalTests + totalTestCases.get();
	}
	
	@When("user opens processing pro application")
	public void open_Processing_pro_application()
	{
		threadLocalDriver.get().get(Settings.application_Url);
		try { Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	@When("user opens cx support application")
	public void open_cx_support_application()
	{
		threadLocalDriver.get().get(Settings.cxSupport_Url);
		try { Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	@When("user opens payment application")
	public void open_payment_application()
	{
		threadLocalDriver.get().get(Settings.payment_Url);
		try { Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	@When("user do login to processing pro application with valid credentials")
	public void login_to_processing_valid_credentials()
	{
		CurrentPage.getInstance(LoginPage.class).doLoginWithValidCredentials();
	}
	
	@When("user do login to cx support application with valid credentials")
	public void login_to_cx_support_valid_credentials()
	{
		CurrentPage.getInstance(LoginPage.class).loginCXSupportWithValidCredentials();
	}
	
	@When("user do login to payment application with valid credentials")
	public void login_to_payment_valid_credentials()
	{
		CurrentPage.getInstance(LoginPage.class).loginPaymentWithValidCredentials();
	}
	
	@When("user do login to processing pro application with {string} invalid user name")
	public void login_to_processing_application_invalid_username(String userName)
	{
		CurrentPage.getInstance(LoginPage.class).doLoginWithInvalidUserName(userName);
	}
	
	@When("user do login to cx suppport application with {string} invalid user name")
	public void login_to_cx_suppport_invalid_username(String userName)
	{
		CurrentPage.getInstance(LoginPage.class).loginCXSupportWithInvalidUserName(userName);
	}
	
	@When("user do login to processing pro application with {string} invalid password")
	public void login_to_WN_application_invalid_password(String password)
	{
		CurrentPage.getInstance(LoginPage.class).doLoginWithInvalidPassword(password);
	}
	
	@When("user do login to cx suppport application with {string} invalid password")
	public void login_to_cx_suppport_invalid_password(String password)
	{
		CurrentPage.getInstance(LoginPage.class).loginCXSupportWithInvalidPassword(password);
	}
	
	@When("verify logoff done successfully")
	public void verify_logoff_done_successfully()
	{
		CurrentPage.getInstance(LoginPage.class).verifyLogoffSuccess();
	}
	
	@When("user wait for {string} seconds")
	public void user_wait_for_seconds(String time)
	{
		CurrentPage.getInstance(LoginPage.class).waitForSeconds(time);
	}
	

	@When("user wait for post to be populated")
	public void user_wait_for_post_to_be_populate()
	{
		CurrentPage.getInstance(LoginPage.class).waitForPostPopulate();
	}
	
	@When("user wait for user icon to be populated")
	public void user_wait_for_usericon_to_be_populate()
	{
		CurrentPage.getInstance(LoginPage.class).waitForLogoffPopulate();
	}
	
	@When("user refresh browser")
	public void user_refresh_browser()
	{
		CurrentPage.getInstance(LoginPage.class).refreshBrowser();
	}
	
	@When("user enter {string} into username")
	public void user_enter_into_username(String userName)
	{
		CurrentPage.getInstance(LoginPage.class).enterValueIntoUserName(userName);
	}
	
	@When("user enter {string} into password")
	public void user_enter_into_password(String password)
	{
		CurrentPage.getInstance(LoginPage.class).enterValueIntoPassword(password);
	}
	
	@When("user clicks onto the login button")
	public void user_clicks_onto_the_login_button()
	{
		CurrentPage.getInstance(LoginPage.class).userClicksOnLoginButton();
	}
	
	@When("user enters otp into OTP Verification page")
	public void user_enters_otp_into_OTP_Verification_page() throws IOException, MailosaurException, AWTException
	{
		CurrentPage.getInstance(LoginPage.class).enterOtp();
	}
	
	@When("user enters otp into OTP Verification page from payment application")
	public void user_enters_otp_into_OTP_Verification_page_payment() throws IOException, MailosaurException, AWTException
	{
		CurrentPage.getInstance(LoginPage.class).enterOtp_payment();
	}
	
	@Then("verify that login successfull")
	public void verify_that_login_successfull()
	{
		CurrentPage.getInstance(LoginPage.class).verifySuccessLogin();
	}
	
	@When("user opens payment pro application")
	public void user_opens_payment_pro_application()
	{
		CurrentPage.getInstance(LoginPage.class).openPaymentProApplication();
	}
	
	@When("user reads user listed from excel file verify login")
	public void user_reads_user_listed_from_excel_file_verify_login() throws Exception
	{
		CurrentPage.getInstance(LoginPage.class).readUsersFromExcelAndVerifyLogin();
	}
	
	@When("user clicks on back button of browser")
	public void user_clicks_on_back_button_of_browser() throws Exception
	{
		CurrentPage.getInstance(LoginPage.class).clickOnBackButtonOfBrowser();
	}
	
	@Then("verify login page components are visible")
    public void verify_login_page_components_are_visible() 
	{
        CurrentPage.getInstance(LoginPage.class).verifyLoginPageComponents();
    }
	
	@Then("verify that user is redirected to OTP verification page")
    public void verify_that_user_is_redirected_to_otp_verification_page() 
	{
        CurrentPage.getInstance(LoginPage.class).verifyOTPVerificationPage();
    }
	
	@Then("verify error message is displayed with text {string}")
    public void verify_error_message_is_displayed_with_text(String expectedErrorMessage)
	{
        CurrentPage.getInstance(LoginPage.class).verifyErrorMessage(expectedErrorMessage);
    }
	
	@Then("verify validation error is displayed for empty {string}")
    public void verify_validation_error_is_displayed_with_empty(String expectedValidationMessage)
	{
        CurrentPage.getInstance(LoginPage.class).verifyMessageForEmpty(expectedValidationMessage);
    }
	
	@When("user clicks on forgot password link")
    public void user_clicks_on_forgot_password_link()
	{
        CurrentPage.getInstance(LoginPage.class).clickForgotPasswordLink();
    }
	
	@Then("verify user is redirected to password reset page")
    public void verify_user_is_redirected_to_password_reset_page()
	{
        CurrentPage.getInstance(LoginPage.class).verifyPasswordResetPage();
    }
	
	@When("user navigate to login page")
	public void user_navigate_to_login_page()
	{
		CurrentPage.getInstance(LoginPage.class).clickOnLoginLink();
	}
}
