package com.hs.medium;

public class MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] nums) {
		int kadaneMax = kadane(nums);

		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
			nums[i] *= -1;
		}

		int kadaneMin = kadane(nums);
		int circularSum = totalSum - (-kadaneMin);
		if (circularSum == 0) // All elements are negative
			return kadaneMax;

		return Math.max(kadaneMax, circularSum);
	}

	public int kadane(int[] nums) {
		int sum = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSumCircularSubarray array = new MaximumSumCircularSubarray();
		int arr[] = { 2, 1, -5, 4, -3, 1, -3, 4, 1 };
		int maxSum = array.maxSubarraySumCircular(arr);
		System.out.println("max sum is " + maxSum);
	}
}