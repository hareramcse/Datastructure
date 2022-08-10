package com.hs.bst;

public class SearchInRotatedSortedArray {
	public int search(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		return search(arr, low, high, key);
	}

	private int search(int[] arr, int low, int high, int key) {
		int minIndex = rotationCount(arr, low, high);
		int left = binarySearch(arr, low, minIndex - 1, key);
		int right = binarySearch(arr, minIndex, high, key);
		if (left != -1) {
			return left;
		}
		if (right != -1) {
			return right;
		}
		return -1;
	}

	private int rotationCount(int[] arr, int low, int high) {
		// means whole array is all ready sorted
		if (arr[low] <= arr[high]) {
			return low;
		}

		int n = arr.length;
		int mid = low + (high - low) / 2;

		// this modulo property is for circular array
		int next = (mid + 1) % n;
		int prev = (mid - 1 + n) % n;

		if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
			return mid;
		} else if (arr[mid] < arr[high]) {
			return rotationCount(arr, low, mid - 1);
		} else {
			return rotationCount(arr, mid + 1, high);
		}
	}

	private int binarySearch(int[] arr, int low, int high, int value) {
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
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray array = new SearchInRotatedSortedArray();
		int arr[] = { 1, 3 };
		int key = 3;
		int i = array.search(arr, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}