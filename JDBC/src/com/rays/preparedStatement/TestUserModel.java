package com.rays.preparedStatement;

import java.sql.SQLException;

public class TestUserModel {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserModel model = new UserModel();
		System.out.println(model.nextPk());
	}
}
