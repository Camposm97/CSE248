package p11_Multithreading.p14_Order_Taking_System.v1_Non_Multithreaded;

import java.util.LinkedList;

public class OrderQueue {
	private LinkedList<Order> orderList;
	
	
	public OrderQueue() {
		orderList = new LinkedList<>();
	}
	
	public void pushOrder(Order order) {
		orderList.addLast(order);
	}
	
	public Order pullOrder() {
		return orderList.removeFirst();
	}
}
