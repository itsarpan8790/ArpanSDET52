package com.practise_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoXcelSheet_10thNov {
	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Sdet52testdatawritepractise.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1"); // if wrong sheet name null pointer exception
		sheet.createRow(5).createCell(0).setCellValue("Qspiders");

		// sheet.getRow(6).getCell(0).setCellValue("jspiders"); Cell value should not be
		// empty

		FileOutputStream fos = new FileOutputStream("./src/test/resources/Sdet52testdatawritepractise.xlsx");
		workbook.write(fos);
		workbook.close();
	}

}
