package util;

public class StringUtils {
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
