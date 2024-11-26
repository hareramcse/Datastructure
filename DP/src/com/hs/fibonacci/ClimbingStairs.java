package com.hs.fibonacci;

import java.util.Arrays;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return solveMemo(n, dp);
	}

	private int solveMemo(int n, int[] dp) {
		if (n == 0 || n == 1)
			return 1;

		if (dp[n] != -1)
			return dp[n];

		dp[n] = solveMemo(n - 1, dp) + solveMemo(n - 2, dp);
		return dp[n];
	}

	public static void main(String[] args) {
		ClimbingStairs obj = new ClimbingStairs();
		int n = 3;
		int result = obj.climbStairs(n);
		System.out.println(result);
	}
}
