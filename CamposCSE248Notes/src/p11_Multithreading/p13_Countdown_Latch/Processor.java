package p11_Multithreading.p13_Countdown_Latch;

import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable {
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Starting..." + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed " + Thread.currentThread().getName());
		latch.countDown(); // Like a counter, the latch will count down
	}	
}
