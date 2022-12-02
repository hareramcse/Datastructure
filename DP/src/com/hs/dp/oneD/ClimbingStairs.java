package com.hs.dp.oneD;

import java.util.Arrays;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		ClimbingStairs obj = new ClimbingStairs();
		int n = 3;
		int result = obj.climbStairs(n);
		System.out.println(result);
	}
}