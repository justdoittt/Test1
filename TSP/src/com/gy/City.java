package com.gy;

import java.text.DecimalFormat;

//旅行商问题
//共有N个城市，假设路线为city[0]->city[1]->...->city[N-1]->city[0]
public class City implements Cloneable{
	private String name;
	private double x;// 经度
	private double y;// 维度

	public City(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.format();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void format() {
		DecimalFormat df = new DecimalFormat("#.00");
		df.format(this.x);
		df.format(this.y);
	}

	public String toString() {
		return "(" + this.name + "," + this.x + "," + this.y + ")";
	}

	protected City clone() throws CloneNotSupportedException {
		return (City)super.clone();
	}
}// end City