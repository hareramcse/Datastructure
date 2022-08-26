package com.hs.basic;

public class MinDiffFromGivenKeyInSortedArray {
	public int search(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// if key is present it means this element only will give min diff
			if (key == arr[mid]) {
				res = arr[mid];
				return arr[mid];
			} else if (key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// if while loop doesn't return anything means value is not there in the array
		if (res != -1) {
			return res;
		} else {
			// if key is not present in the arr then low and high will be the neighbors of
			// the key. 
			return Math.min(Math.abs(arr[low] - key), Math.abs(arr[high] - key));
		}
	}

	public static void main(String[] args) {
		MinDiffFromGivenKeyInSortedArray bst = new MinDiffFromGivenKeyInSortedArray();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int value = bst.search(arr, 24);
		System.out.println(value);
	}
}