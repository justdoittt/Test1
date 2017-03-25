package com.gy;

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
	public double totalDistance;
	public static final double e = 0.001;// 停止迭代温度
	private boolean flag = true;

	public TSP2(int num) {
		this.num = num;
		points = new ArrayList<Point>(this.num);
		this.init();
		this.path = CopyUtils2.deepCopy(points);
	}

	public void init() {
		generatePoints();
	}

	public void generatePoints() {// generate N points;

		File dataFile = new File("D:\\软件\\Github\\Test1\\TSP\\src\\com\\gy\\data");
		FileWriter writer = null;
		try {
			writer = new FileWriter(dataFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Random random = new Random();
		float x = 0, y = 0;
		for (int i = 0; i < this.num; i++) {
			x = random.nextFloat() * 700;
			y = random.nextFloat() * 700;
			Point p = new Point(x, y, i);
			this.points.add(p);
		}
		for (Point p : points) {
			try {
				writer.write(p.toString() + "\r\n");
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end for
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// add N points to the list points automatically only if search() is not
	// called
	public void addPoint() {
		if (flag) {
			int N = 50;
			Point point = null;
			Random random = new Random();
			File dataFile = new File("D:\\软件\\Github\\Test1\\TSP\\src\\com\\gy\\data");
			FileWriter writer = null;
			try {
				writer = new FileWriter(dataFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < N; i++) {
				float x = random.nextFloat() * 700;
				float y = random.nextFloat() * 700;
				point = new Point(x, y, points.size() + i - 1);
				points.add(point);
				try {
					writer.write(point.toString());
					writer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // end for
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.num += N;
			this.setPath(CopyUtils2.deepCopy(this.getPoints()));// reset path
		}
	}

	public void search() {// solve the TSP problem
		flag = false;
		Random random = new Random();
		double len1 = 0;
		double t_temprature = temprature * points.size();
		List<Point> temp = new ArrayList<Point>(points.size());
		for (int i = 0; i < temp.size(); i++) {
			temp.set(i, null);
		}
		while (t_temprature > e) {

			for (int i = 0; i < iter; i++) {
				len1 = total_distance(this.path);
				temp = this.change();
				double len2 = this.total_distance(temp);
				double delta_e = len2 - len1;
				if (delta_e < 0) {// the new route is better,replace with the
									// old one
					this.setPath(CopyUtils2.deepCopy(temp));
				} else {// if the new route is worse,accept it in a probability
					if (Math.exp(-delta_e / t_temprature) > random.nextDouble()) {
						this.setPath(CopyUtils2.deepCopy(temp));
					}
				}
			} // end for
			len1 = this.total_distance(path);
			t_temprature = t_temprature * delta;
		} // end while
		this.setPath(CopyUtils2.deepCopy(temp));
		float total = this.total_distance(this.path);
		this.setTotalDistance(total);
	}// end search()

	public void clear() {
		points.clear();
		path.clear();
		this.num = 0;
		this.totalDistance = 0;
		flag = true;
	}

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

	public void print() {

		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("最佳路线的总距离为:" + df.format(this.getTotalDistance()));
		/*
		 * System.out.println("最佳路线为:"); for (Point item : this.path) {
		 * System.out.print(item.getId() + "->"); if (item.getId() % 10 == 0) {
		 * System.out.println(); } }//end for
		 */
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double distance) {
		this.totalDistance = distance;
	}

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

	public float getDistance(List<Point> theList, int i, int j) {
		Point x = theList.get(i);
		Point y = theList.get(j);
		float delta_x = x.getX() - y.getX();
		float delta_y = x.getY() - y.getY();
		float d = (float) Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2));
		return d;
	}

	private float total_distance(List<Point> pointList) {

		float total = 0;
		for (int i = 0; i < pointList.size() - 1; i++) {
			total += getDistance(pointList, i, i + 1);
		}
		total += getDistance(pointList, pointList.size() - 1, 0);
		return total;
	}// end total_distance
}
