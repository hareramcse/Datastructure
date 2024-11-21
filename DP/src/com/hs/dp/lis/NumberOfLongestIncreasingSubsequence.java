package com.hs.dp.lis;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int[] count = new int[n];

		Arrays.fill(dp, 1);
		Arrays.fill(count, 1);

		int max = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = Math.max(dp[i], 1 + dp[j]);
						count[i] = count[j];
					} else if (dp[j] + 1 == dp[i]) {
						count[i] += count[j];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == max)
				ans += count[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence obj = new NumberOfLongestIncreasingSubsequence();
		int[] nums = { 1, 3, 5, 4, 7 };
		int result = obj.findNumberOfLIS(nums);
		System.out.println(result);
	}
}