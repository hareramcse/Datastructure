package com.hs.searching;

import java.util.Arrays;

class CheckForPairWithSumK {
	// Function to check if array has 2 elements whose sum is equal to the given
	// value
	static boolean hasArrayTwoCandidates(int arr[], int arr_size, int sum) {

		/* Sort the elements */
		Arrays.sort(arr);

		/*
		 * Now look for the two candidates in the sorted array
		 */
		int start = 0;
		int end = arr_size - 1;
		while (start < end) {
			if (arr[start] + arr[end] == sum)
				return true;
			else if (arr[start] + arr[end] < sum)
				start++;
			else // A[i] + A[j] > sum
				end--;
		}
		return false;
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;
		int size = arr.length;

		// Function calling
		if (hasArrayTwoCandidates(arr, size, n))
			System.out.println("Array has two " + "elements with given sum");
		else
			System.out.println("Array doesn't have " + "two elements with given sum");

	}
}
