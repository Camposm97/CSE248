package p04_Design_Pattern_Observer.p2;

import java.util.Observable;
import java.util.Observer;

public class GpaObserver implements Observer {
	private static int idTracker = 0;
	private int id;
	private Student s;
	
	public GpaObserver(Student s) {
		this.id = idTracker++;
		this.s = s;
		s.addObserver(this);
		System.out.println("New Observer: " + id);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(((Student) o).getName() + ": " + ((Student) o).getGpa());
		System.out.println(arg);
	}
}
