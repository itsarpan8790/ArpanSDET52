package LearnAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void TC1() {
		System.out.println("Open Connection");
	}

	@AfterSuite
	public void TC2() {
		System.out.println("Close Connection");
	}

	@BeforeClass
	public void TC3() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void TC4() {
		System.out.println("After Class");
	}

	@AfterClass
	public void TC5() {
		System.out.println("After Class");
	}

	@AfterClass
	public void TC6() {
		System.out.println("After Class");
	}

	@BeforeMethod
	public void TC7() {
		System.out.println("Before Method");
	}

	@BeforeMethod
	public void TC8() {
		System.out.println("Before Method");
	}

	@BeforeMethod
	public void TC9() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void TC10() {
		System.out.println("After Method");
	}

	@AfterMethod
	public void TC11() {
		System.out.println("After Method");
	}

}
