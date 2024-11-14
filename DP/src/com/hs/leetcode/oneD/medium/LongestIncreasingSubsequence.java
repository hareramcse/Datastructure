package com.hs.leetcode.oneD.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solveMemo(nums, 0, -1, dp);
	}

	private int solveMemo(int[] nums, int ind, int prev_ind, int[][] dp) {
		if (ind == nums.length)
			return 0;

		if (dp[ind][prev_ind + 1] != -1)
			return dp[ind][prev_ind + 1];

		int take = 0;
		int notTake = solveMemo(nums, ind + 1, prev_ind, dp);
		if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
			take = 1 + solveMemo(nums, ind + 1, ind, dp);
		}
		return dp[ind][prev_ind + 1] = Math.max(notTake, take);
	}

	private int solveTab(int[] nums) {
		int[] dp = new int[nums.length];

		Arrays.fill(dp, 1);

		int ans = 0;
		for (int ind = 0; ind < nums.length; ind++) {
			for (int prev = 0; prev < ind; prev++) {
				if (nums[prev] < nums[ind]) {
					dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
				}
			}
			ans = Math.max(ans, dp[ind]);
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int result = obj.lengthOfLIS(nums);
		System.out.println(result);
		result = obj.solveTab(nums);
		System.out.println(result);
	}
}