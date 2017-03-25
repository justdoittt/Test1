package com.gy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CopyUtils2 {

	public static List<Point> deepCopy(List<Point> src) {
		List<Point> dest = new ArrayList<Point>();
		Iterator<Point> it = src.iterator();
		while (it.hasNext()) {
			dest.add(it.next().clone());
		}
		return dest;
	}

}
