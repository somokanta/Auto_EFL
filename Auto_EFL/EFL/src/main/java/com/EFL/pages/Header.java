package com.EFL.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Commonuse.CommonLocator;
import com.Commonuse.CommonUseFile;
import com.EFL.testbase.TestBase;

public class Header extends TestBase{
	CommonLocator cl;
	//CommonUseFile coml;
	CommonUseFile fil;
	@FindBy(xpath="/html/body/div[4]/header/div[1]/div[2]/a/img")
	WebElement Logo;
	@FindBy(xpath="/html/body/div[4]/header/div[1]/div[3]/ul/li[2]/a")
	WebElement UserLogin;
	@FindBy(xpath="//*[text()='Create an account']")
	WebElement CREATEAN_ACCOUNT;
	@FindBy(xpath="//*[@name='country_code']")
	WebElement CountryCode;
	@FindBy(xpath="//*[@name='phone_number']")
	WebElement Number;
	@FindBy(xpath="//*[@name='firstname']")
	WebElement FirstName;
	@FindBy(xpath="//*[@name='lastname']")  
	WebElement LastName;
	@FindBy(xpath="//*[@name='email']")
	WebElement EmailAddress;
	@FindBy(xpath="//*[@id='password']")
	WebElement Password;
	@FindBy(xpath="//*[@id='password-confirmation']")
	WebElement ConfirmPassword;
	@FindBy(xpath="//*[@id='form-validate']/fieldset/div[12]/div/button/span")
	WebElement Createanaccount;
	@FindBy(xpath="//*[@id='form-validate']/fieldset/div[10]/label")
	WebElement checkbox;
	@FindBy(xpath="//li[@class='current']")

	WebElement SIGNIN;
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailAddressF;
	@FindBy(xpath="//div[3]/div/input[@id='pass']")
	WebElement EmailAddressSIGNIN;
	
	@FindBy(xpath="//*[text()='Forgot Your Password']")
	WebElement ForgotYourPassword;
	@FindBy(xpath="//*[@id='email_address']")
	WebElement EmailAddress_Forget;
/*	@FindBy(xpath="")
	WebElement Logo1;
	@FindBy(xpath="")
	WebElement Logo1;
	@FindBy(xpath="")
	WebElement Logo1;
	@FindBy(xpath="")*/
	
	
	
	
	/*public Header(WebDriver driver) throws IOException {
	coml=new CommonUseFile(driver);
	cl=new CommonLocator();
	}*/
	public Header() throws IOException{
	PageFactory.initElements(driver, this);
	fil=new CommonUseFile(driver);
	}
/*	public void logOut() {
	coml.click(cl.logout, "logout");	
	}
	public void logo() {
	coml.click(cl.logo, "logo click");
	}*/
  public void Logo() {
   fil.click(Logo, "Logo");
	}

}
