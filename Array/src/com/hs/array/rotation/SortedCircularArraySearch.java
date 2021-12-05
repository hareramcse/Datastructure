package com.hs.array.rotation;

public class SortedCircularArraySearch {
	private int search(int arr[], int low, int high, int key) {
		if (low > high)
			return -1;

		int mid = (low + high) / 2;
		if (arr[mid] == key)
			return mid;

		/* If arr[l...mid] first subarray is sorted */
		if (arr[low] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in half or other
			 * half
			 */
			if (key >= arr[low] && key <= arr[mid])
				return search(arr, low, mid - 1, key);
			/*
			 * If key not lies in first half subarray, Divide other half into two subarrays,
			 * such that we can quickly check if key lies in other half
			 */
			return search(arr, mid + 1, high, key);
		}

		/*
		 * If arr[l..mid] first subarray is not sorted, then arr[mid... h] must be
		 * sorted subarray
		 */
		if (key >= arr[mid] && key <= arr[high])
			return search(arr, mid + 1, high, key);

		return search(arr, low, mid - 1, key);
	}

	public static void main(String[] args) {
		SortedCircularArraySearch array = new SortedCircularArraySearch();
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 6;
		int i = array.search(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}
