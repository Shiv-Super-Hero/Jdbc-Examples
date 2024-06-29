package com.durgasoft.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.durgasoft.dto.Student;
import com.durgasoft.factory.ConnectionFactory;
import com.durgasoft.factory.StudentServiceFactory;
import com.durgasoft.service.StudentService;

public class Test {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println();
			System.out.println("1.ADD Student");
			System.out.println("2.SEARCH Student");
			System.out.println("3.UPDATE Student");
			System.out.println("4.DELETE Student");
			System.out.println("5.EXIT");
			System.out.print("Your Option [1,2,3,4,5] : ");
			int option = Integer.parseInt(br.readLine());
			String sid = "";
			String sname = "";
			String saddr = "";
			Student student = null;
			String status = "";
			StudentService studentService = null;
			switch (option) {
			case 1:
				System.out.println("====ADD Student Module====");
				System.out.print("Student Id  : ");
				sid = br.readLine();
				System.out.print("Student Name  : ");
				sname = br.readLine();
				System.out.print("Student Address  : ");
				saddr = br.readLine();
				student = new Student();
				student.setSid(sid);
				student.setSname(sname);
				student.setSaddr(saddr);
				
				studentService = StudentServiceFactory.getStudentService();
				status = studentService.addStudent(student);
				System.out.println(status);
				
				break;
				
			case 2:
				System.out.println("===== Search Student Module=====");
				System.out.print("Student ID  : ");
				sid  = br.readLine();
				studentService = StudentServiceFactory.getStudentService();
				student = studentService.searchStudent(sid);
				if(student == null) {
					System.out.println("Student Not Existed");
				}else {
					System.out.println();
					System.out.println("Student Details");
					System.out.println("------------------------");
					System.out.println("Student Id  : "+student.getSid());
					System.out.println("Student Name  : "+student.getSname());
					System.out.println("Student Address  : "+student.getSaddr());
				}
				break;
				
			case 3:
				System.out.println("======UPDATE Student Module=======");
				System.out.print("Student Id  : ");
				sid = br.readLine();
				studentService = StudentServiceFactory.getStudentService();
				student = studentService.searchStudent(sid);
				if(student == null) {
					System.out.println("Student Not Existed");
				}else {
					System.out.print("Student Name  [Old : "+student.getSname()+"] New : ");
					sname = br.readLine();
					if(sname == null || sname.equals("")) {
						sname = student.getSname();
					}
					
					System.out.print("Student Address  [Old : "+student.getSaddr()+"] New : ");
					saddr = br.readLine();
					if(saddr == null || saddr.equals("")) {
						saddr = student.getSaddr();
					}
					
					student = new Student();
					student.setSid(sid);
					student.setSname(sname);
					student.setSaddr(saddr);
					
					status =  studentService.updateStudent(student);
					System.out.println(status);
				}
				break;
				
			case 4:
				System.out.println("=======DELETE Student Module======");
				System.out.print("Student Id  : ");
				sid = br.readLine();
				studentService = StudentServiceFactory.getStudentService();
				student = studentService.searchStudent(sid);
				if(student == null) {
					System.out.println("Student Not Existed");
				}else {
					status = studentService.deleteStudent(sid);
					System.out.println(status);
				}
				break;
				
			case 5:
				System.out.println("******Thank You for using Student Application******");
				ConnectionFactory.cleanUp();
				System.exit(0);
				break;

			default:
				System.out.println("Enter the option from 1,2,3,4 and 5");
				break;
			}
		}

	}

}
