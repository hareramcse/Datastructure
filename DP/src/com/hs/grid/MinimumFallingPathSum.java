package com.hs.grid;

import java.util.Arrays;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < m; j++) {
			int ans = solveMemo(n - 1, j, m, matrix, dp);
			min = Math.min(min, ans);
		}

		return min;
	}

	private int solveMemo(int n, int j, int m, int[][] matrix, int[][] dp) {
		if (n == 0)
			return matrix[n][j];
		
		if (j < 0 || j >= m)
			return (int) 1e9;

		if (dp[n][j] != -1)
			return dp[n][j];

		int up = matrix[n][j] + solveMemo(n - 1, j, m, matrix, dp);
		int leftDiagonal = matrix[n][j] + solveMemo(n - 1, j - 1, m, matrix, dp);
		int rightDiagonal = matrix[n][j] + solveMemo(n - 1, j + 1, m, matrix, dp);
		dp[n][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

		return dp[n][j];
	}

	public static void main(String[] args) {
		MinimumFallingPathSum obj = new MinimumFallingPathSum();
		int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int result = obj.minFallingPathSum(grid);
		System.out.println(result);
	}
}