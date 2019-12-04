package p11_Multithreading.p14_Order_Taking_System.v1_Non_Multithreaded;

public class OrderHandler {
	private Order order;
	
	public OrderHandler(OrderQueue orderQueue) {
		this.order = orderQueue.pullOrder();
	}
	
	public Order getOrder() {
		return order;
	}
}
