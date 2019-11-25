package p11_Multithreading.p05_Multithreads_Lambda;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> { // Lambda Expression, no need to create instance of Runnable
			for (int i = 0; i < 10; i++) {
				System.out.println("Hello World! " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		new Thread(() -> { // Lambda Expression
			for (int i = 0; i < 10; i++) {
				System.out.println("Hello World! " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start(); // Call start() after defining run() method
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Done! " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
