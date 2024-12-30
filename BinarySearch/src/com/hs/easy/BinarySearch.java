package com.hs.easy;

public class BinarySearch {
	public int searchIterative(int[] arr, int value) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (value == arr[mid]) {
				return mid;
			} else if (value > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// if while loop doesn't return anything means value is not there in the array
		return -1;
	}

	public int searchRecursive(int[] arr, int low, int high, int value) {
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;
		if (value == arr[mid]) {
			return mid;
		} else if (value < arr[mid]) {
			return searchRecursive(arr, low, mid - 1, value);
		} else {
			return searchRecursive(arr, mid + 1, high, value);
		}
	}

	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int index = obj.searchIterative(arr, 23);
		if (index == -1) {
			System.out.println("value not found");
		} else {
			System.out.println("value found at index " + index);
		}
	}
}