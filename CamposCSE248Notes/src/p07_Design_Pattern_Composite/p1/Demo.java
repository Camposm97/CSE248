package p07_Design_Pattern_Composite.p1;

public class Demo {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("Bill", "Left 5", 50.00);
		Wine w1 = new Wine("Bill's", "2009", 1, 29.99);
		ItemList list = new ItemList();
		list.add(t1);
		list.add(w1);
		list.printAllItems();
	}

}
