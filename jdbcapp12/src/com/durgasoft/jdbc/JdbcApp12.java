package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp12 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:shiv", "system", "durga");
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("update emp1 set ESAL = ESAL + 500 where ESAL < 36000");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
