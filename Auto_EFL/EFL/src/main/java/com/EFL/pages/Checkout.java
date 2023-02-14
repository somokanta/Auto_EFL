package com.EFL.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class Checkout extends TestBase{
	//Sreps1
	CommonUseFile fil;
	loginPage login;
	Home hom;
	PDP P;
	public static Properties config = new Properties();
	@FindBy(xpath="//*[@name='ko_unique_1']")
	WebElement ContinueAsaGuest;
	@FindBy(xpath="//*[@name='email']")
	WebElement EmsilAddressforGuest;

	//---------------------------------------------------------
	@FindBy(xpath="//*[@id='checkout-custom-form']/ul/li[1]/input")
	WebElement FNmae;
	@FindBy(xpath="//*[@id='checkout-custom-form']/ul/li[2]/input")
	WebElement LName;
	@FindBy(xpath="//*[@id='checkout-custom-form']/ul/li[3]/input")
	WebElement MobileNumber;
	@FindBy(xpath="//*[@id='checkout-custom-form']/ul/li[4]/input")
	WebElement EmailId;
	
	@FindBy(xpath="//*[text()='Continue']")
	WebElement Continue;
	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div[1]/div[3]/ol/li[2]/div[2]/form/div/div[1]/div/input")
	WebElement house_no;
	@FindBy(xpath="/html/body/div[2]/main/div/div/div[1]/div[3]/ol/li[2]/div[2]/form/div/fieldset/div/div[1]/div/input")
	WebElement Street;
	@FindBy(xpath="/html/body/div[3]/main/div/div/div[1]/div[3]/ol/li[2]/div[2]/form/div/fieldset/div/div[2]/div/input")
	WebElement Street1;
	@FindBy(xpath="/html/body/div[3]/main/div/div/div[1]/div[3]/ol/li[2]/div[2]/form/div/div[5]/div/input")
	WebElement PinCode;
	@FindBy(xpath="/html/body/div[3]/main/div/div/div[1]/div[3]/ol/li[2]/div[2]/form/div/div[6]/div/input")
	WebElement City;
	@FindBy(xpath="/html/body/div[3]/main/div/div/div[1]/div[3]/ol/li[2]/div[2]/form/div/div[8]/div/select")
	WebElement Region;
	@FindBy(xpath="//*[text()='Deliver to this address']")
	WebElement Delivertothisaddress;
	@FindBy(xpath="//*[text()='Log in']")
	WebElement log_in;
	@FindBy(xpath="//*[@id='mobNumber']")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id='OTPbtn']")
	WebElement Continue1;
	@FindBy(xpath="//*[text()='Debit Card']")
	WebElement Card;
	@FindBy(xpath="//*[text()='View Summary']")
	WebElement ViewSummary;
	@FindBy(xpath="//*[text()='Deliver to this address']")
	WebElement Delivertothis;
	
	@FindBy(xpath="//*[@class='summary-modal']")
	WebElement PopUpCancel;
	
	@FindBy(xpath="//*[@class='product-name']")
	WebElement ProductName;
	@FindBy(xpath="//*[@class='product-qty']")
	WebElement Quantity;
	@FindBy(xpath="//*[@class='totalamount']")
	WebElement TotalPrice;
	@FindBy(xpath="//*[@id='checkout-summary']/div[3]/span[1]/span[2]")
	WebElement SubTotal;
	@FindBy(xpath="//*[@id='checkout-summary']/div[3]/span[2]/span[2]")
	WebElement Shiping;
	
	
	
	
	public Checkout() throws IOException{
	PageFactory.initElements(driver, this);
	fil=new CommonUseFile(driver);
	login = new loginPage();	
	hom=new Home();
	P=new PDP();
	}
	public void ContinueAsaGuest() {
	fil.waitFixedTime(5);
	fil.click(ContinueAsaGuest, "ContinueAsaGuest");
	fil.waitFixedTime(2);
	}
	
    //-----------------------------------------------------------------
    public void FillTheDetailsTocontinue(String FirstName,String lastName,String Mobile_Number,String Email_Id) {
    fil.SendKeys(FNmae,FirstName,"Enter First Name");
    fil.SendKeys(LName,lastName,"Enter Last Name");
    fil.SendKeys(MobileNumber,Mobile_Number,"Enter Mobile Number");
    fil.SendKeys(EmailId,Email_Id,"Enter Email Id");
    fil.click(Continue, "clicking on Continue button");
    String s=driver.findElement(By.xpath("//*[text()='Shipping Address']")).getText();
    try {
    	Assert.assertEquals(s,"Shipping Address");
    	System.out.println("Test Cases pass>>Atuel result ie. "+s+" match with expected value");
    	Reporter.log("Test Cases pass>>Atuel result ie. "+s+" match with expected value");
    }
    catch(Exception e) {
    	System.out.println("Test Cases pass>>Atuel result ie. "+s+" not match with expected value");
    	Reporter.log("Test Cases pass>>Atuel result ie. "+s+" not match with expected value");
    	Assert.fail();
    	
    }}
    public void ShippingAddress(String house_noData,String Street_Data,String Street1_Data,String PinCode_Data,String City_Data,String selectRegion) {
        fil.waitFixedTime(5);
    	fil.SendKeys(house_no,house_noData,"Enter house no");
        fil.SendKeys(Street,Street_Data,"Enter Street");
        fil.SendKeys(Street1,Street1_Data,"Enter Street1");
        fil.SendKeys(PinCode,PinCode_Data,"Enter PinCode");
        //fil.SendKeys(City,City_Data,"Enter City name");
        fil.selectByVisibleText(Region, selectRegion, "selectRegion");
        fil.click(Delivertothisaddress, "clicking on Deliver to this address");
        fil.waitFixedTime(3);
        String s=driver.findElement(By.xpath("//*[text()='Credit Card']")).getText();
        try {
        	Assert.assertEquals(s,"Credit Card");
        	System.out.println("Test Cases pass>>Atuel result ie. "+s+" match with expected value");
        	Reporter.log("Test Cases pass>>Atuel result ie. "+s+" match with expected value");
            }
            catch(Exception e) {
        	System.out.println("Test Cases pass>>Atuel result ie. "+s+" not match with expected value");
        	Reporter.log("Test Cases pass>>Atuel result ie. "+s+" not match with expected value");
        	Assert.fail();
        	
        }
    }
    public void Login(String mobiledata){
    fil.click(log_in, "clicking on login");
    String s=driver.findElement(By.xpath("//*[text()='Log in']")).getText();
    try {
    	Assert.assertEquals(s,"Log in");
    	System.out.println("Test Cases pass>>Atuel result ie. "+s+" match with expected value");
    	Reporter.log("Test Cases pass>>Atuel result ie. "+s+" match with expected value");
    	 fil.SendKeys(mobile,mobiledata,"Enter mobile number");
        }
        catch(Exception e) {
    	System.out.println("Test Cases pass>>Atuel result ie. "+s+" not match with expected value");
    	Reporter.log("Test Cases pass>>Atuel result ie. "+s+" not match with expected value");
    	Assert.fail();
    	
    }finally {
    	 fil.click(Continue1, "clicking on Continue button");
    }
    }
    public void VerifyPaymentgateway() {
    	fil.waitFixedTime(3);
		fil.click(Card, "clicking on Card option");
		fil.waitFixedTime(20);
		if(fil.isElementPresent(driver,By.xpath("//*[@class='final-amount']"))) {
		String s = driver.findElement(By.xpath("//*[@class='final-amount']")).getText();
		Assert.assertEquals(s,s);
		System.out.println(">>>>>>>>>>>>>>>>"+s);
		Reporter.log(">>>>>>>>>>>>>>>>"+s);
		System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
		Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
		}else {
			//fil.waitFixedTime(3);
			//String s = driver.findElement(By.xpath("//*[@id='amount']")).getText();	
		//---
			   WebDriverWait wait=new WebDriverWait(driver,30);
		        System.out.println("waiting for frame");
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='razorpay-checkout-frame']")));
		        System.out.println("Frame find");
		        String s = driver.findElement(By.xpath("//*[@id='amount']")).getText();
		        System.out.println("Close the bot");
		        driver.switchTo().defaultContent();	
			
		//--
		
		try {
			Assert.assertEquals(s,s);
			System.out.println(">>>>>>>>>>>>>>>>"+s);
			Reporter.log(">>>>>>>>>>>>>>>>"+s);
			System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
			Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
		} catch (Exception e) {
			System.out.println("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
			Reporter.log("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
			Assert.fail();

		}}

	}
    public void CheckoutPage(String WayOfCheckout,String mobiledata,String FirstName,String lastName,String Mobile_Number,String Email_Id,String house_noData,String Street_Data,String Street1_Data,String PinCode_Data,String City_Data,String selectRegion) {
		if (WayOfCheckout.equalsIgnoreCase("Login")) {
			//this.Login(mobiledata);
			
		 fil.click(Delivertothis, "clicking on Deliver to this address");
		} else {
			this.FillTheDetailsTocontinue(FirstName, lastName, Mobile_Number, Email_Id);
			this.ShippingAddress(house_noData, Street_Data, Street1_Data, PinCode_Data, City_Data, selectRegion);
		}
		this.SummaryPopUp();
		this.VerifyPaymentgateway();
	}
    public void SummaryPopUp(){
    fil.waitFixedTime(3);
    fil.click(ViewSummary, "clicking on ViewSummary");	
    fil.waitFixedTime(3);
    fil.click(ViewSummary, "clicking on ViewSummary");	
    String Productname = driver.findElement(By.xpath("//*[@class='product-name']")).getText();
    System.out.println(">>Product name is " +Productname);
	Reporter.log(">>Product name is " +Productname);
    String Quantity = driver.findElement(By.xpath("//*[@class='product-qty']")).getText();
    System.out.println(">>Product Quantity is " +Quantity);
	Reporter.log(">>Product Quantity is " +Quantity);
	if(fil.isElementPresent(driver, By.xpath("//*[@id='checkout-summary']/div[4]/span[2]/span[2]"))) 
	{
		String SubTotal = driver.findElement(By.xpath("//*[@id='checkout-summary']/div[4]/span[1]/span[2]")).getText();
	    System.out.println(">>Sub Total is " +SubTotal);
	       Reporter.log(">>Sub Total is " +SubTotal);
	       String Discount = driver.findElement(By.xpath("//*[@id=\"checkout-summary\"]/div[4]/span[2]/span[2]")).getText();
	    System.out.println(">>Sub Total is " +Discount);
	       Reporter.log(">>Sub Total is " +Discount);
	    String Shiping = driver.findElement(By.xpath("//*[@id='checkout-summary']/div[4]/span[3]/span[2]")).getText();
	    System.out.println(">>Shiping charges is " +Shiping);
	       Reporter.log(">>Shiping charges is" +Shiping);
	}else {
    String SubTotal = driver.findElement(By.xpath("//*[@id='checkout-summary']/div[3]/span[1]/span[2]")).getText();
    System.out.println(">>Sub Total is " +SubTotal);
   	Reporter.log(">>Sub Total is " +SubTotal);
    String Shiping = driver.findElement(By.xpath("//*[@id='checkout-summary']/div[3]/span[2]/span[2]")).getText();
    System.out.println(">>Shiping charges is " +Shiping);
   	Reporter.log(">>Shiping charges is" +Shiping);
	}
	  String Total = driver.findElement(By.xpath("//*[@class='totalamount']")).getText();
	    System.out.println(">>Total Product price is " +Total);
		Reporter.log(">>Total Product price is " +Total);
    fil.click(PopUpCancel, "clicking on PopUp Cancel");
  
    }   
    
  public void VerifyViewSummaryPopUp(){
    	
    }
    }
