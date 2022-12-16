package com.hs.dp.subsequence;

import java.util.Arrays;

public class RodCuttingProblem {
	int cutRod(int[] price, int N) {
		int dp[][] = new int[N][N + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solveMemo(price, N - 1, N, dp);
	}

	private int solveMemo(int[] price, int ind, int N, int[][] dp) {
		if (ind == 0) {
			return N * price[0];
		}

		if (dp[ind][N] != -1)
			return dp[ind][N];

		int notTaken = solveMemo(price, ind - 1, N, dp);

		int taken = Integer.MIN_VALUE;
		int rodLength = ind + 1;
		if (rodLength <= N)
			taken = price[ind] + solveMemo(price, ind, N - rodLength, dp);

		return dp[ind][N] = Math.max(notTaken, taken);
	}
}
