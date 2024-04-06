package com.hs.medium;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (nums[i] > sum) {
				sum = nums[i];
			}
			result = Math.max(result, sum);
		}
		return result;
	}

	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = obj.maxSubArray(nums);
		System.out.println(result);
	}
}
