package com.gy;

import java.util.ArrayList;
import java.util.List;

public class SwitchUtilsTest {

	public static void main(String[] args) {

		List<Point> testList = new ArrayList<Point>();
		for (int i = 0; i < 5; i++) {
			float c = 0.1f;
			testList.add(new Point(i + c, i + c, i));

		}
		SwitchUtils.exchange(testList, 0, 4);
		SwitchUtils.exchange(testList, 1, 2);
		for (Point p : testList) {
			System.out.println(p);
		}

	}

}
