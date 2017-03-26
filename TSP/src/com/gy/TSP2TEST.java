package com.gy;

import java.util.List;

public class TSP2TEST {

	public static void main(String[] args) {
		TSP2 t = new TSP2(10);
		List<Point> origin = t.getPath();
		for (Point p : origin) {
			System.out.print(p.getId() + " ");
		}
		System.out.println();
		System.out.println("______________________________________");
		for (int i = 0; i < 10; i++) {
			t.change(t.path);
		}
		List<Point> changed = t.getPath();
		for (Point pp : changed) {
			System.out.print(pp.getId() + " ");
		}
	}

}
