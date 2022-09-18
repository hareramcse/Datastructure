package com.hs.leetcode.medium;

public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] occupancy = new int[1001];
		for (int i = 0; i < trips.length; i++) {
			occupancy[trips[i][1]] += trips[i][0];
			occupancy[trips[i][2]] -= trips[i][0];
		}

		int currOccupancy = 0;
		for (int curr : occupancy) {
			currOccupancy += curr;
			if (currOccupancy > capacity) {
				return false;
			}
		}
		return true;
	}
}
