package p11_Multithreading.p14_Order_Taking_System.v1_Non_Multithreaded;

public class Order {
	private static int orderNum = 0;
	
	
	public Order() {
		orderNum++;
		System.out.println("Order# " + orderNum + " is created");
	}
	
	@Override
	public String toString() {
		return "Order #" + orderNum;
	}
}
