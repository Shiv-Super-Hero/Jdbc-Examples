package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test{
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		BufferedReader br = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Table Name    :");
			String tname = br.readLine();
			String query = "create table "+tname+"(ENO number(3) primary key, ENAME varchar2(10), ESAL float(5),EADDR varchar2(10))";
			st.executeUpdate(query);
			System.out.println("Table "+tname+" Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}