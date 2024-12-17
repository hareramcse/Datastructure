package com.hs.medium;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		int prefix = 0;
		int suffix = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			prefix = prefix == 0 ? 1 : prefix;
			suffix = suffix == 0 ? 1 : suffix;

			prefix *= nums[i];
			suffix *= nums[nums.length - 1 - i];

			max = Math.max(max, Math.max(prefix, suffix));
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumProductSubArray obj = new MaximumProductSubArray();
		int[] nums = { 2, 3, -2, -5, 6, -1, 4 };
		System.out.println("Maximum Sub array product is " + obj.maxProduct(nums));
	}
}