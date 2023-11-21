package com.practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_SelectQueryEx_09thNov23 {
	public static void main(String[] args) throws SQLException {
		
		
	
		//Step 1. Register the Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2.Get Connection Of Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET52", "root", "tiger");
		
		//Step 3.Issue Create Statement
		 Statement state = conn.createStatement();
		 String query="Select * from Student_info";
		 
		
		//Step 4.Execute Query
		 ResultSet result = state.executeQuery(query);
		 
		 while(result.next()) {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		 }
		
		
		//Step 5. Close Database
			conn.close();
		
		
		
		
	}

}
