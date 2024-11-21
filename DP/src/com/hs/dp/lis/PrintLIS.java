package com.hs.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
	public List<Integer> longestIncreasingSubsequence(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int[] parent = new int[n];
		Arrays.fill(parent, -1);

		int maxLen = 0;
		int lastIndex = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
					dp[i] = 1 + dp[j];
					parent[i] = j;
				}
			}

			if (dp[i] > maxLen) {
				maxLen = dp[i];
				lastIndex = i; // Track the index of the last element in the LIS
			}
		}

		List<Integer> lis = new ArrayList<>();
		int currentIndex = lastIndex;
		while (currentIndex != -1) {
			lis.add(nums[currentIndex]);
			currentIndex = parent[currentIndex];
		}
		Collections.reverse(lis);
		return lis;
	}

	public static void main(String[] args) {
		PrintLIS obj = new PrintLIS();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		List<Integer> result = obj.longestIncreasingSubsequence(nums);
		System.out.println(result);
	}
}