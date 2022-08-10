package com.hs.leetcode.easy;

public class CheckifArrayIsSortedAndRotated {
	public boolean check(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[(i + 1) % nums.length])
				count++;
		}

		if (count > 1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		CheckifArrayIsSortedAndRotated obj = new CheckifArrayIsSortedAndRotated();
		int[] nums = { 3, 4, 5, 1, 2 };
		boolean result = obj.check(nums);
		System.out.println(result);
	}
}