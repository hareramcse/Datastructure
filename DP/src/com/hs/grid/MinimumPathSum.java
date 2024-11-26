package com.hs.grid;

import java.util.Arrays;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] dp = new int[n][m];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(n - 1, m - 1, grid, dp);
	}

	private int solveMemo(int n, int m, int[][] grid, int[][] dp) {
		if (n == 0 && m == 0)
			return grid[n][m];
		
		if (n < 0 || m < 0)
			return (int) 1e9;

		if (dp[n][m] != -1)
			return dp[n][m];

		int up = grid[n][m] + solveMemo(n - 1, m, grid, dp);
		int left = grid[n][m] + solveMemo(n, m - 1, grid, dp);
		dp[n][m] = Math.min(up, left);

		return dp[n][m];
	}

	public static void main(String[] args) {
		MinimumPathSum obj = new MinimumPathSum();
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int result = obj.minPathSum(grid);
		System.out.println(result);
	}
}