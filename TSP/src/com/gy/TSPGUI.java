package com.gy;

import controlP5.Accordion;
import controlP5.ControlP5;
import controlP5.Group;
import processing.core.PApplet;

public class TSPGUI extends PApplet {

	ControlP5 cp5;
	Accordion accordion;
	int c = color(0, 160, 100);

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		noStroke();// Disables drawing the stroke
		// stroke() Sets the color used to draw lines and borders around shapes.
		smooth();
	}


	public void change() {
		c = color(random(255), random(255), random(255), random(128, 255));
	}

	public void draw() {
		background(220);
		fill(c);// Sets the color used to fill shapes.
		float s1 = 100, s2 = 200;
		ellipse(200, 400, s1, s1);// control the radius of the circle
		ellipse(300, 100, s2, s2);

	}

	public static void main(String[] args) {

		PApplet.main(new String[] { TSPGUI.class.getName() });
	}

}