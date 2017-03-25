package com.gy;

import java.text.DecimalFormat;

public class Point implements Cloneable {

	private float x;
	private float y;
	private int id;

	public Point(float x, float y, int id) {
		super();
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void format() {
		DecimalFormat df = new DecimalFormat("#.00");
		df.format(this.x);
		df.format(this.y);
	}

	public String toString() {

		return "ID:" + this.id + " " + this.x + " " + this.y;

	}

	protected Point clone() {

		Point clone = null;

		try {
			clone = (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clone;
	}

}
