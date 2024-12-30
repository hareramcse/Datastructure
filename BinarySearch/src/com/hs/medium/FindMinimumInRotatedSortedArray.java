package com.hs.medium;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			if (nums[low] <= nums[high]) // If the subarray is already sorted
				return nums[low];

			int mid = low + (high - low) / 2;

			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;

			// Check if the middle element is the minimum
			if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
				return nums[mid];
			} else if (nums[mid] < nums[high]) { // right half is sorted, the minimum must be in the left half
				high = mid - 1;
			} else {
				low = mid + 1; // left half is sorted, the minimum will be in the right half
			}
		}

		return -1; // Should not reach here if input is valid
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int result = obj.findMin(nums);
		System.out.println(result);
	}
}