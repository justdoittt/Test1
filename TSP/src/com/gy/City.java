package com.gy;

import java.text.DecimalFormat;

//����������
//����N�����У�����·��Ϊcity[0]->city[1]->...->city[N-1]->city[0]
public class City implements Cloneable {
	private String name;
	private double x;// ����
	private double y;// ά��

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

	public float[] convert() {// ��γ��ת��Ϊ��������ϵ
		float[] temp = { 0, 0 };
		double lon = this.x;
		double lat = this.y;
		double L = 6381372 * Math.PI * 2;// �����ܳ�
		double W = L;// ƽ��չ����x������ܳ�
		double H = L / 2;// y��Լ�����ܳ�һ��
		double mill = 2.3;// ����ͶӰ�е�һ����������Χ��Լ������2.3֮��
		double xx = lon * Math.PI / 180;// �����ȴӶ���ת��Ϊ����
		double yy = lat * Math.PI / 180;// ��γ�ȴӶ���ת��Ϊ����
		yy = 1.25 * Math.log(Math.tan(0.25 * Math.PI + 0.4 * yy));// ����ͶӰ��ת��
		// ����תΪʵ�ʾ���
		xx = (W / 2) + (W / (2 * Math.PI)) * xx;
		yy = (H / 2) - (H / (2 * mill)) * yy;
		temp[0] = (float)xx; // longtitude to xx
		temp[1] = (float)yy; // latitude to yy
		return temp;
	}
}// end City