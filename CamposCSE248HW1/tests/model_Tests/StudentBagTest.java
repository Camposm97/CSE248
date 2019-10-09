package model_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Student;
import model.StudentBag;

class StudentBagTest {	
	@Test void testInsert() {
		StudentBag bag = new StudentBag(10);
		Student s1 = new Student("Michael", "Campos", 3.9);
		Student s2 = new Student("Chris", "Demonte", 3.9);
		Student s3 = new Student("Matthew", "Guidi", 3.9);
		bag.insert(s1);
		bag.insert(s2);
		bag.insert(s3);
		assertEquals(3, bag.size());
	}
	
	@Test
	void testFindById() {
		StudentBag bag = new StudentBag(10);
		Student s = new Student("Michael", "Campos", 3.9);
		bag.insert(s);
		Student s1 = bag.findById(s.getId());
		assertEquals(s, s1);
	}
	
	@Test 
	void testFindByLastName() {
		StudentBag bag = new StudentBag(10);
		Student s = new Student("Chris", "Demonte", 3.9);
		bag.insert(s);
		Student s1 = bag.deleteByLastName("Demonte");
		assertEquals(s, s1);
		assertEquals(0, bag.size());
	}
	
	@Test
	void testDeletById() {
		StudentBag bag = new StudentBag(10);
		Student s = new Student("Matthew", "Guidi", 3.9);
		bag.insert(s);
		Student s1 = bag.deleteById(s.getId());
		assertEquals(s, s1);
		assertEquals(0, bag.size());
	}
	
	@Test
	void testDeleteByLastName() {
		StudentBag bag = new StudentBag(10);
		Student s = new Student("Jon", "Doe", 3.8);
		bag.insert(s);
		Student s1 = bag.deleteByLastName("Doe");
		assertEquals(s, s1);
		assertEquals(0, bag.size());
	}
	
	@Test
	void testAverageGpa() {
		StudentBag bag = new StudentBag(10);
		Student s1 = new Student("Michael", "Campos", 3.9);
		Student s2 = new Student("Chris", "Demonte", 3.5);
		Student s3 = new Student("Matthew", "Guidi", 3.8);
		bag.insert(s1);
		bag.insert(s2);
		bag.insert(s3);
		double averageGpa = bag.getAverageGpa();
		assertEquals(3.733333333333333, averageGpa);
	}
}
