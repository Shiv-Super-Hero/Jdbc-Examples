package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcapp02 {

	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		Statement st = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = conn.createStatement();
			
			br =  new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.print("Employee Number  :");
				int eno = Integer.parseInt(br.readLine());
				System.out.print("Employee Name  :");
				String ename = br.readLine();
				System.out.print("Employee Salary  :");
				float esal = Float.parseFloat(br.readLine());
				System.out.print("Employee Address  :");
				String eaddr = br.readLine();
				int rowCount = st.executeUpdate("insert into emp2 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
				if(rowCount==1) {
					System.out.println("Employee "+eno+" inserted Successfully");
				}
				System.out.print("One More Employeee[Yes/No]?  :");
				String option = br.readLine();
				if (option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					break;
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				br.close();
				st.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
	}

}
