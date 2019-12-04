package p11_Multithreading.p14_Order_Taking_System.v2_Multithreaded;

public class OrderTaker extends Thread {
	private static int orderNum = 0;
	
	private int count = 0;
	private int maxOrders;
	private OrderQueue orderQueue;
	
	public OrderTaker(int orderCount, OrderQueue orderQueue) {
		this.maxOrders = orderCount;
		this.orderQueue = orderQueue;
	}
	
	public void run() {
		Order order;
		while (count < maxOrders) {
			order = new Order(getOrderNum());
			orderQueue.pushOrder(order);
			System.out.println(order.toString() + " created by " + this.getName());
			count++;
		}
	}
	
	public static synchronized int getOrderNum() {
		return orderNum++;
	}
}
