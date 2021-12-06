package com.hs.array.searching;

import java.util.stream.IntStream;

public class MaximumEquilibriumSum {

	private int findMaxSum(int arr[], int n) {
		int sum = IntStream.of(arr).sum();
		int prefix_sum = 0, res = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			prefix_sum += arr[i];

			if (prefix_sum == sum)
				res = Math.max(res, prefix_sum);
			sum -= arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		MaximumEquilibriumSum array = new MaximumEquilibriumSum();
		int arr[] = { -2, 5, 3, 1, 2, 6, -4, 2 };
		int n = arr.length;
		System.out.print(array.findMaxSum(arr, n));
	}
}