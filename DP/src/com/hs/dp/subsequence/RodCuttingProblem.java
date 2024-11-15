package com.hs.dp.subsequence;

import java.util.Arrays;

public class RodCuttingProblem {
	public int cutRod(int[] price, int N) {
		int dp[][] = new int[N][N + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solveMemo(price, N - 1, N, dp);
	}

	private int solveMemo(int[] price, int n, int N, int[][] dp) {
		if (n == 0) {
			return N * price[0];
		}

		if (dp[n][N] != -1)
			return dp[n][N];

		int notTaken = solveMemo(price, n - 1, N, dp);

		int taken = Integer.MIN_VALUE;
		int rodLength = n + 1;
		if (rodLength <= N)
			taken = price[n] + solveMemo(price, n, N - rodLength, dp);

		dp[n][N] = Math.max(notTaken, taken);
		return dp[n][N];
	}

	public static void main(String[] args) {
		RodCuttingProblem obj = new RodCuttingProblem();
		int[] price = { 3, 5, 8, 9, 10, 17, 17, 20 };
		int N = 8;
		int result = obj.cutRod(price, N);
		System.out.println(result);
	}
}
