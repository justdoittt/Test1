package com.gy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyUtils2Test {

	public static void main(String[] args) {

		List<Point> src = new ArrayList<Point>();
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			src.add(new Point(r.nextFloat(), r.nextFloat(), i));
		}
		List<Point> dest = new ArrayList<Point>();
		dest = CopyUtils2.deepCopy(src);
		for (Point p : dest) {
			System.out.println(p);
		}

	}

}
