package com.gy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSFileReader {

	private File sourceFile;
	private File destFile;

	public JSFileReader(File sourceFile, File destFile) {
		this.sourceFile = sourceFile;
		this.destFile = destFile;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public File getDestFile() {
		return destFile;
	}

	public void setDestFile(File destFile) {
		this.destFile = destFile;
	}

	private ArrayList<String> getData() {

		ArrayList<String> data = new ArrayList<String>();
		FileReader fr = null;
		try {
			fr = new FileReader(sourceFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader bf = new BufferedReader(fr);
		String line = null;
		try {
			while ((line = bf.readLine()) != null) {

				boolean flag = false;
				String[] str = { "南京", "苏州", "无锡", "常州", "镇江", "南通", "泰州", "扬州", "盐城", "淮安", "宿迁", "连云港", "徐州" };
				for (int i = 0; i < 13; i++) {
					if (line.startsWith(str[i])) {
						flag = true;
					}
				} // end for
				if (flag) {
					data.add(line);
				}
				flag = false;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (bf != null) {
					bf.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return data;

	}// end getData()

	private void generateData() {

		ArrayList<String> list = this.getData();
		FileWriter fw = null;
		try {
			fw = new FileWriter(destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String line : list) {
			try {
				fw.write(line + "\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // end for
		try {
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] readData() {

		this.generateData();
		String[] re = new String[13];
		for (int i = 0; i < re.length; i++) {
			re[i] = null;
		}
		FileReader fr = null;

		try {
			fr = new FileReader(destFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader bf = new BufferedReader(fr);

		for (int i = 0; i < re.length; i++) {
			String line = null;
			try {
				if ((line = bf.readLine()) != null) {
					re[i] = line;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return re;
	}

}
