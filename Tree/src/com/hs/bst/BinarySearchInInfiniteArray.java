package com.hs.bst;

public class BinarySearchInInfiniteArray {
	private int search(int arr[], int key) {
		int low = 0, high = 1;
		int val = arr[0];

		// Find high to do binary search
		while (val < key) {
			low = high;
			if (2 * high < arr.length - 1)
				high = 2 * high;
			else
				high = arr.length - 1;

			val = arr[high];
		}

		// at this point we have updated low and high indices, 
		// thus use binary search between them
		return binarySearch(arr, low, high, key);
	}

	private int binarySearch(int arr[], int low, int high, int value) {
		int mid = low + (high - low) / 2;
		if (low > high) {
			return -1;
		}
		if (arr[mid] == value) {
			return mid;
		} else if (value < arr[mid]) {
			return binarySearch(arr, low, mid - 1, value);
		} else {
			return binarySearch(arr, mid + 1, high, value);
		}
	}

	public static void main(String[] args) {
		BinarySearchInInfiniteArray bst = new BinarySearchInInfiniteArray();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int index = bst.search(arr, 23);
		if (index == -1) {
			System.out.println("value not found");
		} else {
			System.out.println("value found at index " + index);
		}
	}
}