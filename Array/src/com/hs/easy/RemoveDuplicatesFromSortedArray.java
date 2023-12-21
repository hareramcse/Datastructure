package com.hs.easy;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int result = obj.removeDuplicates(nums);
		System.out.println(result);
	}
}
