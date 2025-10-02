package com.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBCDataSource {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			testSearch();
			System.out.println("No of Connection: "+i);
		}
	}
	public static void testSearch() {
		Connection comm = null;
		try {
			comm = JDBCDataSource.getConnection();
			Statement stmt = comm.createStatement();
			ResultSet rs = stmt.executeQuery("select * from st_user where id = 1");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
