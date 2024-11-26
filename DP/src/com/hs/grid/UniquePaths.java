package com.hs.grid;

import java.util.Arrays;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(m - 1, n - 1, dp);
	}

	private int solveMemo(int m, int n, int[][] dp) {
		if (m == 0 && n == 0)
			return 1;

		if (m < 0 || n < 0)
			return 0;

		if (dp[m][n] != -1)
			return dp[m][n];

		int up = solveMemo(m - 1, n, dp);
		int left = solveMemo(m, n - 1, dp);
		dp[m][n] = up + left;
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		UniquePaths obj = new UniquePaths();
		int m = 3, n = 7;
		int result = obj.uniquePaths(n, m);
		System.out.println(result);
	}
}