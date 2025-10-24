package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class DriverUtilities extends Base
{
	public  void openApplication(String url )
	{
		threadLocalDriver.get().get(url);
	}
	
	public void navigateBackToBrowser()
	{
		threadLocalDriver.get().navigate().back();
	}
	
	public void navigateForwardToBrowser()
	{
		threadLocalDriver.get().navigate().forward();
	}
	
	public void deleteAllCookies()
	{
		threadLocalDriver.get().manage().deleteAllCookies();
	}
	
	public void typeIntoTextBox( WebElement textBox , String content )
	{
		textBox.sendKeys(content);
	}
	
	public void clearTextBox( WebElement textBox )
	{
		textBox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	}
	
	public String getPageSource()
	{
		return threadLocalDriver.get().getPageSource();
	}
	
	public void clearFieldUsingJS( WebElement element )
	{
		JavascriptExecutor js = (JavascriptExecutor) threadLocalDriver.get();
		//js.executeScript("arguments[0].value = '';", element);
		js.executeScript("arguments[0].setAttribute('value', '');", element);
	}
	
	public void clickOnElement( WebElement element )
	{
		element.click();
	}
	
	public void mouseClickOnElement( WebElement element )
	{
		Actions action = new Actions(threadLocalDriver.get());
		action.moveToElement(element).click().build().perform();
	}
	
	public boolean isElementDisplayed( WebElement element )
	{
		boolean flag = element.isDisplayed();
		return flag;
	}
	
	public boolean isElementClickable( WebElement element )
	{
		boolean flag = element.isEnabled();
		return flag;
	}
	
	public WebElement getWebElement( String xpath )
	{
		return threadLocalDriver.get().findElement(By.xpath(xpath));
	}
	
	public WebElement getWebElementByCSS( String cssPath )
	{
		return threadLocalDriver.get().findElement(By.cssSelector(cssPath));
	}
	
	public void keyPress( String key ) throws AWTException
	{
		Robot r = new Robot();
		if( key.equalsIgnoreCase("tab") )
		{
			r.keyPress(KeyEvent.VK_TAB);
		}
		if( key.equalsIgnoreCase("control") )
		{
			r.keyPress(KeyEvent.VK_CONTROL);
		}
		if( key.equalsIgnoreCase("C") )
		{
			r.keyPress(KeyEvent.VK_C);
		}
		if( key.equalsIgnoreCase("V") )
		{
			r.keyPress(KeyEvent.VK_V);
		}
		if( key.equalsIgnoreCase("A") )
		{
			r.keyPress(KeyEvent.VK_A);
		}
		if( key.equalsIgnoreCase("X") )
		{
			r.keyPress(KeyEvent.VK_X);
		}
		if( key.equalsIgnoreCase("delete") )
		{
			r.keyPress(KeyEvent.VK_DELETE);
		}
		if( key.equalsIgnoreCase("space bar") )
		{
			r.keyPress(KeyEvent.VK_SPACE);
		}
		if( key.equalsIgnoreCase("esc") )
		{
			r.keyPress(KeyEvent.VK_ESCAPE);
		}
		if( key.equalsIgnoreCase("enter") )
		{
			r.keyPress(KeyEvent.VK_ENTER);
		}
		if( key.equalsIgnoreCase("page down") )
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		if( key.equalsIgnoreCase("page up") )
		{
			r.keyPress(KeyEvent.VK_PAGE_UP);
		}
		if( key.equalsIgnoreCase("back space") )
		{
			r.keyPress(KeyEvent.VK_BACK_SPACE);
		}
		if( key.equalsIgnoreCase("right arrow") )
		{
			r.keyPress(KeyEvent.VK_RIGHT);
		}
		if( key.equalsIgnoreCase("left arrow") )
		{
			r.keyPress(KeyEvent.VK_LEFT);
		}
	}
	
	public void keyRelease( String key ) throws AWTException
	{
		Robot r = new Robot();
		if( key.equalsIgnoreCase("tab") )
		{
			r.keyRelease(KeyEvent.VK_TAB);
		}
		if( key.equalsIgnoreCase("control") )
		{
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		if( key.equalsIgnoreCase("C") )
		{
			r.keyRelease(KeyEvent.VK_C);
		}
		if( key.equalsIgnoreCase("V") )
		{
			r.keyRelease(KeyEvent.VK_V);
		}
		if( key.equalsIgnoreCase("A") )
		{
			r.keyRelease(KeyEvent.VK_A);
		}
		if( key.equalsIgnoreCase("X") )
		{
			r.keyRelease(KeyEvent.VK_X);
		}
		if( key.equalsIgnoreCase("delete") )
		{
			r.keyRelease(KeyEvent.VK_DELETE);
		}
		if( key.equalsIgnoreCase("space bar") )
		{
			r.keyRelease(KeyEvent.VK_SPACE);
		}
		if( key.equalsIgnoreCase("esc") )
		{
			r.keyRelease(KeyEvent.VK_ESCAPE);
		}
		if( key.equalsIgnoreCase("enter") )
		{
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		if( key.equalsIgnoreCase("page down") )
		{
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		if( key.equalsIgnoreCase("page up") )
		{
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		}
		if( key.equalsIgnoreCase("back space") )
		{
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		if( key.equalsIgnoreCase("right arrow") )
		{
			r.keyRelease(KeyEvent.VK_RIGHT);
		}
		if( key.equalsIgnoreCase("left arrow") )
		{
			r.keyRelease(KeyEvent.VK_LEFT);
		}
	}
	
	public void refreshBrowser()
	{
		threadLocalDriver.get().navigate().refresh();
	}
	
	public String getFirstSelectedOptionFromList( WebElement list )
	{
		Select select = new Select( list );
		return select.getFirstSelectedOption().getText().toString().trim();
	}
	
	public List<String> getListOptions( WebElement list )
	{
		List<String> listOptions = new ArrayList<String>();
		Select select = new Select( list );
		List<WebElement> listElements = select.getOptions();
		
		for( WebElement e : listElements )
		{
			listOptions.add(e.getText().trim());
		}
		return listOptions;
	}

	public void waitForElement( WebElement elementPath )
	{
		FluentWait fluentWait = new FluentWait(threadLocalDriver.get());
		fluentWait.withTimeout(Duration.ofMillis(60000));
		fluentWait.pollingEvery(Duration.ofMillis(1000));
		fluentWait.ignoring(Exception.class);
		
		Function<RemoteWebDriver, WebElement> function = new Function<RemoteWebDriver, WebElement>()
		{
			public WebElement apply(RemoteWebDriver d) 
			{
				//System.out.println("Checking for the element:---");
				WebElement element = elementPath;
				boolean enabled =element.isEnabled();
				if( (element != null) && ( enabled==true ) )
				{
					//System.out.println(elementPath+"----------->  "+"fouun");
				}
				return element;
			}
		};
		fluentWait.until(function);
	}
	
	/*public void waitForElement2(WebElement elementPath)
	{
		boolean visible = false;
		int time = 0;
		
		while( (!visible) && (time < 10000) )
		{
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			time = time + 1000;
			if( isElementDisplayed(elementPath) )
			{
				visible= true;
				break;
			}
		}
	}*/
	
	public void waitForElementToBeClickable(String path )
	{
		WebDriver driver = (WebDriver)threadLocalDriver.get();
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(60)); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	}
	
	public void waitForElementToBeClickable(WebElement elementpath )
	{
		WebDriver driver = (WebDriver)threadLocalDriver.get();
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(20)); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementpath));
		try {Thread.sleep(2000);}catch(InterruptedException e) {}
	}
	
	public void waitForElementToBeInteractable(WebElement elementpath )
	{
		 int timeCount=1;
	     while( timeCount <= 7 )
	     {
	    	try 
	    	{
	    		elementpath.click();
	    		break;
	    	}
	    	catch(ElementClickInterceptedException e) 
	    	{
	    		try {Thread.sleep(1000);}catch(InterruptedException e1){}
	    		timeCount++;
	    	}
	     }
	}
	
	public void waitForElementToBePresent(WebElement path )
	{
		WebDriver driver = (WebDriver)threadLocalDriver.get();
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(20)); 
		WebElement element = wait.until(ExpectedConditions.visibilityOf(path));
	}
	
	public void waitForElementDisappear(WebElement path )
	{
		WebDriver driver = (WebDriver)threadLocalDriver.get();
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(60)); 
		wait.until(ExpectedConditions.invisibilityOf(path));
	}
	
	public void waitForElementDisappear2(String path )
	{
		WebDriver driver = (WebDriver)threadLocalDriver.get();
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
	}
	
	public void waitForElementToBePresent2(String path )
	{
		WebDriver driver = (WebDriver)threadLocalDriver.get();
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(20)); 
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}
	
	//public void waitForPageLoadFully()
	//{
		//JavascriptExecutor js = (JavascriptExecutor) threadLocalDriver.get();
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//WebDriver driver = (WebDriver)threadLocalDriver.get();
		//WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(60)).until((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		//wait.until(js.executeScript("return document.readyState").equals("complete"));
		
		//new WebDriverWait(firefoxDriver, pageLoadTimeout).until(
			      //webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	//}
	
	/*public void waitForElementDisappear2(WebElement elementPath)
	{
		boolean visible = true;
		int time = 0;
		
		while( (visible) && (time < 10000) )
		{
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
			time = time + 1000;
			try 
			{
				if( isElementDisplayed(elementPath) )
				{
					
				}
			}
			catch(NoSuchElementException e)
			{
				visible= false;
				break;
			}
		}
	}*/
	
	public void fileUpload( String filePath ) throws AWTException
	{
		 StringSelection str = new StringSelection( filePath );
		 try {Thread.sleep(1500);}catch(InterruptedException e) {}
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 try {Thread.sleep(1);}catch(InterruptedException e) {}
		 System.out.println("copy path started");
		 keyPress("control");
		 keyPress("v");
		 try {Thread.sleep(500);}catch(InterruptedException e) {}
		 keyRelease("control");
		 keyRelease("v");
		 System.out.println("copy path completed");
		 
		 
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyPress("tab");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyRelease("tab");
		 System.out.println("tab1 press");
		 
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyPress("tab");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyRelease("tab");
		 System.out.println("tab2 press");
		 
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyPress("space bar");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyRelease("space bar");
		 System.out.println("space bar press");
	}
	
	public void fileUpload2( WebElement ele , String filePath ) throws AWTException
	{
		
		 //StringSelection str = new StringSelection( filePath );
		// try {Thread.sleep(1500);}catch(InterruptedException e) {}
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 ele.sendKeys(filePath);
		 try {Thread.sleep(1);}catch(InterruptedException e) {}
		 keyPress("control");
		 keyPress("v");
		 try {Thread.sleep(500);}catch(InterruptedException e) {}
		 keyRelease("control");
		 keyRelease("v");
		 
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyPress("tab");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyRelease("tab");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyPress("tab");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyRelease("tab");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyPress("space bar");
		 try{Thread.sleep(1);}catch(InterruptedException e){}
		 keyRelease("space bar");
	}
	
	public int getNumberOfElement( String xpath )
	{
		return threadLocalDriver.get().findElements(By.xpath(xpath)).size();
	}
	
	public List<WebElement> getAllWebElements( String xpath )
	{
		return threadLocalDriver.get().findElements(By.xpath(xpath));
	}
	
	public boolean isElementChecked( WebElement element )
	{
		return element.isSelected();
	}
	
	public String getAttribute( WebElement element , String att )
	{
		String value = element.getAttribute(att);
		return value;
	}
	
	public String getProperty( WebElement element , String att )
	{
		String value = element.getDomProperty(att);
		return value;
	}
	
	public void selectElementFromList( WebElement list , String text )
	{
		Select select = new Select( list );
		select.selectByVisibleText(text);
	}
	
	public void selectElementFromListByValue( WebElement list , String value )
	{
		Select select = new Select( list );
		select.selectByValue(value);
	}
	
	public void selectElementFromListIndex( WebElement list , int index )
	{
		Select select = new Select( list );
		select.selectByIndex(index);
	}
	
	public String getElementText(WebElement element)
	{
		return element.getText();
	}
	
	public Actions getActions()
	{
		Actions action = new Actions(threadLocalDriver.get());
		return action;
	}
	
	public void moveToElementBasedOnCordinates(Actions action, WebElement element)
	{
		Point location = element.getLocation();
        int targetX = location.getX();
        int targetY = location.getY();
        action.moveByOffset(targetX, targetY).build().perform();
	}
	
	public void moveToAnElementByOffsetAndClick( WebElement element , Actions action , int x, int y)
	{
		action.moveToElement(element, x, y).click().build().perform();
	}
	
	public String getElementCSSValue( WebElement element , String style )
	{
		return element.getCssValue(style);
	}
	
	public String getElementAttribute( WebElement element , String attribute )
	{
		return element.getAttribute(attribute);
	}
	
	public void moveCursorToAnElement(Actions act , WebElement e)
	{
		act.moveToElement(e).build().perform();
	}
	
	public void moveCursorToAnElementClickAndHold(Actions act , WebElement e)
	{
		act.moveToElement(e).clickAndHold().build().perform();
	}
	
	public void moveCursorToAnElementAndClick(Actions act , WebElement e)
	{
		Actions ac = act.moveToElement(e);
		try { Thread.sleep(1000);}catch(InterruptedException e1) {}
		ac.click().build().perform();
		try { Thread.sleep(1000);}catch(InterruptedException e1) {}
	}
	
	public void moveCursorToAnElementWithOffset(Actions act , WebElement e , int x , int y)
	{
		act.moveToElement(e,x,y).build().perform();
	}
	
	public int getXCoordinateOfAnElement(WebElement e)
	{
		return e.getLocation().getX();
	}
	
	public int getYCoordinateOfAnElement(WebElement e)
	{
		return e.getLocation().getY();
	}
	
	public void makeElementVisibleIntoScreen( WebElement element )
	{
		((JavascriptExecutor) threadLocalDriver.get()).executeScript("arguments[0].scrollIntoView();", element);
		try {Thread.sleep(500);}catch(InterruptedException e) {}
	}
	
	public void makeElementVisibleIntoScreenAtMiddle( WebElement element )
	{
		((JavascriptExecutor) threadLocalDriver.get()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})", element);
		try {Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public void scrollDownWebPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) threadLocalDriver.get();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollUpWebPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) threadLocalDriver.get();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollUpInsidePopup(WebElement element)
	{
		element.sendKeys(Keys.PAGE_UP);
	}
	
	public void scrollDownInsidePopup(WebElement element)
	{
		element.sendKeys(Keys.END);
	}
	
	public void dragAndDropElement( Actions action , WebElement source , WebElement desti )
	{
		action.clickAndHold(source).moveToElement(desti).release(desti).build().perform();
	}
	
	public String switchToNextNewTab()
	{
		Set<String> opnedWindows = threadLocalDriver.get().getWindowHandles();
		String currentWindow = threadLocalDriver.get().getWindowHandle();
		
		Iterator<String> iterator = opnedWindows.iterator();
		while( iterator.hasNext() )
		{
			String nextWindow = iterator.next();
			if( currentWindow!= nextWindow )
			{
				threadLocalDriver.get().switchTo().window(nextWindow);
			}
		}
		return currentWindow;
	}
	
	public void switchToMainWindow()
	{
		threadLocalDriver.get().switchTo().defaultContent();
	}
	
	public void switchToWindow(String Id)
	{
		threadLocalDriver.get().switchTo().window(Id);
	}
	
	public String getPageUrl()
	{
		return threadLocalDriver.get().getCurrentUrl();
	}
	
	public void clickByjavaScript( WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) threadLocalDriver.get();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);    
		element.click();
	}
	
	public void enterIntoFrame( WebElement frameName )
	{
		threadLocalDriver.get().switchTo().frame(frameName);
	}
	
	public void leaveFrame()
	{
		threadLocalDriver.get().switchTo().defaultContent();
	}
	
	public void pasteData(String data) throws AWTException
	{
		StringSelection str = new StringSelection( data );
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		keyPress("control");
		keyPress("v");
		 
		keyRelease("control");
		keyRelease("v");
	}
	
	public void setAttributeOfElement(WebElement e , String att , String val)
	{
		e.sendKeys(att,val);
	}
	
	public void setTextOfElement(WebElement e , String val)
	{
		e.sendKeys(val);
	}
	
	public void scrollLeft(WebElement element)
	{
		((JavascriptExecutor) threadLocalDriver.get()).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
		try {Thread.sleep(500);}catch(InterruptedException e) {}
	}
	
	public void setByJavaScriptIntoTextBox(WebElement element , String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)  threadLocalDriver.get();
		js.executeScript("arguments[0].value = arguments[1];", element, value);
	}
	
	public JavascriptExecutor getjavaScriptExecutor()
	{
		JavascriptExecutor js = (JavascriptExecutor)  threadLocalDriver.get();
		return js;
	}
}
