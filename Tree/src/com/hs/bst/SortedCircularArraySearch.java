package com.hs.bst;

public class SortedCircularArraySearch {
	private int search(int arr[], int low, int high, int key) {
		int minIndex = rotationCount(arr, low, high);
		int left = binarySearch(arr, low, minIndex - 1, key);
		int right = binarySearch(arr, minIndex, high - 1, key);
		if (left != -1) {
			return left;
		}
		if (right != -1) {
			return right;
		}
		return -1;
	}

	private int binarySearch(int arr[], int low, int high, int value) {
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

	private int rotationCount(int arr[], int low, int high) {
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

	public static void main(String[] args) {
		SortedCircularArraySearch array = new SortedCircularArraySearch();
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 6;
		int i = array.search(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}