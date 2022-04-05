package com.hs.dp.knapsack.zeroone;

public class EqualSumSubset {
	private boolean equalSum(int[] arr, int sum) {
		if (sum % 2 != 0) {
			return false;
		} else {
			return subSetSum(arr, sum / 2);
		}
	}

	private boolean subSetSum(int[] arr, int sum) {
		boolean[][] dp = new boolean[arr.length + 1][sum + 1];

		for (int i = 0; i < sum + 1; i++)
			dp[0][i] = false;
		for (int i = 0; i < arr.length + 1; i++)
			dp[i][0] = true;

		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[arr.length][sum];
	}

	public static void main(String[] args) {
		EqualSumSubset kbu = new EqualSumSubset();
		int[] arr = new int[] { 5, 4, 6, 3 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}

		boolean found = kbu.equalSum(arr, sum);
		System.out.println(found);
	}
}