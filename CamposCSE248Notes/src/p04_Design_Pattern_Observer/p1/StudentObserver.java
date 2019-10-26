package p04_Design_Pattern_Observer.p1;

public class StudentObserver implements Observer {
	private static int idTracker = 0;
	private int id;
	
	public StudentObserver(Student s) {
		id = idTracker++;
		System.out.println("New Observer registered: " + id);
		s.register(this);
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public void update(String name, double gpa) {
		System.out.println(name + ": " + gpa);
	}
}
