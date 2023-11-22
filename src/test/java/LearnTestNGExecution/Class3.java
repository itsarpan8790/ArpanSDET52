package LearnTestNGExecution;

import org.testng.annotations.Test;



public class Class3 extends BaseClass {
	@Test(groups = { "smoke", "regression" })
	public void method5() {
		System.out.println("method5");
	}
	
	@Test(groups = { "smoke", "regression" })
	public void method6() {
		System.out.println("method6");
	}

}
