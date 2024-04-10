package LearnListeners;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.bixi.genericutility.BaseClass;

public class Class1 extends BaseClass {
	@Test
	public void c1M1() {
		System.out.println("method 1");
	}
	@Test(retryAnalyzer = com.bixi.genericutility.RetryAnalyserImp.class)
	public void c1M2() {
		Assert.fail();
		System.out.println("method 2");
		
	}

}
