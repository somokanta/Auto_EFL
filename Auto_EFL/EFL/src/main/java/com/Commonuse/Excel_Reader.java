package com.Commonuse;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public Excel_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);// Searching the file path and store path for read the data
			workbook = new XSSFWorkbook(fis);// opening the sheet from location which store in above path
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
				XSSFSheet sheet = workbook.getSheet(sheetName);
				// count number of active rows
				System.err.println(sheet+"-----> 1");
				int totalRow = sheet.getLastRowNum() + 1;
				// count number of active columns in row
				int totalColumn = sheet.getRow(0).getLastCellNum();
				// Create array of rows and column
				dataSets = new String[totalRow - 1][totalColumn];//except header
				// Run for loop and store data in 2D array
				// This for loop will run on rows
				System.err.println(dataSets+"-----> 2");
				for (int i = 1; i < totalRow; i++) {
					XSSFRow rows = sheet.getRow(i);
					// This for loop will run on columns of that row
					System.err.println(i+"-----> 3");
					for (int j = 0; j < totalColumn; j++) {
						// get Cell method will get cell
						XSSFCell cell = rows.getCell(j);
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
