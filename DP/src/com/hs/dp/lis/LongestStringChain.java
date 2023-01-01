package com.hs.dp.lis;

import java.util.Arrays;

public class LongestStringChain {
	public int longestStrChain(String[] words) {
		int n = words.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		Arrays.sort(words);

		int maxi = 1;

		for (int i = 0; i <= n - 1; i++) {
			for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
				if (compare(words[i], words[prev_index]) && 1 + dp[prev_index] > dp[i]) {
					dp[i] = 1 + dp[prev_index];
				}
			}

			maxi = Math.max(maxi, dp[i]);
		}
		return maxi;
	}

	private boolean compare(String s1, String s2) {
		if (s1.length() != s2.length() + 1)
			return false;

		int first = 0;
		int second = 0;

		while (first < s1.length()) {
			if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
				first++;
				second++;
			} else
				first++;
		}
		if (first == s1.length() && second == s2.length())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		LongestStringChain obj = new LongestStringChain();
		int result = obj.longestStrChain(args);
		System.out.println(result);
	}
}