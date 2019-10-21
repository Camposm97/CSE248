package p05_Design_Pattern_Singleton.eager_Initialization;

public class Instructor {
	private static String name;
	private static Instructor _instructor = new Instructor();
	
	private Instructor() {
	} // Prevent Public Constructor, so no one can create an Instructor object
	
	public static Instructor makeTheInstructor(String name) {
		Instructor.setName(name);
		return _instructor;
	}
	
	public static void setName(String name) {
		Instructor.name = name; 
	}
	
	public static String getName() {
		return name;
	}
}
