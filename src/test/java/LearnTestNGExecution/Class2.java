package LearnTestNGExecution;

import org.testng.annotations.Test;

public class Class2  {
	
	@Test(groups = "smoke")
	public void method3() {
		System.out.println("method3");
	}
	
	@Test(groups = "regression")
	public void method4() {
		System.out.println("method4");
	}

}
