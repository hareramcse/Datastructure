package com.hs.leetcode.medium;

public class JumpGame2 {
	public int jump(int[] nums) {
		int ans = 0;
		int left = 0, right = 0;
		while (right < nums.length - 1) {
			int maxReach = 0;
			for (int i = left; i < right + 1; i++) {
				maxReach = Math.max(maxReach, i + nums[i]);
			}

			left = right + 1;
			right = maxReach;
			ans++;
		}
		return ans;
	}
}
