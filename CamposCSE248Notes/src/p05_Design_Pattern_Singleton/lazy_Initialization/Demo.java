package p05_Design_Pattern_Singleton.lazy_Initialization;

import p05_Design_Pattern_Singleton.eager_Initialization.Instructor;

public class Demo {
	public static void main(String[] args) {
		Instructor i1 = Instructor.makeTheInstructor("Bill");
		System.out.println(i1.getName());
		Instructor i2 = Instructor.makeTheInstructor("Adam");
		System.out.println(i2.getName());
		System.out.println(i1 == i2);
		System.out.println(i2);
		i2.setName("Adam");
		System.out.println(i1.toString());
	}
}
