package com.rays.collableStatement;

import java.sql.*;

public class TestCollableStatement {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		CallableStatement cstmt = conn.prepareCall("{CALL searchEmployee()}");
		ResultSet rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
	}
}
