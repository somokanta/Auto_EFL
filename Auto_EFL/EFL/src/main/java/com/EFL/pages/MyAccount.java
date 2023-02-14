package com.EFL.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class MyAccount extends TestBase {
	CommonUseFile fil;
	loginPage login;
	// Page Factory created
	// public static Object Logn ="//*[text()='Login']";
	@FindBy(xpath = "//*[@id='slick-slide-control00']")
	WebElement Hmbanner1;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[5]/div/div/div[1]/div/a")
	WebElement shopsweater;
	@FindBy(xpath = "//*[text()='My Account']")
	WebElement MyAccount;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[5]/div[1]/div/a/p")
	WebElement ViewAll;
	@FindBy(xpath = "//*[@class='MuiButtonBase-root MuiButton-root MuiButton-text save-or-edit-address-button']")
	WebElement AddAdress;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/div/div")
	WebElement Country;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[3]/div/div/div")
	WebElement CityC;
	@FindBy(xpath = "//*[text()='Prefix']")
	WebElement prefix;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[6]/div/div/div[2]/div[2]/div/input")
	WebElement PhoneNumber;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[4]/div/div/input")
	WebElement Fname;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[5]/div/div/input")
	WebElement Lname;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[7]/div/div/input")
	WebElement Apartment;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[8]/div/div/input")
	WebElement Address;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[9]/div/div/input")
	WebElement Area;
	@FindBy(xpath = "//*[text()='Save']")
	WebElement Save;
	@FindBy(xpath = "//*[@id='root']/div[1]/header/div[1]/div[2]/div[2]/div/a/img")
	WebElement Logo;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/div/span/img")
	WebElement Delete;

	@FindBy(xpath = "//*[text()='Yes']")
	WebElement Ok;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/div/button/img")
	WebElement Edit;
	
	
	
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div")
	WebElement ECountry;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div")
	WebElement ECityC;
	@FindBy(xpath = "//*[text()='051']")
	WebElement Eprefix;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[6]/div/div/div[2]/div[2]/div/input")
	WebElement EPhoneNumber;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[4]/div/div/input")
	WebElement EFname;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[5]/div/div/input")
	WebElement ELname;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/input")
	WebElement EApartment;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[8]/div/div/input")
	WebElement EAddress;
	@FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div/div/div/div/div/div/div[9]/div/div/input")
	WebElement EArea;
	@FindBy(xpath = "//*[text()='Save']")
	WebElement ESave;
	

	public MyAccount() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		fil = new CommonUseFile(driver);
		// cm=new CommonLocator();
		login = new loginPage();
	}

	public void AddAddress(String Delivery, String CountryData, String CityData, String prefixData,
			String PhoneNumberData, String FirstName, String LastName, String ApartmentData, String AddressData,
			String AreaData) throws Exception {
		login.login(prop.getProperty("EmailAddress"), prop.getProperty("Password"));

		fil.click(MyAccount, "click on the MyAccount tab");
		fil.ScrollDown();
		fil.ScrollDown();
		fil.click(ViewAll, "Click on the ViewAll link");
		
		fil.click(AddAdress, "Click on the AddAdress link");
		fil.waitFixedTime(1);
		
		  WebElement wb2=driver.findElement(By.xpath("//*[text()='"+Delivery+"']"));
		  wb2.click();
		 
		fil.click(Country, "Click on country");
		WebElement wb = driver.findElement(By.xpath("//*[text()='" + CountryData + "']"));
		wb.click();
		fil.click(CityC, "Click on City");
		WebElement wb1 = driver.findElement(By.xpath("//*[@id='menu-']/div[3]/ul/li[4]"));
		wb1.click();
		fil.SendKeys(Fname, FirstName, "Enter FirstName");
		fil.SendKeys(Lname, LastName, "Enter LastName");

		fil.waitFixedTime(5);
		fil.click(prefix, "Click on prefixData");
		fil.waitFixedTime(1);
		WebElement wb4 = driver.findElement(By.xpath("//*[text()='" + prefixData + "']"));
		fil.waitFixedTime(1);
		wb4.click();
		fil.waitFixedTime(5);
		fil.SendKeys(PhoneNumber, PhoneNumberData, "Enter mobile number");
		fil.waitFixedTime(5);
		fil.SendKeys(Apartment, ApartmentData, "Enter Apartment");
		fil.SendKeys(Address, AddressData, "Enter Address");
		fil.SendKeys(Area, AreaData, "Enter Area");
		fil.click(Save, "Click on Save button");
		fil.waitFixedTime(3);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		fil.waitFixedTime(3);
		String s = driver.findElement(By.xpath("//*[text()='hulesh kumar']")).getText();
		try {
			if (s.equalsIgnoreCase("hulesh kumar")) {
				System.out.println("Address added successfully");
				Reporter.log("Address added successfully");
				fil.click(Delete, "Click for delete the adderess");
				fil.waitFixedTime(3);
				fil.click(Ok, "Click on ok button and handle the popup");
				fil.waitFixedTime(5);
			} else {
				System.out.println("Address Not added successfully");
				Reporter.log("Address added Not successfully");
				fil.click(Delete, "Click for delete the adderess");
				fil.waitFixedTime(3);
				fil.click(Ok, "Click on ok button and handle the popup");
				fil.waitFixedTime(5);
			}
			Assert.assertNotEquals(s, "hulesh kumar\r\n"
					+ "work");
		} catch (Exception e) {
			Assert.fail();
		} finally {
			fil.click(Logo, "click on logo");
			login.mouseoverForLogout();
		}
	}
	public void EditAddress(String Delivery, String CountryData, String CityData, String prefixData,
			String PhoneNumberData, String FirstName, String LastName, String ApartmentData, String AddressData,
			String AreaData) throws Exception {
		login.login(prop.getProperty("EmailAddress"), prop.getProperty("Password"));
		fil.click(MyAccount, "click on the MyAccount tab");
		fil.ScrollDown();
		fil.ScrollDown();
		fil.click(ViewAll, "Click on the ViewAll link");
		fil.click(AddAdress, "Click on the AddAdress link");
		fil.waitFixedTime(1);
		  WebElement wb2=driver.findElement(By.xpath("//*[text()='"+Delivery+"']"));
		  wb2.click();
		fil.click(Country, "Click on country");
		WebElement wb = driver.findElement(By.xpath("//*[text()='" + CountryData + "']"));
		wb.click();
		fil.click(CityC, "Click on City");
		WebElement wb1 = driver.findElement(By.xpath("//*[@id='menu-']/div[3]/ul/li[4]"));
		wb1.click();
		fil.SendKeys(Fname, FirstName, "Enter FirstName");
		fil.SendKeys(Lname, LastName, "Enter LastName");
		fil.waitFixedTime(5);
		fil.click(prefix, "Click on prefixData");
		fil.waitFixedTime(1);
		WebElement wb4 = driver.findElement(By.xpath("//*[text()='" + prefixData + "']"));
		fil.waitFixedTime(1);
		wb4.click();
		fil.waitFixedTime(5);
		fil.SendKeys(PhoneNumber, PhoneNumberData, "Enter mobile number");
		fil.waitFixedTime(5);
		fil.SendKeys(Apartment, ApartmentData, "Enter Apartment");
		fil.SendKeys(Address, AddressData, "Enter Address");
		fil.SendKeys(Area, AreaData, "Enter Area");
		fil.click(Save, "Click on Save button");
		fil.waitFixedTime(3);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		fil.waitFixedTime(3);
		String s = driver.findElement(By.xpath("//*[text()='hulesh kumar']")).getText();
		try {
			if (s.equalsIgnoreCase("hulesh kumar")) {
				System.out.println("Address added successfully");
				Reporter.log("Address added successfully");
			} else {
				System.out.println("Address Not added successfully");
				Reporter.log("Address added Not successfully");
			}
			Assert.assertNotEquals(s, "hulesh kumar");
		} catch (Exception e) {
			Assert.fail();
		} finally {
			fil.click(Edit, "click on Edit");
			this.EditF(Delivery, CountryData, CityData, prefixData, PhoneNumberData, FirstName, LastName, ApartmentData, AddressData, AreaData);
			fil.click(Logo, "click on logo");
			login.mouseoverForLogout();
		}
	}
	public void EditF(String Delivery, String CountryData, String CityData, String prefixData,
			String PhoneNumberData, String FirstName, String LastName, String ApartmentData, String AddressData,
			String AreaData) {
		fil.waitFixedTime(1);
		
		  WebElement wb2=driver.findElement(By.xpath("//*[text()='"+Delivery+"']"));
		  wb2.click();
		 
			/*
			 * fil.click(ECountry, "Click on country"); WebElement wb =
			 * driver.findElement(By.xpath("//*[text()='" + CountryData + "']"));
			 * wb.click();
			 */
		fil.click(ECityC, "Click on City");
		WebElement wb1 = driver.findElement(By.xpath("//*[@id='menu-']/div[3]/ul/li[115]"));
		wb1.click();
		fil.SendKeys(EFname, FirstName, "Enter FirstName");
		fil.SendKeys(ELname, LastName, "Enter LastName");

		fil.waitFixedTime(5);
		//fil.click(Eprefix, "Click on prefixData");
		/*
		 * fil.waitFixedTime(1); WebElement wb4 =
		 * driver.findElement(By.xpath("//*[text()='" + prefixData + "']"));
		 * fil.waitFixedTime(1); wb4.click(); fil.waitFixedTime(5);
		 * fil.SendKeys(EPhoneNumber, PhoneNumberData, "Enter mobile number");
		 */
		fil.waitFixedTime(5);
		fil.SendKeys(EApartment, ApartmentData, "Enter Apartment");
		fil.SendKeys(EAddress, AddressData, "Enter Address");
		fil.SendKeys(EArea, AreaData, "Enter Area");
		fil.waitFixedTime(3);
		fil.click(ESave, "Click on Save button");
		fil.waitFixedTime(3);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		fil.waitFixedTime(3);
		String s = driver.findElement(By.xpath("//*[text()='huleshhulesh kumarkumar']")).getText();
			if (s.equalsIgnoreCase("huleshhulesh kumarkumar")) {
				System.out.println("Address added successfully");
				Reporter.log("Address added successfully");
				fil.click(Delete, "Click for delete the adderess");
				fil.waitFixedTime(3);
				fil.click(Ok, "Click on ok button and handle the popup");
				fil.waitFixedTime(5);
			} else {
				System.out.println("Address Not added successfully");
				Reporter.log("Address Edited successfully");
				fil.click(Delete, "Click for delete the adderess");
				fil.waitFixedTime(3);
				fil.click(Ok, "Click on ok button and handle the popup");
				fil.waitFixedTime(5);
			}}}
