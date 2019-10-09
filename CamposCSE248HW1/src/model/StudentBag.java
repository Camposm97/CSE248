package model;

import java.util.HashMap;
import java.util.Map;

public class StudentBag {
	private double totalGpa;
	private HashMap<String, Student> idMap;
	private HashMap<String, Student> lastNameMap;
	
	public StudentBag(int maxSize) {
		this.totalGpa = 0;
		idMap = new HashMap<>(maxSize);
		lastNameMap = new HashMap<>(maxSize);
	}
	
	public void insert(Student s) {
		idMap.put(s.getId(), s);
		lastNameMap.put(s.getLastName(), s);
		totalGpa += s.getGpa();
	}
	
	public Student findById(String id) {
		Student s = idMap.get(id);
		return s;
	}
	
	public Student findByLastName(String lastName) {
		Student s = lastNameMap.get(lastName);
		return s;
	}
	
	public Student deleteById(String id) {
		Student s = idMap.remove(id);
		if (s != null) {
			lastNameMap.remove(s.getLastName());
			totalGpa -= s.getGpa();
		}
		return s;
	}
	
	public Student deleteByLastName(String lastName) {
		Student s = lastNameMap.remove(lastName);
		if (s != null) {
			idMap.remove(s.getId());
			totalGpa -= s.getGpa();
		}
		return s;
	}
	
	public double getAverageGpa() {
		return totalGpa / size();
	}
	
	public int size() {
		return (idMap.size() + lastNameMap.size()) / 2;
	}
}
