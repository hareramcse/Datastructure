package com.hs.leetcode.medium;

public class JumpGame {
	public static boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;

		int left = 0, right = 0;
		while (right < nums.length) {
			int maxReach = 0;
			for (int i = left; i < right + 1; i++) {
				maxReach = Math.max(maxReach, i + nums[i]);
			}

			left = right + 1;
			right = maxReach;
			if (left > right)
				return false;
			if (maxReach >= nums.length - 1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		boolean canJump = JumpGame.canJump(nums);
		System.out.println(canJump);
	}
}
