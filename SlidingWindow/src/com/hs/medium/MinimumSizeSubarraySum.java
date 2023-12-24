package com.hs.medium;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		int i = 0, j = 0;
		
		while (j < nums.length) {
			sum = sum + nums[j];
			// while sum is greater than the value of target
			while (i <= j && sum >= target) {
				// Keep track of minLength
				minLength = Math.min(minLength, j - i + 1);
				// Subtract the value from sum variable and move start pointer
				sum = sum - nums[i];
				i++;
			}
			j++;
		}
		return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
	}
}