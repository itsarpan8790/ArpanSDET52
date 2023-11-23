package com.practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_NonSelectQueryEx_09thNov23 {
	public static void main(String[] args) throws SQLException {
		//Step 1. Register the Driver
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				
				//Step 2.Get Connection Of Database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET52", "root", "tiger");
				
				//Step 3.Issue Create Statement
				 Statement state = conn.createStatement();
				 String query="INSERT INTO Student_info VALUES('NEYAZ','753951','BANSHANKARI',27)";
				 
				//Step 4.Execute Query
				int result = state.executeUpdate(query);
				
				if(result==1) {
					System.out.println("Data inserted Succesfully");
					
				}else
					System.out.println("Table not updated");
				
				
				//Step 5. Close Database
				conn.close();
	}

}
