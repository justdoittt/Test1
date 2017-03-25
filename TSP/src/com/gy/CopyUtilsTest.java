package com.gy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class CopyUtilsTest {

	List<Point> test = new ArrayList<Point>();
	List<Point> copy1 = new ArrayList<Point>();
	Random random = new Random();

	@Test
	public void test() {

		for (int i = 0; i < 10; i++) {
			Point p = new Point(random.nextFloat(), random.nextFloat(), i);
			test.add(p);
		}
		assertEquals(10, test.size());
	}

	@Test
	public void testDeepCopyList() {

		copy1 = CopyUtils.deepCopyList(test);
		assertEquals(false, copy1 == null);

	}

}
