package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
	public int nextPk() throws ClassNotFoundException, SQLException {
		int pk=0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		conn.close();
		return pk+1;
		
	}
}
