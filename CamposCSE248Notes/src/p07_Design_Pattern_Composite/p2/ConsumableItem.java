package p07_Design_Pattern_Composite.p2;

 public abstract class ConsumableItem {
	private double price;

	public ConsumableItem(double price) {
		super();
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public abstract void print();
	
	@Override
	public String toString() {
		return String.valueOf(price);
	}
}
