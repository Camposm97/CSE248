package p11_Multithreading.p07_Synchronization_Variables;

import java.util.Scanner;

public class Processor extends Thread {
	private volatile boolean flag = true; // synchronize the variable
	
	@Override
	public void run() {
		while (flag) {
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		flag = false;
	}
	
	public static void main(String[] args) {
		Processor p1 = new Processor();
		p1.start();
		Scanner in = new Scanner(System.in);
		System.out.println("Press enter to pause: ");
		in.nextLine();
		in.close();
		p1.shutdown();
	}
}
