package com.gy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountUtils {

	public int count = 0;

	public void countLines(File dir) {

		if (dir.isDirectory()) {
			File[] src = dir.listFiles();
			for (int i = 0; i < src.length; i++) {
				FileReader reader = null;
				try {
					reader = new FileReader(src[i]);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader br = null;
				br = new BufferedReader(reader);
				try {
					String line = "";
					while ((line = br.readLine()) != null) {
						count++;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						br.close();
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else if (dir.isFile()) {

			FileReader reader = null;
			try {
				reader = new FileReader(dir);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader br = null;
			br = new BufferedReader(reader);
			String line = " ";
			try {
				while ((line = br.readLine()) != null) {
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Not a file or a directory!");
			return;
		}
		print();
	}// end
																									// countLine

	private void print() {
		System.out.println("Total:" + getCount() + " lines");
	}

	public int getCount() {
		return count;
	}

}
