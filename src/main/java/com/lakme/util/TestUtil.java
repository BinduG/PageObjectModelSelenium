package com.lakme.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {

	public static long PageloadTimeout = 20;

	public static long implicitlyWait = 10;

	public static final String  projectpath = System.getProperty("user.dir");

	public FileInputStream fis = null;

	public Workbook workbook = null;

	public Sheet sheet = null;


	// <<<<<<<<<<<<<<< To read excel data >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public Object[][] getTestData(String sheetname) throws Exception {

		fis = new FileInputStream(projectpath+"\\src\\main\\java\\com\\lakme\\testdata\\TestDataLakme.xlsx");

		workbook = WorkbookFactory.create(fis);

		sheet = workbook.getSheet(sheetname);

		int rowcount = sheet.getLastRowNum();

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];

		for(int i = 0;i<rowcount;i++) 
		{

			int colcount = sheet.getRow(i+1).getLastCellNum();

			for(int j=0;j<colcount;j++) 
			{

				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();

			}

		}

		return data;

	}

}
