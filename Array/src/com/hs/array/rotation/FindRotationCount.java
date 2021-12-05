package com.hs.array.rotation;

public class FindRotationCount {
	// here goal is to find out the minimum value index in the array
	private int rotationCount(int arr[], int low, int high) {
		int n = arr.length;
		int mid = low + (high - low) / 2;

		// this modulo property is for circular array
		int next = (mid + 1) % n;
		int prev = (mid - 1 + n) % n;

		// means whole array is all ready sorted
		if (arr[low] <= arr[high]) {
			return low;
		}

		if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
			return mid;
		} else if (arr[mid] < arr[high]) {
			return rotationCount(arr, low, mid - 1);
		} else {
			return rotationCount(arr, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		FindRotationCount array = new FindRotationCount();

		int arr[] = { 3, 4, 5, 1, 2 };
		int low = 0;
		int high = arr.length - 1;
		int count = array.rotationCount(arr, low, high);
		System.out.println(count);
	}
}
