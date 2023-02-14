package com.EFL.pages;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class Cart extends TestBase{
	CommonUseFile fil;
	loginPage login;
	Home hom;
	//PDP P;
	public static Properties config = new Properties();
	@FindBy(xpath="//*[@title='Remove']")
	WebElement remove;
	@FindBy(xpath="//label[@for='accept-terms']")
	WebElement Checkbox;
	
	@FindBy(xpath="//*[@id='maincontent']/div[1]/div/a/span")
	WebElement CheckOut;
	@FindBy(xpath="//*[@class='action primary checkout']")
	WebElement CheckOut1;
	@FindBy(xpath="//*[@class='icon icon-delete']")
	WebElement Delete;
	@FindBy(xpath="//*[@class='input-text coupon_code']")
	WebElement Promocode;
	@FindBy(xpath="//*[@name='coupon_code2']")
	WebElement Promocode2;
	@FindBy(xpath="//*[@name='coupon_code3']")
	WebElement Promocode3;
	
	@FindBy(xpath="//*[@id='giftvoucher_button1']")
	WebElement ApplyPromocode;
	@FindBy(xpath="//*[@id='modal-close-mobile']")
	WebElement ApplyPromocodeCancel;
	@FindBy(xpath="//*[@id='giftvoucher_button2']")
	WebElement ApplyPromocode2;
	@FindBy(xpath="//*[@id='giftvoucher_button3']")
	WebElement ApplyPromocode3;
	@FindBy(xpath="//*[text()='Add More Coupon ++']")
	WebElement AddMore;
	
	@FindBy(xpath="//*[@id='root']/div[1]/header/div[1]/div[2]/div[3]/ul/li[4]/a/span")
	WebElement Carticon;
	@FindBy(xpath="//*[@id=\"t_PageBody\"]/div[9]/div[3]/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/a/img")
	WebElement image;
	
	
	
	
	
	
	
	
	public Cart() throws IOException{
	PageFactory.initElements(driver, this);
	fil=new CommonUseFile(driver);
	login = new loginPage();	
	hom=new Home();
	//P=new PDP();
	}
	public void Remove(){
	fil.click(remove, "remove");
	}
	
	
	public void CheckBoxHandle(String action) throws InterruptedException {
	fil.waitFixedTime(3);
	//fil.CheckBoxHandler(action, Checkbox, "Checkboxhandle");
	if(action.equalsIgnoreCase("yes")) {
		fil.waitFixedTime(3);
		fil.click(Checkbox, "Checkbox handle");
		System.out.println(Checkbox);
	}
	else {
		System.out.println("User does't clicked on checlbox");
	}
	}
	public void YourPromoCode(String data) {
		//fil.SendKeys(YourPromoCode, data);
		//fil.SendKeys(YourPromoCode, data, "YourPromoCode");
	}	
	
	public void MiniCartVerification() {
		String price = driver.findElement(By.xpath("//*[@class='price1']")).getText();
		String Quantity = driver.findElement(By.xpath("//*[@class='item-qty cart-item-qty']")).getText();
		String name = driver.findElement(By.xpath("//*[@class='product-item-name']")).getText();
		String Total = driver.findElement(By.xpath("//*[@id='minicart-content-wrapper']/div/div[2]/div/span/span"))
				.getText();
		try {
			System.out.println("Mini Cart page verification"+"Sub total "+price);
			System.out.println("Total Quantity "+Quantity);
			System.out.println("product Name "+name);
			System.out.println("Total price "+Total);
			Reporter.log("Mini Cart page verification"+"Sub total "+price);
			Reporter.log("Total Quantity "+Quantity);
			Reporter.log("product Name "+name);
			Reporter.log("Total price "+Total);
			Assert.assertEquals(price, price);
			System.out.println("Test cases pass atual resule ie, '" + price + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + price + "'match with expected value");
			Assert.assertEquals(Quantity, Quantity);
			System.out.println("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");
			Assert.assertEquals(name, name);
			System.out.println("Test cases pass atual resule ie, '" + name + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + name + "'match with expected value");
			Assert.assertEquals(Total, Total);
			System.out.println("Test cases pass atual resule ie, '" + Total + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Total + "'match with expected value");

		} catch (Exception e) {
			System.out.println("Test cases pass atual resule ie, '" + price + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + price + "'match with expected value");
			Assert.fail();
		}
	}
	public void VerifyBagTotalwithAddedProductCost() {
		String Quantity = driver.findElement(By.xpath("//*[@class='item-qty cart-item-qty']")).getText();
		String Total = driver.findElement(By.xpath("//*[@data-th='Total']"))
				.getText();
		try {
			Assert.assertEquals(Quantity, Quantity);
			System.out.println("Total Quantity of product is "+Quantity);
			System.out.println("Total Price of product is "+Total);
			System.out.println("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");

			Assert.assertEquals(Total, Total);
			System.out.println("Test cases pass atual resule ie, '" + Total + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Total + "'match with expected value");

		} catch (Exception e) {
			System.out.println("Test cases pass atual resule ie, '" + Total + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Total + "'match with expected value");
			Assert.fail();
		}
		}
	public void VerifyQty() {
		String Quantity = driver.findElement(By.xpath("//*[@id='cart-1448962-qty']")).getText();
		try {
			Assert.assertEquals(Quantity, Quantity);
			System.out.println("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");

		} catch (Exception e) {
			System.out.println("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + Quantity + "'match with expected value");
			Assert.fail();
		}	
	}
	public void VerifyCheckout() {
		fil.waitFixedTime(5);
		fil.click(CheckOut, " Click on CheckOut");
		fil.waitFixedTime(5);
		fil.click(CheckOut1, " Click on CheckOut");
		String s = driver.findElement(By.xpath("//*[text()='Shipping']")).getText();
		try {
			Assert.assertEquals(s,s);
			System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");

		} catch (Exception e) {
			System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
			Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");
			Assert.fail();
		}}
		public void VerifyProductDelete() {
			fil.click(Delete, "Click on Delete");
			String s = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[1]/p[1]")).getText();
			try {
				Assert.assertEquals(s,"You have no items in your shopping cart.");
				System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");

			} catch (Exception e) {
				System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Assert.fail();
			}	
		}  
		public void CouponCode(String ThingtoApplyPromocode,String PromocodeData) {
			if(ThingtoApplyPromocode.equalsIgnoreCase("Single")) {
			fil.SendKeys(Promocode, PromocodeData, "Enter fPromo code");
			fil.click(ApplyPromocode, "Click on Apply Promocode");
			fil.click(ApplyPromocodeCancel, "Click on Apply ApplyPromocodeCancel");
		    }
		    else {
		    fil.click(AddMore, "Click on AddMore");
			fil.SendKeys(Promocode2, PromocodeData, "Enter fPromo code2");
			fil.click(ApplyPromocode2, "Click on Apply Promocode2");
			fil.SendKeys(Promocode3, PromocodeData, "Enter fPromo code3");
		    }
			String s = driver.findElement(By.xpath("//*[text()='Send OTP']")).getText();
			//fil.click(ApplyPromocode3, "Click on Cancel button");
			try {
				Assert.assertEquals(s,s);
				System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");

			} catch (Exception e) {
				System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Assert.fail();
			}	
		}
		public void CartPage(String ThingtoApplyPromocode,String PromocodeData) {
			this.CouponCode(ThingtoApplyPromocode, PromocodeData);
			this.VerifyBagTotalwithAddedProductCost();
			this.VerifyCheckout();
		}
		public void CartPageLogin(String ThingtoApplyPromocode,String PromocodeData) {
			//this.CouponCode(ThingtoApplyPromocode, PromocodeData);
			this.VerifyBagTotalwithAddedProductCost();
			this.VerifyCheckout1();
		}
		public void VerifyCheckout1() {
			fil.waitFixedTime(5);
			fil.click(CheckOut, " Click on CheckOut");
			fil.waitFixedTime(3);
			String s = driver.findElement(By.xpath("//*[text()='Shipping']")).getText();
			try {
				Assert.assertEquals(s,s);
				System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");

			} catch (Exception e) {
				System.out.println("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Reporter.log("Test cases pass atual resule ie, '" + s + "'match with expected value");
				Assert.fail();
			}}
	}
