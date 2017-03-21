package com.gy;

import java.util.Random;

import processing.core.PApplet;
import controlP5.*;

public class BangTest2 extends PApplet {

	ControlP5 cp5;
	Random random = new Random();
	int myColorBackground = 250;

	int[] col = { 100, 150, 200, 250 };

	public void settings() {
		size(1000, 640);
	}

	public void setup() {
		noStroke();
		smooth();
		surface.setResizable(true);
		cp5 = new ControlP5(this);
		for (int i = 0; i < col.length; i++) {
			cp5.addBang("bang" + i).setPosition(40 + 80 * i, 200).setSize(40, 40).setId(i);
		}

		cp5.addBang("bang").setPosition(40, 300).setSize(300, 40).setTriggerEvent(Bang.RELEASE);
	}

	public void controlEvent(ControlEvent theEvent) {
		String name = theEvent.getController().getName();
		for (int i = 0; i < col.length; i++) {
			if (name.equals("bang" + i)) {
				col[i] = (int) (random.nextDouble() * 255);
			}
		}
	}

	public void bang() {
		int color = (int) (random.nextDouble() * 255);
		myColorBackground = color;

	}

	public void draw() {
		background(myColorBackground);
		for (int i = 0; i < col.length; i++) {
			fill(col[i]);
			ellipse(40 + 80 * i, 50, 20, 30);
		}
	}

	public static void main(String[] args) {

		PApplet.main(new String[] { BangTest2.class.getName() });

	}

}
