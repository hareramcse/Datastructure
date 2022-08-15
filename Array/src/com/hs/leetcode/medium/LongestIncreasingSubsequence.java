package com.hs.leetcode.medium;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];

		// each element itself is an increasing sub sequence
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
		}

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
		int[] nums = { 1,3,5,4,7 };
		int ans = obj.lengthOfLIS(nums);
		System.out.println(ans);
	}
}