package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcapp003 {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = conn.createStatement();
			scanner = new Scanner(System.in);
			System.out.print("Salary Range  :");
			float sal_Range = scanner.nextFloat();
			System.out.print("Bonus Amount  :");
			int bonus_Amt = scanner.nextInt();
			int rowCount = st.executeUpdate("update emp1 set ESAL = ESAL+ "+bonus_Amt+" where ESAL < "+sal_Range );
			System.out.println("No. of Records Updated  :"+rowCount);
		}catch (Exception e) {
			e.printStackTrace();

	}finally {
		try {
			scanner.close();
			st.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
}