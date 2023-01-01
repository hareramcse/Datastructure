package com.hs.dp.mcm;

import java.util.Arrays;

public class PalindromePartitioning2 {
	public int minCut(String str) {
		int n = str.length();
		int[] dp = new int[str.length()];
		Arrays.fill(dp, -1);
		return solveMemo(0, n, str, dp) - 1;
	}

	private int solveMemo(int i, int n, String str, int[] dp) {
		if (i == n)
			return 0;

		int minCost = Integer.MAX_VALUE;
		if (dp[i] != -1)
			return dp[i];

		for (int j = i; j < n; j++) {
			if (isPolindrome(str, i, j)) {
				int cost = 1 + solveMemo(j + 1, n, str, dp);
				minCost = Math.min(minCost, cost);
			}
		}
		return dp[i] = minCost;
	}

	private boolean isPolindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	private int solveTab(String str) {
		int[] dp = new int[str.length() + 1];
		Arrays.fill(dp, 0);

		int n = str.length();
		dp[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			int minCost = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				if (isPolindrome(str, i, j)) {
					int cost = 1 + dp[j + 1];
					minCost = Math.min(minCost, cost);
				}
			}
			dp[i] = minCost;
		}
		return dp[0] - 1;
	}

	public static void main(String[] args) {
		PalindromePartitioning2 obj = new PalindromePartitioning2();
		String str = "aab";
		int result = obj.minCut(str);
		System.out.println(result);
		result = obj.solveTab(str);
		System.out.println(result);
	}
}