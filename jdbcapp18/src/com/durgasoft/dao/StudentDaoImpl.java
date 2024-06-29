package com.durgasoft.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.durgasoft.dto.Student;
import com.durgasoft.factory.ConnectionFactory;
import com.durgasoft.factory.StudentDaoFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		String status = "";
		try {
			Connection conn = ConnectionFactory.getConnection();
			Statement st = conn.createStatement();
			Student std = search(student.getSid());
			if(std == null) {
				int rowCount = st.executeUpdate("insert into student values('"+student.getSid()+"','"+student.getSname()+"','"+student.getSaddr()+"')");
				
				if(rowCount == 1) {
					status = "Student Inserted Successfully";
				}else {
					status = "Student Insertion Failure";
				}
				
			}else {
				status = "Student Existed Already";
			}
			
		} catch (Exception e) {
			status = "Student Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection conn = ConnectionFactory.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from student where SID = '"+sid+"'");
			boolean b = rs.next();
			
			if(b==true) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
				
			}else {
				student = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		String status = "";
		try {
			Connection conn = ConnectionFactory.getConnection();
			Statement st = conn.createStatement();
			int rowCount = st.executeUpdate("update student set SNAME = '"+student.getSname()+"',SADDR = '"+student.getSaddr()+"' where SID = '"+student.getSid()+"'");
			if(rowCount == 1) {
				status = "Student Updated Successfully";
			}else {
				status = "Student Updation Failure";
			}
		} catch (Exception e) {
			status = "Student Updation Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status ="";
		try {
			Connection conn = ConnectionFactory.getConnection();
			Statement st = conn.createStatement();
			int rowCount = st.executeUpdate("delete from student where SID = '"+sid+"'");
			if(rowCount==1) {
				status = "Student deleted Successfully";
			}else {
				status = "Student Deletion Failure";
			}
		} catch (Exception e) {
			status = "Student Deletion Failure";
			e.printStackTrace();
		}
		return status;
	}

}
