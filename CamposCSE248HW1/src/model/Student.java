package model;

import static util.StudentUtil.*;

public class Student {
	private static int idNumber = 0;
	private String id;
	private String firstName;
	private String lastName;
	private double gpa;
	private String username;
	private String password;
	
	public Student() {
		this.id = String.valueOf(idNumber++);
		this.firstName = nameFactory.emitFirstName();
		this.lastName = nameFactory.emitLastName();
		this.gpa = emitGPA();
		this.username = emitUsername(this);
		this.password = emitPassword(this);
	}
	
	public String getId() {
		return id;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
