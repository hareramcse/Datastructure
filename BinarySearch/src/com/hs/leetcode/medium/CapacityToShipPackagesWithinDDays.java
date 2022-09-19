package com.hs.leetcode.medium;

public class CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int days) {
		int max = 0;
		int sum = 0;
		for (int w : weights) {
			max = Math.max(w, max);
			sum += w;
		}

		if (days == weights.length)
			return max;

		int low = max;
		int high = sum;

		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(weights, mid, days)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private boolean isPossible(int[] wt, int mid, int days) {
		int d = 1;
		int sum = 0;
		for (int i = 0; i < wt.length; i++) {
			sum += wt[i];
			if (sum > mid) {
				d++;
				sum = wt[i];
			}
		}
		return d <= days;
	}
}