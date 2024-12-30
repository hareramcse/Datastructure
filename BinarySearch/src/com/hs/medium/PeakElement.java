package com.hs.medium;

public class PeakElement {
	public int findPeakElement(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		PeakElement object = new PeakElement();
		int arr[] = { 2, 4, 12, 15, 22, 23, 25, 65 };
		int index = object.findPeakElement(arr);
		System.out.println(index);
	}
}