package p03_Design_Pattern_MVC.app;

import p03_Design_Pattern_MVC.controller.StudentController;
import p03_Design_Pattern_MVC.model.Student;
import p03_Design_Pattern_MVC.view.StudentView;

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
