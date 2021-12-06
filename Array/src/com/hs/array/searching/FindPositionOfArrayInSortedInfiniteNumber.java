package com.hs.array.searching;

public class FindPositionOfArrayInSortedInfiniteNumber {
	// Simple binary search algorithm
	private int binarySearch(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return binarySearch(arr, low, mid - 1, x);
			return binarySearch(arr, mid + 1, high, x);
		}
		return -1;
	}

	private int findPos(int arr[], int key) {
		int low = 0, high = 1;
		int val = arr[0];

		// Find high to do binary search
		while (val < key) {
			low = high; // store previous high
			// check that 2*h doesn't exceeds array
			// length to prevent ArrayOutOfBoundException
			if (2 * high < arr.length - 1)
				high = 2 * high;
			else
				high = arr.length - 1;

			val = arr[high]; // update new val
		}

		// at this point we have updated low and high indices,
		// thus use binary search between them
		return binarySearch(arr, low, high, key);
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		FindPositionOfArrayInSortedInfiniteNumber array = new FindPositionOfArrayInSortedInfiniteNumber();
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int ans = array.findPos(arr, 10);

		if (ans == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index " + ans);
	}
}
