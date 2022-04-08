package com.hs.bst;

public class PeakElement {
	private int search(int[] arr, int key) {
		int length = arr.length;
		int low = 0, high = length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < length - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return mid;
				} else if (arr[mid - 1] > arr[mid]) {
					high = mid - 1;
				} else{
					low = mid + 1;
				}
			} else if (mid == 0) {
				if (arr[0] > arr[1]) {
					return 0;
				} else {
					return 1;
				}
			} else if (mid == length - 1) {
				if (arr[length - 1] > arr[length - 2]) {
					return length - 1;
				} else {
					return length - 2;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		PeakElement tree = new PeakElement();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int index = tree.search(arr, 23);
		System.out.println(index);
	}
}