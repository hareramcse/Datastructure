package com.hs.leetcode.medium;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		for (int i = 0; i < nums.length; i++) {
			maxEndingHere = maxEndingHere + nums[i];
			maxEndingHere = Integer.max(maxEndingHere, nums[i]);
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
