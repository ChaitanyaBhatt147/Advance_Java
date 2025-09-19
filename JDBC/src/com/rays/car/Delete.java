package com.rays.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
	public Delete(String tableName, int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
		Statement stmt = conn.createStatement();
		String quary = "delete from "+tableName+" where id = "+ id;
		int i = stmt.executeUpdate(quary);
		System.out.println(i+", row deleated successfully");
		conn.close();
	}
	public Delete(String tableName) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "root");
		Statement stmt = conn.createStatement();
		String quary = "drop table "+tableName;
		stmt.executeUpdate(quary);
		System.out.println("Table droped successfully");
		conn.close();
		
	}
}
