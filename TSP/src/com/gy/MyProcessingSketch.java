package com.gy;

import processing.core.PApplet;

public class MyProcessingSketch extends PApplet {

	public void settings() {
		size(1000, 800);
	}

	public void setUp() {
		background(mouseX / 2, mouseY / 2, 0);
		ellipse(height / 2, width / 2, 0, 0);
		surface.setResizable(true);
	}

	public void draw() {

	}

	public static void main(String[] args) {
		PApplet.main(new String[] { MyProcessingSketch.class.getName() });
	}

}
