package com.hs.leetcode.medium;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < nums[i]) {
				sum = nums[i];
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}
}
