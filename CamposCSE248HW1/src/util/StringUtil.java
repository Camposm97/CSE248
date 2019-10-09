package util;

import model.Student;

public class StringUtil {
	public static String formatId(String id) {
		final int ID_LENGTH = 8;
		for (int i = id.length(); i < ID_LENGTH; i++) {
			id = "0" + id;
		}
		return id;
	}
	
	public static String formatStudent(Student s) {
		String str = "ID: " + s.getId() + "\n";
		str += "First Name: " + s.getFirstName() + "\n";
		str += "Last Name: " + s.getLastName() + "\n";
		str += "GPA: " + s.getGpa() + "\n";
		str += "Username: " + s.getUsername() + "\n";
		str += "Password: " + s.getPassword() + "\n";
		return str;
	}
	
	public static String emitUsername(String firstName, String lastName, String id) {
		String username = "";
		if (isFourChar(lastName))
			username += lastName.substring(0, 4);
		else
			username += lastName;
		username += Character.toUpperCase(firstName.charAt(0));
		username += id.charAt(id.length() - 1);
		return username;
	}
	
	public static String emitPassword(String firstName, String lastName, String id) {
		String password = emitUsername(firstName, lastName, id);
		char c = Character.toUpperCase(password.charAt(0));
		password = c + password.substring(1, password.length());
		return password;
	}
	
	public static boolean isFourChar(String str) {
		return str.length() >= 4;
	}
}
