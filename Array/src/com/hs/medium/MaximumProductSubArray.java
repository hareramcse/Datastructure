package com.hs.medium;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		int leftMax = 0;
		int rightMax = 0;
		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			leftMax = leftMax == 0 ? 1 : leftMax;
			rightMax = rightMax == 0 ? 1 : rightMax;

			leftMax *= nums[i];
			rightMax *= nums[nums.length - 1 - i];

			max = Math.max(max, Math.max(leftMax, rightMax));
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumProductSubArray obj = new MaximumProductSubArray();
		int[] nums = { 2, 3, -2, -5, 6, -1, 4 };
		System.out.println("Maximum Sub array product is " + obj.maxProduct(nums));
	}
}