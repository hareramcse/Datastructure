package com.hs.leetcode.easy;

public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		int i = 0;
		int j = 0;

		int ans = 0;
		while (j < nums.length) {
			if (j > 0 && nums[j - 1] >= nums[j])
				i = j;
			ans = Math.max(ans, j - i + 1);
			j++;
		}

		return ans;
	}
}
