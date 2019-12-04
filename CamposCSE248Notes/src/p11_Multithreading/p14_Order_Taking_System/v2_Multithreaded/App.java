package p11_Multithreading.p14_Order_Taking_System.v2_Multithreaded;

public class App {
	public static void main(String[] args) {
		final int TAKER_COUNT = 3; // number f taker threads
		final int ORDER_COUNT = 3; // number of ordersper taker thread
		final int HANDLER_COUNT = 2; // number of OrderHandler threads
		
		OrderQueue queue = new OrderQueue();
		
		System.out.println("Starting " + TAKER_COUNT + " order takers, " + "each producing " + ORDER_COUNT + " orders.");
		System.out.println("Starting " + HANDLER_COUNT + " order handlers.");
		
//		String s = "OrderTaker threads\t\tOrderHandlerThreads\t\t\n--------------------------------------------------------";
//		System.out.println(s);
		
		for (int i = 0; i < TAKER_COUNT; i++) {
			OrderTaker t = new OrderTaker(ORDER_COUNT, queue);
			t.start();
		}
		
		for (int i = 0; i < HANDLER_COUNT; i++) {
			OrderHandler h = new OrderHandler(queue);
			h.start();
		}
		System.out.println("Done!");
	}
}
