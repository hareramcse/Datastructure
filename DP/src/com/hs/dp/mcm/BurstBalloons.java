package com.hs.dp.mcm;

import java.util.Arrays;

public class BurstBalloons {
	private int maxCoins(int[] nums) {
		int n = nums.length;

		// Create a new array with boundaries (1 at both ends)
		int[] balloons = new int[n + 2];
		balloons[0] = 1;
		balloons[n + 1] = 1;

		// Copy the original nums into the new array
		for (int i = 0; i < n; i++) {
			balloons[i + 1] = nums[i];
		}

		int[][] dp = new int[n + 2][n + 2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(1, n, balloons, dp);
	}

	private static int solveMemo(int left, int right, int[] balloons, int[][] dp) {
		// Base case: no balloons to burst
		if (left > right) {
			return 0;
		}

		if (dp[left][right] != -1) {
			return dp[left][right];
		}

		int maxCoins = 0;
		for (int i = left; i <= right; i++) {
			int coins = balloons[left - 1] * balloons[i] * balloons[right + 1] + solveMemo(left, i - 1, balloons, dp)
					+ solveMemo(i + 1, right, balloons, dp);

			maxCoins = Math.max(maxCoins, coins);
		}

		dp[left][right] = maxCoins;
		return maxCoins;
	}

	public static void main(String[] args) {
		BurstBalloons obj = new BurstBalloons();
		int[] nums = { 3, 1, 5, 8 };
		int result = obj.maxCoins(nums);
		System.out.println(result);
	}
}