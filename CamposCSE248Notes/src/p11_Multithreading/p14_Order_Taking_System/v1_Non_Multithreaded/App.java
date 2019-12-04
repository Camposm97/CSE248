package p11_Multithreading.p14_Order_Taking_System.v1_Non_Multithreaded;

public class App {

	public static void main(String[] args) {
		OrderQueue myQueue = new OrderQueue();
		
		Order o1 = new Order();
		
		OrderTaker taker1 = new OrderTaker(myQueue, o1);
		OrderHandler handler1 = new OrderHandler(myQueue);
		System.out.println("Order Handled: " + handler1.getOrder());
		
		Order o2= new Order();
		
		OrderTaker taker2 = new OrderTaker(myQueue, o2);
		OrderHandler handler2 = new OrderHandler(myQueue);
		System.out.println("Order Handled: " + handler2.getOrder());
	}
}
