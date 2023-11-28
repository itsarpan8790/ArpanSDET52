package LearnMavenSurefire;

import org.testng.annotations.Test;

public class MavenProf1 {
	@Test(groups = "smoke")
	public void Tc1(){
		System.out.print("smoke Tc1");
	}
	
	@Test(groups = "regression")
	public void Tc2(){
		System.out.print("regression Tc2");
	}

}
