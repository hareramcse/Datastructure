package com.hs.dp;

import java.util.Arrays;

public class Fibonacci {

	public int fibRecursion(int n) {
		if (n <= 1)
			return n;

		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}

	public int fibMemoization(int n, int[] dp) {
		if (n <= 1)
			return n;

		if (dp[n] != -1)
			return dp[n];

		dp[n] = fibMemoization(n - 1, dp) + fibMemoization(n - 2, dp);
		return dp[n];
	}

	public int fibTabular(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Fibonacci obj = new Fibonacci();
		int n = 5;
		int result = obj.fibRecursion(n);
		System.out.println("Fibonacci number through recursion " + result);

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		result = obj.fibMemoization(n, dp);
		System.out.println("Fibonacci number through memoization " + result);

		result = obj.fibTabular(n);
		System.out.println(result);
	}
}