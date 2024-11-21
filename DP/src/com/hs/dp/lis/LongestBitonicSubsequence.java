package com.hs.dp.lis;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	public int longestBitonicSequence(int[] nums) {
		int n = nums.length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];

		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (nums[j] < nums[i]) {
					dp2[i] = Math.max(dp2[i], 1 + dp2[j]);
				}
			}
		}

		int ans = -1;

		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp1[i] + dp2[i] - 1);
		}

		return ans;
	}

	public static void main(String[] args) {
		LongestBitonicSubsequence obj = new LongestBitonicSubsequence();
		int[] nums = { 1, 2, 5, 3, 2 };
		int result = obj.longestBitonicSequence(nums);
		System.out.println(result);
	}
}