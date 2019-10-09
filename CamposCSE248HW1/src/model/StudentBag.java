package model;

import java.util.HashMap;
import java.util.Map;

public class StudentBag {
	private HashMap<String, Student> studentMap;
	
	public StudentBag(int maxSize) {
		studentMap = new HashMap<>(maxSize);
	}
	
	public void insert(Student s) {
		studentMap.put(s.getId(), s);
	}
	
	public Student findById(String id) {
//		StudentKey key = new StudentKey(id, null);
		Student s = studentMap.get(id);
		return s;
	}
	
	public Student findByLastName(String lastName) {
		StudentKey key = new StudentKey(null, lastName);
		Student s = studentMap.get(key);
		return s;
	}
	
	public Student deleteById(String id) {
//		StudentKey key = new StudentKey(id, null);
		Student s = studentMap.remove(id);
		return s;
	}
	
	public Student deleteByLastName(String lastName) {
//		StudentKey key = new StudentKey(null, lastName);
		Student s = studentMap.remove(key);
		return s;
	}
	
	public double getAverageGpa() {
		double averageGpa = 0;
		int count = 0;
		for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
			averageGpa += entry.getValue().getGpa();
			count++;
		}
		return averageGpa / count;
	}
}
