package p11_Multithreading.p06_Synchronization_Methods;

public class Demo {
	private int count;
	
	public static void main(String[] args) throws InterruptedException {
		Demo demo = new Demo();
		demo.doWork();
	}
	
	public void doWork() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("The count is " + count);
	}
	
	private synchronized void increment() { // This method can only be accessed one thread at a time.
		count++;
	}
}
