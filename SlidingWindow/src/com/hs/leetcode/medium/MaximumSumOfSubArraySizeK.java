package com.hs.leetcode.medium;

public class MaximumSumOfSubArraySizeK {
	public int solve(int[] arr, int k) {
		int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
		while (j < arr.length) {
			sum += arr[j];
			if (j - i + 1 == k) {
				max = Math.max(max, sum);
				// remove the ith index val from sum before sliding the window
				sum -= arr[i];
				i++;
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSumOfSubArraySizeK msask = new MaximumSumOfSubArraySizeK();
		int arr[] = { 2, 5, 1, 8, 2, 9, 1 };
		int k = 3;
		
		int sum = msask.solve(arr, k);
		System.out.println(sum);
	}
}