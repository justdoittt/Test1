package com.gy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TSP2 {

	public int num;
	public List<Point> points;
	public static final double temprature = 100;
	public static final double delta = 0.98;
	public static final int iter = 100;
	public List<Point> path;
	private File file = null;
	private FileWriter writer = null;
	private BufferedWriter bw = null;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public List<Point> getPath() {
		return path;
	}

	public void setPath(List<Point> path) {
		this.path = path;
	}

	public double totalDistance;
	public static final double e = 0.001;// 停止迭代温度
	public File dataFile = null;

	public TSP2(int num) {
		super();
		this.points = new ArrayList<Point>(num);
		generatePoints();
		this.path = CopyUtils.deepCopyList(points);
		dataFile = new File("C:\\Users\\asus\\Desktop\\data.txt");
	}

	public float getDistance(int i, int j) {
		Point x = path.get(i);
		Point y = path.get(j);
		float d = (float) Math.sqrt(Math.pow((y.getX() - x.getX()), 2) + Math.pow((y.getY() - x.getY()), 2));
		return d;
	}

	private float total_distance(List<Point> path) {

		float total = 0;
		for (int i = 0; i < path.size(); i++) {
			total += getDistance(i, i + 1);
		}
		total += getDistance(path.size() - 1, 0);
		return total;
	}// end total_distance

	public void generatePoints() {// generate N points;
		Random random = new Random();
		float x = 0, y = 0;
		int id = 0;
		for (int i = 0; i < points.size(); i++) {
			x = random.nextFloat() * 700;
			y = random.nextFloat() * 700;
			Point p = new Point(x, y, i);
			points.add(p);
		}
		file = new File(".\\data.txt");
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bw = new BufferedWriter(writer);
		for (Point p : points) {
			try {
				bw.write(p.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void addPoint(int num) {
		Random random = new Random();
		Point point = null;
		for (int i = 0; i < num; i++) {
			float x = random.nextFloat() * 700;
			float y = random.nextFloat() * 700;
			point = new Point(x, y, points.size());
			points.add(point);
			try {
				bw.write(point.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void search() {// solve the TSP problem

		Random random = new Random();
		double len1 = 0;
		double t_temprature = temprature * points.size();
		List<Point> temp = new ArrayList<Point>(points.size());
		for (int i = 0; i < temp.size(); i++) {
			temp.set(i, null);
		}
		while (t_temprature > e) {

			for (int i = 0; i < iter; i++) {
				len1 = total_distance(path);
				temp = this.change();
				double len2 = this.total_distance(temp);
				double delta_e = len2 - len1;
				if (delta_e < 0) {// the new route is better,replace with the
									// old one
					this.setPath(CopyUtils.deepCopyList(path));
				} else {// if the new route is worse,accept it in a probability
					if (Math.exp(-delta_e / t_temprature) > random.nextDouble()) {
						this.setPath(CopyUtils.deepCopyList(temp));
					}
				}
			} // end for
			len1 = this.total_distance(path);
			t_temprature = t_temprature * delta;
		} // end while
		this.setPath(CopyUtils.deepCopyList(temp));
		double total = this.total_distance(this.getPath());
		this.setTotalDistance(total);
		this.print();
	}// end search()

	private List<Point> change() {// 随机交换两个城市的路线
		Random random = new Random();
		int p1 = 0, p2 = 0;
		do {
			p1 = (int) Math.floor(num * random.nextDouble());
			p2 = (int) Math.floor(num * random.nextDouble());
		} while (p1 == p2);// 获得两个不相同的随机数
		// 交换p1,p2两个城市
		SwitchUtils.exchange(path, p1, p2);
		return this.path;

	}

	private void print() {

		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("最佳路线的总距离为:" + df.format(this.getTotalDistance()) + "km");
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double distance) {
		this.totalDistance = distance;
	}

}
