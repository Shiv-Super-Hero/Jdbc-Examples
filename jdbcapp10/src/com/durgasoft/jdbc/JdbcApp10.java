package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp10 {

	public static void main(String[] args) {
		Connection conn  = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","durga");
			st = conn.createStatement();
			boolean b = st.execute("select * from emp1");
			System.out.println(b);
			rs = st.getResultSet();
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-----------------------------");
			while(rs.next()) {
			System.out.print(rs.getInt("ENO")+"\t");
			System.out.print(rs.getString("ENAME")+"\t");
			System.out.print(rs.getFloat("ESAL")+"\t");
			System.out.print(rs.getString("EADDR")+"\n");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			st.close();
			conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
