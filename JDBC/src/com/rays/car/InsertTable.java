package com.rays.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class InsertTable {
	public InsertTable(String tableName, int id, String companyName, String model, int price, String parchaseDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
		Statement stmt = conn.createStatement();
		String quary = "Insert into "+tableName+" values ("+id+", '"+companyName+"', '"+model+"', "+ price+" ,'"+sdf.format(sdf.parse(parchaseDate))+"')";
		int i = stmt.executeUpdate(quary);
		System.out.println(i+", row inserted successfully");
		conn.close();
	}
}
