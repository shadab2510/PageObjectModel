package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public static long Page_LOAD_TIMEOUT=20;
	
	public static long IMPLICIT_WAIT=20;
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH="src\\main\\java\\com\\qa\\testData\\ITMTestData.xlxs.xlsx";
	
	public static String sheetname="AddDevice";
	
	
	
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public static Workbook book; public static Sheet sheet;
	 * 
	 * public static Object[][] getTestData(String sheetName) { FileInputStream
	 * file=null; try { file= new FileInputStream(TESTDATA_SHEET_PATH); }
	 * catch(FileNotFoundException e) { e.printStackTrace(); } try {
	 * book=WorkbookFactory.create(file); } catch(InvalidFormatException e) {
	 * e.printStackTrace(); } catch(IOException e) { e.printStackTrace(); }
	 * 
	 * sheet=(Sheet) book.getSheet(sheetName); Object [][] data= new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 * 
	 * for(int i=0;i<sheet.getLastRowNum();i++) { for(int
	 * k=0;k<sheet.getRow(0).getLastCellNum;k++) {
	 * data[i][k]=sheet.getRow(i+1).getCell(k).toString(); } } return data; }
	 */
	
	public static void StaticWait()
	{
		try{Thread.sleep(2000);}
		catch(Exception e){
			
		}
	}
	
	public void switchToFrame()
	{
		driver.switchTo().frame("nameOfFrame");
	}
	
	public static void ExplicitWait(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
