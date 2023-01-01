package com.hs.dp.square;

public class CountSquareSubmatricesWithAllOnes {
	public int countSquares(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = matrix[i][0];
		}

		for (int i = 0; i < m; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 0)
					dp[i][j] = 0;
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += dp[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		CountSquareSubmatricesWithAllOnes obj = new CountSquareSubmatricesWithAllOnes();
		int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int result = obj.countSquares(matrix);
		System.out.println(result);
	}
}
