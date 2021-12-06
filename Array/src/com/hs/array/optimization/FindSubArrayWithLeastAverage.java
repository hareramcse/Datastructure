package com.hs.array.optimization;

class FindSubArrayWithLeastAverage {

	// Prints beginning and ending indexes of subarray of size k with minimum
	// average
	private void findMinAvgSubarray(int[] arr, int k) {
		int n = arr.length;
		// k must be smaller than or equal to n
		if (n < k)
			return;

		// Initialize beginning index of result
		int res_index = 0;

		// Compute sum of first subarray of size k
		int curr_sum = 0;
		for (int i = 0; i < k; i++)
			curr_sum += arr[i];

		// Initialize minimum sum as current sum
		int min_sum = curr_sum;

		// Traverse from (k+1)'th element to n'th element
		for (int i = k; i < n; i++) {
			// Add current item and remove first
			// item of previous subarray
			curr_sum += arr[i] - arr[i - k];

			// Update result if needed
			if (curr_sum < min_sum) {
				min_sum = curr_sum;
				res_index = (i - k + 1);
			}
		}

		System.out.println("Subarray between [" + res_index + ", " + (res_index + k - 1) + "] has minimum average");
	}

	public static void main(String[] args) {
		FindSubArrayWithLeastAverage array = new FindSubArrayWithLeastAverage();
		int arr[] = { 3, 7, 90, 20, 10, 50, 40 };
		int k = 3; // Subarray size
		array.findMinAvgSubarray(arr, k);
	}
}
