package com.hs.subsequence;

import java.util.Arrays;

public class SubsetSumEqualToTarget {
	public boolean isSubsetSumEqualToTarget(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solveMemo(arr, n - 1, target, dp);
	}

	private boolean solveMemo(int[] arr, int n, int target, int[][] dp) {
		if (target == 0)
			return true;

		if (n == 0)
			return arr[n] == target;

		if (dp[n][target] != -1)
			return dp[n][target] == 0 ? false : true;

		boolean notTake = solveMemo(arr, n - 1, target, dp);

		boolean take = false;
		if (target >= arr[n])
			take = solveMemo(arr, n - 1, target - arr[n], dp);

		dp[n][target] = notTake || take ? 1 : 0;

		return take || notTake;
	}

	public boolean solveTab(int[] arr, int n, int target) {
		boolean dp[][] = new boolean[n][target + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		if (arr[0] <= target)
			dp[0][arr[0]] = true;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= target; j++) {
				boolean notTaken = dp[i - 1][j];

				boolean taken = false;
				if (arr[i] <= j)
					taken = dp[i - 1][j - arr[i]];

				dp[i][j] = notTaken || taken;
			}
		}
		return dp[n - 1][target];
	}

	public static void main(String[] args) {
		SubsetSumEqualToTarget obj = new SubsetSumEqualToTarget();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		boolean result = obj.isSubsetSumEqualToTarget(arr, 9);
		System.out.println(result);
		result = obj.solveTab(arr, arr.length - 1, 9);
		System.out.println(result);
	}
}