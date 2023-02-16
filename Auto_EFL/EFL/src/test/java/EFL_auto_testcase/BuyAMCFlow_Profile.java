package EFL_auto_testcase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.EFL.pages.ByAMC;
import com.EFL.pages.Cart;
import com.EFL.pages.Checkout;
import com.EFL.pages.Home;
import com.EFL.pages.PDP;
import com.EFL.pages.Service;
import com.EFL.pages.loginPage;
import com.EFL.testbase.ExtentTestManager;
import com.EFL.testbase.TestBase;
import com.aventstack.extentreports.Status;

public class BuyAMCFlow_Profile extends TestBase{
	loginPage login;
	PDP P;
	Cart c;
	Home hom;
	Service ser;
	ByAMC AM;
	//TestLinkIntegration rel;
	Checkout cout;
	private String result;
	private String exception;
	public static Properties config = new Properties();

	@DataProvider(name="Selectcategory")
	public String[][] getData1(){
	String[][] testRecord=getData("Selectcategory","category");
	return testRecord;	
	}
	@DataProvider(name="List_Page")
	public String[][] getData2(){
	String[][] testRecord=getData("List_Page","List");
	return testRecord;	
	}
	@DataProvider(name="PDP_Page")
	public String[][] getData3(){
	String[][] testRecord=getData("PDP_Page","PDP");
	return testRecord;	
	}
	@DataProvider(name="Checkout")
	public String[][] getData4(){
	String[][] testRecord=getData("Checkout","CheckoutPage");
	return testRecord;	
	}
	@DataProvider(name="Service")
	public String[][] getData5(){
	String[][] testRecord=getData("Service","ServicePage");
	return testRecord;	
	}
	
	@DataProvider(name="BuyAmc")
	public String[][] getData6(){
	String[][] testRecord=getData("BuyAmc","BuyAmcPage");
	return testRecord;	
	}
	@DataProvider(name="Demo")
	public String[][] getData7(){
	String[][] testRecord=getData("Demo","DemoPage");
	return testRecord;	
	}
	//@BeforeMethod
	@BeforeClass
	public void setUp() throws IOException{
	//initialization();
	login = new loginPage();	
	P=new PDP();
	hom=new Home();
	c=new Cart();
	cout=new Checkout();
	ser=new Service();
	AM=new ByAMC();
	//rel= new TestLinkIntegration();
	}
/*	@Test
	public void demo12234() throws Throwable{
		hom.test12();
		
	}*/
	@Test(priority=0,dataProvider = "BuyAmc",enabled=true)
	 public void BuyAMC(String ChoosePlan,String ChoosePlanHome,String ChoosePlanProfile) throws InterruptedException {
	 AM.Profile_ByAMCflow(ChoosePlanProfile);
	 try {
		Assert.assertEquals(driver.getTitle(),"AMC Payment");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully");
		}
		catch(Exception e) {	
		System.out.println(e);
		Reporter.log(">>>>>>>>>verification failed+e");
		Assert.fail(">>>>>>>>>verification failed+e");
		}
	}
	 
	
		
	}

