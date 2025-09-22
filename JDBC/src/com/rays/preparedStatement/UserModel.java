package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

//	Generate primary key
	public int nextPk() throws Exception {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		conn.close();
		return pk + 1;
	}

//	insert record
	public void add(UserBean bean) throws Exception {
		UserBean existBean = findByLogin(bean.getLogin());

		if (existBean != null) {
			throw new RuntimeException("User alrady Exist");
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values (?,?,?,?,?,?)");
		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		int i = pstmt.executeUpdate();
		System.out.println("Data inserted successfully: " + i);
		conn.close();
	}

//	delete record
	public void Delete(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
		pstmt.setInt(1, bean.getId());
		pstmt.executeUpdate();
		System.out.println("Data deleted successfully.");
		conn.close();
	}

//	update record
	public void Update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstName = ?, lastName = ?, login = ?, password = ?, dob = ? where id =?");
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());
		pstmt.executeUpdate();
		System.out.println("Data Upadated successfully.");
		conn.close();
	}

//	find by login id
	public UserBean findByLogin(String login) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");
		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}
		return bean;
	}

//	User Authentication
	public UserBean authenticator(String login, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ? and password = ?");
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}
		conn.close();
		return bean;
	}

//	Change password
	public void changePassword(String login, String password, String newPassword) throws Exception {
		if (password != newPassword) {
			UserBean bean = authenticator(login, password);
			if (bean != null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				PreparedStatement pstmt = conn.prepareStatement("update st_user set password = ? where id =?");
				pstmt.setString(1, newPassword);
				pstmt.setInt(2, bean.getId());
				pstmt.executeUpdate();
				conn.close();
				System.out.println("Password changed successfully");
			} else {
				throw new RuntimeException("Wrong Username or Password");
			}
		} else {
			throw new RuntimeException("Both the oldPassword and newPasswoed both are same.");
		}

	}

//	Forget Password
	public void forgetPassword(String login) throws Exception {
		UserBean bean = findByLogin(login);
		if (bean != null) {
			System.out.println("Password: " + bean.getPassword());
		} else {
			throw new RuntimeException("User does not exist.");
		}
	}

//	find by id
	public UserBean findById(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}
		return bean;
	}

//	Search() will search multiple record.
//	if SQL injunction is true then we can append as many as quarry in one quarry

	public List search(UserBean bean) throws Exception {
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");
		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '%" + bean.getFirstName() + "%'");
			}
			if (bean.getId() > 0 && bean.getId() < nextPk()) {
				sql.append(" and id like '%" + bean.getId() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '%" + bean.getLastName() + "%'");
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" and login like '%" + bean.getLogin() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" and password like '%" + bean.getPassword() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime())+"'");
			}
		}

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);

		}

		return list;
	}
}
