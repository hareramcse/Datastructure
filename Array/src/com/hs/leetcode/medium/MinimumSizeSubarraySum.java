package com.hs.leetcode.medium;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int start = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		// Move end pointer
		for (int end = 0; end < nums.length; end++) {
			// Add value to the sum variable
			sum = sum + nums[end];
			// while sum is greater than the value of k
			while (sum >= target && start <= end) {
				// Keep track of minLength
				minLength = Math.min(minLength, (end - start) + 1);
				// Subtract the value from sum variable and move start pointer
				sum = sum - nums[start];
				start++;
			}
		}
		return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		int result = obj.minSubArrayLen(target, nums);
		System.out.println(result);
	}
}