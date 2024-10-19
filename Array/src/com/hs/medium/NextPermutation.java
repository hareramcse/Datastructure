package com.hs.medium;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int k = n - 2;
		if (nums == null || n <= 1)
			return;

		// find k such that, after kth index all elements are in descending order
		for (int i = n - 1; i > 0; i--) {
			if (nums[i] <= nums[i - 1]) // here = is for,if there is any duplicate number
				k--;
			else
				break;
		}

		// if k == -1
		if (k == -1) {
			reverse(nums, 0, n - 1);
			return;
		}

		// else replace k with next greater element from right and then reverse
		for (int i = n - 1; i > 0; i--) {
			if (nums[i] > nums[k]) {
				swap(nums, i, k);
				break;
			}
		}

		reverse(nums, k + 1, n - 1);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j)
			swap(nums, i++, j--);
	}

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();
		int[] nums = { 1, 2, 3 };
		obj.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}