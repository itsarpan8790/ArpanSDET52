package com.practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_BothQueryEx_09thNov23 {
	public static void main(String[] args) throws SQLException {
		// Step 1. Register the Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// Step 2.Get Connection Of Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET52", "root", "tiger");

		// Step 3.Issue Create Statement
		Statement state = conn.createStatement();
		String query1 = "INSERT INTO Student_info VALUES('Manju','753951','Qspider',25),('Gopi','753451','Mico',27)";
		String query2 = "Select * from Student_info";
		// Step 4.Execute Query
		int resultInt = state.executeUpdate(query1);
		ResultSet resultString = state.executeQuery(query2);

		if (resultInt >= 1) {
			System.out.println("Data inserted Succesfully");
			System.out.println(resultInt+"Rows affected");

		} else
			System.out.println("Table not updated");

		while (resultString.next()) {
			System.out.println(resultString.getString(1) + " " + resultString.getString(2) + " "
					+ resultString.getString(3) + " " + resultString.getString(4));
		}

		// Step 5. Close Database
		conn.close();
	}
}
