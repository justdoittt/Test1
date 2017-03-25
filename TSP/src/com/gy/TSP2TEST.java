package com.gy;

import java.util.ArrayList;

public class TSP2TEST {

	public static void main(String[] args) {
		TSP2 t = new TSP2(100);
		ArrayList<Point> path = (ArrayList<Point>) t.getPath();
		t.search();
		t.print();
		t.clear();// clear all the points
		t = new TSP2(100);
		t.addPoint();// add another 50 points automatically
		t.search();
		t.print();

	}

}
