 package com.bixi.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {

	/**
	 * This method is to read data From Excel File
	 * 
	 * @author arpan
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fisE = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fisE);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	/**
	 * This method is for counting Total number of Rows Present in Sheet
	 * @author arpan
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNumber(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fisE = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fisE);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}

	/**
	 * This method is use to Write data into Excel Sheet
	 * 
	 * @author arpan
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int row, int cell, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fisE = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fisE);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fisO=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fisO);

	}

	public void readMultipleDataFromExcel(String sheetName, WebDriver driver) throws Throwable {
		// JavaUtility jLib=new JavaUtility();
		FileInputStream fisE = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fisE);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();

		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i <= rowCount; i++) {
			String key = wb.getSheet(sheetName).getRow(i).getCell(0).getStringCellValue();
			String value = wb.getSheet(sheetName).getRow(i).getCell(1).getStringCellValue();
			hm.put(key, value);
		}
		
		for (Entry<String, String> set : hm.entrySet()) {
//			if(set.getKey().contains("accountname"))
//				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNumber());
//			else
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			Thread.sleep(500);
		}

	}

	public Object[][] dataProviderMethod(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DataProviderOrgLoc.xlsx");
		Sheet sheet = WorkbookFactory.create(fis).getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}

		}
		return obj;
	}

}
