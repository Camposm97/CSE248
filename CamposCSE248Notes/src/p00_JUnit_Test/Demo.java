package p00_JUnit_Test;

public class Demo {
	public static void main(String[] args) {
		Calculator c = new Calculator(512341);
		c.divide(3);
		System.out.println(c.roundAmount(c.getAmount()));
		c.time(3);
		System.out.println(c.roundAmount(c.getAmount()));
	}
}
