package p11_Multithreading.p14_Order_Taking_System.v2_Multithreaded;

import java.util.LinkedList;

import p11_Multithreading.p14_Order_Taking_System.v2_Multithreaded.Order;

public class OrderQueue {
private LinkedList<Order> orderList;
	
	
	public OrderQueue() {
		orderList = new LinkedList<>();
	}
	
	public synchronized void pushOrder(Order order) {
		orderList.addLast(order);
		notifyAll();
	}
	
	public synchronized Order pullOrder() {
		while (orderList.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return orderList.removeFirst();
	}
}
