package com.gy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {

		File destfile = new File("D:\\Èí¼þ\\Github\\Test1\\TSP\\src\\com\\gy\\data");
		FileWriter writer = null;
		try {
			writer = new FileWriter(destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "hello world";
		try {
			writer.write(line);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Random random = new Random();
		List<Point> ps = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			ps.add(new Point(random.nextFloat(), random.nextFloat(), i));
		}

	}
}
