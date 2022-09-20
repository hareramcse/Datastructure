package com.hs.leetcode.medium;

public class MinimumNumberOfDaysToMakeMBouquets {
	public int minDays(int[] bloomDay, int m, int k) {
		if (m * k > bloomDay.length)
			return -1;
		
		int low = 1, high = 1;
		for (int i : bloomDay) {
			low = Math.min(low, i);
			high = Math.max(high, i);
		}

		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canmake(bloomDay, mid, m, k)) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return ans;
	}

	private boolean canmake(int[] bloom, int val, int bouquet, int flowers) {
		int count = 0;
		for (int i : bloom) {
			if (i <= val) {
				count++;
				if (count == flowers) {
					bouquet--;
					count = 0;
					if (bouquet == 0)
						return true;
				}
			} else {
				count = 0;
			}
		}
		return false;
	}
}
