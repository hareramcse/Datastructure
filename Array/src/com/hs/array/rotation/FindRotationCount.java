package com.hs.array.rotation;

public class FindRotationCount {
	
	private static int rotationCount(int arr[], int low, int high) {
		int length = arr.length;
		int mid = low + (high - low) / 2;

		// this modulo property is for circular array
		int next = (mid + 1) % length;
		int prev = (mid + length - 1) % length;

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
		int arr[] = { 3, 4, 5, 1, 2 };
		
		int low = 0;
		int high = arr.length - 1;
		int count2 = rotationCount(arr, low, high);
		System.out.println(count2);
	}
}
