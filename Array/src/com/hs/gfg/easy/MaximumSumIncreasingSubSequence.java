package com.hs.gfg.easy;

public class MaximumSumIncreasingSubSequence {

	private int maxSumIS(int arr[], int n) {
		int i, j, max = 0;
		int msis[] = new int[n];

		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];

		return max;
	}

	public static void main(String args[]) {
		MaximumSumIncreasingSubSequence array = new MaximumSumIncreasingSubSequence();
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println("Sum of maximum sum increasing subsequence is " + array.maxSumIS(arr, n));
	}
}