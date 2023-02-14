package com.EFL.testbase;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IQuery {

	/**
	* It finds element on the provided locator.
	* @author navin kumar.
	* @param locator 
	* 			specified element to find.
	 * @return WebElement
	*/
	public WebElement findElement(Object locator);

	public List<WebElement> findElements(Object locator);
	
	
	
	
}
