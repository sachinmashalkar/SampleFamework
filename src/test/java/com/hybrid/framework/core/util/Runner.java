package com.hybrid.framework.core.util;

public class Runner {

	public static void main(String[] args) throws Exception {
		ExcelRead.readExcel();
		ExcelRead.getStudentDetails("Student");
		for(Student student:GlobalConstants.studentList) {
			System.out.println("ID - " + student.getId()
					+", First Name - " + student.getFirstName()
					+", Last Name - " + student.getLastName()
					+", Grade - " + student.getGrade()
					+", Section - " + student.getSection());
		}
	}
}
