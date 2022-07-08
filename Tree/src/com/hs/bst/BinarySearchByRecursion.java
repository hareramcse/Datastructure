package com.hs.bst;

public class BinarySearchByRecursion {
	private int search(int arr[], int low, int high, int value) {
		int mid = low + (high - low) / 2;
		if (low > high) {
			return -1;
		}
		if (arr[mid] == value) {
			return mid;
		} else if (value < arr[mid]) {
			return search(arr, low, mid - 1, value);
		} else {
			return search(arr, mid + 1, high, value);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		BinarySearchByRecursion tree = new BinarySearchByRecursion();
		int index = tree.search(arr, 0, arr.length - 1, 23);
		if (index == -1) {
			System.out.println("value not found");
		} else {
			System.out.println("value found at index " + index);
		}
	}
}