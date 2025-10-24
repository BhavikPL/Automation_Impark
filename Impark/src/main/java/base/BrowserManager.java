package base;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import path.Path;
import utility.PropertyUtil;

public class BrowserManager 
{
	//public static RemoteWebDriver openBrowser(String browserName, String clientName)
	public static RemoteWebDriver openBrowser(String browserName)
	{
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if(Settings.runMode.equalsIgnoreCase("true"))
            {
            	options.addArguments("headless");
            }
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("autofill.credit_card_enabled", false);
            chromePrefs.put("download.default_directory", Path.downloadPath);
            chromePrefs.put("safebrowsing.enabled", "true");
            options.setExperimentalOption("prefs", chromePrefs);
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			try { PropertyUtil.clearProperty();} catch (IOException e) {}
		}
		
		
		if (browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			if(Settings.runMode.equalsIgnoreCase("true"))
	        {
				options.setHeadless(true);
	        }
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.dir", Path.downloadPath);
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
		
		
		if (browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.edgedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			chromePrefs.put("download.default_directory", Path.downloadPath);
			chromePrefs.put("safebrowsing.enabled", "true");
			chromePrefs.put("browser.show_hub_apps_tower", false);
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			chromeOptions.addArguments("--remote-allow-origins=*");
			EdgeOptions op=new EdgeOptions().merge(chromeOptions);
			if(Settings.runMode.equalsIgnoreCase("true"))
	        {
				op.addArguments("headless");
	        }
			driver = new EdgeDriver(op);
			driver.manage().window().maximize();
		}
		return (RemoteWebDriver)driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
