package com.hs.array.optimization;

public class MaximumAvgSubArrayOfKSize {

	// Returns beginning index of maximum average subarray of length 'k'
	private int findMaxAverage(int arr[], int n, int k) {

		// Check if 'k' is valid
		if (k > n)
			return -1;

		// Compute sum of first 'k' elements
		int sum = arr[0];
		for (int i = 1; i < k; i++)
			sum += arr[i];

		int max_sum = sum, max_end = k - 1;

		// Compute sum of remaining subarrays
		for (int i = k; i < n; i++) {
			sum = sum + arr[i] - arr[i - k];
			if (sum > max_sum) {
				max_sum = sum;
				max_end = i;
			}
		}

		// Return starting index
		return max_end - k + 1;
	}

	// Driver program
	public static void main(String[] args) {
		MaximumAvgSubArrayOfKSize array = new MaximumAvgSubArrayOfKSize();
		int arr[] = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		int n = arr.length;
		System.out.println("The maximum average" + " subarray of length " + k + " begins at index "
				+ array.findMaxAverage(arr, n, k));
	}

}