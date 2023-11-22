package LearnTestNGExecution;

import org.testng.annotations.Test;

public class GroupExecutionClass {

	@Test(groups = "smoke")
	public void method1() {
		System.out.println("method1");
	}

	@Test(groups = { "smoke", "regression" })
	public void method2() {
		System.out.println("method2");
	}

	@Test(groups = "smoke")
	public void method3() {
		System.out.println("method3");
	}

	@Test(groups = "regression")
	public void method4() {
		System.out.println("method4");
	}

}
