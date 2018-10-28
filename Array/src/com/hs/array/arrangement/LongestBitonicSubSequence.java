package com.hs.array.arrangement;

public class LongestBitonicSubSequence {
	/*
	 * lbs() returns the length of the Longest Bitonic Subsequence in arr[] of size
	 * n. The function mainly creates two temporary arrays lis[] and lds[] and
	 * returns the maximum lis[i] + lds[i] - 1.
	 * 
	 * lis[i] ==> Longest Increasing subsequence ending with arr[i] lds[i] ==>
	 * Longest decreasing subsequence starting with arr[i]
	 */
	static int longesBitonicSequence(int arr[], int n) {
		int i, j;

		/*
		 * Allocate memory for LIS[] and initialize LIS values as 1 for all indexes
		 */
		int[] longestIncreasingSequence = new int[n];
		for (i = 0; i < n; i++)
			longestIncreasingSequence[i] = 1;

		/* Compute LIS values from left to right */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && longestIncreasingSequence[i] < longestIncreasingSequence[j] + 1)
					longestIncreasingSequence[i] = longestIncreasingSequence[j] + 1;

		/*
		 * Allocate memory for lds and initialize LDS values for all indexes
		 */
		int[] longestDecreasingSequence = new int[n];
		for (i = 0; i < n; i++)
			longestDecreasingSequence[i] = 1;

		/* Compute LDS values from right to left */
		for (i = n - 2; i >= 0; i--)
			for (j = n - 1; j > i; j--)
				if (arr[i] > arr[j] && longestDecreasingSequence[i] < longestDecreasingSequence[j] + 1)
					longestDecreasingSequence[i] = longestDecreasingSequence[j] + 1;

		/* Return the maximum value of lis[i] + lds[i] - 1 */
		int max = longestIncreasingSequence[0] + longestDecreasingSequence[0] - 1;
		
		for (i = 1; i < n; i++)
			if (longestIncreasingSequence[i] + longestDecreasingSequence[i] - 1 > max)
				max = longestIncreasingSequence[i] + longestDecreasingSequence[i] - 1;

		return max;
	}

	public static void main(String[] args) {
		int arr[] = {12, 4, 78, 90, 45, 23};
		int n = arr.length;
		System.out.println("Length of longest bitonic sequence is " + longesBitonicSequence(arr, n));
	}
}
