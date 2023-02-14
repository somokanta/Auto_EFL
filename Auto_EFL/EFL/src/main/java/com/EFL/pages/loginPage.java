 
package com.EFL.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.EFL.testbase.TestBase;

public class loginPage extends TestBase {
	@FindBy(xpath="//*[text()='Login']")
	WebElement LoginIcon;
	@FindBy(xpath="//*[text()='Login']")
	WebElement click;
	@FindBy(xpath="//*[contains(@id,'j_username') and contains(@name,'j_username')]")
	WebElement email;
	@FindBy(xpath="//*[contains(@id,'j_password') and contains(@name,'j_password')]")
	WebElement pswd;
	@FindBy(xpath="//*[@id='loginForm']/div[1]/div/div[4]/button")
	WebElement login;
	//------------------------------
	@FindBy(xpath="//*[@id='root']/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/form/div[1]/div/div/div/input")
	WebElement email1;
	@FindBy(xpath="//*[@id='root']/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/form/div[2]/div/div/div/input")
	WebElement pswd1;
	@FindBy(xpath="//*[@class='MuiButtonBase-root MuiButton-root MuiButton-contained GeustBtn']")
	WebElement login1;
	
	@FindBy(xpath="/html/body/div[2]/header/div/div/div[2]/ul/li[3]/a")
	WebElement icon;
	
	
	@FindBy(xpath="//*[text()='Sign out']")
	WebElement Logout;
	//Initializing the Page Objects:
	public loginPage(){
	PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
	return driver.getTitle();
	}
	public void login(String un, String pwd){
	//WebElement menuOption = driver.findElement(By.xpath("//*[@id='root']/div[1]/header/div[1]/div[2]/div[3]/ul/li[2]/a"));
	icon.click();
	email.sendKeys(un);
	pswd.sendKeys(pwd);
	login.click();
	//String t=driver.findElement(By.xpath("//*[@class='search-product-header']")).getText();
	}
	public void loginOnCheckout(String un, String pwd){
		email1.sendKeys(un);
		pswd1.sendKeys(pwd);
		login1.click();
		}
	public void Logout(){
		login.click();
	 /*JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", login);*/
	}
	
	/*private Object text(String path) {
		// TODO Auto-generated method stub
		return By.xpath("//*[text()='"+path+"']");
	}
*/
	public void mouseoverForLogout() throws InterruptedException {
		icon.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);       
        Actions actions = new Actions(driver);
    	Thread.sleep(5000);
    	WebElement menuOption = driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[2]/ul/li[3]/a"));
    	actions.moveToElement(menuOption).perform();
    	Thread.sleep(5000);
    	System.out.println("Done Mouse hover on 'logout'");
    	WebElement subMenuOption = driver.findElement(By.xpath("//*[text()='Logout ']")); 
    	Thread.sleep(5000);
    	subMenuOption.click();
    	Thread.sleep(5000);
	}
}
