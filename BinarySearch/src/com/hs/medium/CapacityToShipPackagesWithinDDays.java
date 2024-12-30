package com.hs.medium;

public class CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int days) {
		int low = 0; // Minimum capacity is the heaviest package
		int high = 0; // Maximum capacity is the sum of all packages
		for (int weight : weights) {
			low = Math.max(low, weight);
			high += weight;
		}

		int result = high;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canShip(weights, days, mid)) {
				result = mid;
				high = mid - 1; // Try for a smaller value
			} else {
				low = mid + 1;
			}
		}

		return result;
	}

	private static boolean canShip(int[] weights, int days, int capacity) {
		int daysNeeded = 1; // Start with one day
		int currentLoad = 0;

		for (int weight : weights) {
			if (currentLoad + weight > capacity) {
				daysNeeded++;
				currentLoad = weight;

				if (daysNeeded > days) {
					return false;
				}
			} else {
				currentLoad += weight;
			}
		}

		return true;
	}
}