package com.gy;

public class DistanceUtils {

	public static float sumDistance(Point[] p) {

		float d = 0;
		for (int i = 0; i < p.length - 1; i++) {
			d += getDistance(p, i, i + 1);
		}
		d += getDistance(p, 0, p.length - 1);
		return d;
	}

	public static float getDistance(Point[] p, int i, int j) {
		Point x = p[i];
		Point y = p[j];
		float delta_x = x.getX() - y.getX();
		float delta_y = x.getY() - y.getY();
		float d = (float) Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2));
		return d;

	}

}
