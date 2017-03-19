package com.gy;

import java.text.DecimalFormat;
import java.util.Random;

public class TSP {

	public static final int N = 13;
	public City[] cities;
	public static final double temprature = 100;
	public static final double delta = 0.98;
	public static final int iter = 100;
	public static final double Earth_radius = 6378.137;
	public City[] path;
	public double totalDistance;
	public static final double e = 0.001;// 停止迭代温度

	public TSP(City[] c) {

		cities = new City[N];
		for (int i = 0; i < N; i++) {
			try {
				cities[i] = c[i].clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 初始的path
		path = new City[N];
		for (int i = 0; i < N; i++) {
			try {
				path[i] = cities[i].clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end constructor

	private double getDistance(City a, City b) {// 计算两个城市之间的距离，单位为km
		double distance = 0;
		double longtitude1 = a.getX();
		double latitude1 = a.getY();
		double longtitude2 = b.getX();
		double latitude2 = b.getY();
		double a1, b1, sa, sb;
		latitude1 = rad(latitude1);
		latitude2 = rad(latitude2);
		a1 = latitude1 - latitude2;
		b1 = rad(longtitude1 - longtitude2);
		sa = Math.sin(a1 / 2);
		sb = Math.sin(b1 / 2);
		distance = 2 * this.Earth_radius
				* Math.asin(Math.sqrt(sa * sa + Math.cos(latitude1) * Math.cos(latitude2) * sb * sb));
		return distance;
	}

	private double rad(double d) {
		return d * Math.PI / 180;
	}

	private double total_distance(City[] path) {// compute the total distance of
												// TSP

		double total = 0;
		for (int i = 0; i < N - 1; i++) {
			total += getDistance(path[i], path[i + 1]);
		}
		total += getDistance(path[N - 1], path[0]);
		return total;
	}// end total_distance

	public void search() {// solve the TSP problem

		double len1 = total_distance(path);
		double t_temprature = temprature * N;
		City[] temp_cities = new City[N];
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			temp_cities[i] = null;
		}
		while (t_temprature > e) {

			for (int i = 0; i < iter; i++) {
				temp_cities = this.change();
				double len2 = this.total_distance(temp_cities);
				double delta_e = len2 - len1;
				if (delta_e < 0) {// 新路线更好,替代旧的路线
					this.setCities(temp_cities.clone());
				} else {// 新的路线更差，则以一定的概率接受结果
					if (Math.exp(-delta_e / t_temprature) > random.nextDouble()) {
						this.setCities(temp_cities.clone());
					}
				}
			} // end for
			len1 = this.total_distance(path);
			t_temprature = t_temprature * delta;
		} // end while
		this.setPath(this.cities.clone());
		double total = this.total_distance(this.getPath());
		this.setTotalDistance(total);
		this.print();
	}// end search()

	private City[] change() {// 随机交换两个城市的路线
		Random random = new Random();
		City temp = null;
		int p1 = 0, p2 = 0;
		do {
			p1 = (int) Math.floor(N * random.nextDouble());
			p2 = (int) Math.floor(N * random.nextDouble());
		} while (p1 == p2);// 获得两个不相同的随机数
		// 交换p1,p2两个城市
		temp = cities[p1];
		cities[p1] = cities[p2];
		cities[p2] = temp;
		return this.cities;
	}

	private void print() {

		System.out.println("最佳路线为为:");
		for (int i = 0; i < N - 1; i++) {
			System.out.print(path[i].getName() + "->");
		}
		System.out.println(path[0].getName());
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("最佳路线的总距离为:" + df.format(this.getTotalDistance()) + "km");
	}

	public City[] getCities() {
		return cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}

	public City[] getPath() {
		return path;
	}

	public void setPath(City[] path) {
		this.path = path;
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double distance) {
		this.totalDistance = distance;
	}

}
