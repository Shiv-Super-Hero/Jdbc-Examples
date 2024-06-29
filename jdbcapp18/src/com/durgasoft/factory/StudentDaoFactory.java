package com.durgasoft.factory;

import com.durgasoft.dao.StudentDao;
import com.durgasoft.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentDao = null;
	static {
		studentDao = new StudentDaoImpl();
	}
	public static StudentDao getStudentDao() {
		return studentDao;
		
	}
}
