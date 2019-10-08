package util;

import model.NameFactory;
import model.Student;

public class StudentFactory {
	private NameFactory nameFac;
	
	public StudentFactory() {
		
	}
	
	public double emitGPA() {
		return Math.random() * 4.0;
	}
	
}
