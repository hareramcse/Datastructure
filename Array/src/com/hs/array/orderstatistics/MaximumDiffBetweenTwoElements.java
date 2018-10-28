package com.hs.array.orderstatistics;

//Maximum difference between two elements such that larger element appears after the smaller number
public class MaximumDiffBetweenTwoElements {

	int maxDiff(int arr[], int n) {
		// Initialize diff, current diff and max diff
		int diff = arr[1] - arr[0];
		int curr_diff = diff;
		int max_diff = curr_diff;

		for (int i = 1; i < n - 1; i++) {
			// Calculate current diff
			diff = arr[i + 1] - arr[i];

			// Calculate current diff
			if (curr_diff > 0)
				curr_diff += diff;
			else
				curr_diff = diff;

			// Update max diff, if needed
			if (curr_diff > max_diff)
				max_diff = curr_diff;
		}

		return max_diff;
	}

	public static void main(String[] args) {
		MaximumDiffBetweenTwoElements maxdif = new MaximumDiffBetweenTwoElements();
		int arr[] = { 80, 2, 6, 3, 100, 500, 300 };
		int size = arr.length;
		System.out.println("Maximum Difference is " + maxdif.maxDiff(arr, size));
	}
}
