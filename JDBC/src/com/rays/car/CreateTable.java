package com.rays.car;

import java.sql.*;

public class CreateTable {
	public CreateTable(String tableName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt = conn.createStatement();
		String quary = "create table "+tableName+"(id int primary key, companyName varchar(45), model varchar(45), price int, purchaseDate date)";
		stmt.executeUpdate(quary);
		System.out.println("Table is created");
		conn.close();
	}

}
