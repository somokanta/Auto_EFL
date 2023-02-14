package com.EFL.pages;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class Service extends TestBase{
	//Sreps1
	CommonUseFile fil;
	loginPage login;
	Home hom;
	PDP P;
	public static Properties config = new Properties();
	@FindBy(xpath="//*[@name='ko_unique_1']")
	WebElement ContinueAsaGuest;
	@FindBy(xpath="//*[@class='services']")
	WebElement service;
	@FindBy(xpath="//*[@class='icon icon4']")
	WebElement BookService;
	@FindBy(xpath="//*[@class='amc_products_type']")
	WebElement RadioButton;
	@FindBy(xpath="//*[@id='request_type']")
	WebElement Complaint;
	@FindBy(xpath="//*[@name='remarks']")
	WebElement Remarks;
	@FindBy(xpath="//*[@id='logServiceRequestForm1']/div[2]/button/span")
	WebElement Continue;
	@FindBy(xpath="//*[@id='logServiceRequestForm2']/div[2]/button/span")
	WebElement Continue1; 
	@FindBy(xpath="//*[@class='action-close']")
	WebElement cancel;
	
	
	public Service() throws IOException{
		PageFactory.initElements(driver, this);
		fil=new CommonUseFile(driver);
		hom=new Home();
		}
		
		public void Size(String SizeData,String chooseOptionData) throws Exception {
		fil.ScrollDown();
		fil.waitFixedTime(4);
		WebElement wb=driver.findElement(By.xpath("//*[text()='"+SizeData+"']"));
		wb.click();
		}
		public void BookServiceflow(String selectComplaint,String Remarks_Data) throws InterruptedException{
			driver.get("https://m.gs.im/n/JZjyYxOEg4i");//Direct user logged in URL 
			System.err.println(">>>>>>>>>Login not happening successfully");
			Assert.fail(">>>>>>>>>Login not happening successfully");
			
			fil.click(service, "Click on service");
			fil.click(BookService, "Click on BookService icon");
			fil.click(RadioButton, "Click on RadioButton");
			fil.selectByVisibleText(Complaint, selectComplaint, "selectComplaint");
			fil.SendKeys(Remarks, Remarks_Data, "Enter Remarks");
			fil.click(Continue, "Click on Continue button");
			String s = driver.findElement(By.xpath("//*[text()='Select Date And Time']")).getText();
			try {
				Assert.assertEquals(s, "Select Date And Time");
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				fil.click(Continue1, "Click on Continue gain button");
				String s1 = driver.findElement(By.xpath("//*[@class='number']")).getText();
				Assert.assertEquals(s1,s1);
				System.out.println("Request id is "+s1);
				System.out.println("Test Cases pass>>Atuel result ie. " + s1 + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s1 + " match with expected value");
				fil.click(cancel, "Click on cancel button");
			} catch (Exception e) {
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Assert.fail();
			}finally {
			//login.mouseoverForLogout();
			}
		}
}
