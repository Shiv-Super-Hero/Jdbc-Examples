package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp08 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			conn = DriverManager.getConnection("jdbc:odbc:shiv","system","durga");
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			
			int rowCount1 = st.executeUpdate("create table emp10 (ENO number(3) primary key, ENAME varchar2(10))");
			System.out.println(rowCount1);
			
			int rowCount2 = st.executeUpdate("drop table emp10");
			System.out.println(rowCount2);
		}catch(Exception e) {
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
