package com.practise_package;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataToPropertiesFIle_10thNov {
	public static void main(String[] args) throws Throwable {

		Properties pobj = new Properties();
		pobj.setProperty("browser", "chrome");
		pobj.setProperty("url", "http://localhost:8888/");
		pobj.setProperty("username", "admin");
		pobj.setProperty("password", "admin");

		FileOutputStream fos = new FileOutputStream("./src/test/resources/commondatapractise.properties");
		pobj.store(fos, "Write");

		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
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
		
	}

}
