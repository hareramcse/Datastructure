package com.hs.basic;

public class FloorInSortedArray {
	public int findFloor(int[] arr, int value) {
		int low = 0, high = arr.length - 1;
		int res = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (value == arr[mid]) {
				return value;
			} else if (value < arr[mid]) {
				high = mid - 1;
			} else {
				res = arr[mid];
				low = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FloorInSortedArray array = new FloorInSortedArray();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int value = 6;
		int i = array.findFloor(arr, value);
		System.out.println(i);
	}
}