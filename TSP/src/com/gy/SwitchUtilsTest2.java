package com.gy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class SwitchUtilsTest2 extends TestCase {

	List<Point> testList = new ArrayList<Point>();

	@Test
	public void testExchange() {

		for (int i = 0; i < 3; i++) {
			testList.add(new Point(i + 0.1f, i + 0.1f, i));
		}
		SwitchUtils.exchange(testList, 0, 1);
		SwitchUtils.exchange(testList, 1, 2);
		assertEquals(1, testList.get(0).getId());
		assertEquals(2, testList.get(1).getId());

	}

}
