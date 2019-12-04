package p11_Multithreading.p14_Order_Taking_System.v2_Multithreaded;

public class Order {
	private int orderNum = 0;
	
	
	public Order(int orderNum) {
		this.orderNum = orderNum;
		System.out.println("Order# " + orderNum + " is created");
	}
	
	@Override
	public String toString() {
		return "Order #" + orderNum;
	}
}
