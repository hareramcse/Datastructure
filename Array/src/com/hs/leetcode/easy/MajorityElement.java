package com.hs.leetcode.easy;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int candidate = Integer.MIN_VALUE, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate) {
				count++;
			} else if (count == 0) {
				candidate = nums[i];
				count = 1;
			} else {
				count--;
			}
		}
		return candidate;
	}
}