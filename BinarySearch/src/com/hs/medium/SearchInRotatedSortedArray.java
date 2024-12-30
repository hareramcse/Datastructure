package com.hs.medium;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[low] <= nums[mid]) { // it means left part is sorted
				if (target >= nums[low] && target <= nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else { // right part is sorted
				if (target >= nums[mid] && target <= nums[high]) {
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
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int key = 0;
		int result = array.search(arr, key);
		if (result != -1)
			System.out.println("Index: " + result);
		else
			System.out.println("Key not found");
	}
}