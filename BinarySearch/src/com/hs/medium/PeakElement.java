package com.hs.medium;

public class PeakElement {
	public int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;

		if (nums[0] > nums[1]) // check if first element is peak element
			return 0;

		if (nums[n - 1] > nums[n - 2]) // check if last element is peak element
			return n - 1;

		int low = 1, high = n - 2; // search with remaining elements
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] < nums[mid + 1]) { // it means nums[mid+1] could be peak element
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		PeakElement object = new PeakElement();
		int arr[] = { 1, 2, 1, 3, 5, 6, 4 };
		int index = object.findPeakElement(arr);
		System.out.println(index);
	}
}