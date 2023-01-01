package com.hs.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int[] hash = new int[n];
		Arrays.fill(hash, 1);

		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			hash[i] = i;
			for (int prev_index = 0; prev_index < i; prev_index++) {
				if (nums[i] % nums[prev_index] == 0 && 1 + dp[prev_index] > dp[i]) {
					dp[i] = 1 + dp[prev_index];
					hash[i] = prev_index;
				}
			}
		}

		int ans = -1;
		int lastIndex = -1;

		for (int i = 0; i <= n - 1; i++) {
			if (dp[i] > ans) {
				ans = dp[i];
				lastIndex = i;
			}
		}

		List<Integer> tmp = new ArrayList<>();
		tmp.add(nums[lastIndex]);

		while (hash[lastIndex] != lastIndex) {
			lastIndex = hash[lastIndex];
			tmp.add(nums[lastIndex]);
		}
		return tmp;
	}

	public static void main(String[] args) {
		LargestDivisibleSubset obj = new LargestDivisibleSubset();
		int[] nums = { 1, 2, 4, 8 };
		List<Integer> result = obj.largestDivisibleSubset(nums);
		System.out.println(result);
	}
}