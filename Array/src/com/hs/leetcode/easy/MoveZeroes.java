package com.hs.leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is
		// non-zero, then replace the element at index 'count'
		// with this element
		for (int i = 0; i < n; i++)
			if (nums[i] != 0)
				nums[count++] = nums[i]; // here count is
											// incremented

		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < n)
			nums[count++] = 0;
	}

	public static void main(String[] args) {
		MoveZeroes obj = new MoveZeroes();
		int[] nums = { 0, 1, 0, 3, 12 };
		obj.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}