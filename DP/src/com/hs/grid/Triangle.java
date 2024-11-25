package com.hs.grid;

import java.util.Arrays;

public class Triangle {
	public int minimumTotal(int[][] grid) {
		int m = grid.length;
		int n = grid.length;

		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solve(0, 0, grid, dp);
	}

	private int solve(int m, int n, int[][] grid, int[][] dp) {
		if (m == grid.length - 1)
			return grid[m][n];

		if (dp[m][n] != -1)
			return dp[m][n];

		int down = grid[m][n] + solve(m + 1, n, grid, dp);
		int diagonal = grid[m][n] + solve(m + 1, n + 1, grid, dp);
		dp[m][n] = Math.min(down, diagonal);

		return dp[m][n];
	}

	public static void main(String[] args) {
		Triangle obj = new Triangle();
		int[][] grid = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		int result = obj.minimumTotal(grid);
		System.out.println(result);
	}
}