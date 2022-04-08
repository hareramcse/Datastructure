package com.hs.bst;

public class BinarySearchOnReverseSortedArray {
	private int search(int arr[], int value) {
		int lenght = arr.length;
		int low = 0, high = lenght - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (value == arr[mid]) {
				return mid;
			} else if (value > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// if while loop doesn't return anything means value is not there in the array
		return -1;
	}

	public static void main(String[] args) {
		BinarySearchOnReverseSortedArray tree = new BinarySearchOnReverseSortedArray();
		int arr[] = { 65, 25, 23, 22, 15, 12, 4, 2 };
		int index = tree.search(arr, 23);
		if (index == -1) {
			System.out.println("value not found");
		} else {
			System.out.println("value found at index " + index);
		}
	}
}
