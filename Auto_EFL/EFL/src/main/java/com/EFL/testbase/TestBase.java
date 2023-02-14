package com.EFL.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Commonuse.Excel_Reader;
import com.Commonuse.Excel_Reader2;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static Excel_Reader excel;
	public static Excel_Reader2 excel1;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	//protected static ExtentTest test;
	//static ExtentReports report;

	public TestBase(){
			
	try {
	prop = new Properties();
	/*FileInputStream ip = new FileInputStream("E:\\AutoFrame\\alfa_auto\\src\\main\\java\\com\\Alfa\\config\\config.properties");*/
	
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/EFL"
	+ "/config/config.properties");
	prop.load(ip);
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	@BeforeTest
	@Parameters("browser")
	public static void initialization(String browserName){
	//public static void initialization(){
	//String browserName = prop.getProperty("browser");
		
	if(browserName.equalsIgnoreCase("chrome_linex")){
	System.out.println("chrome setProperty for launch.......");
	//WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver", "\usr\local\bin\chromedriver");//"/usr/local/bin/chromedriver"	
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
	chromeOptions.addArguments("--disable-notifications");
	chromeOptions.addArguments("--disable-dev-shm-usage");
	chromeOptions.addArguments("--lang=en_US");
	driver = new ChromeDriver(chromeOptions);
	//driver = new ChromeDriver(); 
	log.debug("chrome launch..............");
	System.out.println("chrome launch..............");
	}
	else if(browserName.equalsIgnoreCase("linux")){
		System.out.println("chrome setProperty for launch.......");
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");//"/usr/local/bin/chromedriver"	
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(/*"--headless",*/ "window-size=1024,768", "--no-sandbox");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--lang=en_US");
		driver = new ChromeDriver(chromeOptions);
		//driver = new ChromeDriver(); 
		log.debug("chrome launch..............");
		System.out.println("chrome launch..............");
		}
	else if (browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//Browser//chromedriver.exe");
		 //WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Users\\User\\AppData\\Local\\Google\\Chrome Beta\\Application\\chrome.exe");
		
		
		//chromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		chromeOptions.addArguments("ignore-certificate-errors");
		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver(chromeOptions); 
		log.debug("chrome launch..............");
		System.out.println("chrome launch..............");
		
	}
	else if (browserName.equalsIgnoreCase("firefox"))
	{
		//WebDriverManager.edgedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
	    // ChromeOptions chromeOptions = new ChromeOptions();
		System.setProperty("webdriver.gecko.driver" ,".//src//test//resources//Browser//geckodriver.exe");
		driver=new FirefoxDriver();
		log.debug("firefox launch..............");
		System.out.println("firefox launch..............");
	}
	else if (browserName.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		log.debug("Edge launch..............");
		System.out.println("Edge launch..............");
	}
	else if (browserName.equalsIgnoreCase("Chrome_Headless"))
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("disable-gpu");
		 driver = new ChromeDriver(chromeOptions);
		log.debug("Chrome_Headless launch..............");
		System.out.println("Chrome_Headless launch..............");
	}
	else if(browserName.equalsIgnoreCase("ie"))
	{
		WebDriverManager.iedriver().setup();
		//System.setProperty("webdriver.ie.driver", ".//src//test//resources//Browser//IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		log.debug("IE launch..............");
		System.out.println("IE launch..............");
	}
	//driver.manage().window().maximize();
	 Dimension d = new Dimension(1382,744); //Resize the current window to the given dimension 
	 driver.manage().window().setSize(d);//1382,744
	driver.manage().deleteAllCookies();//1920,1080
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));

	

	driver.manage().window().maximize();
	
}
	/*@AfterClass
	public void close(){
	driver.close();
	driver.quit();	

	}*/
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	 public void screenShot(ITestResult result){
	 //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	 if(ITestResult.FAILURE==result.getStatus()){
	 try{
	 // To create reference of TakesScreenshot
		 EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	 // Call method to capture screenshot
	 File src=edriver.getScreenshotAs(OutputType.FILE);
	 // Copy files to specific location 
	 // result.getName() will return name of test case so that screenshot name will be same as test case name
	 FileUtils.copyFile(src, new File(".//src//test//resources//ScreenShotFolder// "+result.getName()+".png"));
	 System.out.println("Successfully captured a screenshot");//"D:\\ScreenShortFolder\\"
	// driver.quit();
	 }catch (Exception e){
	 System.out.println("Exception while taking screenshot "+e.getMessage());
	 }}
	 else {
	//driver.quit(); 
	 }
	 //report.flush();
	 }
	public String[][]getData(String sheetName, String ExcelName){
		//String path=System.getProperty("/src/test/resources/"+ExcelName);
		String path=(".//src//test//resources//testdata//testfile.xlsx");
		excel=new Excel_Reader(path);//E:\\AutoFrame\\alfa_automation\\src\\test\\resources\\testdata\\testfile.xlsx
		String[][]data=excel.getDataFromSheet(sheetName, ExcelName);
	/*	String path=("E:\\AutoFrame\\alfa_auto1\\src\\test\\resources\\testdata\\testfile2.xls");
		excel1=new Excel_Reader2(path);
		String[][]data=excel1.getDataFromSheet(sheetName, ExcelName);*/
		return data;
		
	}
	@AfterClass 
	public void close() {
	//driver.quit(); 
	
	}
}
