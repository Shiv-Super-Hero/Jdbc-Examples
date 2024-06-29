package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
		Connection conn  = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:shiv","system","durga");
			st = conn.createStatement();
			int rowCount = st.executeUpdate("select * from emp1");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				rs = st.getResultSet();
				System.out.println("ENO\tENAME\tESAL\tEADDR");
				System.out.println("-----------------------------");
				while (rs.next()) {
					System.out.print(rs.getInt("ENO")+"\t");
					System.out.print(rs.getString("ENAME")+"\t");
					System.out.print(rs.getFloat("ESAL")+"\t");
					System.out.print(rs.getString("EADDR")+"\n");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
