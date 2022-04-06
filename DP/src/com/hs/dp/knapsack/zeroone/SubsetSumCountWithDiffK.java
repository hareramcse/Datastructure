package com.hs.dp.knapsack.zeroone;

public class SubsetSumCountWithDiffK {
	private int subsetSumCountWithDiffK(int[] arr, int diff) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		sum = (diff + sum) / 2;
		return subSetSumCount(arr, sum);
	}

	private int subSetSumCount(int[] arr, int sum) {
		int[][] dp = new int[arr.length + 1][sum + 1];

		for (int i = 0; i < sum + 1; i++)
			dp[0][i] = 0;
		for (int i = 0; i < arr.length + 1; i++)
			dp[i][0] = 1;

		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[arr.length][sum];
	}

	public static void main(String[] args) {
		SubsetSumCountWithDiffK kbu = new SubsetSumCountWithDiffK();
		int[] arr = new int[] { 5, 4, 6, 3, 1 };
		int diff = 1;
		int count = kbu.subsetSumCountWithDiffK(arr, diff);
		System.out.println(count);
	}
}