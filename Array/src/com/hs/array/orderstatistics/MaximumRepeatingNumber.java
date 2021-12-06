package com.hs.array.orderstatistics;

class MaximumRepeatingNumber {

	// Returns maximum repeating element in arr[0..n-1].
	// The array elements are in range from 0 to k-1
	private int maxRepeating(int arr[], int n, int k) {
		// Iterate though input array, for every element
		// arr[i], increment arr[arr[i]%k] by k
		for (int i = 0; i < n; i++)
			arr[(arr[i] % k)] += k;

		// Find index of the maximum repeating element
		int max = arr[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}

		/*
		 * Uncomment this code to get the original array back for (int i = 0; i< n; i++)
		 * arr[i] = arr[i]%k;
		 */

		// Return index of the maximum element
		return result;
	}

	public static void main(String[] args) {
		MaximumRepeatingNumber array = new MaximumRepeatingNumber();
		int arr[] = { 2, 3, 3, 5, 3, 4, 1, 7 };
		int n = arr.length;
		int k = 8;
		System.out.println("Maximum repeating element is: " + array.maxRepeating(arr, n, k));
	}
}