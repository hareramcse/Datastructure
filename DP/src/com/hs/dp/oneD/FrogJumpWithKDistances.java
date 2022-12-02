package com.hs.dp.oneD;

public class FrogJumpWithKDistances {
	public int frogJump(int n, int[] height, int k) {
		int[] dp = new int[n + 1];
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			int mmSteps = Integer.MAX_VALUE;

			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
					mmSteps = Math.min(jump, mmSteps);
				}
			}
			dp[i] = mmSteps;
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		FrogJumpWithKDistances obj = new FrogJumpWithKDistances();
		int[] height = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int k = 2;
		int result = obj.frogJump(n, height, k);
		System.out.println(result);
	}
}