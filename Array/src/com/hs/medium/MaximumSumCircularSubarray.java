package com.hs.medium;

public class MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int kadane = kadane(nums);

		for (int i = 0; i < nums.length; i++) {
			nums[i] *= -1;
		}

		int inverseKadane = kadane(nums);
		if (sum + inverseKadane == 0)
			return kadane;
		return Math.max(kadane, sum + inverseKadane);
	}

	private int kadane(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum < nums[i]) {
				sum = nums[i];
			}
			max = Integer.max(max, sum);
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