package com.practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class PrakashSirJDBCScenario_15thNov_Test {

	public static void main(String[] args) throws SQLException {
		
		//Connection conn=null;
		
			Random ran = new Random();
			int age = ran.nextInt(100);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Name:");
			String dynamicName = sc.next();

			// Step 1.Register the Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			// Step 2. Get the Database Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET52", "root", "tiger");

			// Step 3.Create Statement
			Statement state = conn.createStatement();
			String query = "SELECT * FROM EMP2;";
			String insertQuery = "INSERT INTO EMP2 VALUES('" + dynamicName + "'," + age + ");";

			// Step 4. Execute Query
			ResultSet result = state.executeQuery(query);
			 //String EmpName = result.getString(1);

			while (result.next()) {
				if (dynamicName.equals(result.getString(1))) {
					System.out.println(result.getString(1) + " : already available");
				}

				else {
					state.executeUpdate(insertQuery);
					System.out.println("Data Inserted Successfully and Table Updated");
				}
			}

		
		
		
			// Step 5.Close the Connection.
			   conn.close();
		
		

	}

}
