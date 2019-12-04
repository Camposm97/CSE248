package p11_Multithreading.p14_Order_Taking_System.v2_Multithreaded;

public class OrderHandler extends Thread {
	private OrderQueue orderQueue;
	
	public OrderHandler(OrderQueue orderQueue) {
		this.orderQueue = orderQueue;
	}
	
	public void run() {
		Order order;
		while (true) {
			order = orderQueue.pullOrder();
			System.out.println(order + " processed by " + this.getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
