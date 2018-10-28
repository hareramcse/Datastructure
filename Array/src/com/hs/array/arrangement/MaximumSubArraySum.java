package com.hs.array.arrangement;

public class MaximumSubArraySum {

	// Returns sum of maximum subarray sum in aa[l..h]
	static int maxSubArraySum(int arr[], int start, int end) {
		// Base Case: Only one element
		if (start == end)
			return arr[start];

		// Find middle point
		int mid = (start + end) / 2;

		// Return maximum of following three possible cases:
		// a) Maximum subarray sum in left half
		// b) Maximum subarray sum in right half
		// c) Maximum subarray sum such that the subarray crosses the midpoint
		return Math.max(Math.max(maxSubArraySum(arr, start, mid), maxSubArraySum(arr, mid + 1, end)),
				maxCrossingSum(arr, start, mid, end));
	}

	// Find the maximum possible sum in arr[]
	// such that arr[mid] is part of it
	static int maxCrossingSum(int arr[], int start, int mid, int end) {
		// Include elements which is left of mid.
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = start; i <= mid; i++) {
			sum = sum + arr[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		// Include elements which is right of mid
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= end; i++) {
			sum = sum + arr[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		// Return sum of elements on left and right of mid
		return left_sum + right_sum;
	}

	/* Driver program to test maxSubArraySum */
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, 7 };
		int n = arr.length;
		int max_sum = maxSubArraySum(arr, 0, n - 1);

		System.out.println("Maximum contiguous sum is " + max_sum);
	}
}