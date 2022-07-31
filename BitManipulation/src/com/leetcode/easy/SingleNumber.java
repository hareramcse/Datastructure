package com.leetcode.easy;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int l = nums.length;
		int res = 0;
		for (int i = 0; i < l; i++) {
			res = res ^ nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		SingleNumber obj = new SingleNumber();
		int[] nums = { 4, 1, 2, 1, 2 };
		int result = obj.singleNumber(nums);
		System.out.println(result);
	}
}
