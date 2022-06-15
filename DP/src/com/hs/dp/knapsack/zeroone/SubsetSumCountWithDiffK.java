package com.hs.dp.knapsack.zeroone;

public class SubsetSumCountWithDiffK {
	private int subsetSumCountWithDiffK(int[] arr, int diff) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		sum = (diff + sum) / 2;
		return subSetSumCount(arr, sum, n);
	}

	private int subSetSumCount(int[] arr, int sum, int n) {
		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					dp[i][j] = 0;
				if (j == 0)
					dp[i][j] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		SubsetSumCountWithDiffK kbu = new SubsetSumCountWithDiffK();
		int[] arr = new int[] { 5, 4, 6, 3, 1 };
		int diff = 1;
		int count = kbu.subsetSumCountWithDiffK(arr, diff);
		System.out.println(count);
	}
}