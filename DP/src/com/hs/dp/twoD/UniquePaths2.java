package com.hs.dp.twoD;

import java.util.Arrays;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(m - 1, n - 1, obstacleGrid, dp);
	}

	private int solveMemo(int m, int n, int[][] obstacleGrid, int[][] dp) {
		if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1)
			return 0;

		if (m == 0 && n == 0)
			return 1;

		if (m < 0 || n < 0)
			return 0;

		if (dp[m][n] != -1)
			return dp[m][n];

		int up = solveMemo(m - 1, n, obstacleGrid, dp);
		int left = solveMemo(m, n - 1, obstacleGrid, dp);

		return dp[m][n] = up + left;
	}

	public static void main(String[] args) {
		UniquePaths2 obj = new UniquePaths2();
		int[][] obstacleGrid = { { 0, 1 }, { 0, 0 } };
		int result = obj.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
	}
}