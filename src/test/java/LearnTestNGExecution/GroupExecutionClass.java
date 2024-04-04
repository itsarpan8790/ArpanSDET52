package LearnTestNGExecution;

import org.testng.annotations.Test;

public class GroupExecutionClass {

	@Test(groups = "smoke")
	public void method1() {
		System.out.println("1.smoke");
	}

	@Test(groups = { "smoke", "regression" })
	public void method2() {
		System.out.println("2.smoke+regression");
	}

	@Test(groups = "smoke")
	public void method3() {
		System.out.println("3.smoke");
	}

	@Test(groups = "regression")
	public void method4() {
		System.out.println("4.regression");
	}
	
	@Test(groups = {"smoke","regression"})
	public void method5() {
		System.out.println("5.smoke+regression");
	}

}
