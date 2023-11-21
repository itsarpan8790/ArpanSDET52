package com.practise_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LogFileQuestion {
	public static void main(String[] args) throws Throwable, IOException {
		ArrayList<String> al = new ArrayList<String>();
int max=0;
		// Adding all url to arraylist
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\LogFile.xlsx");
		Sheet sheet = WorkbookFactory.create(fis).getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();

		boolean[] flag = new boolean[15];

		for (int i = 0; i <= rowCount; i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			al.add(url);
		}
		System.out.println(al.size());
		System.out.println(al);
		for (int i = 0; i < al.size(); i++) {

			if (flag[i] == false) {
				int count = 0;
				String n = al.get(i);

				for (int j = 0; j < al.size(); j++) {
					if (n.equals(al.get(j))) {
						count++;
						flag[j] = true;
					}

				}
				System.out.println(n + " ocuurs " + count + " times");
				if (count>max)
					max=count;
			}
		}
	}

}
