package com.hs.grid;

import java.util.Arrays;

public class Triangle {
	public int minimumTotal(int[][] grid) {
		int n = grid.length;
		int m = grid.length;

		int[][] dp = new int[n][m];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solve(0, 0, grid, dp);
	}

	private int solve(int n, int m, int[][] grid, int[][] dp) {
		if (n == grid.length - 1)
			return grid[n][m];

		if (dp[n][m] != -1)
			return dp[n][m];

		int down = grid[n][m] + solve(n + 1, m, grid, dp);
		int diagonal = grid[n][m] + solve(n + 1, m + 1, grid, dp);
		dp[n][m] = Math.min(down, diagonal);

		return dp[n][m];
	}

	public static void main(String[] args) {
		Triangle obj = new Triangle();
		int[][] grid = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		int result = obj.minimumTotal(grid);
		System.out.println(result);
	}
}