package com.hs.bst;

public class BinarySearchByIterativeMethod {
	private int search(int arr[], int value) {
		int length = arr.length;
		int low = 0, high = length - 1;
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

	public static void main(String[] args) {
		BinarySearchByIterativeMethod tree = new BinarySearchByIterativeMethod();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int index = tree.search(arr, 23);
		if (index == -1) {
			System.out.println("value not found");
		} else {
			System.out.println("value found at index " + index);
		}
	}
}