package com.gy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Calculator c = new Calculator();

	@Before
	public void setUp() {
		c.clear();
	}

	@Test
	public void testAdd() {
		c.add(2);
		c.add(3);
		assertEquals(5, c.getResult());
	}

	@Test
	public void testSub() {
		c.add(5);
		c.sub(2);
		assertEquals(3, c.getResult());
	}

	@Test
	public void testMulti() {
		c.add(2);
		c.multi(7);
		assertEquals(14, c.getResult());
	}

	@Test
	public void testDevide() {
		c.add(12);
		c.devide(4);
		assertEquals(3, c.getResult());
	}

	@Test
	public void testClear() {
		c.clear();
		assertEquals(0, c.getResult());
	}

	@Test
	public void testGetResult() {
		fail("Not yet implemented");
	}

}
