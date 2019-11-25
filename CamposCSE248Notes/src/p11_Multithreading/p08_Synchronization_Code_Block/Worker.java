package p11_Multithreading.p08_Synchronization_Code_Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public void fillList1() {
		synchronized (lock1) { // Whoever wants to run this block of code, you have to have a lock to do it
			list1.add(random.nextInt(100)); // Add Integer 0-99
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fillList2() {
		synchronized (lock2) {
			list2.add(random.nextInt(100));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void process() {
		for (int i = 0; i < 10; i++) {
			fillList1();
			fillList2();
		}
	}

	public void main() {
		Thread t1 = new Thread(() -> {
			process();
		});
		Thread t2 = new Thread(() -> {
			process();
		});
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("Time Taken: " + (end - start));
		System.out.println("List1 " + list1.size());
		System.out.println("List2 " + list2.size());
	}
}
