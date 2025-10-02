package com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Step one make class as final class so that child can not be created
public final class JDBCDataSource {
//	step two make a self type of private static variable/ attribute
//	private static variable/ attribute has single copy in its life time
	private static JDBCDataSource dataSource = null;
	private static ComboPooledDataSource cpds = null;
//	Step three make default constructor as private so that the object can not be created. or other class can not be able to create the instance of this class
	private JDBCDataSource() {
		
	}
//	Step four make a getInstance() which returns same type of instance
	private static JDBCDataSource getInstance() {
		if (dataSource == null) {
			dataSource = new JDBCDataSource();
			dataSource.cpds = new ComboPooledDataSource();
			ResourceBundle rb =ResourceBundle.getBundle("com.rays.bundel.app");
			try {
				dataSource.cpds.setDriverClass(rb.getString("driver"));
				dataSource.cpds.setJdbcUrl(rb.getString("url"));
				dataSource.cpds.setUser(rb.getString("username"));
				dataSource.cpds.setPassword(rb.getString("password"));	
				dataSource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
				dataSource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
				dataSource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
				dataSource.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataSource;
		
	}
	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
	}
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
