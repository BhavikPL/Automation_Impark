package pages;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.NoSuchElementException;

import com.mailosaur.MailosaurException;

import base.BasePage;
import config.Settings;
import utility.EmailOTPReader;
import utility.EncryptDecPassword;
import utility.ExcelReader;

public class LoginPage extends BasePage
{	
	@FindBy(how=How.XPATH, using="//input[@name='user_name']")
	public WebElement userNameTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy(how=How.XPATH, using="//button[contains(@type,'submit') and contains(text(),'Sign In')]")
	public WebElement loginButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(@href,'forgot-password')]")
	public WebElement forgotPasswordLink;
	
	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Login')]")
	public WebElement loginHeading;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'User name*')]")
	public WebElement userNameLabel;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Password*')]")
	public WebElement passwordLabel;
	
	@FindBy(how=How.XPATH, using="//*[@class='alert alert-danger']")
	public WebElement errorMessage;
	
	private void enterUserName()
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		driverUtilities.get().typeIntoTextBox(userNameTextBox, Settings.userId);
	}
	
	private void enterCXSupportUserName(String userName)
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		driverUtilities.get().typeIntoTextBox(userNameTextBox, userName);
	}
	
	private void enterCXSupportUserName()
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		driverUtilities.get().typeIntoTextBox(userNameTextBox, Settings.cxSupportUserId);
	}
	
	private void enterUserName(String userName)
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		driverUtilities.get().typeIntoTextBox(userNameTextBox, userName);
	}
	
	private void enterCXSupportPassword()
	{
		//System.out.println("Password is:="+EncryptDecPassword.decrypt(Settings.password));
		driverUtilities.get().clearTextBox(passwordTextBox);
		driverUtilities.get().typeIntoTextBox(passwordTextBox, EncryptDecPassword.decrypt(Settings.cxSupportPassword));
	}
	
	private void enterPassword()
	{
		//System.out.println("Password is:="+EncryptDecPassword.decrypt(Settings.password));
		driverUtilities.get().clearTextBox(passwordTextBox);
		driverUtilities.get().typeIntoTextBox(passwordTextBox, EncryptDecPassword.decrypt(Settings.password));
	}
	
	private void enterPassword(String passwortd)
	{
		driverUtilities.get().clearTextBox(passwordTextBox);
		driverUtilities.get().typeIntoTextBox(passwordTextBox, passwortd);
	}
	
	private void enterCXSupportPassword(String passwortd)
	{
		driverUtilities.get().clearTextBox(passwordTextBox);
		driverUtilities.get().typeIntoTextBox(passwordTextBox, passwortd);
	}
	
	private void clickOnLoginButton()
	{
		try {driverUtilities.get().clickOnElement(loginButton);}catch(NoSuchElementException e) {}
		try {Thread.sleep(200);}catch(InterruptedException e) {}
	}
	
	public void refreshBrowser()
	{
		driverUtilities.get().refreshBrowser();
		try { Thread.sleep(7000);}catch(InterruptedException e) {}
	}
	
	public void doLoginWithValidCredentials()
	{
		enterUserName();
		enterPassword();
		clickOnLoginButton();
	}
	
	public void loginCXSupportWithValidCredentials()
	{
		enterCXSupportUserName();
		enterCXSupportPassword();
		clickOnLoginButton();
	}
	
	public void doLoginWithInvalidUserName(String userName)
	{
		enterUserName(userName);
		enterPassword();
		clickOnLoginButton();
	}
	
	public void loginCXSupportWithInvalidUserName(String userName)
	{
		enterCXSupportUserName(userName);
		enterCXSupportPassword();
		clickOnLoginButton();
	}
	
	public void doLoginWithInvalidPassword(String password)
	{
		enterUserName();
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public void loginCXSupportWithInvalidPassword(String password)
	{
		enterCXSupportUserName();
		enterCXSupportPassword(password);
		clickOnLoginButton();
	}
	
	public void verifyLogoffSuccess()
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(userNameTextBox));
	}
	
	public void waitForSeconds(String time)
	{
		try{ Thread.sleep( 1000*Integer.parseInt(time) );}catch( InterruptedException e ){}
	}
	
	public void waitForPostPopulate()
	{
		driverUtilities.get().waitForElement(driverUtilities.get().getWebElement("//*[contains(@class,'PostTitle') and contains(@class,'heading_draggable')]"));
	}
	
	public void waitForLogoffPopulate()
	{
		driverUtilities.get().waitForElement(driverUtilities.get().getWebElement("//div[contains(@class,'UserIcon')]"));
	}
	
	public void enterValueIntoUserName(String userName)
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		try{driverUtilities.get().typeIntoTextBox(userNameTextBox, userName);}catch(IllegalArgumentException e) {}
	}
	
	public void enterValueIntoPassword(String password)
	{
		driverUtilities.get().clearTextBox(passwordTextBox);
		try{driverUtilities.get().typeIntoTextBox(passwordTextBox, password);}catch(IllegalArgumentException e) {}
	}
	
	public void userClicksOnLoginButton()
	{
		clickOnLoginButton();
	}
	
	public void enterOtp() throws IOException, MailosaurException, AWTException
	{
		//String otp = EmailOTPReader.getOtp();
		String otp = "527175";
		//System.out.println("otp is:="+otp);
		try {driverUtilities.get().waitForElementToBePresent2("//div[contains(@class,'otp-login-sec')]//input[1]");}catch(TimeoutException e) {}
		driverUtilities.get().clickOnElement(driverUtilities.get().getWebElement("//div[contains(@class,'otp-login-sec')]//input[1]"));
		driverUtilities.get().pasteData(otp);
		try {Thread.sleep(5000);}catch(InterruptedException e) {}
	}
	
	public void verifySuccessLogin()
	{
		try {driverUtilities.get().waitForElementToBePresent2("//*[contains(text(),'Dashboard')]");}catch(TimeoutException e) {}
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'Dashboard')]")));
	}
	
	public void openPaymentProApplication()
	{
		driverUtilities.get().openApplication(Settings.paymentProUrl);
	}
	
	public void readUsersFromExcelAndVerifyLogin() throws Exception
	{
		ExcelReader obj = new ExcelReader();
		List<Map<String, Object>> excelData = obj.getData(path.Path.usersFile, 0);
		
		for(int i=0;i<excelData.size();i++)
		{
			String userName = excelData.get(i).get("Username/Email").toString().trim();
			String password = excelData.get(i).get("Password").toString().trim();
			try {Thread.sleep(500);}catch(InterruptedException e) {}
			enterValueIntoUserName(userName);
			enterValueIntoPassword(password);
			userClicksOnLoginButton();
			try {driverUtilities.get().waitForElementToBePresent2("//h3[contains(text(),'OTP Verification')]");}catch(TimeoutException e) {}
			Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h3[contains(text(),'OTP Verification')]")));
			driverUtilities.get().navigateBackToBrowser();
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			System.out.println(userName+"--->"+password+" Success login");
		}
	}
	
	public void verifyLoginPageComponents()
	{
		Assert.assertTrue("Login heading not displayed", driverUtilities.get().isElementDisplayed(loginHeading));
		Assert.assertTrue("Username label not displayed", driverUtilities.get().isElementDisplayed(userNameLabel));
		Assert.assertTrue("Password label not displayed", driverUtilities.get().isElementDisplayed(passwordLabel));
		Assert.assertTrue("Forgot password link not displayed", driverUtilities.get().isElementDisplayed(forgotPasswordLink));
		Assert.assertTrue("Sign In button not displayed", driverUtilities.get().isElementDisplayed(loginButton));
		Assert.assertTrue("Username textbox not displayed", driverUtilities.get().isElementDisplayed(userNameTextBox));
		Assert.assertTrue("Password textbox not displayed", driverUtilities.get().isElementDisplayed(passwordTextBox));
	}
	
	public void clickForgotPasswordLink()
	{
		driverUtilities.get().clickOnElement(forgotPasswordLink);
	}
	
	public void verifyErrorMessage(String expectedErrorMessage)
	{
	    try{driverUtilities.get().waitForElementToBePresent2("//*[@class='alert alert-danger']");}catch(TimeoutException e) {}
		String actualErrorMessage = driverUtilities.get().getElementText(errorMessage);
		System.out.println(actualErrorMessage);
		Assert.assertTrue("Error message does not match. Expected: " + expectedErrorMessage + ", Actual: " + actualErrorMessage, 
							 actualErrorMessage.contains(expectedErrorMessage));
	}
	
	public void verifyValidationError(String expectedValidationMessage)
	{
		verifyErrorMessage(expectedValidationMessage);
	}
	
	public void verifyMessageForEmpty(String message)
	{
		Assert.assertTrue(driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//*[contains(text(),'"+message+"')]")));
	}
	
	public void verifyOTPVerificationPage()
	{
		try {
			driverUtilities.get().waitForElementToBePresent2("//h3[contains(text(),'OTP Verification')]");
			Assert.assertTrue("OTP Verification page not displayed", 
							 driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h3[contains(text(),'OTP Verification')]")));
		} catch (TimeoutException e) {
			Assert.fail("OTP Verification page not displayed");
		}
	}
	
	public void verifyPasswordResetPage()
	{
		try {
			driverUtilities.get().waitForElementToBePresent2("//h1[contains(text(),'Forgot Password')] | //h2[contains(text(),'Forgot Password')] | //h3[contains(text(),'Forgot Password')]");
			Assert.assertTrue("Password reset page not displayed", 
							 driverUtilities.get().isElementDisplayed(driverUtilities.get().getWebElement("//h1[contains(text(),'Forgot Password')] | //h2[contains(text(),'Forgot Password')] | //h3[contains(text(),'Forgot Password')]")));
		} catch (TimeoutException e) {
			Assert.fail("Password reset page not displayed");
		}
	}
	
	public void navigateToLoginPage()
	{
		// This method assumes the application is already open and we're on the login page
		// If navigation is needed, it can be implemented here
		driverUtilities.get().waitForElement(loginHeading);
	}
	
	public void doLoginWithEmptyUsername()
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		enterPassword();
		clickOnLoginButton();
	}
	
	public void doLoginWithEmptyPassword()
	{
		enterUserName();
		driverUtilities.get().clearTextBox(passwordTextBox);
		clickOnLoginButton();
	}
	
	public void doLoginWithEmptyFields()
	{
		driverUtilities.get().clearTextBox(userNameTextBox);
		driverUtilities.get().clearTextBox(passwordTextBox);
		clickOnLoginButton();
	}
	
	public void clickOnBackButtonOfBrowser()
	{
		driverUtilities.get().navigateBackToBrowser();
	}
}
