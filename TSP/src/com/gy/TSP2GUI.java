package com.gy;

import processing.core.PApplet;

import java.text.DecimalFormat;
import java.util.List;

import controlP5.ControlP5;

public class TSP2GUI extends PApplet {

	private TSP2 tsp;
	private ControlP5 cp5;
	private Point[] points;
	private boolean running = true;
	private List<Point> origin;
	private static double distance = Double.MAX_VALUE;
	private long t0 = 0;

	public void settings() {
		size(1100, 1100);
	}

	public void setup() {

		tsp = new TSP2(30);
		points = tsp.nextGeneration();
		cp5 = new ControlP5(this);
		cp5.addButton("onAdd").setPosition(5, 100).setSize(80, 80).setCaptionLabel("Add points");
		cp5.addButton("onStart").setPosition(5, 190).setSize(80, 80).setCaptionLabel("Start");
		cp5.addButton("onStop").setPosition(5, 280).setSize(80, 80).setCaptionLabel("Stop");
		cp5.addButton("reStart").setPosition(5, 370).setSize(80, 80).setCaptionLabel("Restart");
		cp5.addButton("onClear").setPosition(5, 460).setSize(80, 80).setCaptionLabel("Clear points");
		t0 = System.currentTimeMillis();

	}

	public void draw() {

		background(220);
		stroke(255, 0, 0);
		strokeWeight(2);
		if (points.length > 10 && running) {
			for (int i = 1; i < points.length; i++) {
				line(points[i].getX(), points[i].getY(), points[i - 1].getX(), points[i - 1].getY());
			}
			line(points[0].getX(), points[0].getY(), points[points.length - 1].getX(),
					points[points.length - 1].getY());
			fill(0);
			noStroke();
			for (int i = 0; i < points.length; i++) {
				ellipse(points[i].getX(), points[i].getY(), 8, 8);
			}
			stroke(0);
			fill(0);
			textSize(12);
			long t1 = System.currentTimeMillis();
			long delat_t = t1 - t0;
			DecimalFormat df = new DecimalFormat("#.00");
			double distance = DistanceUtils.sumDistance(points);
			text("point length: " + points.length, 5, 20);
			text("best distance: " + df.format(distance), 5, 65);
			text("time cost: " + delat_t, 5, 45);
			this.searchTwice();
		} // end if

	}

	public void searchTwice() {
		tsp.search();
		if (tsp.getTotalDistance() < distance) {
			this.updatePoints();
		} else {
			return;
		}
	}

	public void updatePoints() {
		distance = tsp.getTotalDistance();
		List<Point> temp = tsp.getPath();
		for (int j = 0; j < temp.size(); j++) {
			points[j] = temp.get(j).clone();
		}
	}

	public void onAdd() {

		if (!running) {

		}

	}

	public void onStart() {
		running = true;
	}

	public void onStop() {
		running = false;
	}

	public void restart() {

	}

	public void onClear() {
		tsp.clear();
	}
}