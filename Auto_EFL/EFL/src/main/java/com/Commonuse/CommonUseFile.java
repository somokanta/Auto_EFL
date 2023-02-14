package com.Commonuse;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

import com.EFL.testbase.IQuery;
import com.EFL.testbase.Query;
import com.EFL.testbase.TestBase;

/**
 * --------------------- Functions list --------------------------
 * 1. select value from DD by using selectByIndex.
 * 2. selectByValue.
 * 3. select value from DD by using selectByVisibleText.
 * 4. method for send keys.
 * 5. switchToFrameByName "this use for switching frame using ByName.
 * 6. switchToFrameById "this use for switching frame using ById.
 * 7. switchToFrameByIndex "this use for switching frame using ByIndex.
 * 8. Element is editable or not.
 * 9. mouse over.
 * 10. verify Element Selected or not.
 * 11. Waiting for particular element.
 * 12. Alert Box present or not.
 * 13. Is Element Present as a single locator.
 * 14. Click Action.
 * 15. CheckBoxHandler.
 * 16. Send value in search box and select values from list.
 * 17. Send value in search box and click values from list using mouseAction.
 * 18. Get Alert and Get Alert box Message.
 * 19. isAlertPresent.
 * 20. AlertAcceptIfPresent.
 * 21. Pop up window handle.
 * 22.Click and skip.
 * 23.Clear function for edit. 
 * 24.verify single locator.
 * 25.MenuPageClick for 3 level.
 * 26.MenuPageMouseOver for 3 level.
 * 27.moveToElement function.
 * 28.Upload method for upload any kinds of file using robot class.
 * 29.Method for Quantity check and verified.
 * 30.logout method for logout the application.
 * 31.Method for click using web element.
 * 32.selectByVisibleText method for drop down using web element.
 * 33.Method for waitFixedTime.
 * 34.Method for ScrollDown.
 * 35.highLighter Method for highLight the element.
 * 36.ClickAndVerify for Click And Verify.
 * 
 */


public class CommonUseFile extends TestBase {

	static Logger logger = Logger.getLogger("");
	public static final Logger log = Logger.getLogger(CommonUseFile.class.getName());
	private IQuery stale;
	CommonLocator cl;
	private boolean acceptNextAlert = true;
	
	public CommonUseFile(WebDriver driver) throws IOException {
		
		TestBase.driver = driver;
		stale = new Query(driver);
		cl = new CommonLocator();
		stale = new Query(driver);
	}

	/** select value from DD by using selectByIndex
	  * 
	  * @param locator
	 *            ---- Element locator
	 * @param index
	 *            -- Drop down value index
	  */
	
	public static boolean selectByIndex(By locator, int index, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByIndex(index);
			System.out.println(index);
			logger.info("succ:> index selected" + locator);
			return true;
		} catch (AssertionError e) {
			System.err.println(e);
			logger.error("err:> index notfound"+ locator);
			Assert.fail("Err:>index not found" + locator);
			flag = true;
			return false;
		}
						}	
	/**
	 * select value 
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @param value
	 *            -- Drop down value
	 */
	public static boolean selectByValue(By locator, String value, String locatorName)
			throws Throwable {
		//boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByValue(value);
			System.out.println(value);
			logger.info("succ:> index selected" + locator);
			return true;
		} catch (AssertionError e) {
			//flag = true;
			System.err.println(e);
			logger.error("err:> Value selected"+ locator);
			Assert.fail("Err:>Value selected" + locator);
			return false;
								}
	}
	/**
	 * select value from DD by using selectByVisibleText
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @param visibletext
	 *            --Visible text of Drop down value
	  * 
	 */
	
	/*public  boolean selectByVisibleText1(WebElement locator, String visibletext,String locatorName) {
		//boolean flag = false;
		try {
			//Select act=new Select(stale.findElement(locator));
			//stale.findElement(locator);
			WebElement wb=driver.findElement(locator);
			//Select s = new Select(stale.findElement(locator));
			act.selectByVisibleText(visibletext);
			System.out.println("---------------------------------"+visibletext);
			logger.info("sucess:>Sucessfully Text visible"+ locator);
			return true;
		} catch (AssertionError e) {
			//flag = true;
			System.err.println(e);
			logger.error("error:> Text not visible "+ locator);
			Assert.fail("Err:>Text not visible" + locator);
			return false;
							}
				}*/
	public void selectByVisibleText(Object locator, String text, String locatorName) {
		System.out.println("Executing Select on: " + locatorName);
	//	log.info("Executing Select on: " + locatorName);
		if (!text.equals("")) {
			try {
				boolean isSelected = false;
				Select s = new Select(stale.findElement(locator));

				try {
					Thread.sleep(200);
					s.selectByVisibleText(text);
					Thread.sleep(1000);
					if (this.OnlyVerifyisElementPresentSingleLocator(cl.pageCrashImage)) {
						System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
						logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
						Assert.fail("ERROR  :> Page crashed on the click of " + locatorName);
					
				}else if (this.OnlyVerifyisElementPresentSingleLocator(cl.ServerError)) {
					System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
					logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
					Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
				}else {
					logger.info("SUCCESS :> Dropdown Selected :: '" + text + "' from selectbox :: '" + locatorName+"'");
					log.info("SUCCESS :> Dropdown Selected :: " + text + " from selectbox :: " + locatorName+"'");
				}
					
					isSelected = true;
				} catch (Exception e) {
					log.error("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox : '" + locatorName+"'");
					logger.error("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox : '" + locatorName+"'");
					isSelected = false;
				}
				if (!isSelected) {
					try {
						s.selectByValue(text);
						
						Thread.sleep(1000);
						if (this.OnlyVerifyisElementPresentSingleLocator(cl.pageCrashImage)) {
							System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
							logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
							Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
						
					}else if (this.OnlyVerifyisElementPresentSingleLocator(cl.ServerError)) {
						System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
						logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
						Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
					}else {
					//	log.info("SUCCESS :> Selected :: " + text);
					//	this.logInfo("SUCCESS :> Selected :: " + text );
					}						
						
						isSelected = true;
					} catch (Exception e) {
					//	log.error("ERROR   :> Not able to select :: " + text);
					//	this.logError("ERROR   :> Not able to select :: " + text);
						isSelected = false;
					}
				}
				if (!isSelected) {
					try {
					//	s.selectByIndex(1);
					//	log.error("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox : '" + locatorName+"'");
					//	this.logError("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox : '" + locatorName+"'");
						
					} catch (Exception e) {
					}
				}

			} catch (Exception e) {
			//	System.out.println("Not found: uuuuuuu " + locatorName);
				log.warn("SKIPED  :> Dropdown Locator Not found : " + locatorName);
				logger.warn("SKIPED  :> Dropdown Locator Not found : " + locatorName);
		//		throw new SkipException("Not Found Locator : " + locatorName);
			}
		} else {
			log.warn("Blank : " + locatorName);
			logger.warn("Blank : " + locatorName);
		}
	}

	/** method for sendkey
	 * 
	 */
	
	/*public void Sendkeys1(Object locator,String data) {
		try {
			//WebElement sel = driver.findElement(By.xpath(""));
			stale.findElement(locator).sendKeys(data);
			//sel.sendKeys(data);
			System.out.println(data);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	//------------------------------------------------ Send value ----------------------------------------------------- >
	
	
		public void SendKeys(Object locator, String data, String locatorName) {
			System.out.println("Executing input on: " + locatorName);
		//	log.info("Executing input on: " + locatorName);
			//this.waitFixedTime(1);
			this.waitForElement(locator);
			try {
				//this.waitFixedTime(4);
				//Thread.sleep(300);
				stale.findElement(locator).clear();
				if(data.equalsIgnoreCase("false")) {
					stale.findElement(locator).sendKeys("");
				}else {
					//this.waitFixedTime(4);
					stale.findElement(locator).sendKeys(data);
				}
				//this.waitFixedTime(1);
				if(this.AlertBoxPresentORNot()==true) {
			  		String alertmessage = this.closeAlertAndGetItsText();
					System.err.println("WARNING   :> Alert Message : '" + alertmessage+"' on this field : "+locatorName);
					log.warn("WARNING   :> Alert Message : '" + alertmessage+"' on this field : "+locatorName);
					logger.warn("WARNING   :> Alert Message : '" + alertmessage+"' on this field : "+locatorName);
					if(this.AlertBoxPresentORNot()==true) {
						while(20>0) {
							if(this.AlertBoxPresentORNot()==false) {
								break;
							}
						else {
							this.AlertAcceptIfPresent();
						}
					}
					
				}else {
					
				}
			}	
				System.err.println("Input data: '" + data + "' to field: " + locatorName);
				log.info("SUCCESS :> Input data: '" + data + "' to field: " + locatorName);
				logger.info("SUCCESS :> Input data: '" + data + "' to field: " + locatorName);
			} catch (Exception e) {
			//	System.out.println("Element not found : " + locatorName);
				log.warn("SKIPED  :> Element not found : " + locatorName);
				logger.warn("SKIPED  :> Element not found : " + locatorName);
			//	throw new SkipException("Not Found Locator : " + locatorName);
			}
		}*/
	
	  //---------------------------------> Send value ------------------------------>
	  public void SendKeys(WebElement locator,String data,String locatorName){
		  System.out.println("\nExecuting input on: "+locatorName);
		  System.out.println("\nExecuting input on: "+locator);
		  this.highLighterMethod(locator);
		 // log.info("Executing input on: "+locatorName);
		 // this.waitForElement(locator);
		  //this.waitFixedTime(1);
		   Reporter.log(">>>>>>>>>Send value "+data);
		  	 try{
		  		locator.clear();
		  		if(data.equalsIgnoreCase("false")) {
					locator.sendKeys("");
					}else if(data.equals("")) {
					locator.sendKeys("");
					}else {
					locator.sendKeys(data);
				}
		  		System.err.println("Input data: '" + data + "' to field: " + locatorName);
				log.info("SUCCESS :> Input data: '" + data + "' to field: " + locatorName);
				logger.info("SUCCESS :> Input data: '" + data + "' to field: " + locatorName);
		  	 }catch(Exception e){
		  		log.warn("SKIPED  :> Element not found : " + locatorName);
				logger.warn("SKIPED  :> Element not found : " + locatorName);
		  	  //throw new SkipException("Not Found Locator : "+locatorName);
		  	 }
	  }
	
	
		/** switchToFrameByName "this use for switching frame using ByName"
	 * @param 
	 * @throws		
	 */
		public static void switchToFrameByName(String nameValue)throws Throwable
		{   boolean flag=false;
			try
			{
				driver.switchTo().frame(nameValue);
				System.out.println(nameValue);
				logger.info("success: switchframe successfully"+ nameValue);
				flag=true;
			}
			catch(AssertionError e)
			{
			System.err.println(e);
			logger.error("error: Frame not switch"+ nameValue);
			Assert.fail("Error: Unable to switch frame"+nameValue);
			}
			
		}
	/** switchToFrameById "this use for switching frame using ById"
	 * 
	 */
	public static void switchToFrameById(String IdValue) throws Throwable
	{
		boolean Flag=false;
		try
		{
			driver.switchTo().frame(IdValue);
			System.out.println(IdValue);
			logger.info("Success:>>Frame selected by id" +IdValue);
			Flag=true;
		}
		catch(AssertionError e)
		{
			System.err.println("error: >>Frame not selected by id" +IdValue);
			logger.error("error:>> Frame not selected by id"+IdValue);
			Assert.fail("Frame not switch by Id"+IdValue);
		}
	}
	
	/** switchToFrameByIndex "this use for switching frame using ByIndex"
	 * 
	 */
	public static void switchToFrameByIndex (int index) throws Throwable
	{
		boolean Flag=false;
		try
		{
			driver.switchTo().frame(index);
			System.out.println(index);
			logger.info("Success:>>Frame switch successfully by selecting index" +index);
			Flag=true;
		}
		catch (AssertionError e)
		{
			System.err.println(e);
			logger.error("error: Frame not switched by selecting index" +index);
			Assert.fail("Err:Frame not switched by selecting index" +index);
		}
	}

	/**
	 * Element is editable or not
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @return True if the element is enabled, false otherwise.
	 **/
	public static Boolean isEnabled(By locator, String locatorName) throws Throwable {
		Boolean value = false;		
		try {
			if (driver.findElement(locator).isEnabled()) {
				System.out.println(locator);
				logger.info("Success:>> Locator  is enabled"+locator);
				value = true;
			}
			return value;
		} catch (NoSuchElementException e) {
			System.err.println(e);
			logger.error("error:>> locator visible status not is not enabled"+locator);
			Assert.fail("Err: >>locator visible status not is not enabled"+locator);
			return value;
		}
	}
	
	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * 
	 * @param locator
	 *            element to move to.
	 * @return A self reference.
	 * 
	 */
	public static void mouseover(By locator, String locatorName)
			throws Throwable {
		boolean Flag = false;
		try {
			WebElement mo = driver.findElement(locator);
			new Actions(driver).moveToElement(mo).build().perform();
			System.out.println(locatorName);
			logger.info("Succ:>> MouseOver action is Done on"+locatorName);
		} catch (NoSuchElementException e) {
			System.err.println("error: >> MouseOver is not perform on"+locatorName);
			logger.error("Err:Failed to Mouseover on"+locatorName);
			Assert.fail("Fail:Failed to Mouseover on"+locatorName);
			Flag = true;
		} 
		}

//	/**
//	 * SWITCH TO WINDOW BY USING TITLE
//	 * 
//	 * @param windowTitle
//	 *            --Title of the child widow
//	 * @param count
//	 *            --Number of the window
//	 */
//	 public Boolean switchWindowByTitle (String windowTitle,int count)
//			 throws Throwable
//	 {
//		 boolean flag=false;
//		 try {
//			 Set<String> windowList=driver.getWindowHandles();
//			int windowCount = windowList.size();
//			//set timeout
//				Calendar calendar = new GregorianCalendar();
//				int second = calendar.get(Calendar.SECOND); // /to get current time
//				int timeout = second + 40; 
//			while (windowCount != count && second < timeout) {
//				Thread.sleep(500);
//				windowList=driver.getWindowHandles();
//				windowCount=windowList.size();
//			}
//				String[]array=windowList.toArray(new String[0]);
//						
//				for(int i=0;i< windowCount;i++) {
//					driver.switchTo().window(array[i]);
//					if (driver.getTitle().contains(windowTitle))
//						return true;
//								}
//				return false;
//		 			}
//		 		
//		 				catch (Exception e) {
//		 					flag = true;
//		 					return false;
//		 				}
//	 	}
	/** verify Element Selected or not 
	 *  
	 * @param locator
	 * @return
	 */
/*	public boolean isElement_selected(Object locator) {
		System.out.println("Executing isElementselected");
		log.debug("Executing isElementselected");
		try {
			if (stale.findElement(locator).isSelected())
				return true;
         // System.err.println();
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}*/
	
	public boolean isElement_selected(Object locator) {
		System.out.println("Executing isElementselected");
		log.debug("Executing isElementselected");
		try {
			if (stale.findElement(locator).isSelected()) {
				return true;}
         // System.err.println();
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}
	// -----------------------> element is selected or not	// ------------------------------>
	public void isElementSelected(Object locator, String ElementName, String Page) {
		System.out.println("Executing Select on: " + ElementName + " On Page:" + Page);
	//	log.info("Executing Select on: " + ElementName);
		try {
			boolean val = stale.findElement(locator).isSelected();
			if (val == true) {
				System.out.println(ElementName + ": is selected.");
				log.info(ElementName + ": is selected.");
			} else {
				System.out.println(ElementName + ": is not selected.");
				log.info(ElementName + ": is not selected.");
			}
		} catch (Exception e) {
			System.out.println("Not found: " + ElementName);
			log.error("Not found: " + ElementName);
			throw new SkipException("Element is not found : " + ElementName);
		}
	}
	/**  Waiting for particular element
	 * 
	 * @param locator
	 */
	public void waitForElement(Object locator) {
		System.out.println("Executing waitForElement " + locator);
//		log.info("Executing waitForElement " + locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int attempts = 1;
		while (attempts < 5) {
			try {
				//wait.until(ExpectedConditions.visibilityOf(stale.findElement(locator)));
				break;
			} catch (StaleElementReferenceException ex) {
				System.out.println("Caught StaleElementReferenceException in waitForElement Method for '"+attempts+"' time.");
				attempts++;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
}
		
		
		
		
		
		
	}
	public void waitForElementw(WebElement locator) {
		System.out.println("Executing waitForElement " + locator);
//		log.info("Executing waitForElement " + locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		int attempts = 1;
		while (attempts < 5) {
			try {
				wait.until(ExpectedConditions.visibilityOf(stale.findElement(locator)));
				break;
			} catch (StaleElementReferenceException ex) {
				System.out.println("Caught StaleElementReferenceException in waitForElement Method for '"+attempts+"' time.");
				attempts++;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}}}
	
	/** Alert Box present or not
	 * 
	 * @return
	 */
		
		public boolean AlertBoxPresentORNot() {
			System.out.println("Executing Get Alert Box");
		//	log.info("Executing GetAlertBox");
			try {
				driver.switchTo().alert();
				return true;
			} catch (Exception e) {
				System.err.println("Alert box not present");
				return false;
			}
		}
	/**  Is Element Present as a single locator
	 * 
	 * @param locator
	 * @return
	 */
		public boolean isElementPresentSingleLocator(Object locator) {
			try {
				stale.findElement(locator);
				log.info("\nPASS    :> Element Present : '" + locator+"'");
				logger.info("\nPASS    :> Element Present : '" + locator+"'");
				return true;
			} catch (NoSuchElementException e) {
				log.error("\nERROR   :> Element not found : '" + locator+"'");
				logger.error("\nERROR   :> Element not found : '" + locator+"'");
				return false;
			}
		}	
		
	/**  Click Action
	 * 	
	 * @param locator
	 * @param locatorName
	 */
	public void click(Object locator, String locatorName) {
		System.out.println("Executing click on: " + locatorName);
	//	log.info("Executing click on: " + locatorName);
		try {
			this.waitForElement(locator);
			stale.findElement(locator).click();
			log.info("Able to click on " + locatorName);
		if(this.AlertBoxPresentORNot()==false) {	 	
			if (this.isElementPresentSingleLocator(cl.pageCrashImage)) {
					System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
					logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
					Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
				
			}else if (this.isElementPresentSingleLocator(cl.ServerError)) {
				System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
				logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
				Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
			}else {
				System.out.println("PASS    :> Successfully clicked : " + locatorName );
			}
		}	else {
		  		System.out.println("Found Alert Box on the click of '"+locatorName+"'");
		  	}
		} catch (Exception e) {
			System.err.println("SKIPED  :> Element not found :> " + locatorName);
			log.warn("SKIPED  :> Element not found :> " + locatorName);
			logger.warn("SKIPED  :> Element not found :> " + locatorName);
		//	throw new SkipException("Not Found Element : " + locatorName);
		}
	}
	
	/**  CheckBoxHandler  
	 * 
	 * @param action
	 * @param CheckBoxLocator
	 * @param locatorName
	 * @throws InterruptedException
	 */
/*public void CheckBoxHandle(String action,Object CheckBoxLocator, String locatorName) throws InterruptedException
	
	{
		System.out.println("execute:" + CheckBoxLocator);
		if(action.equalsIgnoreCase("yes")&& !this.isElementSelected(Object locator, String ElementName, String Page))
		{
			this.click(CheckBoxLocator, locatorName);
			System.out.println("click:" + CheckBoxLocator);
		}
		else if(action.equalsIgnoreCase("yes")&& this.isElementSelected(CheckBoxLocator)==false)
		{
			System.err.println("allready selected:" + CheckBoxLocator);
		}
		else if(action.equalsIgnoreCase("no")&& this.isElement_selected(CheckBoxLocator))
		{
			this.click(CheckBoxLocator, locatorName);
		}
		else
		{
			System.err.println("user not want to select:" + CheckBoxLocator);
		}
	
	
	}*/
/*	public void CheckBoxHandle(String action,Object CheckBoxLocator, String locatorName) throws InterruptedException
	
	{
		System.out.println("execute:" + CheckBoxLocator);
		if(action.equalsIgnoreCase("yes")&& !this.isElement_selected(CheckBoxLocator))
		{
			this.click(CheckBoxLocator, locatorName);
			System.out.println("click:" + CheckBoxLocator);
		}
		else if(action.equalsIgnoreCase("yes")&& this.isElement_selected(CheckBoxLocator)==false)
		{
			System.err.println("allready selected:" + CheckBoxLocator);
		}
		else if(action.equalsIgnoreCase("no")&& this.isElement_selected(CheckBoxLocator))
		{
			this.click(CheckBoxLocator, locatorName);
		}
		else
		{
			System.err.println("user not want to select:" + CheckBoxLocator);
		}
	
	
	}*/
// ---------------------------------------> Send value ----------------------------->

public void SendKeysSearchBoxDropdownValue(Object SearchTextBoxlocator,String data,
		String locatorName, int waitTime) {
	System.out.println("Executing input on: " + locatorName);
//	log.info("Executing input on: " + locatorName);
	this.waitForElement(SearchTextBoxlocator);
	try {
		this.waitForElement(SearchTextBoxlocator);
		stale.findElement(SearchTextBoxlocator).click();
		this.waitForElement(SearchTextBoxlocator);
		stale.findElement(SearchTextBoxlocator).clear();
		this.waitForElement(SearchTextBoxlocator);
		
		//this.waitFixedTime(2);
		//this.waitForElementImplicit(2);
		//commonMethods.waitForInvisibilityOfPreloader();
		
		/*stale.findElement(labelLocatorName).click();
		this.waitForElement(SearchTextBoxlocator);*/
		stale.findElement(SearchTextBoxlocator).click();
		this.waitForElement(SearchTextBoxlocator);
		stale.findElement(SearchTextBoxlocator).sendKeys(data);
		this.waitForElement(SearchTextBoxlocator);
		stale.findElement(SearchTextBoxlocator).sendKeys("\uE015");
		//this.waitFixedTime(1);
		stale.findElement(SearchTextBoxlocator).sendKeys(Keys.ENTER);
		//this.waitFixedTime(waitTime);
	if(this.AlertBoxPresentORNot()==false) {	
		if (this.OnlyVerifyisElementPresentSingleLocator(cl.pageCrashImage)) {
			System.err.println("ERROR   :> Page crashed After Selection : '" + data+"'");
			logger.fatal("ERROR   :> Page crashed After Selection : '" + data+"'");
			Assert.fail("ERROR   :> Page crashed After Selection : '" + data+"'");
		
	}else if (this.OnlyVerifyisElementPresentSingleLocator(cl.ServerError)) {
		System.err.println("ERROR   :> Page crashed After Selection : '" + data+"'");
		logger.fatal("ERROR   :> Page crashed After Selection : '" + data+"'");
		Assert.fail("ERROR   :> Page crashed After Selection : '" + data+"'");
	}
	}
	else{
  		if (this.closeAlertAndGetItsText().equalsIgnoreCase("Record Not Found")) {
		System.err.println("ERROR   :> Record Not Found : '" + data+"'");
		log.error("ERROR   :> Record Not Found : '" + data+"'");
		logger.error("ERROR   :> Record Not Found : '" + data+"'");
	//	Assert.fail("ERROR   :> Record Not Found : '" + data+"'");
  		}
	}
		System.out.println("Able to input data: " + data + " to field: " + locatorName);
		log.info("SUCCESS :> Able to input data : '" + data + "' to field: " + locatorName);
		logger.error("SUCCESS :> Able to input data : '" + data + "' to field: " + locatorName);
	
		
	} catch (Exception e) {
		log.warn("SKIPED  :> Element not found : " + locatorName);
		logger.error("SKIPED  :> Element not found : " + locatorName);
//		throw new SkipException("Not Found Locator : " + locatorName);
	}
}
	 
	/** Send value in Searchbox and select values from list
	 * 
	 * @param SearchTextBoxlocator
	 * @param labelNameLocator
	 * @param data
	 * @param locatorName
	 * @param waitTime
	 */
public void SendKeysSearchBoxDropdownValue1(WebElement SearchTextBoxlocator, WebElement labelNameLocator, String data,String locatorName, int waitTime){
	  System.out.println("Executing input on: "+locatorName);
	//  log.info("Executing input on: "+locatorName);
	  this.waitForElement(SearchTextBoxlocator);
	  //this.waitFixedTime(1);
	  ((WebElement) SearchTextBoxlocator).click();
	  	 try{
	  		SearchTextBoxlocator.click();
	  		SearchTextBoxlocator.clear();
	  		//labelNameLocator.click();
	  		//this.waitFixedTime(waitTime);
	  		this.waitForElement(SearchTextBoxlocator);
	  		SearchTextBoxlocator.click();
	  		SearchTextBoxlocator.sendKeys(data);
	  		this.waitFixedTime(2);
	  		SearchTextBoxlocator.sendKeys("\uE015");
	  		//SearchTextBoxlocator.sendKeys("\uE015");
	  		this.waitFixedTime(2);
	  		SearchTextBoxlocator.sendKeys(Keys.ENTER);
	  		//this.waitFixedTime(waitTime);
	  		if (this.isElementPresentSingleLocator(cl.pageCrashImage)) {
				System.err.println("ERROR   :> Page crashed After Selection : '" + data+"'");
				logger.fatal("ERROR   :> Page crashed After Selection : '" + data+"'");
				Assert.fail("ERROR   :> Page crashed After Selection : '" + data+"'");
		}
	  		else if (this.isElementPresentSingleLocator(cl.ServerError)) {
			System.err.println("ERROR   :> Page crashed After Selection : '" + data+"'");
			logger.fatal("ERROR   :> Page crashed After Selection : '" + data+"'");
			Assert.fail("ERROR   :> Page crashed After Selection : '" + data+"'");
		}
	  		else if(this.AlertBoxPresentORNot()==true) {
	  		if (this.closeAlertAndGetItsText().equalsIgnoreCase("Record Not Found")) {
			System.err.println("ERROR   :> Record Not Found : '" + data+"'");
			log.error("ERROR   :> Record Not Found : '" + data+"'");
			logger.error("ERROR   :> Record Not Found : '" + data+"'");
			Assert.fail("ERROR   :> Record Not Found : '" + data+"'");
	  		}
		}
	  		else {
			System.out.println("Input data: " + data + " to field: " + locatorName);
			log.info("SUCCESS :> Input data : '" + data + "' to field: " + locatorName);
			logger.info("SUCCESS :> Input data : '" + data + "' to field: " + locatorName);
		}
	  }catch(Exception e){
	  		log.warn("SKIPED  :> Element not found : " + locatorName);
			logger.warn("SKIPED  :> Element not found : " + locatorName);
	  	//	   throw new SkipException("Not Found Locator : "+locatorName);
	  	 }
}
	 
	/**  Send value in searchbox and click values from list using mouseAction
	 * 
	 * @param SearchTextBoxlocator
	 * @param labelNameLocator
	 * @param data
	 * @param locatorName
	 * @param waitTime
	 * @throws Throwable
	 */
public void Searchboxvalueselectionby_mouseaction(WebElement SearchTextBoxlocator, By labelNameLocator, String data,String locatorName, int waitTime) throws Throwable{
	  System.out.println("Executing input on: "+locatorName);
	//  log.info("Executing input on: "+locatorName);
	  this.waitForElement(SearchTextBoxlocator);
	  //this.waitFixedTime(1);
	  SearchTextBoxlocator.click();
	  	 try{
	  		SearchTextBoxlocator.click();
	  		SearchTextBoxlocator.clear();
	  		//labelNameLocator.click();
	  		//this.waitFixedTime(waitTime);
	  		this.waitForElement(SearchTextBoxlocator);
	  		SearchTextBoxlocator.click();
	  		SearchTextBoxlocator.sendKeys(data);
	  		SearchTextBoxlocator.sendKeys("\uE015");
	  		CommonUseFile.mouseover(labelNameLocator, locatorName);
	  		this.click(labelNameLocator, locatorName);
	  		//this.waitFixedTime(2);
	  		SearchTextBoxlocator.sendKeys(Keys.ENTER);
	  		//this.waitFixedTime(waitTime);
	  		if (this.isElementPresentSingleLocator(cl.pageCrashImage)) {
				System.err.println("ERROR   :> Page crashed After Selection : '" + data+"'");
				logger.fatal("ERROR   :> Page crashed After Selection : '" + data+"'");
				Assert.fail("ERROR   :> Page crashed After Selection : '" + data+"'");
		}
	  		else if (this.isElementPresentSingleLocator(cl.ServerError)) {
			System.err.println("ERROR   :> Page crashed After Selection : '" + data+"'");
			logger.fatal("ERROR   :> Page crashed After Selection : '" + data+"'");
			Assert.fail("ERROR   :> Page crashed After Selection : '" + data+"'");
		}
	  		else if(this.AlertBoxPresentORNot()==true) {
	  		if (this.closeAlertAndGetItsText().equalsIgnoreCase("Record Not Found")) {
			System.err.println("ERROR   :> Record Not Found : '" + data+"'");
			log.error("ERROR   :> Record Not Found : '" + data+"'");
			logger.error("ERROR   :> Record Not Found : '" + data+"'");
			Assert.fail("ERROR   :> Record Not Found : '" + data+"'");
	  		}
		}
	  		else {
			System.out.println("Input data: " + data + " to field: " + locatorName);
			log.info("SUCCESS :> Input data : '" + data + "' to field: " + locatorName);
			logger.info("SUCCESS :> Input data : '" + data + "' to field: " + locatorName);
		}
	  }catch(Exception e){
	  		log.warn("SKIPED  :> Element not found : " + locatorName);
			logger.warn("SKIPED  :> Element not found : " + locatorName);
	  	//	   throw new SkipException("Not Found Locator : "+locatorName);
	  	 }
}

	/**  Get Alert and Get Alert box Message 
	 * 
	 * @return
	 */

public String closeAlertAndGetItsText() {
	  System.out.println("Executing closeAlertAndGetItsText");
	//  log.info("Executing closeAlertAndGetItsText");
      try {
           Alert alert = driver.switchTo().alert();
           String alertText = alert.getText();
                  if (acceptNextAlert) {
                  	alert.accept();
                   } else {
                    alert.dismiss();
                    }
             return alertText;
          } finally {
        acceptNextAlert = true;
          }
	 
}

	/** isAlertPresent
	 * 
	 */
public boolean isAlertPresent() 
{ 
    try 
    { 
        driver.switchTo().alert(); 
        return true; 
    }   // try 
    catch (NoAlertPresentException Ex) 
    { 
        return false; 
    }   // catch 
}   // isAlertPresent()
	 /** AlertAcceptIfPresent
	  * 
	  */
	public void AlertAcceptIfPresent(){
	if(this.isAlertPresent()){
	System.err.println("Alert present");
	driver.switchTo().alert().accept();
	System.out.println("Alert dismiss");
	}else{
	System.err.println("Alert not present.....");
	}
}
	/**  PopWindow Handle
	 *  
	 */
	public void WindowHandle() {
		 // It will return the parent window name as a String
		 String mainWindow=driver.getWindowHandle();
		 // It returns no. of windows opened by WebDriver and will return Set of Strings
		 Set<String> set =driver.getWindowHandles();
		 // Using Iterator to iterate with in windows
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
		 String childWindow=itr.next();
		    // Compare whether the main windows is not equal to child window. If not equal, we will close.
		 if(!mainWindow.equals(childWindow)){
		 driver.switchTo().window(childWindow);
		 System.out.println(driver.switchTo().window(childWindow).getTitle());
		 driver.close();
		 }
		 // This is to switch to the main window
		 else {
			 
		 driver.switchTo().window(mainWindow);
		 }
		
	}}
	/**  Click and skip
	 *  
	 */
	public void clickORSkip(Object locator, String locatorName) {
		System.out.println("\nExecuting click on: " + locatorName);
		log.info("Executing click on: " + locatorName);
		try {
			this.waitForElement(locator);
			stale.findElement(locator).click();
			log.info("Able to click on " + locatorName);
			
			if (this.OnlyVerifyisElementPresentSingleLocator(cl.pageCrashImage)) {
					System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
					logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
					Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
				
			}else if (this.OnlyVerifyisElementPresentSingleLocator(cl.ServerError)) {
				System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
				logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
				Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
			}else {
				System.out.println("PASS    :> Successfully clicked : " + locatorName );
			}
		} catch (Exception e) {
			System.err.println("SKIPED  :> Element not found :> " + locatorName);
			log.warn("SKIPED  :> Element not found :> " + locatorName);
			logger.warn("SKIPED  :> Element not found :> " + locatorName);
			throw new SkipException("SKIPED  :> Not Found Element : " + locatorName);
		}
	}

	/** Clear function for edit
	 *  
	 */

public void Clear(Object locator, String locatorName) {
	System.out.println("Executing click on: " + locatorName);
//	log.info("Executing click on: " + locatorName);
	try {
		stale.findElement(locator).clear();
		log.info("Able to click on " + locatorName);
	} catch (Exception e) {
		System.err.println("SKIPED  :> Element not found :> " + locatorName);
		log.warn("SKIPED  :> Element not found :> " + locatorName);
		logger.warn("SKIPED  :> Element not found :> " + locatorName);
	//	throw new SkipException("Not Found Element : " + locatorName);
	}
} 
/** verify single locator
 *  
 */	 
public boolean OnlyVerifyisElementPresentSingleLocator(Object locator) {
	try {
		stale.findElement(locator);
		return true;
	} catch (NoSuchElementException e) {
		return false;
	}
}
/** 
 * MenuPageClick for 3 level
 *  
 */	
public void MenuPageClick(Object modulelocator, String moduleName, Object submodulelocator,
		String submoduleName, Object pageNamelocator, String pageName, Object PageHeader) {
	this.clickORSkip(modulelocator, moduleName);
	// bc.waitFixedTime(1);
	this.clickORSkip(submodulelocator, submoduleName);
	// bc.waitFixedTime(1);
	this.clickORSkip(pageNamelocator, pageName);
	//this.waitFixedTime(2);
	log.info("<-------------------------------------> "+pageName+" <---------------------------------->");
	logger.info("<-------------------------------------> "+pageName+" <---------------------------------->");
	try {
		Assert.assertTrue(this.isElementPresentSingleLocator(PageHeader));
		System.out.println("PASSED :> Menu page open Successfully");
		log.info("PASSED :> Menu page open Successfully");
		logger.info("PASSED  :> Menu page open Successfully");

	} catch (AssertionError e) {
		System.err.println("FAILED :> Menu page not Open OR Page Crashed");
		log.warn("FAILED  :> Menu page not Open OR Page Crashed");
		logger.error("FAILED  :> Menu page not Open OR Page Crashed");
		Assert.fail("Expected Value : [" + pageName + " - Page Header] But Found : [Page Crashed]");
	}
}	 
/** 
 * MenuPageMouseOver for 3 level
 *  
 */	
	public void MenuPageMouseOver(Object modulelocator, String moduleName, Object submodulelocator,
			String submoduleName, Object pageNamelocator,
			String pageName, String PageTitle) {
		this.moveToElement(modulelocator, moduleName);
		this.moveToElement(submodulelocator, submoduleName);
		this.clickORSkip(pageNamelocator, pageName);
		log.info("<-------------------------------------> " + pageName + " <---------------------------------->");
		logger.info("<-------------------------------------> " + pageName + " <---------------------------------->");
		String a = driver.getTitle();
		try {
			Assert.assertEquals(driver.getTitle(), PageTitle);
			System.out.println("PASSED :> MenuPage page open Successfully");
			log.info("PASSED :> Menu page open Successfully");
			logger.info("PASSED  :> Menu page open Successfully");
		} catch (AssertionError e) {
			System.err.println("FAILED :> Menu page not open OR Page Crashed");
			log.warn("FAILED  :> Menu page not open OR Page Crashed");
			logger.error("FAILED  :> Menu page not open OR Page Crashed");
			Assert.fail("Expected Value : " + PageTitle + " But Found : " + a);
		}
	}
	/** 
	 * moveToElement function
	 *  
	 */	
   public void moveToElement(Object locator, String locatorName) {
	try {
		Actions actions = new Actions(driver);
		actions.moveToElement(stale.findElement(locator)).build().perform();
		// actions.clickAndHold().build().perform();
		System.out.println("Executing Move to Element on Element:" + locatorName);
		log.info("Executing Move to Element on Element:" + locatorName);
	} catch (Exception e) {
		System.out.println("Not found: " + locatorName);
		log.error("Not found: " + locatorName);
		throw new SkipException("Not Found : " + locatorName);
	}
}	 
   /** 
	 * Upload method for upload any kinds of file using robot class
	 *  
	 */	

	public void Upload_Method(String Filepath) throws Exception {
		System.err.println("executed robot classes...............");
		StringSelection ss = new StringSelection(Filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info(Filepath);
		logger.fatal(Filepath);
	}	 
	  /** 
		 * Method for Quantity check and verified
		 *  
		 */	
	public void Quantity(String Signature, String numberofProduct, Object locator, String locatorName,
			Object quentityP) {
		for (int i = 0; i <= numberofProduct.length(); i++) {
			if (Signature.equalsIgnoreCase("positive")) {
				this.click(locator, locatorName);
				System.out.println(locator);
			} else {
				this.click(quentityP, "locator1");
				System.out.println(locator);
			}

		}

	}
	 /** 
	 * logout method for logout the application
	 *  
	 */	
public void logout(Object locator,String locatorName) {
	this.click(locator, locatorName);
}
//------------------------------------------> Click ------------------------------------>
public void click(WebElement locator,String locatorName){
	  System.out.println("\nExecuting click on: "+locatorName);
	 // log.info("Executing click on: "+locatorName);
	  	 try{
	  		 	this.waitForElement(locator);
	  		 	//this.waitFixedTime(1);
	  		 	//this.Implicitywait();

	  		 	WebDriverWait wait = new WebDriverWait(driver,60);
	  	        wait.until(ExpectedConditions.visibilityOf(locator ));
	  		    this.highLighterMethod(locator);
	  		 	locator.click();
	  		   log.info("Able to click on "+locatorName);
	  		 Reporter.log(">>>>>>>>>click on "+locatorName);
	  	 }catch(Exception e){
	  		System.err.println("SKIPED  :> Element not found :> " + locatorName);
			log.warn("SKIPED  :> Element not found :> " + locatorName);
			logger.warn("SKIPED  :> Element not found :> " + locatorName);
			Reporter.log(locatorName+" element Not clickable>>>>>>>>>");
	  		//   throw new SkipException("Not Found Element : "+locatorName);
	  	 }
	    }
//----------------------------> Select dropdown value-------------------------------------->
public void selectByVisibleText(WebElement locator,String text,String locatorName){
	  System.out.println("Executing Select on: "+locatorName);
	//  fbc.logWarn("****************** : "+text);
	  this.highLighterMethod(locator);
	 if(!text.equals("")){
	  try{
		  this.waitFixedTime(2);
		   boolean isSelected=false;
		    Select s = new Select(locator);
			try{
		  s.selectByVisibleText(text);
		  Reporter.log(">>>>>>>>>select visible  "+text);
		  Thread.sleep(1000);
			if (this.OnlyVerifyisElementPresentSingleLocator(cl.pageCrashImage)) {
				System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
				logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
				Assert.fail("ERROR  :> Page crashed on the click of " + locatorName);
			
		}else if (this.OnlyVerifyisElementPresentSingleLocator(cl.ServerError)) {
			System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
			logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
			Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
		}else {
			logger.info("SUCCESS :> Dropdown Selected :: '" + text + "' from selectbox :: '" + locatorName+"'");
			log.info("SUCCESS :> Dropdown Selected :: " + text + " from selectbox :: " + locatorName+"'");
		}
			isSelected=true;
			}catch(Exception e){
				log.error("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox :: '" + locatorName+"'");
				logger.error("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox :: '" + locatorName+"'");
				
			    isSelected=false;
			}
			if(!isSelected){
			try{
			    s.selectByValue(text);
			    Thread.sleep(1000);
				if (this.OnlyVerifyisElementPresentSingleLocator(cl.pageCrashImage)) {
					System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
					logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
					Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
				
			}else if (this.OnlyVerifyisElementPresentSingleLocator(cl.ServerError)) {
				System.err.println("ERROR   :> Found a Page crashed on the click of " + locatorName );
				logger.fatal("ERROR   :> Page crashed on the click of " + locatorName);
				Assert.fail("ERROR   :> Page crashed on the click of " + locatorName);
			}else {
			//	log.info("SUCCESS :> Selected :: " + text);
			//	this.logInfo("SUCCESS :> Selected :: " + text );
			}	
				isSelected=true;
				}catch(Exception e){
			//		log.error("ERROR   :> Not able to select :: " + text);
			//		this.logError("ERROR   :> Not able to select :: " + text);
				    isSelected=false;
				}
			}
			if(!isSelected){
				try{
			//	s.selectByIndex(1);
		//		log.error("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox : '" + locatorName+"'");
			//	this.logError("ERROR   :> 'Blank value' OR Not able to select :: '" + text + "' from selectbox : '" + locatorName+"'");
				}catch(Exception e){
						}
				}
			
		    
		    }catch(Exception e){
		    	log.warn("SKIPED  :> Dropdown Locator Not found : " + locatorName);
				logger.warn("SKIPED  :> Dropdown Locator Not found : " + locatorName);
	//		  throw new SkipException("Not Found Locator : "+locatorName);
			}
	 }
	 else{
	 }
}
// -----------------> fixed wait time in seconds --------------------------->
public void waitFixedTime(long t){
	//  log.info("Executing wait Fixed Time");
	 try{
		 Thread.sleep(t*1000);
	 }catch(Throwable e){
		 System.out.println("Error in wait");
		 log.info("Error in wait");
		   	 }
  }
public void Implicitywait() {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
public void CheckBoxHandler(String action,WebElement CheckBoxLocator, String locatorName) throws InterruptedException

{
	System.out.println("execute:" + CheckBoxLocator);
	if(action.equalsIgnoreCase("yes")&& !this.isElement_selected(CheckBoxLocator))
	{
		this.click(CheckBoxLocator, locatorName);
		System.out.println("click:" + CheckBoxLocator);
	}
	else if(action.equalsIgnoreCase("yes")&& this.isElement_selected(CheckBoxLocator)==false)
	{
		System.err.println("allready selected:" + CheckBoxLocator);
	}
	else if(action.equalsIgnoreCase("no")&& this.isElement_selected(CheckBoxLocator))
	{
		this.click(CheckBoxLocator, locatorName);
	}
	else
	{
		System.err.println("user not want to select:" + CheckBoxLocator);
	}


}
//-------------------> scroll Down java script ---------------------------->

public void ScrollDown() throws Exception {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0,200)", "");//750
}
//Creating a custom function
public void highLighterMethod(WebElement element){
System.out.println(">>>>>>>>>>>>>>>>>>>>>>run highlighter"+element);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
}
//-----------------------> Add New Button -------------------------------------->
public void ClickAndVerify(WebElement AddNewButtonLocator, String locatorName, WebElement AddNewPageNameHeader, WebElement CancelButton){
	this.click(AddNewButtonLocator, locatorName);
	this.waitFixedTime(1);
	try{
		Assert.assertTrue(this.isElementPresentSingleLocator(AddNewPageNameHeader));
		this.click(CancelButton, "Back Button");
		System.out.println("PASSED  :> "+locatorName+" is working properly");
		log.info("PASSED  :> "+locatorName+" is working properly");
		log.info("PASSED  :> Add New Button is working properly");
	}
	catch(AssertionError e){
		System.out.println("FAILED  :>"+locatorName+" is not Working : page crashed");
		log.error("FAILED  :> "+locatorName+" is not Working : page crashed");
		log.error("FAILED  :> "+locatorName+" is not Working : page crashed");
		Assert.fail("Expected Value : "+locatorName+" Page Header, But Found : Page Crashed");
	}
	
}
//-------------------> select ValueFromComboBox ---------------------------->
public void selectValueFromComboBox(WebElement locator,String text,String locatorName) {
	  System.out.println("\nExecuting click on: "+locatorName);
		 // log.info("Executing click on: "+locatorName);
		  	 try{
		  		 	this.waitForElement(locator);
		  		 	//this.waitFixedTime(1);
		  		    this.highLighterMethod(locator);
		  		 	locator.click();
		  		   log.info("Able to click on "+locatorName);
		  		 Reporter.log(">>>>>>>>>click on "+locatorName);
		  	 }catch(Exception e){
		  		System.err.println("SKIPED  :> Element not found :> " + locatorName);
				log.warn("SKIPED  :> Element not found :> " + locatorName);
				logger.warn("SKIPED  :> Element not found :> " + locatorName);
				Reporter.log(locatorName+" element Not clickable>>>>>>>>>");
		  		//   throw new SkipException("Not Found Element : "+locatorName);
		  	 }
		    	
}
//-------------------> ClickEnter ---------------------------->

public void ClickEnter() throws Exception {
	System.err.println("executed robot classes  for click on the enter button...............");
	Robot robot = new Robot();
	/*
	 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
	 */
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}
//-------------------> isElementPresent for check the locator available or not ---------------------------->
public boolean isElementPresent(WebDriver driver, By by) {  
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
    try {  
        driver.findElement(by); 
       Reporter.log("Element Present");
        return true;  
    } catch (NoSuchElementException e) {  
    	Reporter.log("Element not Present");
        return false;  
    } finally {  
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
    }  
}
//-------------------> iFrame handle ---------------------------->
public void iFrame(WebElement locator) {
    WebDriverWait wait=new WebDriverWait(driver,30);
    System.out.println("waiting for frame");
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By)locator));
	log.info("Able to click on "+locator);
	 Reporter.log(">>>>>>>>>click on "+locator);
    System.out.println("Frame fiend.........");
    System.out.println("Close the bot");
	
}
//------------------->ifElementPresent then click---------------------------->
public void ifElementPresent(WebElement locator,String locatorName) {
	  List<WebElement> Element=driver.findElements((By) locator);
      if(Element.size()>0) {
      Element.get(0).click();
}

}
//------------------->Price verification---------------------------->
public void PriceVerification(String locator) {
	String Price = driver.findElement(By.xpath(locator)).getText();
	String NumericPrice=Price.replaceAll("[^0-9]", "");
	Integer number = Integer.valueOf(NumericPrice);
	System.out.println("Price is "+number);
	Reporter.log("Price is "+number);
	
}
//------------------->Separate character and digit---------------------------->
public void ChangeIntoNumeric(WebElement locator,String locatorName){
	  System.out.println("\nExecuting the: "+locatorName);
	  	 try{
	  		 	this.waitForElement(locator);
	  		 	WebDriverWait wait = new WebDriverWait(driver,60);
	  	        wait.until(ExpectedConditions.visibilityOf(locator ));
	  		    this.highLighterMethod(locator);
	  		  String Price=locator.getText();
	  		String NumericPrice=Price.replaceAll("[^0-9]", "");
	  		Integer number = Integer.valueOf(NumericPrice);
	  		System.out.println("Price is "+number);
	  		Reporter.log("Price is "+number);
	  		   log.info("Able to convert on the number "+number);
	  		 Reporter.log(">>>>>>>>Able to convert on the number  "+number);
	  	 }catch(Exception e){
	  		System.err.println("SKIPED  :> Element not found :> " + locatorName);
			log.warn("SKIPED  :> Element not found :> " + locatorName);
			logger.warn("SKIPED  :> Element not found :> " + locatorName);
			Reporter.log(locatorName+" element Not vigible>>>>>>>>>");
	  	 }
	    }
//--------------------------------------------------------------------------------
public void CheckOrderTotal_SubTotal_ShippingCost(WebElement locator1,WebElement locator2,WebElement locator3,WebElement locator4,String locatorName) {
	int c;
	
		System.out.println("Execute CheckOrderTotal_SubTotal_ShippingCost....");
		  this.highLighterMethod(locator1);
  		String CartSubTotal=locator1.getText();
  		System.out.println(CartSubTotal);
  		Reporter.log(CartSubTotal);
  		String Shpping=locator2.getText();
  		System.out.println(Shpping);
  		Reporter.log(Shpping);
  		String Tax=locator3.getText();
  		System.out.println(Tax);
  		Reporter.log(Tax);
  		String GrandTotal=locator4.getText();
  		System.out.println(GrandTotal);
  		Reporter.log(GrandTotal);
  		//Removing the character from String
		String CartSubTotal1=CartSubTotal.replaceAll("[^0-9]", "");
		String Shpping1=Shpping.replaceAll("[^0-9]", "");
		String Tax1=Tax.replaceAll("[^0-9]", "");
		String GrandTotal1=GrandTotal.replaceAll("[^0-9]", "");
		//Converting String to integer
		Integer number_CartSubTotal = Integer.valueOf(CartSubTotal1);
		System.out.println(number_CartSubTotal);
		Reporter.log(CartSubTotal1);
		Integer number_Shpping = Integer.valueOf(Shpping1);
		System.out.println(number_Shpping);
		Reporter.log(Shpping1);
		Integer number_Tax = Integer.valueOf(Tax1);
		System.out.println(number_Tax);
		Reporter.log(CartSubTotal);
		Integer number_GrandTotal1 = Integer.valueOf(GrandTotal1);
		System.out.println(GrandTotal1);
		Reporter.log(GrandTotal1);
		try {
		c = number_CartSubTotal+number_Shpping+ number_Tax ;//c variable stands for the total amount
		Assert.assertEquals(c,GrandTotal1);
		System.out.println("Testcases pass " + c + "match with" + number_GrandTotal1);
	} catch (Exception e) {
		Assert.fail();
	} finally {
	 System.out.println("Execute the final block");
	}
}
//----------------------Method for scroll up-------------------------------
public void scrollup() {
((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
}



}