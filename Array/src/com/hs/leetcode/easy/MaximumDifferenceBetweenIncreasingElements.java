package com.hs.leetcode.easy;

public class MaximumDifferenceBetweenIncreasingElements {
	public int maximumDifference(int[] nums) {
		int n = nums.length;
		int maxDiff = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			min = Math.min(min, nums[i]);
			if (nums[i] > min)
				maxDiff = Math.max(maxDiff, nums[i] - min);
		}
		return maxDiff;
	}
}
