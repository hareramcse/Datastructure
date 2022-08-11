package com.hs.leetcode.medium;

class CountStrictlyIncreasingSubArray {

	private int countIncreasing(int[] arr, int n) {
		int count = 0; // Initialize result

		// Initialize length of current increasing subarray
		int len = 1;

		// Traverse through the array
		for (int i = 0; i < n - 1; ++i) {
			// If arr[i+1] is greater than arr[i],
			// then increment length
			if (arr[i + 1] > arr[i])
				len++;

			// Else Update count and reset length
			else {
				count += (((len - 1) * len) / 2);
				len = 1;
			}
		}

		// If last length is more than 1
		if (len > 1)
			count += (((len - 1) * len) / 2);

		return count;
	}

	public static void main(String[] args) {
		CountStrictlyIncreasingSubArray array = new CountStrictlyIncreasingSubArray();
		int arr[] = new int[] { 1, 2, 2, 4 };
		System.out.println("Count of strictly increasing subarrays is " + array.countIncreasing(arr, arr.length));
	}
}
