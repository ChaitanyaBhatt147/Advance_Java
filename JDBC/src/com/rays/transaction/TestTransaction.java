package com.rays.transaction;

import java.sql.*;

public class TestTransaction {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("insert into employe values( 27 , 'Riddhi', 'Arcgate', 'Udaipur', 30000, 2)");
			i = stmt.executeUpdate("insert into employe values( 27 , 'Riddhi', 'Arcgate', 'Udaipur', 30000, 2)");
			i = stmt.executeUpdate("insert into employe values( 28 , 'Siddhi', 'Arcgate', 'Udaipur', 30000, 2)");
			conn.commit();
			System.out.println("Transaction is commited");
		} catch (Exception e) {
			System.out.println("Transaction is rolled back");
			conn.rollback();
		}
	}
}
