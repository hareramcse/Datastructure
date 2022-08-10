package com.hs.leetcode.medium;

public class MaximumSumCircularSubarray {

	public int maxSubarraySumCircular(int[] nums) {
        int kadane = kadane(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] *= -1;
		}

		int inverseKadane = kadane(nums);
        if (sum + inverseKadane == 0)
			return kadane;
		return Math.max(kadane, sum + inverseKadane);
    }
    
    private int kadane(int[] nums) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		for (int i = 0; i < nums.length; i++) {
			maxEndingHere = maxEndingHere + nums[i];
			maxEndingHere = Integer.max(maxEndingHere, nums[i]);
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		MaximumSumCircularSubarray array = new MaximumSumCircularSubarray();
		int arr[] = { 1, -2, 3, -2 };
		int maxSum = array.maxSubarraySumCircular(arr);
		System.out.println("max sum is " + maxSum);
	}
}