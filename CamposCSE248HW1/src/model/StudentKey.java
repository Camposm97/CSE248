package model;

public class StudentKey {
	private String id;
	private String lastName;
	
	public StudentKey(String id, String lastName) {
		this.id = id;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object obj) {
		StudentKey key = (StudentKey) obj;
		if (key == null) {
			return false;
		}
		if (key.id.equals(this.id) || key.lastName.equals(this.lastName)) {
			return true;
		}
		return false;
	}
}
