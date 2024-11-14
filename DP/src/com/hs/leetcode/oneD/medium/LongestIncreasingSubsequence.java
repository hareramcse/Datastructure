package com.hs.leetcode.oneD.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	private int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];

		Arrays.fill(dp, 1);

		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int result = obj.lengthOfLIS(nums);
		System.out.println(result);
	}
}