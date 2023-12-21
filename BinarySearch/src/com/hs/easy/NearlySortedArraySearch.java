package com.hs.easy;

// Nearly sorted array means the element which should have present at ith index is presnt at (i-1)th or ith or (i+1)th index
public class NearlySortedArraySearch {
	private int binarySearch(int arr[], int low, int high, int value) {
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		// If the element is present at one of the middle 3 positions
		if (arr[mid] == value)
			return mid;
		if (mid > low  && arr[mid - 1] == value)
			return mid - 1;
		if (mid < high && arr[mid + 1] == value)
			return mid + 1;

		// If element is smaller than all 3 mids, then it can only be present in left subarray
		// we have already searched in mid - 1 index in above steps. so will check it
		// from mid - 2 index
		if (value < arr[mid])
			return binarySearch(arr, low, mid - 2, value);

		// Else the element can only be present in right subarray
		// we have already searched in mid + 1 index in above steps. so will check it
		// from mid + 2 index
		return binarySearch(arr, mid + 2, high, value);
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