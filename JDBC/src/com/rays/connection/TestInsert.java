package com.rays.connection;

import java.sql.*;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//		make connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
//		create statement
		Statement smt = conn.createStatement();
//		execute quarry
		int i = smt.executeUpdate("insert into employe values(26,'Siddhi', 'Arcgate', 'Udaipur' , 30000,2)");
		System.out.println(i);
		conn.close();
	}
}
