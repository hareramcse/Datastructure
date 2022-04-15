package com.hs.dp.knapsack.zeroone;

public class SubsetSum {
	private boolean subSetSum(int[] arr, int sum) {
		int n = arr.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		SubsetSum kbu = new SubsetSum();
		int[] arr = new int[] { 1, 3, 5, 7, 8, 9 };
		int sum = 4;
		boolean found = kbu.subSetSum(arr, sum);
		System.out.println(found);
	}
}