package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp04 {

	public static void main(String[] args) {
		BufferedReader br = null;
		Statement st = null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Table Name   :");
			String tname = br.readLine();
			String primary_Key_Cols = "";
			String query = "";
			query = query + "create table "+tname+"(";
			int primary_Key_Count = 0;
			
			while(true) {
				System.out.print("Column Name:");
				String col_Name = br.readLine();
				System.out.print("Cloumn Data Type and Size	:");
				String col_Type_Size = br.readLine();
				System.out.print("Is it Primary Key Column[Yes/No]   :");
				String primary_Key_Option = br.readLine();
				if (primary_Key_Option.equalsIgnoreCase("yes")) {
					primary_Key_Count = primary_Key_Count+1;
					if (primary_Key_Count == 1) {
						primary_Key_Cols = primary_Key_Cols + col_Name;
					}
					else {
						primary_Key_Cols = primary_Key_Cols+","+col_Name;
					}
				}
				query = query + col_Name+" "+col_Type_Size;
				
				System.out.print("One more Column? [Yes/No]    :");
				String option = br.readLine();
				
				if (option.equalsIgnoreCase("yes")) {
					query = query+",";
					continue;
				}else {
					query = query + "," + "primary key(" + primary_Key_Cols +"))";
					break;
				}	
			}
			st.executeUpdate(query);
			System.out.println("Table "+tname+" is Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
