package LearnTestNGExecution;

import org.testng.annotations.Test;

public class SarC2 {
	@Test(dependsOnMethods = "LearnTestNGExecution.SarC1.method1")
	public void method2() {
		System.out.println("method 1 of class 2");
	}
	
	@Test(dependsOnMethods = "LearnTestNGExecution.SarC1.method1")
	public void method3() {
		System.out.println("method 1 of class 2");
	}

}
