package p07_Design_Pattern_Composite.p1;

import java.util.Date;

public class Ticket implements IItem {
	private String name;
	private String location;
	private Date date;
	private double price;
	
	public Ticket(String name, String location, double price) {
		this.name = name;
		this.location = location;
		this.date = new Date();
		this.price = price;
	}
	
	@Override
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Location: " + location);
		System.out.println("Date: " + date);
		System.out.println("Price: " + price);
		System.out.println();
	}

}
