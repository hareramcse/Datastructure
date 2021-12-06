package com.hs.array.misc;

public class MaximumSumSubArraySizeK {
	private int getSum(int[] arr, int k) {
		int n = arr.length;
		int start = 0;
		int sum = 0;
		int maxSum = 0;

		for (int end = 0; end < n; end++) {
			sum += arr[end];
			if (end >= k - 1) {
				maxSum = Math.max(sum, maxSum);
				sum = sum - arr[start];
				start++;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		MaximumSumSubArraySizeK array = new MaximumSumSubArraySizeK();
		int[] arr = { 4, 5, 8, 2, 3, 7, 9, 6 };
		int windowSize = 3;
		int maxSum = array.getSum(arr, windowSize);
		System.out.println("Max sum of subarray of size " + windowSize + " is " + maxSum);
	}
}
