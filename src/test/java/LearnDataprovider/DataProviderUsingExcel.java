package LearnDataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingExcel {
	@DataProvider
	public Object[][] storedDataExcel() throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DataProviderOrgLoc.xlsx");
		Sheet sheet = WorkbookFactory.create(fis).getSheet("OrgLoc");
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

	@Test(dataProvider = "storedDataExcel")
	public void getDataExcel(String org, String loc) {
		System.out.println(org + "  " + loc);

	}

}
