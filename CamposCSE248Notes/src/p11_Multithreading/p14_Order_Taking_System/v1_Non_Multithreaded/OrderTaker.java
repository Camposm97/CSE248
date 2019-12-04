package p11_Multithreading.p14_Order_Taking_System.v1_Non_Multithreaded;

public class OrderTaker {

	public OrderTaker(OrderQueue orderQueue, Order order) {
		orderQueue.pushOrder(order);
	}
}
