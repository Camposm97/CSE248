package p1_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import p00_JUnit_Test.Calculator;

/**
 * Highlight a method to use that method that's being highlighted
 * Not highlighting anything will run all the methods 
 */
class CalculatorTest {
	@Test
	void testTime() {
		Calculator c = new Calculator(5);
		c.time(2);
		assertEquals(10, c.getAmount(), 0.01);
	}
	
	@Test
	void testDivide() {
		Calculator c = new Calculator(10);
		c.divide(0);
		assertNotEquals(5, c.getAmount(), 0.000000001);
	}
	
	@Test
	void testRoundAmount() {
		Calculator c = new Calculator(1);
		System.out.println(c.roundAmount(1234.12345));
		assertEquals("1,234.12", c.roundAmount(1234.12345));
	}
	
	@Test
	void testDenominatorIsZero() {
		Calculator c = new Calculator(5);
		assertTrue(c.denominatorIsZero(0));
	}
}
