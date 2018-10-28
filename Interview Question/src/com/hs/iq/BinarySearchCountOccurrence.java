package com.hs.iq;

public class BinarySearchCountOccurrence {
	private int binarySearchCountOccurrence(int arr[], int data,
			boolean searchFirst) {
		int length = arr.length;
		int low = 0, high = length - 1, result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (data == arr[mid]) {
				result = mid;
				if (searchFirst) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (data < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BinarySearchCountOccurrence binarySearch = new BinarySearchCountOccurrence();
		// array should be strictly sorted
		int arr[] = { 12, 34, 45, 45, 45, 65, 67, 87, 98 };
		int firstIndex = binarySearch
				.binarySearchCountOccurrence(arr, 45, true);
		int lastIndex = binarySearch
				.binarySearchCountOccurrence(arr, 45, false);
		int count = lastIndex - firstIndex + 1;
		if (firstIndex == -1) {
			System.out.println("element doesnt exist in the array");
		} else {
			System.out.println("elememt occurs " + count + " times");
		}
	}
}