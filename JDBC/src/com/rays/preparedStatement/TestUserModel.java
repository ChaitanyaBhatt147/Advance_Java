package com.rays.preparedStatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
//		testUpadte();
//		testFindByLogin();
//		testAuthenticator();
//		testChangePassword();
//		testForgetPassword();
		testSearch();
	}

	public static void testAdd() throws Exception {
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

	public static void testFindByLogin() throws Exception {
		UserModel model = new UserModel();
		UserBean existBean = model.findByLogin("bhattChaitanya43@gmail.com");

		if (existBean != null) {
			System.out.println("User alrady Exist");
		} else {
			System.out.println("User dosenot Exist");
		}

	}

	public static void testAuthenticator() throws Exception {
		UserModel model = new UserModel();
		UserBean existBean = model.authenticator("bhattchaitanya43@gmail.com", "Chetan2001@");

		if (existBean != null) {
			System.out.println("Login successfull");
		} else {
			throw new RuntimeException("Wrong UserName or Password");
		}
	}

	public static void testChangePassword() throws Exception {
		UserModel model = new UserModel();
		model.changePassword("bhattchaitanya43@gmail.com", "Chetan2001@", "Chetan147@");
	}

	public static void testForgetPassword() throws Exception {
		UserModel model = new UserModel();
		model.forgetPassword("bhattchaitanya43@gmail.com");
	}

	public static void testFindById() throws Exception {
		UserModel model = new UserModel();
		UserBean existBean = model.findById(1);

		if (existBean != null) {
			System.out.println("User alrady Exist");
		} else {
			System.out.println("User dosenot Exist");
		}
	}

	public static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("ita");
//		bean.setDob(sdf.parse("2001-07-17"));
//		bean.setId(2);

		List list = model.search(bean);
		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}
	}
}
