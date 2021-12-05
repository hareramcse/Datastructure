package com.hs.array.arrangement;

public class IndexOfZeroReplaceWithOneToGetMaxContinousSeq {

	// Returns index of 0 to be replaced with 1 to get longest
	// continuous sequence of 1s. If there is no 0 in array, then
	// it returns -1.
	private int maxOnesIndex(int arr[]) {
		int n = arr.length;
		int max_count = 0; // for maximum number of 1 around a zero
		int max_index = 0; // for storing result
		int prev_zero = -1; // index of previous zero
		int prev_prev_zero = -1; // index of previous to previous zero

		// Traverse the input array
		for (int curr = 0; curr < n; ++curr) {
			// If current element is 0, then calculate the difference
			// between curr and prev_prev_zero
			if (arr[curr] == 0) {
				// If the difference between curr and prev_prev_zero is more than maximum so
				// far, then update the maximum.
				if (curr - prev_prev_zero > max_count) {
					max_count = curr - prev_prev_zero;
					max_index = prev_zero;
				}

				// Update for next iteration
				prev_prev_zero = prev_zero;
				prev_zero = curr;
			}
		}

		// Check for the last encountered zero
		if (n - prev_prev_zero > max_count)
			max_index = prev_zero;

		return max_index;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		IndexOfZeroReplaceWithOneToGetMaxContinousSeq array = new IndexOfZeroReplaceWithOneToGetMaxContinousSeq();
		int arr[] = { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		System.out.println("Index of 0 to be replaced is " + array.maxOnesIndex(arr));
	}
}