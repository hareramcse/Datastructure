package com.hs.easy;

import java.util.Arrays;

public class SortArrayByParity2 {
	public int[] sortArrayByParityII(int[] nums) {
		int start = 0;
		int end = 1;
		int n = nums.length;

		while (start < n && end < n) {
			while (start < n && nums[end] % 2 == 0) {
				start += 2;
			}

			while (end < n && nums[end] % 2 == 1) {
				end += 2;
			}

			if (start < n && end < n) {
				swap(nums, start, end);
			}
		}
		return nums;
	}

	private void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	public static void main(String[] args) {
		SortArrayByParity2 obj = new SortArrayByParity2();
		int[] nums = { 4, 2, 5, 7 };
		int[] result = obj.sortArrayByParityII(nums);
		System.out.println(Arrays.toString(result));
	}
}