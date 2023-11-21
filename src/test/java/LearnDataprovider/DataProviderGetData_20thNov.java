package LearnDataprovider;

/**
 * MethodMatcherException---1.Whenever we pass wrong arguments in getData method
 */
import org.testng.annotations.Test;

public class DataProviderGetData_20thNov {

	@Test(dataProviderClass = DataProviderStoreData_20thNov.class, dataProvider = "storeData1")
	public void getData1(String from, String to) {

		System.out.println(from + "  " + to + "  ");
	}

	@Test(dataProviderClass = DataProviderStoreData_20thNov.class, dataProvider = "storeData2")
	public void getData2(String from, String to, int price) {

		System.out.println(from + "  " + to + "  " + price);
	}

    //Execute excel dataprovider through framework
	@Test(dataProviderClass = DataProviderStoreData_20thNov.class, dataProvider = "excelStoreData")
	public void getData3(String org, String loc) {
		System.out.println(org + "  " + loc);
	}
}
