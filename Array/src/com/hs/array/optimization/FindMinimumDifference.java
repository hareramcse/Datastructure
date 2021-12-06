package com.hs.array.optimization;

import java.util.Arrays;

public class FindMinimumDifference {

	// Returns minimum difference between any pair
	private int findMinDiff(int[] arr, int n) {
		// Sort array in non-decreasing order
		Arrays.sort(arr);

		// Initialize difference as infinite
		int diff = Integer.MAX_VALUE;

		// Find the min diff by comparing adjacent
		// pairs in sorted array
		for (int i = 0; i < n - 1; i++)
			if (arr[i + 1] - arr[i] < diff)
				diff = arr[i + 1] - arr[i];

		// Return min diff
		return diff;
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		FindMinimumDifference array = new FindMinimumDifference();
		int arr[] = new int[] { 1, 5, 3, 19, 18, 25 };
		System.out.println("Minimum difference is " + array.findMinDiff(arr, arr.length));

	}

}