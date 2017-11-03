package com.tas.TasSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tas.util.Access;


public class TasSQL {
	private static Connection conn=null;
	public static Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url=Access.URL;
			String db_name=Access.SQL_NAME;
			String db_pass=Access.SQL_PASS;
			conn=DriverManager.getConnection(url, db_name, db_pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
