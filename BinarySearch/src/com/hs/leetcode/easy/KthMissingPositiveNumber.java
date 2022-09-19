package com.hs.leetcode.easy;

public class KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			// arr[mid] - (mid + 1) will give the no of missing element
			if (arr[mid] - (mid + 1) >= k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low + k;
	}
}
