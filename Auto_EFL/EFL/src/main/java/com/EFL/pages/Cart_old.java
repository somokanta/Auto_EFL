package com.EFL.pages;

/*public class Cart_old {
	CommonLocator cl;
	CommonUseFile coml;
	loginPage lp;
    public static Properties config = new Properties();
	public Cart_old(WebDriver driver) throws IOException {
	coml=new CommonUseFile(driver);
	cl=new CommonLocator();
	lp=new loginPage();
	alc=new addToCartLc();
	}
	public void login() {
	lp.login(config.getProperty("EmailAddress"),config.getProperty("Password"));
	}
	public void product(String SearchValue,String Size, String Signature, String numberofProduct) throws InterruptedException {
	Thread.sleep(1000);
	coml.SendKeysSearchBoxDropdownValue(alc.Search, SearchValue, "Search",2);
	if(coml.isElementPresentSingleLocator(alc.Size)) {
	coml.selectByVisibleText(alc.Size, Size, "Size");
	}
	else 
	{
	System.err.println(">>>>>>>>>>>>>>>>>Size option is not available for particular product");	
	}
	coml.Quantity(Signature, numberofProduct, alc.quentityP, "quentityP", alc.quentityN);
	coml.click(alc.CollectinStore, "CollectinStore");
	}
	public void addtobag() {
	coml.click(alc.bag, "storein bag");
	coml.click(alc.bag, "storein bag");
	}
	public void checkout_continueshoping(String checkout) {
		if(checkout.equalsIgnoreCase("yes")) {
		coml.click(alc.checkout, "checkout");	
		}
		else {
		coml.click(alc.continueshoping, "continueshoping");
		}
	}*/

