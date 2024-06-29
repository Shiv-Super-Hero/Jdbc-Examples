package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class JdbcApp09 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			OracleDriver driver = new OracleDriver();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tENO\tEADDR");
			System.out.println("---------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");
				System.out.print(rs.getString(4)+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
