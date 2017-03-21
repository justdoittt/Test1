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

	public void setUp() {
		noStroke();// Disables drawing the stroke
		// stroke() Sets the color used to draw lines and borders around shapes.
		smooth();
		gui();
	}

	public void gui() {
		Group g1 = cp5.addGroup("myGroup1").setBackgroundColor(color(0, 64)).setBackgroundHeight(150);
		cp5 = new ControlP5(this);
		cp5.addBang("change").setPosition(10, 20).setSize(100, 100).moveTo(g1);
		;
		accordion = cp5.addAccordion("acc").setPosition(40, 40).setWidth(200).addItem(g1);

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