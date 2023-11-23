package com.practise_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelMultipleEntries_Arpan10thNov {
	public static void main(String[] args) throws Throwable, IOException {

		FileInputStream fis = new FileInputStream(
				".\\src\\test\\resources\\WriteDataIntoExcelMultipleEntries_Arpan10thNov.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1"); // if wrong sheet name null pointer exception

		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j < 3; j++) {
				sheet.createRow(i).createCell(j).setCellValue("qspiders");
			}
		}

		FileOutputStream fos = new FileOutputStream(
				".\\src\\test\\resources\\WriteDataIntoExcelMultipleEntries_Arpan10thNov.xlsx");
		workbook.write(fos);
		workbook.close();
		System.out.println("done");

	}

}
