package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base 
{
	public static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();
	public static ThreadLocal<DriverUtilities> driverUtilities = new ThreadLocal<>();
	public static ThreadLocal<Integer> totalTestCases = ThreadLocal.withInitial(() -> 0);
	public static int totalTests=0;
	public static String appVersion="";
	
	public static <TPage extends BasePage> TPage getInstance(Class<TPage> page)
	{
		Object object = PageFactory.initElements(threadLocalDriver.get(), page);
		return page.cast(object);
	}
}
