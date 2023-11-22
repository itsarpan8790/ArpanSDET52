package LearnTestNGExecution;

import org.testng.annotations.Test;

public class Class1  {
	@Test(groups = "smoke")
	public void method1() {
		System.out.println("method1");
	}

	@Test(groups = "regression")
	public void method2() {
		System.out.println("method2");
	}

}
