package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp11 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			
			boolean b = st.execute("update emp1 set ESAL = ESAL + 500 where ESAL < 32500");
			System.out.println(b);
			
			int rowCount = st.getUpdateCount();
			System.out.println("Records Updated  : "+rowCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
