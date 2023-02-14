package com.Commonuse;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

public class Excel_Reader2 {
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	/*public XSSFWorkbook workbook1;
	public XSSFSheet sheet1;
	public XSSFRow row1;
	public XSSFCell cell1;*/
	public HSSFWorkbook workbook1;
	public HSSFSheet sheet1;
	public HSSFRow row1;
	public HSSFCell cell1;

	public Excel_Reader2(String path) {
	this.path = path;
	try {
	fis = new FileInputStream(path);// Searching the file path and store path for read the data
	workbook1 = new HSSFWorkbook(fis);// opening the sheet from location which store in above path
	} catch (Exception e) {
	e.printStackTrace(); // For giving the proper exception
	}
	}

	/**
	* This Method will return 2D object Data for each record in excel sheet.
	*
	* @param NavinKumar
	* @param fileName
	* @return
	*/
	public String[][] getDataFromSheet(String sheetName, String ExcelName)//initialise object
	{
	String dataSets[][] = null; //instantiat elementy
	try {
	// get sheet from excel workbook
	HSSFSheet sheet1 = workbook1.getSheet(sheetName);
	System.out.println(sheetName);
	// count number of active rows
	System.err.println(sheet1+"-----> 1");
	int totalRow = sheet1.getLastRowNum() + 1;
	// count number of active columns in row
	int totalColumn = sheet1.getRow(0).getLastCellNum();
	// Create array of rows and column
	dataSets = new String[totalRow - 1][totalColumn];//except header
	// Run for loop and store data in 2D array
	// This for loop will run on rows
		System.err.println(dataSets+"-----> 2");
		for (int i = 1; i < totalRow; i++) {
		HSSFRow rows = sheet1.getRow(i);
		// This for loop will run on columns of that row
		System.err.println(i+"-----> 3");
		for (int j = 0; j < totalColumn; j++) {
		// get Cell method will get cell
		HSSFCell cell = rows.getCell(j);
		System.err.println(j+"-----> 4");
		// If cell of type String , then this if condition will work
		if (cell.getCellType() == Cell.CELL_TYPE_STRING)
		dataSets[i - 1][j] = cell.getStringCellValue();
		// If cell of type Number , then this if condition will work
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		String cellText = String.valueOf(cell.getNumericCellValue());
		dataSets[i - 1][j] = cellText;
		} else
		// If cell of type boolean , then this if condition will work
		dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
		}

		}
		return dataSets;
		} catch (Exception e) {
		System.out.println("Exception in reading Xlxs file" + e.getMessage());
		e.printStackTrace();
		}
		return dataSets;
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
