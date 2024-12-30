package com.hs.medium;

public class SearchInRotatedSortedArray2 {
	public boolean search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid])
				return true;

			if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
				low++;
				high--;
				continue;
			}

			if (nums[low] <= nums[mid]) { // left part is sorted
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

		return false;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray2 obj = new SearchInRotatedSortedArray2();
		int[] nums = { 1, 0, 1, 1, 1 };
		int target = 0;
		boolean result = obj.search(nums, target);
		System.out.println(result);
	}
}
