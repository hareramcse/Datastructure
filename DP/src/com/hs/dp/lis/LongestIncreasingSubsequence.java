package com.hs.dp.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solveMemo(nums, 0, -1, dp);
	}

	private int solveMemo(int[] nums, int n, int m, int[][] dp) {
		if (n == nums.length)
			return 0;

		if (dp[n][m + 1] != -1)
			return dp[n][m + 1];

		int notTake = solveMemo(nums, n + 1, m, dp);

		int take = 0;
		if (m == -1 || nums[n] > nums[m]) {
			take = 1 + solveMemo(nums, n + 1, n, dp);
		}

		dp[n][m + 1] = Math.max(notTake, take);
		return dp[n][m + 1];
	}

	private int solveTab(int[] nums) {
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
		result = obj.solveTab(nums);
		System.out.println(result);
	}
}