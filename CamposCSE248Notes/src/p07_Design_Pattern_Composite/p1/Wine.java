package p07_Design_Pattern_Composite.p1;

public class Wine implements IItem {
	private String producer;
	private String vintage; // the year the wine was made
	private int abv; // alcohol by volume (how strong it is)
	private double price;

	public Wine(String producer, String vintage, int abv, double price) {
		this.producer = producer;
		this.vintage = vintage;
		this.abv = abv;
		this.price = price;
	}

	@Override
	public void print() {
		System.out.println("Producer: " + producer);
		System.out.println("Vintage: " + vintage);
		System.out.println("ABV: " + abv);
		System.out.println("Price: " + price);
		System.out.println();
	}
}
