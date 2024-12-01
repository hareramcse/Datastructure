package com.hs.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

	public int solveTab(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n + 1][n + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= -1; j--) {
				int notTake = dp[i + 1][j + 1];

				int take = 0;
				if (j == -1 || nums[i] > nums[j]) {
					take = 1 + dp[i + 1][i + 1];
				}

				dp[i][j + 1] = Math.max(notTake, take);
			}
		}

		return dp[0][0];
	}

	private int solveTabOptimal(int[] nums) {
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

	public int solveBinarySearch(int[] nums) {
		List<Integer> result = new ArrayList<>();

		for (int num : nums) {
			// Find the position where the current number can replace an element
			int index = Collections.binarySearch(result, num);

			if (index < 0) { // If num is not found, binarySearch returns -(insertion_point) - 1
				index = -(index + 1);
			}

			if (index == result.size()) {
				result.add(num);
			} else {
				result.set(index, num);
			}
		}

		return result.size();
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int result = obj.lengthOfLIS(nums);
		System.out.println(result);
		result = obj.solveTab(nums);
		System.out.println(result);
		result = obj.solveTabOptimal(nums);
		System.out.println(result);
		result = obj.solveBinarySearch(nums);
		System.out.println(result);
	}
}