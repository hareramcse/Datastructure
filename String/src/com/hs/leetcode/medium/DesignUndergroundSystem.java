package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class Event {
	int id;
	String stationName;
	int time;

	Event(int id, String stationName, int t) {
		this.id = id;
		this.stationName = stationName;
		this.time = t;
	}
}

public class DesignUndergroundSystem {
	Map<Integer, Event> arrivals;
	Map<String, double[]> total;

	public DesignUndergroundSystem() {
		arrivals = new HashMap<>();
		total = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		arrivals.put(id, new Event(id, stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		Event event = arrivals.get(id);
		String key = event.stationName + "_" + stationName;
		double[] pair = total.getOrDefault(key, new double[2]);
		int time = t - event.time;
		pair[0] += time;
		pair[1]++;
		total.put(key, pair);
	}

	public double getAverageTime(String startStation, String endStation) {
		String key = startStation + "_" + endStation;
		double[] pair = total.get(key);
		return pair[0] / pair[1];
	}

	public static void main(String[] args) {
		DesignUndergroundSystem obj = new DesignUndergroundSystem();
		obj.checkIn(45, "Leyton", 3);
		obj.checkIn(32, "Paradise", 8);
		obj.checkIn(27, "Leyton", 10);
		obj.checkOut(45, "Waterloo", 15);
		obj.checkOut(27, "Waterloo", 20);
		obj.checkOut(32, "Cambridge", 22);
		double result = obj.getAverageTime("Paradise", "Cambridge");
		System.out.println(result);
		result = obj.getAverageTime("Leyton", "Waterloo");
		System.out.println(result);
		obj.checkIn(10, "Leyton", 24);
		result = obj.getAverageTime("Leyton", "Waterloo");
		System.out.println(result);
		obj.checkOut(10, "Waterloo", 38);
		result = obj.getAverageTime("Leyton", "Waterloo");
		System.out.println(result);
	}
}