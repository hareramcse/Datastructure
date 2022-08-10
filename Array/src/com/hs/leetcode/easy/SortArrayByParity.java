package com.hs.leetcode.easy;

import java.util.Arrays;

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		int[] ans = new int[nums.length];
		int i = 0;
		for (int num : nums) {
			if (num % 2 == 0)
				ans[i++] = num;
		}
		for (int num : nums) {
			if (num % 2 != 0)
				ans[i++] = num;
		}

		return ans;
	}

	public static void main(String[] args) {
		SortArrayByParity obj = new SortArrayByParity();
		int[] nums = { 3, 1, 2, 4 };
		int[] result = obj.sortArrayByParity(nums);
		System.out.println(Arrays.toString(result));
	}
}