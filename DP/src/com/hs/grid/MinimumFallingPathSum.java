package com.hs.grid;

import java.util.Arrays;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int dp[][] = new int[m][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		int min = Integer.MAX_VALUE;

		for (int j = 0; j < n; j++) {
			int ans = solveMemo(m - 1, j, n, matrix, dp);
			min = Math.min(min, ans);
		}

		return min;
	}

	private int solveMemo(int m, int j, int n, int[][] matrix, int[][] dp) {
		if (j < 0 || j >= n)
			return (int) 1e9;

		if (m == 0)
			return matrix[0][j];

		if (dp[m][j] != -1)
			return dp[m][j];

		int up = matrix[m][j] + solveMemo(m - 1, j, n, matrix, dp);
		int leftDiagonal = matrix[m][j] + solveMemo(m - 1, j - 1, n, matrix, dp);
		int rightDiagonal = matrix[m][j] + solveMemo(m - 1, j + 1, n, matrix, dp);

		return dp[m][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
	}

	public static void main(String[] args) {
		MinimumFallingPathSum obj = new MinimumFallingPathSum();
		int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int result = obj.minFallingPathSum(grid);
		System.out.println(result);
	}
}