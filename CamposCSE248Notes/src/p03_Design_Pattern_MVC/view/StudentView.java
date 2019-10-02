package p03_Design_Pattern_MVC.view;

import p03_Design_Pattern_MVC.model.Student;

public class StudentView {
	public void printStudentDetails(Student s) {
		System.out.println("Student: ");
		System.out.println("Name: " + s.getName());
		System.out.println("ID Number: " + s.getId());
	}
}
