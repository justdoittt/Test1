package com.gy;

import java.text.DecimalFormat;

//旅行商问题
//共有N个城市，假设路线为city[0]->city[1]->...->city[N-1]->city[0]
public class City implements Cloneable {
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
		return (City) super.clone();
	}

	public float[] convert() {// 经纬度转换为米勒坐标系
		float[] temp = { 0, 0 };
		double lon = this.x;
		double lat = this.y;
		double L = 6381372 * Math.PI * 2;// 地球周长
		double W = L;// 平面展开后，x轴等于周长
		double H = L / 2;// y轴约等于周长一半
		double mill = 2.3;// 米勒投影中的一个常数，范围大约在正负2.3之间
		double xx = lon * Math.PI / 180;// 将经度从度数转换为弧度
		double yy = lat * Math.PI / 180;// 将纬度从度数转换为弧度
		yy = 1.25 * Math.log(Math.tan(0.25 * Math.PI + 0.4 * yy));// 米勒投影的转换
		// 弧度转为实际距离
		xx = (W / 2) + (W / (2 * Math.PI)) * xx;
		yy = (H / 2) - (H / (2 * mill)) * yy;
		temp[0] = (float)xx; // longtitude to xx
		temp[1] = (float)yy; // latitude to yy
		return temp;
	}
}// end City