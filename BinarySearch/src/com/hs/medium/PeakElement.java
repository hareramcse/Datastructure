package com.hs.medium;

public class PeakElement {
	public int findPeakElement(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
				return mid;
			} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		PeakElement tree = new PeakElement();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int index = tree.findPeakElement(arr);
		System.out.println(index);
	}
}