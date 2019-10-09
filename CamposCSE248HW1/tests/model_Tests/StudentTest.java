package model_Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.Student;

class StudentTest {
	@Test
	void testId() {
		Student s = new Student("Michael", "Campos", 3.9);
		assertEquals("00000000", s.getId());
	}
	
	@Test 
	void testUsername() {
		Student s = new Student("Michael", "Campos", 3.9);
		System.out.println(s);
		assertEquals("CampM2", s.getUsername());
	}
	
	@Test 
	void testPassword() {
		Student s = new Student("Michael", "Campos", 3.9);
		System.out.println(s);
		assertEquals("CampM4", s.getPassword());
	}
	
	@Test
	void testFirstName() {
		Student s = new Student("Michael", "Campos", 3.9);
		assertEquals("Michael", s.getFirstName());
		s.setFirstName("Mike");
		assertEquals("Mike", s.getFirstName());
	}
	
	@Test void testLastName() {
		Student s = new Student("Michael", "Campos", 3.9);
		assertEquals("Campos", s.getLastName());
		s.setLastName("Campus");
		assertEquals("Campus", s.getLastName());
	}
}
