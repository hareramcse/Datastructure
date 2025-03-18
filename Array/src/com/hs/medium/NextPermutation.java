package com.hs.medium;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		if (nums == null || n <= 1)
			return;

		int k = -1; // index from where all elements are in descending order
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}

		// If k == -1, it means all elements are sorted in descending order.
		// Reverse the array to get the next greater permutation.
		if (k == -1) {
			reverse(nums, 0, n - 1);
			return;
		}

		// Swap kth index with the next greater element than nums[k] from the right
		for (int i = n - 1; i >= k; i--) {
			if (nums[i] > nums[k]) {
				swap(nums, i, k);
				break;
			}
		}

		// Reverse the part of the array to the right of index k
		reverse(nums, k + 1, n - 1);
	}

	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			swap(nums, left++, right--);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();
		int[] nums = { 2, 1, 5, 4, 3, 0, 0 };
		obj.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}