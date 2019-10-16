package p04_Design_Pattern_Observer.p2;

public class Demo {
	public static void main(String[] args) {
		Student s = new Student("Michael", 4.0);
		GpaObserver o1 = new GpaObserver(s);
		s.setGpa(3.9);
		GpaObserver o2 = new GpaObserver(s);
		s.setGpa(4.0);
		s.deleteObserver(o2);
		s.setGpa(0.0);
	}
}
