package p07_Design_Pattern_Composite.p2;

public class Wine extends ConsumableItem {
	private String producer;
	private int abv;

	public Wine(double price, String producer, int abv) {
		super(price);
		this.producer = producer;
		this.abv = abv;
	}

	@Override
	public void print() {
		System.out.println("Producer: " + producer);
		System.out.println("ABV: " + abv);
		System.out.println("Price: " + getPrice());
	}
}
