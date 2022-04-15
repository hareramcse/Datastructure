package com.hs.dp.knapsack.zeroone;

public class MinimumSubsetSumDifference {
	private int minDiffernce(int arr[]) {
		int n = arr.length;
		int range = 0;
		for (int i = 0; i < n; i++)
			range = range + arr[i];
		boolean[][] dp = subsetSum(arr, n, range/2);
		int diff = Integer.MAX_VALUE;
		/// largest j such that dp[n][j] is true where j loops from sum/2 to 0
		for (int j = range / 2; j >= 0; j--) {
			if (dp[n][j] == true) {
				diff = range - 2 * j;
				break;
			}
		}
		return diff;
	}

	private boolean[][] subsetSum(int arr[], int n, int range) {
		boolean[][] dp = new boolean[n + 1][range + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= range; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= range; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp;
	}

	public static void main(String[] args) {
		MinimumSubsetSumDifference mds = new MinimumSubsetSumDifference();
		int[] arr = { 1, 2, 7 };
		int minDiffernce = mds.minDiffernce(arr);
		System.out.println(minDiffernce);
	}
}