package com.rays.preparedStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
//		testUpadte();
//		testFindByLogin();
//		testAuthenticator();
//		testChangePassword();
		testForgetPassword();
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
	
	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(3);
		
		model.Delete(bean);
		
	}
	
	public static void testUpadte() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("Chaitanya");
		bean.setLastName("Bhatt");
		bean.setLogin("bhattChaitanya43@gmail.com");
		bean.setPassword("Chetan2001@");
		bean.setDob(sdf.parse("2001-07-17"));
		model.Update(bean);
	}
	
	public static void testFindByLogin() throws Exception{
		UserModel model = new UserModel();
		UserBean existBean = model.findByLogin("bhattChaitanya43@gmail.com");
		
		if (existBean != null) {
			System.out.println("User alrady Exist");
		}
		else {
			System.out.println("User dosenot Exist");			
		}
		
	}
	
	public static void testAuthenticator() throws Exception {
		UserModel model = new UserModel();
		UserBean existBean = model.authenticator("bhattchaitanya43@gmail.com", "Chetan2001@");
		
		if (existBean != null) {
			System.out.println("Login successfull");
		}
		else {
			throw new RuntimeException("Wrong UserName or Password");			
		}
	}
	
	public static void testChangePassword() throws Exception {
		UserModel model = new UserModel();
		model.changePassword("bhattchaitanya43@gmail.com", "Chetan147@", "Chetan2001@");
	}
	
	public static void testForgetPassword() throws Exception {
		UserModel model = new UserModel();
		model.forgetPassword("bhattchaitanya43@gmail.com");
	}
}
