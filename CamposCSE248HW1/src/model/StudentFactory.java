package model;

public class StudentFactory {
	private NameFactory nameFac;
	
	public StudentFactory() {
		nameFac = new NameFactory();
	}
	
	public Student emitStudent() {
		String firstName= nameFac.emitFirstName();
		String lastName = nameFac.emitLastName();
		double gpa = emitGPA();
		Student s = new Student(firstName, lastName, gpa);
		return s;
	}
	
	public double emitGPA() {
		return Math.random() * 4.0;
	}
	
}
