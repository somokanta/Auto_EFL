package com.EFL.pages;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class PDP extends TestBase{
	//Sreps1
	CommonUseFile fil;
	Home hom;
	Cart c;
	@FindBy(xpath="//*[@id='root']/div[1]/header/div[1]/div[2]/div[2]/div/a/img")
	WebElement Logo;
	@FindBy(xpath="//*[@id='amasty-shopby-product-list/]/div[2]/ol/li[1]/div/div/div/div[5]/div/div[2]/a/button/span")
	WebElement ViewMore;
	////////////////miniCart page
	@FindBy(xpath="//*[@id='root']/div[1]/header/div[1]/div[2]/div[3]/ul/li[4]/a/span")
	WebElement oldPrice;
	@FindBy(xpath="//*[@class='minus minus-cart-item']")
	WebElement currentPrice;
	@FindBy(xpath="//*[@class='plus update-cart-item']")
	WebElement Plus;
	@FindBy(xpath="//*[text()='View all']")
	WebElement ViewCart;
	
	@FindBy(xpath="//*[@id='block-discount']/div[1]/span[2]")
	WebElement Maxmise;
	@FindBy(xpath="//*[@id='coupon_code']")
	WebElement promocode1;
	@FindBy(xpath="//*[@id='discount-coupon-form']/div/div[2]")
	WebElement applycoupon;
	
	@FindBy(xpath="//*[@id='shopping-cart-table']/tbody[1]/tr/td[1]/div/div[4]/a[1]/span")
	WebElement Editbutton;
	@FindBy(xpath="//*[@id='shopping-cart-table']/tbody[1]/tr/td[1]/div/div[4]/a[2]")
	WebElement DeleteButton;
	
	
	@FindBy(xpath="//*[@class='price-discount-percent']")
	WebElement actualPercentage;
	@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[2]/div[2]/p[2]")
	WebElement TextAmount;
	
	@FindBy(xpath="//*[@class='styles_closeIcon__1QwbI']")
	WebElement PopupLocator;
	//--------------------------------------------------------
	@FindBy(xpath="//*[text()='Add to Cart']")
	WebElement addToCart;
	@FindBy(xpath="//*[@class='icon icon-cart action showcart']")
	WebElement Minicart;
	@FindBy(xpath="//*[text()='Check Out']")
	WebElement CheckOut;
	
	@FindBy(xpath="//*[text()='Buy Now']")
	WebElement BuyNow;
	
	@FindBy(xpath="//*[@class='logo']")
	WebElement LoGo;
	@FindBy(xpath="//*[text()=' Check delivery for']")
	WebElement CheckFor;
	
	public PDP() throws IOException{
	PageFactory.initElements(driver, this);
	fil=new CommonUseFile(driver);
	hom=new Home();
	c=new Cart();
	}
	
	public void Size(String SizeData,String chooseOptionData) throws Exception {
	fil.ScrollDown();
	fil.waitFixedTime(4);
	WebElement wb=driver.findElement(By.xpath("//*[text()='"+SizeData+"']"));
	wb.click();
	}
	public void myBag(String promocode,String promocodedata,String Update,String SizeData,String chooseOptionData) throws Exception {
	if(promocode.equalsIgnoreCase("yes")) {
	fil.waitFixedTime(2);
	fil.click(Maxmise, "Maxmise name");
	fil.waitFixedTime(2);
	fil.SendKeys(promocode1, promocodedata, "promocode name");
	fil.waitFixedTime(2);
	fil.click(applycoupon, "applycoupon button");
	fil.waitFixedTime(2);
	}
	if(Update.equalsIgnoreCase("Edit")) {
	fil.waitFixedTime(2);
	fil.click(Editbutton, "Edit button");
	//this.PDPFlow(SizeData, chooseOptionData);
	}
	else if(Update.equalsIgnoreCase("delete")) {
	fil.waitFixedTime(2);
	fil.click(DeleteButton, "DeleteButton name");
	}
	fil.waitFixedTime(2);
//	fil.click(CheckOut, "CheckOut name");
	}
	
	
	public double getOldPrices() {
		String oldP=oldPrice.getText().substring(3);
		
		double oldPr=Double.parseDouble(oldP);

		return oldPr;
	}
	public double getCurrentPrices() {

		String currentP=currentPrice.getText().substring(3);

		double currentPr=Double.parseDouble(currentP);
		return currentPr;
	}
	public double getActualPercentage() {
		fil.waitFixedTime(5);
		String act=actualPercentage.getText().substring(1, 3);
		
		double actualPerc=Double.parseDouble(act);
		return actualPerc;
	}
	public double percentageCalc() {
		double perc=(this.getCurrentPrices()/this.getOldPrices())*100;
		double per=100-Math.round(perc);
		System.out.println(per);
		return per;
	}
	public void Plus() {
	fil.waitFixedTime(2);
	fil.click(Plus, "Plus Quantity");	
	}
	public void ViewCart() {
	fil.waitFixedTime(2);
	fil.click(ViewCart, "ViewBag_ button");	
	}
	
	public void AddTocart(String WayToBuy) throws Exception {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DOWN);
	fil.ScrollDown();
	fil.waitFixedTime(5);
	fil.ScrollDown();
	robot.keyPress(KeyEvent.VK_DOWN);
	
	fil.waitFixedTime(5);
	fil.ScrollDown();
	robot.keyPress(KeyEvent.VK_DOWN);
	fil.waitForElement(addToCart);
	if(WayToBuy.equalsIgnoreCase("Add to Cart")) {
	fil.click(addToCart, "add to cart button");
	fil.waitFixedTime(3);
	fil.click(Minicart, "add to cart button");
	c.MiniCartVerification();
	String s=driver.findElement(By.xpath("//*[@id='mini-cart']/table/tbody/tr[2]/td[2]/div/span")).getText();
	try {
		Assert.assertEquals(s,s);
		System.out.println("product price is '"+s+"'match  with expected value");
		Reporter.log("product price is '"+s+"'match  with expected value");
		
	}
		catch(Exception e) {
			System.out.println("product price is '"+s+"' not match  with expected value");
			Reporter.log("product price is '"+s+"' not match  with expected value");
			Assert.fail();
		}
	}
	else {
	fil.click(BuyNow, "Click on button");
	this.BuyNow();
	}	
	fil.click(CheckOut, "click on Check Out button");
	}
	public void BuyNow() {
		String S=driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/div/a/span")).getText();
		try {
			Assert.assertEquals(S,"Check Out");
			System.out.println("Buy now function working fine '"+S+"' with expected value");
			Reporter.log("Buy now function working fine '"+S+"' with expected value");	
		}
		catch(Exception e) {
			System.out.println("Buy now function working fine '"+S+"'not  with expected value");
			Reporter.log("Buy now function working fine '"+S+"' not with expected value");
			Assert.fail();
		}
		}
	public void ProductImage() {
		fil.waitFixedTime(7);
		
		//fil.click(ProductImage, "click on the product image");	
		//fil.click(addToCart, "add to cart button");
	}
	public void PDPFlow(String WayToBuy,String ExecutionMode) throws Exception {
		this.AddTocart(WayToBuy);
	}
	
	public void gettextAmount() {
		String s=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[2]/div[2]/p[2]")).getText();
		System.err.println(">>>>>>>>>>>>>>>>>>"+s);
		Reporter.log(">>>>>>>>>Total amount of the product is " +s);
	 }

//-------------Get price for all the ------------------------->>
    public void getTextAmount() {
	String s1=driver.findElement(By.xpath("//*[@class='Dropdown-placeholder is-selected']")).getText();
	//System.err.println(">>>>>>>>>>>>>>>>>>"+s1);
	String s=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[2]/div[2]/p[2]")).getText();
	System.err.println(">>>>>>>>>>>>>>>>>>"+s);
	Reporter.log(">>>>>>>>>Total amount of the" +s1+ "product is " +s);
    }
    

    public void PriceVerification(String WayToClickOnMenu,String SearchData,String selectData) throws Throwable {
    	fil.waitFixedTime(10);
    	if(WayToClickOnMenu.equalsIgnoreCase("Search")) {
       hom.Search(SearchData,selectData);
       }
       else {
    	hom.Menu();
        fil.ScrollDown();
        fil.waitFixedTime(3);
        String s=driver.findElement(By.xpath("//*[@data-product-id='678']")).getText();
		System.err.println(">>>>>>>>>>>>>>>>>>"+s);
		Reporter.log(">>>>>>>>>Total amount of the product is " +s);
		if(s.equalsIgnoreCase("₹43,000")) {
		Assert.assertEquals( s, "₹43,000");
		System.err.println("Price match with expected value"+s);
		Reporter.log("Price match with expected value"+s);
		}
		else {
			System.out.println("Price missmatch with expected value"+s);
			Reporter.log("Price missmatch with expected value"+s);
			Assert.fail();
		}
    }	
    fil.click(Logo, "click on Logo");
    }
    public void VerifyPageTitle() {
    String s=driver.getTitle();
    try {
	Assert.assertEquals(s,s);
	System.err.println("PDP page title match with expected value"+s);
	Reporter.log("PDP page title match with expected value"+s);
    }
	catch(Exception e) {
	System.err.println("PDP page title not match with expected value"+s);
	Reporter.log("PDP page title not match with expected value"+s);	
	Assert.fail();
	}finally {

	}}
public void AddToCartOption(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData,String WayToBuy) throws Throwable {
hom.Selectcategory(WayToClickOnMenu, SearchData,selectData,PinCodeData,FullNameData,MobileNumberData);
fil.waitFixedTime(5);
if(WayToBuy.equalsIgnoreCase("Add to Cart")) {
fil.click(addToCart, "Add to cart button");
fil.click(Minicart, "Add to cart button");
String s=driver.findElement(By.xpath("//*[@id='mini-cart']/table/tbody/tr[2]/td[2]/div/span")).getText();
try {
	Assert.assertEquals(s,s);
	System.out.println("product price is '"+s+"'match  with expected value");
	Reporter.log("product price is '"+s+"'match  with expected value");	
    }
	catch(Exception e) {
		System.out.println("product price is '"+s+"' not match  with expected value");
		Reporter.log("product price is '"+s+"' not match  with expected value");
		Assert.fail();
	}
}
else {
fil.click(BuyNow, "Click on button");
this.BuyNow();
}	
fil.click(CheckOut, "click on Check Out button");
}
public void VerifyLoadNextCTA(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData) throws Throwable {
	try {
	fil.waitFixedTime(10);
	if(WayToClickOnMenu.equalsIgnoreCase("Search")) {
	hom.Search(SearchData,selectData);
	}
	else {
	hom.Menu();
	//fil.waitFixedTime(2);
	//fil.click(image1, "Click on image");
	
	   }
	List<WebElement> Element=driver.findElements((By.xpath("//*[@id='amasty-shopby-product-list']")));
	Element.size();
	System.out.println("======================"+Element.size());
	/*
	 * for(int i=0;i<=Element.size();i++) { System.out.println(Element.get(i)); }
	 */
	
	/*
	 * if(Element.size()>0) { Element.get(0).click();
	 * 
	 * 
	 * }
	 */}
   catch(Exception e) {
   Assert.fail();
   }finally {
 fil.click(LoGo, "Click on LoGo");
}
}
public void CheckDeliveryFor() throws Exception {
	fil.isElementPresent(driver,By.xpath("//*[text()=' Check delivery for']"));
	System.out.println("TestCases pass''Check Delivery For''option are available on PDP page");
	String s=driver.findElement(By.xpath("//*[text()=' Check delivery for']")).getText();
	try {
		Assert.assertEquals(s,s);
	Assert.assertNotEquals(s," Check delivery for");
	System.out.println("test cases pass'atual value ie.'"+s+"' match with expected value");
	Reporter.log("test cases pass'atual value ie.'"+s+"' match with expected value");
	
	}catch(Exception e){
		System.out.println("test cases pass'atual value ie.'"+s+"'Not  match with expected value");
		Reporter.log("test cases pass'atual value ie.'"+s+"'Not  match with expected value");
		Assert.fail();
	}
}
public void PLP(String WayToClickOnMenu,String SearchData,String selectData) throws Throwable {
	this.VerifyPageTitle();
	hom.learNMore(WayToClickOnMenu, SearchData, selectData, WayToClickOnMenu, SearchData, selectData);
	this.AddToCartOption(WayToClickOnMenu, SearchData, selectData, selectData, SearchData, selectData, WayToClickOnMenu);
	fil.click(LoGo, "Click on LoGo");
	this.PriceVerification(WayToClickOnMenu, SearchData, selectData);
	this.VerifyLoadNextCTA(WayToClickOnMenu, SearchData, selectData, WayToClickOnMenu, SearchData, selectData);
}
public void SearchResultPage(String WayToClickOnMenu,String SearchData,String selectData) throws Throwable {
hom.learNMore(WayToClickOnMenu, SearchData, selectData, WayToClickOnMenu, SearchData, selectData);
this.AddToCartOption(WayToClickOnMenu, SearchData, selectData, selectData, SearchData, selectData, WayToClickOnMenu);
}



}
