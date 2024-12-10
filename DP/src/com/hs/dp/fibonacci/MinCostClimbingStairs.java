package com.hs.dp.fibonacci;

import java.util.Arrays;

public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return solveMemo(n, cost, dp);
	}

	private int solveMemo(int n, int[] cost, int[] dp) {
		if (n == 0 || n == 1)
			return 0;

		if (dp[n] != -1)
			return dp[n];

		int pick = cost[n - 1] + solveMemo(n - 1, cost, dp);
		int notPick = cost[n - 2] + solveMemo(n - 2, cost, dp);
		dp[n] = Math.min(pick, notPick);
		
		return dp[n];
	}

	public static void main(String[] args) {
		MinCostClimbingStairs obj = new MinCostClimbingStairs();
		int[] cost = { 10, 15, 20 };
		int result = obj.minCostClimbingStairs(cost);
		System.out.println(result);
	}
}
