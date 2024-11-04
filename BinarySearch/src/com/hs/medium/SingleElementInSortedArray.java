package com.hs.medium;

public class SingleElementInSortedArray {
	public int singleNonDuplicate(int[] nums) {
		int low = 0;
		int high = nums.length - 2;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == nums[mid ^ 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return nums[low];
	}

	public static void main(String[] args) {
		SingleElementInSortedArray obj = new SingleElementInSortedArray();
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int result = obj.singleNonDuplicate(nums);
		System.out.println(result);
	}
}
