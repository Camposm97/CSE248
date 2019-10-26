package p04_Design_Pattern_Observer.p1;

public class Demo {
	public static void main(String[] args) {
		Student s1 = new Student("Michael", 4.0); // Subject
		StudentObserver o1 = new StudentObserver(s1);
		StudentObserver o2 = new StudentObserver(s1);
		s1.unregister(o2);
		s1.setGpa(3.9);
	}
}
