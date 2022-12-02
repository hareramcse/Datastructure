package com.hs.dp.oneD;

import java.util.Arrays;

public class FrogJump {
	public int frogJump(int[] cost) {
		int n = cost.length;
		return frogJumpTab(n, cost);
	}

	private int frogJumpTab(int n, int[] cost) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			int second = Integer.MAX_VALUE;
			int first = dp[i - 1] + Math.abs(cost[i] - cost[i - 1]);
			if (i > 1) {
				second = dp[i - 2] + Math.abs(cost[i] - cost[i - 2]);
			}
			dp[i] = Math.min(first, second);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		FrogJump obj = new FrogJump();
		int[] arr = { 30, 10, 60, 10, 60, 50 };
		int result = obj.frogJump(arr);
		System.out.println(result);
	}
}
