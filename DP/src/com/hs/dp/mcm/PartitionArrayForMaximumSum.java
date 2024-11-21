package com.hs.dp.mcm;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return solveMemo(arr, 0, n, k, dp);
	}

	private int solveMemo(int[] arr, int i, int n, int k, int[] dp) {
		if (i == arr.length)
			return 0;

		if (dp[i] != -1)
			return dp[i];

		int len = 0;
		int maxi = Integer.MIN_VALUE;
		int maxAns = Integer.MIN_VALUE;

		for (int j = i; j < Math.min(i + k, n); j++) {
			len++;
			maxi = Math.max(maxi, arr[j]);
			int sum = len * maxi + solveMemo(arr, j + 1, n, k, dp);
			maxAns = Math.max(maxAns, sum);
		}
		return dp[i] = maxAns;
	}

	public int solveTab(int[] arr, int k) {
		int n = arr.length;
		int[] dp = new int[n + 1];

		dp[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			int len = 0;
			int maxi = Integer.MIN_VALUE;
			int maxAns = Integer.MIN_VALUE;

			for (int j = i; j < Math.min(i + k, n); j++) {
				len++;
				maxi = Math.max(maxi, arr[j]);
				int sum = len * maxi + dp[j + 1];
				maxAns = Math.max(maxAns, sum);
			}

			dp[i] = maxAns;
		}

		return dp[0];
	}

	public static void main(String[] args) {
		PartitionArrayForMaximumSum obj = new PartitionArrayForMaximumSum();
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		int result = obj.maxSumAfterPartitioning(arr, k);
		System.out.println(result);
		result = obj.solveTab(arr, k);
		System.out.println(result);
	}
}