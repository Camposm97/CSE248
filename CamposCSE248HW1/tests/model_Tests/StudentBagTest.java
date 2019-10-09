package model_Tests;

import org.junit.jupiter.api.Test;

import model.Student;
import model.StudentBag;

class StudentBagTest {
	@Test
	void testFindById() {
		StudentBag bag = new StudentBag(10);
		Student s = new Student("Michael", "Campos", 3.9, "", "");
		System.out.println(s.getId());
		bag.insert(s);
		Student s1 = bag.findById("00000000");
		System.out.println(s1);
	}
	
	@Test
	void testDeletById() {
		StudentBag bag = new StudentBag(10);
		Student s = new Student("Michael", "Campos", 3.9, "", "");
		System.out.println(s.getId());
		bag.insert(s);
		Student s1 = bag.deleteById("00000000");
		System.out.println(s1);
	}
}
