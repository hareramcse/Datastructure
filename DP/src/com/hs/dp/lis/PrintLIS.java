package com.hs.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLIS {
	public int longestIncreasingSubsequence(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int[] hash = new int[n];
		Arrays.fill(hash, 1);

		for (int i = 0; i < n; i++) {
			hash[i] = i;
			for (int prev_index = 0; prev_index < i; prev_index++) {
				if (nums[prev_index] < nums[i] && 1 + dp[prev_index] > dp[i]) {
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

		List<Integer> temp = new ArrayList<>();
		temp.add(nums[lastIndex]);

		while (hash[lastIndex] != lastIndex) {
			lastIndex = hash[lastIndex];
			temp.add(nums[lastIndex]);
		}

		// reverse the array

		System.out.print("The subsequence elements are ");

		for (int i = temp.size() - 1; i >= 0; i--) {
			System.out.print(temp.get(i) + " ");
		}
		System.out.println();

		return ans;
	}

	public static void main(String[] args) {
		PrintLIS obj = new PrintLIS();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int result = obj.longestIncreasingSubsequence(nums);
		System.out.println(result);
	}
}