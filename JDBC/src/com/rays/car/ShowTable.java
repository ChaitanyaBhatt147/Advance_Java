package com.rays.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowTable {
	public ShowTable(String tableName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt = conn.createStatement();
		String quary = "select * from "+tableName;
		ResultSet rs = stmt.executeQuery(quary);
		
		while (rs.next()) {
			System.out.print(rs.getInt(1));			
			System.out.print("\t"+rs.getString(2));			
			System.out.print("\t"+rs.getString(3));			
			System.out.print("\t"+rs.getInt(4));			
			System.out.println("\t"+rs.getDate(5));			
		}
		conn.close();
	}
}
