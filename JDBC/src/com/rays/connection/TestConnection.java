package com.rays.connection;
import java.sql.*;
public class TestConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//		make connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
//		create statement
		Statement smt = conn.createStatement();
//		execute quarry
		ResultSet rs = smt.executeQuery("select * from employe");
		
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getInt(5));
			System.out.println("\t"+rs.getInt(6));
			
		}
		conn.close();
	}
}
