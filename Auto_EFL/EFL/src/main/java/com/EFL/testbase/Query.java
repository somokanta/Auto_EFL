package com.EFL.testbase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Query implements IQuery {

	WebDriver idriver;
	WebElement element;
	List<WebElement> elements;
	private int attempts = 5;
	
	public Query(WebDriver driver){
		idriver = driver;
	}

	public WebElement findElement(Object locator) {
		
		while (attempts > 0){
			try {
				element = idriver.findElement((By)locator);
				break;
			} catch (StaleElementReferenceException e) {
				attempts--;
			}
		}
		return element;
	}
	
	public List<WebElement> findElements(Object locator) {
		
		while (attempts > 0){
			try {
				elements = idriver.findElements((By)locator);
				break;
			} catch (StaleElementReferenceException e) {
				attempts--;
			}
		}
		return elements;
	}
	
	
	
	
}
