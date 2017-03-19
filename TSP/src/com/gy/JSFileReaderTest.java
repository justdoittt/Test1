package com.gy;

import java.io.File;

//JSFileReader≤‚ ‘¿‡
public class JSFileReaderTest {

	public static void main(String[] args) {

		File destfile = new File("C:\\Users\\asus\\Desktop\\location.txt");
		File sourceFile = new File("C:\\\\Users\\\\asus\\\\Desktop\\jiangsu.txt");
		JSFileReader jf = new JSFileReader(sourceFile, destfile);
		String[] lines = jf.readData();
		CityInfo cf = new CityInfo(lines);
		City[] cities = cf.getCityInfo();
		
		
		
		
		
		
		
	}

}
