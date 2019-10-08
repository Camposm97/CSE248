package util;

public class StringUtil {
	public static String emitUsername(String firstName, String lastName, String id) {
		String username = "";
		if (isFourChar(lastName))
			username += lastName.substring(0, 4);
		else
			username += lastName;
		username += Character.toUpperCase(firstName.charAt(0));
		username +=
		return username;
	}
	
	public static String emitPassword(String firstName, String lastName, String id) {
		String password = emitUsername(firstName, lastName, id);
		
		return null;
	}
	
	public static boolean isFourChar(String str) {
		return str.length() >= 4;
	}
}
