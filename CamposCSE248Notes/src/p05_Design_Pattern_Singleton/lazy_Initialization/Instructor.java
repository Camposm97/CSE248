package p05_Design_Pattern_Singleton.lazy_Initialization;

public class Instructor {
	private static String name;
	private static Instructor instructor;
	
	private Instructor(String name) {
		Instructor.name = name;
	}
	
	public static Instructor makeTheInstructor(String name) {
		if (instructor == null)
			instructor = new Instructor(name);
		return instructor;
	}
	
	public static void setName(String name) {
		Instructor.name = name; 
	}
	
	public static String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Instructor [name=" + name + "]";
	}
}
