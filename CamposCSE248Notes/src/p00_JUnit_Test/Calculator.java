package p00_JUnit_Test;

import java.util.Scanner;

// A good program is good if it has no comments - Prof. Chen
public class Calculator {
	private Scanner in;
	private double amount;
	
	public Calculator(double amount) {
		this.amount = amount;
		in = new Scanner(System.in);
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void time(double multiplier) {
		amount *= multiplier;
	}
	
	public String roundAmount(double d) {
		return String.format("%,.2f", d);
	}
	
	public void divide(double denominator) {
		if (denominatorIsZero(denominator)) 
			amount = getNewDenominator();
		denominator /= denominator;
	}
	
	public double getNewDenominator() {
		double denominator = 0;
		while (denominator == 0) {
			System.out.print("Enter a new denominator: ");
			denominator = in.nextDouble();
		}
		return denominator;
	}
	
	public boolean denominatorIsZero(double denominator) {
		return (denominator == 0.0);
	}
}
