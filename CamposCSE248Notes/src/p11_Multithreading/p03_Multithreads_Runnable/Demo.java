package p11_Multithreading.p03_Multithreads_Runnable;

public class Demo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		t2.start();
		t1.start();
		System.out.println("Done");
	}
}
