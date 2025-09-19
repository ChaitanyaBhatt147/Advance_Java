package com.rays.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class UpdateTable {
	public UpdateTable(String tableName, String columName, String value, int id) throws Exception {
		if (columName == "companyName" || columName == "model") {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
			Statement stmt = conn.createStatement();
			String quary = "update "+tableName+" set "+columName+" = '"+value+"' where id = "+ id;
			int i = stmt.executeUpdate(quary);
			System.out.println(i+", row updated successfully");
			conn.close();
		}
		
		if (columName == "price") {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
			Statement stmt = conn.createStatement();
			String quary = "update "+tableName+" set "+columName+" = "+ Integer.parseInt(value)+" where id = "+ id;
			int i = stmt.executeUpdate(quary);
			System.out.println(i+", row updated successfully");
			conn.close();
		}
		
		if (columName == "parchaseDate") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
			Statement stmt = conn.createStatement();
			String quary = "update "+tableName+" set "+columName+" = '"+ sdf.format(sdf.parse(value))+"' where id = "+ id;
			int i = stmt.executeUpdate(quary);
			System.out.println(i+", row updated successfully");
			conn.close();
		}
	}
}
