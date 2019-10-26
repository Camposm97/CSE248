package p07_Design_Pattern_Composite.p2;

public class Demo {
	public static void main(String[] args) {
		Ticket t1 = new Ticket(50.00, "Bill", "10/23/2019");
		Wine w1 = new Wine(19.99, "Bill's", 1);
		ItemList list = new ItemList();
		list.add(t1);
		list.add(w1);
		list.printAllItems();
	}
}
