package LearnDataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingSameClass_20thNov {

	@DataProvider
	public Object[][] storeData() {
		Object ob[][] = new Object[2][2];

		ob[0][0] = "Banglore";
		ob[0][1] = "Delhi";

		ob[1][0] = "Banglore";
		ob[1][1] = "Patna";

		return ob;

	}

	@Test(dataProvider = "storeData")
	public void getData(String from, String to) {

		System.out.println(from + "  " + to);
	}

}
