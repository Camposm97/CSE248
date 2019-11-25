package p11_Multithreading.p08_Synchronization_Code_Block;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		Worker worker = new Worker();
		worker.main();
	}
}
