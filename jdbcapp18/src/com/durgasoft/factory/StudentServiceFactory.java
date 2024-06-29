package com.durgasoft.factory;

import com.durgasoft.service.StudentService;
import com.durgasoft.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService = null;
	static {
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService() {
		return studentService;
	}
}
