package com.gy;

import java.io.File;

public class TspTest {

	public static void main(String[] args) {

		File destfile = new File("C:\\Users\\asus\\Desktop\\location.txt");
		File sourceFile = new File("C:\\\\Users\\\\asus\\\\Desktop\\jiangsu.txt");
		JSFileReader jf = new JSFileReader(sourceFile, destfile);
		String[] lines = jf.readData();
		CityInfo cf = new CityInfo(lines);
		City[] cities = cf.getCityInfo();
		TSP solver = new TSP(cities);
		solver.search();

	}

}
