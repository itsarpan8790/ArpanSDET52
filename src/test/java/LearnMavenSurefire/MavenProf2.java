package LearnMavenSurefire;

import org.testng.annotations.Test;

public class MavenProf2 {
	
	@Test(groups = "smoke")
	public void Tc3(){
		System.out.print("smoke Tc3");
	}
	
	@Test(groups = "regression")
	public void Tc4(){
		System.out.print("regression Tc4");
	}

}
