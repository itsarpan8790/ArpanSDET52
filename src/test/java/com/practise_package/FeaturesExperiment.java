package com.practise_package;

import org.testng.annotations.Test;

public class FeaturesExperiment {
	@Test()
	public void a() {
		System.out.println("a");
	}

	@Test()
	public void b() {
		System.out.println("b");
	}

	@Test(dependsOnMethods = "b")
	public void c() {
		System.out.println("c");
	}

	@Test()
	public void d() {
		System.out.println("d");
	}

}
