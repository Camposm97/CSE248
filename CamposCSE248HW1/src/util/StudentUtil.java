package util;

import model.NameFactory;
import model.Student;

public class StudentUtil {
public static final NameFactory nameFactory = new NameFactory();

	public static String emitUsername(Student s) {
		String username = "";
		String lastName = s.getLastName();
		if (isFourChar(lastName))
			username += lastName.substring(0, 4);
		else
			username += lastName;
		username += s.getFirstName().charAt(0);
		username += s.getId().charAt(s.getId().length());
		return username;
	}
	
	public static String emitPassword(Student s) {
		return null;
	}
	
	public static final double emitGPA() {
		return Math.random() * 4.0;
	}
	
	public static boolean isFourChar(String str) {
		return str.length() >= 4;
	}
}
