package appsHooks;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.Base;
import base.BrowserManager;
import config.Settings;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import path.Path;
import utility.PropertyUtil;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.service.ExtentService;

import java.awt.*;


public class ApplicationHooks extends Base
{	
	Scenario scenario;
	
	@After( order = 1 )
	public void quitBrowser( Scenario scenario ) throws IOException
	{
		scenario.log( String.valueOf("<B>TOTAL EXECUTED TESTCASES:= "+totalTestCases.get()+"</B>") );
	}
	
	@After( order = 2 )
	public void takeScreenShotOnFailure( Scenario scenario )
	{
		if ( scenario.isFailed() )
		{
	        String scenarioName = scenario.getName().replaceAll(" ", "_");
	       
	        if (threadLocalDriver.get() instanceof org.openqa.selenium.WebDriver)
	        {
	            TakesScreenshot takeScreenShot = (TakesScreenshot) threadLocalDriver.get();
	            byte[] src = takeScreenShot.getScreenshotAs(OutputType.BYTES);
	            scenario.attach(src, "image/png", scenarioName);
	        }
	    }
	}
	
	private static void update_report_more_systemInfo()
	{
		String javaVersion = System.getProperty("java.version");
		String systemUser = System.getProperty("user.name");
		String applicationUrl = Settings.application_Url;
		String appUserName = Settings.userId;
		
		int[] resolution = checkScreenResolution();
		String resolutionX = String.valueOf(resolution[0]);
		String resolutionY = String.valueOf(resolution[1]);
		String screen = resolutionX+" X "+resolutionY;
		
		ExtentReports extentReports = ExtentService.getInstance(); 
	    extentReports.setSystemInfo("Browser", Settings.browserName);
	    extentReports.setSystemInfo("Java Version", javaVersion);
	    extentReports.setSystemInfo("Application version", appVersion);
	    extentReports.setSystemInfo("App URL", applicationUrl);
	    extentReports.setSystemInfo("Processing Pro User", appUserName);
	    extentReports.setSystemInfo("QA", systemUser);
	    //extentReports.setSystemInfo("Build number", getBuild());
	    extentReports.setSystemInfo("Screen Resolution", screen);
	}
	
	@AfterAll
	public static void before_or_after_all()
	{
		ApplicationHooks.update_report_more_systemInfo();
	}
	
	@AfterAll
	public static void after_all()
	{
		ExtentReports extentReports = ExtentService.getInstance(); 
	    extentReports.setSystemInfo("Total TestCases Executed", String.valueOf(totalTests));
	}
	
	private static int[] checkScreenResolution()
	{
		int[] resolution = new int[2];
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    resolution[0] = width;
	    resolution[1] = height;
	    return resolution;
	}
	
}
