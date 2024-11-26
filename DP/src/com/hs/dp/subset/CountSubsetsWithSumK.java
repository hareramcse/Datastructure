package com.hs.dp.subset;

import java.util.Arrays;

public class CountSubsetsWithSumK {
	public int countSubsetWithSumK(int[] arr, int K) {
		int n = arr.length;
		int[][] dp = new int[n][K + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solveMemo(n - 1, arr, K, dp);
	}

	private int solveMemo(int n, int[] arr, int target, int[][] dp) {
		if (target == 0)
			return 1;

		if (n < 0 || target < 0)
			return 0;

		if (dp[n][target] != -1)
			return dp[n][target];

		int notTake = solveMemo(n - 1, arr, target, dp);
		int take = solveMemo(n - 1, arr, target - arr[n], dp);
		dp[n][target] = notTake + take;

		return dp[n][target];
	}

	public static void main(String[] args) {
		CountSubsetsWithSumK obj = new CountSubsetsWithSumK();
		int[] arr = { 1, 2, 2, 3 };
		int K = 3;
		int result = obj.countSubsetWithSumK(arr, K);
		System.out.println(result);
	}
}