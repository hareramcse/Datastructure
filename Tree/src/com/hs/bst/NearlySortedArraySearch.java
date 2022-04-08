package com.hs.bst;

public class NearlySortedArraySearch {
	private int binarySearch(int arr[], int low, int high, int value) {
		if (high >= low) {
			int mid = low + (high - low) / 2;

			// If the element is present at one of the middle 3 positions
			if (arr[mid] == value)
				return mid;
			if (mid > low && arr[mid - 1] == value)
				return (mid - 1);
			if (mid < high && arr[mid + 1] == value)
				return (mid + 1);

			// If element is smaller than mid, then it can only be present in left subarray
			if (arr[mid] > value)
				return binarySearch(arr, low, mid - 2, value);

			// Else the element can only be present in right subarray
			return binarySearch(arr, mid + 2, high, value);
		}

		// We reach here when element is not present in array
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 10, 4, 40 };
		int n = arr.length;
		int value = 4;

		NearlySortedArraySearch bst = new NearlySortedArraySearch();
		int index = bst.binarySearch(arr, 0, n, value);
		System.out.println(index);
	}
}