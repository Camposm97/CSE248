package p03_Design_Pattern_Model_View_Controller.app;

import p03_Design_Pattern_Model_View_Controller.controller.StudentController;
import p03_Design_Pattern_Model_View_Controller.model.Student;
import p03_Design_Pattern_Model_View_Controller.view.StudentView;

public class Demo {
	public static void main(String[] args) {
		Student s = new Student("0", "Michael");
		StudentView sv = new StudentView();
		StudentController sc = new StudentController(s, sv);
		sc.updateView();
		sc.setStudentName("Chris");
		sc.updateView();
	}
}
