package p04_Design_Pattern_Observer.p1;

import java.util.ArrayList;

public class Student implements Observable {
	private ArrayList<Observer> observerList;
	private String name;
	private double gpa;

	public Student(String name, double gpa) {
		this.observerList = new ArrayList<>();
		this.name = name;
		this.gpa = gpa;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
		notifyObservers();
	}

	@Override
	public void register(Observer o) {
		observerList.add(o);
	}

	@Override
	public void unregister(Observer o) {
		int index = observerList.indexOf(o);
		observerList.remove(index);
		System.out.println("Observer " + (index + 1) + " removed.");
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observerList) {
			o.update(name, gpa);
		}
	}
}
