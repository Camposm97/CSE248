package p09_JSON_Data_Exchange;

public class School {
	private String id, name, city, state, zip, url;
	private int latestStudentSize;

	public School(String id, String name, String city, String state, String zip, String url, int latestStudentSize) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.url = url;
		this.latestStudentSize = latestStudentSize;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getUrl() {
		return url;
	}

	public int getLatestStudentSize() {
		return latestStudentSize;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", zip=" + zip + ", url="
				+ url + ", latestStudentSize=" + latestStudentSize + "]";
	}
}
