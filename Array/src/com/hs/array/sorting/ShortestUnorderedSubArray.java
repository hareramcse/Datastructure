package com.hs.array.sorting;

public class ShortestUnorderedSubArray {

	// boolean function to check array elements are in increasing order or not
	private boolean increasing(int arr[], int n) {
		for (int i = 0; i < n - 1; i++)
			if (arr[i] >= arr[i + 1])
				return false;

		return true;
	}

	// boolean function to check array elements are in decreasing order or not
	private boolean decreasing(int arr[], int n) {
		for (int i = 0; i < n - 1; i++)
			if (arr[i] < arr[i + 1])
				return false;

		return true;
	}

	private int shortestUnsorted(int arr[]) {
		int n = arr.length;

		// increasing and decreasing are two functions.
		// if function return true value then print 0 otherwise 3.
		if (increasing(arr, n) == true || decreasing(arr, n) == true)
			return 0;
		else
			return 3;
	}

	public static void main(String[] args) {
		ShortestUnorderedSubArray array = new ShortestUnorderedSubArray();
		int arr[] = new int[] { 7, 9, 10, 8, 11 };

		System.out.println(array.shortestUnsorted(arr));
	}
}