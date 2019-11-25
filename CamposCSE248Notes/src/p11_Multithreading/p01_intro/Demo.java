package p11_Multithreading.p01_intro;

public class Demo {
	public static void main(String[] args) {
		Runner r1 = new Runner();
		Runner r2 = new Runner();
		r1.run();
		r2.run();
	}

}
