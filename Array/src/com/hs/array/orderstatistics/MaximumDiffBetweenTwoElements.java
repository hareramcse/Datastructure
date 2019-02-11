package com.hs.array.orderstatistics;

//Maximum difference between two elements such that larger element appears after the smaller number
public class MaximumDiffBetweenTwoElements {

	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing order
	 * and returns 0 if elements are equal
	 */
	static int maxDiff(int arr[], int n) {
		// Initialize diff, current
		// sum and max sum
		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {
			// Calculate current diff
			diff = arr[i + 1] - arr[i];

			// Calculate current sum
			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			// Update max sum, if needed
			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		return max_sum;
	}

	public static void main(String[] args) {
		int arr[] = { 80, 2, 6, 3, 100 };
		int n = arr.length;

		// Function calling
		System.out.print("Maximum difference is " + maxDiff(arr, n));
	}
}