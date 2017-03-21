package com.gy;

import java.util.Random;

import controlP5.*;
import processing.core.PApplet;

public class BangTest extends PApplet {

	ControlP5 cp5;
	Random random = new Random();
	int myColorBackground = 250;

	int [] col =  {100,150,200,250
	};

	public void settings(){
		size(400, 600);
		
	}
	public void setup() {
	  noStroke();
	  cp5 = new ControlP5(this);
	  for (int i=0;i<col.length;i++) {
	    cp5.addBang("bang"+i)
	       .setPosition(40+i*80, 200)
	       .setSize(40, 40)
	       .setId(i)
	       ;
	  }
	  
	  // change the trigger event, by default it is PRESSED.
	  cp5.addBang("bang")
	     .setPosition(40, 300)
	     .setSize(280, 40)
	     .setTriggerEvent(Bang.RELEASE)//the event is triggered when the bang is released
	     .setLabel("changeBackground")
	     ;
	           
	}

	public void draw() {
	  background(myColorBackground);
	  for (int i=0;i<col.length;i++) {
	    fill(col[i]);
	    rect(40+i*80, 50, 40, 80);
	  }
	}


	public void bang() {
	  int theColor = (int)(random.nextDouble()*255);
	  myColorBackground = color(theColor);
	}

	public void controlEvent(ControlEvent theEvent) {
	  for (int i=0;i<col.length;i++) {
	    if (theEvent.getController().getName().equals("bang"+i)) {
	      col[i] = (int)(random.nextDouble()*255);
	    }
	  }
	  
	}

	public static void main(String[] args) {

		PApplet.main(new String[] { BangTest.class.getName() });
	}

}
