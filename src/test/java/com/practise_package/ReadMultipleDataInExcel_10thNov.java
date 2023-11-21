package com.practise_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataInExcel_10thNov
{
	public static void main(String[] args) throws Throwable {
		 
		FileInputStream fis=new FileInputStream("./src/test/resources/testdatapractise.xlsx");
		
		Workbook workbook =WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("OrgLoc");
		
		int rowCount = sheet.getLastRowNum(); //5--0,1,2,3,4
		System.out.println(rowCount);//printing index of last Row
		
		int cellcount= sheet.getRow(0).getLastCellNum(); //2--0,1
		System.out.println(cellcount);//printing actual cell count and not index
		
		for(int i=0;i<=rowCount;i++) {  //5 iterations
			for(int j=0;j<cellcount;j++) { //2 iterations
				
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
