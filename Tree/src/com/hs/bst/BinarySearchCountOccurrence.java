package com.hs.bst;

// 34. Find First and Last Position of Element in Sorted Array Leetcode
public class BinarySearchCountOccurrence {
	public int findCount(int arr[], int value, boolean searchFirst) {
		int low = 0, high = arr.length - 1, result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (value == arr[mid]) {
				result = mid;
				if (searchFirst) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (value < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BinarySearchCountOccurrence tree = new BinarySearchCountOccurrence();
		// array should be strictly sorted
		int arr[] = { 12, 34, 45, 45, 45, 65, 67, 87, 98 };
		int firstIndex = tree.findCount(arr, 45, true);
		int lastIndex = tree.findCount(arr, 45, false);
		int count = lastIndex - firstIndex + 1;
		if (firstIndex == -1) {
			System.out.println("element doesnt exist in the array");
		} else {
			System.out.println("elememt occurs " + count + " times");
		}
	}
}