package com.hs.leetcode.medium;

public class OnesAndZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int zeros = 0, ones = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0')
					zeros++;
				else
					ones++;
			}

			for (int i = m; i >= zeros; i--) {
				for (int j = n; j >= ones; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		OnesAndZeroes obj = new OnesAndZeroes();
		String[] strs = { "10", "0001", "111001", "1", "0" };
		int m = 5;
		int n = 3;

		int result = obj.findMaxForm(strs, m, n);
		System.out.println(result);
	}
}