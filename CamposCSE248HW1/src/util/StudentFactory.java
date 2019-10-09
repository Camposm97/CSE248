package util;

import model.NameFactory;
import model.Student;

public class StudentFactory {
	private NameFactory nameFac;
	
	public StudentFactory() {
		nameFac = new NameFactory();
	}
	
	public Student emitStudent() {
		String firstName= nameFac.emitFirstName();
		String lastName = nameFac.emitLastName();
		double gpa = emitGPA();
		Student s = new Student(firstName, lastName, gpa, null, null);
		s.setUsername(StringUtils.emitUsername(firstName, lastName, s.getId()));
		s.setPassword(StringUtils.emitPassword(firstName, lastName, s.getId()));
		return s;
	}
	
	public double emitGPA() {
		return Math.random() * 4.0;
	}
	
}
