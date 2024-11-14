package com.hs.fibonacci;

import java.util.Arrays;

public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return solve(n, cost, dp);
	}

	private int solve(int n, int[] cost, int[] dp) {
		if (n == 0 || n == 1)
			return 0;

		if (dp[n] != -1)
			return dp[n];

		dp[n] = Math.min(cost[n - 1] + solve(n - 1, cost, dp), cost[n - 2] + solve(n - 2, cost, dp));
		return dp[n];
	}

	public static void main(String[] args) {
		MinCostClimbingStairs obj = new MinCostClimbingStairs();
		int[] cost = { 10, 15, 20 };
		int result = obj.minCostClimbingStairs(cost);
		System.out.println(result);
	}
}
