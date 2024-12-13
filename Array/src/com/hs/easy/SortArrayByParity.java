package com.hs.easy;

import java.util.Arrays;

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			// Increment start index when we see even number in left
			while (start < end && nums[start] % 2 == 0)
				start++;

			// Decrement right index when we see odd number from right
			while (start < end && nums[end] % 2 == 1)
				end--;

			if (start < end) {
				swap(nums, start, end);
				start++;
				end--;
			}
		}
		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		SortArrayByParity obj = new SortArrayByParity();
		int[] nums = { 3, 1, 2, 4 };
		int[] result = obj.sortArrayByParity(nums);
		System.out.println(Arrays.toString(result));
	}
}