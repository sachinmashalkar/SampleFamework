package com.hybrid.framework.core.util;

public class Student {

	private int id;
	String firstName, lastName, grade, section;

	public int getId() {
		return id;
	}

	public void setId(double d) {
		this.id = (int) d;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
