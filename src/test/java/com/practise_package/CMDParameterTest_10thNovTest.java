package com.practise_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CMDParameterTest_10thNovTest {
	@Test
	public void cmdParameterTest() throws InterruptedException {
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
       
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.quit();
		
		/**
		 * IN command prompt
		 * Step 1.mvn compile
		 * Step 2.mvn -Dbrowser=chrome -Durl=http://localhost:8888/ -Dusername=admin -Dpassword=admin -Dtest=CMDParameterTest_10thNovTest test
		 */

	}

}
