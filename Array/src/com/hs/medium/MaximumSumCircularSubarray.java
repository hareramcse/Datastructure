package com.hs.medium;

public class MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] nums) {
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}

		int kadaneMax = kadane(nums);

		for (int i = 0; i < nums.length; i++) {
			nums[i] *= -1;
		}

		int kadaneMin = kadane(nums);
		if (totalSum + kadaneMin == 0) // All elements are negative
			return kadaneMax;

		return Math.max(kadaneMax, totalSum + kadaneMin);
	}

	private int kadane(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int num : nums) {
			sum += num;
			if (num > sum) {
				sum = num;
			}

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