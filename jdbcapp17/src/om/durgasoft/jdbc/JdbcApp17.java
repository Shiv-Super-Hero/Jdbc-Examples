package om.durgasoft.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp17 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
			rs = st.executeQuery("select * from emp1");
			String data = "";
			data = data+ "ENO,ENAME,ESAL,EADDR\n";
			while(rs.next()) {
				data = data+rs.getInt("ENO")+",";
				data = data+rs.getString("ENAME")+",";
				data = data+rs.getFloat("ESAL")+",";
				data = data+rs.getString("EADDR")+"\n"; 
			}
			fos = new FileOutputStream("D:\\Wallpapers\\JAVAAPP\\abc.txt");
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("Data Successfully transferred to D:\\Wallpapers\\JAVAAPP\\abc.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null) {
					fos.close();
				}
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
