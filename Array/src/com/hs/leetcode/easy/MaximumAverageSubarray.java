package com.hs.leetcode.easy;

public class MaximumAverageSubarray {
	public double findMaxAverage(int[] nums, int k) {
		int sum = maxSubArraySumInWindowSizeK(nums, k);
		return (double)sum / k;
	}

	private int maxSubArraySumInWindowSizeK(int[] arr, int k) {
		int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
		while (j < arr.length) {
			sum += arr[j];
			if (j - i + 1 == k) {
				max = Math.max(max, sum);
				// remove the ith char before sliding the window
				sum -= arr[i];
				i++;
			}
			j++;
		}
		return max;
	}
}
