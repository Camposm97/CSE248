package p03_Design_Pattern_Model_View_Controller.view;

import p03_Design_Pattern_Model_View_Controller.model.Student;

public class StudentView {
	public void printStudentDetails(Student s) {
		System.out.println("Student: ");
		System.out.println("Name: " + s.getName());
		System.out.println("ID Number: " + s.getId());
	}
}
