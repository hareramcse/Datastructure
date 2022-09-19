package com.hs.leetcode.medium;

import java.util.Arrays;

public class AggressiveCows {
	public int aggressiveCows(int[] arr, int c) {
		Arrays.sort(arr);
		int n = arr.length;
		int low = 1; // minimum
		int high = arr[n - 1] - arr[0];
		int result = -1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (canPlaceCows(mid, c, arr, n)) {
				result = mid;
				low = mid + 1;// will try to maximize
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	private boolean canPlaceCows(int dist, int c, int[] a, int n) {
		int lastCowPlaced = a[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] - lastCowPlaced >= dist) {
				count++;
				lastCowPlaced = a[i];
			}
			if (count == c) {
				return true;
			}
		}
		return false;
	}
}
