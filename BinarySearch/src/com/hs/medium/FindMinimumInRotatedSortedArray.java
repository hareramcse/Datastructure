package com.hs.medium;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		return findMin(nums, low, high);
	}

	private int findMin(int[] arr, int low, int high) {
		// means whole array is all ready sorted
		if (arr[low] <= arr[high]) {
			return arr[low];
		}

		int n = arr.length;
		int mid = low + (high - low) / 2;

		// this modulo property is for circular array
		int prev = (mid - 1 + n) % n;
		int next = (mid + 1) % n;

		if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
			return arr[mid];
		} else if (arr[mid] < arr[high]) { // it means left array is sorted
			return findMin(arr, low, mid - 1);
		} else {
			return findMin(arr, mid + 1, high);
		}
	}
}