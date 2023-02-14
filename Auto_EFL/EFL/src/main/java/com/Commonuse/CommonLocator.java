package com.Commonuse;

import org.openqa.selenium.By;

public class CommonLocator {

	public Object pageCrashImage="",
			firstPageLink="",
			getDataGridTopRow="",
			pageDropDownList="",
			getDataGridAnyRow="",
			nextPageLink="",
			preloader="",
			getCalenderNextBtn="",
			ServerError="",
			logo="",
		    Logn ="/html/body/div[4]/header/nav/ul/li[3]/a",
	        logout="";
			public Object getDataGridTopRow(String value1, String value2, String value3) {
				// TODO Auto-generated method stub
				return By.xpath("//*[text()='"+value1+"']");
			}
			public Object Product(String value) {
				return By.xpath("//*[text()='"+value+"']");
			}
}
