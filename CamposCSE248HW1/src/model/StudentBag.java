package model;

import java.util.HashMap;

public class StudentBag {
	private HashMap<String, Student> students;
	
	public StudentBag(int maxSize) {
		students = new HashMap<>(maxSize);
	}
	
	public Student findById() {
		return null;
	}
	
	public Student deleteById() {
		return null;
	}
}
