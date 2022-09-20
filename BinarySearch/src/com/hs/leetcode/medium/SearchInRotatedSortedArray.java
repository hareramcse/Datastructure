package com.hs.leetcode.medium;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[low] <= nums[mid]) { // it means left part is sorted
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] <= nums[high]) { // mid to high part is sorted
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray array = new SearchInRotatedSortedArray();
		int arr[] = { 1, 3 };
		int key = 3;
		int i = array.search(arr, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}