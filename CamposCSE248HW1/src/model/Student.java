package model;

import util.StringUtils;

public class Student {
	private static int idNumber = 0;
	private String id;
	private String firstName;
	private String lastName;
	private double gpa;
	private String username;
	private String password;

	public static String currentID() {
		return String.valueOf(idNumber);
	}
	
	public Student(String firstName, String lastName, double gpa, String username, String password) {
		this.id = StringUtils.formatId(String.valueOf(idNumber++));
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.username = username;
		this.password = password;
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

	public StudentKey getKey() {
		return new StudentKey(id, lastName);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gpa=" + gpa
				+ ", username=" + username + ", password=" + password + "]";
	}
}
