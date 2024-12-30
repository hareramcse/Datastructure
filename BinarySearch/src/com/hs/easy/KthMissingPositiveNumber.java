package com.hs.easy;

public class KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] - (mid + 1) >= k) { // arr[mid] - (mid + 1) will give the no of missing element
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low + k;
	}

	public static void main(String[] args) {
		KthMissingPositiveNumber obj = new KthMissingPositiveNumber();
		int[] arr = { 2, 3, 4, 7, 11 };
		int k = 5;
		int result = obj.findKthPositive(arr, k);
		System.out.println(result);
	}
}
