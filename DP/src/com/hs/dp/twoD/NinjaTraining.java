package com.hs.dp.twoD;

import java.util.Arrays;

public class NinjaTraining {
	public int ninjaTraining(int n, int[][] points) {
		int dp[][] = new int[n][4];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solveMemo(n - 1, 3, points, dp);
	}

	private int solveMemo(int day, int last, int[][] points, int[][] dp) {
		if (day == 0) {
			int maxi = 0;
			for (int task = 0; task < 3; task++) {
				if (task != last)
					maxi = Math.max(maxi, points[0][task]);
			}
			return dp[day][last] = maxi;
		}

		int maxi = 0;
		for (int task = 0; task < 3; task++) {
			if (task != last) {
				int activity = points[day][task] + solveMemo(day - 1, task, points, dp);
				maxi = Math.max(maxi, activity);
			}
		}
		return dp[day][last] = maxi;
	}

	public int solveTab(int n, int[][] points) {
		int[][] dp = new int[n][4];
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

		for (int day = 1; day < n; day++) {
			for (int last = 0; last < 4; last++) {
				dp[day][last] = 0;
				for (int task = 0; task < 3; task++) {
					if (task != last) {
						int activity = points[day][task] + dp[day - 1][task];
						dp[day][last] = Math.max(dp[day][last], activity);
					}
				}
			}

		}

		return dp[n - 1][3];
	}

	public static void main(String[] args) {
		NinjaTraining obj = new NinjaTraining();
		int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
		int n = points.length;
		int result = obj.ninjaTraining(n, points);
		System.out.println(result);
		result = obj.solveTab(n, points);
		System.out.println(result);
	}
}