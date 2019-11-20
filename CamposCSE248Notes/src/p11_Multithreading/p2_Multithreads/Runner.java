package p11_Multithreading.p2_Multithreads;

public class Runner extends Thread {
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("Hello World! " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
