package com.gy;

public class CityInfo {

	private String[] lines;
	private City[] cities;

	public CityInfo(String[] lines) {
		cities = new City[13];
		this.lines = lines;
	}

	public String[] getLines() {
		return lines;
	}

	public void setLines(String[] lines) {
		this.lines = lines;
	}

	public City[] getCities() {
		return cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}

	public City[] getCityInfo() {

		String[] temp = new String[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = null;
		}
		for (int i = 0; i < 13; i++) {
			temp = lines[i].split("	", 4);
			cities[i] = new City(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]));
		}
		return cities;
	}

}
