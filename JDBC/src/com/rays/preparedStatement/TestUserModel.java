package com.rays.preparedStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		testAdd();
	}
	public static void testAdd() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("Chaitanya");
		bean.setLastName("Bhatt");
		bean.setLogin("bhattChaitanya43@gmail.com");
		bean.setPassword("Chetan2001@");
		bean.setDob(sdf.parse("2001-07-17"));
		model.add(bean);
	}
}
