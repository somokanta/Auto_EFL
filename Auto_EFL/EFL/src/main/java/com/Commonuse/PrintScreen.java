package com.Commonuse;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.EFL.testbase.TestBase;
public class PrintScreen  extends TestBase
{
	//@Test
	public void takescreenShort() throws IOException {
	//TestBase.initialization();
		
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	                     File SrcFile= edriver.getScreenshotAs(OutputType.FILE);
	                    // FileUtils.copyFile("", "");
	                     System.out.println("ttyhghgh");
	                     FileUtils.copyFile(SrcFile, new File("E:\\navinnkvt\\test.jpeg"));
}}

