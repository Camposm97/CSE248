package p04_Design_Pattern_Observer.p2;

import java.util.Observable;

public class Student extends Observable {
	private String name;
	private double gpa;

	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
		this.setChanged();
		this.notifyObservers("Gpa Changed");
	}
}
