package p11_Multithreading.p13_Countdown_Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) {
		final int COUNT = 3;
		CountDownLatch latch = new CountDownLatch(COUNT);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 4; i++) {
			executor.submit(new Processor(latch));
		}
		System.out.println("Before latch.await()");
		try {
			latch.await(); // Needs COUNT Threads to complete
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("Done!");
	}
}
