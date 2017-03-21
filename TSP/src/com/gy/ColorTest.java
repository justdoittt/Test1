package com.gy;

import controlP5.*;
import processing.core.PApplet;

public class ColorTest extends PApplet {

	ControlP5 cp5;

	int myColor = color(255);

	int c1, c2;

	float n, n1;

	public void settings() {
		size(400,600);
	}

	public void setup() {
		noStroke();
		cp5 = new ControlP5(this);
		strokeWeight(6);
		noLoop(); // Run once and stop
		surface.setResizable(true);
		// create a new button with name 'buttonA'
		cp5.addButton("colorA").setValue(0).setPosition(100, 100).setSize(200, 19);

		// and add another 2 buttons
		cp5.addButton("colorB").setValue(100).setPosition(100, 120).setSize(200, 19);

		cp5.addButton("colorC").setPosition(100, 140).setSize(200, 19).setValue(0);

		cp5.addButton("play").setValue(128).setPosition(140, 300).updateSize();

		cp5.addButton("playAgain").setValue(128).setPosition(210, 300).updateSize();

	}

	public void draw() {
		background(myColor);
		myColor = lerpColor(c1, c2, n);
		n += (1 - n) * 0.1;
	}

	public void controlEvent(ControlEvent theEvent) {
		println(theEvent.getController().getName());
		n = 0;
	}

	// function colorA will receive changes from
	// controller with name colorA
	public void colorA(int theValue) {
		println("a button event from colorA: " + theValue);
		c1 = c2;
		c2 = color(0, 160, 100);
	}

	// function colorB will receive changes from
	// controller with name colorB
	public void colorB(int theValue) {
		println("a button event from colorB: " + theValue);
		c1 = c2;
		c2 = color(150, 0, 0);
	}

	// function colorC will receive changes from
	// controller with name colorC
	public void colorC(int theValue) {
		println("a button event from colorC: " + theValue);
		c1 = c2;
		c2 = color(255, 255, 0);
	}

	public void play(int theValue) {
		println("a button event from buttonB: " + theValue);
		c1 = c2;
		c2 = color(0, 0, 0);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { ColorTest.class.getName() });
	}
}
