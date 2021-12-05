package com.hs.array.arrangement;

import java.util.Arrays;

public class MaximumSumOfConsecutiveDiff {
	private int maxSum(int arr[]) {
		int n = arr.length;
		int sum = 0;

		// Sorting the array.
		Arrays.sort(arr);

		// to obtain the answer having maximum sum of difference between consecutive
		// element, arrange element in following manner: a1, an, a2, an-1,…., an/2,
		// a(n/2) + 1

		// Subtracting a1, a2, a3,....., a(n/2)-1, an/2 twice
		// and adding a(n/2)+1, a(n/2)+2, a(n/2)+3,....., an - 1, an twice.

		// array will be a1,a6,a2,a5,a3,a4;
		// sum=(a6-a1)+(a6-a2)+(a5-a2)+(a5-a3)+(a4-a3)+(a4-a1)
		// sum=2*(a6+a5+a4)-2*(a1+a2+a3);
		for (int i = 0; i < n / 2; i++) {
			sum -= (2 * arr[i]);
			sum += (2 * arr[n - i - 1]);
		}
		return sum;
	}

	// Driver Program
	public static void main(String[] args) {
		MaximumSumOfConsecutiveDiff array = new MaximumSumOfConsecutiveDiff();
		int arr[] = { 4, 2, 1, 8 };
		System.out.println(array.maxSum(arr));
	}
}
