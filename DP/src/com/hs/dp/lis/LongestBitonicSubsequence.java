package com.hs.dp.lis;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	public int longestBitonicSequence(int[] nums) {
		int n = nums.length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];

		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		for (int ind = 0; ind < n; ind++) {
			for (int prev = 0; prev < ind; prev++) {
				if (nums[prev] < nums[ind]) {
					dp1[ind] = Math.max(dp1[ind], 1 + dp1[prev]);
				}
			}
		}

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prev = n - 1; prev > ind; prev--) {
				if (nums[prev] < nums[ind]) {
					dp2[ind] = Math.max(dp2[ind], 1 + dp2[prev]);
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