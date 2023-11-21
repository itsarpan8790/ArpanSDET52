package com.practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraApp_09thNov23_Test {
	public static void main(String[] args) throws InterruptedException, SQLException {
		String expectedProjName = "TY_SDET52_Arpan1559";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.findElement(By.linkText("Projects")).click();

		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		Thread.sleep(500);

		driver.findElement(By.name("projectName")).sendKeys(expectedProjName);
		Thread.sleep(500);
		driver.findElement(By.name("createdBy")).sendKeys("ArpanKumar");
		WebElement projStatus = driver.findElement(By.name("status"));

		Select s = new Select(projStatus);
		Thread.sleep(500);
		s.selectByValue("Created");

		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		/***********************************************************************/
		// Step 1. Register the Driver
		Driver driver2 = new Driver();
		DriverManager.registerDriver(driver2);
		// Step 2.Get Connection Of Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		// Step 3.Create Statement
		Statement state = conn.createStatement();
		// Step 4.Execute Query
		String query = "select * from project";
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String actualProjName = result.getString(4);
			if (actualProjName.equalsIgnoreCase(expectedProjName)) {
				flag = true;
				break;
			}

		}
		if (flag)
			System.out.println("Passed: " + "Project creation Successfully");
		else
			System.out.println("Failed: " + "Project creation Failed");

		// Step 5. Close Database
		conn.close();

	}

}
