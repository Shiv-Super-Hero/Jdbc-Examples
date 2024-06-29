package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcApp01 {

	public static void main (String[] args) throws Exception{
		//Load and Register Driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		//Establish Connection between java application and Database
		Connection conn = DriverManager.getConnection("jdbc:odbc:shiv", "system", "durga");
		
		//Create Statement
		
		Statement st = conn.createStatement();
		
		//Create Buffered Reader and take table as dynamic input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Table Name  :");
		String table_Name = br.readLine();
		
		//Write SQL Query
		String query = "create table "+table_Name+"(ENO number(3) primary key,ENAME varchar2(10),ESAL float(5),EADDR varchar2(10) ";
		
		//Execute SQL Query
		st.executeUpdate(query);
		System.out.println("Table "+table_Name+"Created Successfully");
		
		//Close the resources
		br.close();
		st.close();
		conn.close();
	}

}
