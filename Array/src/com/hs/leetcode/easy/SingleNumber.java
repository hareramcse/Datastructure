package com.hs.leetcode.easy;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int n = nums.length;
		// Do XOR of all elements and return
		int ans = nums[0];
		for (int i = 1; i < n; i++)
			ans = ans ^ nums[i];

		return ans;
	}
}
