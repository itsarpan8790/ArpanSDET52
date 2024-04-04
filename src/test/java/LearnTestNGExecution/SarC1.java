package LearnTestNGExecution;

import org.junit.Assert;
import org.testng.annotations.Test;

public class SarC1 {
	@Test
	public void method1() {
		
		System.out.println("method 1 of class 1");
		//Assert.fail();
	}
	
	@Test(dependsOnMethods = "method1")
	public void method2() {
		
		System.out.println("method 2 of class 1");
		throw new RuntimeException("Failing intentionally");
	}

}
