package com.hs.medium;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
        
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
        
		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i])
				j--;
            
			swap(nums, i, j);
		}
		reverse(nums, i + 1, nums.length - 1);
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