package util;

import model.NameFactory;
import model.Student;

public class StudentFactory {
	private NameFactory nameFac;
	
	public StudentFactory() {
		nameFac = new NameFactory();
	}
	
	public double emitGPA() {
		return Math.random() * 4.0;
	}
	
}
