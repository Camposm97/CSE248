package p11_Multithreading.p11_Wait_and_Notify;

import java.util.Scanner;

public class Processor {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Procducer is producing");
			wait();
			System.out.println("Producer resumed");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner in = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key...");
			in.nextLine();
			System.out.println("Return key pressed");
			notify();
			Thread.sleep(2000);
		}
	}
}
