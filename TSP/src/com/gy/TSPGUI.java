package com.gy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controlP5.ControlP5;
import processing.core.PApplet;

public class TSPGUI extends PApplet {

	List<City> path = new ArrayList<City>();
	City[] cities;
	File destfile = new File("C:\\Users\\asus\\Desktop\\location.txt");
	File sourceFile = new File("C:\\\\Users\\\\asus\\\\Desktop\\jiangsu.txt");
	TSP solver = null;
	ControlP5 cp5;

	public void settings() {
		size(1000, 800);
	}

	public void setup() {
		// generatePoints();
		cp5 = new ControlP5(this);
		cp5.addButton("load_data").setPosition(5, 100);
		cp5.addButton("compute").setPosition(5, 130);
		cp5.addButton("display").setPosition(5, 160);
		cp5.addButton("reStart").setPosition(5, 190);
		cp5.addButton("onClear").setPosition(5, 220);
		init();
	}

	public void init() {

		JSFileReader jf = new JSFileReader(sourceFile, destfile);
		String[] lines = jf.readData();
		CityInfo cf = new CityInfo(lines);
		this.cities = cf.getCityInfo();
		solver = new TSP(cities);
		solver.search();
		City[] best = solver.getPath();
		for (int i = 0; i < best.length; i++) {
			path.add(best[i]);
		}

	}

	// public void generatePoints() {
	// for (int i = 0; i < 20; i++) {
	// float x = random(1000);
	// float y = random(800);
	// Point p = new Point(x, y);
	// points.add(p);
	// }
	// }
	
	public float[] reflect(float x,float y){
		float[] temp = new float[2];
		
		return temp;
	}

	public void draw() {
		background(220);
		fill(0);
		// display the original path
		for (int i = 0; i < cities.length; i++) {
			float[] pos = cities[i].convert();
			System.out.println(pos[0]);
			System.out.println(pos[1]);
			ellipse(pos[0], pos[1], 8, 8);
		}
		stroke(255, 0, 0);
		strokeWeight(2);
		for (int i = 0; i < cities.length - 1; i++) {
			float[] posA = cities[i].convert();
			float[] posB = cities[i + 1].convert();
			line(posA[0], posA[1], posB[0], posB[1]);
		} // end for

		// display the optimum path for TSP problem

	}

}