package com.hs.slidingwindow;

public class MaximumSubArraySumOfSizeK {

	private int solve(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
		while (j < n) {
			sum += arr[j];
			if (j - i + 1 == k) {
				max = Math.max(max, sum);
				sum -= arr[i];
				i++;
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSubArraySumOfSizeK msask = new MaximumSubArraySumOfSizeK();
		int arr[] = { 2, 4, 6, 1, 3, 9, 7, 5, 8 };

		int sum = msask.solve(arr, 3);
		System.out.println(sum);
	}
}
