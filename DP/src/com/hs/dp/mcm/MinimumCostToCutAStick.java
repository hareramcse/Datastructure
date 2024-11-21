package com.hs.dp.mcm;

import java.util.Arrays;

public class MinimumCostToCutAStick {
	private int minCost(int n, int[] cuts) {
		int m = cuts.length;
		int[] allCuts = new int[m + 2];
		allCuts[0] = 0;
		allCuts[m + 1] = n;

		for (int i = 0; i < m; i++) {
			allCuts[i + 1] = cuts[i];
		}

		Arrays.sort(allCuts);

		int[][] dp = new int[m + 2][m + 2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(1, m, allCuts, dp);
	}

	public int solveMemo(int i, int j, int[] cuts, int[][] dp) {
		if (i > j) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;
		for (int ind = i; ind <= j; ind++) {
			int cost = cuts[j + 1] - cuts[i - 1] + solveMemo(i, ind - 1, cuts, dp) + solveMemo(ind + 1, j, cuts, dp);
			min = Math.min(min, cost);
		}
		dp[i][j] = min;
		
		return dp[i][j];
	}

	public static void main(String[] args) {
		MinimumCostToCutAStick obj = new MinimumCostToCutAStick();
		int[] cuts = { 3, 5, 1, 4 };
		int n = 7;
		System.out.println("The minimum cost incurred: " + obj.minCost(n, cuts));
	}
}
