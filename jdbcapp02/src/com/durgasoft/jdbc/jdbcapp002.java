package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcapp002 {

	public static void main(String[] args) {
		Connection conn  = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			String query = "create table emp2(ENO number primary key, ENAME varchar2(10),ESAL float(5),EADDR varchar2(10))";
			st.executeUpdate(query);
			System.out.println("Table emp2 created Succesfully");
			
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
