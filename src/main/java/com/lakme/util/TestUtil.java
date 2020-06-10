package com.lakme.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lakme.basesetup.BaseSetup;

public class TestUtil extends BaseSetup {

	public static long PageloadTimeout = 50;

	public static long implicitlyWait = 30;

	public static final String  projectpath = System.getProperty("user.dir");
	
	public static final String propertiesFileLocation = "\\src\\main\\resources\\config.properties";

	public static FileInputStream fis = null;

	public static Workbook workbook = null;

	public static Sheet sheet = null;
	
	
	//<<<<<<<<<<<<<<<<<<Take screenshot>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public static void takescreenshot() throws IOException {
	
		//convert driver object to type 'TakeScreenshot'
		
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		//Taking screenshot
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		
		//Creation destination path
		File destination = new File(projectpath+"\\screenshots\\"+System.currentTimeMillis()+".png");
		
		//copy file from src to destination
		FileUtils.copyFile(srcfile,destination);
	}
	
	


	// <<<<<<<<<<<<<<< To read excel data >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public static Object[][] getTestData(String sheetname) throws Exception {

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
