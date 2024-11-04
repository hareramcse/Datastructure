package com.hs.medium;

public class FindMinimumInRotatedSortedArray {
	// this is the easiest way to find out.
	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return nums[low];
	}

	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			// If the subarray is already sorted
			if (nums[low] <= nums[high])
				return nums[low];

			int mid = low + (high - low) / 2;

			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;

			// Check if the middle element is the minimum
			if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
				return nums[mid];
			} else if (nums[mid] < nums[high]) { // If the right half is sorted, the minimum must be in the left half
				high = mid - 1;
			} else {
				low = mid + 1; // Otherwise, the minimum is in the right half
			}
		}
		return -1; // Should not reach here if input is valid
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
		int[] nums = { 3, 4, 5, 1, 2 };
		int result = obj.findMin(nums);
		System.out.println(result);
	}
}