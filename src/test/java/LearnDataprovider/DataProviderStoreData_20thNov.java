package LearnDataprovider;

import org.testng.annotations.DataProvider;

import com.bixi.genericutility.ExcelUtility;

public class DataProviderStoreData_20thNov {

	@DataProvider
	public Object[][] storeData1() {
		Object ob[][] = new Object[2][2];

		ob[0][0] = "Banglore";
		ob[0][1] = "Delhi";

		ob[1][0] = "Banglore";
		ob[1][1] = "Patna";

		return ob;

	}

	@DataProvider
	public Object[][] storeData2() {
		Object ob[][] = new Object[2][3];

		ob[0][0] = "Banglore";
		ob[0][1] = "Delhi";
		ob[0][2] = 3500;

		ob[1][0] = "Banglore";
		ob[1][1] = "Patna";
		ob[1][2] = 7000;

		return ob;

	}

	// Excel Dataprovider (ExcelUtility)
	@DataProvider
	public Object[][] excelStoreData() throws Throwable {
		ExcelUtility eUtil = new ExcelUtility();
		Object[][] value = eUtil.dataProviderMethod("OrgLoc");
		return value;
	}

}
