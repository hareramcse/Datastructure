package com.hs.medium;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		// max positive product ending at the current position
		int maxSoFar = nums[0];

		// min negative product ending at the current position
		int minSoFar = nums[0];

		// Initialize overall max product
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = maxSoFar;
			maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * minSoFar));
			minSoFar = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minSoFar));
			res = Math.max(res, maxSoFar);
		}
		return res;
	}

	public static void main(String[] args) {
		MaximumProductSubArray obj = new MaximumProductSubArray();
		int[] nums = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println("Maximum Sub array product is " + obj.maxProduct(nums));
	}
}