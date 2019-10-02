package p03_Design_Pattern_MVC.controller;

import p03_Design_Pattern_MVC.model.Student;
import p03_Design_Pattern_MVC.view.StudentView;

public class StudentController {
	private Student model;
	private StudentView view;

	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setStudentName(String name) {
		model.setName(name);
	}
	
	public String getStudentName() {
		return model.getName();
	}
	
	public void setStudentId(String id) {
		model.setId(id);
	}
	
	public String getStudentId() {
		return model.getId();
	}

	public Student getModel() {
		return model;
	}

	public StudentView getView() {
		return view;
	}

	public void updateView() {
		view.printStudentDetails(model);
	}
}
