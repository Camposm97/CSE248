package p1;

public class Student {
	private static int idNumber = 0;
	private String id;
	private String firstName;
	private String lastName;
	private double gpa;
	private String username;
	private String password;
	
	public Student() {
		this.id = String.valueOf(idNumber++);
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}
	
	
}
