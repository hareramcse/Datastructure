package com.hs.medium;

public class SortColors {
	public void sortColors(int[] nums) {
		int left = 0, mid = 0, right = nums.length - 1;
		while (mid <= right) {
			if (nums[mid] == 0) {
				swap(nums, mid++, left++);
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				swap(nums, mid, right--);
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
