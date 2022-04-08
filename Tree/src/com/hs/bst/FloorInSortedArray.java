package com.hs.bst;

public class FloorInSortedArray {
	private int findFloor(int[] arr, int key) {
		int n = arr.length;
		int start = 0, end = n - 1;
		int res = 0;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key)
				return key;

			if (arr[mid] > key) {
				end = mid - 1;
			}
			if (arr[mid] < key) {
				start = mid + 1;
				res = arr[mid];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FloorInSortedArray array = new FloorInSortedArray();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int key = 6;
		int i = array.findFloor(arr, key);
		System.out.println(i);
	}
}