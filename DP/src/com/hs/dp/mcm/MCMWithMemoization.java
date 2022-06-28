package com.hs.dp.mcm;

public class MCMWithMemoization {

	private int solve(int[] arr) {
		int i = 1;
		int j = arr.length - 1;
		int[][] dp = new int[j + 1][j + 1];
		return solve(dp, arr, i, j);
	}

	private int solve(int[][] dp, int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(dp, arr, i, k) + solve(dp, arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			min = Math.min(min, temp);
		}
		return dp[i][j] = min;
	}

	public static void main(String[] args) {
		MCMWithMemoization mcm = new MCMWithMemoization();
		int[] arr = { 1, 2, 3, 4, 3 };
		int ans = mcm.solve(arr);
		System.out.println(ans);
	}
}