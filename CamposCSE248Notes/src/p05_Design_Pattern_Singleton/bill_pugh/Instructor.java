package p05_Design_Pattern_Singleton.bill_pugh;

public class Instructor { // Preferred Way: Multi-threading Advantage
	private static String name;
	private static Instructor ins;
	
	private Instructor() {
		// Prevent people from creating Instructor objects
	}
	
	public static Instructor makeTheInstructor() {
		return SingletonHelper._ins;
	}
	
	public static String getName() {
		return name;
	}
	
	public static void setName(String name) {
		Instructor.name = name;
	}
	
	private static class SingletonHelper { // Inner Class
		private static final Instructor _ins = new Instructor();
	}
}
