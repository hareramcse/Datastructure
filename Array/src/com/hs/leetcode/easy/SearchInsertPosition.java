package com.hs.leetcode.easy;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
        int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
                ans = mid + 1;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
        return ans;
	}

	public static void main(String[] args) {
		SearchInsertPosition obj = new SearchInsertPosition();
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;
		int result = obj.searchInsert(nums, target);
		System.out.println(result);
	}
}
