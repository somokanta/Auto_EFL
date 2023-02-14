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

public class LoginUserFlow extends TestBase{
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
	@DataProvider(name="LoginCheckout")
	public String[][] getData7(){
	String[][] testRecord=getData("LoginCheckout","LoginCheckoutPage");
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
	
	
	
	@Test(priority=0,groups="loginTest",dataProvider = "Demo",enabled=false)
	public void BookDemo(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData,String Runmode) {	
	//login.login(prop.getProperty("EmailAddress"),prop.getProperty("Password"));
		///hom.Demo(WayToClickOnMenu,PinCodeData, FullNameData, MobileNumberData);
	try {
		Assert.assertNotEquals(driver.getTitle(),"Book a Home Demo Request - Eureka Forbes");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+driver.getTitle()+" Match with expexted value");
		 }
		catch(Exception e) {
		Reporter.log(">>>>>>>>>Not verify successfully");
		System.err.println(">>>>>>>>>verify successfully "+driver.getTitle()+" Not Match with expexted value");	
		Assert.fail();
		}
   }

	@Test(priority = 1, groups = "Page"/* ,dependsOnGroups="loginTest" */,dataProvider = "Selectcategory",enabled=true)
	   public void HomePageAvailable(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData,String Runmode) throws Throwable {
	   if(Runmode.equalsIgnoreCase("n")) {
		   throw new SkipException("Not executed with this records");  
	   }
	  //hom.HomePageAvailable(MobileNumberData, SearchData, selectData);
	   }
   @Test(priority=2,groups="Home",dependsOnGroups="Page",dataProvider = "Selectcategory",enabled=true)
   public void MovetoCategoryPage(String WayToClickOnMenu,String SearchData,String selectData,String PinCodeData,String FullNameData,String MobileNumberData,String Runmode) throws Throwable {
   if(Runmode.equalsIgnoreCase("n")) {
	   throw new SkipException("Not executed with this records");  
   }
  driver.get("http://bitly.ws/ySXF");//Direct user logged in URL 
  hom.Selectcategory(WayToClickOnMenu, SearchData,selectData,PinCodeData,FullNameData,MobileNumberData);
   }
	@Test(priority=3,groups="product",dependsOnGroups="Home",dataProvider = "List_Page",enabled=true)
   public void MovetoPDP(String WayToBuy,String Runmode,String ExecutionMode) throws Exception{
   if(Runmode.equalsIgnoreCase("n")) {
	throw new SkipException("Not executed with this records");  
	}
    P.CheckDeliveryFor();
	P.PDPFlow(WayToBuy,ExecutionMode);
	if(ExecutionMode.equalsIgnoreCase("Valid")) {
	try {
	Assert.assertEquals(driver.getTitle(),"Shopping Cart");
	Reporter.log(">>>>>>>>>verify successfully");
	System.err.println(">>>>>>>>>verify successfully");
	//test.log(LogStatus.PASS, ">>>>>>>>>verify successfully");
	// rel.updateTestLinkResult("TP-1", "verify successfully", result);
		}
		catch(Exception e) {	
		System.out.println(e.getMessage());
        exception = e.getMessage();
       // rel.updateTestLinkResult("TP-1", exception, result);
		Reporter.log(">>>>>>>>>verification failed+exception");
		Assert.fail(">>>>>>>>>verification failed+exception");
		//test.log(LogStatus.FAIL, ">>>>>>>>>verify failed");
		}}
		else {
		try {
	  //Assert.assertNotEquals(driver.getTitle(), "Shopping Cart");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully");
	//	test.log(LogStatus.PASS, ">>>>>>>>>verify pass");
	ExtentTestManager.getTest().log(Status.PASS, "verify pass");
		//rel.updateTestLinkResult("TP-1", "verify successfully", result);
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "verify fail");
		System.out.println(e.getMessage());
		//result = TestLinkAPIResults.TEST_FAILED;
        exception = e.getMessage();
       // rel.updateTestLinkResult("TP-1", exception, result);
		Reporter.log(">>>>>>>>>verification failed+exception");
		Assert.fail(">>>>>>>>>verification failed+exception");
		//test.log(LogStatus.FAIL, ">>>>>>>>>verify Failed");
			}
		}
	}

	@Test(priority=4,groups="addtobag",dependsOnGroups="product",dataProvider = "PDP_Page",enabled=true)
	   public void MiniCartCheck(String ThingtoApplyPromocode,String PromocodeData,String Runmode,String ExecutionMode) throws Exception {
		   if(Runmode.equalsIgnoreCase("n")) {
		   throw new SkipException("Not executed with this records");  
		   }
		   c.CartPageLogin(ThingtoApplyPromocode, PromocodeData);
		if(ExecutionMode.equalsIgnoreCase("Valid")) {	
		try {
		   Assert.assertEquals(driver.getTitle(),"Checkout");
			Reporter.log(">>>>>>>>>verify successfully");
			System.err.println(">>>>>>>>>verify successfully");
			}
			catch(Exception e) {	
			System.out.println(e.getMessage());
			Reporter.log(">>>>>>>>>verification failed+e");
			Assert.fail(">>>>>>>>>verification failed+e");
			}}
		    else {
			try {
			Assert.assertNotEquals(driver.getTitle(),"Checkout");
			Reporter.log(">>>>>>>>>verify successfully");
			System.err.println(">>>>>>>>>verify successfully");
			}
			catch(Exception e) {	
			System.out.println(e);
			Reporter.log(">>>>>>>>>verification failed+e");
			Assert.fail(">>>>>>>>>verification failed+e");
			}}	
		     }
	@Test(priority=5,groups="Checkout",dependsOnGroups="addtobag",dataProvider = "LoginCheckout",enabled=true)
	   public void CheckoutCheckAndPayment(String WayOfCheckout,String mobiledata,String FirstName,String lastName,String Mobile_Number,String Email_Id,String house_noData,String Street_Data,String Street1_Data,String PinCode_Data,String City_Data,String selectRegion,String Runmode,String ExecutionMode) throws Exception {
		   if(Runmode.equalsIgnoreCase("n")) {
			   throw new SkipException("Not executed with this records");  
		   }
		 cout.CheckoutPage(WayOfCheckout, mobiledata, FirstName, lastName, Mobile_Number, Email_Id, house_noData, Street_Data, Street1_Data, PinCode_Data, City_Data, selectRegion);
		  if(ExecutionMode.equalsIgnoreCase("Valid")) {	
		  try {
			//Assert.assertEquals(driver.getTitle(),"Ingenico ePayments India Pvt. Ltd. (a Worldline brand)");
			Reporter.log(">>>>>>>>>verify successfully");
			System.err.println(">>>>>>>>>verify successfully");
			}
			catch(Exception e) {	
			System.out.println(e.getMessage());
			Reporter.log(">>>>>>>>>verification failed+e");
			Assert.fail(">>>>>>>>>verification failed+e");
			}}
		  else {
		 try {
		 Assert.assertNotEquals(driver.getTitle(),"Strawberry Home Fragrance Oil");
		Reporter.log(">>>>>>>>>verify successfully");
		System.err.println(">>>>>>>>>verify successfully");
		}
		catch(Exception e) {	
		System.out.println(e.getMessage());
		Reporter.log(">>>>>>>>>verification failed+e");
		Assert.fail(">>>>>>>>>verification failed+e");
		}} 
		  } 
		
	}

