package com.hs.array.misc;

public class PeakElement {
	public static Integer getPeakElement(int[] arr) {

		if (arr == null || arr.length == 0) {
			return null;
		}

		int n = arr.length;

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
				return arr[mid];
			} else {
				if (mid > 0 && arr[mid - 1] > arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 20, 4, 1, 0 };
		Integer peak = getPeakElement(arr);
		System.out.println(peak != null ? "Peak Element is " + peak : "No peak element!");
	}
}
