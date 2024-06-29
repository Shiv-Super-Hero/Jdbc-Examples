package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import oracle.jdbc.driver.OracleDriver;

public class JdbcApp07 {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection conn = null;
		Statement st = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			
			scanner = new Scanner(System.in);
			System.out.print("Salary Range  : ");
			float sal_Range = scanner.nextFloat();
			int row_Count = st.executeUpdate("delete from emp1 where ESAL < "+sal_Range);
			System.out.println("Records Deleted  :  "+row_Count);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				scanner.close();
				st.close();
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
