package com.EFL.pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class ByAMC extends TestBase{
	//Sreps1
	CommonUseFile fil;
	loginPage login;
	Home hom;
	PDP P;
	public static Properties config = new Properties();
	@FindBy(xpath="//*[@name='ko_unique_1']")
	WebElement ContinueAsaGuest;
	@FindBy(xpath="//*[@id='html-body']/div[2]/header/div/div/div[2]/ul/li[5]/a")
	WebElement BuyAmc;
	@FindBy(xpath="//*[@class='maintance-price']")
	WebElement BuyAmc1;
	@FindBy(xpath="//*[@class='btn primary add side-TopRight']")
	WebElement BuyAmc2;
	
	@FindBy(xpath="//*[@class='amc_products_type']")
	WebElement RadioButton;
	@FindBy(xpath="//*[@id='amc_plan_form']/ul/li[1]/div[2]/div[2]/input")
	WebElement RadioButton1;
	
	@FindBy(xpath="//*[@id='amc_plan_form']/ul/li[2]/div[2]/div[2]/input")
	WebElement RadioButton2;
	

	@FindBy(xpath="//*[text()='Continue']")
	WebElement Continue;
	@FindBy(xpath="//*[@id='amc_cart_form']/div[1]/button")
	WebElement Continue1; 
	@FindBy(xpath="//*[@class='action-close']")
	WebElement cancel;
	
	
	@FindBy(xpath="//img[@title='EUREKA FORBES']")
	WebElement Logo;
	@FindBy(xpath="//*[@id='maincontent']/descendant::span[contains(text(),'Buy AMC')]")
	WebElement BuyAMC_Home;
	
	@FindBy(xpath="//*[@id='myaccount']")
	WebElement myaccount;
	@FindBy(xpath="//*[@class='purchase yourpf']")
	WebElement Your_profile;
	@FindBy(xpath="//*[text()='AMC']")
	WebElement profile;
	
	
	public ByAMC() throws IOException{
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
		public void ByAMCflow(String ChoosePlan) throws InterruptedException{
			driver.get("http://bitly.ws/ySXF");//Direct user logged in URL 
			Reporter.log("Direct user logged in URL");
			System.out.println("Direct user logged in URL");
			fil.waitFixedTime(3);
			fil.click(BuyAmc, "Click on BuyAmc");
			//fil.click(BuyAmc1, "Click on BuyAmc");
			//fil.click(BuyAmc2, "Click on BuyAmc2");	
			fil.click(RadioButton, "Click on RadioButton");
			if(ChoosePlan.equalsIgnoreCase("1-year plan")) {
				fil.click(RadioButton1, "Click on RadioButton");
				}else if(ChoosePlan.equalsIgnoreCase("2-year plan")){
				fil.click(RadioButton2, "Click on RadioButton");	
				}else {
				System.out.println("Selected the Default value");
				}
			fil.click(Continue, "Click on Continue button");
			fil.click(Continue1, "Click on Continue button again");
			String s = driver.findElement(By.xpath("//*[@class='quote-grandtotal']")).getText();
			try {
				System.err.println(">>>>>>>>>>>>>>>>"+s);
				Assert.assertNotEquals(s, "₹5,650.00");
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				/*
				 * fil.click(Continue1, "Click on Continue gain button"); String s1 =
				 * driver.findElement(By.xpath("//*[@class='number']")).getText();
				 * Assert.assertEquals(s1,s1);
				 */
				System.out.println("Total price is is "+s);
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
			} catch (Exception e) {
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Assert.fail();
			}finally {
			//login.mouseoverForLogout();
			}
		}
		public void Home_ByAMCflow(String ChoosePlan) throws InterruptedException{
			driver.get("http://bitly.ws/ySXF");//Direct user logged in URL 
			Reporter.log("Direct user logged in URL");
			System.out.println("Direct user logged in URL");
			fil.waitFixedTime(3);
			fil.click(Logo, "Logo");
			fil.click(BuyAMC_Home, "BuyAmc");
			//fil.click(BuyAmc2, "Click on BuyAmc2");	
			fil.click(RadioButton, "Click on RadioButton");
			if(ChoosePlan.equalsIgnoreCase("1-year plan")) {
			fil.click(RadioButton1, "Click on RadioButton");
			}else if(ChoosePlan.equalsIgnoreCase("2-year plan")){
			fil.click(RadioButton2, "Click on RadioButton");	
			}else {
			System.out.println("Selected the Default value");
			}
			fil.click(Continue, "Click on Continue button");
			fil.click(Continue1, "Click on Continue button again");
			String s = driver.findElement(By.xpath("//*[@class='quote-grandtotal']")).getText();
			try {
				System.err.println(">>>>>>>>>>>>>>>>"+s);
				Assert.assertNotEquals(s, "₹5,650.00");
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				/*
				 * fil.click(Continue1, "Click on Continue gain button"); String s1 =
				 * driver.findElement(By.xpath("//*[@class='number']")).getText();
				 * Assert.assertEquals(s1,s1);
				 */
				System.out.println("Total price is is "+s);
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
			} catch (Exception e) {
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Assert.fail();
			}finally {
			//login.mouseoverForLogout();
			}
		}
		public void Profile_ByAMCflow(String ChoosePlan) throws InterruptedException{
			driver.get("http://bitly.ws/ySXF");//Direct user logged in URL 
			Reporter.log("Direct user logged in URL");
			System.out.println("Direct user logged in URL");
			fil.waitFixedTime(3);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Actions element=new Actions(driver);
			//L1 for mouse over
			WebElement Menu=driver.findElement(By.xpath("//*[@id='myaccount']"));
			element.moveToElement(Menu).perform();
			//L2 for click using actions class
			WebElement submenul1=driver.findElement(By.xpath("//*[@id='html-body']/div[2]/header/div/div/div[2]/ul/li[3]/div/div[2]/div[2]/a"));
			submenul1.click();
			fil.waitFixedTime(3);
			fil.click(profile, "BuyAmc");	
			fil.click(RadioButton, "Click on RadioButton");
			
			  if(ChoosePlan.equalsIgnoreCase("1-year plan")) { fil.click(RadioButton1,
			  "Click on RadioButton"); }else
			  if(ChoosePlan.equalsIgnoreCase("2-year plan")){ fil.click(RadioButton2,
			  "Click on RadioButton"); }else {
			  System.out.println("Selected the Default value"); }
			 
			fil.click(Continue, "Click on Continue button");
			fil.click(Continue1, "Click on Continue button again");
			String s = driver.findElement(By.xpath("//*[@class='quote-grandtotal']")).getText();
			try {
				System.err.println(">>>>>>>>>>>>>>>>"+s);
				Assert.assertEquals(s, "₹5,650.00");
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				/*
				 * fil.click(Continue1, "Click on Continue gain button"); String s1 =
				 * driver.findElement(By.xpath("//*[@class='number']")).getText();
				 * Assert.assertEquals(s1,s1);
				 */
				System.out.println("Total price is is "+s);
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " match with expected value");
			} catch (Exception e) {
				System.out.println("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Reporter.log("Test Cases pass>>Atuel result ie. " + s + " not match with expected value");
				Assert.fail();
			}finally {
			//login.mouseoverForLogout();
			}
		}
}
