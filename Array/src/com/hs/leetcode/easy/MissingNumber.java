package com.hs.leetcode.easy;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			ans ^= nums[i] ^ i;
		}

		ans ^= n;
		return ans;
	}

	public static void main(String[] args) {
		MissingNumber obj = new MissingNumber();
		int[] nums = { 3, 0, 1 };
		int result = obj.missingNumber(nums);
		System.out.println(result);
	}
}
