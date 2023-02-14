package com.EFL.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;
public class Home extends TestBase {
	CommonUseFile fil;
	
	//Page Factory created
	//public static Object Logn ="//*[text()='Login']";
	 
	
	
	@FindBy(xpath="//div[3]/div/div[3]/div/i")
	WebElement SearchIcon;
	@FindBy(xpath="//*[@class='action cart-icon']")
	WebElement bag;
	@FindBy(xpath="//*[@id='root']/div[1]/header/div[1]/div[3]/div[1]/div/ul/li[4]/a")///html/body/div[4]/header/nav/ul/li[2]/a
	WebElement Menu;//*[@id="respMenu"]/li[3]/a/span[1]
	
	/*@FindBy(xpath="//*[@id='respMenu']/li[3]/a/span[1]")///html/body/div[4]/header/nav/ul/li[2]/a
	WebElement Menu;*/
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/header/div[1]/div[3]/div[1]/div/ul/li[4]/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/ul/li[1]/a")////*[@id='instant-search-results-container']/div/div[1]/div/div/div[1]/div[1]/a/img
	WebElement SubMenu;
	@FindBy(xpath="//div[2]/div/ul[1]/li[4]/a[1]")
	WebElement signIn;
	
	
	
	
	
	//-------------------------------------------
	//*[text()='Demo request']
	@FindBy(xpath="//*[text()='Demo request']")
	WebElement Seccess;
	@FindBy(xpath="//*[@id='modal-content-1']/div/div/button/span")
	WebElement Continue1;
	@FindBy(xpath="//*[@id='html-body']/div[9]/aside[2]/div[2]/div/header/div")
	WebElement cancel1;
	
	@FindBy(xpath="//*[@class='header-buttons' and text()='Book Demo']")
	WebElement DemoButton;
	@FindBy(xpath="/html/body/div[3]/main/div[2]/div/div[2]/div/ul/li[1]")
	WebElement DemoButton1;
	
	@FindBy(xpath="//*[text()='Vacuum ']")
	WebElement Vaccume;
	@FindBy(xpath="/html/body/div[3]/main/div[2]/div/div[2]/div/ul/li[1]/label/i")
	WebElement Purifiers;
	@FindBy(xpath="//*[@id='maincontent']/div[2]/div/div[7]/div/a/picture/img")
	WebElement HeroBanner;
	
	@FindBy(xpath="//*[@id='pincode_modal']")
	WebElement PinCode;
	@FindBy(xpath="//*[@id='fullname_modal']")
	WebElement FullName;
	@FindBy(xpath="//*[@id='mobile_modal']")
	WebElement MobileNumber;
	@FindBy(xpath="//*[@class='action modalform_1_submit primary']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//*[@id=\"product-search-list\"]/li[1]/a")
	WebElement pd1;
	@FindBy(xpath="//*[@class='search-customs icon icon-search']")
	private WebElement search;
	@FindBy(xpath="//*[@id='search']")
	WebElement SearchBox;
	//*[@id="t_PageBody"]/div[4]/div[3]/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/a/img
	@FindBy(xpath="//*[@class='amsearch-button -loupe -clear -icon']")
	WebElement SearchLogo;
	@FindBy(xpath="//*[@id='html-body']/div[2]/header/div/div/div[3]/section/div/section[2]/section[2]/ul/li[1]/section/a")
	WebElement suggest;
	
	@FindBy(xpath="//*[@id='amasty-shopby-product-list']/div[2]/ol/li[1]/div/div/a/span/span/img")
	WebElement image1; 
	@FindBy(xpath="//*[@id='amasty-shopby-product-list']/div[2]/ol/li[1]/div/div/a/span/span/img")
	WebElement image3;
	@FindBy(xpath="//*[@id='ui-id-10']/div[2]")
	WebElement DropValue;
	
	@FindBy(xpath="//*[@id='html-body']/div[2]/header/div/div/div[1]/a/img")
	WebElement Logo;
	@FindBy(xpath="//*[@class='icon-close auto-search']")
	WebElement searchCross;
	
	@FindBy(xpath="//*[@id='html-body']/div[3]/header/div/div/div[1]/a/img")
	WebElement Logo1;
	@FindBy(xpath="//*[@id='myaccount']")
	WebElement LoginL;
	@FindBy(xpath="//*[@id='mobNumber']")
	WebElement MobL;
	@FindBy(xpath="//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li[1]/div/div/div/div[5]/div/div[2]/a/button/span")
	WebElement ViewMore;
	@FindBy(xpath="//*[@id='OTPbtn']")
	WebElement Continue;
	@FindBy(xpath="//*[@id='btn-otpverify']")
	WebElement ContinueOTP;
	
	@FindBy(xpath="//*[@id='custom-modal']/div/a")
	WebElement cancel;
	
	public Home() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		fil=new CommonUseFile(driver);
		//cm=new CommonLocator();
	}	
	
	
	
	public void HomePageAvailable(String MobileNumberData,String SearchData,String selectData) throws Throwable{
		fil.waitFixedTime(5);
	this.DemoButton();
	this.BuyAMC();
	this.heroBanner();
	this.Login(MobileNumberData);
	this.OTPPopup(MobileNumberData);
	this.VerifySearchicon();
	this.Search_result_By_Adding_keyword(SearchData,selectData);
	this.search_result_withAuto_suggest(SearchData, selectData);
	this.search_withEnter_action(SearchData, selectData);
	
	this.L1_Air_Purifiers();
	this.L1_Coronaguard();
	this.L1_Vacuum_Cleaners();
	this.L1_Water_Purifiers();
	this.L1_Water_Solution();
	
	this.L2_Water_Solution();
	this.L2_Vaccum_cleaner();
	this.L2_Air_Purifiers();
	}
	public void DemoButton() {
	fil.isElementPresent(driver,By.xpath("//*[@class='header-buttons' and text()='Book Demo']"));
	System.out.println("TestCases pass''Demo available on home page");
	}
	public void BuyAMC() {
	fil.isElementPresent(driver,By.xpath("//*[@class='header-buttons' and text()='Buy AMC']"));
	System.out.println("TestCases pass''Buy AMC available on home page");
	}
	public void heroBanner() {
	fil.click(HeroBanner, "Click on hero Banner");	
	try {
	Assert.assertEquals(driver.getTitle(),"Water Testing");
	Reporter.log(">>>>>>>>>verify successfully");
	System.err.println(">>>>>>>>>verify successfully 'Water Testing' Match with expexted value");
	}
	catch(Exception e) {
	Reporter.log(">>>>>>>>>not verify successfully");
	System.err.println(">>>>>>>>>verify successfully 'Water Testing' not Match with expexted value");
	Assert.fail();			
	}finally {
	fil.click(Logo, "Click on Logo");
	}
	}
	public void Login(String MobileNumberData) {
	fil.isElementPresent(driver,By.xpath("//*[@id='myaccount']"));
	System.out.println("TestCases pass''Login icon'' available on home page");
	fil.click(LoginL, "Click on login icon");
	fil.SendKeys(MobL,MobileNumberData, "Enter Mobile Number");
	fil.click(Continue, "Click on Continue");
	String s=driver.findElement(By.xpath("//*[@id='btn-otpverify']")).getText();
	try {
		Assert.assertEquals(s,s);
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully '"+s+"' Match with expexted value");	
		fil.click(ContinueOTP, "Click on Continue");
	}catch(Exception e) {
	Reporter.log(">>>>>>>>>Not verify successfully");
	System.err.println(">>>>>>>>>Not verify successfully '"+s+"' Not Match with expexted value");	
	Assert.fail();	
	}
	finally {
	fil.click(cancel, "Click on cancel");	
	fil.click(Logo1, "Click on logo");	
	}
	}
	public void OTPPopup(String MobileNumberData) {
		fil.isElementPresent(driver,By.xpath("//*[@id='myaccount']"));
		System.out.println("TestCases pass''Login icon'' available on home page");
		fil.click(LoginL, "Click on login icon");
		fil.SendKeys(MobL,MobileNumberData, "Enter Mobile Number");
		fil.click(Continue, "Click on Continue");
		String s=driver.findElement(By.xpath("//*[@id='btn-otpverify']")).getText();
		try {
			Assert.assertEquals(s,s);
			Reporter.log(">>>>>>>>>verify successfully");
			System.err.println(">>>>>>>>>verify successfully '"+s+"' Match with expexted value");	
			fil.click(ContinueOTP, "Click on Continue");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>Not verify successfully");
		System.err.println(">>>>>>>>>Not verify successfully '"+s+"' Not Match with expexted value");	
		Assert.fail();	
		}
		finally {
		fil.click(cancel, "Click on cancel");	
		fil.click(Logo1, "Click on logo");	
		}
		}
	
	
	
	
	
	public void Demo(String WayToClickOnMenu,String PinCodeData,String FullNameData,String MobileNumberData){
	fil.click(DemoButton, "Click on Demo");	
	if(WayToClickOnMenu.equalsIgnoreCase("Water")) {
		fil.waitFixedTime(3);
		fil.click(Purifiers, "Click on water Purifiers");	
		fil.click(DemoButton1, "Click on water Purifiers");
	}else {
		fil.click(Vaccume, "Click on Vaccume cleaners");	
	}
	fil.SendKeys(PinCode, PinCodeData, "Enter PinCode");
	fil.SendKeys(FullName, FullNameData, "Enter FullName");
	fil.SendKeys(MobileNumber, MobileNumberData, "Enter MobileNumber");
	fil.waitFixedTime(2);
	fil.click(Continue1, "Click on Continue");
	fil.waitFixedTime(3);
	fil.click(Seccess, "Click on Seccess");
	String s=driver.findElement(By.xpath("//*[text()='Demo request']")).getText();
	try {
		Assert.assertEquals(s,"Demo request");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully '"+s+"' Match with expexted value");	
		String s1=driver.findElement(By.xpath("//*[@class='demo-request-number']")).getText();
		Reporter.log(s1);
		System.err.println(s1);
		fil.waitFixedTime(3);
		//fil.click(cancel1, "Click on cross button");
	}catch(Exception e) {
	Reporter.log(">>>>>>>>>Not verify successfully");
	System.err.println(">>>>>>>>>Not verify successfully '"+s+"' Not Match with expexted value");	
	Assert.fail();	
	}
	finally {
	//fil.click(cancel, "Click on cancel");	
	//fil.click(Logo1, "Click on logo");	
	}
	//verify demo success or not
	}
	public void Selectcategory(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData) throws Throwable {
	fil.waitFixedTime(10);
	if(WayToClickOnMenu.equalsIgnoreCase("Search")) {
	this.Search(SearchData,selectData);
	}
	else if(WayToClickOnMenu.equalsIgnoreCase("Demo")) {
	//this.Demo(PinCodeData,FullNameData,MobileNumberData);	
	}
	else {
	this.Menu();
	//fil.waitFixedTime(2);
	//fil.click(image1, "Click on image");
	
	   }
		if(fil.isElementPresent(driver,By.xpath("//*[@id='amasty-shopby-product-list']/div[2]/ol/li[1]/div/div/a/span/span/img"))) {
		fil.waitFixedTime(2);
		fil.click(image1, "Click on product image");
		}else 
		{
		fil.click(image3, "Click on product image");	
		}
	}
	public void VerifySearchicon(){
		fil.click(search, "click on Search icon");
		fil.waitFixedTime(1);
		try {
		fil.isElementPresent(driver,By.xpath("//*[@id='search']"));
		System.out.println("TestCases pass'Search box' available on home page");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>TestCases pass'Search box' available on home page");
		}catch(Exception e) {
			System.out.println("TestCases pass'Search box' not available on home page");
			Reporter.log(">>>>>>>>>not verify successfully");
			System.err.println(">>>>>>>>>TestCases failed 'search box' not available on home page");
			Assert.fail();
		}finally {
			fil.click(searchCross, "click on cancel button");
			fil.click(Logo, "click on logo");
		}
		
		
	}
	public void  search_withEnter_action(String SearchData,String selectData) throws Throwable {
		//fil.SendKeysSearchBoxDropdownValue(search, SearchData, "Search box", 2);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		fil.click(search, "click on Search box");
		fil.waitFixedTime(1);
		fil.SendKeys(SearchBox, SearchData, "Search box");
		fil.waitFixedTime(3);
		fil.ClickEnter();
		String t=driver.findElement(By.xpath("//*[@id='item_numbers']")).getText();
		try {
		Assert.assertEquals(t,t);
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+t+" Match with expexted value");
		}
		catch(Exception e) {	
			Reporter.log(">>>>>>>>>not verify successfully");
			System.err.println(">>>>>>>>>verify successfully "+t+" not Match with expexted value");
			Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}
		}
	public void  search_result_withAuto_suggest(String SearchData,String selectData) throws Throwable {
		//fil.SendKeysSearchBoxDropdownValue(search, SearchData, "Search box", 2);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		fil.click(search, "click on Search box");
		fil.waitFixedTime(1);
		fil.SendKeys(SearchBox, SearchData, "Search box");
		fil.waitFixedTime(1);
		fil.click(suggest, "Click on suggest");
		fil.waitFixedTime(3);
		//fil.ClickEnter();
		String t=driver.findElement(By.xpath("//*[@id='magnifier-item-0']")).getText();
		try {
		Assert.assertEquals(t,t);
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+t+" Match with expexted value");
		}
		catch(Exception e) {	
			Reporter.log(">>>>>>>>>not verify successfully");
			System.err.println(">>>>>>>>>verify successfully "+t+" not Match with expexted value");
			Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}
		}
	
	public void  Search_result_By_Adding_keyword(String SearchData,String selectData) throws Throwable {
		//fil.SendKeysSearchBoxDropdownValue(search, SearchData, "Search box", 2);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		fil.click(search, "click on Search box");
		fil.waitFixedTime(1);
		fil.SendKeys(SearchBox, SearchData, "Search box");
		fil.waitFixedTime(1);
		fil.click(SearchLogo, "Click on SearchLogo");
		fil.waitFixedTime(3);
		//fil.ClickEnter();
		String t=driver.findElement(By.xpath("//*[@id='item_numbers']")).getText();
		try {
		Assert.assertEquals(t,t);
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+t+" Match with expexted value");
		}
		catch(Exception e) {	
			Reporter.log(">>>>>>>>>not verify successfully");
			System.err.println(">>>>>>>>>verify successfully "+t+" not Match with expexted value");
			Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}
		}
	
	
	public void  Search(String SearchData,String selectData) throws Throwable {
		//fil.SendKeysSearchBoxDropdownValue(search, SearchData, "Search box", 2);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		fil.click(search, "click on Search box");
		fil.waitFixedTime(1);
		fil.SendKeys(SearchBox, SearchData, "Search box");
		fil.waitFixedTime(1);
		fil.click(SearchLogo, "Click on SearchLogo");
		fil.waitFixedTime(3);
		//fil.ClickEnter();
		String t=driver.findElement(By.xpath("//*[@id='item_numbers']")).getText();
		try {
		Assert.assertEquals(t,t);
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+t+" Match with expexted value");
		}
		catch(Exception e) {	
			Reporter.log(">>>>>>>>>not verify successfully");
			System.err.println(">>>>>>>>>verify successfully "+t+" not Match with expexted value");
			Assert.fail();
		}
		}
	public void Menu() throws AWTException, InterruptedException{
		fil.waitForElement(Menu);
		//-------------------------------
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		//L1 for mouse over
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		//L2 for click using actions class
		WebElement submenul1=driver.findElement(By.xpath("//*[@id='main-close']/li[4]/a/span[2]"));
		element.moveToElement(submenul1).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@id='main-close']/li[4]/ul/li[3]/a/span"));
		Thread.sleep(5000);
		submenu.click();
		fil.waitFixedTime(2);
		String t=driver.findElement(By.xpath("//*[@id='page-title-heading']/span")).getText();
		try {
		Assert.assertEquals(t,"Aeroguard");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+t+" Match with expexted value");
		 }
		 catch(Exception e) {
		 Reporter.log(">>>>>>>>>Not verify successfully");
		 System.err.println(">>>>>>>>>Not verify successfully "+t+" Not Match with expexted value");
		 Assert.fail();
		 }
		}
	//------------------------------------------------------
	public void L1_Water_Purifiers() throws InterruptedException {
	fil.waitForElement(Menu);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	Actions element=new Actions(driver);
	WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
	element.moveToElement(Menu).perform();
	WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-water-purifier']"));
	Thread.sleep(5000);
	submenu.click();
	String s=driver.findElement(By.xpath("//*[text()='Paani ka doctor']")).getText();
	try {
	Assert.assertEquals(s,"Paani ka doctor");
	Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
	System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
	}catch(Exception e) {
	Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
	System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
	 Assert.fail();
	}finally {
		fil.click(Logo, "click on logo");	
	}
	}
	
	public void L1_Vacuum_Cleaners() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-vaccum-cleaner']"));
		Thread.sleep(5000);
		submenu.click();
		String s=driver.findElement(By.xpath("//*[text()='Vacuum Cleaners for all your needs']")).getText();
		try {
		Assert.assertEquals(s,"Vacuum Cleaners for all your needs");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		 Assert.fail();
		}finally {
			fil.click(Logo, "click on logo");	
		}
		}
	public void L1_Coronaguard() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-coronaguard']"));
		Thread.sleep(5000);
		submenu.click();
		String s=driver.findElement(By.xpath("//*[text()='What is Coronaguard?']")).getText();
		try {
		Assert.assertEquals(s,"What is Coronaguard?");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		 Assert.fail();
		}finally {
			fil.click(Logo, "click on logo");	
		}
		}	
	public void L1_Air_Purifiers() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-air-purifier']"));
		Thread.sleep(5000);
		submenu.click();
		String s=driver.findElement(By.xpath("//*[text()='Forbes HPA 500']")).getText();
		try {
		Assert.assertEquals(s,"Forbes HPA 500");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		 Assert.fail();
		}finally {
			fil.click(Logo, "click on logo");	
		}
		}
	public void L1_Water_Solution() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-water-solution']"));
		Thread.sleep(5000);
		submenu.click();
		String s=driver.findElement(By.xpath("//*[text()='An easy fix for hard water. Turn every tap in']")).getText();
		try {
		Assert.assertNotEquals(s,"An easy fix for hard water. Turn every tap in");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}}	
	public void L2_Water_Solution() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-water-purifier']"));
		Thread.sleep(5000);
		element.moveToElement(submenu).perform();
		WebElement submenu1=driver.findElement(By.xpath("//*[@id='main-close']/li[1]/ul/li[1]/a/span"));
		submenu1.click();
		String s=driver.findElement(By.xpath("//*[@id='page-title-heading']/span")).getText();
		try {
		Assert.assertEquals(s,"Water Purifiers");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}}
	public void L2_Vaccum_cleaner() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-vaccum-cleaner']"));
		Thread.sleep(5000);
		element.moveToElement(submenu).perform();
		WebElement submenu1=driver.findElement(By.xpath("//*[@id='main-close']/li[2]/ul/li[1]/a/span"));
		submenu1.click();
		String s=driver.findElement(By.xpath("//*[@id='page-title-heading']/span")).getText();
		try {
		Assert.assertEquals(s,"Vacuum Cleaners");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}}
	public void L2_Air_Purifiers() throws InterruptedException {
		fil.waitForElement(Menu);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions element=new Actions(driver);
		WebElement Menu=driver.findElement(By.xpath("//*[text()='Products']"));
		element.moveToElement(Menu).perform();
		WebElement submenu=driver.findElement(By.xpath("//*[@class='icon-air-purifier']"));
		Thread.sleep(5000);
		element.moveToElement(submenu).perform();
		WebElement submenu1=driver.findElement(By.xpath("//*[@id='main-close']/li[4]/ul/li[1]/a/span"));
		submenu1.click();
		String s=driver.findElement(By.xpath("//*[@id='page-title-heading']/span")).getText();
		try {
		Assert.assertEquals(s,"Air Purifiers");
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		}catch(Exception e) {
		Reporter.log(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		System.err.println(">>>>>>>>>verify successfully "+s+" Match with expexted value");
		Assert.fail();
		}finally {
		fil.click(Logo, "click on logo");	
		}}
public void learNMore(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData) throws Throwable {
	fil.waitFixedTime(10);
	if(WayToClickOnMenu.equalsIgnoreCase("Search")) {
	this.Search(SearchData,selectData);
	}
	else if(WayToClickOnMenu.equalsIgnoreCase("Demo")) {
	//this.Demo(WayToClickOnMenu,PinCodeData,FullNameData,MobileNumberData);	
	}
	else {
	this.Menu();
	//fil.waitFixedTime(2);
	//fil.click(image1, "Click on image");
	
	   }
	fil.click(ViewMore, "click Learn more");
	String s=driver.findElement(By.xpath("//*[@class='incl-price']")).getText();
	try {
		Assert.assertEquals( s, "MRP incl. of all taxes and shipping");
		System.err.println("Learn more working properly with expected value"+s);
		Reporter.log("Learn more working properly with expected value"+s);
	}
		catch(Exception e) {
			
			System.err.println("Learn more not working properly with expected value"+s);
			Reporter.log("Learn more working not properly with expected value"+s);	
			Assert.fail();
		}finally {
			driver.navigate().back();
		}
}

}
